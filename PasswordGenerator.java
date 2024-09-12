import java.util.Random;

public class PasswordGenerator {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    private static final String ALL_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;

    private Random random;

    public PasswordGenerator() {
        random = new Random();
    }

    public String generatePassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Password length must be at least 1.");
        }

        StringBuilder password = new StringBuilder(length);

        // Ensure the password contains at least one character from each character set
        password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Fill the remaining characters randomly from all available characters
        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        // Shuffle the characters to avoid predictable sequences
        return shuffleString(password.toString());
    }

    private String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}