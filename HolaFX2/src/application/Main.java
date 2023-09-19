package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Creacion del VBox
			VBox caja = new VBox();
			
//			BorderPane root = new BorderPane();
			Scene scene = new Scene(caja,400,400);
			
			//Titulo de la ventana principal
			primaryStage.setTitle("Ejercicio A");
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//Mensaje de Texto
			Text mensaje = new Text("Este mensaje está dentro de un VBox");
			
			//Añadir el texto al VBox
			caja.getChildren().add(mensaje);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
