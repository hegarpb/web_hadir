Feature: Tambah jadwal
  Sebagai user saya ingin menambahkan jadwal 
  dengan feature tambah jadwal

  @Positive
  Scenario: Tambah jadwal dengan data valid
    Given user sudah login dan berada di halaman jadwal
    When user menekan tombol Tambahkan pada halaman jadwal
    And user memilih menu dropdown tipe jadwal kerja "<tipeJadwal>"
    And user menginput tanggal efektif "<hari>" "<bulan>" "<tahun>"
    And user menginput nama jadwal kerja "<namaJadwal>"
    And user menekan tombol hari kerja
    And user mengisi jumlah hari kerja:
    And user menekan tombol terapkan pada form tambah jadwal
    And user mengisi toleransi keterlambatan "<menit>"
    And user menekan tombol tambah
    Then muncul pesan "Berhasil menambahkan jadwal"

    Examples:
      | tipeJadwal            | hari | bulan     | tahun | namaJadwal     | menit |
      | Jadwal kerja flexible |    5 | September |  2025 | Jadwal Terbaru |    15 |

  @Positive
  Scenario Outline: tombol batal
    Given user sudah login dan berada di halaman jadwal
    When user menekan tombol Tambahkan pada halaman jadwal
    And user menekan tombol batal pada modal tambah jadwal
    Then modal tambah jadwal akan tertutup

    Examples:
      | tipeJadwal            | hari | bulan     | tahun | namaJadwal | menit |
      | Jadwal kerja flexible |    5 | September |  2025 | Jadwal     |    15 |

  @Negative
  Scenario Outline: Menambahkan jadwal dengan field kosong pada nama jadwal dant toleransi keterlambatan
    Given user sudah login dan berada di halaman jadwal
    When user menekan tombol Tambahkan pada halaman jadwal
    And user memilih menu dropdown tipe jadwal kerja "<tipeJadwal>"
    And user menginput nama jadwal kerja "<namaJadwal>"
    And user mengisi toleransi keterlambatan "<menit>"
    And user menekan tombol tambah
    Then muncul pesan validasi pada field tipe jadwal "<pesanTipe>"

    Examples:
      | tipeJadwal | namaJadwal    | menit | pesanTipe             |
      |            | Jadwal Kosong |    15 | Silahkan pilih jadwal |

  @Negative
  Scenario Outline: Menambahkan jadwal dengan field kosong pada nama jadwal dant toleransi keterlambatan
    Given user sudah login dan berada di halaman jadwal
    When user menekan tombol Tambahkan pada halaman jadwal
    And user memilih menu dropdown tipe jadwal kerja "<tipeJadwal>"
    And user menginput nama jadwal kerja "<namaJadwal>"
    And user mengisi toleransi keterlambatan "<menit>"
    And user menekan tombol tambah
    Then muncul pesan validasi pada field nama jadwal kerja "<pesanNama>"

    Examples:
      | tipeJadwal            | namaJadwal | menit | pesanNama      |
      | Jadwal kerja flexible |            |    15 | Isi isian ini. |
  # @Negative

  @Negative
  Scenario Outline: Menambahkan jadwal dengan field kosong pada nama jadwal dant toleransi keterlambatan
    Given user sudah login dan berada di halaman jadwal
    When user menekan tombol Tambahkan pada halaman jadwal
    And user memilih menu dropdown tipe jadwal kerja "<tipeJadwal>"
    And user menginput nama jadwal kerja "<namaJadwal>"
    And user mengisi toleransi keterlambatan "<menit>"
    And user menekan tombol tambah
    Then muncul pesan validasi pada field toleransi keterlambatan "<pesanNama>"

    Examples:
      | tipeJadwal            | namaJadwal    | menit | pesanNama       |
      | Jadwal kerja flexible | Jadwal kosong |       | Masukkan angka. |
  # @Negative
