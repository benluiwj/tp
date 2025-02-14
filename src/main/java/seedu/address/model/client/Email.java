package seedu.address.model.client;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Client's email in Sellah.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Email {
    private static final String SPECIAL_CHARACTERS = "+_.-";
    private static final String VALIDATION_REGEX =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String MESSAGE_CONSTRAINTS =
            "Emails should be of the format local-part@domain and adhere to the following constraints:\n"
                    + "1. The local-part should only contain alphanumeric characters and these special characters, "
                    + "excluding the parentheses, (" + SPECIAL_CHARACTERS + "). The local-part may not start or end "
                    + "with any special characters.\n"
                    + "2. This is followed by a '@' and then a domain name. The domain name is made up of domain labels"
                    + " separated by periods.\n"
                    + "The domain name must:\n"
                    + "    - end with a domain label at least 2 characters long\n"
                    + "    - have each domain label start and end with alphanumeric characters\n"
                    + "    - have each domain label consist of alphanumeric characters, separated only by hyphens, if "
                    + "any.";

    public final String value;

    /**
     * Constructs an {@code Email}.
     *
     * @param email A valid email address.
     */
    public Email(String email) {
        requireNonNull(email);
        checkArgument(isValidEmail(email), MESSAGE_CONSTRAINTS);
        value = email;
    }

    /**
     * Returns if a given string is a valid email.
     */
    public static boolean isValidEmail(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
