public abstract class Buah {
    public String rasa;
    public String kematangan;
    public int umur;
    public Buah(int umur)
    {
        this.umur = umur;
        ubahRasa(umur);
    }
    public void ubahRasa(int umur)
    {
        if(umur >= 25 && umur < 30) {
            rasa = "Asam";
            kematangan = "Belum matang";
        } else if(umur >= 30 && umur < 40) {
            rasa = "Manis";
            kematangan = "Matang";
        } else if(umur >= 40){
            rasa = "Pahit";
            kematangan = "Busuk";
        } else {
            rasa = "N/A";
            kematangan = "N/A";
        }    
    }
}