/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.account.web;

import com.hellokoding.account.Models.*;
import com.hellokoding.account.controller.util.ErrorBean;
import com.hellokoding.account.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dzni0816
 */
@RequestMapping(value = {"/admin/customer"})
@Controller
public class CustomerController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ApplicationContext applicationContext;
    @Inject
    private ErrorBean error;



    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String emptyCustomer(Model model) {
        model.addAttribute("USER_LIST", userRepository.findAll());
        return "customer/create";
    }


    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String createCustomer(Principal principal, Address address, Customer customer, @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("contact") String contact,
                                 @RequestParam("email") String email,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("passNumber") String passNumber,
                                 @RequestParam("countNumber") String countNumber,
                                 @RequestParam("addressLine") String addressLine,
                                 @RequestParam("city") String city,
                                 @RequestParam("country") String country,
                                 @RequestParam("user1") String user1,
                                 @RequestParam("postalCode") String postalCode) {
        customer.setFirstName(firstName);
        customer.setLastName(firstName);
        customer.setContact(contact);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setPassNumber(passNumber);
        customer.setCountNumber(countNumber);
        Long i = userRepository.findByUsername(principal.getName()).getId();
        String s = String.valueOf(i);
        customer.setUserId(String.valueOf(s));
        address.setAddressLine(addressLine);
        address.setCity(city);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        address.setModifiedDate(dateFormat.format(date));
        addressRepository.save(address);
        customer.setCustomerId(address.getAddressId());
        customer.setAddress1(address);
        customer.setUserId(user1);
        customerRepository.save(customer);
        return "redirect:list";
    }


    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
    public String editCustomer(Model model, @PathVariable("id") Long id) {
        model.addAttribute("CUSTOMER", customerRepository.findOne(id));
        /*List<Address> adr = addressRepository.findAll();
        Address adrm = addressRepository.findOne(id);
        for (Address adr1: adr) if (adr1.getAddressId().equals(customerRepository.findOne(id).getAddress1().getAddressId())) {
            adrm = adr1;
            break;
        }
        model.addAttribute("ADDRESS", adrm);*/
        model.addAttribute("USER_LIST", userRepository.findAll());
        return "customer/update";
    }


    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String updateCustomer(Principal principal, Address address, Customer customer, @RequestParam("firstName") String firstName,
                                 @RequestParam("customerId") Long customerId,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("contact") String contact,
                                 @RequestParam("email") String email,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("passNumber") String passNumber,
                                 @RequestParam("countNumber") String countNumber,
                                 @RequestParam("addressId") Long addressId,
                                 @RequestParam("addressLine") String addressLine,
                                 @RequestParam("city") String city,
                                 @RequestParam("country") String country,
                                 @RequestParam("user1") String user1,
                                 @RequestParam("postalCode") String postalCode) {

        customer.setFirstName(firstName);
        customer.setLastName(firstName);
        customer.setContact(contact);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setPassNumber(passNumber);
        customer.setCountNumber(countNumber);
        Long i = userRepository.findByUsername(principal.getName()).getId();
        String s = String.valueOf(i);
        customer.setUserId(String.valueOf(s));
        address.setAddressLine(addressLine);
        address.setCity(city);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        address.setModifiedDate(dateFormat.format(date));
        addressRepository.save(address);
        customer.setCustomerId(address.getAddressId());
        customer.setAddress1(address);
        customer.setUserId(user1);
        customerRepository.save(customer);
        return "redirect:/admin/customer/list";
    }


    @RequestMapping(value = {"/remove/{id}"}, method = RequestMethod.GET)
    public String removeCustomer(@PathVariable("id") Long id) {
        customerRepository.delete(customerRepository.findOne(id));
        return "redirect:/admin/customer/list";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String findCustomer(Model model, @PathVariable("id") Long id) {
        model.addAttribute("CUSTOMER", customerRepository.findOne(id));
        model.addAttribute("USER", userRepository.findOne(Long.valueOf(customerRepository.findOne(id).getUserId())));
        return "customer/view";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String findAllCustomer(Model model) {
        model.addAttribute("CUSTOMER_LIST", customerRepository.findAll());
        return "customer/list";
    }




    @RequestMapping(value = {"/cabinet"}, method = RequestMethod.GET)
    public String editCabinet(Model model) {
        model.addAttribute("ADDRESS_LIST", addressRepository.findAll());
        return "cabinet/cabinet";
    }

}
