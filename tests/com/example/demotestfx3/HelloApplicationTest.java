package com.example.demotestfx3;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.testfx.matcher.control.TextInputControlMatchers;
import org.testfx.matcher.control.TextMatchers;

@ExtendWith(ApplicationExtension.class)
class HelloApplicationTest {

    private Button button;

    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    private void start(Stage stage) {

        HBox horizontalBox = new HBox();

        TextField tfNombre = new TextField();
        tfNombre.setId("tfNombre");

        button = new Button("click me!");
        button.setId("myButton");
        button.setOnAction(actionEvent -> button.setText("clicked!"));

        horizontalBox.getChildren().addAll(tfNombre, button);

        stage.setScene(new Scene(horizontalBox, 500, 100));
        stage.show();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void should_contain_button_with_text(FxRobot robot) {

        //Validaciones con diferentes formas de obtener el componente visual
        FxAssert.verifyThat(button, LabeledMatchers.hasText("click me!"));
        // or (lookup by css id):
        FxAssert.verifyThat("#myButton", LabeledMatchers.hasText("click me!"));
        // or (lookup by css class):
        FxAssert.verifyThat(".button", LabeledMatchers.hasText("click me!"));
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void should_contain_edittext_empty(FxRobot robot) {
        //Validaciones con Node:: (Gracias Levi)
        FxAssert.verifyThat("#tfNombre", Node::isVisible);
        //Validaciones con Matchers de campos TextEdit
        FxAssert.verifyThat("#tfNombre", TextInputControlMatchers.hasText(""));
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void when_button_is_clicked_text_changes(FxRobot robot) {
        // when:
        robot.clickOn(".button");

        // then:
        FxAssert.verifyThat(button, LabeledMatchers.hasText("clicked!"));
        // or (lookup by css id):
        FxAssert.verifyThat("#myButton", LabeledMatchers.hasText("clicked!"));
        // or (lookup by css class):
        FxAssert.verifyThat(".button", LabeledMatchers.hasText("clicked!"));

        FxAssert.verifyThat("#myButton", Node::isVisible);
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void escribimos_EditText_comprobamos_Valor(FxRobot robot) {
        // when:
        robot.clickOn("#tfNombre");
        robot.write("David Góngora");
        //Validaciones con Matchers de el valor escrito
        FxAssert.verifyThat("#tfNombre", TextInputControlMatchers.hasText("David Góngora"));
    }
}