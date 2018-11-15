package lotto.view;

import lotto.domain.BundleLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoCountManager;
import lotto.domain.WinningLotto;
import lotto.exceptions.InputFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static LottoCountManager getBudget() throws InputFormatException {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            Scanner scanner = new Scanner(System.in);
            int budget = scanner.nextInt();

            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int manualCount = scanner.nextInt();
            return new LottoCountManager(budget, manualCount);
        } catch (Exception e) {
            throw new InputFormatException();
        }
    }

    public static WinningLotto getWinningNumberWithBonus() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            Scanner scanner = new Scanner(System.in);
            String winningLine = scanner.nextLine();

            System.out.println("보너스 볼을 입력해 주세요.");
            int bonusBall = scanner.nextInt();

            return new WinningLotto(Lotto.manual(winningLine), bonusBall);
        } catch (Exception e) {
            throw new InputFormatException();
        }
    }

    public static List<String> getManualLottoNumbers(LottoCountManager lottoCountManager) {
        try {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            List<String> manualLottoNumbers = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < lottoCountManager.getManualCount(); i++) {
                manualLottoNumbers.add(scanner.nextLine());
            }
            return manualLottoNumbers;
        } catch (Exception e) {
            throw new InputFormatException();
        }
    }
}
