package br.com.aetherismc.blocklimiter.objects;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bukkit.entity.Player;

public class BlockObj {
	
	private final String name;
	private final String id;
	private final String data;
	private final int limit;
	private final List<Integer> permissions;
	
	public BlockObj(String name, String id, String data, int limit, List<Integer> permissions) {
		this.name = name;
		this.id = id;
		this.data = data;
		this.limit = limit;
		this.permissions = permissions;
		
		if (!this.permissions.isEmpty()) {
			Comparator<Integer> comparator = Collections.reverseOrder();
			this.permissions.sort(comparator);
		}
	}
	
	public String getDataID() {
		return this.id + ":" + this.data;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getData() {
		return this.data;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLimit() {
		return this.limit;
	}
	
	public int getLimit(Player p) {
		if (!this.permissions.isEmpty()) {
			for ( int quantity : this.permissions ) {
				if ( p.hasPermission("aetheris.blocklimiter." + this.id + "." + this.data + "." + quantity) ) {
					return quantity;
				}
			}
		}
		return this.limit;
	}
}
