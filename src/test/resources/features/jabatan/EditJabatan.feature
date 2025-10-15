Feature: Edit Jabatan
        Sebagai user saya ingin mengubah nama jabatan
        dengan menggunakan fitur edit pada data jabatan

  @Positive
  Scenario Outline: Mengubah nama jabatan dengan fitur edit dengan data yang valid.
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada level jabatan "89"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"

    Examples:
      | namaBaru | levelBaru |
      | Ketua    |        71 |

  @Positive
  Scenario Outline: Mengubah nama jabatan tetapi level tidak diubah
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada level jabatan "85"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"

    Examples:
      | namaBaru      |
      | Tester Senior |

  @Positive
  Scenario Outline: Mengubah level jabatan tetapi nama tidak diubah
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada level jabatan "91"
    And user menekan tombol edit pada menu dropdown
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"

    Examples:
      | levelBaru |
      |        12 |

  @Negative
  Scenario Outline: Mengubah nama jabatan dan level jabatan dengan nama jabatan dan level jabatan yang sudah ada
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada level jabatan "8"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Gagal Edit Jabatan"

    Examples:
      | namaBaru | levelBaru |
      | Karyawan |         1 |

  @Negative
  Scenario Outline: Validasi field kosong saat mengubah data jabatan
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada level jabatan "5"
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

  @Positive
  Scenario Outline: Validasi tombol batal
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada level jabatan "10"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol batal pada form edit jabatan
    Then form pada edit jabatan akan tertutup

    Examples:
      | namaBaru  | levelBaru |
      | TestBatal |        25 |
