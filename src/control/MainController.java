package control;

import model.Exam;
import model.Stack;

/**
 * Created by Jean-Pierre on 01.11.2016.
 */
public class MainController {


    private Stack<Exam> stackOfUncorrected; //TODO: 02 - Sobald der Stack implementiert ist, wird der Controller um die Datenstruktur erweitert.
    private Exam currentCorrection;
    private Stack<Exam> stackOfCorrected;
    private char pupilName;


    /**
     * Ein Objekt der Klasse MainController wird erstellt. Die Schüler beginnen mit dem Buchstaben A.
     * Zwei Stacks werden inistialisert.
     */
    public MainController(){
        pupilName = 'A';
        stackOfUncorrected = new Stack<>();
        stackOfCorrected = new Stack<>();
        //TODO: 03 - Hier muss später eine Initialisierung der Stacks stattfinden.
    }

    /**
     *
     * @return String-Array mit allen Informationen zu den unkorrigierten Klausuren.
     */
    public String[] showUncorrectedExams(){
        //TODO: 05 - Bei einem Stack ist es unüblich, auf alle Daten innerhalb des Stacks zuzugreifen. Gerade das ist hier aber nötig! Hier muss mit einem "Trick" gearbeitet werden, ohne die Klasse Stack zu überarbeiten.
        String[] output = new String[1];
        int nmbOfUE = 0;
        if(!stackOfUncorrected.isEmpty()){
            Stack<Exam> tmpUE = new Stack();
            while(!stackOfUncorrected.isEmpty()){
                nmbOfUE ++;
                tmpUE.push(stackOfUncorrected.top());
                stackOfUncorrected.pop();
            }
            output = new String[nmbOfUE];
            for(int i = 0; i<nmbOfUE; i++){
                output[i] = tmpUE.top().toString();
                stackOfUncorrected.push(tmpUE.top());
                tmpUE.pop();
            }
        }else{
            output[0] = "Stapel ist leer.";
        }
        return output;
    }

    /**
     *
     * @return Informationen zur Klausur, die aktuell korrigiert wird, sofern eine Klausur vorhanden ist.
     */
    public String showCurrentCorrection(){
        if(currentCorrection != null){
            return currentCorrection.toString();
        }
        return "Aktuell keine Korrektur.";
    }

    /**
     *
     * @return String-Array mit allen Informationen zu den korrigierten Klausuren.
     */
    public String[] showCorrectedExams(){
        //TODO: 08 - siehe die Methode showUncorrectedExams!
        String[] output = new String[1];
        int nmbOfE = 0;
        if(!stackOfCorrected.isEmpty()){
            Stack<Exam> tmpE = new Stack();
            while(!stackOfCorrected.isEmpty()){
                nmbOfE ++;
                tmpE.push(stackOfCorrected.top());
                stackOfCorrected.pop();
            }
            output = new String[nmbOfE];
            for(int i = 0; i<nmbOfE; i++){
                output[i] = tmpE.top().toString();
                stackOfCorrected.push(tmpE.top());
                tmpE.pop();
            }
        }else{
            output[0] = "Stapel ist leer.";
        }
        return output;
    }

    /**
     * Eine neue Klausur wird auf den Stapel der unkorrigierten Klausuren gelegt.
     * @return Informationen zur neuen, unkorrigierten Klausur.
     */
    public String addNewExam(){
        //TODO: 04 - Hinzufügen von Objekten auf den Stack.
        stackOfUncorrected.push(new Exam(String.valueOf(pupilName)));
        pupilName++;
        return stackOfUncorrected.toString();
    }

    /**
     * Die oberste Klausur des unkorrigierten Stapels soll korrigiert werden, falls eine unkorrigierte vorhanden ist und gerade keine korrigiert wird.
     * @return true, falls keine Klausur gerade korrigiert wird und eine unkorrigierte Klausur vorahnden ist, sonst false.
     */
    public boolean startCorrection(){
        //TODO: 06 - Entfernen des obersten Objekts eines Stack.
        if(currentCorrection == null && stackOfUncorrected != null){
            currentCorrection = stackOfUncorrected.top();
            stackOfUncorrected.pop();
            return true;
        }
        return false;
    }

    /**
     * Die aktuelle Klausur wurde fertig korrigiert und wird auf den Stapel der bereits korrigierten Klausuren gelegt.
     * @return Informationen zur korrigierten Klausur, falls vorhanden, sonst ein Hinweis, dass keine Klausur korrigiert wurde.
     */
    public String endCorrection(){
        //TODO: 07 - Hinzufügen von Objekten auf den Stack.
        if(currentCorrection != null){
            stackOfCorrected.push(currentCorrection);
            currentCorrection = null;
            return stackOfCorrected.toString();
        }
        return "keine Klausur";
    }
}
