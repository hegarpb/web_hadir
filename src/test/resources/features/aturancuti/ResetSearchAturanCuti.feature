Feature: Tombol Reset
  Seabagai user saya ingin melakukan reset setelah melakukan kaukanpencarian aturan cuti
  dengan featur searach pada halaman Aturan cuti

  Scenario Outline: Pencarian aturan cuti
    Given user login sebagai admin dan berada di halaman Aturan cuti
    When user menginputkan "<namaAturan>" dalam field cari berdasarkan nama
    And user mengklik tombol search di halaman aturan cuti
    And user mengklik tombol Reset
    Then tabel kembali menampilkan semua aturan cuti

    Examples:
      | namaAturan |
      | Cuti Hamil | 
