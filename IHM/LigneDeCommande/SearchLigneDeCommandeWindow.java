package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.IHM.LigneDeCommande.ListLigneDeCommandeWindow;
import StoreManagement.IHM.LigneDeCommande.SearchLigneDeCommandeHandler;
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

public class SearchLigneDeCommandeWindow {
    private Stage window=new Stage();
    private BorderPane root=new BorderPane();
    private Scene scene=new Scene(root);
    private HBox hbox=new HBox(10);
    private Label idLabel=new Label("Id : ");
    private TextField idTextField=new TextField();
    private Button okButton=new Button("OK");
    ListLigneDeCommandeWindow listLigneDeCommandeWindow=null;


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
            new SearchLigneDeCommandeHandler(Long.valueOf(idTextField.getText()),listLigneDeCommandeWindow);
            window.close();

        });
    }

    private void initiWindow(){
        window.setWidth(400);
        window.setHeight(100);
        window.setTitle("Chercher client");
        window.getIcons().add(new Image("file:icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public SearchLigneDeCommandeWindow(ListLigneDeCommandeWindow listLigneDeCommandesWindow){
        this.listLigneDeCommandeWindow=listLigneDeCommandesWindow;
        initiWindow();
        addNodesToPane();
        addEventsToNodes();
        addStylesToNodes();
        window.show();
    }
}
