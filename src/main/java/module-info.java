module com.fre.npsfxmaven {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.fre.npsfxmaven to javafx.fxml;
    exports com.fre.npsfxmaven;
}