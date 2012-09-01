package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BurnCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			  if (cmd.getName().equalsIgnoreCase("burn")) {
			  if (args.length == 1) {
		          if (sender.getServer().getPlayer(args[0]) != null) {
		            Player targetplayer = sender.getServer().getPlayer(args[0]);
		            targetplayer.setFireTicks(10000);
		            targetplayer.sendMessage(ChatColor.GRAY + "You've been set on fire.");
		            sender.sendMessage("Burnt " + targetplayer.getDisplayName());
		          } else {
		        	  sender.sendMessage(ChatColor.RED + "ERROR: Player not found.");
		          }
		        } else if (args.length > 1) {
		        	sender.sendMessage("Incorrect syntax!");
		        	sender.sendMessage("Usage: /" + commandLabel + " [player]");
		          }
		    }
			return true;
		}
		  Logger log = Logger.getLogger("Minecraft");
		  Player player = (Player)sender;
		  if (cmd.getName().equalsIgnoreCase("burn")) {
		    	if (!player.hasPermission("bitzcommands.burn")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
			  if (args.length == 0) {
				player.setFireTicks(10000);
				player.sendMessage(ChatColor.GRAY + "You set yourself on fire!");
				log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel);
			  }
		  if (args.length == 1) {
		    	if (!player.hasPermission("bitzcommands.burn.others")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
	          if (player.getServer().getPlayer(args[0]) != null) {
	            Player targetplayer = player.getServer().getPlayer(args[0]);
	            targetplayer.setFireTicks(10000);
	            targetplayer.sendMessage(ChatColor.GRAY + player.getDisplayName() + " has set you on fire!");
	            player.sendMessage(ChatColor.GRAY + "Burnt " + targetplayer.getDisplayName());
	            log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
	          } else {
		          player.sendMessage(ChatColor.RED + "ERROR: Player not found.");
	          }
	        } else if (args.length > 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " [player]");
	          }
	    }
		return true;
	}
}
