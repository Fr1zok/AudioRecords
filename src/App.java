import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Disc disc = new Disc();
        List<Record> records = new ArrayList<>();
        records.add(new Record("TWIST", "Chubby Checker", (short) 215, Style.ROCKNROLL));
        records.add(new Record("SMOOTH", "Santana Featuring Rob Thomas", (short) 253, Style.LATINPOP));
        records.add(new Record("MACK THE KNIFE", "Bobby Darin", (short) 192, Style.JAZZ));
        records.add(new Record("HOW DO I LIVE", "LeAnn Rimes", (short) 268, Style.POP));
        records.add(new Record("PARTY ROCK ANTHEM", "LMFAO Featuring Lauren Bennett & GoonRock", (short) 263, Style.ELECTROHOUSE));
        records.add(new Record("I GOTTA FEELING", "The Black Eyed Peas", (short) 291, Style.DANCE));
        records.add(new Record("MACARENA (BAYSIDE BOYS MIX)", "Los Del Rio", (short) 237, Style.DANCE));
        records.add(new Record("PHYSICAL", "Olivia Newton-John", (short) 223, Style.DANCE));
        records.add(new Record("YOU LIGHT UP MY LIFE", "Debby Boone", (short) 209, Style.POP));
        records.add(new Record("HEY JUDE", "The Beatles", (short) 428, Style.POPROCK));
        records.add(new Record("WE BELONG TOGETHER", "Mariah Carey", (short) 200, Style.RNB));
        records.add(new Record("UPTOWN FUNK!", "Mark Ronson Featuring Bruno Mars", (short) 270, Style.FUNK));
        records.add(new Record("UN-BREAK MY HEART", "Toni Braxton", (short) 272, Style.POP));
        records.add(new Record("YEAH!", "Usher Featuring Lil Jon & Ludacris", (short) 250, Style.HIPHOP));
        records.add(new Record("BETTE DAVIS EYES", "Kim Carnes", (short) 228, Style.SOFTROCK));
        records.add(new Record("ENDLESS LOVE", "Diana Ross & Lionel Richie", (short) 268, Style.POP));
        records.add(new Record("TONIGHT'S THE NIGHT (GONNA BE ALRIGHT)", "Rod Stewart", (short) 236, Style.SOFTROCK));
        records.add(new Record("FOOLISH GAMES / YOU WERE MEANT FOR ME", "Jewel", (short) 253, Style.FOLK));
        records.add(new Record("(EVERYTHING I DO) I DO IT FOR YOU", "Bryan Adams", (short) 394, Style.SOFTROCK));
        records.add(new Record("I'LL MAKE LOVE TO YOU", "Boyz II Men", (short) 244, Style.RNB));
        records.add(new Record("THE THEME FROM \"A SUMMER PLACE\"", "Percy Faith And His Orchestra", (short) 145, Style.EASYLISTENING));
        records.add(new Record("LE FREAK", "Chic", (short) 323, Style.DISCO));
        records.add(new Record("HOW DEEP IS YOUR LOVE", "Bee Gees", (short) 246, Style.POP));
        records.add(new Record("EYE OF THE TIGER", "Survivor", (short) 246, Style.ROCK));
        records.add(new Record("WE FOUND LOVE", "Rihanna Featuring Calvin Harris", (short) 205, Style.ELECTROHOUSE));
        MenuManager.getInstance().showMainMenu(disc, records);
    }
}
