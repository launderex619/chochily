package com.carcavaz.chochilyapp.constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public String ConvertInputStreamToString(InputStream stream){
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String ConvertLongToDate(Long date){
        String formated;
        Date fecha = new Date(date);
        formated = new SimpleDateFormat("h:mm a").format(fecha);
        return formated;
    }
}
