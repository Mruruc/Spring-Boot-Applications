package com.mruruc.controller;

import com.mruruc.model.CashCard;
import com.mruruc.repository.CashCardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private CashCardRepository repo;
    private Optional<CashCard> card;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.repo = cashCardRepository;
    }

    @DeleteMapping("/delete/{id}")
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
    public HttpStatus addCard(@RequestBody CashCard newCard){
        repo.save(newCard);
        if(repo.existsById(newCard.getId())){
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @PutMapping("/update/{id}")
    public HttpStatus update(@PathVariable Long id,@RequestBody CashCard updatedCard){

        if(repo.existsById(id)){
            Optional<CashCard> cardOptional = repo.findById(id);
            if(cardOptional.isPresent()){
                CashCard card = cardOptional.get();
                card.setAmount(updatedCard.getAmount());
                repo.save(card);
                return HttpStatus.OK;
            }
            else {
                return HttpStatus.BAD_REQUEST;
            }

        }
        else{
            return HttpStatus.NO_CONTENT;
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<Iterable<CashCard>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }



    @GetMapping("/{requestedId}")
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
