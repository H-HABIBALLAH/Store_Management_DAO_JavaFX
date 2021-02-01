package StoreManagement.IHM.Catégorie;

import StoreManagement.DAO.Catégorie.Categorie;
import StoreManagement.IHM.Produit.DeleteAllProduitHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CategorieWindow {
    private Stage window=new Stage();
    private BorderPane root=new BorderPane();
    private Scene scene=new Scene(root);
    VBox vBox =new VBox(20);
    HBox hBox =new HBox();
    Button validateButton = new Button("Validate");
    Categorie categorie = null;

    final ToggleGroup toggleGroup = new ToggleGroup();

    RadioButton rb1 = new RadioButton("TV");

    RadioButton rb2 = new RadioButton("Computer");

    RadioButton rb3 = new RadioButton("Mobile phone");

    private void addNodesToPane(){
        hBox.getChildren().add(validateButton);
        vBox.getChildren().addAll(rb1, rb2, rb3, hBox);
        root.setCenter(vBox);
    }

    private void addStylesToNodes(){
        vBox.setPadding(new Insets(20));
        hBox.getStyleClass().add("btnHbox");
    }

    private void addEventsToNodes(){
        rb1.setToggleGroup(toggleGroup);
        rb1.setSelected(true);
        rb2.setToggleGroup(toggleGroup);
        rb3.setToggleGroup(toggleGroup);
        validateButton.setOnAction(e->{
            categorie.setIntitule(((RadioButton)toggleGroup.getSelectedToggle()).getText());
            window.close();
        });
        rb1.setSelected(true);
    }

    private void initiWindow(){
        window.setWidth(300);
        window.setHeight(250);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public CategorieWindow(Categorie categorie){
        this.categorie = categorie;
        initiWindow();
        addStylesToNodes();
        addNodesToPane();
        addEventsToNodes();
        window.show();
    }

}
