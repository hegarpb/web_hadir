Feature: Edit Aturan Cuti
        Sebaga user saya ingin mengedit aturan cuti
        dengan feature edit di halaman aturan cuti

  @Positive
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
      | namaAturan  | namaAturanBaru | eligibleBaru | tanggalBatasBaru | bulanBatasBaru | maksimalSisaBaru | jumlahBulanKerjaSisaBaru |
      | Cuti Khusus | Cuti Revisi    |           10 |                5 |             10 |               10 |                        4 |

  @Negative
  Scenario Outline: Mengedit aturan cuti dengan data invalid (mengandung angka negatif)
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
    Then sistem akan menampilkan pesan "Gagal Mengubah Aturan Cuti".

    Examples:
      | namaAturan    | namaAturanBaru    | eligibleBaru | tanggalBatasBaru | bulanBatasBaru | maksimalSisaBaru | jumlahBulanKerjaSisaBaru |
      | Cuti Tambahan | Cuti Invalid edit |          -12 |               10 |             10 |               -5 |                       -3 |

  @Negative
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
      | namaAturan | namaAturanBaru | eligibleBaru | tanggalBatasBaru | bulanBatasBaru | maksimalSisaBaru | jumlahBulanKerjaBru |
      | Cuti Edit  |                |           12 |                  |                |               10 |                   6 |

  @Positive
  Scenario Outline: Batal Edit
    Given user sudah login dan diarahkan ke halaman Aturan Cuti
    And user menekan tombol action pada aturan cuti "<namaAturan>"
    And user menekan tombol edit pada aturan cuti
    And user menekan tombol tutup pada form sunting Aturan Cuti
    Then form sunting aturan cuti akan tertutup

    Examples:
      | namaAturan |
      | Cuti       |
