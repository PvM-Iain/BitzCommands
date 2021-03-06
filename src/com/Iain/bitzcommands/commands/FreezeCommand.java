package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used in-game!");
	           return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("freeze")) {
		    	if (!player.hasPermission("bitzcommands.freeze")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		    	if (args.length == 1) {
			          if (player.getServer().getPlayer(args[0]) != null) {
				            Player targetplayer = player.getServer().getPlayer(args[0]);
				User.freezePlayer(targetplayer);
				player.sendMessage(ChatColor.GRAY + "Froze " + targetplayer.getDisplayName());
				targetplayer.sendMessage(ChatColor.GRAY + "You've been frozen");
		    	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
			} else {
	    		player.sendMessage(ChatColor.RED + "ERROR: Player not found!");
				}
			} else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
			}
	}
			return true;
}
}
