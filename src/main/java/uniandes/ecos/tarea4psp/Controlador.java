/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.tarea4psp;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author usuario
 */
public class Controlador 
{
    /**Objeto de la clase AdministrarDatos que se encarga de los procesos y calculo*/ 
  public AdministrarDatos adminDatos;
  
  /**Objeto de la clase vista que mustra los menus en pantalla*/
  public Vista menus;
  /**
   * Constructo de la clase
   */
  public Controlador()
  {
	  adminDatos= new AdministrarDatos();
	  menus=new Vista();
  }
   public static void main(String[] args) 
   {
       Controlador control = new Controlador();

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        get("/Intervalos", (req, res) -> 
            {
                Map<String,Map> intervalos= control.adminDatos.calcularIntervalos();
                return control.menus.mostrarResultados(intervalos);
                
            }
        );
   }
}
