package com.example.demotestfx3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class HelloApplicationTestFXMLNuevaVentana {
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
    void al_pulsar_boton_se_abre_una_nueva_ventana(FxRobot robot) {

        robot.clickOn("#btnDatos");
        robot.sleep(1000);
        FxAssert.verifyThat(robot.window("Nueva ventana"), WindowMatchers.isShowing());
        robot.targetWindow("Nueva ventana");
        FxAssert.verifyThat("#lblText", LabeledMatchers.hasText("Nueva ventana"));

    }

}