package com.customermanagement.customer.management.Service;

import com.customermanagement.customer.management.Document.Customer;
import com.customermanagement.customer.management.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //建立客戶並儲存
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    //取得全部的客戶
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //取得指定id的客戶
    public Customer getCustomerById(String id){
        return customerRepository.findById(id).orElse(null);
    }

    //修改客戶內容
    public void updateCustomer(Customer customer){
        Customer oldCustomer = getCustomerById(customer.getId());
        if(oldCustomer != null){
            oldCustomer.setFirstName(customer.getFirstName());
            oldCustomer.setLastName(customer.getLastName());
            oldCustomer.setEmail(customer.getEmail());
            customerRepository.save(oldCustomer);
        }
    }

    //刪除客戶
    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }
}
