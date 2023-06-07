package com.example.newproject.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDtoIn {
    public static final String NAME_IS_REQUIRED = "Job name is required";
    public static final String USER_NAME_LENGTH_ERROR = "Name must be between 5 and 40 symbols long";
    public static final String DESCRIPTION_LENGTH_ERROR = "Description must be between 5 and 40 symbols long";
    @NotNull(message = NAME_IS_REQUIRED)
    @Size(min = 5, max = 20, message = USER_NAME_LENGTH_ERROR)
    private String name;
    @NotNull(message = NAME_IS_REQUIRED)
    @Size(min = 5, max = 20000, message = DESCRIPTION_LENGTH_ERROR)
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
