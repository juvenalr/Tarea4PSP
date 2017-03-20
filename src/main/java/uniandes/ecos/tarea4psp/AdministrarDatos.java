/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.tarea4psp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * clase que administra los conjuntos de datos
 * @author juvenal
 * @version 2.0 20/03/2017
 */
public class AdministrarDatos 
{
    /**datos quemados LOCS */
    private String LOCS = "Loc,18,18,25,31,37,82,82,87,89,230,85,87,558";
    /**datos quemados METODOS*/
    private String METODOS = "Metodos,3,3,3,3,3,5,4,4,4,10,3,3,10";
    /**datos quemados PAGINAS*/
    private String PAGINAS= "Paginas,7,12,10,12,10,12,12,12,12,8,8,8,20,14,18,12";
    /**Lista de conjuntos de datos*/
    private ArrayList<ConjuntoDatos> ListaConjuntoDatos;
	
    /**objeto de tipo Calculo*/
    private Calculo calculos;
/**
 * constructor de la clase
 */	
    public AdministrarDatos()
    {
	ListaConjuntoDatos= new ArrayList<ConjuntoDatos>();
	calculos = new Calculo();
    }
    
    
    /**
     * Lee los valores desde un strin
     * @param linea cadena de texto con la información 
     */
	
    public void leerDatos(String linea)
    {
            
					
            ConjuntoDatos nuevoConjuntoDatos= new ConjuntoDatos();
							
            String[] valores= linea.split(",") ;
            for (int i= 0; i<valores.length;i++) 
            {
                if (i==0)
                {
                    nuevoConjuntoDatos.setTitulo(valores[i]);
		}				        
		else
		{
                    try {
			 Double pValor= Double.parseDouble(valores[i]);
			 nuevoConjuntoDatos.addDato(pValor);
			}
                    catch(NumberFormatException ex)
                    {
                            System.out.println("Conjunto de Datos " +nuevoConjuntoDatos.getTitulo()+ "Valor No Cargado: " + valores[i]);								
                    }
		}						
			
            }
            ListaConjuntoDatos.add(nuevoConjuntoDatos);					
            
    }
    /**
     * pobla el array list de datos
     */
    public void poblarDatos()
    {   this.ListaConjuntoDatos.clone();
	this.leerDatos(LOCS);
        this.leerDatos(METODOS);
        this.leerDatos(PAGINAS);  			
          
    }
    
    /**
     * devuleve el un conjunto de datos de la lista
     * 
     * @param indice indice del conjunto de datos
     */
    public ConjuntoDatos getConjunto(int indice)
    {
	
        return ListaConjuntoDatos.get(indice);
    }
    /**
     * genera la lista de intervalos para
     * @return lista de intervalos
     */
    public Map<String,Map> calcularIntervalos()
    {
     Map<String,Map> mapIntervalos = new HashMap<String,Map>();
     
     this.poblarDatos();
     ConjuntoDatos locMetodos=calculos.operarConjuntosDatos(getConjunto(0), getConjunto(1));
     
     mapIntervalos.put("LOCS/Metodo", calculos.generarIntervalos(locMetodos));
     mapIntervalos.put("Pag/Capitulo", calculos.generarIntervalos(getConjunto(2)));
     
     return mapIntervalos;
    }
    
}
