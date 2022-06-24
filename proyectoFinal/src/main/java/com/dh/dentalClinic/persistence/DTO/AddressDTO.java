package com.dh.dentalClinic.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDTO {
    private Long id;
    private String street;
    private String number;
    private String locality;
    private String province;
}
