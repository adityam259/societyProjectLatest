package com.society.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.society.application.model.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {
	@Query("SELECT COUNT(u) FROM Loan u")
	long countLoan();

	List<Loan> findBymemberData(String string);

	List<Loan> findByloanPlanName(String loanPlanName);
	
	@Query(value="select * from loan inner join member on \r\n"
			+ "loan.search_member_code = member.id\r\n"
			+ "where csp_name = ?1 AND loan_date >=?2 AND loan_date <= ?3",nativeQuery=true)
	List<Loan> filterLoanData(String branch,String fdate,String tdate);
	
	@Query(value="select * from loan where mode_reg_or_irr = 'regular'",nativeQuery=true)
	Loan searchRegularData();
	
	@Query(value="select * from loan where mode_reg_or_irr = 'irregular'",nativeQuery=true)
	Loan searchIrRegularData();
	
	@Query(value="select * from loan where type='Gold'",nativeQuery=true)
	List<Loan> searchGoldLoan();

	
}
