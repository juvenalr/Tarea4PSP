"Tarea4 PSP2" 
- 201710_CSOF5101_01 CONCEPTOS AVANZADOS DE INGENIERÍA SOFTWARE
- Programa 4 PSP2
- Juvenal Alberto Riaño Heredia cod 201710795
- 20/03/2017

- Instrucciones para ejecutar el programa

	para ejecutar el programa exiten dos opciones
	
	1. ejecute el programa desde la url https://radiant-headland-70430.herokuapp.com/Intervalos

  	2. Deplegar la solucion en una cuenta heroku

  	* en su computador abre el una consola de comandos y ubiquese en una carpeta de su predilecion
	
	* ejecute el comando >git clone https://github.com/juvenalr/Tarea4PSP.git
    
	* ubiquese dentro de la carpeta Tarea_PSP2-master > cd Tarea_PSP2-master
	
	* cere un app heroku > heroku create
	   Nota: debera contar con una cuenta Heroku y aber instalado Heroku CLI en si equipo (https://devcenter.heroku.com/articles/getting-started-with-java#set-up)
    * depligue los archivos en heroku > git push heroku master
	   Nota: si esta utilizando una cuenta libre de heroku recuerde que solo puede desplegar 5 aplicaciones si ya tiene todas ocupadas necesitara borrar una para realiar el despliegue
    * escale el dyno 	> heroku ps:scale web=1
	*  abra la aplicacion >heroku open
	    Nota: en este punto desplegara un error agrreue al la url de la plicacion  en el navegador el siguiente texto "/Intervalos" sin las comillas

 