package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Iain.bitzcommands.BitzCommands;
import com.Iain.bitzcommands.settings.Permissions;

public class KickCommand implements CommandExecutor {
	
	String kickmessage = BitzCommands.plugin.getConfig().getString("BitzCommands.Kick Message");

	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("kick")) {
			        if (args.length == 1) {
				        if (sender.getServer().getPlayer(args[0]) != null) {
							Player targetplayer = sender.getServer().getPlayer(args[0]);
							targetplayer.kickPlayer(kickmessage);
					    	if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Broadcast kicks")) {
					    		Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "The CONSOLE just kicked " + args[0]);
					    	}
				          } else {
				        	  sender.sendMessage("ERROR: Player not found.");
				          }
			        } else if (args.length > 1 || args.length < 1) {
			        	sender.sendMessage("Incorrect syntax");
			        	sender.sendMessage("Usage: /" + commandLabel + " <player>");
			        }
			        }
				return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		  Player player = (Player) sender;
		    if (cmd.getName().equalsIgnoreCase("kick")) {
		    	if (!player.hasPermission("bitzcommands.kick")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 1) {
			        if (player.getServer().getPlayer(args[0]) != null) {
					Player targetplayer = player.getServer().getPlayer(args[0]);
					targetplayer.kickPlayer(kickmessage);
		        	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
		            player.sendMessage(ChatColor.GRAY + "Kicked " + targetplayer.getDisplayName());
			    	if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Broadcast kicks")) {
			    		Bukkit.getServer().broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " just kicked " + args[0]);
			    	}
			          } else {
				          player.sendMessage(ChatColor.RED + "ERROR: Player not found.");
			          }
		        } else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
		        }
		        }
			return true;
	  }
}
