/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uniandes.ecos.tarea4psp.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author usuario
 */
public class CalculoTest {
    
    public CalculoTest() {
    }
    
    
     @Test 
     public void testSumaln()
    {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double suma= cal.sumatorialn(datosX);
	 assertEquals(4.787491,suma,0.00001); 
    }
     
    @Test 
     public void testmedia()
    {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double media= cal.media(datosX);
	 assertEquals(0.95749834,media,0.00001); 
    }
     
    @Test 
     public void testVarianza()
    {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("6.0"));
	 datosX.addDato(Double.parseDouble("6.0"));
	 datosX.addDato(Double.parseDouble("8.3333"));
	 datosX.addDato(Double.parseDouble("10.3333"));
         datosX.addDato(Double.parseDouble("12.333"));
	 datosX.addDato(Double.parseDouble("16.4"));
         datosX.addDato(Double.parseDouble("20.5"));
         datosX.addDato(Double.parseDouble("21.75"));
         datosX.addDato(Double.parseDouble("22.25"));
         datosX.addDato(Double.parseDouble("23.0"));
         datosX.addDato(Double.parseDouble("28.3333"));
         datosX.addDato(Double.parseDouble("29.0"));
         datosX.addDato(Double.parseDouble("55.8"));
	 
	 Calculo cal = new Calculo();
	 double media= cal.media(datosX);
         double varianza=cal.varianza(datosX, media);
	 assertEquals(0.43625473,varianza,0.00001); 
    }
     
 @Test 
 public void testoperarConjuntoDatos()
 {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 ConjuntoDatos datosY= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("9"));
	 datosX.addDato(Double.parseDouble("16"));
	 datosX.addDato(Double.parseDouble("25"));
	 
	 datosY.addDato(Double.parseDouble("1"));
	 datosY.addDato(Double.parseDouble("2"));
	 datosY.addDato(Double.parseDouble("3"));
	 datosY.addDato(Double.parseDouble("4"));
	 datosY.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 ConjuntoDatos nuevoConjuntoDatos= cal.operarConjuntosDatos(datosX, datosY);
	 assertEquals(4.0,nuevoConjuntoDatos.getListaValoresNumero().get(3),0);
 
    }
 
    @Test 
    public void testgenerarIntervalos()
    {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("6.0"));
	 datosX.addDato(Double.parseDouble("6.0"));
	 datosX.addDato(Double.parseDouble("8.3333"));
	 datosX.addDato(Double.parseDouble("10.3333"));
         datosX.addDato(Double.parseDouble("12.333"));
	 datosX.addDato(Double.parseDouble("16.4"));
         datosX.addDato(Double.parseDouble("20.5"));
         datosX.addDato(Double.parseDouble("21.75"));
         datosX.addDato(Double.parseDouble("22.25"));
         datosX.addDato(Double.parseDouble("23.0"));
         datosX.addDato(Double.parseDouble("28.3333"));
         datosX.addDato(Double.parseDouble("29.0"));
         datosX.addDato(Double.parseDouble("55.8"));
	 
	 Calculo cal = new Calculo();
	 Map<String,Double> intervalo= cal.generarIntervalos(datosX);
         
	 assertEquals(4.39524449,intervalo.get("VS"),0.00001); 
         assertEquals(8.508102816,intervalo.get("S"),0.00001);
         assertEquals(16.46957607,intervalo.get("M"),0.00001);
         assertEquals(31.88101293,intervalo.get("L"),0.00001);
         assertEquals(61.71373088,intervalo.get("VL"),0.00001);
    }
 
    @Test 
    public void testcalculerIntervalo()
    {
	 AdministrarDatos admin= new AdministrarDatos();	 
	
	 Map<String,Map> intervalos= admin.calcularIntervalos();         
         Map<String,Double> intervalo =intervalos.get("LOCS/Metodo");
	 assertEquals(4.395269124,intervalo.get("VS"),0.00001); 
         assertEquals(8.508138249,intervalo.get("S"),0.00001);
         assertEquals(16.46962095,intervalo.get("M"),0.00001);
         assertEquals(31.88105393,intervalo.get("L"),0.00001);
         assertEquals(61.71372143,intervalo.get("VL"),0.00001);
    }
 
}
