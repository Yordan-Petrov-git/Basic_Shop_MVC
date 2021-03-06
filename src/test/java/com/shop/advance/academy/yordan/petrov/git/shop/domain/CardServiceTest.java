package com.shop.advance.academy.yordan.petrov.git.shop.domain;

import com.shop.advance.academy.yordan.petrov.git.shop.data.dao.CardDao;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.Card;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.CardServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Class test  for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    @MockBean
    CardDao cardDao;

    @Autowired
    CardService cardService;

    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCardServiceReturnsAllCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card());
        cards.add(new Card());
        cards.add(new Card());

        Mockito.when(cardDao.findAll()).thenReturn(cards);
        List<CardServiceViewModel> cardServiceViewModels = cardService.getAllCards();

        assertEquals(3, cardServiceViewModels.size());
    }


    @Test
    public void testCardServiceGetCardsById() {
        Card card = new Card();
        card.setId(15L);

        Mockito.when(cardDao.findById(15L))
                .thenReturn(java.util.Optional.of(card));
        CardServiceViewModel cardServiceViewModel = this.modelMapper.map(card, CardServiceViewModel.class);

        assertEquals(cardServiceViewModel, cardService.getCardById(15L));
    }

    //TODO ADD TEST IF CREATES

    //TODO ADD TEST IF REMOVES

    //TODO ADD TEST IF UPDATES
}
