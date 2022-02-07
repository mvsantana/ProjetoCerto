package com.livrariacorreta.livrariaapi.service;

import com.livrariacorreta.livrariaapi.api.dto.LoanFilterDTO;
import com.livrariacorreta.livrariaapi.model.entity.Book;
import com.livrariacorreta.livrariaapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LoanService {

    Loan save(Loan loan);

    Optional<Loan> getById(Long id);

    Loan update (Loan loan);

    Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable);

    Page<Loan> getLoansByBook(Book book, Pageable pageable);

}
