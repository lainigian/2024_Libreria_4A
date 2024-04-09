/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Studente
 */
public class ConsoleInput 
{
    private InputStreamReader reader;
    private BufferedReader tastiera;
    
    /**
     * Costruttore
     */
    public ConsoleInput()
    {
        reader=new InputStreamReader(System.in);
        tastiera=new BufferedReader(reader);
        
    }
    
    /**
     * Legge una stringa
     * @return
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * 
     */
    public String readString() throws IOException, NumberFormatException
    {
        return tastiera.readLine();
    }
    
    public int readInt() throws IOException, NumberFormatException
    {
        String s=tastiera.readLine();
        int x=Integer.parseInt(s);
        return x;
    }
    
    public short readShort() throws IOException, NumberFormatException
    {
        return Short.parseShort(tastiera.readLine());
    }
    
    public char readChar() throws IOException, NumberFormatException
    {
        return tastiera.readLine().charAt(0);
    }
    
    public Long readLong() throws IOException, NumberFormatException
    {
        return Long.parseLong(tastiera.readLine());
    }
    
    public float readFloat() throws IOException, NumberFormatException
    {
        return Float.parseFloat(tastiera.readLine());
    }
    
    public double readDouble() throws IOException, NumberFormatException
    {
        return Double.parseDouble(tastiera.readLine());
    }
    
    public Boolean readBoolean() throws IOException, NumberFormatException
    {
        return Boolean.parseBoolean(tastiera.readLine());
    }
    
    public byte readByte() throws IOException, NumberFormatException
    {
        return Byte.parseByte(tastiera.readLine());
    }
    
    
}
