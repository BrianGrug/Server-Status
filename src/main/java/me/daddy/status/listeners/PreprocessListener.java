package me.daddy.status.listeners;

import lombok.Getter;
import me.daddy.status.Status;
import me.daddy.status.utils.JavaCommands;
import me.daddy.status.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PreprocessListener implements Listener {

    @EventHandler
    public void PlayerExecute(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();

        if (event.getMessage().startsWith("/restart") ||
                event.getMessage().startsWith("/stop")){

            event.setCancelled(true);

            String[] reason = event.getMessage().split(" ", 2);

            String server = Status.getPlugin().getServer().getServerName();

            new Messages().onStop(player, reason[1], server);

            restart();
        }

        if(event.getMessage().startsWith("/whitelist on")){

            event.setCancelled(true);

            player.sendMessage("Whitelist has been enabled.");

            String[] rea = event.getMessage().split(" ", 3);

            String server = Status.getPlugin().getServer().getServerName();

            StringBuilder reason = new StringBuilder();

            for(int i = 2; i < rea.length; i++) {
                reason.append(rea[i]).append(" ");
            }

            Bukkit.getServer().setWhitelist(true);

            new Messages().whitelistOn(player, reason.toString(), server);


        }
        if(event.getMessage().startsWith("/whitelist off")){

            event.setCancelled(true);

            player.sendMessage("Whitelist has been disabled.");

            String[] rea = event.getMessage().split(" ", 3);

            String server = Status.getPlugin().getServer().getServerName();

            StringBuilder reason = new StringBuilder();

            for(int i = 2; i < rea.length; i++) {
                reason.append(rea[i]).append(" ");
            }


            Bukkit.getServer().setWhitelist(false);

            new Messages().whitelistOff(player, reason.toString(), server);
        }
    }
    public void restart() {
        //Kinda WIP, didn't make this, just have an auto restart script if you're not on windows.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();
                List<String> command = new ArrayList<String>();
                command.add(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java.exe");
                for(int i = 0; i < args.size(); i++) {
                    command.add(args.get(i));
                }
                command.add("-jar");
                command.add(new File(Bukkit.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath());
                try {
                    new ProcessBuilder(command).start();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Bukkit.shutdown();
    }
}
