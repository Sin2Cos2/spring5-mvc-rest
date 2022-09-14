package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    Vendor vendorDtoToVendor(VendorDTO vendorDTO);

    @Mapping(source = "id", target = "vendorURL", qualifiedByName = "vendorURL")
    VendorDTO vendorToVendorDTO(Vendor vendor);

    @Named("vendorURL")
    default String setUrl(Long vendorId) {
        return "/api/v1/vendors/" + vendorId;
    }
}
