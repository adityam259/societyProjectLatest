package com.society.application.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.society.application.model.BranchMaster;
import com.society.application.model.Employee;
import com.society.application.model.GenericGetById;
import com.society.application.model.GroupMaster;
import com.society.application.model.GroupMasterApplication;
import com.society.application.model.Loan;
import com.society.application.model.LoanMaster;
import com.society.application.model.LoanPlanMaster;
import com.society.application.model.Member;
import com.society.application.repository.BranchMasterRepo;
import com.society.application.repository.EmployeeRepo;
import com.society.application.repository.GroupMasterApplicationRepo;
import com.society.application.repository.GroupMasterRepo;
import com.society.application.repository.LoanMasterRepo;
import com.society.application.repository.LoanPlanRepo;
import com.society.application.repository.LoanRepo;
import com.society.application.repository.MemberRepo;

@Controller
public class GroupLoanController {

	@Autowired
	MemberRepo memberRepo;

	@Autowired
	BranchMasterRepo branchMasterRepo;

	@Autowired
	LoanMasterRepo loanMasterRepo;

	@Autowired
	GroupMasterRepo groupMasterRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	GroupMasterApplicationRepo groupMasterApplicationRepo;
	
	@Autowired
	LoanRepo loanRepo ;
	
	@Autowired
	LoanPlanRepo loanPlanRepo ;

	@GetMapping("/LoanPlan5c22")
	public String LoanPlan5c22(Model model) {
		return "group_loan/LoanPlan5c22";
	}

	@GetMapping("/LoanGroupMaster")
	public String LoanGroupMaster(Model model) {
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute("employeeList", employeeList);

		return "group_loan/LoanGroupMaster";
	}

	@GetMapping("/GroupLoanApplication")
	public String GroupLoanApplication(Model model) {
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		return "group_loan/GroupLoanApplication";
	}

	@GetMapping("/GroupLoanApproval9c5a")
	public String GroupLoanApproval9c5a(Model model) {
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		return "group_loan/GroupLoanApproval9c5a";
	}

	@PostMapping("/closeLoanRegularEMIRepaymentGroup")
	public String closeLoanRegularEMIRepaymentGroup(@ModelAttribute("updateLoan") Loan loan, Model model) {

		// few fields are no tthere so not saving close status

		model.addAttribute("status", "success");
		return "group_loan/LoanPreSettlement5c22";
	}

	@GetMapping("/GroupLoanApprovalf780")
	public String GroupLoanApprovalf780(Model model) {
		return "group_loan/GroupLoanApprovalf780";
	}

	@GetMapping("/LoanRepayment5c22")
	public String LoanRepayment5c22(Model model) {
		return "group_loan/LoanRepayment5c22";
	}

	@GetMapping("/GlDailyRepaymentSheet")
	public String GlDailyRepaymentSheet(Model model) {
		return "group_loan/GlDailyRepaymentSheet";
	}

	@GetMapping("/DemandSheet")
	public String DemandSheet(Model model) {
		return "group_loan/DemandSheet";
	}

	@GetMapping("/RegularLoanStatement5c22")
	public String RegularLoanStatement5c22(Model model) {
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		return "group_loan/RegularLoanStatement5c22";
	}

	@GetMapping("/LoanPreSettlement5c22")
	public String LoanPreSettlement5c22(Model model) {
		return "group_loan/LoanPreSettlement5c22";
	}

	@GetMapping("/ClosedLoanReportf159")
	public String ClosedLoanReportf159(Model model) {
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		return "group_loan/ClosedLoanReportf159";
	}

	@GetMapping("/GroupLoanSearch")
	public String GroupLoanSearch(Model model) {
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "group_loan/GroupLoanSearch";
	}

	@GetMapping("/getAllGroupLoan")
	@ResponseBody
	public List<LoanMaster> getAllGroupLoan(Model model) {
		List<LoanMaster> allGroupLoan = loanMasterRepo.findAll();
		List<LoanMaster> filterGroupLoan = allGroupLoan.stream().filter(p -> p.getType().equals("Group"))
				.collect(Collectors.toList());
		System.err.println(filterGroupLoan);
		return filterGroupLoan;
	}

	// getAllGroupMaster
	@GetMapping("/getAllGroupMaster")
	@ResponseBody
	public List<GroupMaster> getAllGroupMaster() {
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		return allGroupMaster;
	}

	@PostMapping("/saveGroupMaster")
	public String saveGroupMaster(@ModelAttribute("saveGroupMaster") GroupMaster groupMaster, Model model) {
		groupMaster.setCreatedBy("");
		groupMaster.setCreatedDate(new Date().toString());
		groupMaster.setUpdatedBy("");
		groupMaster.setUpdatedDate(new Date().toString());
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute("employeeList", employeeList);
		GroupMaster savedsaveGroupMaster = groupMasterRepo.save(groupMaster);
		if (savedsaveGroupMaster != null) {
			model.addAttribute("status", "success");
		}
		model.addAttribute("status", "Fail");
		return "group_loan/LoanGroupMaster";
	}

