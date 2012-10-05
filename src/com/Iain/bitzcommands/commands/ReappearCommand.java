package com.Iain.bitzcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;

public class ReappearCommand implements CommandExecutor {
	 
	public static void makePlayerAppear(Player player) {
		for(Player otherPlayers : Bukkit.getServer().getOnlinePlayers()) {
			otherPlayers.showPlayer(player);
		}
	}
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			  if (cmd.getName().equalsIgnoreCase("reappear")) {
			    	if (args.length == 1) {
				          if (sender.getServer().getPlayer(args[0]) != null) {
				            Player targetplayer = sender.getServer().getPlayer(args[0]);
				            makePlayerAppear((Player) targetplayer);
							targetplayer.sendMessage("You're now visible");
							sender.sendMessage("You've made " + targetplayer.getDisplayName() + " visible.");
							User.vanish.put(((Player) targetplayer).getName(), true);
				          } else {
				        	  sender.sendMessage("ERROR: Player not found.");
				          }
				        } else if (args.length > 1) {
				        	sender.sendMessage("Too many arguments!");
					        sender.sendMessage("Usage: /" + commandLabel + " <player>");
				          }
				        }
					return true;
				    }
		  Player player = (Player)sender;
		  if (cmd.getName().equalsIgnoreCase("reappear")) {
		    	if (!player.hasPermission("bitzcommands.invisible")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
        	if (args.length == 0) {
				makePlayerAppear((Player) sender);
				player.sendMessage(ChatColor.GRAY + "You're now visible.");
				User.vanish.remove(((Player) sender).getName());
	        } else if (args.length == 1) {
		    	if (!player.hasPermission("bitzcommands.invisible.others")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		          if (player.getServer().getPlayer(args[0]) != null) {
		            Player targetplayer = player.getServer().getPlayer(args[0]);
		            makePlayerAppear((Player) targetplayer);
					targetplayer.sendMessage(ChatColor.GRAY + "You're now visible.");
					player.sendMessage(ChatColor.GRAY + "You've made " + targetplayer.getDisplayName() + " visible.");
					User.vanish.remove(((Player) targetplayer).getName());
		          } else {
		        	  player.sendMessage(ChatColor.RED + "ERROR: Player not found.");
		          }
	        } else if (args.length > 2) {
		          player.sendMessage(ChatColor.RED + "Incorrect Syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + "[player]");
	        }
		    }
		return true;
	  }
}
