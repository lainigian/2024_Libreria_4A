/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progettolibreria_4a;

/**
 * Classe che rappresenta un libro
 * @author gian
 */
public class Libro 
{
    
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina=0.05;
    private final double COSTO_FISSO=5.5;

    /**
     * Metodo costruttore
     * @param titolo titolo del libro
     * @param autore autore del libro
     * @param numeroPagine  numero di pagine di cui è costituito il libro
     */
    public Libro(String titolo, String autore, int numeroPagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroPagine = numeroPagine;
    }

    /**
     * Costruttore di copia
     * @param libro Il libro da copiare
     */
    public Libro (Libro libro)
    {
        this.titolo=libro.getTitolo();
        this.autore=libro.getAutore();
        this.numeroPagine=libro.getNumeroPagine();
    }
    
    /**
     * 
     * @return Il titolo del libro
     */
    public String getTitolo() {
        return titolo;
    }
    
    /**
     * Assegna un titolo al libro
     * @param titolo 
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    /**
     * 
     * @return l'autore del libro
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Assegna un autore al libro
     * @param autore 
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * 
     * @return Il numeor di pagine del libro
     */
    public int getNumeroPagine() {
        return numeroPagine;
    }

    /**
     * Assegnail mnumeor di pagine al libro
     * @param numeroPagine 
     */
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
    
    /**
     * Calcola il prezzo del libro
     * @return il prezzo del libro
     */
    public double prezzo()
    {
        double p;
        p=COSTO_FISSO+(this.numeroPagine*costoPagina);
        return p;
    }
    
    /**
     * Assegna il costo per ogni pagina del libro
     * @param costoP 
     */
    public static void setCostoPagina(double costoP)
    {
        costoPagina=costoP;
    }
    
    /**
     * 
     * @return Il costo fisso per ogni libro
     */
    public double getCostoFisso()
    {
        return COSTO_FISSO;
    }
    
    /**
     * Restituisce un libro in formato testuale
     * @return 
     */
    
    public String toString()
    {
        String s;
        s=getTitolo()+";"+getAutore()+";"+getNumeroPagine()+";"+prezzo()+" €";
        return s;
    }
}
