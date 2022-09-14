package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;

import java.util.List;

public interface VendorService {

    Vendor save(Vendor vendor);

    List<VendorDTO> getAllVendors();

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    void deleteVendorById(Long id);

    VendorDTO getVendorById(Long id);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    VendorDTO saveByVendorDTO(Long id, VendorDTO vendorDTO);
}
