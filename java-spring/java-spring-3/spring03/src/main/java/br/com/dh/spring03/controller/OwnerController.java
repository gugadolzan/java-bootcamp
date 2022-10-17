package br.com.dh.spring03.controller;

import br.com.dh.spring03.model.Owner;
import br.com.dh.spring03.service.IOwner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private IOwner ownerService;

    @GetMapping
    public ResponseEntity<List<Owner>> getAll() {
        return new ResponseEntity<>(ownerService.getAll(), HttpStatus.OK);
    }
}
