Feature: Tambah Aturan Cuti
  Sebagai user saya ingin menambahkan aturan cuti dengan feature tambah aturan cuti

  Scenario Outline: Tambah aturan cuti baru dengan data valid
    Given user melakukan login dan berada di halaman manajemen Aturan Cuti
    When user menekan tombol Tambahkan Aturan Cuti
    And user menginput nama aturan cuti "<namaAturan>"
    And user menginput Eligible pengaturan cuti "<eligable>"
    And user menginput tanggal batas sisa cuti "<tanggalBatas>"
    And user menginput bulan batas sisa cuti "<bulanBatas>"
    And user menginput maksimal sisa cuti "<maksimalSisa>"
    And user menginput jumlah bulan sisa kerja cuti "<jumlahBulanKerja>"
    And user menekan tombol Tambahkan pada form tambahkan aturan cuti
    Then sistem menampilkan pesan "Sukses Membuat Aturan Cuti"

    Examples:
      | namaAturan     | eligible | tanggalBatas | bulanBatas | maksimalSisa | jumlahBulanKerja |
      | "Cuti Tahunan" | "12"     | "5"          | "2"        | "10"         | "6"              |
      | "Cuti Khusus"  | "6"      | "10"         | "1"        | "5"          | "3"              |

  Scenario Outline: Tambah aturan cuti dengan data invalid (mengandung angka negatif)
    Given user melakukan login dan berada di halaman manajemen Aturan Cuti
    When user menekan tombol Tambahkan Aturan Cuti
    And user menginput nama aturan cuti "<namaAturan>"
    And user menginput Eligible pengaturan cuti "<eligable>"
    And user menginput tanggal batas sisa cuti "<tanggalBatas>"
    And user menginput bulan batas sisa cuti "<bulanBatas>"
    And user menginput maksimal sisa cuti "<maksimalSisa>"
    And user menginput jumlah bulan sisa kerja cuti "<jumlahBulanKerja>"
    And user menekan tombol Tambahkan pada form tambahkan aturan cuti
    Then sistem menampilkan pesan "Gagal Membuat Aturan Cuti"

    Examples:
      | namaAturan      | eligible | tanggalBatas | bulanBatas | maksimalSisa | jumlahBulanKerja |
      | "Cuti Invalid1" | "-12"    | "8"          | "6"        | "-10"        | "-6"             |

  Scenario Outline: Tambah aturan cuti dengan data invalid (mengandung huruf alfabet )
    Given user melakukan login dan berada di halaman manajemen Aturan Cuti
    When user menekan tombol Tambahkan Aturan Cuti
    And user menginput nama aturan cuti "<namaAturan>"
    And user menginput Eligible pengaturan cuti "<eligable>"
    And user menginput tanggal batas sisa cuti "<tanggalBatas>"
    And user menginput bulan batas sisa cuti "<bulanBatas>"
    And user menginput maksimal sisa cuti "<maksimalSisa>"
    And user menginput jumlah bulan sisa kerja cuti "<jumlahBulanKerja>"
    And user menekan tombol Tambahkan pada form tambahkan aturan cuti
    Then sistem menampilkan pesan "Gagal Membuat Aturan Cuti"

    Examples:
      | namaAturan      | eligible | tanggalBatas | bulanBatas | maksimalSisa | jumlahBulanKerja |
      | "Cuti Invalid2" | "-ABC"   | "8"          | "6"        | "asd"        | "bsa"            |
