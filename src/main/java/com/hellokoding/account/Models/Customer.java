/**
 * This file was generated by the JPA Modeler
 */
package com.hellokoding.account.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author dzni0816
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Column(name = "CustomerId", table = "customer", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Column(name = "FirstName", table = "customer")
    @Basic
    private String firstName;

    @Column(name = "LastName", table = "customer")
    @Basic
    private String lastName;

    @Column(name = "Contact", table = "customer")
    @Basic
    private String contact;

    @Column(name = "Email", table = "customer")
    @Basic
    private String email;

    @Column(name = "Phone", table = "customer")
    @Basic
    private String phone;



    @Column(name = "PassNumber", table = "customer")
    @Basic
    private String passNumber;

    @Column(name = "CountNumber", table = "customer")
    @Basic
    private String countNumber;



    @ManyToOne(targetEntity = Address.class)
    private Address address1;

    @OneToMany(targetEntity = Statisticscollector.class, mappedBy = "customer1")
    private List<Statisticscollector> statisticscollectors1;

    @OneToMany(targetEntity = So.class, mappedBy = "customer1")
    private List<So> soes;

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public String getPassNumber() {
        return this.passNumber;
    }

    public void setCountNumber(String countNumber) {
        this.countNumber = countNumber;
    }

    public String getCountNumber() {
        return this.countNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress1() {
        return this.address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public List<Statisticscollector> getStatisticscollectors1() {
        return statisticscollectors1;
    }

    public void setStatisticscollectors1(List<Statisticscollector> statisticscollectors1) {
        this.statisticscollectors1 = statisticscollectors1;
    }

    public List<So> getSoes() {
        return soes;
    }

    public void setSoes(List<So> soes) {
        this.soes = soes;
    }
}
