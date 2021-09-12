/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activitiescalendar;

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

    //CONSTRUCTOR
    public Activity(String name, String description, String category, String state, String date) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.state = state;
        this.date = date;
    }
    
    public Activity () {
        name = null;
        description = null;
        category = null;
        state = null;
        date = null;
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
    
    //METODS
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
            
    public void editActivity (int menu) {
        switch (menu) {
            
            case 0: return;
            
            case 1: //MODIFICAR NOMBRE ACTIVIDAD  
            case 2: //MODIFICAR DESCRIPCION 
            case 3: //MODIFICAR FECHA (PAJA)
            case 4: //MODIFICAR CATEGORIA
            case 5: //MODIFICAR ESTADO
            
        }
    }
}
