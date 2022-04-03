package encryptdecrypt;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Command {
    private String mode;
    private int key;
    private String readAddress;
    private String writeAddress;
    private ArrayList<Character> source;
    private ArrayList<Character> result;
    private String algorithm;

    Command(){
        mode = "enc";
        key = 0;
        readAddress = "";
        writeAddress = "";
        source = new ArrayList<>();
        result = new ArrayList<>();
        algorithm = "shift";
    }

    public void input(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                source = args[i + 1].chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toCollection(ArrayList::new));
            } else if ("-in".equals(args[i])) {
                readAddress = args[i + 1];
            } else if ("-out".equals(args[i])) {
                writeAddress =  args[i + 1];
            } else if ("-alg".equals(args[i])) {
                algorithm = args[i + 1];
            }
        }
        if (source.size() == 0 && !readAddress.equals("")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(readAddress))) {
                source = reader.readLine().chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toCollection(ArrayList::new));
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public String getMode() {
        return mode;
    }

    public String getWriteAddress() {
        return writeAddress;
    }

    public ArrayList<Character> getSource() {
        return source;
    }

    public int getKey() {
        return key;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
