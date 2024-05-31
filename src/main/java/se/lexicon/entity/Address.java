package se.lexicon.entity;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString(exclude = "user")
@EqualsAndHashCode(of = "id")

public class Address {

    private Long id;
    private String city;
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String zipCode;
    private LocalDateTime creationDate;
    private User user;



}
