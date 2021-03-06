package StoreManagement.IHM.Client;

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

public class DeleteClientWindow {
    private Stage window=new Stage();
    private BorderPane root=new BorderPane();
    private Scene scene=new Scene(root);
    private HBox hbox=new HBox(10);
    private Label codeLabel=new Label("code : ");
    private TextField codeTextField=new TextField();
    private Button okButton=new Button("OK");
    ListClientWindow listClientWindow =null;


    private void addNodesToPane(){
        hbox.getChildren().addAll(codeLabel,codeTextField,okButton);
        root.setCenter(hbox);
    }

    private void addStylesToNodes(){
        hbox.setPadding(new Insets(10));
        codeTextField.setMaxWidth(50);
    }

    private void addEventsToNodes(){
        okButton.setOnAction(e->{
            new DeleteClientHandler(codeTextField.getText(), listClientWindow);
            window.close();
        });
    }

    private void initiWindow(){
        window.setWidth(220);
        window.setHeight(100);
        window.getIcons().add(new Image("icone.png"));
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
