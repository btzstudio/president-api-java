package tech.btzstudio.president.card;

import org.springframework.stereotype.Service;
import tech.btzstudio.president.card.domain.Card;
import tech.btzstudio.president.card.domain.CardPower;
import tech.btzstudio.president.card.domain.CardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class CardDispatcher {

    public Collection<Card> dispatch(final int decksCount) {
        Collection<Card> cards = new ArrayList<>();

        for (int deckIndex = 0; deckIndex < decksCount; deckIndex++) {
            Arrays.asList(CardType.values()).forEach(cardType -> {
                Arrays.asList(CardPower.values()).forEach(cardPower -> {
                    cards.add(new Card(cardType, cardPower));
                });
            });
        }

        return cards;
    }

    public Collection<Card> dispatch() {
        return this.dispatch(1);
    }
}
