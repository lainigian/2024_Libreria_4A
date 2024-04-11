/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._progettolibreria_4a;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import eccezioni.FileException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.ConsoleInput;
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
        int numeroVoci=9;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Scaffale s1=new Scaffale(); //creo lo scaffale vuoto
        int esito;
        //Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,autore;
        int numeroPagine;
        Libro lib;
        int ripiano, posizione;
        String[] elencoTitoliAutore;
        Libro[] libriPresenti;
        String nomeFile="volumi.csv";
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutti i volumi presenti";
        vociMenu[2]="\t--> Aggiungi volume";
        vociMenu[3]="\t--> Visualizza volume (ripiano, posizione) ";
        vociMenu[4]="\t--> Elimina volume (ripiano, posizione)";
        vociMenu[5]="\t--> Mostra libri di un autore";
        vociMenu[6]="\t--> Mostra libri presenti in ordine alfabetico di titolo";
        vociMenu[7]="\t--> Esporta i volumi su file CSV";
        vociMenu[8]="\t--> Importa i volumi da file CSV";
        
        menu=new Menu(vociMenu);
       
        
        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0: //esci
                    System.out.println("Arrivederci!");    
                    break;
                case 1://Visualizza tutti
                    System.out.println(s1.toString());
                    break;
                case 2://aggiungivolume
                    try
                    {
                        System.out.println("Titolo --> ");
                        titolo=tastiera.readString();
                        System.out.println("Autore --> ");
                        autore=tastiera.readString();
                        do
                        {
                            try
                            {
                                System.out.println("Numero pagine --> ");
                                numeroPagine=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                        
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                        
                        do
                        {
                            try
                            {
                                    System.out.println("Posizione (0..14) --> ");
                                    posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                        
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
                    }
                    catch(IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera!");
                    }
                    
                    break;

                case 3: //visualizza volume
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                        
                        do
                        {
                            try
                            {
                                    System.out.println("Posizione (0..14) --> ");
                                    posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true);  
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
                    catch (IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera!");
                    }
                    break;

                case 4: //elimina volume

                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                        
                        do
                        {
                            try
                            {
                                    System.out.println("Posizione (0..14) --> ");
                                    posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true);  
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
                    catch (IOException e)
                    {
                        System.out.println("Impossibile acquisire da tastiera");
                    }                 
                    break;

                case 5://mostra libri autore
                    
                    try
                    {
                        System.out.println("Autore --> ");
                        autore=tastiera.readString();
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
                    }
                    catch (IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera1");
                    }
                    
                    break;
                case 6://mostra elenco libri ordinati
                    libriPresenti=s1.elencoLibriPresenti();
                    libriPresenti=Ordinatore.selectionSortCrescenteLibri(libriPresenti);
                    for(int i=0;i<libriPresenti.length;i++)
                    {
                        System.out.println(libriPresenti[i].toString());
                    }
                    break;
                case 7: //esporta su file CSV
                    try 
                    {
                        s1.esportaCSV(nomeFile);
                        System.out.println("Esportazione avvenuta con successo!");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore di scrittura, impossibile accedere al file");
                    } 
                    catch (FileException ex) 
                    {
                        System.out.println("Errore file aperto in lettura!");
                    }
                    break;

                    
            }  
        }while(voceScelta!=0);  
    }
}
