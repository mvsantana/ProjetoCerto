package com.livrariacorreta.livrariaapi.service.impl;

import com.livrariacorreta.livrariaapi.api.dto.LoanFilterDTO;
import com.livrariacorreta.livrariaapi.exception.BusinessException;
import com.livrariacorreta.livrariaapi.model.entity.Book;
import com.livrariacorreta.livrariaapi.model.entity.Loan;
import com.livrariacorreta.livrariaapi.model.repository.LoanRepository;
import com.livrariacorreta.livrariaapi.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class LoanServiceimpl implements LoanService {

    private LoanRepository repository;

    public LoanServiceimpl(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Loan save(Loan loan) {
        if (repository.existsByBookAndNotReturned(loan.getBook()) ){
         throw new BusinessException("Book already loaned");
        }
        return repository.save(loan);
    }

    @Override
    public Optional<Loan> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Loan update(Loan loan) {

        return repository.save(loan);
    }

    @Override
    public Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable) {
        return repository.findByBookIsbnOrCustomer(filterDTO.getIsbn(), filterDTO.getCustomer(), pageable);
    }

    @Override
    public Page<Loan> getLoansByBook(Book book, Pageable pageable) {
        return repository.findBYBook(book, pageable);
    }
}
