/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impiccato;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
/**
 * FXML Controller class
 *
 * @author Migliaccio 3AIN 1920
 */
public class ImpiccatoController implements Initializable {

    char lettera;       //lettera inserita da tastiera
    char lett[] = new char[7];  //lettere che compongono la parola
    String parola;              //parola usata  
    int cont = 0, vitt = 0;     //contatori
    boolean usata = false;      //variabile di controllo per le lettere gia inserite
            
    @FXML
    private Circle testa;
    @FXML
    private Line Gsinistra;
    @FXML
    private Line Gdestra;
    @FXML
    private Line corpo;
    @FXML
    private Line sinistra;
    @FXML
    private Line destra;
    @FXML
    private Line fune;
    @FXML
    private Button invio;
    @FXML
    private TextField inputL;
    @FXML
    private Label uno;
    @FXML
    private Label due;
    @FXML
    private Label tre;
    @FXML
    private Label quattro;
    @FXML
    private Label cinque;
    @FXML
    private Label sei;
    @FXML
    private Label sette;
    @FXML
    private Label Risultato;
    @FXML
    private TextField inputP;
    @FXML
    private Button invioP;
    @FXML
    private TextArea inserite;
    @FXML
    private Button restart;
    @FXML
    private Line destraHAPPY;
    @FXML
    private Line sinistraHAPPY;
    @FXML
    private Line funeTerra;
    @FXML
    private Ellipse cerchioTerra;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        parola word = null;
        try {
            word = new parola();                        //creazione di una parola nuova con gestione dell'eccezione IOException
        } catch (IOException ex) {
            Logger.getLogger(ImpiccatoController.class.getName()).log(Level.SEVERE, null, ex);  
        }
        this.parola = word.getParola();                 //assegnazione della parola alla variabile globale 
        //System.out.println("Parola: "+ this.parola);    //stampa di debug         
        
