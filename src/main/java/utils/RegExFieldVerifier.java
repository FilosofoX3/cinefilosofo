package utils;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExFieldVerifier extends InputVerifier {
    Pattern pattern;

    public RegExFieldVerifier(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean verify(JComponent input) {
        if (input instanceof JFormattedTextField) {
            JFormattedTextField ftf = (JFormattedTextField)input;
            String line = ftf.getText();
            Matcher m = pattern.matcher(line);
            if (!m.matches())
                System.out.println("Doesn't match regular expression " +
                        pattern.pattern());
            return m.matches();
        }
        return true;
    }

    public boolean shouldYieldFocus(JComponent input) {
        return verify(input);
    }
}
