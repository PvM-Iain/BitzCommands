package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreeperCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used by in-game players!");
	           return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		  World world = player.getWorld();
		    if (cmd.getName().equalsIgnoreCase("creeper")) {
		    	if (!player.hasPermission("bitzcommands.creeper")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 0) {
		          Block targetblock = player.getTargetBlock(null, 50);
		          Location location = targetblock.getLocation();
		            world.createExplosion(location, 12);
		            log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel);
		            player.sendMessage(ChatColor.GRAY + "You revealed the creeper within yourself.");
		        } else if (args.length > 0) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
		          }
		        }
			return true;
			
		    }
	  }
		    
