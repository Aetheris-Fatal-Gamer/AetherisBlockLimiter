package br.com.aetherismc.blocklimiter.players;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import br.com.aetherismc.blocklimiter.objects.IncObj;

public class PlayerListener implements Listener {
	
	@EventHandler(
		priority = EventPriority.LOWEST,
		ignoreCancelled = true
	)
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		String blockID = this.asBlock(e.getBlock());
		if ( blockID == null ) {
			return;
		}
		
		if ( this.onFake(p.getName()) ) {
			e.setCancelled(true);
			return;
		}

    }
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
	}
	
	@EventHandler
	public void onExplosion(BlockExplodeEvent e) {
		
	}
	
	private boolean onFake(String name) {
		return IncObj.fakePlayers.contains(name);
	}
	
	@SuppressWarnings("deprecation")
	private String asBlock(Block block) {
		int blockID = block.getType().getId();
		
		if ( IncObj.blocks.containsKey(blockID + ":*") ) {
			return blockID + ":*";
		} else if ( IncObj.blocks.containsKey(blockID + ":" + block.getData()) ) {
			return blockID + ":" + block.getData();
		}
		return null;
	}
}
