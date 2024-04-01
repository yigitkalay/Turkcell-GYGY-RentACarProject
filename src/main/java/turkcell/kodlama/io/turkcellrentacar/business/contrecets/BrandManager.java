package turkcell.kodlama.io.turkcellrentacar.business.contrecets;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turkcell.kodlama.io.turkcellrentacar.business.abstracts.BrandService;
import turkcell.kodlama.io.turkcellrentacar.business.requests.CreateBrandRequest;
import turkcell.kodlama.io.turkcellrentacar.business.requests.UpdateBrandRequest;
import turkcell.kodlama.io.turkcellrentacar.business.responses.GetAllBrandsResponse;
import turkcell.kodlama.io.turkcellrentacar.business.responses.GetByIdBrandResponse;
import turkcell.kodlama.io.turkcellrentacar.core.utilities.mappers.ModelMapperService;
import turkcell.kodlama.io.turkcellrentacar.dataAccess.abstracts.BrandRepository;
import turkcell.kodlama.io.turkcellrentacar.entities.concretes.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        /*List<GetAllBrandsResponse> brandsResponse=new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem =new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }
        return brandsResponse;*/

        List<GetAllBrandsResponse> brandsResponses = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;
    }

    public void add(CreateBrandRequest createBrandRequest) {
        /*Brand brand=new Brand();
        brand.setName(createBrandRequest.getName());*/

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
