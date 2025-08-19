Feature: Tambah Jabatan
  Sebagai pengguna, saya ingin dapat menambahkan jabatan baru
  dengan berbagai skenario, termasuk validasi.

  Scenario Outline: Tambah jabatan baru dengan data valid
    Given user berada di halaman Manajemen Jabatan
    When user menambahkan jabatan dengan nama "<nama>" dan level "<level>"
    Then sistem menampilkan pesan sukses "<message>"

    Examples:
      | nama        | level | message                        |
      | Supervisor7 |     2 | Berhasil Menambahkan Job Level |

  Scenario Outline: Validasi penambahan jabatan dengan nama yang sudah ada
    Given user berada di halaman Manajemen Jabatan
    When user menambahkan jabatan dengan nama "<nama>" dan level "<level>"
    Then sistem menampilkan pesan error "<message>"

    Examples:
      | nama        | level | message                     |
      | Supervisor7 |     2 | Gagal Menambahkan Job Level |

  Scenario Outline: Validasi field kosong saat menambahkan jabatan
    Given user berada di halaman Manajemen Jabatan
    When user menambahkan jabatan dengan nama "<nama>" dan level "<level>"
    Then sistem menampilkan pesan validasi "<message_nama>" pada field nama jabatan
    And sistem menampilkan pesan validasi "<message_level>" pada field level jabatan

    Examples:
      | nama    | level | message_nama   | message_level  |
      |         |     2 | Isi isian ini. |                |
      | Manager |       |                | Isi isian ini. |
