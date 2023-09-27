package fr.lsarazin.passwordmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Random;

public class HelloController {

    @FXML
    private CheckBox caps;

    @FXML
    private CheckBox number;

    @FXML
    private CheckBox special;

    @FXML
    private SpinnerValueFactory.IntegerSpinnerValueFactory nbChar;

    @FXML
    private TextField generateText;

    @FXML
    protected void onGenerateButtonClick() {

        boolean capsValue = caps.isSelected();
        boolean numberValue = number.isSelected();
        boolean specialValue = special.isSelected();
        int nbCharValue = nbChar.getValue();

        String password = generatePassword(capsValue, numberValue ,specialValue, nbCharValue);
        generateText.setText(password);
    }

    protected String generatePassword(boolean caps, boolean number, boolean special, int nbChar) {
        String withAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String withCaps = withAlphabet.toUpperCase();
        String withNumber = "1234567890";
        String withSpecial = "*$%&#!?";
        Random rand = new Random();
        if(caps) {
            withAlphabet += withCaps;
        }
        if(number) {
            withAlphabet += withNumber;
        }
        if(special) {
            withAlphabet += withSpecial;
        }

        StringBuilder password = new StringBuilder();
        for(int i = 0; i < nbChar; i++) {
            char letter = withAlphabet.charAt(rand.nextInt(withAlphabet.length()));
            password.append(letter);
        }

        return password.toString();
    }
}