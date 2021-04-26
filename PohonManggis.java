import java.util.Random;
import java.util.ArrayList;

public class PohonManggis extends Tumbuhan implements Penghijauan, Komoditas{
    private int minGas = 5;
    private int maxGas = 30;
    private int harga;
    private int[] statusBuah = new int[3];
    private Random r = new Random();
    private ArrayList<BuahManggis> listBuah;
    public int producedO2 = 15;
    public int absorbedCO2 = 5;
    public int jmlDaun;
    public PohonManggis()
    {
        listBuah = new ArrayList<BuahManggis>();
        jmlDaun = 5;
        harga = 1000;
    }
    @Override
    public void fotosintesis()
    {
        producedO2 += r.nextInt((maxGas - minGas) + 1) + minGas;
        absorbedCO2 += r.nextInt((maxGas - minGas) + 1) + minGas;
    }

    @Override
    public void tumbuhDaun()
    {
        jmlDaun += r.nextInt(5);
    }

    @Override
    public void rontokDaun()
    {
        jmlDaun -= r.nextInt(2);
    }

    public ArrayList<BuahManggis> berbuah(int umur)
    {
        if (umur > 20) {
            if (umur % 5 == 0) {
                listBuah.add(new BuahManggis(umur));
            }
        }
        return listBuah;
    }


    @Override
    public void setHarga(int harga)
    {
        this.harga = harga;
    }

    @Override
    public int getHarga()
    {
        return harga;
    }

    public String dailyRoutine(int umur)
    {
        //reset status kematangan buah
        statusBuah[0] = 0;
        statusBuah[1] = 0;
        statusBuah[2] = 0;

        //tumbuh
        tumbuh();

        //fotosintessis
        fotosintesis();

        //tumbuhDaun
        tumbuhDaun();

        //rontokDaun
        rontokDaun();

        //berbuah
        berbuah(umur);

        //kematangan buah
       for(BuahManggis buah : listBuah){
            if(buah.kematangan.matches("Belum matang"))
                statusBuah[0] += 1;
            if(buah.kematangan.matches("Matang"))
                statusBuah[1] += 1;
            if(buah.kematangan.matches("Busuk"))
                statusBuah[2] += 1;
        };


        //print status
        return "======= Status Pohon Manggis ==========" +
                "\nJumlah daun : " + jmlDaun +
                "\nTinggi batang pokok : " + tinggi +
                "\nJumlah Buah : " + listBuah.size() +
                "\n  - Belum matang : " +  statusBuah[0] +
                "\n  - Matang : " +  statusBuah[1] +
                "\n  - Busuk : " +  statusBuah[2] +
                "\nCO2 diserap : " + absorbedCO2 +
                "\nO2 dihasilkan : " + producedO2;
    }
}