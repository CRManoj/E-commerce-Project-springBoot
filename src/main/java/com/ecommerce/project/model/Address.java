package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addressess")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must be atleast 5 Characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must be atleast 5 Characters")
    private String buildingName;

    @Size(min = 4, message = "City name must be atleast 5 Characters")
    private String city;

    @Size(min = 5, message = "State name must be atleast 5 Characters")
    private String state;

    @Size(min = 5, message = "Country name must be atleast 5 Characters")
    private String country;

    @Size(min = 6, message = "Pincode name must be atleast 5 Characters")
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "uset_id")
    private User user;

    public Address(Long addressId, String street, String buildingName, String city, String state, String country, String pincode)
    {
        this.addressId = addressId;
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
}
