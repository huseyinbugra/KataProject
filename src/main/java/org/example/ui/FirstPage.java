package org.example.ui;

import com.vaadin.ui.*;
import org.example.button.CreateButton;

public class FirstPage extends HorizontalLayout {

    private FormLayout layout = new FormLayout();
    private CreateButton createButton;
    private TextField row;
    private TextField column;
    private int rowInt;
    private int columnInt;


    public FirstPage() {
        setMargin(true);
        setSpacing(true);

        addComponent(layout);

        TextField row = new TextField("Satır Sayısı");
        layout.addComponent(row);

        column = new TextField("Sütun Sayısı");
        layout.addComponent(column);

        createButton = new CreateButton();
        createButton.setCaption("OK");
        createButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                rowInt = Integer.parseInt(row.getValue());
                columnInt = Integer.parseInt(column.getValue());
                if(rowInt>0 && columnInt>0) {
                    Main main = new Main(rowInt, columnInt);
                    removeAllComponents();
                    addComponent(main);
                }
                else{
                    Notification.show("Hatalı sayı girdiniz. Lütfen Tekrar deneyin.");
                }
            }
        });
        layout.addComponent(createButton);
    }
}
