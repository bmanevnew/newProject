package com.example.newproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QouteDto {
    public static final String REQUIRED_FIELD = "Required field.";
    private LocalDate date;

    @NotBlank(message = REQUIRED_FIELD)
    private String companyName;
    @NotBlank(message = REQUIRED_FIELD)
    private String personInCharge;


    private String phone;

    @NotBlank(message = REQUIRED_FIELD)
    private String email;
    private String transportType;
    private String containerType;
    private String deliveryTerms;
    private String loadingAddress;
    private String loadingPort;
    private String country;
    private LocalDate readyDate;
    private String cargoType;
    private String remarks;

    private int weight;
    private int volume;
    private int quantity;
    private String packageType;
    private boolean isImdg;
    private String imdgClass;

}
