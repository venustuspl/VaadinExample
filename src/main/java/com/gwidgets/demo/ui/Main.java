package com.gwidgets.demo.ui;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.vaadin.ui.themes.ValoTheme.BUTTON_LINK;
import static com.vaadin.ui.themes.ValoTheme.MENU_ITEM;

@SpringUI(path="app")
@StyleSheet({"http://localhost:8080/styles.css"})
public class Main extends UI {

    @Autowired
    Add addView;

    @Autowired
    List listView;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout rootLayout = new HorizontalLayout();
        rootLayout.setSizeFull();
        HorizontalLayout mainarea = new HorizontalLayout();
        mainarea.setWidth("80%");
        Navigator navigator = new Navigator(this, mainarea);
        navigator.addView("", addView);
        navigator.addView("add", addView);
        navigator.addView("list", listView);

        CssLayout sideNav = new CssLayout();
        sideNav.setSizeFull();
        sideNav.addStyleName("sidenav");
        sideNav.setId("sideNav");
        sideNav.setWidth("20%");

        Button link1 = new Button("Add", e -> navigator.navigateTo("add"));
        link1.addStyleNames(BUTTON_LINK, MENU_ITEM);
        Button link2 = new Button("List", e -> navigator.navigateTo("list"));
        link2.addStyleNames(BUTTON_LINK, MENU_ITEM);
        sideNav.addComponent(link1);
        sideNav.addComponent(link2);
        rootLayout.addComponent(sideNav);
        rootLayout.addComponent(mainarea);
        setContent(rootLayout);
    }
}
