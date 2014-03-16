package us.axe2760.xenfororanker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URL;
import java.util.List;

public class XenforoRanker extends JavaPlugin {

    private String apiKey;
    private List<String> groups;
    private String websiteLink;

    public void onEnable(){
        this.saveDefaultConfig();

        websiteLink = this.getConfig().getString("websiteLink");
        apiKey = this.getConfig().getString("apiKey");
        groups = this.getConfig().getStringList("groups");

        if (apiKey == null){
            stopPlugin("You are missing the api key in the config!");
        }
        if (groups == null){
            stopPlugin("Could not find list of groups in the config!");
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        switch(args.length){
            case 0:
                sender.sendMessage("§4_____________________");
                sender.sendMessage("      §cXen Ranker     ");
                sender.sendMessage("§7§oType /xenrank help for help.");
            case 1:
                if (args[0].equalsIgnoreCase("help")){

                }
                else if (args[0].equalsIgnoreCase("groups")){
                    sender.sendMessage("§7Getting a list of groups...");
                    for (String group : groups){
                        sender.sendMessage("§a"+group);
                    }
                    sender.sendMessage("§c§oUse /xenrank rank <player> <group> to use!");
                }
                else if (args[0].equalsIgnoreCase("rank")){
                    sender.sendMessage("§aUse /xenrank rank <player> <group>");
                }
                else{
                    sender.sendMessage("I don't know what you are trying to do! Do /xenrank help for help.");
                }
            case 2:
                sender.sendMessage("I don't know what you are trying to do! Do /xenrank help for help.");

            case 3:
                if (args[0].equalsIgnoreCase("rank")){
                    if (!groups.contains(args[2])) return false;
                    sender.sendMessage("§cXenRank:");

                    //TODO: add code
                }
        }
        return true;
    }

    public void stopPlugin(String explanation){
        this.getLogger().severe(explanation);
        this.getLogger().severe("Disabling plugin...");
        this.getServer().getPluginManager().disablePlugin(this);
    }

}
