package tn.esb.bis.ecommercebackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bis.ecommercebackend.Repositories.customerRepository;

@Service
public class CustomerService {
    @Autowired
    private customerRepository customerRepos;
}
