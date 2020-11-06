package de.tempoo50.eco.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

import net.milkbowl.vault.economy.Economy;

public class VaultHook {
	private Eco plugin = Eco.getPlugin();
	private MyEconomy provider;
	
	public void hook() {
		provider = plugin.econ;
		Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
	}
	
	public void unhook() {
		Bukkit.getServicesManager().unregister(Economy.class, this.provider);
	}
}