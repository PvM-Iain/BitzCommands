package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("broadcast")) {
						StringBuilder x = new StringBuilder();
						int i;
						for(i = 0; i < args.length; i++) {
							x.append(args[i] + " ");
						}
						Bukkit.getServer().broadcastMessage(ChatColor.RED + "["+ ChatColor.BLUE + "Broadcast" + ChatColor.RED + "] " + ChatColor.WHITE + x.toString().trim());
			        } else if (args.length < 1) {
			        	sender.sendMessage("An error has occured!");
			        	sender.sendMessage("Usage: /" + commandLabel);
			        }
				return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		  Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("broadcast")) {
		    	if (!player.hasPermission("bitzcommands.broadcast")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
					StringBuilder x = new StringBuilder();
					int i;
					for(i = 0; i < args.length; i++) {
						x.append(args[i] + " ");
					}
					Bukkit.getServer().broadcastMessage("["+ ChatColor.BLUE + "Broadcast" + ChatColor.WHITE + "] " + ChatColor.WHITE + x.toString().trim());
					log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + x.toString().trim());
		        } else if (args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Error!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
		        }
			return true;
	  }
}

