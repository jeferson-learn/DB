package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    public static String getDataDiferencaDias(Integer qtdDias){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, qtdDias);
        return getDataFormatada(calendar.getTime());
    }

    public static String getDataFormatada(Date data) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }


}
