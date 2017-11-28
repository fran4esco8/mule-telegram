package telegrambot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.mule.api.MuleEventContext;

import org.mule.api.lifecycle.Callable;
import org.mule.common.query.dsql.grammar.DsqlParser.date_return;

import com.ibm.icu.util.TimeZone;


public class stationCompl implements Callable {
	@SuppressWarnings("deprecation")
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		String 				value 		= (String) eventContext.getMessage().getInvocationProperty("departureTime");
		SimpleDateFormat 	formatter 	= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+03:00");
		SimpleDateFormat 	formatterTime = new SimpleDateFormat("HH:mm");
        Date 				date 		= formatter.parse(value);
        
        
        java.util.TimeZone tz = java.util.TimeZone.getTimeZone("Europe/Moscow");
        Calendar calendar = Calendar.getInstance(tz);
        
        
        Date dateCurrent 	= calendar.getTime();
        Date dateCurrentEnd = calendar.getTime();
        dateCurrent.setTime(dateCurrent.getTime() + 3600 * 1000 * 3);
        dateCurrentEnd.setTime(dateCurrent.getTime() + 3600 * 1000); // + 1 час
       
        eventContext.getMessage().setInvocationProperty("needToAdd", (date.after(dateCurrent) &&  date.before(dateCurrentEnd)));
        
        String different = String.valueOf((int)(date.getTime() - dateCurrent.getTime())/60000);
        eventContext.getMessage().setInvocationProperty("resultTime", formatterTime.format(date) + ". Осталось " + different + " мин.");

        return eventContext.getMessage().getPayload();
	}

}

