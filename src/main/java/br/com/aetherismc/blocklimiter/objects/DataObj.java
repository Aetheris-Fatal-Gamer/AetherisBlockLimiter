package br.com.aetherismc.blocklimiter.objects;

import br.com.aetherismc.blocklimiter.Core;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class DataObj {

	public static <T> void saveFlatData(T obj, String fileName) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(Core.getJava().getDataFolder() + File.separator + fileName)));
			output.writeObject(obj);
			output.flush();
			Core.getJava().getLogger().info("O arquivo de limites " + fileName + " foi salvo.");
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T loadFlatData(String fileName) {
		Object obj = null;
		try {
			if ( checkFile(fileName) ) {
				Core.getJava().getLogger().info("O arquivo de limite " + fileName + " foi carregado.");
				ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(Core.getJava().getDataFolder() + File.separator + fileName)));
				Object result = input.readObject();
				input.close();
				obj = result;
			} else {
				Core.getJava().getLogger().info("O arquivo de limite " + fileName + " foi carregado.");
                obj = new HashMap<String, HashMap<String, Integer>>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}
	
	public static boolean checkFile(String fileName) {
		File file = new File(Core.getJava().getDataFolder() + File.separator + fileName);
		if (file.exists()) {
			return true;
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
}
