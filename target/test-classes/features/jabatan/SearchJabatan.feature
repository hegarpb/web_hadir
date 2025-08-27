Feature: Search Level Jabatan
          Sebagai pengguna saya 
          ingin mencri level jabatan agar dapat melihat daftar jabatan dengan level tertentu

  @Positive
  Scenario Outline: Search jabatan berdasarkan level
    Given user sudah melakukan login dan berada pada halaman Manajemen Jabatan
    When user menginput "<level>" pada field pencarian
    When user menekan tombol search setelah menginput "<level>"
    Then semua jabatan yang ditampilkan memiliki level "<level>"

    Examples:
      | level |
      |     9 |

  @Positive
  Scenario Outline: Search jabatan dengan level yang tidak ada
    Given user sudah melakukan login dan berada pada halaman Manajemen Jabatan
    When user menginput "<level>" pada field pencarian
    When user menekan tombol search setelah menginput "<level>"
    Then tidak ada jabatan yang ditampilkan

    Examples:
      | level |
      | 10000 |

  @Positive
  Scenario Outline: Search jabatan dengan input alfabet
    Given user sudah melakukan login dan berada pada halaman Manajemen Jabatan
    When user menginput "<level>" pada field pencarian
    When user menekan tombol search setelah menginput "<level>"
    Then tidak ada jabatan yang ditampilkan

    Examples:
      | level |
      | abc   |
