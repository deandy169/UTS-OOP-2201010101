
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasivila;

/**
 *
 * @author andi
 */

public class ManajerVila {
    private Kamar[] kamars;
    private int jumlahKamar;

    public ManajerVila(int ukuran) {
        kamars = new Kamar[ukuran];
        jumlahKamar = 0;
    }

    public void tambahKamar(Kamar kamar) {
        if (jumlahKamar < kamars.length) {
            kamars[jumlahKamar] = kamar;
            jumlahKamar++;
        } else {
            System.out.println("Array penuh, tidak dapat menambah kamar lagi.");
        }
    }

    public void tampilkanKamar() {
        for (int i = 0; i < jumlahKamar; i++) {
            System.out.println("Nomor Kamar: " + kamars[i].getNomorKamar() +
                               ", Tipe Kamar: " + kamars[i].getTipeKamar() +
                               ", Terisi: " + kamars[i].isTerisi());
        }
    }

    public void ubahKamar(int nomorKamar, String tipeKamarBaru, boolean terisiBaru) {
        int indeks = cariIndeksKamarBerdasarkanNomor(nomorKamar);
        if (indeks != -1) {
            kamars[indeks].setTipeKamar(tipeKamarBaru);
            kamars[indeks].setTerisi(terisiBaru);
        } else {
            System.out.println("Kamar tidak ditemukan.");
        }
    }

    public void hapusKamar(int nomorKamar) {
        int indeks = cariIndeksKamarBerdasarkanNomor(nomorKamar);
        if (indeks != -1) {
            for (int i = indeks; i < jumlahKamar - 1; i++) {
                kamars[i] = kamars[i + 1];
            }
            kamars[jumlahKamar - 1] = null;
            jumlahKamar--;
        } else {
            System.out.println("Kamar tidak ditemukan.");
        }
    }

    private int cariIndeksKamarBerdasarkanNomor(int nomorKamar) {
        for (int i = 0; i < jumlahKamar; i++) {
            if (kamars[i].getNomorKamar() == nomorKamar) {
                return i;
            }
        }
        return -1;
    }
}
