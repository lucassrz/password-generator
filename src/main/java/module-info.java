module fr.lsarazin.passwordmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.lsarazin.passwordmanagement to javafx.fxml;
    exports fr.lsarazin.passwordmanagement;
}