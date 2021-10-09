package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.commons.ID;
import seedu.address.model.commons.Name;
import seedu.address.model.product.Product;
import seedu.address.model.product.UnitPrice;

/**
 * Jackson-friendly version of {@link Product}.
 */
public class JsonAdaptedProduct {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Product's %s field is missing!";

    private final String name;
    private final String id;
    private final String unitPrice;

    /**
     * Constructs a {@code JsonAdaptedProduct} with the given product details.
     */
    @JsonCreator
    public JsonAdaptedProduct(@JsonProperty("name") String name, @JsonProperty("id") String id,
                              @JsonProperty("unit price") String unitPrice) {
        this.name = name;
        this.id = id;
        this.unitPrice = unitPrice;
    }

    /**
     * Converts a given {@code Product} into this class for Jackson use.
     */
    public JsonAdaptedProduct(Product source) {
        name = source.getName().fullName;
        id = source.getId().toString();
        unitPrice = source.getUnitPrice().toString();
    }

    /**
     * Converts this Jackson-friendly adapted product object into the model's {@code Product} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted client.
     */
    public Product toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (id == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, ID.class.getSimpleName()));
        }
        final ID modelId = new ID(id);

        if (unitPrice == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    UnitPrice.class.getSimpleName()));
        }
        final UnitPrice modelUnitPrice = new UnitPrice(unitPrice);
        return new Product(modelId, modelName, modelUnitPrice);
    }
}