	@PostMapping("/getGroupMasterById")
	@ResponseBody
	public GroupMaster getGroupMasterById(@RequestBody GenericGetById id) {
		Optional<GroupMaster> groupMaster = groupMasterRepo.findById(Integer.parseInt(id.getId()));
		return groupMaster.get();
	}

	@PostMapping("/saveGroupMasterApplication")
	public String saveGroupMasterApplication(
			@ModelAttribute("saveGroupMasterApplication") GroupMasterApplication groupMasterApplication, Model model) {
		groupMasterApplication.setCreatedBy("");
		groupMasterApplication.setCreatedDate(new Date().toString());
		groupMasterApplication.setUpdatedBy("");
		groupMasterApplication.setUpdatedDate(new Date().toString());
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		GroupMasterApplication savedgroupMasterApplication = groupMasterApplicationRepo.save(groupMasterApplication);
		if (savedgroupMasterApplication != null) {
			model.addAttribute("status", "success");
		}
		model.addAttribute("status", "Fail");
		return "group_loan/GroupLoanApplication";
	}

	@PostMapping("/approveGroupMasterApplication")
	public String approveGroupMasterApplication(
			@ModelAttribute("saveGroupMasterApplication") GroupMasterApplication groupMasterApplication, Model model) {
		groupMasterApplication.setCreatedBy("");
		groupMasterApplication.setCreatedDate(new Date().toString());
		groupMasterApplication.setUpdatedBy("");
		groupMasterApplication.setUpdatedDate(new Date().toString());
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		System.err.println(groupMasterApplication);
		GroupMasterApplication savedgroupMasterApplication = groupMasterApplicationRepo.save(groupMasterApplication);
		if (savedgroupMasterApplication != null) {
			model.addAttribute("status", "success");
		}
		model.addAttribute("status", "Fail");
		return "group_loan/GroupLoanApproval9c5a";
	}

	@PostMapping("/updateLoanRegularEMIRepaymentGroup")
	public String updateLoanRegularEMIRepaymentGroup(@ModelAttribute("updateLoan") Loan loan, Model model) {

		// as of now no action as complete field is not visible in view

		List<GroupMaster> allGroupMaster = groupMasterRepo.findAll();
		model.addAttribute("allGroupMaster", allGroupMaster);
		List<LoanMaster> loanPlanMaster = loanMasterRepo.findAll();
		model.addAttribute("loanPlanMaster", loanPlanMaster);
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		model.addAttribute("status", "success");
		return "group_loan/LoanRepayment5c22";
	}
	
	// Search groupSearch loan
	@GetMapping("/getAllGroupLoanBranch")
	@ResponseBody
	public List<BranchMaster> getAllGroupLoanBranch() {
		return branchMasterRepo.findAll();
	}

	@GetMapping("/getAllGroupLoanID")
	@ResponseBody
	public List<Loan> getAllGroupLoanID() {
		return loanRepo.findAll();
	}

	@GetMapping("/getAllGroupLoanplan")
	@ResponseBody
	public List<LoanPlanMaster> getAllGroupLoanplan() {
		return loanPlanRepo.findAll();
	}

	@PostMapping("/searchInTheGroupLoan")
	@ResponseBody
	public List<Loan> searchInTheGroupLoan(@RequestBody Loan loan) {

		List<Loan> data1 = loanRepo.findBycspName(loan.getCspName());
		List<Loan> data2 = loanRepo.findByloanDateBetween(loan.getfDate(), loan.gettDate());
		List<Loan> data3 = loanRepo.findByadvisorName(loan.getAdvisorName());
		
		//List<Loan> data4 = loanRepo.findByid(loan.getId());
		List<Loan> data4 = new ArrayList<>();
	    Loan loanData4 = loanRepo.findByid(loan.getId());
	    if (loanData4 != null) {
	        data4.add(loanData4);
	    }
	    
		List<Loan> data5 = loanRepo.findBysearchMemberCode(loan.getSearchMemberCode());
		List<Loan> data6 = loanRepo.findByloanPlanName(loan.getLoanPlanName());
		List<Loan> data7 = loanRepo.findByadvisorCode(loan.getAdvisorCode());

		if (!data1.isEmpty()) {
			return data1;
		} else if (!data2.isEmpty()) {
			return data2;
		} else if (!data3.isEmpty()) {
			return data3;
		} else if (!data4.isEmpty()) {
			return data4;
		} else if (!data5.isEmpty()) {
			return data5;
		} else if (!data6.isEmpty()) {
			return data6;
		} else {
			return data7;
		}
	}
}
