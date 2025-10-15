Feature: Detail Jadwal
         Sebagai user saya ingin melihat detail jadwal
         denga feature detail pada halaman jadwal

  @Positive
  Scenario Outline: Menampilkan detail jadwal
    Given user login sebagai admin dan berada di halaman jadwal.
    When user menekan tombol action pada "<namaJadwal>"
    When user menekan menu detail
    Then detail jadwal akan muncul

    Examples:
      | namaJadwal |
      | Indolakto  |
