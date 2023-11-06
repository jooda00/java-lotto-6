package lotto.domain;

import lotto.validation.LottoValidation;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Lotto> lotteries = new ArrayList<>();
    private final int amount;

    public Player(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public ArrayList<Lotto> generateLotteries() {
        int size = convertToUnit();
        for (int i = 0; i < size; i++) {
            lotteries.add(Lotto.makeLotto());
        }
        return lotteries;
    }

    public int convertToUnit() {
        return this.amount / 1000;
    }

    private void validate(int amount) {
        LottoValidation.validateOverThousandUnit(amount);
        LottoValidation.validateIsThousandUnit(amount);
    }
}
