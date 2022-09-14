package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"", "/"})
    public VendorListDTO getAllVendors() {
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{vendorId}")
    public VendorDTO getVendorById(@PathVariable String vendorId) {
        return vendorService.getVendorById(Long.valueOf(vendorId));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping({"", "/"})
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{vendorId}")
    public VendorDTO updateVendor(@PathVariable String vendorId,
                                  @RequestBody VendorDTO vendorDTO) {
        return vendorService.saveByVendorDTO(Long.valueOf(vendorId), vendorDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{vendorId}")
    public VendorDTO patchVendor(@PathVariable String vendorId,
                                 @RequestBody VendorDTO vendorDTO) {
        return vendorService.patchVendor(Long.valueOf(vendorId), vendorDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{vendorId}")
    public void deleteVendor(@PathVariable String vendorId) {
        vendorService.deleteVendorById(Long.valueOf(vendorId));
    }
}
