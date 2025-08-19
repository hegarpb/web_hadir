Feature: Reset Filter Level Jabatan
  Sebagai pengguna, saya ingin dapat mereset filter level jabatan
  untuk melihat kembali semua daftar jabatan tanpa filter.

  Scenario: Reset filter setelah melakukan pencarian
    Given user diarahkan ke halaman Manajemen Jabatan
    And user sudah melakukan pencarian level jabatan dengan level "2"
    When user mengklik tombol "Reset Filter"
    Then semua jabatan yang ditampilkan tidak dalam keadaan terfilter
