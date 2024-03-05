/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.util.Scanner;

/**
 *
 * @author gian
 */
public class Menu 
{
    private String[] elencoVoci; //Ogni stringa è una voce del menu
    private int numeroVoci;
    
    public Menu(String[] elenco)
    {
        numeroVoci=elenco.length; //Imposto il numero di voci del menu
        elencoVoci=new String[numeroVoci];
        
        //Copio ciascuna voce del parametro elenco
        //nell'attributo elencoVoci
        for(int i=0;i<numeroVoci;i++)
        {
            elencoVoci[i]=elenco[i];
        }
        
    }
    
    public void visualizzaMenu()
    {
        for(int i=0;i<numeroVoci;i++)
        {
            System.out.println(elencoVoci[i]);
        }
    }
    
    public int sceltaMenu()
    {
        Scanner tastiera=new Scanner(System.in);
        String input;
        boolean inputOK = false;
        int scelta=0;
        String input2="0";

        do
        {
            inputOK=true;
            visualizzaMenu();
            System.out.println("Scegli: ");
            input=tastiera.nextLine();
            if(input.charAt(0)<'0' || input.charAt(0)>'9')
            {
                System.out.println("Input non corretto.");
                inputOK=false;
            }
            else
            {
                input2=input2+input.charAt(0);
                scelta=Integer.parseInt(input2);
                if (scelta<0 || scelta>=numeroVoci)
                {
                     System.out.println("La voce scelta non è prevista.");
                    inputOK=false;
                }
            }
        }while(!inputOK);
        
        return scelta;
    }
    
    
    
}
