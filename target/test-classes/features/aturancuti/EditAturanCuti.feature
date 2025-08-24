Feature: Edit Aturan Cuti
        Sebaga user saya ingin mengedit aturan cuti
        dengan feature edit di halaman aturan cuti

  Scenario Outline: mengedit aturan cuti
    Given user sudah login dan diarahkan ke halaman Aturan Cuti
    And user menekan tombol action pada aturan cuti "<namaAturan>"
    And user menekan tombol edit pada aturan cuti
    And user menginput nama aturan cuti "<namaAturanBaru>" pada form sunting aturan cuti
    And user menginput Eligible pengaturan cuti "<eligableBaru>" pada form sunting aturan cuti
    And user menginput tanggal batas sisa cuti "<tanggalBatasBaru>" pada form sunting aturan cuti
    And user menginput bulan batas sisa cuti "<bulanBatasBaru>" pada form sunting aturan cuti
    And user menginput maksimal sisa cuti "<maksimalSisaBaru>" pada form sunting aturan cuti
    And user menginput jumlah bulan kerja sisa cuti "<jumlahBulanKerjaSisaBaru>" pada form sunting aturan cuti
    And user menekan tombol Simpan pada form tambahkan aturan cuti
    Then sistem akan menampilkan pesan sukses "Sukses Mengubah Aturan Cuti"

    Examples:
      | namaAturan    | namaAturanBaru | eligableBaru | tanggalBatasBaru | bulanBatasBaru | maksimalSisaBaru | jumlahBulanKerjaSisaBaru |
      | Cuti Tahunan3 | Edit Revisi2   |           12 |               30 |             12 |                7 |                        9 |
