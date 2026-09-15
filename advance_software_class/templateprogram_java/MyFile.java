public class MyFile implements Addable<MyFile> {
    public String content;

    public MyFile(String c) {
        this.content = c;
    }

    @Override
    public MyFile add(MyFile other) {
        return new MyFile(this.content + "\n" + other.content);
    }
}
