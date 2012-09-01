package com.Iain.bitzcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Iain.bitzcommands.settings.Permissions;

public class CheckBannedCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("Checkbanned")) {
			        if (args.length == 1) {
			            	OfflinePlayer targetplayer = sender.getServer().getPlayer(args[0]);
			            	if (targetplayer == null) targetplayer = sender.getServer().getOfflinePlayer(args[0]);
					            if (targetplayer.isBanned()) {
					            	sender.sendMessage(targetplayer.getName() + " is banned!");
					            } else {
					            	sender.sendMessage(targetplayer.getName() + " isn't banned! :)");
					            }		            
				    	}
			        } else if (args.length > 1 || args.length < 1) {
			        	sender.sendMessage("Incorrect syntax!");
			        	sender.sendMessage("Usage: /" + commandLabel + " <player>");
			        }
				return true;
		  }
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("banned")) {
		    	if (!player.hasPermission("bitzcommands.banned")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 1) {
				            OfflinePlayer targetplayer = player.getServer().getPlayer(args[0]);
				            if (targetplayer == null) targetplayer = player.getServer().getOfflinePlayer(args[0]);
				            if (targetplayer.isBanned()) {
				            	player.sendMessage(ChatColor.GRAY + targetplayer.getName() + " is banned!");
				            } else {
				            	player.sendMessage(ChatColor.GRAY + targetplayer.getName() + " isn't banned!");
				            }		            
			    	}
		        } else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect Syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
		        }
			return true;
	  }
}
