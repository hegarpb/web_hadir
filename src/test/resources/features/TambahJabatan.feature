Feature: Tambah Jabatan

  Scenario: Tambah jabatan baru dengan data valid
    Given user berada di halaman Manajemen Jabatan
    When user menambahkan jabatan dengan nama "<namaJabatan>" dan level "<levelJabatan>"
    Then sistem menampilkan pesan sukses "Berhasil Menambahkan Job Level"

  Scenario: Tambah jabatan baru dengan nama jabatan yang sudah ada
    Given user berada di halaman Jabatan
    When user menambahkan jabatan dengan nama "SPV2" dan level "2"
    Then sistem menampilkan pesan error "Gagal Menambahkan Job Level"

  Scenario: Tambah jabatan baru dengan nama jabatan kosong
    Given user berada di halaman Jabatan
    When user menambahkan jabatan dengan nama "" dan level "2"
    Then sistem menampilkan pesan validasi "Isi isian ini." pada field Nama Jabatan

  Scenario: Tambah jabatan baru dengan level jabatan kosong
    Given user berada di halaman Jabatan
    When user menambahkan jabatan dengan nama "Marketing" dan level ""
    Then sistem menampilkan pesan validasi "Isi isian ini." pada field Level Jabatan
