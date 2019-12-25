package org.example.button;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class SimpleButton extends Button {

    private int Number;

    public SimpleButton() {
        setWidth(80, Unit.PIXELS);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int setNumberFont(){

        if(this.getNumber()==0){
            setIcon(FontAwesome.MINUS_CIRCLE);
            setWidth(80,Unit.PIXELS);
            addStyleName(ValoTheme.BUTTON_DANGER);
            return 0;
        }

        else if(this.getNumber()==1){
            setIcon(FontAwesome.CHECK_CIRCLE);
            setWidth(80,Unit.PIXELS);
            return 0;
        }

        return -1;
    }
}