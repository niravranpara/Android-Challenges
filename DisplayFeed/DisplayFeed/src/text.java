public class text extends bodyItem
{
    private String text;

    text(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print()
    {
        super.print();
        System.out.println(("Text: " + text ));
        System.out.println((""));

    }
}
