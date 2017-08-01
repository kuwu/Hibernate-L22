
package com.test.controller;

/**
 *
 *
 * Created by Kuwu on 7/24/17.
 */

import com.test.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class HomeController {

  @RequestMapping("/")
  public ModelAndView helloWorld() {
    String hi = "Welcome to the Coffee Shop";
    return new
        ModelAndView( "welcome", "message",hi);
  }

  @RequestMapping("/listCustomers")
  public ModelAndView listCustomer() {
    ArrayList<UsersEntity> userList = getAllCustomers();


    return new ModelAndView("welcome", "cList", userList);
  }

  // this method was extracted to be used again. This a regular method and not a controller.
  private ArrayList<UsersEntity> getAllCustomers() {
    //　Configuration allows app to specify properties & mapping documents to use
    //  when creating a session factory.
    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

    SessionFactory sessionFactory = cfg.buildSessionFactory();

    Session selectCustomers = sessionFactory.openSession();

    selectCustomers.beginTransaction();

    Criteria c = selectCustomers.createCriteria(UsersEntity.class);

    return (ArrayList< UsersEntity>) c.list();
  }

  @RequestMapping("/getNewCust")
  public String newCustomer(){
    return "addcustomerform";
  }

  @RequestMapping("/addNewCustomer")
  public String addNewCustomer(@RequestParam("userId") String userId,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("phoneNumber") String phoneNumber,
                               @RequestParam("password") String password, Model model){

    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

    SessionFactory sessionFact = cfg.buildSessionFactory();

    Session session = sessionFact.openSession();

    Transaction tx = session.beginTransaction();

    UsersEntity newCustomer = new UsersEntity();

    newCustomer.setUserId(userId);
    newCustomer.setFirstName(firstName);
    newCustomer.setLastName(lastName);
    newCustomer.setEmail(lastName);
    newCustomer.setPhoneNumber(phoneNumber);
    newCustomer.setPassword(password);


    session.save(newCustomer);
    tx.commit();
    session.close();

    model.addAttribute("newStuff",newCustomer);

    return "addcustsuccess";
  }

}