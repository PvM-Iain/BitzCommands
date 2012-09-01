package com.Iain.bitzcommands;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Iain.bitzcommands.commands.AFKCommand;
import com.Iain.bitzcommands.commands.BackCommand;
import com.Iain.bitzcommands.commands.BanCommand;
import com.Iain.bitzcommands.commands.BitzCommandsCommand;
import com.Iain.bitzcommands.commands.BroadcastCommand;
import com.Iain.bitzcommands.commands.BurnCommand;
import com.Iain.bitzcommands.commands.CreeperCommand;
import com.Iain.bitzcommands.commands.FreezeCommand;
import com.Iain.bitzcommands.commands.GamemodeCommand;
import com.Iain.bitzcommands.commands.GodCommand;
import com.Iain.bitzcommands.commands.HealCommand;
import com.Iain.bitzcommands.commands.HomeCommand;
import com.Iain.bitzcommands.commands.InventClearCommand;
import com.Iain.bitzcommands.commands.InvseeCommand;
import com.Iain.bitzcommands.commands.IpCommand;
import com.Iain.bitzcommands.commands.PingCommand;
import com.Iain.bitzcommands.commands.SpawnmobCommand;
import com.Iain.bitzcommands.commands.UngodCommand;
import com.Iain.bitzcommands.commands.VanishCommand;
import com.Iain.bitzcommands.events.blockListener;
import com.Iain.bitzcommands.events.playerListener;
import com.Iain.bitzcommands.settings.UserConfig;

public class BitzCommands extends JavaPlugin {
	public static BitzCommands plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
    public static String readableProfile(long time) {
        int i = 0;
        String[] units = new String[] { "ms", "s", "m", "hr", "day", "week", "mnth", "yr" };
        int[] metric = new int[] { 1000, 60, 60, 24, 7, 30, 12 };
        long current = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS);

        for(i = 0; current > metric[i]; i++)
            current /= metric[i];

        return current + " " + units[i] + ((current > 1 && i > 1) ? "s" : "");
    }
	
	public void onDisable() {		
		final long startTime = System.nanoTime();
        final long endTime;
        endTime = System.nanoTime();
        final long duration = endTime - startTime;
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[BitzCommands] " + pdfFile.getName() + " v" + pdfFile.getVersion() + " disabled (" + readableProfile(duration) + ")");
	}
	
	public void onEnable() {
		final long startTime = System.nanoTime();
        final long endTime;
        
		plugin = this;
		UserConfig.loadConfig();
		this.logger.info("[BitzCommands] Loading players.yml");
		getConfig();
		addOptionsForConfig();
		this.logger.info("[BitzCommands] Loading config.yml");
		getCommands();
		registerEvents();
		endTime = System.nanoTime();
		final long duration = endTime - startTime;
		
		PluginDescriptionFile pdfFile = this.getDescription();		
		this.logger.info("[BitzCommands] " + pdfFile.getName() + " v" + pdfFile.getVersion() +  " enabled (" + readableProfile(duration) + ")");
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new playerListener(), this);
		pm.registerEvents(new blockListener(), this);
		this.logger.info("[BitzCommands] Initializing Events.");
	}
	public void getCommands() {
		getCommand("afk", new AFKCommand());
		getCommand("back", new BackCommand());
		getCommand("ban", new BanCommand());
		getCommand("bitzcommands", new BitzCommandsCommand());
		getCommand("broadcast", new BroadcastCommand());
		getCommand("burn", new BurnCommand());
		getCommand("clear inventory", new InventClearCommand());
		getCommand("creeper", new CreeperCommand());
		getCommand("heal", new HealCommand());
		getCommand("freeze", new FreezeCommand());
		getCommand("gm", new GamemodeCommand());
		getCommand("god", new GodCommand());
		getCommand("god", new UngodCommand());
		getCommand("home", new HomeCommand());
		getCommand("invee", new InvseeCommand());
		getCommand("ip", new IpCommand());
		getCommand("item", new CommandItem());
		getCommand("kick", new CommandKick());
		getCommand("kill", new CommandKill());
		getCommand("location", new CommandLocation());
		getCommand("mute", new CommandMute());
		getCommand("nuke", new CommandNuke());
		getCommand("ping", new PingCommand());
		getCommand("jump", new CommandJump());
		getCommand("ram", new CommandRam());
		getCommand("reappear", new CommandReappear());
		getCommand("sethome", new CommandSethome());
		getCommand("setspawn", new CommandSetspawn());
		getCommand("setwarp", new CommandSetwarp());
		getCommand("smite", new CommandSmite());
		getCommand("spawn", new CommandSpawn());
		getCommand("spawnmob", new SpawnmobCommand());
		getCommand("storm", new CommandStorm());
		getCommand("suicide", new CommandSuicide());
		getCommand("sun", new CommandSun());
		getCommand("thunder", new CommandThunder());
		getCommand("time", new CommandTime());
		getCommand("tp", new CommandTp());
		getCommand("tp2p", new CommandTp2p());
		getCommand("tpall", new CommandTpall());
		getCommand("tphere", new CommandTphere());
		getCommand("unban", new CommandUnban());
		getCommand("unfreeze", new CommandUnfreeze());
		getCommand("unmute", new CommandUnmute());
		getCommand("warp", new CommandWarp());
		getCommand("vanish", new VanishCommand());
		this.logger.info("[BitzCommands] Initializing Commands.");
	}
	public void getCommand(String command, CommandExecutor commandexecutor) {
		Bukkit.getServer().getPluginCommand(command).setExecutor(commandexecutor);
		}
	  public void addOptionsForConfig() {
		  
		  	getConfig().addDefault("BitzCommands.Join message", true);
		  	getConfig().addDefault("BitzCommands.Ban Message", "The Ban Hammer has Spoken");
		  	getConfig().addDefault("BitzCommands.Broadcast bans", false);
		  	getConfig().addDefault("BitzCommands.Kick Message", "You've been kicked from the server");
		  	getConfig().addDefault("BitzCommands.Broadcast kicks", false);
		  	getConfig().addDefault("BitzCommands.Log all commands", false);
		  	getConfig().addDefault("BitzCommands.Player.No join message", false);
		  	getConfig().addDefault("BitzCommands.Player.No quit message", false);
		  	getConfig().addDefault("BitzCommands.Player.God.Effect when hit", false);
		    getConfig().options().copyDefaults(true);
		    saveConfig();
	  }
}