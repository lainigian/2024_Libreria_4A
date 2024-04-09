/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Studente
 * Rapprensenta un menu costituito da un elenco di voci. 
 * Il metodo elencoVoci è un array di String cdove ogni elemento
 * costituisce una delle voci.
 * Ad ogni voce è associato un numero intero. Tali numeri vanno da 0 a 
 * numeroVoci-1. 
 * L'utente può scegliere il numero corrispondente ad una delle voci.
 * Esempio:
 *      (0)Esci
    *   (1)Fai questo..
    *   (2)Fai quello..
*       Scegli-->
* 
* L'utente sceglie una di queste voci (0,1,o 2...).
 */
public class Menu 
{
    private String[] elencoVoci;
    private int numeroVoci;
    
    
   /**
    * Costruttore
    * @param elenco Array di stringhe che rappresenta l'elenco di voci del menu
    *  Esempio: elenco={"Esci","Fai questo..","Fai quello..."}
    */
    public Menu(String[] elenco)
    {
        numeroVoci=elenco.length;
        elencoVoci=new String[numeroVoci];
        for(int i=0;i<numeroVoci;i++)
        {
            elencoVoci[i]=elenco[i]; 
        }
    }
    /**
     * Metodo che consente di scegliere una voce fra quelle del menu.
     * Controllo se l'input inserito è numerico o valido (compreso fra 0 e voci menu-1)
     * 
     * @return Il numero intero corrispondente all voce scelta.
     */
    public int sceltaMenu()
    {
        //Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        
        int scelta = 0;
        String sceltaStringa;
        boolean sceltaOK=true;
        
        do
        {
            sceltaOK=true;
            visualizzaMenu();
            System.out.print("Scegli-->");

            try 
            {
                scelta=tastiera.readInt();
            } 
            catch (IOException ex) 
            {
                 System.out.println("Impossibile leggere da tastiera");          
                 sceltaOK=false;
            } 
            catch (NumberFormatException ex) 
            {
                System.out.println("Errore! Formato input non conforme.");
                sceltaOK=false;
            }
            
            //Controlliamo che il numero inserito 
            //dall'utente si acompreso fra 0 e (numeroVoci -1)
            if (sceltaOK)
            {
                if(scelta<0||scelta>=numeroVoci)
                {
                    sceltaOK=false;
                    System.out.println("Scelta non valida! Inserire un numero compreso tra 0 e "+(numeroVoci-1));
                }
            }
        }while(!sceltaOK);
        return scelta;      
    }
    
    public void visualizzaMenu()
    {
        for(int i=0;i<numeroVoci;i++)
        {
            System.out.println("("+i+")"+elencoVoci[i]);
        }
    }
    
}
