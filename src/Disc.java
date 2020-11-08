import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disc {
    private short capacity = 4800;
    private List<Record> records = new ArrayList<>();

    public Disc() {
    }

    public Disc(short capacity, List<Record> records) {
        this.capacity = capacity;
        this.records = records;
    }

    public String addTrack(Record record) {
        if (record.getLength() > capacity) {
            return "No enough space!";
        } else {
            records.add(record);
            capacity -= record.getLength();
            return "Track Added.";
        }
    }

    public String recordCollection() {
        if (records.isEmpty()) {
            return "Collection is empty!";
        } else {
            capacity = 4800;
            records.clear();
            return "Disc recorded successfully";
        }
    }

    public short getCapacity() {
        return capacity;
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disc disc = (Disc) o;
        return capacity == disc.capacity &&
                Objects.equals(records, disc.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, records);
    }

    @Override
    public String toString() {
        return "Disc{" +
                "capacity=" + capacity +
                ", records=" + records +
                '}';
    }
}
