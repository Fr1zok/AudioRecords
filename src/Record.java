import java.util.Objects;

public class Record {
    private final String name;
    private final String author;
    private final short length;
    private final Style style;

    public Record(String name, String author, short length, Style style) {
        this.name = name;
        this.author = author;
        this.length = length;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public short getLength() {
        return length;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return length == record.length &&
                Objects.equals(name, record.name) &&
                Objects.equals(author, record.author) &&
                style == record.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, length, style);
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", length=" + length +
                ", style=" + style +
                '}';
    }
}
