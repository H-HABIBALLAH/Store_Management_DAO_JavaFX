package StoreManagement.IHM.Produit;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SearchProduitWindow {
    private Stage window=new Stage();
    private BorderPane root=new BorderPane();
    private Scene scene=new Scene(root);
    private HBox hbox=new HBox(10);
    private Label idLabel=new Label("Désignation : ");
    private TextField idTextField=new TextField();
    private Button okButton=new Button("OK");
    ListProduitWindow listProduitWindow=null;


    private void addNodesToPane(){
        hbox.getChildren().addAll(idLabel,idTextField,okButton);
        root.setCenter(hbox);
    }

    private void addStylesToNodes(){
        hbox.setPadding(new Insets(10));
        idTextField.setMaxWidth(200);
    }

    private void addEventsToNodes(){
        okButton.setOnAction(e->{
            new SearchProduitHandler(idTextField.getText(),listProduitWindow);
            window.close();

        });
    }

    private void initiWindow(){
        window.setWidth(400);
        window.setHeight(100);
        window.setTitle("Chercher");
        window.getIcons().add(new Image("file:icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public SearchProduitWindow(ListProduitWindow listProduitsWindow){
        listProduitWindow=listProduitsWindow;
        initiWindow();
        addNodesToPane();
        addEventsToNodes();
        addStylesToNodes();
        window.show();
    }
}
