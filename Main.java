package StoreManagement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application{
    BorderPane root=new BorderPane();
    Scene scene=new Scene(root);

    MenuItem nouveauProduitMenuItem=new MenuItem("Nouveau");
    MenuItem listeProduitsMenuItem=new MenuItem("Liste");

    MenuItem nouveauClientMenuItem=new MenuItem("Nouveau");
    MenuItem listeClientsMenuItem=new MenuItem("Liste");

    MenuItem helpMenuItem=new MenuItem("?");

    private void addEventsMenuItems(){
        nouveauProduitMenuItem.setOnAction(e -> {
            new FormProduitWindow();
        });
        listeProduitsMenuItem.setOnAction(e -> {
            new ListProduitWindow();
        });
        nouveauClientMenuItem.setOnAction(e -> {
            System.out.println("new product clicked");
        });
        listeClientsMenuItem.setOnAction(e -> {
            System.out.println("new product clicked");
        });
        helpMenuItem.setOnAction(e -> {
            System.out.println("new product clicked");
        });
    }

    private void addStylesToNodes(){
       root.getStyleClass().add("mainWindow");
       scene.getStylesheets().add("/StoreManagement/style.css");
    }

    private void createMenu(){
        MenuBar menuBar=new MenuBar();

        Menu produitsMenu = new Menu("Produits");
        Menu clientsMenu = new Menu("Clients");
        Menu ventesMenu = new Menu("Ventes");
        Menu paiementsMenu = new Menu("Paiements");
        Menu inventaireMenu = new Menu("Inventaire");
        Menu helpMenu = new Menu("Help");

        produitsMenu.getItems().addAll(nouveauProduitMenuItem,listeProduitsMenuItem);
        clientsMenu.getItems().addAll(nouveauClientMenuItem,listeClientsMenuItem);
        helpMenu.getItems().addAll(helpMenuItem);

        menuBar.getMenus().addAll(produitsMenu,clientsMenu,ventesMenu,paiementsMenu,inventaireMenu,helpMenu);

        root.setTop(menuBar);
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        createMenu();
        addEventsMenuItems();
        addStylesToNodes();
        window.setScene(scene);
        window.setWidth(1300);
        window.setHeight(800);
        window.show();
    }
}
