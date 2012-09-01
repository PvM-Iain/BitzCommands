package com.Iain.bitzcommands.commands;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IpCommand implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("ip")) {
			    	if (args.length == 1) {
			          if (sender.getServer().getPlayer(args[0]) != null) {
			            Player targetplayer = sender.getServer().getPlayer(args[0]);
			            sender.sendMessage(targetplayer.getDisplayName() + "'s IP Address is " + User.playerIP(targetplayer));
			          } else {
			        	  sender.sendMessage(ChatColor.RED + "ERROR: Player not found!");
			          }
			        } else if (args.length > 1) {
			        	sender.sendMessage("Too many arguments!");
				        sender.sendMessage("Usage: /" + commandLabel + " <player>");
			          }
			        }
				return true;
			    }
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("ip")) {
		    	if (!player.hasPermission("bitzcommands.ip")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		    	if (args.length == 1) {
			          if (player.getServer().getPlayer(args[0]) != null) {
			            Player targetplayer = player.getServer().getPlayer(args[0]);
			            player.sendMessage(ChatColor.GRAY + targetplayer.getDisplayName() + "'s IP Address is " + User.playerIP(targetplayer));
			          } else {
			        	  player.sendMessage(ChatColor.RED + "ERROR: Player not found!");
			          }
			        } else if (args.length > 1) {
			        	player.sendMessage(ChatColor.RED + "Incorrect syntax!");
			        	player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
			          }
			        }
				return true;
			    }
}