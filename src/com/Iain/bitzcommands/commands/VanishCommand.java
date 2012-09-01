package com.Iain.bitzcommands.commands;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
	 	
	public static void makePlayerVanish(Player player) {
		for(Player otherPlayers : Bukkit.getServer().getOnlinePlayers()) {
			otherPlayers.hidePlayer(player);
		}
	}
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			  if (cmd.getName().equalsIgnoreCase("vanish")) {
		    	if (args.length == 1) {
			          if (sender.getServer().getPlayer(args[0]) != null) {
			            Player targetplayer = sender.getServer().getPlayer(args[0]);
						makePlayerVanish((Player) targetplayer);
						targetplayer.sendMessage("You're now invisible to everyone!");
						sender.sendMessage("You've made " + targetplayer.getDisplayName() + " invisible.");
						User.vanish.put(((Player) targetplayer).getName(), true);
			          } else {
			        	  sender.sendMessage(ChatColor.RED + "ERROR: Player not found.");
			          }
			        } else if (args.length > 1) {
			        	sender.sendMessage("Incorrect syntax!");
				        sender.sendMessage("Usage: /" + commandLabel + " <player>");
			          }
			        }
				return true;
			    }
		  Player player = (Player)sender;
		  if (cmd.getName().equalsIgnoreCase("vanish")) {
		    	if (!player.hasPermission("bitzcommands.vanish")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
			  if (args.length == 0) {
				makePlayerVanish((Player) sender);
				player.sendMessage(ChatColor.GREEN + "You're now invisible to everyone!");
				User.vanish.put(((Player) sender).getName(), true);
	        } else if (args.length == 1) {
		    	if (!player.hasPermission("bitzcommands.vanish.others")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		          if (player.getServer().getPlayer(args[0]) != null) {
		            Player targetplayer = player.getServer().getPlayer(args[0]);
					makePlayerVanish((Player) targetplayer);
					targetplayer.sendMessage(ChatColor.GREEN + "You're now invisible to everyone!");
					player.sendMessage(ChatColor.GRAY + "You've made " + targetplayer.getDisplayName() + " invisible.");
					User.vanish.put(((Player) targetplayer).getName(), true);
		          } else {
		        	  player.sendMessage(ChatColor.RED + "ERROR: Player not found.");
		          }
	        } else if (args.length > 2) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + "[player]");
	        }
        	}
		return true;
	  }
}

