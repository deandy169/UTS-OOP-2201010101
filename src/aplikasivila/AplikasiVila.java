package aplikasivila;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * I Gede Andi Utama Giri (2201010101)
 * 14-05-2024
 */

class Kamar {
    private int nomorKamar;
    private String tipeKamar;
    private boolean terisi;

    public Kamar(int nomorKamar, String tipeKamar) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.terisi = false; // Default kamar tidak terisi
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

class ManajerVila {
    private List<Kamar> kamarList;

    public ManajerVila(int kapasitas) {
        kamarList = new ArrayList<>(kapasitas);
    }

    public void tambahKamar(Kamar kamar) {
        kamarList.add(kamar);
    }

    public void tampilkanKamar() {
        if (kamarList.isEmpty()) {
            System.out.println("Belum ada kamar yang ditambahkan.");
            return;
        }

        System.out.printf("%-10s %-20s %-10s%n", "Nomor", "Tipe Kamar", "Terisi");
        System.out.println("==============================================");

        for (Kamar kamar : kamarList) {
            System.out.printf("%-10d %-20s %-10s%n", 
                kamar.getNomorKamar(), 
                kamar.getTipeKamar(), 
                kamar.isTerisi() ? "Ya" : "Tidak"
            );
        }
    }

    public void ubahKamar(int nomorKamar, String tipeKamar, boolean terisi) {
        for (Kamar kamar : kamarList) {
            if (kamar.getNomorKamar() == nomorKamar) {
                kamar.setTipeKamar(tipeKamar);
                kamar.setTerisi(terisi);
                return;
            }
        }
        System.out.println("Kamar dengan nomor " + nomorKamar + " tidak ditemukan.");
    }

    public void hapusKamar(int nomorKamar) {
        kamarList.removeIf(kamar -> kamar.getNomorKamar() == nomorKamar);
    }
}

public class AplikasiVila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManajerVila manajer = new ManajerVila(10);

        // Welcome message with ASCII art
        System.out.println("****************************************");
        System.out.println("*          Selamat Datang di           *");
        System.out.println("*             Aplikasi Vila            *");
        System.out.println("****************************************");

        while (true) {
            // Display menu
            System.out.println("\n=========== Menu ===========");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Tampilkan Kamar");
            System.out.println("3. Ubah Kamar");
            System.out.println("4. Hapus Kamar");
            System.out.println("5. Keluar");
            System.out.println("=============================");
            System.out.print("Pilih opsi (1-5): ");
            
            // Handle menu selection
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Mengkonsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan Nomor Kamar: ");
                    int nomorKamar = scanner.nextInt();
                    scanner.nextLine();  // Mengkonsumsi newline
                    System.out.print("Masukkan Tipe Kamar: ");
                    String tipeKamar = scanner.nextLine();
                    manajer.tambahKamar(new Kamar(nomorKamar, tipeKamar));
                    System.out.println("Kamar berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.println("\nDaftar Kamar:");
                    manajer.tampilkanKamar();
                    break;
                case 3:
                    System.out.print("\nMasukkan Nomor Kamar yang ingin diubah: ");
                    int nomorKamarUbah = scanner.nextInt();
                    scanner.nextLine();  // Mengkonsumsi newline
                    System.out.print("Masukkan Tipe Kamar baru: ");
                    String tipeKamarBaru = scanner.nextLine();
                    System.out.print("Apakah Kamar Terisi (true/false): ");
                    boolean terisiBaru = scanner.nextBoolean();
                    manajer.ubahKamar(nomorKamarUbah, tipeKamarBaru, terisiBaru);
                    System.out.println("Kamar berhasil diubah!");
                    break;
                case 4:
                    System.out.print("\nMasukkan Nomor Kamar yang ingin dihapus: ");
                    int nomorKamarHapus = scanner.nextInt();
                    manajer.hapusKamar(nomorKamarHapus);
                    System.out.println("Kamar berhasil dihapus!");
                    break;
                case 5:
                    System.out.println("\nTerima kasih telah menggunakan Aplikasi Vila. Sampai jumpa!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}

