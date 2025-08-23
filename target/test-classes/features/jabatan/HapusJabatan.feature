Feature: Hapus Jabatan
        Sebagai user saya ingin menghapus data jabatan 
        dengan menggunakan feature delete pada tabel data jabatan

  Scenario Outline: Menghapus data jabatan dengan feature delete pada tabel jabatan
    Given user sudah login sebagai admin dan berada di halaman Manajemen jabatan
    When user mengklik tombol action pada level jabatan "109"
    And user mengklik tombol delete pada menu dropdown
    And user mengklik tombol Ya pada form hapus jabatan
    Then pesan sukses "Berhasil Delete Jabatan" akan diatmpilkan sistem

  Scenario Outline: Batal menghapus jabatan dengan menekan tombol batal pada form hapus jabatan
    Given user sudah login sebagai admin dan berada di halaman Manajemen jabatan
    When user mengklik tombol action pada level jabatan "111"
    And user mengklik tombol delete pada menu dropdown
    And user mengklik tombol Batal pada form hapus jabatan
    Then form pada hapus jabatan akan tertutup
