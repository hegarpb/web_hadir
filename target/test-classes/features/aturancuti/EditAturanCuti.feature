Feature: Edit Aturan Cuti
        Sebaga user saya ingin mengedit aturan cuti
        dengan feature edit di halaman aturan cuti
#Positive Test - Data Valid

  Scenario Outline: mengedit aturan cuti dengan data valid
    Given user sudah login dan diarahkan ke halaman Aturan Cuti
    And user menekan tombol action pada aturan cuti "<namaAturan>"
    And user menekan tombol edit pada aturan cuti
    And user menginput nama aturan cuti "<namaAturanBaru>" pada form sunting aturan cuti
    And user menginput Eligible pengaturan cuti "<eligibleBaru>" pada form sunting aturan cuti
    And user menginput tanggal batas sisa cuti "<tanggalBatasBaru>" pada form sunting aturan cuti
    And user menginput bulan batas sisa cuti "<bulanBatasBaru>" pada form sunting aturan cuti
    And user menginput maksimal sisa cuti "<maksimalSisaBaru>" pada form sunting aturan cuti
    And user menginput jumlah bulan kerja sisa cuti "<jumlahBulanKerjaSisaBaru>" pada form sunting aturan cuti
    And user menekan tombol Simpan pada form sunting aturan cuti
    Then sistem akan menampilkan pesan "Sukses Mengubah Aturan Cuti".
    And data aturan cuti "<namaAturanBaru>" ditampilkan di tabel.

    Examples:
      | namaAturan | namaAturanBaru | eligibleBaru | tanggalBatasBaru | bulanBatasBaru | maksimalSisaBaru | jumlahBulanKerjaSisaBaru |
      | Cuti Edit1 | Cuti Revisi    |           10 |               10 |             10 |                5 |                        3 |
#Negative Test- Data Invalid

  Scenario Outline: Mengedit aturan cuti dengan data invalid
    Given user sudah login dan diarahkan ke halaman Aturan Cuti
    And user menekan tombol action pada aturan cuti "<namaAturan>"
    And user menekan tombol edit pada aturan cuti
    And user menginput nama aturan cuti "<namaAturanBaru>" pada form sunting aturan cuti
    And user menginput Eligible pengaturan cuti "<eligible>" pada form sunting aturan cuti
    And user menginput tanggal batas sisa cuti "<tanggalBatasBaru>" pada form sunting aturan cuti
    And user menginput bulan batas sisa cuti "<bulanBatasBaru>" pada form sunting aturan cuti
    And user menginput maksimal sisa cuti "<maksimalSisaBaru>" pada form sunting aturan cuti
    And user menginput jumlah bulan kerja sisa cuti "<jumlahBulanKerjaSisaBaru>" pada form sunting aturan cuti
    And user menekan tombol Simpan pada form sunting aturan cuti
    Then sistem akan menampilkan pesan "Gagal Mengubah Aturan Cuti".

    Examples:
      | namaAturan | namaAturanBaru | eligibleBaru | tanggalBatasBaru | bulanBatasBaru | maksimalSisaBaru | jumlahBulanKerjaSisaBaru |
      | Cuti Edit2 | Edit Invalid1  |          -12 |               10 |             10 |               -5 |                       -3 |
      | Cuti Edit3 | Edit Invalid2  | abc          |               12 |              6 | abc              | abc                      |

  Scenario Outline: Mengedit aturan cuti dengan  field kosong
    Given user sudah login dan diarahkan ke halaman Aturan Cuti
    And user menekan tombol action pada aturan cuti "<namaAturan>"
    And user menekan tombol edit pada aturan cuti
    And user menginput nama aturan cuti "<namaAturanBaru>" pada form sunting aturan cuti
    And user menginput Eligible pengaturan cuti "<eligibleBaru>" pada form sunting aturan cuti
    And user menginput tanggal batas sisa cuti "<tanggalBatasBaru>" pada form sunting aturan cuti
    And user menginput bulan batas sisa cuti "<bulanBatasBaru>" pada form sunting aturan cuti
    And user menginput maksimal sisa cuti "<maksimalSisaBaru>" pada form sunting aturan cuti
    And user menginput jumlah bulan kerja sisa cuti "<jumlahBulanKerjaSisaBaru>" pada form sunting aturan cuti
    And user menekan tombol Simpan pada form sunting aturan cuti
    Then pesan validasi akan muncul pada field kosong

    Examples:
      | namaAturan        | namaAturanBaru | eligibleBaru | tanggalBatasBaru | bulanBatasBaru | maksimalSisaBaru | jumlahBulanKerjaBru |
      | Cuti Field Kosong |                |           12 |                  |                |               10 |                   6 |

  Scenario Outline: Batal Edit
    Given user sudah login dan diarahkan ke halaman Aturan Cuti
    And user menekan tombol action pada aturan cuti "<namaAturan>"
    And user menekan tombol edit pada aturan cuti
    And user menekan tombol tutup pada form sunting Aturan Cuti
    Then form sunting aturan cuti akan tertutup

    Examples:
      | namaAturan      |
      | Cuti Batal Edit |
