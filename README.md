# AUTOMATION-SUDAMERIS

1. En la carpeta "QA AUTOMATION" se encuentra un documento .docx el cual contiene las respuestas correspondientes al documento "Prueba Tecnica Qa Automation".
2. El proyecto de automatizacion se encuentra en la carpeta "APPSUDAMERIS", para su ejecucion se debe tener en cuenta:

	•	Como patron de diseño se utilizo POM, lenguaje de programacion Java, TestNG como framework para los test y Appium como herramienta de automatizacion.  
	•	La app que se automatizo fue  "Copy of selendroid-test-app.apk".  
	•	A continuacion se visualiza la estructura del proyecto:
	<p align="center">
		<img width="343" height="508" src="https://github.com/Jhoan0714/AUTOMATION-SUDAMERIS/blob/master/APPSUDAMERIS/EstructuraProyecto.PNG">
	</p>
	•	Se tuvieron encuenta dos escenarios:
	
		- Registro de usuario: Objetos totalmente Nativos - "TestUserRegister".  
		- Web View - Form Page: Objetos hibridos - "TestWebView".  
		
	•	Cada escenario tiene un dataprovider configurado para tomar solo una linea de registro, son los archivos "UserRegister.csv" y "FormPage.csv", se encuentran en la ruta "APPSUDAMERIS\src\test\java\com\gnb\sudameris\data".  
	•	Se creo en la raiz del proyecto el archivo "testNG.xml" el cual contiene la informacion necesaria para la ejecucion de los test, incluso de forma paralela con las propiedades parallel="tests" thread-count="2", se debe tener en cuenta dos instancias de appium con distintos puertos.  
	•	Para lanzar la automatizacion se debe ejecutar la clase main, la cual llama automaticamente la suite del archivo "testNG.xml".  
	•	Se creara una carpeta en la raiz del proyecto con el nombre "Evidencias" la cual para efectos de prueba guarda la captura de pantalla por cada page de la app.  
	
3. Se crear script de rendimiento en el cual se plantean dos escenarios para efecto de pruebas, ya que la API encontrada no soporta tanta carga:
 
 		- Prueba de carga, que alcanza 1000 UVC con un ramp-up de 1800 segs, lo cual agregara masomenos 1 UVC por seg, la prueba tendria una duracion de aprox 40 min, esta prueba se podria tomar como una linea base o exploratorio ya que no tenemos una cantidad de transacciones max o min establecidas.   
		- Prueba de escalabilidad, en el cual se configuran los mismos 1000 UVC como tope final, pero cada 60 segs se agregan 30 UVC, manteniendolos por 600 segs (aprox 10 min), se toma este tiempo ya que la API de ejemplo, es un registro de producto, por lo cual en un escenario real podria llevarse este tiempo como maximo en que una persona realiza esta solicitud. Finalmente cada 10 segs finalizan 5 UVC, la prueba tendria una duracion de aprox 1 hora con 20 min.  

<p align="center">
		<img width="441" height="720" src="https://github.com/Jhoan0714/AUTOMATION-SUDAMERIS/blob/master/BONUS%20PERFORMANCE/EstructuraScript.PNG">
	</p>
	
	•	Escogi JMeter, ya que es la herramienta con la cual he podido realizar algunos test de carga, por otra parte comparandolo con WAPT, se tiene documentacion a la mano y una comunidad que lo respalda, tambien plugins que le permite ser mas completo.  
	•	No se plantea carga de estress, ya que no contamos con un max o min de transacciones por segs esperadas. Tampoco se pueden evaluar performance counters ya que no tengo acceso por TCP/IP, SNMP, WMI o incluso ODBC, esto con el fin de obtener estadisticas del servidor de aplicaciones o base de datos.  
	•	Para la ejecucion del script, se deben agregar datos al archivo "Data Jmeter.csv" que se encuentra en la raiz del proyecto.  
	•	El script tiene configurado generar graficas de Hits por second, Response codes por second, Transactions por second y Active threads over time, a mi parecer son las que brindan mayor informacion sobre el test.
