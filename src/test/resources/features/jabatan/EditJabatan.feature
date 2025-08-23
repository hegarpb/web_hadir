Feature: Edit Jabatan
        Sebagai user saya ingin mengubah nama jabatan
        dengan menggunakan fitur edit pada data jabatan
#Positive Test -Data Valid

  Scenario Outline: Mengubah nama jabatan dengan fitur edit dengan data yang valid.
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan "101"
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user mengubah level jabatan menjadi "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"

    Examples:
      | namaBaru  | levelBaru |
      | EDitBaru9 |         7 |
  # Scenario Outline: Mengubah nama jabatan tetapi level tidak diubah
  #   Given user sudah login dan user berada di halaman Manajemen Jabatan
  #   When user menekan tombol action pada jabatan "HEAD"
  #   And user menekan tombol edit pada menu dropdown
  #   And user mengubah nama jabatan menjadi "<namaBaru>"
  #   And user menekan tombol simpan
  #   Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"
  #   Examples:
  #     | namaBaru |
  #     | Sekjen   |
  # Scenario Outline: Mengubah level jabatan tetapi nama tidak diubah
  #   Given user sudah login dan user berada di halaman Manajemen Jabatan
  #   When user menekan tombol action pada jabatan "Ass Manager2"
  #   And user menekan tombol edit pada menu dropdown
  #   And user mengubah level jabatan menjadi "<levelBaru>"
  #   And user menekan tombol simpan
  #   Then sistem akan menampilkan pesan "Berhasil Edit Jabatan"
  #   Examples:
  #     | levelBaru |
  #     |        12 |
  # # NegtiveTest - Data Invalid
  # Scenario Outline: Mengubah nama jabatan dan level jabatan dengan nama jabatan dan level jabatan yang sudah ada,inputan level mengandung angka negtif
  #   Given user sudah login dan user berada di halaman Manajemen Jabatan
  #   When user menekan tombol action pada jabatan "s"
  #   And user menekan tombol edit pada menu dropdown
  #   And user mengubah nama jabatan menjadi "<namaBaru>"
  #   And user mengubah level jabatan menjadi "<levelBaru>"
  #   And user menekan tombol simpan
  #   Then sistem akan menampilkan pesan "Gagal Edit Jabatan"
  #   Examples:
  #     | namaBaru | levelBaru |
  #     | Karyawan |         1 |
  #     | Sersan   |       -21 |
  # Scenario Outline: Validasi field kosong saat mengubah data jabatan
  #   Given user sudah login dan user berada di halaman Manajemen Jabatan
  #   When user menekan tombol action pada jabatan "DIREKTUR"
  #   And user menekan tombol edit pada menu dropdown
  #   And user mengubah nama jabatan menjadi "<namaBaru>"
  #   And user mengubah level jabatan menjadi "<levelBaru>"
  #   And user menekan tombol simpan
  #   Then pesan validasi "<message_nama>" akan muncul pada field nama jabatan
  #   Then pesan validasi "<message_level>" akan muncul pada field level jabatan
  #   Examples:
  #     | namaBaru | levelBaru | message_nama   | message_level  |
  #     |          |        25 | Isi isian ini. |                |
  #     | Pengawas |           |                | Isi isian ini. |
  # Scenario Outline: Validasi batal mengubah data jabatan
  #   Given user sudah login dan user berada di halaman Manajemen Jabatan
  #   When user menekan tombol action pada jabatan "Anggota Pengawas"
  #   And user menekan tombol edit pada menu dropdown
  #   And user mengubah nama jabatan menjadi "<namaBaru>"
  #   And user mengubah level jabatan menjadi "<levelBaru>"
  #   And user menekan tombol batal pada form edit jabatan
  #   Then form pada edit jabatan akan tertutup
  #   Examples:
  #     | namaBaru  | levelBaru |
  #     | TestBatal |        25 |
