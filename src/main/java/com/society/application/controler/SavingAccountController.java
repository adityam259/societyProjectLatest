package com.society.application.controler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.society.application.model.BankMaster;
import com.society.application.model.BranchMaster;
import com.society.application.model.GenericGetById;
import com.society.application.model.Member;
import com.society.application.model.SavingAccount;
import com.society.application.model.SavingsAccountApplication;
import com.society.application.model.UserMaster;
import com.society.application.repository.BankMasterRepo;
import com.society.application.repository.BranchMasterRepo;
import com.society.application.repository.MemberRepo;
import com.society.application.repository.SavingAccountRepo;
import com.society.application.repository.SavingsAccountApplicationRepo;

@Controller
public class SavingAccountController {
	
	@Autowired
	MemberRepo memberRepo;
	
	@Autowired
	BranchMasterRepo branchMasterRepo;
	
	@Autowired
	SavingAccountRepo savingAccountRepo;
	
	@Autowired
	SavingsAccountApplicationRepo savingsAccountApplicationRepo;
	
	@Autowired
	BankMasterRepo bankMasterRepo;
	
	@GetMapping("/addSaving")
	public String AddSaving(Model model) {
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "savingsAccount/AddSaving";
	}

	@GetMapping("/savingIntraTransfer")
	public String SavingIntraTransfer(Model model) {
		List<BankMaster> bankMasterList = bankMasterRepo.findAll();
		model.addAttribute("bankMaster", bankMasterList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "savingsAccount/SavingIntraTransfer";
	}

	@GetMapping("/savingsPlanMaster")
	public String SavingsPlanMaster() {
		return "savingsAccount/SavingsPlanMaster";
	}

	@GetMapping("/savingsStatement")
	public String savingsStatement(Model model) {
		List<BankMaster> bankMasterList = bankMasterRepo.findAll();
		model.addAttribute("bankMaster", bankMasterList);
		return "savingsAccount/SavingsStatement";
	}

	@GetMapping("/savingsTransactionEntry")
	public String SavingsTransactionEntry(Model model) {
		List<BankMaster> bankMasterList = bankMasterRepo.findAll();
		model.addAttribute("bankMaster", bankMasterList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "savingsAccount/SavingsTransactionEntry";
	}

	@GetMapping("/sBInterestGenerate")
	public String SBInterestGenerate() {
		return "savingsAccount/SBInterestGenerate";
	}

	@GetMapping("/sBPassbookPrint")
	public String SBPassbookPrint(Model model) {
		List<BankMaster> bankMasterList = bankMasterRepo.findAll();
		model.addAttribute("bankMaster", bankMasterList);
		return "savingsAccount/SBPassbookPrint";
	}

	@GetMapping("/searchSavingsAccount")
	public String SearchSavingsAccount() {
		return "savingsAccount/SearchSavingsAccount";
	}

	@GetMapping("/serviceChargesDeduction")
	public String ServiceChargesDeduction() {
		return "savingsAccount/ServiceChargesDeduction";
	}

	@GetMapping("/sMSChargesDeduction")
	public String SMSChargesDeduction() {
		return "savingsAccount/SMSChargesDeduction";
	}

	@GetMapping("/accountCloser")
	public String AccountCloser(Model model) {
		List<BankMaster> bankMasterList = bankMasterRepo.findAll();
		model.addAttribute("bankMaster", bankMasterList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "savingsAccount/AccountCloser";
	}

	@PostMapping("/saveSavingsAccount")
	public String saveSavingsAccount(@ModelAttribute("saveSavingsAccount") SavingAccount savingAccount, Model model, HttpSession session) {
		SavingAccount savingAccountObj = savingAccountRepo.save(savingAccount);
		model.addAttribute("status", "ERROR");
		if(savingAccountObj!=null) {
			model.addAttribute("status", "SUCCESS");
		}
		return "savingsAccount/SavingsPlanMaster";
	}
	
	@GetMapping("/getAllSavingsAccount")
	@ResponseBody
	public List<SavingAccount>  getAllSavingsAccount(Model model, HttpSession session) {
		List<SavingAccount> getAllSavingAccount = savingAccountRepo.findAll();
		model.addAttribute("status", "ERROR");
		if(getAllSavingAccount!=null) {
			model.addAttribute("savingAccount", getAllSavingAccount);
			model.addAttribute("status", "SUCCESS");
		}
		return getAllSavingAccount;
	}
	
	@PostMapping("/saveSavingsAccountApplciation")
	public String saveSavingsAccountApplciation(@ModelAttribute("saveSavingsAccountApplciation") SavingsAccountApplication savingsAccountApplication, Model model, HttpSession session) {
		SavingsAccountApplication savingAccountObj = savingsAccountApplicationRepo.save(savingsAccountApplication);
		model.addAttribute("status", "ERROR");
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		if(savingAccountObj!=null) {
			model.addAttribute("status", "SUCCESS");
		}
		return "savingsAccount/AddSaving";
	}
	
	@PostMapping("/updateSavingsAccountApplciation")//think of id for update
	public String updateSavingsAccountApplciation(@ModelAttribute("saveSavingsAccountApplciation") SavingsAccountApplication savingsAccountApplication, Model model, HttpSession session) {
		//SavingsAccountApplication savingAccountObj = savingsAccountApplicationRepo.save(savingsAccountApplication);
		model.addAttribute("status", "ERROR");
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		//if(savingAccountObj!=null) {
			model.addAttribute("status", "SUCCESS");
		//}
		return "savingsAccount/SavingsTransactionEntry";
	}
	
	//updateIntraAccountTransfer
	@PostMapping("/updateIntraAccountTransfer")//think of id for update
	public String updateIntraAccountTransfer(@ModelAttribute("updateIntraAccountTransfer") SavingsAccountApplication savingsAccountApplication, Model model, HttpSession session) {
		//SavingsAccountApplication savingAccountObj = savingsAccountApplicationRepo.save(savingsAccountApplication);
		model.addAttribute("status", "ERROR");
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		//if(savingAccountObj!=null) {
			model.addAttribute("status", "SUCCESS");
		//}
		return "savingsAccount/SavingIntraTransfer";
	}
	
	//accountCloser
	@PostMapping("/accountCloser")//think of id for update
	public String accountCloser(@ModelAttribute("accountCloser") SavingsAccountApplication savingsAccountApplication, Model model, HttpSession session) {
		//SavingsAccountApplication savingAccountObj = savingsAccountApplicationRepo.save(savingsAccountApplication);
		model.addAttribute("status", "ERROR");
		List<Member> memberList = memberRepo.findAll();
		model.addAttribute("memberList", memberList);
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		//if(savingAccountObj!=null) {
			model.addAttribute("status", "SUCCESS");
		//}
			List<BankMaster> bankMasterList = bankMasterRepo.findAll();
			model.addAttribute("bankMaster", bankMasterList);
			
			return "savingsAccount/AccountCloser";
	}
	
	
}
