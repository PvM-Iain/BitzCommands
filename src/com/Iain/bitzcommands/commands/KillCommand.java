package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Iain.bitzcommands.settings.Permissions;

public class KillCommand implements CommandExecutor {

	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("kill")) {
			    	if (args.length == 1) {
			    	if (sender.getServer().getPlayer(args[0]) != null) {
					Player targetplayer = sender.getServer().getPlayer(args[0]);
					((Player) targetplayer).setHealth(0);
					sender.sendMessage("You killed " + targetplayer.getDisplayName());
					} else {
						sender.sendMessage("ERROR: Player not found.");
			    	}
		        } else if (args.length > 1 || args.length < 1) {
		        	sender.sendMessage("Incorrect syntax!");
		        	sender.sendMessage("Usage: /" + commandLabel + " <player>");
		          }
			    }
				return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("kill")) {
		    	if (!player.hasPermission("bitzcommands.kill")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		    	if (args.length == 1) {
		    	if (player.getServer().getPlayer(args[0]) != null) {
				Player targetplayer = player.getServer().getPlayer(args[0]);
				((Player) targetplayer).setHealth(0);
		    	player.sendMessage(ChatColor.GRAY + "You killed " + targetplayer.getDisplayName());
		    	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
		    	} else {
		    		player.sendMessage(ChatColor.RED + "ERROR: Player not found");
		    	}
	        } else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
	          }
		    }
			return true;
	  }
}
