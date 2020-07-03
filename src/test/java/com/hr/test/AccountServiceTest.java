package com.hr.test;

import com.hr.domain.Account;
import com.hr.service.IAccountService;
import conf.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void testFindAll() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        for (Account a : allAccount) {
            System.out.println(a);

        }
    }

    @Test
    public void testFindOne() {
        //        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        Account a = accountService.findAccountById(1);
        System.out.println(a);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("laohefsa");
        account.setMoney(999999f);
        //        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount(account);

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}
