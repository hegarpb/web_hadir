Feature: Delete Jadwal
         sebagai user saya ingin menghapus Jadwal
         dengan feature hapus Jadwal

  @Positive
  Scenario Outline: Delete jadwal
    Given user melakukan login sebagai admin dan berada di halaman Jadwal
    When user menekan tombol action pada "<namaJadwal>".
    When user menekan tombol delete pada menu dropdown
    When user menekan tombol Ya pada pesan konfirmasi dialog
    Then nama jadwal akan terhapus dari tabel dan sistem akan menpilkan pesan "Berhasil hapus jadwal"

    Examples:
      | namaJadwal     |
      | Jadwal Terbaru |
