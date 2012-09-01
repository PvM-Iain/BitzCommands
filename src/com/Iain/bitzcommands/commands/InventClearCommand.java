package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventClearCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			  if (cmd.getName().equalsIgnoreCase("clear inventory")) {
			  if (args.length == 1) {
		          if (sender.getServer().getPlayer(args[0]) != null) {
		            Player targetplayer = sender.getServer().getPlayer(args[0]);
		            ((Player) targetplayer).getInventory().clear();
		            targetplayer.sendMessage(ChatColor.GRAY + "Inventory cleared.");
		            sender.sendMessage("Cleared " + targetplayer.getDisplayName() + "'s inventory!");
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
		  if (cmd.getName().equalsIgnoreCase("clear inventory")) {
		    	if (!player.hasPermission("bitzcommands.clear")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
			  if (args.length == 0) {
				((Player) sender).getInventory().clear();
				player.sendMessage(ChatColor.GRAY + "Inventory cleared.");
				log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel);
			  }
		  if (args.length == 1) {
		    	if (!player.hasPermission("bitzcommands.clear.others")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
	          if (player.getServer().getPlayer(args[0]) != null) {
	            Player targetplayer = player.getServer().getPlayer(args[0]);
	            ((Player) targetplayer).getInventory().clear();
	            targetplayer.sendMessage(ChatColor.GRAY + "Inventory cleared.");
	            player.sendMessage(ChatColor.GRAY + "Cleared " + targetplayer.getDisplayName() + "'s inventory!");
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
