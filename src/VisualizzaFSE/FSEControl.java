package VisualizzaFSE;

import ExternalComponentsInterface.DatabaseInterface;
import ExternalComponentsInterface.PDFInterface;
import Oggetti.PazienteEntity;

import java.time.LocalDateTime;

public class FSEControl {
	private String content;

	public FSEControl() {
	    content = DatabaseInterface.getInstance().ottieniStoricoVisite(PazienteEntity.getPaziente(), LocalDateTime.now());
	    new FSEDialog(content);
	}

	public void stampa() {
		PDFInterface.getInstance().stampa(PazienteEntity.getPaziente().toHtml()+content);
	}

}
