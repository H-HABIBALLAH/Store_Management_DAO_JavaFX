package StoreManagement.IHM.Client;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteClientWindow {
    private Stage window=new Stage();
    private BorderPane root=new BorderPane();
    private Scene scene=new Scene(root);
    private HBox hbox=new HBox(10);
    private Label idLabel=new Label("id : ");
    private TextField idTextField=new TextField();
    private Button okButton=new Button("OK");
    ListClientWindow listClientWindow =null;


    private void addNodesToPane(){
        hbox.getChildren().addAll(idLabel,idTextField,okButton);
        root.setCenter(hbox);
    }

    private void addStylesToNodes(){
        hbox.setPadding(new Insets(10));
        idTextField.setMaxWidth(50);
    }

    private void addEventsToNodes(){
        okButton.setOnAction(e->{
            new DeleteClientHandler(idTextField.getText(), listClientWindow);
            window.close();

        });
    }

    private void initiWindow(){
        window.setWidth(200);
        window.setHeight(100);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public DeleteClientWindow(ListClientWindow listClientsWindow){
        listClientWindow =listClientsWindow;
        initiWindow();
        addNodesToPane();
        addEventsToNodes();
        addStylesToNodes();
        window.show();
    }
}
