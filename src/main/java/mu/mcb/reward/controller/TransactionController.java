package mu.mcb.reward.controller;

import lombok.RequiredArgsConstructor;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerResponse;
import mu.mcb.reward.dto.Transaction;
import mu.mcb.reward.dto.TransactionRequest;
import mu.mcb.reward.service.TransactionService;
import mu.mcb.reward.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<Transaction> postTransaction(@RequestBody TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.postTransaction(transactionRequest));
    }

//    @GetMapping("/{customerId}")
//    public ResponseEntity<Transaction> getTransaction(@PathVariable TransactionRequest transactionRequest) {
//        return ResponseEntity.ok(transactionService.getTransactionList(transactionRequest));
//    }
}
