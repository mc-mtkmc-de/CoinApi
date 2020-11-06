package de.tempoo50.eco.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.tempoo50.eco.commands.EcoCommand;
import de.tempoo50.eco.commands.PayAllCommand;
import de.tempoo50.eco.commands.PayCommand;
import de.tempoo50.eco.commands.SetCommand;
import de.tempoo50.eco.mysql.MySQL;
import net.milkbowl.vault.economy.Economy;

public class Eco extends JavaPlugin {
	
	private Eco plugin;
	public static Economy econ = null;
	
	public void onEnable() {
		
		plugin = this;
		
		MySQL.connect();
		MySQL.createTable();

		getCommand("eco").setExecutor(new EcoCommand());
		getCommand("pay").setExecutor(new PayCommand());
		getCommand("set").setExecutor(new SetCommand());
		getCommand("payall").setExecutor(new PayAllCommand());
		
	}

	public void onDisable() {
		
		MySQL.disconnect();
		
	}
	
	public Eco getPlugin() {
		return plugin;
	}

}
