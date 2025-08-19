Feature: Tambah Jabatan
  Sebagai pengguna
  Saya ingin dapat menambahkan jabatan baru
  Sehingga sistem dapat menyimpan atau memvalidasi input dengan benar
  # Positive Test

  Scenario Outline: Tambah jabatan baru dengan data valid
    Given user berada di halaman Manajemen Jabatan
    When user menambahkan jabatan dengan nama "<nama>" dan level "<level>"
    Then sistem menampilkan pesan sukses "<message>"

    Examples:
      | nama       | level | message                        |
      | Karyawan14 |     1 | Berhasil Menambahkan Job Level |
  # Negative Test - Data Invalid (nama yang sudah ada,inputan level non numeric)

  Scenario Outline: Validasi penambahan jabatan dengan data invalid
    Given user berada di halaman Manajemen Jabatan
    When user menambahkan jabatan dengan nama "<nama>" dan level "<level>"
    Then sistem menampilkan pesan error "<message>"

    Examples:
      | nama       | level | message                     |
      | Karyawan14 |     1 | Gagal Menambahkan Job Level |
      | SPVVVv     | abc   | Gagal Menambahkan Job Level |
  # Negative Test - Field Kosong

  Scenario Outline: Validasi field kosong saat menambahkan jabatan
    Given user berada di halaman Manajemen Jabatan
    When user menambahkan jabatan dengan nama "<nama>" dan level "<level>"
    Then sistem menampilkan pesan validasi "<message_nama>" pada field nama jabatan
    And sistem menampilkan pesan validasi "<message_level>" pada field level jabatan

    Examples:
      | nama    | level | message_nama   | message_level  |
      |         |     2 | Isi isian ini. |                |
      | Manager |       |                | Isi isian ini. |
