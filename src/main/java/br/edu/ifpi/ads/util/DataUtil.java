package br.edu.ifpi.ads.util;

import java.util.Calendar;
import java.util.Date;

public class DataUtil {
	
	public static Calendar normalizeDataHora(String horario){
			
			System.out.println("ANTES:" + horario);

			//HTML5 do Chrome bota um T: 2014-07-09T10:00
			//Que Loucura meu!!!. Ave Java 8 or JodaTime
			if (horario.contains("T")){
				System.out.println("ANTES:" + horario);
				horario = horario.replace("T", "-");
				System.out.println("ANTES2:" + horario);
				String str[] = horario.split("-");
				horario = str[1]+"/"+str[2]+"/"+str[0] + " " + str[3] +":00";
				System.out.println("Depois " + horario);
			}else {
				System.out.println("ANTES X1:" + horario);
				String str[] = horario.split("/");
				horario = str[1]+"/"+str[0]+"/"+str[2] ;
				System.out.println("Depois X" + horario);
			}
			
			Date data_hora_D = new Date(horario);;
			Calendar data_hora_C = Calendar.getInstance();
			data_hora_C.setTime(data_hora_D);
			
		return data_hora_C;
		
	}

}
