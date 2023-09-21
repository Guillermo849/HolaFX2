package application;
	
import javafx.geometry.Rectangle2D;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class PantallaFX extends Application {
	
	public static void main(String[] args) {
        Application.launch(args);
    }

	// Aqui veremos la informacion de cada pantalla conectada a nuestro ordenador
	@Override
	public void start(Stage escenario) {
		
		ObservableList<Screen> screenList = Screen.getScreens();
		System.out.println("Screen Count: " + screenList.size());
		for (Screen screen : screenList) {
			print(screen);
		}
		Platform.exit();
	}
	
	/* 
	 * Metodo para poder mostrar la informacion de cada pantalla:
	 * 	DIP (pixeles por pulgadas)
	 * 	Tamaño de la pantalla
	 * 	Tamaño visible de la pantalla
	 */
	public void print(Screen pantalla) {
		
		System.out.println("DPI: " + pantalla.getDpi());
		
		System.out.print("Screen Bounds: ");
		Rectangle2D bounds = pantalla.getBounds();
		print(bounds);
		
		System.out.println("Screen Visual Bounds: ");
		Rectangle2D visualBounds = pantalla.getVisualBounds();
		print(visualBounds);
		
		System.out.println("----------------------------------");
	}
	
	// Metodo que obtine la altura y anchura de la pantalla
	public void print(Rectangle2D r) {
		System.out.format("minX=%.2f, minY=%.2f, width=%.2f, height=%.2f%n", r.getMinX(), r.getMinY(), 
				r.getWidth(), r.getHeight());
	}
}
