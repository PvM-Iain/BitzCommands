package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Iain.bitzcommands.settings.Permissions;

public class SmiteCommand implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("smite")) {
			    	if (args.length == 1) {
			          if (sender.getServer().getPlayer(args[0]) != null) {
			            Player targetplayer = sender.getServer().getPlayer(args[0]);
			            Location location = targetplayer.getLocation();
			            targetplayer.getWorld().strikeLightning(location);
			            targetplayer.sendMessage(ChatColor.GRAY + "Thou has been smitten.");
			            sender.sendMessage("Smiting " + targetplayer.getDisplayName());
			          } else {
			        	  sender.sendMessage("ERROR: Player not found");
			          }
			        } else if (args.length > 1) {
			        	sender.sendMessage("Incorrect Syntax!");
				        sender.sendMessage("Usage: /" + commandLabel + " <player>");
			          }
			        }
				return true;
			    }
		  Logger log = Logger.getLogger("Minecraft");
		  Player player = (Player)sender;
		  World world = player.getWorld();
		    if (cmd.getName().equalsIgnoreCase("smite")) {
		    	if (!player.hasPermission("bitzcommands.smite")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 0) {
		          Block targetblock = player.getTargetBlock(null, 50);
		          Location location = targetblock.getLocation();
		          world.strikeLightning(location);
		          log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel);
		        } else if (args.length == 1) {
			    	if (!player.hasPermission("bitzcommands.smite.others")) {
						Permissions.noPermissionMessage((Player) player);
						return true;
			    }
		          if (player.getServer().getPlayer(args[0]) != null) {
		            Player targetplayer = player.getServer().getPlayer(args[0]);
		            Location location = targetplayer.getLocation();
		            world.strikeLightning(location);
		            targetplayer.sendMessage(ChatColor.GRAY + "Thou has been smitten.");
		            player.sendMessage(ChatColor.GRAY + "Smiting " + targetplayer.getDisplayName());
		            log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
		          } else {
			          player.sendMessage(ChatColor.RED + "Error: Player not found.");
		          }
		        } else if (args.length > 1) {
			          player.sendMessage(ChatColor.RED + "Incorrect Syntax!");
			          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " [player]");
		          }
		        }
			return true;
		    }
	  }