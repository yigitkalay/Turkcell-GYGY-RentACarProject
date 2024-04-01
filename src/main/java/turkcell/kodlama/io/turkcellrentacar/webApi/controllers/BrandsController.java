package turkcell.kodlama.io.turkcellrentacar.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import turkcell.kodlama.io.turkcellrentacar.business.abstracts.BrandService;
import turkcell.kodlama.io.turkcellrentacar.business.requests.CreateBrandRequest;
import turkcell.kodlama.io.turkcellrentacar.business.requests.UpdateBrandRequest;
import turkcell.kodlama.io.turkcellrentacar.business.responses.GetAllBrandsResponse;
import turkcell.kodlama.io.turkcellrentacar.business.responses.GetByIdBrandResponse;
import turkcell.kodlama.io.turkcellrentacar.entities.concretes.Brand;

import java.util.List;

@RestController //anotasyon
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
//        BrandManager brandManager = new BrandManager(new InMemoryBrandRepository());
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getByID(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
        public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
