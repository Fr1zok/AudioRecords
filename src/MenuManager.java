import java.util.List;

public class MenuManager {

    private static final String DIVIDER = "-----------------------------------------------------------------------------";

    private static final KeyboardManager kb = KeyboardManager.getInstance();

    private static volatile MenuManager instance;

    public static MenuManager getInstance() {
        if (instance == null) {
            synchronized (MenuManager.class) {
                if (instance == null) {
                    instance = new MenuManager();
                }
            }
        }
        return instance;
    }

    private MenuManager() {}

    public void showMainMenu(Disc disc, List<Record> records) {
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
                    int selectedRecordNumber = showRecordsAndReturnNumberOfOne(records);
                    Record selectedRecord = records.get(selectedRecordNumber);
                    System.out.println(disc.addTrack(selectedRecord));
                    break;
                case 2:
                    int selectedTrackNumber = showRecordsAndReturnNumberOfOne(disc.getRecords());
                    System.out.println(disc.removeTrack(selectedTrackNumber));
                    break;
                case 3:
                    showCollection(disc);
                    break;
                case 4:
                    recordCollection(disc);
                    break;
                default:
                    System.out.println("Wrong option: " + option);
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    private int showRecordsAndReturnNumberOfOne(List<Record> records){
        int option = -1;
        while (option != 0) {
            printTracks(records);
            System.out.print("Please, enter composition number (0 - back): ");
            option = kb.getNumber();
            if (option > records.size()) {
                System.out.println("Wrong number!!!");
            } else {
                return option - 1;
            }
        }
        return 0;
    }

    private void showCollection(Disc disc) {
        printTracks(disc.getRecords());
        System.out.println("Collection: " + disc.getRecords().size() + " tracks, " + convertSecondsToMinSec(disc.getCapacity()) + " left");
    }

    private void recordCollection(Disc disc) {
        System.out.println(disc.recordCollection());
    }

    private String convertSecondsToMinSec(short length) {
        int minutes = length / 60;
        int seconds = length % 60;
        String secondsString = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
        return minutes + ":" + secondsString;
    }

    private void printTracks(List<Record> records) {
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
