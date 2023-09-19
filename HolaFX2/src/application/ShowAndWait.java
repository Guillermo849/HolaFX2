package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowAndWait extends Application {
    
	// Variables
	protected static int contador = 0;
    protected Stage ultimaEscenaAbierta;

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    // Escena Inicial con el boton de abrir(2)
    @Override
    public void start(Stage escena) {
        VBox root = new VBox();
        Button btnAbrir = new Button("Open");
        btnAbrir.setOnAction(e -> abrir(++contador));
        root.getChildren().add(btnAbrir);
        Scene scene = new Scene(root, 400, 400);
        escena.setScene(scene);
        escena.setTitle("The Primary Stage");
        escena.show();
        this.ultimaEscenaAbierta = escena;
    }
    
    /*
     * Metodo que abre una nueva escena con los siguientes objetos:
     *   1.- btnDiHola: Siempre que se pulse se mostrará en la 
     *       consola que número de página es.
     *   2.- btnAbrir: Cunado se pulse abrirá una nueva escena.
     * */
    private void abrir(int stageNumber) {
        // Número de escena
    	Stage escena = new Stage();
    	escena.setTitle("#" + stageNumber);
        // 1 Boton Hola
        Button btnDiHola = new Button("Say Hello");
        btnDiHola.setOnAction(e -> System.out.println("Hello from #" + stageNumber));
        // 2 Boton Abrir
        Button btnAbrir = new Button("Open");
        btnAbrir.setOnAction(e -> abrir(++contador));
        // Configura la escena y añadir objetos
        VBox root = new VBox();
        root.getChildren().addAll(btnDiHola, btnAbrir);
        Scene scene = new Scene(root, 200, 200);
        escena.setScene(scene);
        escena.setX(this.ultimaEscenaAbierta.getX() + 50);
        escena.setY(this.ultimaEscenaAbierta.getY() + 50);
        this.ultimaEscenaAbierta = escena;
        System.out.println("Before stage.showAndWait(): " + stageNumber);
        // Muestra una escena y espera a que está se cierre
        escena.showAndWait();
        System.out.println("After stage.showAndWait(): " + stageNumber);
    }
}
