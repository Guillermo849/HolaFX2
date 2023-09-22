// FlowPaneAlignment.java
package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PanelFlow extends Application {
    
	public static void main(String[] args) {
        Application.launch(args);
    }
    
	// Se crean FlowPane que ponga los elementos en distintos sitios
    @Override
    public void start(Stage stage) {
    	FlowPane fpDerechaArriva = crearFlowPane(Pos.TOP_RIGHT);
        FlowPane fpDerechaAbajo = crearFlowPane(Pos.BOTTOM_RIGHT);
        FlowPane fpIzquierdaArriva = crearFlowPane(Pos.TOP_LEFT);
        FlowPane fpIzquierdaAbajo = crearFlowPane(Pos.BOTTOM_LEFT);
        FlowPane fpCentro = crearFlowPane(Pos.CENTER);
        HBox root = new HBox(fpDerechaArriva, fpDerechaAbajo, fpIzquierdaArriva, fpIzquierdaAbajo, fpCentro);
        Scene escena = new Scene(root);
        stage.setScene(escena);
        stage.setTitle("FlowPane Alignment");
        stage.show();
    }
    
    // Se crea un FlowPane con 3 botones dentro
    private FlowPane crearFlowPane(Pos alignment) {
        FlowPane fp = new FlowPane(5, 5);
        fp.setPrefSize(200, 100);
        fp.setAlignment(alignment);
        fp.getChildren().addAll(new Text(alignment.toString()), 
                                new Button("Boton 1"), 
                                new Button("Boton 2"),
                                new Button("Boton 3"));
        // Añadimos un estilo a el FlowPane
        fp.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" + 
                    "-fx-border-radius: 5;" + 
                    "-fx-border-color: blue;");
        return fp;
    }
}
