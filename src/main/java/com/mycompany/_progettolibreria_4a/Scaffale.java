/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progettolibreria_4a;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.TextFile;

/**
 * Rappresenta uno scaffale costituito da
 * NUM_RIPIANI mensole, ciascuna delle quali può 
 * contenere dei libri.
 * @author gian
 */
public class Scaffale 
{
    private Mensola[] ripiani; //array di mensole
    private final static int NUM_RIPIANI=5;
    
/**
 * Costruttore
 */    
    public Scaffale()
    {
        ripiani=new Mensola[NUM_RIPIANI];
        //Istanzio una mensola (vuota) per ciascun ripiano
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            ripiani[i]=new Mensola();
        }
    }
    
    public Scaffale(Scaffale scaf) 
    {
         ripiani=new Mensola[NUM_RIPIANI];
         Libro lib;
         for(int i=0;i<NUM_RIPIANI;i++)
         {
            ripiani[i]=new Mensola();
            for (int j=0;j<scaf.getNumMaxLibri(i);j++)
            {
                try 
                {
                    lib=scaf.getLibro(i, j);
                    this.setLibro(lib, i, j);
                } 
                catch (EccezioneRipianoNonValido ex) 
                {
                    //Non può essere
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //non può essere
                } 
                catch (EccezionePosizioneVuota ex) 
                {
                    //non fare nulla
                } catch (EccezionePosizioneOccupata ex) 
                {
                    //non fare nulla
                }
            }     
         }
    }
    
    /**
     *Inserisce il libro nella posizione "posizione" del ripiano “ripiano”.
        se il ripiano non è valido --> return -3
        se la posizione non è valida --> return -1
        se la posizione è già occupata --> return -2
        se ok  return 0

     */
    
    public void setLibro(Libro libro, int ripiano, int posizione ) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        
        if (ripiano<0 || ripiano >=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        ripiani[ripiano].setVolume(libro, posizione);
       /* if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //return -1 o -2
    */
    }
    
    /**
     * Restituisce il libro che si trova 
     * in un certo ripiano, in un certa posizione
     * @param ripiano
     * @param posizione
     * @return 
     * restituisce null se il ripiano non esiste,
     * se la posizione non esiste oppure se
     * nei dati ripiano/posizione non è presente il libro.
     * Negli altri casi restituisce il libro.
     */
    public Libro getLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if (ripiano<0 || ripiano>=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        Libro lib;
        lib=ripiani[ripiano].getVolume(posizione);
        return lib;
    }

    /**
     * Rimuove un volume da un determinato ripiano e una 
     * determinata posizione
     * @param ripiano
     * @param posizione
     * @return 
     * se il ripiano non è valido --> return -3
     * se la posizione non è valida --> return -1
     * se la posizione è vuota --> return -2
     * se il volume è rimosso correttamente --> return 0
     */
    public void rimuoviLibro(int ripiano, int posizione ) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
       
        if (ripiano<0 || ripiano >=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        ripiani[ripiano].rimuoviVolume(posizione);
    /*    if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //return -1 o -2
    */
    }
    /**
     * restituisce il numero di mensole (ripiani)
     * presenti nello scaffale
     * @return 
     */
    public int getNumRipiani()
    {
        return NUM_RIPIANI;
    }
    
    /**
     * Restituisce il numero massimo di libri
     * contenuti in uno scaffale
     * @return 
     */
    public int getNumMaxLibri()
    {
        int contatore=0;
        for (int i=0;i<NUM_RIPIANI;i++)
        {
            contatore+=ripiani[i].getNumMaxVolumi();
        }
        
        return contatore;
    }
    
    /**
     * Restituisce il numero di volumi
     * presenti nello scaffale
     * @return 
     */
    public int getNumLibri()
    {
        int contaVolumi=0;
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            contaVolumi+=ripiani[i].getNumVolumi();
        }
        return contaVolumi;
    }
    
   /**
    * Restituisce il numero di libri
    * che sono presenti nello specifico ripiano
    * @param ripiano
    * @return 
    *  Se il ripiano non esiste --> return -1
    *  
    */
   public int getNumLibri(int ripiano)
   {
       if (ripiano<0 || ripiano>NUM_RIPIANI)
           return -1;
       return ripiani[ripiano].getNumVolumi();
   }
   
   /**
    * Restituisce il numero massimo di libri
    * che possono essere presenti nello specifico ripiano
    * @param ripiano
    * @return 
    *  Se il ripiano non esiste --> return -1
    *  
    */
   public int getNumMaxLibri(int ripiano)
   {
        if (ripiano<0 || ripiano>NUM_RIPIANI)
           return -1;
       return ripiani[ripiano].getNumMaxVolumi();
   }
  
   /**
    * Restituisce una stringa che contiene i volumi presenti in ciascuno scaffale
    * @return 
    * 
    */
   public String toString()
   {
       String s="";
       for (int i=0;i<NUM_RIPIANI;i++)
       {
           s+="Ripiano "+i+":\n"+ripiani[i].toString();
       }
       return s;
   }
   
   
   public String[] elencoTitoliAutore(String autore)
   {
       Libro lib;
       String[] elencoTitoliAutore;
       
       int contaLibriAutore=0;
       for (int i=0;i<NUM_RIPIANI;i++)
       {
           for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
           {
               try 
               {
                   lib=this.getLibro(i, j);
                   if (lib.getAutore().equalsIgnoreCase(autore))
                   {
                       contaLibriAutore++;  //sarà la dimensione dell'array
                   }
                   
               } 
               catch (EccezioneRipianoNonValido ex) 
               {
                 //Non succederà mai
               } 
               catch (EccezionePosizioneNonValida ex) 
               {
                     //Non succederà mai
               } 
               catch (EccezionePosizioneVuota ex) 
               {
                  //non fare nulla...
               }
               
           }
       }
       //Se non ci sono libri dell'autore --> return null
       if (contaLibriAutore==0)
           return null;
           
       //Istanzio l'array DINAMICAMENTE (Run time, durante l'esecuzione)
       elencoTitoliAutore=new String[contaLibriAutore];
       
       //Copio i titoli dell'autore nell'array di titoli
       contaLibriAutore=0;
       for (int i=0;i<NUM_RIPIANI;i++)
       {
           for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
           {
               try 
               {
                   lib=this.getLibro(i, j);
                   if (lib.getAutore().equalsIgnoreCase(autore))
                   {
                       elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
                       contaLibriAutore++;  //sarà la dimensione dell'array
                   }
               } 
               catch (EccezioneRipianoNonValido ex) 
               {
                   //non può essere
               } 
               catch (EccezionePosizioneNonValida ex) 
               {
                    //non può essere
               } 
               catch (EccezionePosizioneVuota ex) 
               {
                   //non fare nulla...
               } 
           }
       }   
       return elencoTitoliAutore;
   }
   
   public Libro[] elencoLibriPresenti()
   {
       Libro[] elencoLibriPresenti=new Libro[getNumLibri()];
       Libro lib;
       int c=0; //contatore
       for (int i=0;i<getNumRipiani();i++)
       {
           for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
           {
               try 
               {
                   lib=getLibro(i, j);
                   elencoLibriPresenti[c]=lib;
                   c++;
               } 
               catch (EccezioneRipianoNonValido ex) 
               {
                   //non può essere
               } 
               catch (EccezionePosizioneNonValida ex) 
               {
                   //non può essere
               } 
               catch (EccezionePosizioneVuota ex) 
               {
                   //non fare nulla
               }     
           }
       }
       return elencoLibriPresenti;
   }
   
   
   public void esportaCSV(String fileName) throws IOException, FileException
   {
       TextFile f1=new TextFile(fileName,'W');
       Libro lib;
       String datiVolume;
       
       for(int i=0;i<getNumRipiani();i++)
       {
           for(int j=0;j<getNumMaxLibri(i);j++)
           {
               try 
               {
                   lib=this.getLibro(i, j);
                   datiVolume=i+";"+j+";"+lib.getTitolo()+";"+lib.getAutore()+";"+lib.getNumeroPagine();
                   f1.toFile(datiVolume);    
               } 
               catch (EccezioneRipianoNonValido ex) 
               {
                    //non succederà mai
               } 
               catch (EccezionePosizioneNonValida ex) 
               {
                   //non succederà mai
               } 
               catch (EccezionePosizioneVuota ex) 
               {
                   //non fare nulla.
               }
           }
       }
       f1.close();
   }
}
