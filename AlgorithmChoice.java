package encryptdecrypt;

/**
 * Strategy
 */
interface AlgorithmChoice {

    String encrypt(Command command);

    String decrypt(Command command);
}