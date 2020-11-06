package de.tempoo50.eco.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.tempoo50.eco.commands.EcoCommand;
import de.tempoo50.eco.commands.PayAllCommand;
import de.tempoo50.eco.commands.PayCommand;
import de.tempoo50.eco.commands.SetCommand;
import de.tempoo50.eco.mysql.MySQL;
import de.tempoo50.eco.utils.CoinAPI;

public class Eco extends JavaPlugin {
	
	private static Eco plugin;
	public CoinAPI econ = null;
	private VaultHook vaulthook;
	
	public void onEnable() {
		plugin = this;
		econ = new CoinAPI();
		vaulthook = new VaultHook();
		vaulthook.hook();
		
		MySQL.connect();
		MySQL.createTable();

		getCommand("eco").setExecutor(new EcoCommand());
		getCommand("pay").setExecutor(new PayCommand());
		getCommand("set").setExecutor(new SetCommand());
		getCommand("payall").setExecutor(new PayAllCommand());			
	}

	public void onDisable() {	
		vaulthook.unhook();
		MySQL.disconnect();	
	}
	
	public static Eco getPlugin() {
		return plugin;
	}
}
