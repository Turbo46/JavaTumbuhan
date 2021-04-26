
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Hari tidak dimasukkan.");
            System.exit(1);
        }
        int hari = Integer.parseInt(args[0]);
        PohonManggis pohonManggis = new PohonManggis();
        PohonPisang pohonPisang = new PohonPisang();
        for (int umur=0; umur < hari; umur++) {
            System.out.println("Hari ke-" + (umur + 1));
            System.out.println(pohonManggis.dailyRoutine(umur));
            System.out.println(pohonPisang.dailyRoutine(umur));
            System.out.println("\n");
        }
    }
}