public class Paragraph implements Addable<Paragraph> {
    public String text;

    public Paragraph(String t) {
        this.text = t;
    }

    @Override
    public Paragraph add(Paragraph other) {
        return new Paragraph(this.text + "\n" + other.text);
    }
}
