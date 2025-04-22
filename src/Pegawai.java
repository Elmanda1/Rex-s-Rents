import java.io.IOException; // Tambahkan import untuk LocalDate
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Pegawai extends Akun {
    private static final Scanner obj = new Scanner(System.in);
    private static ArrayList<Pelanggan> daftarPelanggan = Pelanggan.readFromCSV();

    private ArrayList<Mobil> daftarMobil = Mobil.readFromCSV(); // Akan diatur dari Admin/Main

    private static ArrayList<Transaksi> daftarTransaksi = Transaksi.readFromCSV();

    public Pegawai(String username, String password) {
        super(username, password);
    }

    // Hapus deklarasi ulang Scanner di tampilkanMenu()
    public void tampilkanMenu() {
        int pilihan = 0; // Inisialisasi dengan nilai default
        do {
            try {
                clearScreen();
            } catch (IOException | InterruptedException e) {
                System.out.println("Gagal membersihkan layar: " + e.getMessage());
            }

            System.out.println("====================================");
            System.out.println("||       Pegawai Rex's Rent       ||");
            System.out.println("====================================");
            System.out.println("|| 1. Tambah Data Pelanggan       ||");
            System.out.println("|| 2. Edit Data Pelanggan         ||");
            System.out.println("|| 3. Lihat Data Pelanggan        ||");
            System.out.println("|| 4. Tambah Transaksi Pelanggan  ||");
            System.out.println("|| 5. Lihat List Mobil Tersedia   ||");
            System.out.println("|| 6. Kembalikan Mobil            ||");
            System.out.println("|| 7. Logout                      ||");
            System.out.println("====================================");
            System.out.print("Pilih Menu: ");
            try {
                pilihan = obj.nextInt();
                obj.nextLine(); // Membersihkan buffer

                switch (pilihan) {
                    case 1:
                        tambahDataPelanggan();
                        tekanEnter();
                        break;
                    case 2:
                        editDataPelanggan();
                        tekanEnter();
                        break;
                    case 3:
                        liatDataPelanggan();
                        tekanEnter();
                        break;
                    case 4:
                        tambahTransaksi();
                        tekanEnter();
                        break;
                    case 5:
                        lihatListMobil();
                        tekanEnter();
                        break;
                    case 6:
                        kembalikanMobil(obj);
                        tekanEnter();
                        break;
                    case 7:
                        Pelanggan.writeToCSV(daftarPelanggan);
                        Mobil.writeToCSV(daftarMobil);
                        Transaksi.writeToCSV(daftarTransaksi);
                        System.out.println("Keluar dari menu pegawai.\n");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        tekanEnter();
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Masukkan angka sesuai menu.");
                obj.nextLine(); // Membersihkan buffer
                tekanEnter();
            }
        } while (pilihan != 7);
    }

    public void tambahDataPelanggan() {
        String nama;
        do {
            System.out.print("Nama Pelanggan: ");
            nama = obj.nextLine();
            if (nama.trim().isEmpty()) {
                System.out.println("Nama tidak boleh kosong. Silakan masukkan nama yang valid.");
            }
        } while (nama.trim().isEmpty());

        String noHp;
        do {
            System.out.print("No HP: ");
            noHp = obj.nextLine();
            if (!noHp.matches("\\d{10,13}")) { // Hanya angka, panjang 10-13 digit
                System.out.println("Nomor HP harus berupa angka dengan panjang 10-13 digit. Silakan coba lagi.");
            }
        } while (!noHp.matches("\\d{10,13}"));

        String noKtp;
        do {
            System.out.print("NIK: ");
            noKtp = obj.nextLine();
            if (!noKtp.matches("\\d{16}")) { // Hanya angka, panjang 16 digit
                System.out.println("NIK harus berupa angka dengan panjang 16 digit. Silakan coba lagi.");
            }
        } while (!noKtp.matches("\\d{16}"));

        String alamat;
        do {
            System.out.print("Alamat: ");
            alamat = obj.nextLine();
            if (alamat.trim().isEmpty()) {
                System.out.println("Alamat tidak boleh kosong. Silakan masukkan alamat yang valid.");
            }
        } while (alamat.trim().isEmpty());

        String gender;
        do {
            System.out.print("Gender (L/P): ");
            gender = obj.nextLine().toUpperCase(); // Ubah input menjadi huruf besar
            if (!gender.equals("L") && !gender.equals("P")) {
                System.out.println("Gender harus berupa 'L' (Laki-laki) atau 'P' (Perempuan). Silakan coba lagi.");
            }
        } while (!gender.equals("L") && !gender.equals("P"));

        Pelanggan pelanggan = new Pelanggan(nama, noHp, noKtp, alamat, gender);
        daftarPelanggan.add(pelanggan);
        System.out.println("Data pelanggan berhasil ditambahkan dengan ID: " + pelanggan.getIdPelanggan());
    }

    public void liatDataPelanggan() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        System.out.println(Pelanggan.getHeader());
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        for (Pelanggan pelanggan : daftarPelanggan) {
            System.out.println(pelanggan.getInfo());
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
    }

    public void editDataPelanggan() {
        System.out.println("Daftar Pelanggan:");
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPelanggan.get(i));
        }
        System.out.print("Masukkan ID Pelanggan yang ingin diubah: ");
        String id = obj.nextLine();

        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getIdPelanggan().equals(id)) {
                String nama;
                do {
                    System.out.print("Nama: ");
                    nama = obj.nextLine();
                    if (nama.trim().isEmpty()) {
                        System.out.println("Nama tidak boleh kosong. Silakan masukkan nama yang valid.");
                    }
                } while (nama.trim().isEmpty());
                pelanggan.setNama(nama);

                String noHp;
                do {
                    System.out.print("No HP: ");
                    noHp = obj.nextLine();
                    if (!noHp.matches("\\d{10,13}")) { // Hanya angka, panjang 10-13 digit
                        System.out
                                .println("Nomor HP harus berupa angka dengan panjang 10-13 digit. Silakan coba lagi.");
                    }
                } while (!noHp.matches("\\d{10,13}"));
                pelanggan.setNoHp(noHp);

                String alamat;
                do {
                    System.out.print("Alamat: ");
                    alamat = obj.nextLine();
                    if (alamat.trim().isEmpty()) {
                        System.out.println("Alamat tidak boleh kosong. Silakan masukkan alamat yang valid.");
                    }
                } while (alamat.trim().isEmpty());
                pelanggan.setAlamat(alamat);

                String gender;
                do {
                    System.out.print("Gender (L/P): ");
                    gender = obj.nextLine().toUpperCase(); // Ubah input menjadi huruf besar
                    if (!gender.equals("L") && !gender.equals("P")) {
                        System.out.println(
                                "Gender harus berupa 'L' (Laki-laki) atau 'P' (Perempuan). Silakan coba lagi.");
                    }
                } while (!gender.equals("L") && !gender.equals("P"));
                pelanggan.setGender(gender);

                System.out.println("Data pelanggan berhasil diubah!");
                return;
            }
        }
        System.out.println("Pelanggan dengan ID tersebut tidak ditemukan.");
    }

    public void tambahTransaksi() {
        // Ambil tanggal dan waktu dari sistem
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String tanggalWaktu = now.format(formatter);

        // Pilih pelanggan
        System.out.println("Daftar Pelanggan:");
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPelanggan.get(i).getInfo());
        }
        System.out.print("Pilih pelanggan (nomor): ");
        int pIndex = obj.nextInt() - 1;
        if (pIndex < 0 || pIndex >= daftarPelanggan.size()) {
            System.out.println("Pilihan pelanggan tidak valid.");
            return;
        }
        Pelanggan pelanggan = daftarPelanggan.get(pIndex);

        // Pilih mobil
        lihatListMobil();
        System.out.print("Pilih mobil (nomor): ");
        int mIndex = obj.nextInt() - 1;
        if (mIndex < 0 || mIndex >= daftarMobil.size() || !daftarMobil.get(mIndex).isTersedia()) {
            System.out.println("Pilihan mobil tidak valid atau mobil sedang disewa.");
            return;
        }
        Mobil mobil = daftarMobil.get(mIndex);

        System.out.print("Durasi Sewa (hari): ");
        int durasi = -1;
        do {
            try {
                durasi = obj.nextInt();
                if (durasi <= 0) {
                    System.out.println("Durasi sewa harus berupa angka positif. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Masukkan angka positif.");
                obj.nextLine(); // Membersihkan buffer
                durasi = -1; // Set nilai invalid untuk mengulang
            }
        } while (durasi <= 0);

        // Panggil konstruktor transaksi baru
        Transaksi transaksi = new Transaksi(tanggalWaktu, this, pelanggan, mobil, durasi);
        transaksi.proses();

        // Tandai mobil sebagai disewa
        mobil.setStatus(false);

        // Setelah transaksi dibuat, tampilkan ID transaksi
        System.out.println("Transaksi berhasil dibuat dengan ID: " + transaksi.getIdTransaksi());

        daftarTransaksi.add(transaksi);
        System.out.println("Transaksi berhasil diproses.");
    }

    public void kembalikanMobil(Scanner obj) {
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil yang tersedia untuk dikembalikan.");
            return;
        }

        System.out.println("Daftar Mobil yang Sedang Disewa:");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < daftarMobil.size(); i++) {
            if (!daftarMobil.get(i).isTersedia()) {
                System.out.printf("%-2d. %s\n", (i + 1), daftarMobil.get(i).getInfo());
            }
        }
        System.out.println("-------------------------------------------------------------------------------------");

        int index = -1;
        do {
            try {
                System.out.print("Pilih mobil yang akan dikembalikan (nomor): ");
                index = obj.nextInt() - 1;
                obj.nextLine(); // Membersihkan buffer

                if (index < 0 || index >= daftarMobil.size() || daftarMobil.get(index).isTersedia()) {
                    System.out.println("Pilihan tidak valid atau mobil sudah tersedia. Silakan coba lagi.");
                    index = -1; // Set nilai invalid untuk mengulang
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Masukkan angka yang sesuai.");
                obj.nextLine(); // Membersihkan buffer
                index = -1; // Set nilai invalid untuk mengulang
            }
        } while (index == -1);

        // Ubah status mobil menjadi tersedia
        daftarMobil.get(index).setStatus(true);
        System.out.println("Mobil berhasil dikembalikan: " + daftarMobil.get(index).getInfo());
    }

    public void lihatListMobil() {
        System.out.println(Mobil.getHeader());
        System.out.println("---------------------------------------------------------------------------------");
        for (Mobil mobil : daftarMobil) {
            if (mobil.isTersedia()) { // Hanya tampilkan mobil yang tersedia
                System.out.println(mobil.getInfo());
            }
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    // Clear screen
    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    // Tekan enter untuk melanjutkan
    public static void tekanEnter() {
        System.out.print("\nTekan enter untuk melanjutkan...");
        try {
            System.in.read(); // Menunggu input dari pengguna
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menunggu input.");
        }
    }
}
