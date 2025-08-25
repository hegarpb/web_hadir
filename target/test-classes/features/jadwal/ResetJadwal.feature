Feature: Tombol Reset
  Seabagai user saya ingin melakukan reset setelah melakukan pencarian jadwal
  dengan feature searach pada halaman jadwal

  Scenario Outline: Reset Pencarian jadwal
    Given user login sebagai admin dan berada di halaman jadwal
    When user menginputkan "<namaJadwal>" dalam field cari berdasarkan nama di halaman
    And user mengklik tombol Search pada halaman jadwal
    And user mengklik tombol Reset serelah melakukan pencarian
    Then tabel kembali menampilkan semua nama jadwal

    Examples:
      | namaJadwal |
      | Indolakto  |