        uno.setText(""+this.parola.charAt(0));
        due.setText(" ");
        tre.setText(" ");
        quattro.setText(" ");
        cinque.setText(" ");                            //inizializzazione dei campi per la visualizzazione delle lettere.
        sei.setText(" ");
        sette.setText(" ");
        inserite.setDisable(true);
    }    

    @FXML
    private void handleInvioBtn(ActionEvent event) {    //metodo per l'inserimento di una lettera
        String letter = inputL.getText().toUpperCase();     //input delle lettere convertite in maiuscolo
        lettera = letter.charAt(0);                         //assegnazione della lettera alla variabile lettera
        
        for(int z=0; z<inserite.getText().length(); z++)    //ciclo per controllare se la lettera è presente nella parola confrontandole con ogni lettera della parola
        {
            if(lettera == inserite.getText().charAt(z))     //controllo se la lettera è contenuta nella parola
            {
                usata = true;                               //indicho che la lettera è gia stata usata
                break;
            }
            else
            {
                usata = false;                              
            }
        }
                
        String parolaInserita = "";                         //dichiaro e inizializzo una variabile per comporre la parola inserita lettera per lettera dall'utente
        vitt = 0;                                           //inizializzo a 0 il contatore vitt
        for(int i=0; i<7; i++)                              //ciclo per scorrere le lettere della parola
        {
            if(lettera == parola.charAt(i) && usata == false)   //controllo se la lettera è presente nella parola e non è stata ancora usata
            {
                if(i==0)
                {
                    vitt++;                                     //incremento il contatore
                    uno.setText(""+lettera);                    //mostro la lettera nell'apposito spazio
                }
                else if(i==1)
                {
                    vitt++;
                    due.setText(""+lettera);
                }
                else if(i==2)
                {
                    vitt++;
                    tre.setText(""+lettera);
                }
                else if(i==3)
                {
                    vitt++;
                    quattro.setText(""+lettera);
                }
                else if(i==4)
                {
                    vitt++;
                    cinque.setText(""+lettera);
                }
                else if(i==5)
                {
                    vitt++;
                    sei.setText(""+lettera);
                }
                else if(i==6)
                {
                    vitt++;
                    sette.setText(""+lettera);
                }
                parolaInserita = getLettere(lettera);           //compongo la parola inserita lettera per lettera                
            }
            else
            {
                if(i==6 && vitt ==0 && usata == false)          //controllo se alla fine della parola ci sono state corrispondenze
                {   
                    cont++;                                     //incremento il contatore degli errori
                    if(cont==1)                                 //in base al numero di errori mostro le parti del corpo del personaggio
                    {
                        fune.setVisible(true);
                        testa.setVisible(true);
                    }
                    else if(cont==2)
                    {
                        corpo.setVisible(true);
                    }
                    else if(cont==3)
                    {
                        sinistra.setVisible(true);
                        destra.setVisible(true);
                    }
                    else if(cont==4)
                    {                                                   //disabilito i tasti
                        invio.setDisable(true);
                        invioP.setDisable(true);
                        Gsinistra.setVisible(true);                                 
                        Gdestra.setVisible(true);

                        uno.setText(""+this.parola.charAt(0));
                        due.setText(""+this.parola.charAt(1));
                        tre.setText(""+this.parola.charAt(2));
                        quattro.setText(""+this.parola.charAt(3));      //mostro la parola per intero
                        cinque.setText(""+this.parola.charAt(4));
                        sei.setText(""+this.parola.charAt(5));
                        sette.setText(""+this.parola.charAt(6));

                        Risultato.setText("HAI PERSO!");
                        Risultato.setTextFill(javafx.scene.paint.Color.RED);
                    }
                }
            }
            if(parolaInserita == null ? this.parola == null : parolaInserita.equals(this.parola))
            {
                invio.setDisable(true);
                invioP.setDisable(true);
                Risultato.setText("HAI VINTO!");
                Risultato.setTextFill(javafx.scene.paint.Color.LIME);
                
                
                fune.setVisible(false);
                funeTerra.setVisible(true);
                cerchioTerra.setVisible(true);
                testa.setVisible(true);
                corpo.setVisible(true);
                sinistraHAPPY.setVisible(true);
                destraHAPPY.setVisible(true);
                Gsinistra.setVisible(true);
                Gdestra.setVisible(true);                
            }
        }
        if(usata == false)
        {
            inserite.setText(inserite.getText()+lettera);
            usata = true;
        }
        inputL.setText("");
    }
    
    public String getLettere(char a)
    {
        String par = "";

        par = par + uno.getText().charAt(0) + due.getText().charAt(0) + tre.getText().charAt(0) + quattro.getText().charAt(0) + cinque.getText().charAt(0) + sei.getText().charAt(0) + sette.getText().charAt(0);
        
        return par;
    }

    @FXML
    private void handleInvioPBtn(ActionEvent event) {
        String par = inputP.getText().toUpperCase();
        
        //System.out.println("Parola Intera: "+par);            DEBUG

        if(par.equals(this.parola))
        {
            uno.setText(""+this.parola.charAt(0));
            due.setText(""+this.parola.charAt(1));
            tre.setText(""+this.parola.charAt(2));
            quattro.setText(""+this.parola.charAt(3));
            cinque.setText(""+this.parola.charAt(4));
            sei.setText(""+this.parola.charAt(5));
            sette.setText(""+this.parola.charAt(6));
            
            fune.setVisible(false);
            funeTerra.setVisible(true);
            cerchioTerra.setVisible(true);
            testa.setVisible(true);
            corpo.setVisible(true);
            sinistra.setVisible(false);
            destra.setVisible(false);
            sinistraHAPPY.setVisible(true);
            destraHAPPY.setVisible(true);
            Gsinistra.setVisible(true);
            Gdestra.setVisible(true);        

            invio.setDisable(true);
            invioP.setDisable(true);
            Risultato.setText("HAI VINTO!");
            Risultato.setTextFill(javafx.scene.paint.Color.LIME);
        }
        else
        {
            invioP.setDisable(true);  
            inputP.setDisable(true);
            inputP.setText(par);
            cont++;
            if(cont==1)
            {
                fune.setVisible(true);
                testa.setVisible(true);
            }
            else if(cont==2)
            {
                corpo.setVisible(true);
            }
            else if(cont==3)
            {
                sinistra.setVisible(true);
                destra.setVisible(true);
            }
            else if(cont==4)
            {
                invio.setDisable(true);
                Gsinistra.setVisible(true);
                Gdestra.setVisible(true);

                uno.setText(""+this.parola.charAt(0));
                due.setText(""+this.parola.charAt(1));
                tre.setText(""+this.parola.charAt(2));
                quattro.setText(""+this.parola.charAt(3));
                cinque.setText(""+this.parola.charAt(4));
                sei.setText(""+this.parola.charAt(5));
                sette.setText(""+this.parola.charAt(6));

                Risultato.setText("HAI PERSO!");
                Risultato.setTextFill(javafx.scene.paint.Color.RED);
            }
        }
        inputL.setText("");
    }

    @FXML
    private void handleRestartBtn(ActionEvent event) throws IOException {
        parola word = new parola();
        this.parola = word.getParola();
        System.out.println("Parola: "+ this.parola);
        
        usata = false;
        
        uno.setText(""+this.parola.charAt(0));
        due.setText(" ");
        tre.setText(" ");
        quattro.setText(" ");
        cinque.setText(" ");
        sei.setText(" ");
        sette.setText(" ");
        inserite.setText("");
        Risultato.setText("");
        inputL.setText("");
        inputP.setText("");
        
        cont = 0;
        vitt = 0;
        
        inserite.setDisable(true);
        inputP.setDisable(false);
        invio.setDisable(false);
        invioP.setDisable(false);      
        
        fune.setVisible(false);
        testa.setVisible(false);
        corpo.setVisible(false);
        destra.setVisible(false);
        sinistra.setVisible(false);
        Gdestra.setVisible(false);
        Gsinistra.setVisible(false);
        sinistraHAPPY.setVisible(false);
        destraHAPPY.setVisible(false);
        funeTerra.setVisible(false);
        cerchioTerra.setVisible(false);
    }

}
