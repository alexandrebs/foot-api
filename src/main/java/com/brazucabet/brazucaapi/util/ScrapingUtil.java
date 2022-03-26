package com.brazucabet.brazucaapi.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brazucabet.brazucaapi.dto.PartidaDTO;

public class ScrapingUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapingUtil.class);
	private static final String BASE_URL_GOOGLE = "https://www.google.com/search?q=";
	private static final String COMPLEMENTO_URL_GOOGLE = "&hl=pt-BR";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = BASE_URL_GOOGLE + "EGITO+X+SENEGAL" + COMPLEMENTO_URL_GOOGLE;
		
		ScrapingUtil scraping = new ScrapingUtil();
		
		scraping.obtemInformacoesPartida(url);
		
	}

	public PartidaDTO obtemInformacoesPartida(String URL) {
		
		PartidaDTO partidaDto = new PartidaDTO();
		
		try {
			Document document = Jsoup.connect(URL).get();
			
			String title = document.title();
			
			LOGGER.info("Titilo da pagina: {}", title);
			
		} catch (IOException e) {

			LOGGER.error("Erro ao conectar no GOOGLE com Jsoup -> {}", e.getMessage());
			
		}
		
		
		
		return partidaDto;
	}
	
}
