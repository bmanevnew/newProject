package com.example.newproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDtoOut {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job_id")
    private long id;

    @JsonProperty("description")
    private String description;
    @JsonProperty("is_active")
    private boolean isActive;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
