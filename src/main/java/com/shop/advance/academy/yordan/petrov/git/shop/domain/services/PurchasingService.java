package com.shop.advance.academy.yordan.petrov.git.shop.domain.services;

import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.TransactionServiceModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.TransactionServiceViewModel;
import org.springframework.stereotype.Service;

/**
 * Interface service for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@Service
public interface PurchasingService {

    /**
     * @param transaction
     * @return
     */
    TransactionServiceViewModel payByCard(TransactionServiceModel transaction);

    /**
     * @param transaction
     * @return
     */
    TransactionServiceViewModel refundCardPurchase(TransactionServiceModel transaction);
}
