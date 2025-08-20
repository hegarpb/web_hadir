Feature: Edit Jabatan
        Sebagai user saya ingin mengubah nama jabatan
        dengan menggunakan fitur edit pada data jabatan

  Scenario Outline: Mengubah nama jabatan dengan fitur edit dengan data yang valid.
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>" dan level "<levelBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan sukses "Berhasil Edit Jabatan"

    Examples:
      | namaBaru       | levelBaru |
      | Staff IT Baru2 |         6 |

  Scenario Outline: Mengubah nama jabatan tetapi level tidak diubah
    Given user sudah login dan user berada di halaman Manajemen Jabatan
    When user menekan tombol action pada jabatan
    And user menekan tombol edit pada menu dropdown
    And user mengubah nama jabatan menjadi "<namaBaru>"
    And user menekan tombol simpan
    Then sistem akan menampilkan pesan sukses "Berhasil Edit Jabatan"

    Examples:
      | namaBaru       |
      | Staff IT Baru3 |
