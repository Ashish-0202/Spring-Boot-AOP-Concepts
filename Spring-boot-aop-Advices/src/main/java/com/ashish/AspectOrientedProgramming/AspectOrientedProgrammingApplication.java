package com.ashish.AspectOrientedProgramming;

import com.ashish.AspectOrientedProgramming.Dao.Account;
import com.ashish.AspectOrientedProgramming.Dao.AccountDao;
import com.ashish.AspectOrientedProgramming.Dao.MemberShipDao;
import com.ashish.AspectOrientedProgramming.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao dao,
											   MemberShipDao memberShipDao,
											   TrafficFortuneService trafficFortuneService){
		return runner->{
			//runDaoOperation(dao,memberShipDao);
			//runAfterAdvice(dao);
			//runAfterThrowing(dao);

			runDemoAroundAdvice(trafficFortuneService);
		};
	}

	private void runDemoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: runDemoAroundAdvice");

		System.out.println("Calling getFortune()");

		String data= trafficFortuneService.getFortune();

		System.out.println("Data from fortune(): "+data);
	}

	private void runAfterThrowing(AccountDao dao) {
		List<Account> accounts = null;

		try{
			boolean tripWire = true;
			accounts = dao.getAllAccounts(tripWire);
		} catch (Exception exception){
			System.out.println("Exception occurred bro:" +exception);
		}
	}

	public void runDaoOperation(AccountDao dao,MemberShipDao memberShipDao){
		//calling the addAccount() from AccountDao
		Account account = new Account();
		account.setType("SB");
		account.setName("Ashish");
		//Invoking getter and setters
		dao.getName();
		dao.getType();
		dao.setName("name");
		dao.setType("type");

		dao.addAccount(account);

		//calling the addAccount() from MemberShipDao
		memberShipDao.addAccount();

		//calling the addMember() from MemberShipDao
		memberShipDao.addMember();

		int amt= memberShipDao.addAmount();
//		System.out.println("\n calling the same dao one more time\n");
//		dao.addAccount();
//		memberShipDao.addAccount();

		List<Account> acts= dao.getAllAccounts();
		System.out.println(acts);
	}

	public  void runAfterAdvice(AccountDao dao){
		List<Account> accountList = dao.getAllAccounts();
		System.out.println("======> Account Details: "+accountList);
	}


}
