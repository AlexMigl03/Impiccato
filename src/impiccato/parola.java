package impiccato;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class parola { 
    String par = "";
    String daFile;
    int nP;
    
    public parola() throws FileNotFoundException, IOException {
        
        FileReader f;
        f=new FileReader("src/impiccato/parola.txt");
        BufferedReader b;
        b = new BufferedReader(f);
        
        daFile = b.readLine();
        String[] bho = daFile.split(",");       
        
        this.nP = bho.length;
        
        Random r = new Random();
        //int i = (int)Math.floor(Math.random()*((nP-1)-0+1)+0);
        int i = r.nextInt(nP);
        //System.out.println("I: "+i);
        this.par = bho[i];
    }
    
    public String getParola()
    {        
        return this.par;
    }
    
}
