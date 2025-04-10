package com.github.thientoan3596.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.github.thientoan3596.validator.EnumValidator;

/**
 * Annotation to validate that a String field's value matches one of the constants in the specified Enum class.
 *
 * <p>This annotation must be used only on fields of type {@link String}.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * public enum Status {
 *     ACTIVE, INACTIVE, PENDING
 * }
 *
 * public class Request {
 *     @ValidEnum(enumClass = Status.class, message = "Status must be one of: ACTIVE, INACTIVE, PENDING")
 *     private String status;
 * }
 * }
 * </pre>
 *
 * <p>The validator (EnumValidator) checks if the String value corresponds to any of the names
 * of the constants in the specified Enum class.</p>
 * NB! Does not handle null, let @NotNull do its job
 *
 * @author Toan Luong
 * @see EnumValidator
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface ValidEnum {
    String message() default "Invalid value. Allowed values: {allowedValues}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends Enum<?>> enumClass();
}
