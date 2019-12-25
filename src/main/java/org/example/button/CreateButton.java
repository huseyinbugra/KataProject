package org.example.button;

import com.vaadin.ui.themes.ValoTheme;

public class CreateButton extends SimpleButton {

    public CreateButton() {
        setWidth(50, Unit.PIXELS);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }
}