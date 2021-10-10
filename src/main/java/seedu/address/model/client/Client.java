package seedu.address.model.client;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.Category;
import seedu.address.model.commons.ID;
import seedu.address.model.commons.Name;

/**
 * Represents a Client in the app.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Client implements Category {
    // Identity fields
    private final ID id;

    // Data fields
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Email email;
    private final Address address;

    public Client(Name name, PhoneNumber phoneNumber, Email email, Address address) {
        this(new ID(), name, phoneNumber, email, address);
    }
<<<<<<< HEAD
    /** Constructs a {@code Client}. */
    public Client(ID id, Name name, PhoneNumber phoneNumber, Email email, Address address) {
=======

    private Client(ID id, Name name, PhoneNumber phoneNumber, Email email, Address address) {
>>>>>>> origin
        requireAllNonNull(id, name, phoneNumber);

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public ID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public static Client updateClient(Client client, Name name, PhoneNumber phoneNumber, Email email, Address address) {
        return new Client(client.getId(), name, phoneNumber, email, address);
    }

    /**
     * Returns true if both clients have the same id.
     * This defines a weaker notion of equality between two clients.
     *
     * @param otherClient Another Client being compared to.
     */
    public boolean isSameClient(Client otherClient) {
        if (otherClient == this) {
            return true;
        }

        return otherClient != null && otherClient.getId().equals(this.getId());
    }

    /**
     * Returns true if both clients have the same identity and data fields.
     * This defines a stronger notion of equality between two clients.
     *
     * @param other Any Object being compared to. May or may not be a instance of Client.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Client)) {
            return false;
        }

        Client otherClient = (Client) other;
        return id.equals(otherClient.id)
                       && name.equals(otherClient.name)
                       && phoneNumber.equals(otherClient.phoneNumber)
                       && email.equals(otherClient.email)
                       && address.equals(otherClient.address);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(id, name, phoneNumber, email, address);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ID: ")
                .append(id)
                .append("; Name: ")
                .append(name)
                .append("; Phone Number: ")
                .append(phoneNumber);

        if (email != null) {
            builder.append("; Email: ").append(email);
        }

        if (address != null) {
            builder.append("; Address: ").append(address);
        }

        return builder.toString();
    }
}
