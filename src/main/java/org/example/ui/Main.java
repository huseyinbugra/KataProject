package org.example.ui;
import com.vaadin.ui.*;
import org.example.button.SimpleButton;
import java.util.Random;

public class Main extends VerticalLayout {

    private HorizontalLayout horizontalLayout;
    private int buttonNumber;
    private TextField captionField;

    public Main(int raw, int column) {

        SimpleButton btnArray[][] = new SimpleButton[raw][column];
        buttonNumber=0;
        setMargin(true);
        setSpacing(true);

        for (int i = 0; i <raw ; i++) {
            horizontalLayout = new HorizontalLayout();
            for (int j = 0; j <column ; j++) {
                buttonNumber++;
                Random rnd = new Random();
                int counter = rnd.nextInt(2);

                SimpleButton simpleButton = new SimpleButton();
                if(counter==0) {
                    btnCreate(counter, simpleButton,i,j,raw,column,btnArray);
                }
                else if (counter==1){
                    btnCreate(counter, simpleButton,i,j,raw,column,btnArray);
                }
                horizontalLayout.addComponent(simpleButton);
            }
            addComponent(horizontalLayout);
        }
    }

    private void btnCreate(int counter, SimpleButton simpleButton, int i, int j, int raw, int column, SimpleButton [][] btnArray) {

        btnArray[i][j]=simpleButton;
        simpleButton.setNumber(counter);
        simpleButton.setDescription(String.valueOf(simpleButton.getNumber()));
        simpleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                //tıkladığımız zaman ilk olarak butonun ölü olup olmadığını kontrol ediyor.
                if(simpleButton.getNumber()==0){
                    Notification.show("Ölü!");
                    simpleButton.setNumberFont();
                }
                else {
                    //sol üst köşeyi kontrol eder.
                    if (i == 0 && j == 0 ) {
                        if(btnArray[i][j+1].getNumber()==1 && btnArray[i+1][j].getNumber()==1 && btnArray[i+1][j+1].getNumber()==1){
                            setNumberOne(btnArray[i][j]);
                        }
                        else setNumberZero(btnArray[i][j]);

                    }
                    //sağ alt köşeyi kontrol eder.
                    else if(i == raw-1 && j == column-1){
                        if(btnArray[i][j-1].getNumber()==1 && btnArray[i-1][j].getNumber()==1 && btnArray[i-1][j-1].getNumber()==1){
                            setNumberOne(btnArray[i][j]);
                        }
                        else setNumberZero(btnArray[i][j]);
                    }
                    //sağ üst köşeyi kontrol eder.
                    else if(i == 0 && j == column-1){
                        if(btnArray[i][j-1].getNumber()==1 && btnArray[i+1][j].getNumber()==1 && btnArray[i+1][j-1].getNumber()==1){
                            setNumberOne(btnArray[i][j]);
                        }
                        else setNumberZero(btnArray[i][j]);
                    }
                    //sol alt köşeyi kontrol eder.
                    else if(i == raw-1 && j == 0){
                        if(btnArray[i][j+1].getNumber()==1 && btnArray[i-1][j].getNumber()==1 && btnArray[i-1][j+1].getNumber()==1){
                            setNumberOne(btnArray[i][j]);
                        }
                        else setNumberZero(btnArray[i][j]);
                    }
                    //köşeler dışındaki en üst satırı kontrol eder.
                    else if(i == 0 && j!=0){
                        int counter =0;
                        if (btnArray[i][j-1].getNumber() == 1) { counter++; }
                        if (btnArray[i][j+1].getNumber() == 1) { counter++; }
                        if (btnArray[i+1][j-1].getNumber() == 1) { counter++; }
                        if (btnArray[i+1][j].getNumber() == 1) { counter++; }
                        if (btnArray[i+1][j+1].getNumber() == 1) { counter++; }
                        if(counter>2) { setNumberOne(btnArray[i][j]); }
                        if (counter<3){ setNumberZero(btnArray[i][j]); }
                    }
                    //köşeler dışındaki en alt satırı kontrol eder.
                    else if(i == raw-1 && j!=column-1){
                        int counter =0;
                        if (btnArray[i][j-1].getNumber() == 1) { counter++; }
                        if (btnArray[i][j+1].getNumber() == 1) { counter++; }
                        if (btnArray[i-1][j-1].getNumber() == 1) { counter++; }
                        if (btnArray[i-1][j].getNumber() == 1) { counter++; }
                        if (btnArray[i-1][j+1].getNumber() == 1) { counter++; }
                        if(counter>2) { setNumberOne(btnArray[i][j]); }
                        if (counter<3){ setNumberZero(btnArray[i][j]); }
                    }
                    //köşeler dışındaki en sol kolunu kontrol eder.
                    else if(j == 0 && i!=raw-1){
                        int counter =0;
                        if (btnArray[i-1][j].getNumber() == 1) { counter++; }
                        if (btnArray[i+1][j].getNumber() == 1) { counter++; }
                        if (btnArray[i-1][j+1].getNumber() == 1) { counter++; }
                        if (btnArray[i][j+1].getNumber() == 1) { counter++; }
                        if (btnArray[i+1][j+1].getNumber() == 1) { counter++; }
                        if(counter>2) { setNumberOne(btnArray[i][j]); }
                        if (counter<3){ setNumberZero(btnArray[i][j]); }
                    }
                    //köşeler dışındaki en sağ kolonu kontrol eder.
                    else if(j == column-1 && i!=0){
                        int counter =0;
                        if (btnArray[i-1][j].getNumber() == 1) { counter++; }
                        if (btnArray[i+1][j].getNumber() == 1) { counter++; }
                        if (btnArray[i-1][j-1].getNumber() == 1) { counter++; }
                        if (btnArray[i][j-1].getNumber() == 1) { counter++; }
                        if (btnArray[i+1][j-1].getNumber() == 1) { counter++; }
                        if(counter>2) { setNumberOne(btnArray[i][j]); }
                        if (counter<3){ setNumberZero(btnArray[i][j]); }
                    }
                    //kenar ve köşede olmayan tüm butonlar için.
                    else{
                        int counter = 0;
                        if(btnArray[i-1][j-1].getNumber()==1){ counter++; }
                        if(btnArray[i-1][j].getNumber()==1){counter++; }
                        if(btnArray[i-1][j+1].getNumber()==1){ counter++; }
                        if(btnArray[i][j+1].getNumber()==1){counter++;}
                        if(btnArray[i+1][j+1].getNumber()==1){ counter++;}
                        if(btnArray[i+1][j].getNumber()==1){counter++;}
                        if(btnArray[i+1][j-1].getNumber()==1){ counter++;}
                        if(btnArray[i][j-1].getNumber()==1){ counter++; }
                        if(counter>2) { setNumberOne(btnArray[i][j]);}
                        if (counter<3){ setNumberZero(btnArray[i][j]);}
                    }
                }
            }
        });
    }
    //Tıkladığımız zaman ölü ve öldürülmüş olan butonların değerlerini ve renklerini değiştiriyor.
    private void setNumberZero(SimpleButton simpleButton1) {
        simpleButton1.setNumber(0);
        simpleButton1.setNumberFont();
        Notification.show("Öldürüldü!");
    }
    //Tıkladığımız zaman yaşayan butonları gösterir.
    private void setNumberOne(SimpleButton simpleButton1) {
        Notification.show("Yaşıyor!");
        simpleButton1.setNumber(1);
        simpleButton1.setNumberFont();
    }
}