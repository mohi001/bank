package Client.Menu;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class TransferS extends Scene {
    private static final VBox root = new VBox();

    public TransferS(Stage stage) throws FileNotFoundException {
        super(root, 900, 700);
    }
}