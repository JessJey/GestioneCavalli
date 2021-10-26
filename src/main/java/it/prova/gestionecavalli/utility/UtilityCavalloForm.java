package it.prova.gestionecavalli.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecavalli.model.Cavallo;

//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityCavalloForm {

	public static Cavallo createCavalloFromParams(String nomeInputParam, String razzaInputParam,
			String prezzoInputStringParam, String dataDiNascitaStringParam) {

		Cavallo result = new Cavallo(nomeInputParam, razzaInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setDataDiNascita(parseDateArrivoFromString(dataDiNascitaStringParam));

		return result;
	}

	public static boolean validateCavalloBean(Cavallo cavalloToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(cavalloToBeValidated.getNome())
				|| StringUtils.isBlank(cavalloToBeValidated.getRazza())
				|| cavalloToBeValidated.getPrezzo() == null 
				|| cavalloToBeValidated.getPrezzo() < 1
				|| cavalloToBeValidated.getDataDiNascita() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataDiNascitaStringParam) {
		if (StringUtils.isBlank(dataDiNascitaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataDiNascitaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
