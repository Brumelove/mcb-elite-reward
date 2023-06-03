package mu.mcb.reward.controller;

import lombok.RequiredArgsConstructor;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerResponse;
import mu.mcb.reward.dto.Transaction;
import mu.mcb.reward.dto.TransactionRequest;
import mu.mcb.reward.entity.TierEntity;
import mu.mcb.reward.enums.SubCategoryType;
import mu.mcb.reward.service.TierService;
import mu.mcb.reward.service.TransactionService;
import mu.mcb.reward.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {
    private final TransactionService transactionService;
    private final TierService tierService;


    @PostMapping()
    public ResponseEntity<Transaction> postTransaction(@RequestBody TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.postTransaction(transactionRequest));
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody TransactionRequest transactionRequest) {
        return ResponseEntity.ok("Transaction Updated successfully");
    }

    @PostMapping()
    public ResponseEntity<TierEntity> createTier(@RequestBody TierEntity transactionRequest) {
        return ResponseEntity.ok(tierService.createTier(transactionRequest));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<SubCategoryType>> getCategoryList() {
        return ResponseEntity.ok(SubCategoryType.getSubCategory());
    }
}
