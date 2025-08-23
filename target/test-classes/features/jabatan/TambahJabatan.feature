Feature: Tambah Jabatan
  Sebagai pengguna
  Saya ingin dapat menambahkan jabatan baru
  Sehingga sistem dapat menyimpan atau memvalidasi input dengan benar
  # Positive Test Data Valid (Nama baru dan level baru)

  Scenario Outline: Tambah jabatan baru dengan data nama baru dan level baru
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan sukses "<message>"

    Examples:
      | nama            | level | message                        |
      | Kel3 ValidData3 |     9 | Berhasil Menambahkan Job Level |
#Positive Test Data Valid 

  Scenario Outline: Tambah jabatan baru dengan data nama yang sudah ada tetapi level berbeda
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan sukses "<message>"

    Examples:
      | nama     | level | message                        |
      | SPVBaru5 |     2 | Berhasil Menambahkan Job Level |
         # Positive Test Data Valid 

  Scenario Outline: Tambah jabatan baru dengan data  Nama baru dan level yang sudah ada
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan sukses "<message>"

    Examples:
      | nama                  | level | message                        |
      | Assistant Manager HKK |     1 | Berhasil Menambahkan Job Level |
  # Negative Test - Data Invalid 

  Scenario Outline: Validasi penambahan jabatan dengan data invalid (nama yang sama dan level yang sama,inputan level non numeric,level negtif atau minus)
    Given user sudah login dan berada di halaman Manajemen Jabatan
    When user menekan tombol tambahkan
    When user menginput jabatan dengan nama "<nama>" dan level "<level>"
    When user menekan tombol tambah di form tambah jabatan
    Then sistem menampilkan pesan error "<message>"

    Examples:
      | nama       | level | message                     |
      | Karyawan14 |     1 | Gagal Menambahkan Job Level |
      | SPVVVv     | abc   | Gagal Menambahkan Job Level |
  # Negative Test - Field Kosong

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

  Scenario Outline: Batal menambah jabatan dengan menekan tombol batal pada form tambah jabatan
    Given user sudah login sebagai admin dan berada di halaman Manajemen jabatan
    When user sudah login dan berada di halaman Manajemen Jabatan
    And user menekan tombol tambahkan
    And user menginput jabatan dengan nama "<nama>" dan level "<level>"
    And user menekan tombol batal di form tambah jabatan
    Then form pada tambah jabatan akan tertutup

    Examples:
      | nama      | level |
      | TestBatal |     3 |
