Feature: Tombol Pagination
  Sebagai user
  Saya ingin melakukan perpindahan halaman dengan tombol pagination

  Scenario: Berpindah ke halaman selnajutnya dengan menekan tombol selanjutnya
    Given user sudah login dan berada di halaman manajemen jabatan
    When user menekan tombol selanjutnya
    Then halaman akan berpindah ke halaman berikutnya

  Scenario: Berpindah ke halaman sebelumnya dengan menekan tombol sebelumnya
    Given user sudah login dan berada di halaman manajemen jabatan
    When user menekan tombol selanjutnya
    When user menekan tombol sebelumnya
    Then halaman akan berpindah ke halaman sebelumnya

  Scenario: Berpindah ke halaman sebelumnya dengan menekan tombol sebelumnya
    Given user sudah login dan berada di halaman manajemen jabatan
    When user menekan tombol ke halaman terakhir
    Then halaman akan berpindah ke halaman terakhir

  Scenario: Berpindah ke halaman sebelumnya dengan menekan tombol sebelumnya
    Given user sudah login dan berada di halaman manajemen jabatan
    When user menekan tombol ke halaman terakhir
    When user menekan tombol kembali ke halaman awal
    Then halaman akan berpindah ke halaman awal
