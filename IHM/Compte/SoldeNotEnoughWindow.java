package StoreManagement.IHM.Compte;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SoldeNotEnoughWindow {

    GridPane grid = new GridPane();

    private Stage window = new Stage();

    private VBox root = new VBox(10);
    private HBox buttonHbox = new HBox();

    private Scene scene = new Scene(root);

    private Label messageLabel;


    private Button okButton = new Button("OK");

    private void addNodesToWindow(){
        grid.add(messageLabel,0,0);

        buttonHbox.getChildren().add(okButton);

        root.getChildren().addAll(grid,buttonHbox);
    }

    private void addStylesToNodes(){
        grid.setVgap(10);
        grid.setHgap(10);
        okButton.setStyle("-fx-background-color: gray; -fx-text-fill: white");
        root.setMargin(grid,new Insets(30,10,10,10));
        buttonHbox.setStyle("-fx-alignment: center");
        grid.setAlignment(Pos.CENTER);
    }


    private void addEvents(){
        okButton.setOnAction(e -> {
            window.close();
        });
    }

    private void initWindow(){
        window.setMinWidth(500);
        window.setMinHeight(200);
    }



    public SoldeNotEnoughWindow() {
        messageLabel=new Label("Votre solde n'esp pas suffisant pour effectuer cette opération");
        initWindow();
        addStylesToNodes();
        addNodesToWindow();
        addEvents();
        window.setScene(scene);
        window.show();
    }
}
