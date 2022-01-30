# demoTestFX

Ejemplo de uso de la librería TestFX para realizar pruebas E2E en un proyecto Maven. 

El principal problema para conseguir ejecutar los tests es configurar las librerías necesarias. Partiendo de un proyecto JavaFX existente hay que añadir al fichero POM:

1. Las librerías. (En nuestro caso se usa Junit 5. En caso contrario habría que cambiarlo.)

         <dependency>
            <groupId>org.testfx</groupId>
            <artifactId>testfx-core</artifactId>
            <version>4.0.16-alpha</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testfx</groupId>
            <artifactId>testfx-junit5</artifactId>
            <version>4.0.16-alpha</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.1</version>
            <scope>test</scope>
        </dependency>

Con mi configuración ha sido necesario el añadir una opción para la ejecución de los test utilizando el plugin Surefire. En caso de no hacerlo se produce un error al ejecutar el test.

             <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
                <configuration>
                    <argLine>
                        --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED
                    </argLine>
                </configuration>
            </plugin>
