Feature: Edit Jadwal
         Sebeagi user saya ingin melakukan edit jadwal
         dengan feature Edit pada halaman jadwal

  @Positive
  Scenario Outline: Edit jadwal
    Given user login sebagai admin dan ada di halaman jadwal
    When user menekan tombol action pada nama jadwal "<namaJadwal>".
    And user memilih menu edit
    And user memilih menu dropdown tipe jadwal kerja. "<tipeJadwal>"
    And user menginput tanggal efektif. "<hari>" "<bulan>" "<tahun>"
    And user menginput nama jadwal kerja. "<namaJadwalBaru>"
    And user menekan tombol hari kerja.
    And user mengisi jumlah hari kerja.
    And user menekan tombol terapkan pada form tambah jadwal.
    And user mengisi toleransi keterlambatan "<menit>".
    And user menekan tombol simpan.
    Then sistem akan menampilkan pesan popup "Berhasil mengubah jadwal".
    Then nama jadwal yang sudah di edit akan muncul dalam tabel  "<namaJadwalBaru>".

    Examples:
      | namaJadwal  | tipeJadwal            | hari | bulan     | tahun | namaJadwalBaru    | menit |
      | Jadwal Baru | Jadwal kerja flexible |   10 | September |  2025 | Jadwal Baru Edit2 |    15 |

  @Negative
  Scenario Outline: Edit jadwal dengan field kosong
    Given user login sebagai admin dan ada di halaman jadwal
    When user menekan tombol action pada nama jadwal "<namaJadwal>".
    And user memilih menu edit
    And user menginput nama jadwal kerja. "<namaJadwalBaru>"
    And user mengisi toleransi keterlambatan "<menit>".
    And user menekan tombol simpan.
    Then muncul pesan validasi pada field nama jadwal kerja "<pesanNama>".
    Then muncul pesan validasi pada field toleransi keterlambatan "<pesanToleransi>".

    Examples:
      | namaJadwal        | namaJadwalBaru | menit | pesanNama      | pesanToleransi  |
      | Jadwal Baru Edit2 |                |    15 | Isi isian ini. |                 |
      | Jadwal Baru Edit2 | Jadwal Revisi  |       |                | Masukkan angka. |

  @Positive
  Scenario Outline: Batal Edit
    Given user login sebagai admin dan ada di halaman jadwal
    When user menekan tombol action pada nama jadwal "<namaJadwal>".
    And user memilih menu edit
    And user menekan tombol batal pada modal edit jadwal
    Then modal edit jadwal akan tertutup

    Examples:
      | namaJadwal        |
      | Jadwal Baru Edit2 |
