package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DetallesDelUsuario extends Application{
	public static void main(String[] args) {
        Application.launch(args);
    }
	
	/*
	 * Stage con los siguientes objetos:
	 *   1.- btnAbrirURL: Boton que abre en el navegador la URL que tiene el String
	 *   2.- enseniarAlerta: Boton que al pulsarlo emplea el metodo showAlert (este está explicado más adelante).
	 * */
    public void start(Stage escenario) {
        String yahooURL = "http://www.yahoo.com";
        // 1 
        Button btnAbrirURL = new Button("Ir a Yahoo!");
        btnAbrirURL.setOnAction(e -> getHostServices().showDocument(yahooURL));
        // 2
        Button enseniarAlerta = new Button("Show Alert");
        enseniarAlerta.setOnAction(e -> showAlert());
        // Creamos el contenedor donde se guardaran los botones y la informacion de anfitrión
        VBox root = new VBox();
        root.getChildren().addAll(btnAbrirURL, enseniarAlerta);
        Map<String, String> detallesAnfitrion = getHostDetails();
        // Muestra la informacion obtenida del metodo getHostDetails (este está explicado más adelante).
        for (Map.Entry<String, String> entry : detallesAnfitrion.entrySet()) {
            String desc = entry.getKey() + ": " + entry.getValue();
            root.getChildren().add(new Label(desc));
        }
        
        // Creamos la Scene
        Scene scene = new Scene(root);
        escenario.setScene(scene);
        escenario.setTitle("Conociendo al anfitrion");
        escenario.show();
    }
    
    /*
	 * Este Metodo implementa los siguientes metodos de HostServices:
	 *   1.- getCodeBase(): Directorio donde se localiza el archivo JAR para lanzar el programa
	 *   2.- getDocumentBase(): Directorio actual cuando se lanza el programa.
	 *   3.- resolveURI(): Con los parametros que le pasamos te devuelve un URI absoluto
	 * */
    protected Map<String, String> getHostDetails() {
        Map<String, String> mapa = new HashMap<>();
        HostServices anfitrion = getHostServices();
        // 1
        String codigoBase = anfitrion.getCodeBase();
        mapa.put("CodeBase", codigoBase);
        // 2
        String baseDocumento = anfitrion.getDocumentBase();
        mapa.put("DocumentBase", baseDocumento);
        // 3
        String splashImagenURI = anfitrion.resolveURI(baseDocumento, "splash.jpg");
        mapa.put("Splash Image URI", splashImagenURI);
        return mapa;
    }
    
    // Metodo que habré una Stage con una alerta que bloquea la anterior Stage hasta que está se cierre
    protected void showAlert() {
        Stage escenario = new Stage(StageStyle.UTILITY);
        escenario.initModality(Modality.APPLICATION_MODAL);
        Label lblMensaje = new Label("¡Eso es un aviso FX!");
        Group root = new Group(lblMensaje);
        Scene escena = new Scene(root);
        escenario.setScene(escena);
        escenario.setTitle("Alerta FX");
        escenario.show();
    }
}
