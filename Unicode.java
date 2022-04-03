package encryptdecrypt;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

class Unicode implements AlgorithmChoice {

    @Override
    public String encrypt(Command command) {
        ArrayList<Character> temp = command.getSource();
        for (int i = 0; i < temp.size(); i++) {
            temp.set(i, shiftChar(temp.get(i), command.getKey(), true));
        }
        return temp.stream().map(Objects::toString)
                .collect(Collectors.joining());
    }

    @Override
    public String decrypt(Command command) {
        ArrayList<Character> temp = command.getSource();
        for (int i = 0; i < temp.size(); i++) {
            temp.set(i, shiftChar(temp.get(i), command.getKey(), false));
        }
        return temp.stream().map(Objects::toString)
                .collect(Collectors.joining());
    }

    private char shiftChar(char ch, int shift, boolean isEnc) {
        if (isEnc) {
            return (char) (ch + shift);
        } else {
            return (char) (ch - shift);
        }
    }
}
