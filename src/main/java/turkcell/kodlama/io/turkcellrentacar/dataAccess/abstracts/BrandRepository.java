package turkcell.kodlama.io.turkcellrentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.kodlama.io.turkcellrentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
