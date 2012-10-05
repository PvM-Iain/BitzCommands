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

public class NukeCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used in-game!");
	           return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		  World world = player.getWorld();
		    if (cmd.getName().equalsIgnoreCase("nuke")) {
		    	if (!player.hasPermission("bitzcommands.nuke")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 0) {
		          Block targetblock = player.getTargetBlock(null, 50);
		          Location location = targetblock.getLocation();
		            world.createExplosion(location, 60);
		            log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel);
		            player.sendMessage(ChatColor.GRAY + "May death rain upon them...");
		        } else if (args.length > 0) {
		          player.sendMessage(ChatColor.GRAY + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
		          }
		        }
			return true;
			
		    }
	  }
		    
