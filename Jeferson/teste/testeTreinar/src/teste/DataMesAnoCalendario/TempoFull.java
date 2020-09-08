package teste.DataMesAnoCalendario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TempoFull {

    private static Date data = new Date();
    private static Calendar calendar = Calendar.getInstance();

    public static void main(String[] args) {
//        dataNow();
//        teste();
        calendario();
//        hora();
//        mes();
    }

    private static void mes(){
        Integer jan1 = Calendar.JANUARY+1;
        Integer fev1 = Calendar.FEBRUARY+1;
        Integer mar1 = Calendar.MARCH+1;

        System.out.println("Janeiro: " + jan1);
        System.out.println("Fevereiro: " + fev1);
        System.out.println("Marco: " + mar1);
    }

    private static void hora(){
        Integer hora1 = calendar.get(Calendar.HOUR);
        Integer hora2 = calendar.get(Calendar.HOUR_OF_DAY);
        Integer min = calendar.get(Calendar.MINUTE);
        Integer seg = calendar.get(Calendar.SECOND);
        System.out.println("Horario1: " + hora1);
        System.out.println("Horario2: " + hora2);
        System.out.println("Min: " + min);
        System.out.println("Seg: " + seg);
    }

    private static void calendario(){
        calendar.setTime(data);
        Integer dia1 = calendar.get(Calendar.DATE);
        Integer dia2 = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mes = calendar.get(Calendar.MONTH)+1; //Janeiro = 0 Dezembro = 11
        Integer ano = calendar.get(Calendar.YEAR);
        Integer doy = calendar.get(Calendar.DAY_OF_YEAR);

        System.out.println("DIA1: " + dia1);
        System.out.println("DIA2: " + dia2);
        System.out.println("MES: " + mes);
        System.out.println("ANO: " + ano);
        System.out.println("DIAS POR ANO: " + doy);
    }

    private static void teste(){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String hora = formatador.format(data);
        System.out.println(hora);
    }

    private static void dataNow(){
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yy");
        DateTimeFormatter formato4 = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter formato5 = DateTimeFormatter.ofPattern("MMM");
        DateTimeFormatter formato6 = DateTimeFormatter.ofPattern("yyyy");

        DateTimeFormatter horario = DateTimeFormatter.ofPattern("h:m:s");

        LocalDateTime dataNow = LocalDateTime.now();

        String data1 = formato1.format(dataNow);
        String data2 = formato2.format(dataNow);
        String data3 = formato3.format(dataNow);
        String data4 = formato4.format(dataNow);
        String data5 = formato5.format(dataNow);
        String data6 = formato6.format(dataNow);

        String hora = horario.format(dataNow);


        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        System.out.println("Dia: " + data4);
        System.out.println("Mes: " + data5);
        System.out.println("Ano: " + data6);

        System.out.println("Horario: " + hora);
    }

    private static String getDataDiferencaDias(Integer qtdDias){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, qtdDias);
        return getDataFormatada(calendar.getTime());
    }

    private static String getDataFormatada(Date data) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }

}
