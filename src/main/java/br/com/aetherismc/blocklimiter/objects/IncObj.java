package br.com.aetherismc.blocklimiter.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.aetherismc.blocklimiter.Core;
import br.com.aetherismc.blocklimiter.api.Config;

public class IncObj {

	public static Config config = new Config(Core.getJava(), "config.yml");
	public static HashMap<String, BlockObj> blocks = new HashMap<String, BlockObj>();
	public static HashMap<String, HashMap<String, Integer>> playersLimit = new HashMap<String, HashMap<String, Integer>>();
	public static List<String> fakePlayers = new ArrayList<String>();
	
	public static void loadBlocks() {
		if ( IncObj.config.contains("Blocks") ) {
			for ( String itemID : IncObj.config.getConfig().getConfigurationSection("Blocks").getKeys(false) ) {
				String path = "Blocks." + itemID + ".";
				List<Integer> permissions = new ArrayList<Integer>();
				for ( String permissionREG : IncObj.config.getStringList(path + "permissions") ) permissions.add(Integer.valueOf(permissionREG));
				
				
				IncObj.blocks.put(itemID + ":" + IncObj.config.getString(path + "data"), 
					new BlockObj(
							IncObj.config.getString(path + "name"), 
							itemID, 
							IncObj.config.getString(path + "data"), 
							Integer.parseInt(IncObj.config.getString(path + "limit")),
							permissions
					)
				);
			}
		}
	}
}
