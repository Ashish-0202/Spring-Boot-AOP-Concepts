package com.ashish.AspectOrientedProgramming;

import com.ashish.AspectOrientedProgramming.Dao.Account;
import com.ashish.AspectOrientedProgramming.Dao.AccountDao;
import com.ashish.AspectOrientedProgramming.Dao.MemberShipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao dao, MemberShipDao memberShipDao){
		return runner->{
			runDaoOperation(dao,memberShipDao);
		};
	}

	public void runDaoOperation(AccountDao dao,MemberShipDao memberShipDao){
		//calling the addAccount() from AccountDao
		Account account = new Account();
		dao.addAccount(account);

		//calling the addAccount() from MemberShipDao
		memberShipDao.addAccount();

		//calling the addMember() from MemberShipDao
		memberShipDao.addMember();

		int amt= memberShipDao.addAmount();
//		System.out.println("\n calling the same dao one more time\n");
//		dao.addAccount();
//		memberShipDao.addAccount();
	}
}
