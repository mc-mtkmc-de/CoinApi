package de.tempoo50.eco.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import de.tempoo50.eco.mysql.MySQL;

public class CoinAPI implements Economy{

	@Override
	public EconomyResponse bankBalance(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse bankDeposit(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse bankHas(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse createBank(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse createBank(String arg0, OfflinePlayer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createPlayerAccount(String arg0) {
		return createPlayerAccount(Bukkit.getPlayer(arg0));
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0) {
		createPlayerAccount(arg0.getName());
		try
		{
			//PreparedStatement st = MySQL.con.prepareStatement("SELECT coins FROM coinTable WHERE UUID = ?");		
			if(true)//TODO: hasAccount? oder ähnliches benutzen
			{
				PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO coinTable(UUID, coins) VALUES (?,?);");		
				st.setString(1, arg0.getUniqueId().toString());
				st.setDouble(2, 1000);
				st.executeUpdate();
				return true;
			}			
		}catch(SQLException e) 
		{			
			e.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean createPlayerAccount(String arg0, String arg1) {
		return createPlayerAccount(Bukkit.getPlayer(arg0));
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0, String arg1) {
		return createPlayerAccount(arg0);
	}

	@Override
	public String currencyNamePlural() {
		return "MTK-Dollar";
	}

	@Override
	public String currencyNameSingular() {		
		return "MTK-Dollar";
	}

	@Override
	public EconomyResponse deleteBank(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String format(double arg0) {
		return String.valueOf(arg0);
	}

	@Override
	public int fractionalDigits() {
		return 0;
	}

	@Override
	public double getBalance(String arg0) {
		return getBalance(Bukkit.getPlayer(arg0));
	}

	@Override
	public double getBalance(OfflinePlayer arg0) {
		try
		{
			PreparedStatement st = MySQL.con.prepareStatement("SELECT coins FROM coinTable WHERE UUID = ?");
			st.setString(1, arg0.getUniqueId().toString());
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) 
			{				
				return rs.getInt("coins"); 			
			}
		}catch(SQLException e) 
		{			
			e.printStackTrace();
			
		}	
		return -1;
	}

	@Override
	public double getBalance(String arg0, String arg1) {
		return getBalance(Bukkit.getPlayer(arg0));
	}

	@Override
	public double getBalance(OfflinePlayer arg0, String arg1) {
		return getBalance(arg0);
	}

	@Override
	public List<String> getBanks() {
		return null;
	}

	@Override
	public String getName() {
		return "Economy Name?";
	}

	@Override
	public boolean has(String arg0, double arg1) {
		return has(Bukkit.getPlayer(arg0), arg1);
	}

	@Override
	public boolean has(OfflinePlayer arg0, double arg1) {		
		return getBalance(arg0) >= arg1;
	}

	@Override
	public boolean has(String arg0, String arg1, double arg2) {
		return has(Bukkit.getPlayer(arg0), arg2);
	}

	@Override
	public boolean has(OfflinePlayer arg0, String arg1, double arg2) {
		return has(arg0, arg2);
	}

	@Override
	public boolean hasAccount(String arg0) {
		return hasAccount(Bukkit.getPlayer(arg0));
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0) {
		try
		{
			PreparedStatement st = MySQL.con.prepareStatement("SELECT COUNT(*) FROM coinTable WHERE UUID = ?");
			st.setString(1, arg0.getUniqueId().toString());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) 
			{				
				int numberOfRows = rs.getInt(1);
				if(numberOfRows >= 1)
					return true;
			}
		}catch(SQLException e) 
		{			
			e.printStackTrace();			
		}	
		return false;
	}

	@Override
	public boolean hasAccount(String arg0, String arg1) {
		return hasAccount(Bukkit.getPlayer(arg0));
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0, String arg1) {
		return hasAccount(arg0);
	}

	@Override
	public boolean hasBankSupport() {
		return false;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, OfflinePlayer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, OfflinePlayer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
