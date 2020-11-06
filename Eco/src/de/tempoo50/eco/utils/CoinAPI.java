package de.tempoo50.eco.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;
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
		try
		{	
			if(!hasAccount(arg0))
			{
				PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO coinTable(UUID, coins) VALUES (?,?);");		
				st.setString(1, arg0.getUniqueId().toString());
				st.setDouble(2, 1000);
				st.executeUpdate();
				return true;
			}else {
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
		return depositPlayer(Bukkit.getPlayer(arg0), arg1);
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, double arg1) {
		EconomyResponse result = new EconomyResponse(arg1, -1, ResponseType.FAILURE, "Es gab einen unbekannten Fehler.");
		try
		{
			if(!hasAccount(arg0)) {
				return new EconomyResponse(arg1, -1, ResponseType.FAILURE, "Der Spieler hat keinen Account");
			}
			double amount = getBalance(arg0) + arg1;
			PreparedStatement st = MySQL.con.prepareStatement("UPDATE coinTable SET coins = ? WHERE UUID = ?");
			st.setDouble(1, amount);
			st.setString(2, arg0.getUniqueId().toString());
			st.executeUpdate();
			result = new EconomyResponse(arg1, amount, ResponseType.SUCCESS, "");
		}catch(SQLException e) 
		{			
			e.printStackTrace();			
		}	
		return result;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		return depositPlayer(Bukkit.getPlayer(arg0), arg2);
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		return depositPlayer(arg0, arg2);
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
		return withdrawPlayer(Bukkit.getPlayer(arg0), arg1);
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, double arg1) {
		EconomyResponse result = new EconomyResponse(arg1, -1, ResponseType.FAILURE, "Es gab einen unbekannten Fehler.");
		try
		{
			if(!hasAccount(arg0)) {
				return new EconomyResponse(arg1, -1, ResponseType.FAILURE, "Der Spieler hat keinen Account");
			}
			if(!has(arg0, arg1)) {
				return new EconomyResponse(arg1, -1, ResponseType.FAILURE, "Der Spieler hat nicht genügend " + currencyNameSingular());
			}
			double amount = getBalance(arg0) - arg1;
			PreparedStatement st = MySQL.con.prepareStatement("UPDATE coinTable SET coins = ? WHERE UUID = ?");
			st.setDouble(1, amount);
			st.setString(2, arg0.getUniqueId().toString());
			st.executeUpdate();
			result = new EconomyResponse(arg1, amount, ResponseType.SUCCESS, "");
		}catch(SQLException e) 
		{			
			e.printStackTrace();			
		}	
		return result;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		return withdrawPlayer(Bukkit.getPlayer(arg0), arg2);
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		return withdrawPlayer(arg0, arg2);
	}
	
}
