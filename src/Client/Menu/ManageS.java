package Client.Menu;

import Client.InUpField;
import Client.Messenger;
import Client.ValidAble;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageS extends Scene {
    private static final VBox root = new VBox();

    public ManageS(Stage stage, Messenger ms, Scene back) throws IOException {
        super(root, 900, 700);
        root.setSpacing(90);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setBackground(new Background(new BackgroundFill
                (Color.YELLOW, new CornerRadii(1),
                        new Insets(0.0, 0.0, 0.0, 0.0))));
        ChoseAccount choseAccount = new ChoseAccount(ms.send("accounts"));
        InUpField name = new InUpField("src/Client/Resources/cart.png",
                "alias name",
                new ValidAble() {
                    @Override
                    public boolean isValid(String s) {
                        return true;
                    }
                }, "please enter valid code",
                0, 0, false);
        name.setTranslateX(200);
        Label label = new Label("please chose account to change or add alias");
        label.setWrapText(true);
        label.setStyle("-fx-font-size: 30");
        Button add = new Button("add alias");
        add.setMinSize(100, 50);
        add.setTranslateY(-50);
        setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ESCAPE)
            {
                stage.setScene(back);
            }
        });
        add.setOnAction(e -> {
            String answer = "";
            try
            {
                answer = ms.sendNS("MAliasAdd", name.getText(),
                        choseAccount.getAccountNum());
            } catch (IOException ioException)
            {
                ioException.printStackTrace();
            }
            if (answer.equals("true"))
            {
                label.setText("alias added successfully");
            } else
            {
                label.setText("failed to do operation");
            }
        });
        root.getChildren().addAll(label, choseAccount, name, add);
    }
}


