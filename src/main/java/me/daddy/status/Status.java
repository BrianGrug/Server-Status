package me.daddy.status;

import lombok.Getter;
import me.daddy.status.listeners.PreprocessListener;
import me.daddy.status.utils.Messages;
import org.bukkit.plugin.java.JavaPlugin;


@Getter
public class Status extends JavaPlugin {

    @Getter private static Status plugin;

    @Override
    public void onEnable(){

        plugin = this;

        this.saveDefaultConfig();

        new Messages().onStart(getServer().getServerName());

        this.getServer().getPluginManager().registerEvents(new PreprocessListener(), this);
    }

}
