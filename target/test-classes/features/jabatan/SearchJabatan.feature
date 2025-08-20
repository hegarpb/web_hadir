Feature: Filter Level Jabatan
          Sebagai pengguna saya 
          ingin memfilter level jabatan agar dapat melihat daftar jabatan dengan level tertentu
  #Positive Test

  Scenario Outline: Memfilter jabatan berdasarkan level
    Given user sudah melakukan login dan berada pada halaman Manajemen Jabatan
    When user menginput "<level>" pada field "inputSearchText"
    When user menekan tombol search setelah menginput "<level>"
    Then semua jabatan yang ditampilkan memiliki level "<level>"

    Examples:
      | level |
      |     2 |
  #Negative Test

  Scenario Outline: Memfilter jabatan dengan level yang tidak ada
    Given user sudah melakukan login dan berada pada halaman Manajemen Jabatan
    When user menginput "<level>" pada field "inputSearchText"
    When user menekan tombol search setelah menginput "<level>"
    Then tidak ada jabatan yang ditampilkan

    Examples:
      | level |
      | 10000 |
  #Negative Test

  Scenario Outline: Memfilter jabatan dengan input alfabet
    Given user sudah melakukan login dan berada pada halaman Manajemen Jabatan
    When user menginput "<level>" pada field "inputSearchText"
    When user menekan tombol search setelah menginput "<level>"
    Then tidak ada jabatan yang ditampilkan

    Examples:
      | level |
      | abc   |
