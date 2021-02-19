package StoreManagement.IHM.Compte;

import StoreManagement.IHM.Compte.VerifyCompteHandler;
import StoreManagement.IHM.Paiement.FormPaiementWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.Socket;

public class FormPaiementCardWindow {

    boolean enoughSolde;
    boolean compteExist;
    boolean validerClicked = false;
    FormPaiementWindow formPaiementWindow = null;

    private Stage window = new Stage();

    private VBox root = new VBox(10);
    private GridPane inputsGrid = new GridPane();
    private HBox buttonHbox = new HBox();

    private Scene scene = new Scene(root);

    private Label numeroLabel=new Label("Numéro : ");
    private Label montantLabel=new Label("Montant : ");

    private TextField numeroInput = new TextField();
    private TextField montantInput = new TextField();

    private Button validerButton = new Button("Valider");

    public boolean isValiderClicked() {
        return validerClicked;
    }

    public Stage getWindow() {
        return window;
    }

    public TextField getMontantInput() {
        return montantInput;
    }

    public Button getValiderButton() {
        return validerButton;
    }

    private void addNodesToWindow(){
        inputsGrid.add(numeroLabel,0,0);
        inputsGrid.add(numeroInput,1,0);
        inputsGrid.add(montantLabel,0,1);
        inputsGrid.add(montantInput,1,1);

        buttonHbox.getChildren().add(validerButton);

        root.getChildren().addAll(inputsGrid,buttonHbox);
    }

    private void addStylesToNodes(){
        inputsGrid.setVgap(10);
        inputsGrid.setHgap(10);
        validerButton.setStyle("-fx-background-color: gray; -fx-text-fill: white");
        root.setMargin(inputsGrid,new Insets(30,10,10,10));
        buttonHbox.setStyle("-fx-alignment: center");
        inputsGrid.setAlignment(Pos.CENTER);
    }

    private void verifyCompte(){
        new VerifyCompteHandler(numeroInput.getText()+"/"+montantInput.getText(),this);
    }

    private void addEvents(){
        validerButton.setOnAction(e -> {
            validerClicked = true;
            verifyCompte();
            if(!compteExist)
                new CompteDoesntExistWindow(numeroInput.getText());
            else{
                if(!enoughSolde) {
                    new SoldeNotEnoughWindow();
                }
                else {
                    formPaiementWindow.getMontantInput().setText(formPaiementWindow.getMontantInput().getText());
                    formPaiementWindow.addPaiementLine();
                    window.close();
                }
            }
        });
    }

    private void initWindow(){
        window.setMinWidth(400);
        window.setMinHeight(300);
        window.setTitle("Créer un montant");
    }

    public FormPaiementCardWindow(String montant, FormPaiementWindow formPaiementWindow){
        this.formPaiementWindow = formPaiementWindow;
        initWindow();
        montantInput.setText(montant);
        addStylesToNodes();
        addNodesToWindow();
        addEvents();
        window.setScene(scene);
        window.show();
    }
}
