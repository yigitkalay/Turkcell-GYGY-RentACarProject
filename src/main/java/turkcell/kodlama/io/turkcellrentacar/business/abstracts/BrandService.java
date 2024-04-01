package turkcell.kodlama.io.turkcellrentacar.business.abstracts;

import turkcell.kodlama.io.turkcellrentacar.business.requests.CreateBrandRequest;
import turkcell.kodlama.io.turkcellrentacar.business.requests.UpdateBrandRequest;
import turkcell.kodlama.io.turkcellrentacar.business.responses.GetAllBrandsResponse;
import turkcell.kodlama.io.turkcellrentacar.business.responses.GetByIdBrandResponse;
import turkcell.kodlama.io.turkcellrentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
