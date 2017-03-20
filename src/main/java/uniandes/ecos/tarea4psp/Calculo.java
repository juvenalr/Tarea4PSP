
package uniandes.ecos.tarea4psp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * realiza los diferntes calculos aritmeticos
 * @author juvenal
 * @version 2.0 20/03/2017
 */
public class Calculo
{
    /**
     * calcula la suma de los valores de los logaritmos naturales de un conjunto de datos
     * @param datos conjunto de datos
     * @return suma de los valores del conjuto de datos
    */
    public double sumatorialn(ConjuntoDatos datos)
    {
        double suma=0;
        ArrayList<Double> valores= datos.getListaValoresNumero();
        for(double valor : valores)
        {
            suma = suma + Math.log(valor);
        }
        return suma;
    }
    /**
     * calcula la media de un conjunto de datos
     * @param datos conjunto de datos
     * @return media de los valores del conjuto de datos
     */
    public double media(ConjuntoDatos datos)
    {
	double med=0;		
	double numeroDatos=datos.getNumeroElementos();

	if (numeroDatos >0)
	{
		med= sumatorialn(datos)/numeroDatos;
	}
		
		return med;
    }
           
    
    /**
     * calcula la varianza de un conjunto de datos
     * @param datos conjunto de datos
     * @param media media del conjunto de datos
     * @return media de los valores del conjuto de datos
     */
      
    
     public double varianza(ConjuntoDatos datos, double media)
    {
	double varianza=0;		
	double numeroDatos=datos.getNumeroElementos();
        double suma =0;
        ArrayList<Double> valores= datos.getListaValoresNumero();
        for(double valor : valores)
        {
            suma = suma + Math.pow(Math.log(valor)-media,2);
        } 
        
	if (numeroDatos >1)
	{
		varianza= suma/(numeroDatos-1);
	}
		
	return varianza;
    }
    
    /**
     * Genera un nuevo conjunto de datos a partir de la diviion de los valors del conjunto A con el conjunto B
     * @param conjuntoA conjunto de datos A
     * @param conjuntoB conjunto de Datos B
     * @return nuevo conjunto de datos
     */
    public ConjuntoDatos operarConjuntosDatos(ConjuntoDatos conjuntoA, ConjuntoDatos conjuntoB)
    {
        ConjuntoDatos nuevoConjuntoDatos= new ConjuntoDatos();
        ArrayList<Double> valoresA= conjuntoA.getListaValoresNumero();
        ArrayList<Double> valoresB= conjuntoB.getListaValoresNumero();
        nuevoConjuntoDatos.setTitulo("Loc/metodo");
        for(int i =0;i<conjuntoA.getNumeroElementos();i++ )
        {
            nuevoConjuntoDatos.addDato(valoresA.get(i)/valoresB.get(i));
         
        }
        
        return nuevoConjuntoDatos;
    
    }
    /**
     * retorna la lista de indeces con sus repectivos valores
     * @param datos cojunto de datos
     * @return lista de indices
     */
    public Map<String,Double> generarIntervalos(ConjuntoDatos datos)
    {
        Map<String,Double> parametros= new HashMap<String,Double>();
        double dStn=0;
        double media=0;
        double lnVS=0;
        double lnS=0;
        double lnM=0;
        double lnL=0;
        double lnVL=0;        
        double pVS=0;
        double pS=0;
        double pM=0;
        double pL=0;
        double pVL=0;
        
        media= this.media(datos);
        dStn= Math.sqrt( this.varianza(datos, media));
        
        lnVS= media-2*dStn;
        lnS=media-dStn;
        lnM=media;
        lnL=media+dStn;
        lnVL=media+2*dStn;
        
        pVS=Math.exp(lnVS);
        pS=Math.exp(lnS);
        pM=Math.exp(lnM);
        pL=Math.exp(lnL);
        pVL=Math.exp(lnVL);
        
        parametros.put("VS", pVS);
        parametros.put("S", pS);        
        parametros.put("M", pM);
        parametros.put("L", pL);
        parametros.put("VL", pVL);
        return parametros;
    }
    
}
    
    
    
