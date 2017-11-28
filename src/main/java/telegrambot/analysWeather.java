package telegrambot;

import java.text.SimpleDateFormat;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import java.util.Date;

public class analysWeather implements Callable {
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		int date = eventContext.getMessage().getInvocationProperty("dateWeather");
		SimpleDateFormat 	formatterTime = new SimpleDateFormat("dd.M, EEE, HH");
		
		Date dateValue = new Date(Long.parseLong(Integer.toString(date)) * 1000);

		eventContext.getMessage().setInvocationProperty("dateWeather", formatterTime.format(dateValue));

		
		return eventContext.getMessage().getPayload();
	}
}
