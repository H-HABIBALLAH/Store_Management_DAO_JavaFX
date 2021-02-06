package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ListProduitWindow {


    Stage window = new Stage();
    private VBox root=new VBox();
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des produits");
    TableView<Produit> table = new TableView<>();;
    TableColumn<Produit,Long> idColumn=new TableColumn<>("Id");
    TableColumn<Produit,String> designationColumn=new TableColumn<>("Designation");
    TableColumn<Produit,Double> prixAchatColumn=new TableColumn<>("prixAchat");
    TableColumn<Produit,Integer> quantiteColumn=new TableColumn<>("Quantité");
    TableColumn<Produit, Double> prixVenteColumn=new TableColumn<>("prixVente");
    TableColumn<Produit,String> categorieColumn=new TableColumn<>("Catégorie");
    ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();

    ListProduitsHandler produitsListHandler = new ListProduitsHandler(this);

    Button deleteButton = new Button("Delete");
    Button deleteAllButton = new Button("Delete all");
    Button modifyButton = new Button("Modify");
    Button searchButton = new Button("Search");
    Button refreshButton = new Button("Refresh");
    HBox buttonsHBox=new HBox(40);
    HBox buttonsHBoxParent=new HBox();

    Produit rowClicked = null;




    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        titleLabel.getStyleClass().add("sceneTitle");
        titleLabel.setMinWidth(window.getWidth());
        buttonsHBoxParent.getStyleClass().add("btnHbox");
        table.getStyleClass().add("table-row-cell");
        buttonsHBoxParent.setMargin(buttonsHBox,new Insets(20,0,0,0));
        table.setMinHeight(500);
        modifyButton.getStyleClass().add("btn");
        searchButton.getStyleClass().add("btn");
        refreshButton.getStyleClass().add("btn");
        deleteAllButton.getStyleClass().add("btn");
        deleteButton.getStyleClass().add("btn");

    }

    private void addNodesToPane(){
        buttonsHBox.getChildren().addAll(deleteButton,deleteAllButton,modifyButton,searchButton,refreshButton);
        buttonsHBoxParent.getChildren().add(buttonsHBox);
        root.getChildren().addAll(titleLabel,table,buttonsHBoxParent);
    }

    private void addEvents(){
        deleteButton.setOnAction(e->{
            if(rowClicked != null)
                new DeleteProduitHandler(String.valueOf(rowClicked.getId()),this);
        });
        deleteAllButton.setOnAction(e->{
            new DeleteAllProduitHandler(this);
        });
        modifyButton.setOnAction(e->{
            new ModifyProduitWindow(this);
        });
        searchButton.setOnAction(e->{
            new SearchProduitWindow(this);
        });
        refreshButton.setOnAction(e->{
            new RefreshProduitHandler(this);
        });
        table.setOnMouseClicked((MouseEvent event) -> {
            rowClicked = table.getSelectionModel().getSelectedItem();
        });
    }


    private void initiWindow(){
        window.setWidth(1100);
        window.setHeight(750);
        window.setTitle("Liste des produits");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }


     void updateColmuns(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        idColumn.setPrefWidth(100);

        designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
        designationColumn.setPrefWidth(250);

        prixAchatColumn.setCellValueFactory(new PropertyValueFactory("prixAchat"));
        prixAchatColumn.setPrefWidth(150);

        quantiteColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantiteColumn.setPrefWidth(170);

        prixVenteColumn.setCellValueFactory(new PropertyValueFactory("prixVente"));
        prixVenteColumn.setPrefWidth(200);

        categorieColumn.setCellValueFactory(new PropertyValueFactory("intituleCategorie"));
        categorieColumn.setPrefWidth(200);
    }

    void addColumnsToTableView(ObservableList productsObservableList){
        table.getColumns().addAll(idColumn,designationColumn,prixAchatColumn,prixVenteColumn,quantiteColumn,categorieColumn);
        table.setItems(productsObservableList);
    }



    public ListProduitWindow(){
        initiWindow();
        addStylesToNodes();
        updateColmuns();
        addColumnsToTableView(productsObservableList);
        produitsListHandler.updateProduitsListWIndow();
        addNodesToPane();
        addEvents();
        window.show();
    }
}
