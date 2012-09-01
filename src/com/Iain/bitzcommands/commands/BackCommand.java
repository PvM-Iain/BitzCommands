package com.Iain.bitzcommands.commands;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;
import com.Iain.bitzcommands.settings.UserConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used by in-game players.");
	           return true;
		  }
		  Player player = (Player)sender;
		  if (cmd.getName().equalsIgnoreCase("back")) {
				if (!player.hasPermission("bitzcommands.back")) {
					Permissions.noPermissionMessage((Player) player);
					return true;
		    }
        	if (args.length == 0) {
    			  if(UserConfig.UserConfig.getBoolean(((Player) sender).getName() + ".back.enabled") == true) {
    				  ((Player) sender).teleport(User.teleportBack((Player) sender));
	            player.sendMessage(ChatColor.GRAY + "You have been taken back to your exisitng location.");
	          } else {
		          player.sendMessage(ChatColor.RED + "ERROR: Location not found.");
	          }
	        } else if (args.length > 0) {
		          player.sendMessage(ChatColor.RED + "Incorrect Syntax");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
	          }
		  }
		return true;
	    }
	}