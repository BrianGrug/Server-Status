package me.daddy.status.utils;

import lombok.Getter;
import me.daddy.status.Status;
import org.bukkit.entity.Player;

import java.awt.*;
import java.io.IOException;
import java.util.Date;

@Getter
public class Messages {

    public void onStart(String server){

        Date date=java.util.Calendar.getInstance().getTime();


        try {
            DiscordWebhook webhook = new DiscordWebhook(Status.getPlugin().getConfig().getString("WEBHOOK.URL"));
            webhook.setContent("Server status:");
            webhook.setAvatarUrl(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"));
            webhook.setUsername("Status");
            webhook.setTts(false);
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setTitle("Status Change")
                    .setDescription("The server status has changed!")
                    .setColor(Color.GREEN)
                    .addField("Server: ", server, true)
                    .addField("Changed to:", "Online", true)
                    .addField("Date:", date.toString(), true)
                    .setThumbnail(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"))
                    .setAuthor("Server status", null, Status.getPlugin().getConfig().getString("WEBHOOK.LOGO")));
            webhook.execute(); //Handle exception
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onStop(Player player, String reason, String server){

        Date date=java.util.Calendar.getInstance().getTime();

        try {
            DiscordWebhook webhook = new DiscordWebhook(Status.getPlugin().getConfig().getString("WEBHOOK.URL"));
            webhook.setContent("Server status:");
            webhook.setAvatarUrl(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"));
            webhook.setUsername("Status");
            webhook.setTts(false);
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setTitle("Status Change")
                    .setDescription("A server status has changed!")
                    .setColor(Color.RED)
                    .addField("Server: ", server, true)
                    .addField("Changed to:", "Offline", true)
                    .addField("Reason", reason, true)
                    .addField("User", player.getName() + " has done this operation!", true)
                    .addField("Date:", date.toString(), true)
                    .setThumbnail(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"))
                    .setAuthor("Server status", null, Status.getPlugin().getConfig().getString("WEBHOOK.LOGO")));
            webhook.execute(); //Handle exception
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void whitelistOn(Player player, String reason, String server) {

        Date date = java.util.Calendar.getInstance().getTime();

        try {
            DiscordWebhook webhook = new DiscordWebhook(Status.getPlugin().getConfig().getString("WEBHOOK.URL"));
            webhook.setContent("Server status:");
            webhook.setAvatarUrl(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"));
            webhook.setUsername("Status");
            webhook.setTts(false);
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setTitle("Status Change")
                    .setDescription("A server status has changed!")
                    .setColor(Color.WHITE)
                    .addField("Server: ", server, true)
                    .addField("Changed to:", "Whitelisted", true)
                    .addField("Reason", reason, true)
                    .addField("User", player.getName() + " has done this operation!", true)
                    .addField("Date:", date.toString(), true)
                    .setThumbnail(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"))
                    .setAuthor("Server status", null, Status.getPlugin().getConfig().getString("WEBHOOK.LOGO")));
            webhook.execute(); //Handle exception
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void whitelistOff(Player player, String reason, String server) {

        Date date = java.util.Calendar.getInstance().getTime();

        try {
            DiscordWebhook webhook = new DiscordWebhook(Status.getPlugin().getConfig().getString("WEBHOOK.URL"));
            webhook.setContent("Server status:");
            webhook.setAvatarUrl(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"));
            webhook.setUsername("Status");
            webhook.setTts(false);
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setTitle("Status Change")
                    .setDescription("A server status has changed!")
                    .setColor(Color.WHITE)
                    .addField("Server: ", server, true)
                    .addField("Changed to:", "Non-Whitelisted", true)
                    .addField("Reason", reason, true)
                    .addField("User", player.getName() + " has done this operation!", true)
                    .addField("Date:", date.toString(), true)
                    .setThumbnail(Status.getPlugin().getConfig().getString("WEBHOOK.LOGO"))
                    .setAuthor("Server status", null, Status.getPlugin().getConfig().getString("WEBHOOK.LOGO")));
            webhook.execute(); //Handle exception
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
