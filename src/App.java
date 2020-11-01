import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String DIVIDER = "-----------------------------------------------------------------------------";

    private static KeyboardManager kb = KeyboardManager.getInstance();

    public static void main(String[] args) {
        List<Record> records = new ArrayList<>();
        records.add(new Record("TWIST", "Chubby Checker", (short) 215, Style.ROCKNROLL));
        records.add(new Record("SMOOTH", "Santana Featuring Rob Thomas", (short) 253, Style.LATINPOP));
        records.add(new Record("MACK THE KNIFE", "Bobby Darin", (short) 192, Style.JAZZ));

        int option = -1;
        while (option != 0) {
            System.out.println(DIVIDER);
            System.out.println("1: add new record to collection");
            System.out.println("2: remove record from collection");
            System.out.println("3: show collection");
            System.out.println("4: record collection to disk");
            System.out.println("0: exit");
            System.out.print("Please, enter command: ");
            option = kb.getNumber();
            switch (option) {
                case -1:
                    System.out.println("This method can accept numbers only");
                case 0:
                    break;
                case 1:
                    int i = addNewRecord(records);
                    break;
                case 2:
                    removeRecord();
                    break;
                case 3:
                    showCollection();
                    break;
                case 4:
                    recordCollection();
                    break;
                default:
                    System.out.println("Wrong option: " + option);
            }
        }
    }

    private static int addNewRecord(List<Record> records){
        int option = -1;
        while (option != 0) {
            System.out.println(DIVIDER);
            for (int i = 0; i < records.size(); i++) {
                System.out.print(i + 1);
                System.out.print(". ");
                Record record = records.get(i);
                System.out.print(record.getStyle());
                System.out.print(" - ");
                System.out.print(record.getAuthor());
                System.out.print(" - ");
                System.out.print(record.getName());
                System.out.print(" - ");
                System.out.println(convertSecondsToMinSec(record.getLength()));
            }
            System.out.print("Please, enter composition number (0 - back): ");
            option = kb.getNumber();
            if (option > records.size()) {
                System.out.println("Wrong number!!!");
            } else {
                return option;
            }
        }
        return 0;
    }
    private static void removeRecord(){}
    private static void showCollection(){}
    private static void recordCollection(){}

    private static String convertSecondsToMinSec(short length) {
        int minutes = length / 60;
        int seconds = length % 60;
        String secondsString = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
        return minutes + ":" + secondsString;
    }

        /*
        List<Track> files = new ArrayList<Track>();
        files.add(new Track("HOW DO I LIVE", 268, Style.POP, "LeAnn Rimes"));
        files.add(new Track("PARTY ROCK ANTHEM", 263, Style.ELECTROHOUSE, "LMFAO Featuring Lauren Bennett & GoonRock"));
        files.add(new Track("I GOTTA FEELING", 291, Style.DANCE, "The Black Eyed Peas"));
        files.add(new Track("MACARENA (BAYSIDE BOYS MIX)", 237, Style.DANCE, "Los Del Rio"));
        files.add(new Track("PHYSICAL", 223, Style.DANCE, "Olivia Newton-John"));
        files.add(new Track("YOU LIGHT UP MY LIFE", 209, Style.POP, "Debby Boone"));
        files.add(new Track("HEY JUDE", 428, Style.POPROCK, "The Beatles"));
        files.add(new Track("WE BELONG TOGETHER", 200, Style.RNB, "Mariah Carey"));
        files.add(new Track("UPTOWN FUNK!", 270, Style.FUNK, "Mark Ronson Featuring Bruno Mars"));
        files.add(new Track("UN-BREAK MY HEART", 272, Style.POP, "Toni Braxton"));
        files.add(new Track("YEAH!", 250, Style.HIPHOP, "Usher Featuring Lil Jon & Ludacris"));
        files.add(new Track("BETTE DAVIS EYES", 228, Style.SOFTROCK, "Kim Carnes"));
        files.add(new Track("ENDLESS LOVE", 268, Style.POP, "Diana Ross & Lionel Richie"));
        files.add(new Track("TONIGHT\'S THE NIGHT (GONNA BE ALRIGHT)", 236, Style.SOFTROCK, "Rod Stewart"));
        files.add(new Track("FOOLISH GAMES / YOU WERE MEANT FOR ME", 253, Style.FOLK, "Jewel"));
        files.add(new Track("(EVERYTHING I DO) I DO IT FOR YOU", 394, Style.SOFTROCK, "Bryan Adams"));
        files.add(new Track("I'LL MAKE LOVE TO YOU", 244, Style.RNB, "Boyz II Men"));
        files.add(new Track("THE THEME FROM \"A SUMMER PLACE\"", 145, Style.EASYLISTENING, "Percy Faith And His Orchestra"));
        files.add(new Track("LE FREAK", 323, Style.DISCO, "Chic"));
        files.add(new Track("HOW DEEP IS YOUR LOVE", 246, Style.POP, "Bee Gees"));
        files.add(new Track("EYE OF THE TIGER", 246, Style.ROCK, "Survivor"));
        files.add(new Track("WE FOUND LOVE", 205, Style.ELECTROHOUSE, "Rihanna Featuring Calvin Harris"))

         */
}
