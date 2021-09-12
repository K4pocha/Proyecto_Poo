/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activitiescalendar;

import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author k4po
 */
public class JavaCalendarAplication {
    public static void main(String[] args) {
        int menu, i;
        Scanner reader = new Scanner (System.in);
        Map<String,Date> dateMap = new HashMap();
        ArrayList<Activity> list = new ArrayList();
        Date newDate = new Date();
     
        
        do {
            System.out.println("--------------------------------");
            System.out.println ("MENÚ:");
            System.out.println ("1. Agregar evento");
            System.out.println ("2. Buscar evento por nombre");
            System.out.println ("3. Mostrar eventos de la fecha");
            System.out.println("4. Modificar evento");
            System.out.println("5. Elminiar evento");
            System.out.println ("0. Salir");
            System.out.println("--------------------------------");
            
            //list = new ArrayList();
            menu = reader.nextInt();
            reader.nextLine();
            
            switch (menu) {
                
                case 0: return;
            
                case 1: //AGREGAR ACTIVIDAD
                    Activity newActivity = new Activity();
                    System.out.println("Ingrese fecha de la actividad (formato: dd/mm): ");
                    String selectedDate = reader.nextLine();
                    
                    
                    System.out.println("Ingrese el titulo de la actividad: ");
                    String activityName = reader.nextLine();
                    System.out.println("Ingrese descripcion de la actividad: ");
                    String activityDescription = reader.nextLine();
                    System.out.println("Ingrese estado de la actividad (Incompleto-Completo): ");
                    String activityState = reader.nextLine();
                    System.out.println ("Ingrese categoria de la actividad (Universidad-Trabajo-Vida personal): ");
                    String activityCategory = reader.nextLine();

                    newActivity.SetActivity(activityName, activityDescription, activityCategory, activityState, selectedDate, newActivity);


                    newDate = new Date (selectedDate);
                    newDate.setDate(selectedDate);
                    
                    
                     //newDate.printDate();
                    if (dateMap.get(selectedDate) == null) {
                        list = new ArrayList();
                        list.add(newActivity);
                        newDate.setList(list);
                        dateMap.put(selectedDate, newDate);
                    } else {
                        list.add(newActivity);
                        newDate.setList(list);
                    }
                    
                        //System.out.println("No esta permitido por el momento ingresar mas de un evento para la misma fecha, espere a la proxima actualizacion :D");
                    //}
                    break;

                case 3:
                    System.out.println ("Ingrese la fecha que desea consultar: ");
                    String dateSelected = reader.nextLine();
                    System.out.println("--------------------------------");
                    if (dateMap.get(dateSelected) != null) {
                        newDate = dateMap.get(dateSelected);
                        newDate.printDate(dateSelected);
                        //System.out.println("--------------------------------");
                        
                    } else {
                        System.out.println("Esta fecha no tiene eventos a realizar.");
                    }
                    /** System.out.println("¿Desea consultar otra fecha? ");
                    System.out.println("1. Consultar otra fecha ");
                    System.out.println("0. Volver al menú ");
                    if (menu == 0) break; **/
                    break;
                default:
                    System.out.println("Porfavor, ingrese un número del menu válido.");
                    menu = reader.nextInt();
                    break;
            }
        } while (true);
    }
    
}
