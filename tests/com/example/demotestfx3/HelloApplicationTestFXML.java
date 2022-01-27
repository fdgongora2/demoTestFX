package com.example.demotestfx3;

import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class HelloApplicationTestFXML {
    Pane mainroot;
    Stage mainstage;

    @Start
    public void start(Stage stage) throws IOException {
        mainroot = (Pane) FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        mainstage = stage;
        stage.setScene(new Scene(mainroot));
        stage.show();
        stage.toFront();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void when_button_is_clicked_text_changes(FxRobot robot) {

        FxAssert.verifyThat("#boton", LabeledMatchers.hasText("Hello!"));

    }

}