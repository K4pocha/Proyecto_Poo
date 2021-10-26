package com.mycompany.activitiescalendar;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        int menu,i,j,aux;
        String data;
        String auxData;
        Scanner reader = new Scanner(System.in);
        Map<String, Date> dateMap = new HashMap();

        do {
            System.out.println("--------------------------------");
            System.out.println("MENÚ:");
            System.out.println("1. Agregar evento");
            System.out.println("2. Buscar evento por nombre");
            System.out.println("3. Mostrar evento mas cercano");
            System.out.println("4. Mostrar eventos de la fecha");
            System.out.println("5. Mostrar eventos del mes");
            System.out.println("6. Modificar evento");
            System.out.println("7. Eliminar evento");
            System.out.println("8. Generar reporte de eventos");
            System.out.println("0. Salir");
            System.out.println("--------------------------------");

            menu = reader.nextInt();
            reader.nextLine();

            switch (menu) {

                case 0:
                    return;

                case 1: //AGREGAR ACTIVIDAD
                    //Activity newActivity = new Activity();
                    System.out.println("Ingrese fecha de la actividad (formato: dd-mm): ");
                    String selectedDate = reader.nextLine();

                    System.out.println("Ingrese el titulo de la actividad: ");
                    String activityName = reader.nextLine();
                    //newActivity.setName(reader.nextLine());
                    System.out.println("Ingrese descripcion de la actividad: ");
                    String activityDescription = reader.nextLine();
                    System.out.println("Ingrese estado de la actividad (Incompleto-Completo): ");
                    String activityState = reader.nextLine();
                    System.out.println("Ingrese categoria de la actividad (Universidad-Trabajo-Vida personal): ");
                    String activityCategory = reader.nextLine();

                    Activity newActivity = new Activity(activityName, activityDescription, activityCategory, activityState, selectedDate);
                    //newActivity.SetActivity(activityName, activityDescription, activityCategory, activityState, selectedDate, newActivity);
                    
                    Activity newActivityCsv = new Activity();
                    newActivityCsv.addActivityCsv(newActivityCsv);
                    //newDate.printDate();
                    if (dateMap.get(selectedDate) == null) {
                        Date newDate = new Date(selectedDate);
                        newDate.addActivity(newActivity);
                        dateMap.put(selectedDate, newDate);
                    } else {
                        dateMap.get(selectedDate).addActivity(newActivity);
                    }

                    break;
                case 2:
                    System.out.println("Ingrese el titulo de la actividad: ");
                    String Name = reader.nextLine();

                    for (Date date : dateMap.values()) {
                        if (date.searchActivity(Name) != null) {
                            System.out.println(date.searchActivity(Name));
                            break;
                        }
                    }

                    break;
                    
                case 3:
                    //LocalDate actualDate = LocalDate.now(); Como casteo de localdate a string, hay que cambiar todo el codigo para empezar a usar localdate?
                    boolean flag = false;
                    System.out.println("Ingrese la fecha actual (dd-mm)");
                    String dateNow = reader.nextLine();
                    System.out.println("La actividad mas cercana a la fecha " + dateNow + " es: ");
                    String[] auxDateNow = dateNow.split("-");
                    
                    
                    if (dateMap.get(dateNow) != null) {
                        dateMap.get(dateNow).printDate(dateNow);
                        break;
                    } else {
                        int aux2 = Integer.parseInt(auxDateNow[1]); //Mes
                        int aux1 = Integer.parseInt(auxDateNow[0]); //Dia
                        
                        for (i = aux1; i <= 31; i++) {   
                            String day = Integer.toString(i);
                            String month = Integer.toString(aux2);
                            //String auxDate = new StringBuilder(day).append("-").append(aux2).toString();
                            if (i < 10){  
                                String auxDay = new StringBuilder("0").append(day).toString();
                                String auxDate = new StringBuilder(auxDay).append("-").append(month).toString();
                                if(dateMap.get(auxDate) != null ) {
                                    dateMap.get(auxDate).printDate(auxDate);
                                    flag = true;
                                    break;
                                }
                            } else if (i > 10) {    
                                String auxDate = new StringBuilder(day).append("-").append(aux2).toString();
                                if(dateMap.get(auxDate) != null ) {
                                    dateMap.get(auxDate).printDate(auxDate);
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag) break; //Casos anteriores, break solo sale del ciclo pero no termina la ejecucion del case 3, por lo que seguira buscando eventos en meses siguientes       
                        for (i = 1; i <= 31; i++) {
                            for (j = aux2+1; j<= 12; j++){ 
                               
                                String day = Integer.toString(i);
                                String month = Integer.toString(j);
                                if (i < 10){  
                                    String auxDay = new StringBuilder("0").append(day).toString();
                                    String auxDate = new StringBuilder(auxDay).append("-").append(month).toString();
                                    if(dateMap.get(auxDate) != null ) {
                                        dateMap.get(auxDate).printDate(auxDate);
                                        break;
                                    }
                                } else if (i > 10) {    
                                    String auxDate = new StringBuilder(day).append("-").append(month).toString();
                                    if(dateMap.get(auxDate) != null ) {
                                        dateMap.get(auxDate).printDate(auxDate);
                                        break;
                                    }
                                }
                                
                            }
                        }
                        
                    }
                            
                    System.out.println("No hay fechas cercanas con actividades");
                    break;
                    
                case 4:
                    System.out.println("Ingrese la fecha que desea consultar: ");
                    String dateSelected = reader.nextLine();
                    System.out.println("--------------------------------");
                    if (dateMap.get(dateSelected) != null) {

                        dateMap.get(dateSelected).printDate(dateSelected);


                    } else {
                        System.out.println("Esta fecha no tiene eventos a realizar.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Ingrese el mes que desea consultar (Numero del mes): ");
                    String searchedMonth = reader.nextLine();
                    for (i = 1; i <= 31; i++)
                    {
                        String s = Integer.toString(i);
                        String finalDate = new StringBuilder(s).append("-").append(searchedMonth).toString();
                        if (dateMap.get(finalDate) != null)
                        {
                            dateMap.get(finalDate).printDate(finalDate);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Ingrese la fecha que desea modificar");
                    dateSelected = reader.nextLine();
                    if (dateMap.get(dateSelected) != null) {
                        //newDate = dateMap.get(dateSelected);
                        System.out.println("--------------------------------");
                        System.out.println("Eventos en la fecha: ");
                        dateMap.get(dateSelected).printDate(dateSelected);

                        System.out.println("Ingrese nombre del evento que quiere modificar: ");
                        data = reader.nextLine();
                                           
                        System.out.println("--------------------------------");
                        System.out.println("MODIFICAR:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Fecha");
                        System.out.println("3. Estado");
                        System.out.println("4. Descripcion");
                        System.out.println("5. Categoria");
                        System.out.println("0. Volver al menú");
                        System.out.println("--------------------------------");
                        aux = reader.nextInt();
                        reader.nextLine();
                        
                        switch (aux) {
                            default:
                                System.out.println("Porfavor ingrese un numero valido");
                            case 0: return;

                            case 1: //MODIFICAR NOMBRE ACTIVIDAD 
                                System.out.println("Ingrese el nuevo nombre del evento: ");
                                auxData = reader.nextLine();
                                dateMap.get(dateSelected).editActivityName(data, auxData);
                                break;
                            case 2: //MODIFICAR FECHA (Mapa y evento)
                                System.out.println("Ingrese la nueva fecha del evento: ");
                                auxData = reader.nextLine();                             
                                dateMap.get(dateSelected).editActivityDate(data, auxData);
                                //Como actualizo el mapa, si ya elimine la fecha de la lista ,....
                             
                                break;
                            case 3: //MODIFICAR ESTADO
                                System.out.println("Ingrese el nuevo estado del evento: ");
                                auxData = reader.nextLine();
                                dateMap.get(dateSelected).editActivityState(data, auxData);
                                break;
                            case 4: //MODIFICAR DESCRIPCION
                                System.out.println("Ingrese la nueva descripcion del evento: ");
                                auxData = reader.nextLine();
                                dateMap.get(dateSelected).editActivityDescription(data, auxData);
                                break;
                            case 5: //MODIFICAR CATEGORIA
                                System.out.println("Ingrese la nueva categoria del evento: ");
                                auxData = reader.nextLine();
                                dateMap.get(dateSelected).editActivityCategory(data, auxData);
                                break;
                        }
                    }
                    //System.out.println("ERROR");
                    break;

                case 7:
                    System.out.println("Ingrese la fecha del evento que quiere eliminar");
                    dateSelected = reader.nextLine();
                    if (dateMap.get(dateSelected) != null) {
                        //newDate = dateMap.get(dateSelected);
                        System.out.println("--------------------------------");
                        System.out.println("Eventos en la fecha: ");
                        dateMap.get(dateSelected).printDate(dateSelected);

                        System.out.println("Ingrese nombre del evento que quiere eliminar: ");
                        data = reader.nextLine();
                        dateMap.get(dateSelected).deleteActivity(data);
                    } else {
                        System.out.println("La fecha ingresada es incorrecta o no existen eventos asociados");
                    }
                    break;
                case 8:
                    Activity auxCsv = new Activity();
                    PrintWriter writer = null;
                    auxCsv.printCsv();
                    auxCsv.createCsv(writer);
                    System.out.println("********************************");
                    System.out.println("Reporte de eventos generado!");
                    System.out.println("********************************");
                    break;
                    
                default:
                    System.out.println("Porfavor, ingrese un número del menu válido.");
                    break;
            }
        } while (true);
    }
}
