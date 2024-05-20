/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasivila;

/**
 *
 * @author andi
 */

public class Kamar {
    private final int nomorKamar;
    private String tipeKamar;
    private boolean terisi;

    public Kamar(int nomorKamar, String tipeKamar) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.terisi = false;
    }

    public int getNomorKamar() {
        return nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public boolean isTerisi() {
        return terisi;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public void setTerisi(boolean terisi) {
        this.terisi = terisi;
    }
}