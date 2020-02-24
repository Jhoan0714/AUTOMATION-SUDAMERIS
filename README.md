# AUTOMATION-SUDAMERIS

1. En la carpeta "QA AUTOMATION" se encuentra un documento .docx el cual contiene las respuestas correspondientes al documento "Prueba Tecnica Qa Automation".
2. El proyecto de automatizacion se encuentra en la carpeta "APPSUDAMERIS", para su ejecucion se debe tener en cuenta:

	•	Como patron de diseño se utilizo POM.  
	•	La app que se automatizo fue  "Copy of selendroid-test-app.apk".  
	•	A continuacion se visualiza la estructura del proyecto:
	<p align="center">
		<img width="343" height="508" src="https://github.com/Jhoan0714/AUTOMATION-SUDAMERIS/blob/master/APPSUDAMERIS/EstructuraProyecto.PNG">
	</p>
	•	Se tuvieron encuenta dos escenarios:
	
		- Registro de usuario: Objetos totalmente Nativos - "TestUserRegister".  
		- Web View - Form Page: Objetos hibridos - "TestWebView".  
		
	•	Cada escenario tiene un dataprovider configurado para tomar solo una linea de registro, son los archivos "UserRegister.csv" y "FormPage.csv", se encuentran en la ruta "APPSUDAMERIS\src\test\java\com\gnb\sudameris\data".  
	•	Se creo en la raiz del proyecto el archivo "testNG.xml" el cual contiene la informacion necesaria para le ejecucion de los test, incluso de forma paralela con las propiedades parallel="tests" thread-count="2".  
	•	Para lanzar la automatizacion se debe ejecutar la clase main, la cual llama automaticamente la suite del archivo "testNG.xml".  
	•	Se creara una carpeta en la raiz del proyecto con el nombre "Evidencias" la cual para efectos de prueba guarda la captura de pantalla por cada page de la app.  