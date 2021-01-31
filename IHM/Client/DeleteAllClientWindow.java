package StoreManagement.IHM.Client;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteAllClientWindow {

        private Stage window=new Stage();
        private BorderPane root=new BorderPane();
        private Scene scene=new Scene(root);
        private VBox vBox=new VBox(20);
        private HBox buttonHBox=new HBox(20);
        private Label questionLabel=new Label("Voulez-vous vraiment supprimer tous les Clients ?");
        private Button ouiButton=new Button("OUI");
        private Button nonButton=new Button("NON");
        ListClientWindow listClientWindow=null;


        private void addNodesToPane(){
            buttonHBox.getChildren().addAll(ouiButton,nonButton);
            vBox.getChildren().addAll(questionLabel,buttonHBox);
            root.setCenter(vBox);
        }

        private void addStylesToNodes(){
            vBox.setPadding(new Insets(20));
        }

        private void addEventsToNodes(){
            ouiButton.setOnAction(e->{
                new DeleteAllClientHandler(listClientWindow);
            });
            nonButton.setOnAction(e->{
                window.close();
            });
        }

        private void initiWindow(){
            window.setWidth(500);
            window.setHeight(200);
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
        }

    public DeleteAllClientWindow(ListClientWindow listClientsWindow){
            listClientWindow=listClientsWindow;
            initiWindow();
            addNodesToPane();
            addEventsToNodes();
            addStylesToNodes();
            window.show();
        }

}
