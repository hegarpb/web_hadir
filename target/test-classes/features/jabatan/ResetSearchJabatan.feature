Feature: Reset Filter Level Jabatan
  Sebagai pengguna, saya ingin dapat mereset filter level jabatan
  untuk melihat kembali semua daftar jabatan tanpa filter.

  Scenario: Reset filter setelah melakukan pencarian
    Given user sudah login dan diarahkan ke halaman Manajemen Jabatan
    When user sudah menginput level jabatan dengan level "2"
    When user menekan tombol search "Search"
    When user menekan tombol "Reset"
    Then semua jabatan yang ditampilkan tidak dalam keadaan terfilter
