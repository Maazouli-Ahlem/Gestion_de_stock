package com.mycompany.article.article.dto;

import com.mycompany.article.article.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String address1;
    private String address2;
    private String ville;
    private String codePostale;
    private String Pays;

    public static AddressDto fromEntity(Address address){
        if (address == null){
            return null;
        }
        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .ville(address.getVille())
                .codePostale(address.getCodePostale())
                .Pays(address.getPays())
                .build();
    }

    public static Address toEntity(AddressDto addressDto){
        if (addressDto == null){
            return null;
        }
        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setVille(addressDto.getVille());
        address.setCodePostale(addressDto.getCodePostale());
        address.setPays(addressDto.getPays());
        return address;
    }
}
