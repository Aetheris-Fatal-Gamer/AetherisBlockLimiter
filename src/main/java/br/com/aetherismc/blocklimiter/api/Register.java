package br.com.aetherismc.blocklimiter.api;

import br.com.aetherismc.blocklimiter.Core;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Register {
	public static void setCommand(String comando, CommandExecutor classe, Core pl) {
		pl.getCommand(comando).setExecutor(classe);
	}
	
	public static void setEvents(Listener classe, Core pl) {
		Bukkit.getPluginManager().registerEvents(classe, pl);
	}
	
	public static void RegisterEvents(Core pl){
		// setEvents(new Eventos(), pl);
	}
	
	public static void RegisterCommands(Core pl){
		// setCommand("staffs", new CommandDefault(), pl);
	}
}
