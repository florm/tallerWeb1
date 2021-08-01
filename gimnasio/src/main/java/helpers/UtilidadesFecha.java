package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilidadesFecha {

    public static String parsearFecha(Date fecha) {
        SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
		return fechaFormat.format(fecha);
    }
}
