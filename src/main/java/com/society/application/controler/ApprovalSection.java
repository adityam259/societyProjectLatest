package com.society.application.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.society.application.model.AdvisorCollectorDetails;
import com.society.application.model.BranchMaster;
import com.society.application.model.CashStatement;
import com.society.application.model.ClientMaster;
import com.society.application.model.ShareTransferDto;
import com.society.application.repository.AdvisorCollectorDetailsRepo;
import com.society.application.repository.BranchMasterRepo;
import com.society.application.repository.CashStatementrepo;
import com.society.application.repository.ClientMasterRepo;
import com.society.application.repository.ShareTransferDtoRepo;

@Controller
public class ApprovalSection {
	
	@Autowired
	BranchMasterRepo branchMasterRepo;
	
	@Autowired
	ClientMasterRepo clientMasterRepo;
	
	@Autowired
	ShareTransferDtoRepo dtoRepo;
	
	@Autowired
	AdvisorCollectorDetailsRepo advisorCollectorDetailsRepo;
	
	@Autowired
	CashStatementrepo cashStatementrepo;

	/* MEMBER APPROVAL */

	@GetMapping("/addMemberApproval")
	public String addMemberApproval(Model model) {
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "approvalSection/AddMemberApproval";
	}
	
	@PostMapping("/memberApproval")
	@ResponseBody
	public List<ClientMaster> memberApproval(@RequestBody ClientMaster clientMaster) {
		List<ClientMaster> list1 = clientMasterRepo.findByBranchName(clientMaster.getBranchName());
		List<ClientMaster> list2 = clientMasterRepo.findByregistrationDateBetween(clientMaster.getfDate(),
				clientMaster.gettDate());
		if (!list1.isEmpty()) {
			return list1;
		} else
			return list2;
	}
	
	/* */
	
	/* SHARE APPROVAL */

	@GetMapping("/shareIssueApproval")
	public String shareIssueApproval(Model model) {
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "approvalSection/ShareIssueApproval";
	}
	
	@PostMapping("/shareApproval")
	@ResponseBody
	public List<ShareTransferDto> shareApproval(@RequestBody ShareTransferDto share){
		List<ShareTransferDto> list1 = dtoRepo.findBybranchName(share.getBranchName());
		List<ShareTransferDto> list2 = dtoRepo.findBydojBetween(share.getfDate(), share.gettDate());
		if(!list1.isEmpty()) {
			return list1;
		}else
			return list2;
	}
	
	/* */
	
	/* ADVISOR/COLLECTOR APPROVAL */

	@GetMapping("/advisorApproval")
	public String advisorApproval(Model model) {
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "approvalSection/AdvisorApproval";
	}
	
	@PostMapping("/advisorApproval")
	@ResponseBody
	public List<AdvisorCollectorDetails> advisorApproval(@RequestBody AdvisorCollectorDetails advisor){
		List<AdvisorCollectorDetails> list1 = advisorCollectorDetailsRepo.findBybranchName(advisor.getBranchName());
		List<AdvisorCollectorDetails> list2 = advisorCollectorDetailsRepo.findByjoiningDateBetween(advisor.getfDate(), advisor.gettDate());
		if(!list1.isEmpty()) {
			return list1;
		}else
			return list2;
	}
	
	/* */

	@GetMapping("/investmentApproval")
	public String investmentApproval(Model model) {
		return "approvalSection/InvestmentApproval";
	}

	@GetMapping("/recurringApproval")
	public String recurringApproval(Model model) {
		return "approvalSection/RecurringApproval";
	}

	@GetMapping("/SBTxnApproval")
	public String SBTxnApproval(Model model) {
		return "approvalSection/SBTxnApproval";
	}

	@GetMapping("/intraTransferApproval")
	public String intraTransferApproval(Model model) {
		return "approvalSection/IntraTransferApproval";
	}

	@GetMapping("/regularEMIApproval")
	public String regularEMIApproval(Model model) {
		return "approvalSection/RegularEMIApproval";
	}

	@GetMapping("/irrularEMIApproval")
	public String irrularEMIApproval(Model model) {
		return "approvalSection/IrrularEMIApproval";
	}

	@GetMapping("/paymentEntryApproval")
	public String paymentEntryApproval(Model model) {
		return "approvalSection/PaymentEntryApproval";
	}

	@GetMapping("/maturityApplicationApproval")
	public String maturityApplicationApproval(Model model) {
		return "approvalSection/MaturityApplicationApproval";
	}

	@GetMapping("/maturityApplicationDelete")
	public String maturityApplicationDelete(Model model) {
		return "approvalSection/MaturityApplicationDelete";
	}
	
	/* BRANCH CASH TRANSFER APPROVAL */

	@GetMapping("/CSPCashTransferApproval")
	public String CSPCashTransferApproval(Model model) {
		List<BranchMaster> branchData = branchMasterRepo.findAll();
		model.addAttribute("branchList", branchData);
		return "approvalSection/CSPCashTransferApproval";
	}
	
	@PostMapping("/cspCashTransferApproval")
	@ResponseBody
	public List<CashStatement> cspCashTransferApproval(@RequestBody CashStatement cash){
		List<CashStatement> list1 = cashStatementrepo.findBybranchName(cash.getBranchName());
		List<CashStatement> list2 = cashStatementrepo.findBytxnDateBetween(cash.getFromDate(), cash.getToDate());
		if(!list1.isEmpty()) {
			return list1;
		}else
			return list2;
	}
	
	/* */

}
