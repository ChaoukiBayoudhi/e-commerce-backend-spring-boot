package tn.esb.bis.ecommercebackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bis.ecommercebackend.Domains.Provider;
@Repository
public interface providerRepository extends JpaRepository<Provider,Long> {
}
