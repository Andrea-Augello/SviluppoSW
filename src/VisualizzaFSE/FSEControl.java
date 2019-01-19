package VisualizzaFSE;

import ExternalComponentsInterface.DatabaseInterface;
import ExternalComponentsInterface.PDFInterface;
import Entity.PazienteEntity;

import java.time.LocalDateTime;

public class FSEControl {
	private String content;

	public FSEControl(boolean canPrint) {
	    content = DatabaseInterface.getInstance().ottieniStoricoVisite(PazienteEntity.getPaziente(), LocalDateTime.now());
	    new FSEDialog(this, content, canPrint);
	}

	public void stampa() {
		PDFInterface.getInstance().stampa(PazienteEntity.getPaziente().toFormatted()+"\n-----------------------------------------------------------------\n"+content);
	}

}
