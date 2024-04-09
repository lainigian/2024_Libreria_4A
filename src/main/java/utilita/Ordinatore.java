/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import com.mycompany._progettolibreria_4a.Libro;

/**
 *
 * @author gian
 */
public class Ordinatore 
{
    /**
     * Scambia il valore in posizione pos1 con
     * il valore in posizione pos2 
     * dell' array di interi a
     * @param a
     * @param pos1
     * @param pos2 
     */
    public static void scambia(int[] a, int pos1, int pos2)
    {
        int s;
        s=a[pos1];
        a[pos1]=a[pos2];
        a[pos2]=s;
    }
    
    
     /**
     * Scambia il valore in posizione pos1 con
     * il valore in posizione pos2 
     * dell' array di stringhe a
     * @param a
     * @param pos1
     * @param pos2 
     */
    public static void scambia(String[] a, int pos1, int pos2)
    {
        String s;
        s=a[pos1];
        a[pos1]=a[pos2];
        a[pos2]=s;
    }
    
    
    /**
     * Scambia il libro in posizione pos1 con
     * il libro in posizione pos2 
     * dell' array di libri a
     * @param a
     * @param pos1
     * @param pos2 
     */
    public static void scambiaLibri(Libro[] a, int pos1, int pos2)
    {
        Libro s;
        s=a[pos1];
        a[pos1]=a[pos2];
        a[pos2]=s;
    }
    
    /**
     * Ordina in ordine crescente gli elementi
     * di un array di interi utilizzando l'algoritmo
     * selection sort
     * 
     * @param a l'array da ordinare
     * @return  una copia dell'array ordinato
     */
    public static int[] selectionSortCrescente (int[] a)
    {
        int v[]= new int[a.length];
        int lunghezza=v.length;
        //creo una copia di a
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        
        for (int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (v[j]<v[i])
                    scambia(v, i, j);
            }
        }       
        return v;    
    }
    
    
    /**
     * Ordina in ordine decrescente gli elementi
     * di un array di interi utilizzando l'algoritmo
     * selection sort
     * 
     * @param a l'array da ordinare
     * @return  una copia dell'array ordinato
     */
    public static int[] selectionSortDecrescente (int[] a)
    {
        int v[]= new int[a.length];
        int lunghezza=v.length;
        //creo una copia di a
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        
        for (int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (v[j]>v[i])
                    scambia(v, i, j);
            }
        }       
        return v;    
    }
   
     /**
     * Ordina in ordine crescente gli elementi
     * di un array di stringhe utilizzando l'algoritmo
     * selection sort
     * 
     * @param a l'array da ordinare
     * @return  una copia dell'array ordinato
     */
    public static String[] selectionSortCrescente (String[] a)
    {
        String v[]= new String[a.length];
        int lunghezza=v.length;
        //creo una copia di a
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        
        for (int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (v[j].compareTo(v[i])<0)
                    scambia(v, i, j);
            }
        }       
        return v;    
    }
    
    
    /**
     * Ordina in ordine decrescente gli elementi
     * di un array di stringhe utilizzando l'algoritmo
     * selection sort
     * 
     * @param a l'array da ordinare
     * @return  una copia dell'array ordinato
     */
    public static String[] selectionSortDecrescente (String[] a)
    {
        String v[]= new String[a.length];
        int lunghezza=v.length;
        //creo una copia di a
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        
        for (int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (v[j].compareTo(v[i])>0)
                    scambia(v, i, j);
            }
        }       
        return v;    
    }
    
    
    public static int[] bubbleSortCrescente(int[] a)
    {
        int v[]= new int[a.length];
        int lunghezza=v.length;
        boolean scambioAvvenuto;
        //creo una copia di a
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if (v[i]>v[i+1])
                {
                    scambia(v, i, i+1);
                    scambioAvvenuto=true;
                }
            }
        }while (scambioAvvenuto);
        return v;
    }
    
     public static int[] bubbleSortDecrescente(int[] a)
    {
        int v[]= new int[a.length];
        int lunghezza=v.length;
        boolean scambioAvvenuto;
        
        //creo una copia di a
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if (v[i]>v[i+1])
                {
                    scambia(v, i, i+1);
                    scambioAvvenuto=true;
                }
            }
        }while (scambioAvvenuto);
        return v;
    }
     
     
     
     
     /**
     * Ordina in ordine alfabetico di titolo gli elementi
     * di un array di Libri utilizzando l'algoritmo
     * selection sort
     * 
     * @param a l'array da ordinare
     * @return  una copia dell'array ordinato
     */
    public static Libro[] selectionSortCrescenteLibri (Libro[] a)
    {
        Libro v[]= new Libro[a.length];
        int lunghezza=v.length;
        //creo una copia di a
        for(int i=0;i<v.length;i++)
        {
            v[i]= new Libro(a[i]);      
        }
        
        for (int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (v[j].getTitolo().compareToIgnoreCase(v[i].getTitolo())<0)
                    scambiaLibri(v, i, j);
            }
        }       
        return v;    
    } 
    
}
