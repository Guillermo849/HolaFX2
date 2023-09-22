/*
 * Esta clase mostrará una ventana con dos circulos.
 *   Uno tendra un Controlador de Eventos de Ratón, que lo que hará será 
 *   que aparezca un mensaje en consola, diciendo que se ha llamado al Evento.
 * 
 * */
package application;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EventHandlerProperties extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
    	
    	// Creamos un Circulo que cuando lo clickes muestre en la consola un mensaje
        Circle crcFuncional = new Circle(100, 100, 50);
        crcFuncional.setFill(Color.CORAL);
        // Creamos un Controlador de Eventos del Ratón
        EventHandler<MouseEvent> eventHandler = e -> 
            System.out.println("Se ha llamado al evento del ratón.");
        // Le añadimos el Controlador de Eventos al circulo
        crcFuncional.setOnMouseClicked(eventHandler);
        
        // Creamos otro circulo sin funcion
        Circle crcNoFuncional = new Circle(100, 100, 50);
        crcNoFuncional.setFill(Color.AQUAMARINE);
        
        HBox root = new HBox();
        root.getChildren().addAll(crcFuncional, crcNoFuncional);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Uso de propiedades convenientes del controlador de eventos");
        stage.sizeToScene();
        stage.show();
    }
}
