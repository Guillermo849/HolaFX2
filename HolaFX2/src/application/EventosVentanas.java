/* Programa para ver como funciona los eventos de ventana*/
package application;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class EventosVentanas extends Application {
    private CheckBox cbxPuedeCerrar;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
    	cbxPuedeCerrar = new CheckBox("Puede Cerrar la Ventana");
        // Boton que cerrará la ventana
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> stage.close());
        // Boton que esconde la ventana y ejecuta el metodo enseniarDialogo
        Button btnEsconder = new Button("Mostrar ventana");
        btnEsconder.setOnAction(e -> {
        	enseniarDialogo(stage);
            stage.hide();
        });
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(cbxPuedeCerrar, btnCerrar, btnEsconder);
        // Añadir a la ventana un manipulador de eventos de ventana 
        stage.setOnShowing(e -> handle(e));
        stage.setOnShown(e -> handle(e));
        stage.setOnHiding(e -> handle(e));
        stage.setOnHidden(e -> handle(e));
        stage.setOnCloseRequest(e -> handle(e));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Window Events");
        stage.show();
    }
    
    // Si el cbxPuedeCerrar no esta seleccionado no se podrá cerrar la ventana excepto por el btnCerrar
    public void handle(WindowEvent e) {
        EventType<WindowEvent> tipo = e.getEventType();
        if (tipo == WINDOW_CLOSE_REQUEST && !cbxPuedeCerrar.isSelected()) {
            e.consume();
        }
        System.out.println(tipo + ": Consumido=" + e.isConsumed());
    }
    
    
    // Habre una ventana con un boton para ver la ventana principal
    public void enseniarDialogo(Stage mainWindow) {
        Stage popup = new Stage();
        Button btnCerrar = new Button("Cliquea para ver la ventana principal");
        btnCerrar.setOnAction(e -> {
            popup.close();
            mainWindow.show();
        });
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(btnCerrar);
        Scene scene = new Scene(root);
        popup.setScene(scene);
        popup.setTitle("Popup");
        popup.show();
    }
}
