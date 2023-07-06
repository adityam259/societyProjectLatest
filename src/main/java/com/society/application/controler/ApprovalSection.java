package com.society.application.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.society.application.dto.Response;
import com.society.application.model.AddInvestment;
import com.society.application.repository.AddInvestmentRepo;

@Controller
public class ApprovalSection {
	
	@Autowired
	AddInvestmentRepo addInvestmentRepo;
	
	/* MEMBER APPROVAL */

	@GetMapping("/addMemberApproval")
	public String addMemberApproval(Model model) {
		return "approvalSection/AddMemberApproval";
	}

	@GetMapping("/shareIssueApproval")
	public String shareIssueApproval(Model model) {
		return "approvalSection/ShareIssueApproval";
	}

	@GetMapping("/advisorApproval")
	public String advisorApproval(Model model) {
		return "approvalSection/AdvisorApproval";
	}

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

	@GetMapping("/CSPCashTransferApproval")
	public String CSPCashTransferApproval(Model model) {
		return "approvalSection/CSPCashTransferApproval";
	}
	
	
	
	@PostMapping("/searchByBranchName")
	@ResponseBody
	public Response searchByBranchName(@RequestBody AddInvestment ai) {

		Response response = new Response<>();
		response.setStatus("Not Success");
		response.setMessage("Data Not Found ..!!");
		List<AddInvestment> addinvest = addInvestmentRepo.findBybranchName(ai.getBranchName());

		if (addinvest != null) {
			response.setStatus("Success");
			response.setMessage("Data Found !!!");
			response.setData(addinvest);
			return response;
		}

		return response;
	}
	
	
	@PostMapping("/searchByDate")
	@ResponseBody
	public Response searchByDate(@RequestBody AddInvestment ai) {

		Response response = new Response<>();
		response.setStatus("Not Success");
		response.setMessage("Data Not Found ..!!");

		List<AddInvestment> addinvest2 = addInvestmentRepo.findBymDateBetween(ai.getfDate(), ai.gettDate());

		if (addinvest2 != null) {
			response.setStatus("Success");
			response.setMessage("Data Found !!!");
			response.setData(addinvest2);
			return response;
		}
		return response;

	}
	

}
