package ws.mahesh.cwc2015lite.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Mahesh on 1/29/2015.
 */
public class TimeZoneHelper {

    public static String getTime(String time) {
        try {
            SimpleDateFormat sourceFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
            sourceFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parsed = sourceFormat.parse(time);


            String tzone = TimeZone.getDefault().getID();
            TimeZone tz = TimeZone.getTimeZone(tzone);
            SimpleDateFormat destFormat;
            SimpleDateFormat destFormatTemp = new SimpleDateFormat("z");
            destFormatTemp.setTimeZone(tz);
            if (destFormatTemp.format(parsed).length() > 4)
                destFormat = new SimpleDateFormat("dd-MMM hh:mm aaa");
            else
                destFormat = new SimpleDateFormat("dd-MMM hh:mm aaa, z");
            destFormat.setTimeZone(tz);

            return destFormat.format(parsed);
        } catch (ParseException e) {
            return time;
        }
    }
}
