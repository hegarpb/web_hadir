Feature: Edit Jabatan
        Sebagai user saya ingin mengubah nama jabatan
        dengan menggunakan fitur edit pada data jabatan
#Positive Test -Data Valid

  Scenario Outline: Mengubah nama jabatan dengan fitur edit dengan data yang valid.
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan "Assistant"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"

    Examples:
      | namaBaru  | levelBaru |
      | EDitBaru2 |         7 |

  Scenario Outline: Mengubah nama jabatan tetapi level tidak diubah
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan "EDitBaru2"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"

    Examples:
      | namaBaru         |
      | Anggota Pengawas |

  Scenario Outline: Mengubah level jabatan tetapi nama tidak diubah
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan "Ass Manager2"
    And user menekan tombol edit pada menu dropdown
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"

    Examples:
      | levelBaru |
      |        10 |
  # NegtiveTest - Data Invalid

  Scenario Outline: Mengubah nama jabatan dan level jabatan dengan nama jabatan dan level jabatan yang sudah ada,inputan level mengandung angka negtif
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan "Kepala Suku"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Gagal Edit Jabatan"

    Examples:
      | namaBaru | levelBaru |
      | Karyawan |         1 |
      | Sersan   |       -21 |

  Scenario Outline: Validasi field kosong saat mengubah data jabatan
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan "OB"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then pesan validasi "<message_nama>" akan muncul pada field nama jabatan
    Then pesan validasi "<message_level>" akan muncul pada field level jabatan

    Examples:
      | namaBaru | levelBaru | message_nama   | message_level  |
      |          |        25 | Isi isian ini. |                |
      | Pengawas |           |                | Isi isian ini. |

  Scenario Outline: Validasi field kosong saat mengubah data jabatan
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan "Dewan Pengawas"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol batal pada form edit jabatan
    Then form pada edit jabatan akan tertutup

    Examples:
      | namaBaru  | levelBaru |
      | TestBatal |        25 |
