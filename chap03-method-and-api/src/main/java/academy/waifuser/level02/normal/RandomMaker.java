package academy.waifuser.level02.normal;

public class RandomMaker {
    public int randomNumber(int min, int max){
        int winningNumber = min + (int) (Math.random()*(max-min));
        return winningNumber;
    }

    public String randomUpperAlphabet(int length) {
        String nonsense = "";
        for (int i = 0; i < length; i++) {
            nonsense = nonsense + (char) (60 + Math.random() * 26);
        }
        return nonsense;
    }
}
