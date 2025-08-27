Feature: Tambah Aturan Cuti
  Sebagai user saya ingin menambahkan aturan cuti dengan feature tambah aturan cuti

  @Positive
  Scenario Outline: Tambah aturan cuti baru dengan data valid
    Given user melakukan login dan berada di halaman manajemen Aturan Cuti
    When user menekan tombol Tambahkan Aturan Cuti
    And user menginput nama aturan cuti "<namaAturan>"
    And user menginput Eligible pengaturan cuti "<eligible>"
    And user menginput tanggal batas sisa cuti "<tanggalBatas>"
    And user menginput bulan batas sisa cuti "<bulanBatas>"
    And user menginput maksimal sisa cuti "<maksimalSisa>"
    And user menginput jumlah bulan sisa kerja cuti "<jumlahBulanKerja>"
    And user menekan tombol Tambahkan pada form tambahkan aturan cuti
    Then sistem menampilkan pesan "Sukses Membuat Aturan Cuti"
    And data aturan cuti "<namaAturan>" ditampilkan di tabel

    Examples:
      | namaAturan    | eligible | tanggalBatas | bulanBatas | maksimalSisa | jumlahBulanKerja |
      | Cuti Tambahan |       12 |            5 |          2 |           10 |                6 |

  @Negative
  Scenario Outline: Tambah aturan cuti dengan data invalid
    Given user melakukan login dan berada di halaman manajemen Aturan Cuti
    When user menekan tombol Tambahkan Aturan Cuti
    And user menginput nama aturan cuti "<namaAturan>"
    And user menginput Eligible pengaturan cuti "<eligible>"
    And user menginput tanggal batas sisa cuti "<tanggalBatas>"
    And user menginput bulan batas sisa cuti "<bulanBatas>"
    And user menginput maksimal sisa cuti "<maksimalSisa>"
    And user menginput jumlah bulan sisa kerja cuti "<jumlahBulanKerja>"
    And user menekan tombol Tambahkan pada form tambahkan aturan cuti
    Then sistem menampilkan pesan "Gagal Membuat Aturan Cuti"

    Examples:
      | namaAturan    | eligible | tanggalBatas | bulanBatas | maksimalSisa | jumlahBulanKerja |
      | Cuti Invalid1 | abc      |            9 |          4 | abc          | abc              |
      | Cuti Invalid2 |      -12 |            8 |          6 |          -10 |               -6 |

  @Negative
  Scenario Outline: validasi field kosong
    Given user melakukan login dan berada di halaman manajemen Aturan Cuti
    When user menekan tombol Tambahkan Aturan Cuti
    And user menginput nama aturan cuti "<namaAturan>"
    And user menginput Eligible pengaturan cuti "<eligible>"
    And user menginput tanggal batas sisa cuti "<tanggalBatas>"
    And user menginput bulan batas sisa cuti "<bulanBatas>"
    And user menginput maksimal sisa cuti "<maksimalSisa>"
    And user menginput jumlah bulan sisa kerja cuti "<jumlahBulanKerja>"
    And user menekan tombol Tambahkan pada form tambahkan aturan cuti
    Then muncul pesan validasi pada field kosong

    Examples:
      | namaAturan | eligible | tanggalBatas | bulanBatas | maksimalSisa | jumlahBulanKerja |
      |            |       12 |              |            |           10 |                6 |

  @Positive
  Scenario Outline: Button Tutup Aturan Cuti
    Given user melakukan login dan berada di halaman manajemen Aturan Cuti
    When user menekan tombol Tambahkan Aturan Cuti
    When user menekan tombol tutup pada form tambahkan aturan cuti
    Then form tambah aturan cuti akan tertutup
