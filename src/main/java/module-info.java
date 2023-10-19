module com.fre.npsfxmaven {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.fre.npsfxmaven to javafx.fxml;
    exports com.fre.npsfxmaven;
    exports com.fre.npsfxmaven.controller;
    opens com.fre.npsfxmaven.controller to javafx.fxml;
    exports com.fre.npsfxmaven.model;
    opens com.fre.npsfxmaven.model to javafx.fxml;
    exports com.fre.npsfxmaven.util;
    opens com.fre.npsfxmaven.util to javafx.fxml;
}