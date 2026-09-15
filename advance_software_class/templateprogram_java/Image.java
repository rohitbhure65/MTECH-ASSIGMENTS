public class Image implements Addable<Image> {
    public String imageData;

    public Image(String data) {
        this.imageData = data;
    }

    @Override
    public Image add(Image other) {
        return new Image(this.imageData + " [COMBINED WITH] " + other.imageData);
    }
}
