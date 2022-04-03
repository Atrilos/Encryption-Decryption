package encryptdecrypt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Encrypter {

    private final AlgorithmChoice algorithm;

    Encrypter(AlgorithmChoice algorithm) {
        this.algorithm = algorithm;
    }

    void compute(Command command) {
        String msg = "";
        if (command.getMode().equals("enc")) {
            msg = algorithm.encrypt(command);
            output(command, msg);
        } else {
            msg = algorithm.decrypt(command);
            output(command, msg);
        }
    }

    public void output(Command command, String message) {
        if (command.getWriteAddress().equals("")) {
            System.out.println(message);;
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(command.getWriteAddress()))) {
                writer.write(message);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
