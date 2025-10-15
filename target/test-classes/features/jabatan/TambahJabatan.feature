Feature: Tambah Jabatan
  Sebagai pengguna
  Saya ingin dapat menambahkan jabatan baru
  Sehingga sistem dapat menyimpan atau memvalidasi input dengan benar

  @Positive
  Scenario Outline: Tambah jabatan baru dengan data nama baru dan level baru
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan sukses "<message>"
    Then level jabatan akan di tampilkan "<level>"

    Examples:
      | nama       | level | message                        |
      | Supervisor |    61 | Berhasil Menambahkan Job Level |

  @Positive
  Scenario Outline: Tambah jabatan baru dengan data nama yang sudah ada tetapi level berbeda
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan sukses "<message>"
    Then level jabatan akan di tampilkan "<level>"

    Examples:
      | nama       | level | message                        |
      | Supervisor |    66 | Berhasil Menambahkan Job Level |

  @Positive
  Scenario Outline: Tambah jabatan baru dengan data  Nama baru dan level yang sudah ada
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan sukses "<message>"
    Then level jabatan akan di tampilkan "<level>"

    Examples:
      | nama | level | message                        |
      | HRD  |    25 | Berhasil Menambahkan Job Level |

  @Negative
  Scenario Outline: Validasi penambahan jabatan dengan data invalid (nama yang sama dan level yang sama,inputan level non numeric,level negtif atau minus)
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan error "<message>"

    Examples:
      | nama         | level | message                     |
      | Karyawan     |     1 | Gagal Menambahkan Job Level |
      | Staff SQA    | abc   | Gagal Menambahkan Job Level |
      | Staff Khusus |   -30 | Gagal Menambahkan Job Level |

  @Negative
  Scenario Outline: Validasi field kosong saat menambahkan jabatan
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan validasi "<message_nama>" pada field nama jabatan
    And sistem menampilkan pesan validasi "<message_level>" pada field level jabatan

    Examples:
      | nama    | level | message_nama   | message_level  |
      |         |     2 | Isi isian ini. |                |
      | Manager |       |                | Isi isian ini. |

  @Positive
  Scenario Outline: Batal menambah jabatan dengan menekan tombol batal pada form tambah jabatan
    Given user sudah login sebagai admin dan berada di halaman Manajemen jabatan
    When user sudah login dan berada di halaman Manajemen Jabatan
    And user menekan tombol tambahkan
    And user menginput jabatan dengan nama "<nama>" dan level "<level>"
    And user menekan tombol batal di form tambah jabatan
    Then form pada tambah jabatan akan tertutup

    Examples:
      | nama    | level |
      | Manager |     3 |
