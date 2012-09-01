package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.Material;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCommand implements CommandExecutor {

	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used by ingame players!");
	           return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("give")) {
		    	if (!player.hasPermission("bitzcommands.give")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		    	if (args.length == 2) {
		    	      try
		    	      {
		        String materialName = args[0].toUpperCase();
		        int amount = Integer.parseInt(args[1]);
		        ((Player)sender).getInventory().addItem(new ItemStack[] { new ItemStack(Material.getMaterial(materialName), amount) });
		    	player.sendMessage(ChatColor.GRAY + "Inventory buffed with " + amount + " " + materialName);
		    	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + materialName + " " + amount);
		    	} catch (Exception e) {
			    	player.sendMessage(ChatColor.RED + "Item not recognised!");
		    	}
		        } else if (args.length > 2 || args.length < 2) {
			          player.sendMessage(ChatColor.RED + "Incorrect Syntax!");
			          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <itemid> <amount>");
		        }
	  }
			return true;
	  }
}