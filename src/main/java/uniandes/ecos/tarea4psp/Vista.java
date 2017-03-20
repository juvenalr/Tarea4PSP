
package uniandes.ecos.tarea4psp;

import java.util.Map;

/**
 * clase qque se encarga de generar de mostrar los menus en pantalla
 * @author juvenal
 * @version 2.0 20/03/2017
 */
public class Vista 
{
    /**
     * genera un string a partir de una lista de resulatados
     * @param mapaIntervalos lista de resultados
     * @return 
     */
     public String mostrarResultados(Map<String,Map> mapaIntervalos)
     {
        String salida="";
        for (Map.Entry<String, Map> dato : mapaIntervalos.entrySet())
	{ 
          salida= salida + dato.getKey() + ": ";
          Map <String,Double> intervalos = dato.getValue();
	   for(Map.Entry<String, Double> intervalo: intervalos.entrySet())
           {
               salida = salida + intervalo.getKey() +"(" + intervalo.getValue().toString() + ")  ";
               
           }
           salida=salida+"\r\n";
	}
        return salida;      
     }
}
