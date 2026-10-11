class ReportBuilder {
    private String title       = "Untitled Report";
    private String separator   = "-";
    private int    width       = 40;
    private String headerStyle = "plain";
    private boolean showDate   = false;
    private String footer      = "";

    ReportBuilder setTitle(String title)           { this.title       = title;       return this; }
    ReportBuilder setSeparator(String sep)         { this.separator   = sep;         return this; }
    ReportBuilder setWidth(int width)              { this.width       = width;       return this; }
    ReportBuilder setHeaderStyle(String style)     { this.headerStyle = style;       return this; }
    ReportBuilder showDate(boolean show)           { this.showDate    = show;        return this; }
    ReportBuilder setFooter(String footer)         { this.footer      = footer;      return this; }

    String build(String content) {
        StringBuilder sb = new StringBuilder();
        String line = separator.repeat(width);

        switch (headerStyle) {
            case "box"  -> sb.append("+" + "-".repeat(width - 2) + "+\n")
                             .append("| " + center(title, width - 4) + " |\n")
                             .append("+" + "-".repeat(width - 2) + "+\n");
            case "star" -> sb.append("*".repeat(width) + "\n")
                             .append(center("** " + title + " **", width) + "\n")
                             .append("*".repeat(width) + "\n");
            default     -> sb.append(line + "\n")
                             .append(center(title, width) + "\n")
                             .append(line + "\n");
        }

        if (showDate) sb.append("Date: " + java.time.LocalDate.now() + "\n");

        sb.append("\n").append(content).append("\n");
        sb.append(line);
        if (!footer.isEmpty()) sb.append("\n").append(center(footer, width));

        return sb.toString();
    }

    private String center(String s, int w) {
        if (s.length() >= w) return s;
        int pad = (w - s.length()) / 2;
        return " ".repeat(pad) + s;
    }
}

public class ParametersDemo {
    public static void main(String[] args) {
        System.out.println("=== Variability Mechanism: PARAMETERS ===\n");

        String content = "1. Sales Q1: 50,000\n2. Sales Q2: 75,000\n3. Sales Q3: 90,000";

        System.out.println("--- Bound Parameter Set 1: Plain Style ---");
        ReportBuilder r1 = new ReportBuilder()
            .setTitle("Sales Report")
            .setSeparator("=")
            .setWidth(40)
            .setHeaderStyle("plain")
            .showDate(true)
            .setFooter("Confidential");
        System.out.println(r1.build(content));

        System.out.println();

        System.out.println("--- Bound Parameter Set 2: Box Style ---");
        ReportBuilder r2 = new ReportBuilder()
            .setTitle("Annual Summary")
            .setSeparator("-")
            .setWidth(42)
            .setHeaderStyle("box")
            .showDate(false)
            .setFooter("Page 1 of 1");
        System.out.println(r2.build(content));

        System.out.println();

        System.out.println("--- Bound Parameter Set 3: Star Style ---");
        ReportBuilder r3 = new ReportBuilder()
            .setTitle("Top Secret")
            .setSeparator("~")
            .setWidth(44)
            .setHeaderStyle("star")
            .showDate(true);
        System.out.println(r3.build(content));
    }
}
