package com.hr.test;

import com.hr.domain.Account;
import com.hr.service.IAccountService;
import conf.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Spring整合Junit的配置
 *  1 导入spring整合junit的坐标
 *  2 使用Junit提供的一个注解把原有的main方法替换, 替换成spring提供的@RunWith方法
 *  3 告知spring的运行器,spring和ioc创建是基于xml还是注解的并且说明位置
 *      @ContextConfiguration
 *          属性:
 *          locations: 指定xml文件的位置,加上classpath关键字,表示在类路径下
 *          classes: 指定注解类所在位置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> allAccount = accountService.findAllAccount();
        for (Account a : allAccount) {
            System.out.println(a);

        }
    }

    @Test
    public void testFindOne() {
        Account a = accountService.findAccountById(1);
        System.out.println(a);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("laohefsa");
        account.setMoney(999999f);
        accountService.saveAccount(account);

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}
