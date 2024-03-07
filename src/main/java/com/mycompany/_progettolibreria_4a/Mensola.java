/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progettolibreria_4a;
import eccezioni.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gian
 */
public class Mensola 
{
    private Libro[] volumi;
    private final static int NUM_MAX_VOLUMI=15;
    
    
    public Mensola()
    {
        volumi=new Libro[NUM_MAX_VOLUMI];
    }
    
    
    
    /**
     * Costruttore di copia
     * @param mens 
     */
    public Mensola(Mensola mens)
    {
         volumi=new Libro[NUM_MAX_VOLUMI];
         Libro lib;
         for(int i=0;i<mens.getNumMaxVolumi();i++)
         {
             try 
             {
                 lib=mens.getVolume(i);
                 volumi[i]=lib;
             } 
             catch (EccezionePosizioneNonValida ex) 
             {
                 //Non fare nulla, non avverrà mai.
             } 
             catch (EccezionePosizioneVuota ex) 
             {
                 //non fare nulla
             }
             
           //  if (lib!=null)
                
         }
    }
    
    /**
     * Costruttore che riceve un array di libri e
     * istanzia una mensola contenente i libri 
     * dell'array passato.
     * Se i libri nell'array sono più di 15, i libri in eccesso vengono ignorati.
     * I libri vengono aggiunti alla mensola nello stesso ordine 
     * in cui si trovano nell'array
     * @param elencoLibri 
     */
    public Mensola(Libro[] elencoLibri ) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        volumi=new Libro[NUM_MAX_VOLUMI]; //creo arry vuota nella mensola
        
        //Il numero di libri da aggiungere è 
        //pari alla lunghezza dell'array se essa è <15
        //altrimenti il numero di libri da aggiungere è 15.
        int numeroLibriDaAggiungere=elencoLibri.length;
        if(numeroLibriDaAggiungere>NUM_MAX_VOLUMI)
            numeroLibriDaAggiungere=NUM_MAX_VOLUMI;
        
        //aggiungo i libri dell'array a volumi
        for(int i=0;i<numeroLibriDaAggiungere;i++)
        {
            setVolume(elencoLibri[i], i);
        } 
    }
    
    /**
     * Aggiunge un libro alla mensola nella posizione indicata
        

     * @param volume E' una copia del libro da aggiungere
     * @param posizione E' la posizione in cui si vuole posizionare il libro
     * @return 
     *  se la posizione non esiste --> return -1
        se la posizione è già occupata --> return -2
        se il libro viene posizionato --> return posizione
     */
    public void setVolume(Libro volume,int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        try
        {
            if (volumi[posizione]!=null)
                throw new EccezionePosizioneOccupata();
            volumi[posizione]=new Libro(volume);
           // return posizione;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new eccezioni.EccezionePosizioneNonValida();
        } 
    }
    
    /**
     * Restituisce il libro che si trova in una determinata posizione
     * @param posizione
     * @return Il libro che si trova nella posizione indicata
     * se la posizione è vuota --> return null
     * se la posizione<0 o >= NUM_MAX_LIBRI (non valida) --> return null
     * 
     */
    public Libro getVolume(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
     /*   if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return null;
      */
     /*   if (volumi[posizione]==null)
            return null;
     */
     try
     {
        return new Libro(volumi[posizione]); 
     }
     catch (ArrayIndexOutOfBoundsException e)
     {
         //Se la posizione non è valida sollevo l'eccezione
         throw new EccezionePosizioneNonValida();
     }
     catch (NullPointerException e)
     {
         //Se la posizione non contiene un libro
         throw new EccezionePosizioneVuota();
     }
        
    }
    /**
     * Libera (inserendo null) la posizione "posizione" e restituisce il numero della
posizione "liberata"
se la posizione indicata è<0 o >= NUM_MAX_LIBRI (non valida) --> return -1
se la posizione è già vuota --> return -2
     */
    public void rimuoviVolume(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
    
    /*    if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return -1; //posizione non valida 
    */
        try
        {
            if (volumi[posizione]==null)
               throw new EccezionePosizioneVuota();
            volumi[posizione]=null;
            //return posizione; 
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        } 
    }
    
    /**
     * restituisce il numero massimo di volumi presenti nella mensola 
     * @return 
     */
    public int getNumMaxVolumi() 
    {
        return NUM_MAX_VOLUMI;
    }
    
    public int getNumVolumi()
    {
        int contaLibri;
        contaLibri=0;
        for (int i=0; i<NUM_MAX_VOLUMI; i++)
        {
            if (volumi[i]!=null )
                contaLibri++;
            
        }
        return contaLibri;
    }
    
    public boolean presenzaTitolo(String titolo)
    {
        for (int i=0;i<getNumMaxVolumi();i++)
        {
            if (volumi[i]!=null) //Attenzione!! serve questo!
            {
                if (volumi[i].getTitolo().equalsIgnoreCase(titolo))
                return true;
            }
        }
        return false;
    }
    
    /**
     * Mostra ogni posizione con l'eventuale volume
     * contenuto
     * @return 
     */
    public  String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_VOLUMI;i++)
        {
            s=s+i+"\t--> ";
            if (volumi[i]!=null)
                s=s+volumi[i].toString()+"\n";
            else
                s=s+"\n";
        }
        return s;
    }
    
    
    
}





