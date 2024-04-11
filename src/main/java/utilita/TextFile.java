/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import eccezioni.FileException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Studente
 */
public class TextFile 
{
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    
    public TextFile(String fileName, char mode) throws FileNotFoundException, IOException
    {
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
            
        
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName));
        }
    
    }
    
    public TextFile(String fileName, char mode, boolean append) throws FileNotFoundException, IOException
    {
        
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
            
        
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName, append));
        }
    
    }
    
    public void toFile(String line) throws FileException, IOException
    {
        if (mode=='R')
        {
            throw new FileException("il file è aperto in lettura!!!");
        }
        else
            writer.write(line);
            writer.newLine();
    }
    
    
    public String fromFile() throws FileException, IOException
    {
        String line;
        if (mode=='W')
        {
            throw new FileException("il file è aperto in scrittura");
        }
        else
            line=reader.readLine();
        
        if(line==null)
            throw new FileException("fine del file");
        return line;
    }
    
    public void close() throws IOException
    {
        if(mode=='R')
        {
            reader.close();
        }
        else
            writer.close();
    }
    
    
    
    
}
