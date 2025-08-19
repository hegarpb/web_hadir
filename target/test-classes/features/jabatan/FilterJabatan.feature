Feature: Filter Level Jabatan

  Scenario Outline: Memfilter jabatan berdasarkan level
    Given user berada pada halaman Manajemen Jabatan
    When user mencari jabatan dengan level "<level>"
    Then semua jabatan yang ditampilkan memiliki level "<level>"

    Examples:
      | level |
      |     1 |
      |     2 |
      |     3 |
