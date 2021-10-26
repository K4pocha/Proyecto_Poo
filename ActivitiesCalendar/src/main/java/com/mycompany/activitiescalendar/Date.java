
package com.mycompany.activitiescalendar;

import java.util.*;
import java.time.*;

/**
 *
 * @author k4po
 */
public class Date {

    private String date;
    private ArrayList<Activity> list;
    private int number;

    //CONSTRUCTOR   
    public Date(String activityDate) {
        this.date = activityDate;
        list = new ArrayList();
    }

    public Date() {
        this.list = new ArrayList();
    }

    public Date(String date, ArrayList<Activity> list, int number) {
        this.date = date;
        this.list = list;
        this.number = number;
    }

    //GETTER AND SETTER
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Activity> getList() {
        return list;
    }

    public void setList(ArrayList<Activity> list) {
        this.list = list;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //METODS
    public void addActivity(Activity activity) {
        this.list.add(activity);
        number++;
    }

    public void printDate(String dateSelected) {

        String data;
        int size = this.list.size();

        System.out.println("--------------------------------");
        System.out.println("Fecha consultada: " + dateSelected);
        System.out.println("--------------------------------");

        for (int i = 0; i < size; i++) {
            Activity activity = this.list.get(i);

            /*data = activity.getName();
            System.out.println("Nombre: " + data);
            
            data = activity.getDescription();
            System.out.println("Descripcion: " + data);
            
            data = activity.getCategory();
            System.out.println("Categoria: " + data);
            
            data = activity.getState();
            System.out.println("Estado: " + data);*/
            System.out.println(activity.datos());
            System.out.println("------------------------");
        }
    }

    //evento buscar
    public String searchActivity(String name) {
        for (Activity activity : list) {
            if (activity.getName().equalsIgnoreCase(name)) {
                return activity.toString();
            }
        }
        return null;
    }

    public void deleteActivity(String name) {
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (activity.getName().equalsIgnoreCase(name)) {
                list.remove(i);
                System.out.println("Evento: " + name + " eliminado de la fecha exitosamente");
                return;
            }
        }
        System.out.println("No existe evento en esta fecha con el nombre ingresado.");
    }

    
    
    //¿Como encapsulo para editar en actividad y no en date?
    public Activity editActivityName ( String name, String newName) {
        
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (activity.getName().equalsIgnoreCase(name)) {
                activity.setName(newName);
                System.out.println("Evento: " + name + " renombrado exitosamente como " + newName);
                return activity;
            }      
        }
        return null;
    }
     
    public Activity editActivityState(String data, String auxData) {
        
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (activity.getName().equalsIgnoreCase(data)) {
                activity.setState(auxData);
                System.out.println("Evento: " + data + " ahora tiene estado " + auxData);
                return activity;
            }      
        }
        return null;
    }
    
    public Activity  editActivityDescription(String data, String auxData) {
        
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (activity.getName().equalsIgnoreCase(data)) {
                activity.setDescription(auxData);
                System.out.println("Evento: " + data + " ahora tiene descripción " + auxData);
                return activity;
            }      
        }
        return null;
    }
    
    public Activity  editActivityCategory(String data,String auxData) {
        
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (activity.getName().equalsIgnoreCase(data)) {
                activity.setCategory(auxData);
                System.out.println("Evento: " + data + " ahora tiene categoria " + auxData);
                return activity;
            }      
        }
        return null;
    }
    
    public Activity  editActivityDate(String data, String auxData) {
        
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (activity.getName().equalsIgnoreCase(data)) {
                activity.setDate(auxData);
                System.out.println("Evento: " + data + " ahora tiene fecha " + auxData);
                return activity;
            }      
        }
        return null;
    }
    
    /** public void printMonthActivities (String  monthYearSearched)
    {
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            String activityDate = activity.getDate();
            
            String[] activityDayMonthYear = activityDate.split("/");
            String[] auxMonthYear = monthYearSearched.split("/");
            
             System.out.println("Dias con actividades a realizar en el mes " + monthYearSearched + "son: ");
            
            if (auxMonthYear[0].equalsIgnoreCase(activityDayMonthYear[1]) && auxMonthYear[1].equalsIgnoreCase(activityDayMonthYear[2])) {
               
                activity.printActivity();
            }      
        }
    } **/ 
    
    public void printMonthActivities(String month)
    {
        
    }
    
}
