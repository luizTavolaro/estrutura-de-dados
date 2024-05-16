public class Main {
    public static void main(String[] args) {
        Util_ util = new Util_();
        String music = util.readFile();
        util.fillTree(music);
    }
}
