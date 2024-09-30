package br.com.aetherismc.blocklimiter.api;

import br.com.aetherismc.blocklimiter.objects.IncObj;

public class LoadDefault {

    public static String Prefix;
	public static String Mundo_Aleatorio;
	
	public static String Somente_Seu_Terreno;
	public static String Mundo_Construcao;
	public static String Ja_Colocou;
	public static String Atingiu_Limite;
	
	public static void loadMensagens() {
        String path = "Mensagens.";
        Prefix				= IncObj.config.getString(path + "Prefix").replace('&', '§');
		Mundo_Aleatorio		= IncObj.config.getString(path + "Mundo_Aleatorio").replace('&', '§');
		
		Somente_Seu_Terreno	= IncObj.config.getString(path + "Somente_Seu_Terreno").replace('&', '§');
		Mundo_Construcao	= IncObj.config.getString(path + "Mundo_Construcao").replace('&', '§');
		Ja_Colocou			= IncObj.config.getString(path + "Ja_Colocou").replace('&', '§');
		Atingiu_Limite		= IncObj.config.getString(path + "Atingiu_Limite").replace('&', '§');
	}
}
