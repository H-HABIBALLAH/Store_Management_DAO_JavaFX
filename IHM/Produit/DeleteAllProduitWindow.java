package StoreManagement.IHM.Produit;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteAllProduitWindow {

        private Stage window=new Stage();
        private BorderPane root=new BorderPane();
        private Scene scene=new Scene(root);
        private VBox vBox=new VBox(20);
        private HBox buttonHBox=new HBox(20);
        private Label questionLabel=new Label("Voulez-vous vraiment supprimer tous les produits ?");
        private HBox questionHBox=new HBox();
        private Button ouiButton=new Button("OUI");
        private Button nonButton=new Button("NON");
        ListProduitWindow listProduitWindow=null;


        private void addNodesToPane(){
            questionHBox.getChildren().add(questionLabel);
            buttonHBox.getChildren().addAll(ouiButton,nonButton);
            vBox.getChildren().addAll(questionHBox,buttonHBox);
            root.setCenter(vBox);
        }

        private void addStylesToNodes(){
            vBox.setPadding(new Insets(20));
            buttonHBox.getStyleClass().add("btnHbox");
            questionHBox.getStyleClass().add("centerLabel");
            scene.getStylesheets().add("/StoreManagement/style.css");
        }

        private void addEventsToNodes(){
            window.setOnCloseRequest(e->{
                e.consume();
            });
            ouiButton.setOnAction(e->{
                new DeleteAllProduitHandler(listProduitWindow);
                window.close();
            });
            nonButton.setOnAction(e->{
                window.close();
            });
        }

        private void initiWindow(){
            window.setWidth(500);
            window.setHeight(170);
            window.setTitle("Supprimer tous les produits");
            window.getIcons().add(new Image("file:icone.png"));
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
        }

    public DeleteAllProduitWindow(ListProduitWindow listProduitsWindow){
            listProduitWindow=listProduitsWindow;
            initiWindow();
            addNodesToPane();
            addEventsToNodes();
            addStylesToNodes();
            window.show();
        }

}
