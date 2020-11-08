import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String DIVIDER = "-----------------------------------------------------------------------------";

    private static final KeyboardManager kb = KeyboardManager.getInstance();
    private static Disc disc = new Disc();

    public static void main(String[] args) {
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
        records.add(new Record("TONIGHT\'S THE NIGHT (GONNA BE ALRIGHT)", "Rod Stewart", (short) 236, Style.SOFTROCK));
        records.add(new Record("FOOLISH GAMES / YOU WERE MEANT FOR ME", "Jewel", (short) 253, Style.FOLK));
        records.add(new Record("(EVERYTHING I DO) I DO IT FOR YOU", "Bryan Adams", (short) 394, Style.SOFTROCK));
        records.add(new Record("I'LL MAKE LOVE TO YOU", "Boyz II Men", (short) 244, Style.RNB));
        records.add(new Record("THE THEME FROM \"A SUMMER PLACE\"", "Percy Faith And His Orchestra", (short) 145, Style.EASYLISTENING));
        records.add(new Record("LE FREAK", "Chic", (short) 323, Style.DISCO));
        records.add(new Record("HOW DEEP IS YOUR LOVE", "Bee Gees", (short) 246, Style.POP));
        records.add(new Record("EYE OF THE TIGER", "Survivor", (short) 246, Style.ROCK));
        records.add(new Record("WE FOUND LOVE", "Rihanna Featuring Calvin Harris", (short) 205, Style.ELECTROHOUSE));

        int option = -1;
        while (option != 0) {
            System.out.println(DIVIDER);
            System.out.println("Collection: " + disc.getRecords().size() + " tracks, " + convertSecondsToMinSec(disc.getCapacity()) + " left");
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
                    int selectedRecordNumber = addNewRecord(records);
                    Record selectedRecord = records.get(selectedRecordNumber);
                    System.out.println(disc.addTrack(selectedRecord));
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
            printTracks(records);
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
    private static void removeRecord() {}

    private static void showCollection() {
        printTracks(disc.getRecords());
        System.out.println("Collection: " + disc.getRecords().size() + " tracks, " + convertSecondsToMinSec(disc.getCapacity()) + " left");
    }

    private static void recordCollection() {
        System.out.println(disc.recordCollection());
    }

    private static String convertSecondsToMinSec(short length) {
        int minutes = length / 60;
        int seconds = length % 60;
        String secondsString = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
        return minutes + ":" + secondsString;
    }

    private static void printTracks(List<Record> records) {
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
    }
}
