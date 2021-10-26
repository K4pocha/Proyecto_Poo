package com.mycompany.activitiescalendar;

import java.io.*;
import java.util.*;

/**
 *
 * @author k4po
 */
public class Activity {
    private String name;
    private String description; 
    private String category;    //categoria
    private String state;  //
    private String date;
    private ArrayList<Activity> activitiesCsv;

    //CONSTRUCTOR
    public Activity(String name, String description, String category, String state, String date) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.state = state;
        this.date = date;
    }
    
    public Activity() {
        this.activitiesCsv = new ArrayList();
    }
    
    //GETTER AND SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void setActivitiesCsv(ArrayList<Activity> activitiesCsv) {
        this.activitiesCsv = activitiesCsv;
    }
    
    public ArrayList<Activity> getActivitiesCsv() {
        return activitiesCsv;
    }
    
    public Activity SetActivity (String activityName, String activityDescription, String activityCategory, String activityState, String activityDate, Activity newActivity )
    {
        newActivity.name = activityName;
        newActivity.description = activityDescription;
        newActivity.category = activityCategory;
        newActivity.state = activityState;
        newActivity.date = activityDate;       
        return newActivity;
    }
   
    public void printActivity () {
        
        System.out.print ("Actividad: ");
        System.out.println (this.name );
        
        System.out.print ("Fecha: ");
        System.out.println (this.date);
        
        System.out.print ("Descripcion: ");
        System.out.println (this.description);
        
        System.out.print ("categoria: ");
        System.out.println (this.category);
        
        System.out.print ("Estado: ");
        System.out.println (this.state);
    }
    
    public void printActivity (String nombre) {
        //VALIDAR QUE SEA EL NOMBRE DEL EVENTO
        System.out.print ("Actividad: ");
        System.out.println (this.name );
        
        System.out.print ("Fecha: ");
        System.out.println (this.date);
        
        System.out.print ("Descripcion: ");
        System.out.println (this.description);
        
        System.out.print ("categoria: ");
        System.out.println (this.category);
        
        System.out.print ("Estado: ");
        System.out.println (this.state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Activity{name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", category=").append(category);
        sb.append(", state=").append(state);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
    
    public String datos(){
        return "Nombre: "+ name + "\nDescripcion: "+ description +"\nCategoria: "+ category +"\nEstado: "+ state;
    }
    
    public void addActivityCsv(Activity activity) {
        this.activitiesCsv.add(activity);
    }
      
    public void printCsv() {
        int size = this.activitiesCsv.size();
        for (int i = 0; i < size; i++) {
            this.activitiesCsv.get(i).printCsv();
        }
    }
    
    public void createCsv (PrintWriter writer){
        File csvFile = new File("Reporte Eventos.csv");
         
        try{
            writer = new PrintWriter(csvFile);
            int size = activitiesCsv.size();
            if (size != 0){   
                for(int i=0; i< activitiesCsv.size();i++){
                    writer.println("Fecha:" + activitiesCsv.get(i).getDate());
                    writer.println("Nombre:" + activitiesCsv.get(i).getName());
                    writer.println("Descripcion:" + activitiesCsv.get(i).getDescription());
                    writer.println("Categoria:" + activitiesCsv.get(i).getCategory());
                    writer.println("Estado:" + activitiesCsv.get(i).getState());
                }
            }
        }catch(FileNotFoundException ex){
            System.err.println(ex);
        }
    }
}