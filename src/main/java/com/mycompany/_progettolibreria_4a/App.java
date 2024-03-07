/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._progettolibreria_4a;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.Menu;
import utilita.Ordinatore;

/**
 *
 * @author gian
 */
public class App 
{
    public static void main(String[] args)
    {
       
        String[] vociMenu;
        int numeroVoci=7;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Scaffale s1=new Scaffale(); //creo lo scaffale vuoto
        int esito;
        Scanner tastiera=new Scanner(System.in);
        String titolo,autore;
        int numeroPagine;
        Libro lib;
        int ripiano, posizione;
        String[] elencoTitoliAutore;
        Libro[] libriPresenti;
        
        vociMenu[0]="0\t--> Esci";
        vociMenu[1]="1\t--> Visualizza tutti i volumi presenti";
        vociMenu[2]="2\t--> Aggiungi volume";
        vociMenu[3]="3\t--> Visualizza volume (ripiano, posizione) ";
        vociMenu[4]="4\t--> Elimina volume (ripiano, posizione)";
        vociMenu[5]="5\t--> Mostra libri di un autore";
        vociMenu[6]="6\t--> Mostra libri presenti in ordine alfabetico di titolo";
        
        menu=new Menu(vociMenu);
       
        
        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0:
                    System.out.println("Arrivederci!");    
                    break;
                case 1:
                    System.out.println(s1.toString());
                    break;
                case 2:
                    //svuoto buffer input
                    System.out.println("Premi invio per continuare...");
                    tastiera.nextLine();
                    System.out.println("Titolo --> ");
                    titolo=tastiera.nextLine();
                    System.out.println("Autore --> ");
                    autore=tastiera.nextLine();
                    System.out.println("Numero pagine --> ");
                    numeroPagine=tastiera.nextInt();
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.nextInt();  
                
                    try 
                    {
                        s1.setLibro(new Libro(titolo,autore,numeroPagine), ripiano, posizione);
                        System.out.println("Volume aggiunto correttamente");
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano inesistente");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneOccupata ex)
                    {
                        System.out.println("Posizione già occupata");
                    }
                    break;

                case 3:
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.nextInt();  
                
                    try 
                    {
                        lib=s1.getLibro(ripiano, posizione);
                         System.out.println("Libro cercato: "+lib.toString());
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano inesistente");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("Libro non trovato!");
                    }
                
                                      
                    
                    
                    
                    break;

                case 4:
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.nextInt(); 
                    
                
                    try 
                    {
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("Volume rimosso correttamente");
                    } 
                     catch (EccezioneRipianoNonValido ex) 
                    {
                         System.out.println("Ripiano inesistente");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                          System.out.println("Posizione già vuota. Nessun libro è stato rimosso.");
                    }
                               
                    break;

                case 5:
                    //svuoto buffer input
                    System.out.println("Premi invio per continuare...");
                    tastiera.nextLine();
                    System.out.println("Autore --> ");
                    autore=tastiera.nextLine();
                    elencoTitoliAutore=s1.elencoTitoliAutore(autore);
                    if(elencoTitoliAutore==null)
                        System.out.println("Nessun libro presente");
                    else
                    {
                        for(int i=0;i<elencoTitoliAutore.length;i++)
                        {
                            System.out.println(elencoTitoliAutore[i]);
                        }
                    }
                    break;
                case 6:
                    libriPresenti=s1.elencoLibriPresenti();
                    libriPresenti=Ordinatore.selectionSortCrescenteLibri(libriPresenti);
                    for(int i=0;i<libriPresenti.length;i++)
                    {
                        System.out.println(libriPresenti[i].toString());
                    }
            }  
        }while(voceScelta!=0);
        
        
    }
}
