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
		String url = BASE_URL_GOOGLE + "fc+emmen+x+sc+telstar" + COMPLEMENTO_URL_GOOGLE;
									//argentina+x+venezuela
									//fc+emmen+x+sc+telstar
									//EGITO+X+SENEGAL
		ScrapingUtil scraping = new ScrapingUtil();
		
		scraping.obtemInformacoesPartida(url);
		
	}

	public PartidaDTO obtemInformacoesPartida(String URL) {
		
		PartidaDTO partidaDto = new PartidaDTO();
		
		try {
			Document document = Jsoup.connect(URL).get();
			
			String title = document.title();
			
			StatusPartida statusPartida =  obtemStatusPartida(document);
			
			String tempoPartida = obtemTempoPartida(document);
			
			LOGGER.info("Titilo da pagina: {}", title);
			LOGGER.info(statusPartida.toString());

			LOGGER.info("Tempo da Partida: {}",tempoPartida);
			
			
		} catch (IOException e) {

			LOGGER.error("Erro ao conectar no GOOGLE com Jsoup -> {}", e.getMessage());
			
		}
		
		
		
		return partidaDto;
	}
	
	
	public StatusPartida obtemStatusPartida(Document document) {
		// 1 - partida não iniciada
		// 2 - partida iniciada/ jogo rolando / intervalo
		// 3 - partida encerrada
		// 4 - partida penaltis
		StatusPartida statusPartida = StatusPartida.PARTIDA_NAO_INICIADA;
		
		boolean isTempoPartida = document.select("div[class=imso_mh__lv-m-stts-cont]").isEmpty();
		
		if(!isTempoPartida) {
			String tempoPartida = document.select("div[class=imso_mh__lv-m-stts-cont]").first().text();
			
			statusPartida = StatusPartida.PARTIDA_EM_ANDAMENTO;
			
			if(tempoPartida.contains("Pênaltis")) {
				statusPartida = StatusPartida.PARTIDA_PENALTIS;
			}
			
		}
		
		isTempoPartida = document.select("span[class=imso_mh__ft-mtch imso-medium-font imso_mh__ft-mtchc]").isEmpty();
		
		if(!isTempoPartida) {
			statusPartida = StatusPartida.PARTIDA_ENCERRADA;
			
		}
		
		
		return statusPartida;
	}
	
	
	
	public String obtemTempoPartida(Document document) {
		
		String tempoPartida = null;
		
		// Jogo rolando, penalidades ou intervalo
		Boolean isTempoPartida = document.select("div[class=imso_mh__lv-m-stts-cont]").isEmpty();
		                                                     
		if(!isTempoPartida) {
			try {
			tempoPartida = document.select("div[class=imso_mh__lv-m-stts-cont]").first().text();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		isTempoPartida = document.select("span[class=imso_mh__ft-mtch imso-medium-font imso_mh__ft-mtchc]").isEmpty();
		
		if(!isTempoPartida) {
		
			tempoPartida = document.select("span[class=imso_mh__ft-mtch imso-medium-font imso_mh__ft-mtchc]").first().text();
		}
		
		return validaTempoPartida(tempoPartida);
	}
	
	
	private String validaTempoPartida(String tempoPartida) {
		
		if(tempoPartida.contains("'")) {
			
			tempoPartida = tempoPartida.replace("' ", "min");
		}else if(tempoPartida.contains("+")) {
			tempoPartida = tempoPartida.replace(" ", "").concat("min");
		}
		
		return tempoPartida;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
