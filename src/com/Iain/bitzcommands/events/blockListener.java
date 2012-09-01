package com.Iain.bitzcommands.events;

import com.Iain.bitzcommands.BitzCommands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockListener implements Listener {
	
	  @EventHandler(priority = EventPriority.HIGH)
	  public void onBlockPlace(BlockPlaceEvent event) {
	    if (event.isCancelled()) return;

	    Block block = event.getBlock();
	    Player player = event.getPlayer();

	    if ((block.getType() == Material.TNT) && (!player.hasPermission("BitzCommands.protection.placing.tnt")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.TnT"))) {
	      block.setType(Material.AIR);
	      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing TnT is blocked on this server.");
	    }
	    if ((block.getType() == Material.LAVA) && (!player.hasPermission("BitzCommands.protection.placing.lava")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Lava"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Lava is blocked on this server.");
		    }
	    if ((block.getType() == Material.LAVA_BUCKET) && (!player.hasPermission("BitzCommands.protection.placing.lavabucket")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Lava Buckets"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Lava buckets is blocked on this server.");
		    }
	    if ((block.getType() == Material.WATER) && (!player.hasPermission("BitzCommands.protection.placing.water")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Water"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Water is blocked on this server.");
		    }
	    if ((block.getType() == Material.WATER_BUCKET) && (!player.hasPermission("BitzCommands.protection.placing.waterbucket")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Water Buckets"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Water buckets is blocked on this server.");
		    }
	    if ((block.getType() == Material.BEDROCK) && (!player.hasPermission("BitzCommands.protection.placing.bedrock")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Bedrock"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Bedrock is blocked on this server.");
		    }
	    if ((block.getType() == Material.OBSIDIAN) && (!player.hasPermission("BitzCommands.protection.placing.obsidian")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Obsidian"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Obsidian is blocked on this server.");
		    }
	    if ((block.getType() == Material.FIRE) && (!player.hasPermission("BitzCommands.protection.placing.fire")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Fire"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Fire is blocked on this server.");
		    }
	    if ((block.getType() == Material.FLINT_AND_STEEL) && (!player.hasPermission("BitzCommands.protection.placing.flintandsteel")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Flint and Steel"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Flint and Steel is blocked on this server.");
		    }
	    if ((block.getType() == Material.ICE) && (!player.hasPermission("BitzCommands.protection.placing.ice")) && (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Protection.Prevent.Placing.Ice"))) {
		      block.setType(Material.AIR);
		      player.sendMessage("["+ ChatColor.BLUE + "BitzCommands" + ChatColor.WHITE + "] " + ChatColor.RED + "Placing Ice is blocked on this server.");
		    }
	  }
}
