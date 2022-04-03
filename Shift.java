package encryptdecrypt;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

class Shift implements AlgorithmChoice {

    @Override
    public String decrypt(Command command) {
        ArrayList<Character> temp = command.getSource();
        for (int i = 0; i < temp.size(); i++) {
            if (Character.isAlphabetic(temp.get(i))) {
                temp.set(i, shiftChar(temp.get(i), command.getKey(), false));
            }
        }
        return temp.stream().map(Objects::toString)
                .collect(Collectors.joining());
    }

    @Override
    public String encrypt(Command command) {
        ArrayList<Character> temp = command.getSource();
        for (int i = 0; i < temp.size(); i++) {
            if (Character.isAlphabetic(temp.get(i))) {
                temp.set(i, shiftChar(temp.get(i), command.getKey(), true));
            }
        }
        return temp.stream().map(Objects::toString)
                .collect(Collectors.joining());
    }

    private char shiftChar(char ch, int shift, boolean isEnc) {
        if(Character.isLowerCase(ch)) {
            if (isEnc) {
                return (char) (Math.floorMod((ch - 'a' + shift), 26) + 'a');
            } else {
                return (char) (Math.floorMod((ch - 'a' - shift), 26) + 'a');
            }
        } else {
            if (isEnc) {
                return (char) (Math.floorMod((ch - 'A' + shift), 26) + 'A');
            } else {
                return (char) (Math.floorMod((ch - 'A' - shift), 26) + 'A');
            }
        }
    }
}
