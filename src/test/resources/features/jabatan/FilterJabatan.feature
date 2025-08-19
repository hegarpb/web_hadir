Feature: Filter Level Jabatan
          Sebagai pengguna saya 
          ingin memfilter level jabatan agar dapat melihat daftar jabatan dengan level tertentu

  Scenario Outline: Memfilter jabatan berdasarkan level
    Given user berada pada halaman Manajemen Jabatan
    When user mencari jabatan dengan level "<level>"
    Then semua jabatan yang ditampilkan memiliki level "<level>"

    Examples:
      | level |
      |     2 |

  Scenario Outline: Memfilter jabatan dengan level yang tidak ada
    Given user berada pada halaman Manajemen Jabatan
    When user mencari jabatan dengan level yang tidak ada "<level>"
    Then tidak ada jabatan yang ditampilkan

    Examples:
      | level |
      | 10000 |

  Scenario Outline: Memfilter jabatan dengan input alfabet
    Given user berada pada halaman Manajemen Jabatan
    When user mencari jabatan dengan level yang mengandung alfabet "<level>"
    Then tidak ada jabatan yang ditampilkan

    Examples:
      | level |
      | abc   |
