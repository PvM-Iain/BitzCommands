package com.Iain.bitzcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;
import com.Iain.bitzcommands.settings.UserConfig;

public class GetPosCommand implements CommandExecutor {
	
	  private String getDirection(Player player) {
	    int degrees = (Math.round(player.getLocation().getYaw()) + 360) % 360;

	    if (degrees <= 112) {
	      if (degrees <= 22)
	        return "North";
	      if (68 <= degrees) {
	        return "East";
	      }
	      return "North-East";
	    }
	    if (248 <= degrees) {
	      if (degrees <= 292)
	        return "West";
	      if (338 <= degrees) {
	        return "North";
	      }
	      return "North-West";
	    }

	    if (degrees <= 157)
	      return "South-East";
	    if (203 <= degrees) {
	      return "South-West";
	    }
	    return "South";
	  }
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used in-game!");
	           return true;
		  }
		Player player = (Player)sender;
		World world = player.getWorld();
		double HomeX = User.getSavedHomeX(player);
		double HomeZ = User.getSavedHomeZ(player);
		    if (cmd.getName().equalsIgnoreCase("getpos")) {
		    	if (!player.hasPermission("bitzcommands.getpos")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 0) {
		        	Location location = player.getLocation();
					player.sendMessage(ChatColor.GRAY + "World: "  + world.getName());
					player.sendMessage(ChatColor.GRAY + "Coordiantes X:" + location.getBlockX() + " " + "Y:" + + location.getBlockY() + " " + "Z:" + location.getBlockZ());
					player.sendMessage(ChatColor.GRAY + "Compass: " + getDirection(player));	
					if(UserConfig.UserConfig.getBoolean(((Player) sender).getName() + ".home.enabled") == true) {
						String savedHomeWorld = User.getSavedHomeWorld(player);
						if(world.getName() == savedHomeWorld) {
						  double DistanceX = HomeX - location.getBlockX();
						  double DistanceZ = HomeZ - location.getBlockZ();
						  double Distance = DistanceX - DistanceZ;
						  player.sendMessage(ChatColor.GRAY + "Distance from home: " + Distance);
						} else {
							player.sendMessage(ChatColor.GRAY + "Distance from home: " + ChatColor.RED + "You're in the wrong world, you set your home in world, " + savedHomeWorld);
						}
					  } else {
						  player.sendMessage(ChatColor.GRAY + "Distance from home: " + ChatColor.RED + "You haven't set one...");
					  }

		        } else if (args.length > 0) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
		          }
		        }
			return true;
		    }
	  }
