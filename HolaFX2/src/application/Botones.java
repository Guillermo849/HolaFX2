package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Titulo de la ventana
			primaryStage.setTitle("Hola y Adios");
			
			//VBox donde guardaremos los Objetos
			VBox root = new VBox();
			
			//Crear escena y añadir el Vbox a está
			Scene scene = new Scene(root, 300, 200);
			
			//Label donde aparecera el mensaje
			Label msg = new Label("");
			
			//Boton Hola
			Button btHola = new Button("Hola");
			
			//Añadimos la accion al btHola que cuando lo pulses cambiara el mensaje msg a Hola
			btHola.setOnAction(e -> {
				msg.setText("Hola");
			});
			
			//Boton Adios
			Button btAdios = new Button("Adios");
			
			//Añadimos la accion al btAdios que cuando lo pulses cambiara el mensaje msg a Adios
			btAdios.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					msg.setText("Adios");
				}
			});
			
			//Añadimos los objetos al VB
			root.getChildren().addAll(msg, btHola, btAdios);
			
			//
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
