package com.mruruc.controller;

import com.mruruc.model.CashCard;
import com.mruruc.repository.CashCardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CashCardController {

    private CashCardRepository repo;
    private Optional<CashCard> card;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.repo = cashCardRepository;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id){

        if(repo.existsById(id)){
            repo.deleteById(id);
            return HttpStatus.ACCEPTED;
        }
        else {
            return HttpStatus.NO_CONTENT;
        }
    }

    @PostMapping("/AddCard")
    public ResponseEntity<String> addCard(@RequestBody CashCard newCard){
        repo.save(newCard);
        if(repo.existsById(newCard.getId())){
            return ResponseEntity.ok("Successful");
        }
        else {
            return ResponseEntity.internalServerError().body("Try Again!");
        }
    }

    @PutMapping("/{id}")
    public HttpStatus update(@PathVariable Long id,@RequestBody CashCard updatedCard){

            Optional<CashCard> cardOptional = repo.findById(id);
            if(cardOptional.isPresent()){
                cardOptional.get().setAmount(updatedCard.getAmount());
                repo.save(cardOptional.get());
                return HttpStatus.OK;
            }
            else {
                return HttpStatus.NO_CONTENT;
            }

    }


    @GetMapping("/cards")
    public ResponseEntity<Iterable<CashCard>> findAll() {
        Iterable<CashCard> all = repo.findAll();
        return ResponseEntity.ok(all);
    }



    @GetMapping("/{requestedId}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "requested ID does not exist!")
    public ResponseEntity<CashCard> findById(@PathVariable("requestedId") Long requestedId) {

        Optional<CashCard> cashCardOptional = repo.findById(requestedId);

        if (cashCardOptional.isPresent()) {
            return ResponseEntity.ok(cashCardOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



//    @GetMapping("/cashcards/{requestedId}")
//    public CashCard findById(@PathVariable Long requestedId) {
//        CashCard cashCard = /* Here would be the code to retrieve the CashCard */;
//
//        return ResponseEntity.ok(cashCard);
//    }


//    @GetMapping("/{requestedId}")
//    public ResponseEntity<String> findById() {
//        return ResponseEntity.ok("{}");
//    }


//    @GetMapping("/{requestedId}")
//    public ResponseEntity<CashCard> findById(@PathVariable Long requestedId){
//
//        if(requestedId.equals(99L)){
//            card=new CashCard(99L,123.45);
//            return ResponseEntity.ok(card);
//        }
//        else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
