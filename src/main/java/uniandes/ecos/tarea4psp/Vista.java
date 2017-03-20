
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
        String vs="";
        String s="";
        String m="";
        String l="";
        String vl="";
        for (Map.Entry<String, Map> dato : mapaIntervalos.entrySet())
	{ 
          salida= salida + dato.getKey() + ": "+ System.lineSeparator();
          Map <String,Double> intervalos = dato.getValue();
	   for(Map.Entry<String, Double> intervalo: intervalos.entrySet())
           {
               if (intervalo.getKey().equals("VS"))
               {
                vs= "VS: " + intervalo.getValue().toString() + System.lineSeparator();
               }
               
               else if(intervalo.getKey().equals("S") )
               {
                s= "S: " + intervalo.getValue().toString() + System.lineSeparator();
               }
               
               else if(intervalo.getKey().equals("M") )
               {
                m= "M: " + intervalo.getValue().toString() + System.lineSeparator();
               }
               
                else if(intervalo.getKey().equals("L") )
               {
                l= "L: " + intervalo.getValue().toString() + System.lineSeparator();
               }
               
                 else if(intervalo.getKey().equals("VL") )
               {
                vl= "VL: " + intervalo.getValue().toString() + System.lineSeparator();
               }
              
               
           }
           salida=salida + vs +s+m+l+vl;
	}
        return salida;      
     }
}
