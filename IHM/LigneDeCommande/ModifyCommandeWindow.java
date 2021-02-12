package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Vente.LigneDeCommande;
import StoreManagement.IHM.Client.ListClientWindow;
import StoreManagement.IHM.Client.ModifyClientHandler;
import StoreManagement.IHM.Vente.FormVenteWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModifyCommandeWindow {

        LigneDeCommande ligneDeCommande = null;
        FormVenteWindow formVenteWindow = null;

        private Stage window=new Stage();
        private GridPane quantite=new GridPane();
        private VBox root=new VBox(20);
        private Scene scene=new Scene(root);
        /*private HBox idHBox=new HBox(20);
        private HBox prenomHBox=new HBox(20);
        private HBox nomHBox=new HBox(20);
        private HBox telHBox=new HBox(20);
        private HBox adresseHBox=new HBox(20);
        private HBox emailHBox=new HBox(20);
        private HBox dateHBox=new HBox(20);
        */private HBox buttonsHBox=new HBox(20);/*
        private Label codeLabel=new Label("Code : ");
        private Label telLabel=new Label("Téléphone : ");
        private Label nomLabel=new Label("Nom : ");
        private Label prenomLabel=new Label("Prenom : ");
        private Label emailLabel=new Label("Email : ");
        private Label adresseLabel=new Label("Adresse : ");
        private TextField idTextField=new TextField();
        private TextField nomTextField=new TextField();
        private TextField prenomTextField=new TextField();
        private TextField telTextField=new TextField();
        private TextField adresseTextField=new TextField();
        private TextField emailTextField=new TextField();
        private Button validerButton=new Button("Valider");
        private Button annulerButton=new Button("Annuler");
        ListClientWindow listClientWindow = null;
        private long code = 0;*/

        Label quantiteLabel = new Label("Quantite : ");
        TextField quantiteInput = new TextField();
        Button plusQuantiteButton = new Button("˄");
        Button moinsQuantiteButton = new Button("˅");
        Button confirmereButton = new Button("Confirmer");
        Button annulerButton = new Button("Annuler");


        private void addNodesToPane(){
            /*nomHBox.getChildren().addAll(nomLabel,nomTextField);
            prenomHBox.getChildren().addAll(prenomLabel,prenomTextField);
            telHBox.getChildren().addAll(telLabel,telTextField);
            adresseHBox.getChildren().addAll(adresseLabel,adresseTextField);
            emailHBox.getChildren().addAll(emailLabel,emailTextField);
            buttonsHBox.getChildren().addAll(validerButton,annulerButton);
            vBox.getChildren().addAll(idHBox,nomHBox, prenomHBox, telHBox, emailHBox, adresseHBox, buttonsHBox);
            quantite.setCenter(vBox);*/
            quantite.setPadding(new Insets(10,10,10,10));
            quantite.add(quantiteLabel,0,0,1,2);
            quantite.add(quantiteInput,1,0,1,2);
            quantite.add(plusQuantiteButton,2,0);
            quantite.add(moinsQuantiteButton,2,1);
            buttonsHBox.getChildren().addAll(confirmereButton,annulerButton);
            root.getChildren().addAll(quantite,buttonsHBox);
        }

        private void addStylesToNodes(){
            plusQuantiteButton.setMinHeight(plusQuantiteButton.getMinWidth()/2);
            moinsQuantiteButton.setMinHeight(moinsQuantiteButton.getMinWidth()/2);
            quantiteInput.setMinHeight(quantiteInput.getMinHeight()+50);
            quantiteInput.setMinWidth(20);
            quantite.setVgap(2);
            quantite.setHgap(10);
            buttonsHBox.setStyle("-fx-alignment: center");
        }

        private void addEventsToNodes(){
            plusQuantiteButton.setOnAction(e->{
                quantiteInput.setText(String.valueOf(Integer.valueOf(quantiteInput.getText())+1));
            });
            moinsQuantiteButton.setOnAction(e->{
                if(Integer.valueOf(quantiteInput.getText())>1)
                    quantiteInput.setText(String.valueOf(Integer.valueOf(quantiteInput.getText())-1));
            });

            confirmereButton.setOnAction(e->{
                ligneDeCommande.setQte(Integer.valueOf(quantiteInput.getText()));
                formVenteWindow.updateCommandeColmuns();
                formVenteWindow.addCommandeColumnsToTableView(formVenteWindow.commandeObservableList);
                window.close();
            });
            annulerButton.setOnAction(e->{
               window.close();
            });
        }

        private void initiWindow(){
            window.setWidth(400);
            window.setHeight(200);
            window.setTitle("Modifier Commande");
            window.getIcons().add(new Image("icone.png"));
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
        }

        public ModifyCommandeWindow(LigneDeCommande ligneDeCommande, FormVenteWindow formVenteWindow) {
            this.formVenteWindow = formVenteWindow;
            this.ligneDeCommande = ligneDeCommande;
            initiWindow();
            addNodesToPane();
            addEventsToNodes();
            addStylesToNodes();
            quantiteInput.setText(String.valueOf(ligneDeCommande.getQte()));
            window.show();
        }
}
