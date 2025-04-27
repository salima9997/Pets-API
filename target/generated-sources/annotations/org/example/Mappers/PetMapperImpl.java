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
    date = "2025-04-15T02:02:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
public class PetMapperImpl implements PetMapper {

    @Override
    public PetDTO toDto(PetEntity petEntity) {
        if ( petEntity == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setId( petEntity.getId() );
        petDTO.setName( petEntity.getName() );
        petDTO.setBirthDate( petEntity.getBirthDate() );
        petDTO.setBreed( petEntity.getBreed() );
        petDTO.setColor( petEntity.getColor() );
        petDTO.setOwner( ownerEntityToOwnerDTO( petEntity.getOwner() ) );
        petDTO.setFriends( petEntitySetToPetDTOSet( petEntity.getFriends() ) );

        return petDTO;
    }

    @Override
    public PetEntity toEntity(PetDTO petDTO) {
        if ( petDTO == null ) {
            return null;
        }

        PetEntity.PetEntityBuilder petEntity = PetEntity.builder();

        petEntity.id( petDTO.getId() );
        petEntity.name( petDTO.getName() );
        petEntity.birthDate( petDTO.getBirthDate() );
        petEntity.breed( petDTO.getBreed() );
        petEntity.color( petDTO.getColor() );
        petEntity.owner( ownerDTOToOwnerEntity( petDTO.getOwner() ) );
        petEntity.friends( petDTOSetToPetEntitySet( petDTO.getFriends() ) );

        return petEntity.build();
    }

    protected Set<PetDTO> petEntitySetToPetDTOSet(Set<PetEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<PetDTO> set1 = new LinkedHashSet<PetDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PetEntity petEntity : set ) {
            set1.add( toDto( petEntity ) );
        }

        return set1;
    }

    protected OwnerDTO ownerEntityToOwnerDTO(OwnerEntity ownerEntity) {
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

    protected Set<PetEntity> petDTOSetToPetEntitySet(Set<PetDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<PetEntity> set1 = new LinkedHashSet<PetEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PetDTO petDTO : set ) {
            set1.add( toEntity( petDTO ) );
        }

        return set1;
    }

    protected OwnerEntity ownerDTOToOwnerEntity(OwnerDTO ownerDTO) {
        if ( ownerDTO == null ) {
            return null;
        }

        OwnerEntity.OwnerEntityBuilder ownerEntity = OwnerEntity.builder();

        ownerEntity.id( ownerDTO.getId() );
        ownerEntity.name( ownerDTO.getName() );
        ownerEntity.birthDate( ownerDTO.getBirthDate() );
        ownerEntity.pets( petDTOSetToPetEntitySet( ownerDTO.getPets() ) );

        return ownerEntity.build();
    }
}
