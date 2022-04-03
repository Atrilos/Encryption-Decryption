package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Command command = new Command();
        command.input(args);
        Encrypter encrypter = null;
        switch (command.getAlgorithm()) {
            case "shift" -> encrypter = new Encrypter(new Shift());
            case "unicode" -> encrypter = new Encrypter(new Unicode());
        }
        encrypter.compute(command);
    }
}
