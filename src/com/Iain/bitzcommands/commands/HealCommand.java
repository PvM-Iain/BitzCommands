package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			  if (cmd.getName().equalsIgnoreCase("heal")) {
			  if (args.length == 1) {
		          if (sender.getServer().getPlayer(args[0]) != null) {
		            Player targetplayer = sender.getServer().getPlayer(args[0]);
		            targetplayer.setHealth(20);
		            targetplayer.setFoodLevel(20);
		            targetplayer.sendMessage(ChatColor.GRAY + "Fed.");
		            sender.sendMessage("Successfully healed " + targetplayer.getDisplayName());
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
		  if (cmd.getName().equalsIgnoreCase("heal")) {
		    	if (!player.hasPermission("bitzcommands.heal")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
			  if (args.length == 0) {
				  player.setHealth(20);
				  player.setFoodLevel(20);
					player.sendMessage(ChatColor.GRAY + "Healed");
					log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel);
				  }
		  if (args.length == 1) {
		    	if (!player.hasPermission("bitzcommands.heal.others")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
	          if (player.getServer().getPlayer(args[0]) != null) {
	            Player targetplayer = player.getServer().getPlayer(args[0]);
	            targetplayer.setHealth(20);
	            targetplayer.setFoodLevel(20);
	            targetplayer.sendMessage(ChatColor.GRAY + "Fed.");
	            player.sendMessage(ChatColor.GRAY + "Successfully healed " + targetplayer.getDisplayName());
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
		          

