package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Override
    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository
                .findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor = vendorRepository.save(vendor);

        return vendorMapper.vendorToVendorDTO(vendor);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        if (vendorDTO.getName() == null)
            vendorDTO.setName(vendor.getName());

        vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor = vendorRepository.save(vendor);

        return vendorMapper.vendorToVendorDTO(vendor);
    }

    @Override
    public VendorDTO saveByVendorDTO(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor.setId(id);

        vendor = vendorRepository.save(vendor);
        return vendorMapper.vendorToVendorDTO(vendor);
    }
}
