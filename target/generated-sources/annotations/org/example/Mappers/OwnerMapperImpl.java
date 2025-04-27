package org.example.Mappers;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.example.DTO.OwnerDTO;
import org.example.DTO.PetDTO;
import org.example.Entities.OwnerEntity;
import org.example.Entities.PetEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-15T02:02:04+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public OwnerDTO toDto(OwnerEntity ownerEntity) {
        if ( ownerEntity == null ) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId( ownerEntity.getId() );
        ownerDTO.setName( ownerEntity.getName() );
        ownerDTO.setBirthDate( ownerEntity.getBirthDate() );
        ownerDTO.setPets( petEntitySetToPetDTOSet( ownerEntity.getPets() ) );

        return ownerDTO;
    }

    @Override
    public OwnerEntity toEntity(OwnerDTO ownerDto) {
        if ( ownerDto == null ) {
            return null;
        }

        OwnerEntity.OwnerEntityBuilder ownerEntity = OwnerEntity.builder();

        ownerEntity.id( ownerDto.getId() );
        ownerEntity.name( ownerDto.getName() );
        ownerEntity.birthDate( ownerDto.getBirthDate() );
        ownerEntity.pets( petDTOSetToPetEntitySet( ownerDto.getPets() ) );

        return ownerEntity.build();
    }

    protected Set<PetDTO> petEntitySetToPetDTOSet(Set<PetEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<PetDTO> set1 = new LinkedHashSet<PetDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PetEntity petEntity : set ) {
            set1.add( petEntityToPetDTO( petEntity ) );
        }

        return set1;
    }

    protected PetDTO petEntityToPetDTO(PetEntity petEntity) {
        if ( petEntity == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setId( petEntity.getId() );
        petDTO.setName( petEntity.getName() );
        petDTO.setBirthDate( petEntity.getBirthDate() );
        petDTO.setBreed( petEntity.getBreed() );
        petDTO.setColor( petEntity.getColor() );
        petDTO.setOwner( toDto( petEntity.getOwner() ) );
        petDTO.setFriends( petEntitySetToPetDTOSet( petEntity.getFriends() ) );

        return petDTO;
    }

    protected Set<PetEntity> petDTOSetToPetEntitySet(Set<PetDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<PetEntity> set1 = new LinkedHashSet<PetEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PetDTO petDTO : set ) {
            set1.add( petDTOToPetEntity( petDTO ) );
        }

        return set1;
    }

    protected PetEntity petDTOToPetEntity(PetDTO petDTO) {
        if ( petDTO == null ) {
            return null;
        }

        PetEntity.PetEntityBuilder petEntity = PetEntity.builder();

        petEntity.id( petDTO.getId() );
        petEntity.name( petDTO.getName() );
        petEntity.birthDate( petDTO.getBirthDate() );
        petEntity.breed( petDTO.getBreed() );
        petEntity.color( petDTO.getColor() );
        petEntity.owner( toEntity( petDTO.getOwner() ) );
        petEntity.friends( petDTOSetToPetEntitySet( petDTO.getFriends() ) );

        return petEntity.build();
    }
}
