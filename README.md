# mule-telegram

Analyser command set in processmessageFlow.xml

Main algoritm set in telegrambot.xml

Timetable set in timetableflow.xml

Weather set in weatherflow.xml


The whole algorithm works with the help of telegrams bot.

You need to specify in the settings of the Telegram token 

For example: appIdWeather=78d941793e6db388f558b7f789f68731



Weather:

Commands:
/Погода
/На неделю

You can find out the weather for today and for the week using this app.
To configure, you must set the zip in the configuration file.

For example, zip=141420

In order to find out the weather, you need to register the weathermap.org and get token.
Set property:

For example: appIdWeather=78d941793e6db388f558b7f789f68731



Train timetable:

Commands:
/Домой
/На работу

You can find out the schedule of trains to go home or work. 
You can find out how much time is left before departure.
To configure, you must set the home_id and work_id.

For example, 
stationShodnya=s9603486
stationOstankino=s9603505

In order to find out the timetable, you need to register the https://tech.yandex.ru/rasp/raspapi/ and get token.
Set property:

For example: token=452938758:AAEljOX7_eqjitaOLzyu234j9e8ZpxRpC8s

