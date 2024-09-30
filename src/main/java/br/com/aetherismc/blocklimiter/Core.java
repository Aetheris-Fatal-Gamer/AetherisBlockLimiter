package br.com.aetherismc.blocklimiter;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.aetherismc.blocklimiter.api.Register;
import br.com.aetherismc.blocklimiter.objects.DataObj;
import br.com.aetherismc.blocklimiter.objects.IncObj;

public class Core extends JavaPlugin {

	private static Core core;
	private static JavaPlugin java;
	public static Plugin pl;
	
	
	public Core() {
		core = this;
	}
	
	public static Core getCore() {
		return core;
	}
	
	public void onEnable() {
		java = this;
		pl = this;
		
		if (!(new File(this.getDataFolder(), "config.yml")).exists()) {
			IncObj.config.saveDefaultConfig();
        }
		
		IncObj.fakePlayers = IncObj.config.getStringList("CancelFakePlayers");
		IncObj.playersLimit = DataObj.loadFlatData("limite.obj");
		
		Register.RegisterCommands(this);
		Register.RegisterEvents(this);
		
		Bukkit.getConsoleSender().sendMessage("\n§3====== §bAetherisBlockLimiter §3======" +
											  "\n§3Status: §bIniciado." + 
											  "\n§3Servidor: §bAetherisMC" +
											  "\n§3Autor: §bJoão Veiga" +
											  "\n§3====== §bAetherisBlockLimiter §3======");
	}
	
	public void onDisable() {
		DataObj.saveFlatData(IncObj.playersLimit, "limite.obj");
		Bukkit.getConsoleSender().sendMessage("\n§4====== §cAetherisBlockLimiter §4======" +
											  "\n§4Status: §cDesligado." + 
											  "\n§4Servidor: §cAetherisMC" +
											  "\n§4Autor: §cJoão Veiga" +
											  "\n§4====== §cAetherisBlockLimiter §4======");
	}
	
	public static JavaPlugin getJava() {
		return java;
	}
	
	public static Plugin getPlugin() {
		return pl;
	}
}