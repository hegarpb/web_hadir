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
    Then muncul pesan sukses dan nama jadwal "<namaJadwal>" akan muncul dalam tabel

    Examples:
      | tipeJadwal            | hari | bulan     | tahun | namaJadwal     | menit |
      | Jadwal kerja flexible |    5 | September |  2025 | Jadwal Terbaru |    15 |
  # @Positive
  # Scenario Outline: tombol batal
  #   Given user sudah login dan berada di halaman jadwal
  #   When user menekan tombol Tambahkan pada halaman jadwal
  #   And user menekan tombol batal pada modal tambah jadwal
  #   Then modal tambah jadwal akan tertutup
  #   Examples:
  #     | tipeJadwal            | hari | bulan     | tahun | namaJadwal | menit |
  #     | Jadwal kerja flexible |    5 | September |  2025 | Jadwal     |    15 |
  # @Negative
  # Scenario Outline: Menambahkan jadwal dengan field kosong pada nama jadwal dant toleransi keterlambatan
  #   Given user sudah login dan berada di halaman jadwal
  #   When user menekan tombol Tambahkan pada halaman jadwal
  #   And user memilih menu dropdown tipe jadwal kerja "<tipeJadwal>"
  #   And user menginput nama jadwal kerja "<namaJadwal>"
  #   And user mengisi toleransi keterlambatan "<menit>"
  #   And user menekan tombol tambah
  #   Then muncul pesan validasi pada field tipe jadwal "<pesanTipe>"
  #   Then muncul pesan validasi pada field nama jadwal kerja "<pesanNama>"
  #   Then muncul pesan validasi pada field toleransi keterlambatan "<pesanToleransi>"
  #   Examples:
  #     | tipeJadwal            | namaJadwal    | menit | pesanTipe      | pesanNama      | pesanToleransi  |
  #     |                       | Jadwal Kosong |    15 | Isi isian ini. |                |                 |
  #     | Jadwal kerja flexible |               |    15 |                | Isi isian ini. |                 |
  #     | Jadwal kerja flexible | Jadwal Kosong |       |                |                | Masukkan angka. |
  # @Negative
  # Scenario Outline: Menambahkan jadwal tanpa mengisi hari kerja
  #   Given user sudah login dan berada di halaman jadwal
  #   When user menekan tombol Tambahkan pada halaman jadwal
  #   And user memilih menu dropdown tipe jadwal kerja "<tipeJadwal>"
  #   And user menginput tanggal efektif "<hari>" "<bulan>" "<tahun>"
  #   And user menginput nama jadwal kerja "<namaJadwal>"
  #   And user mengisi toleransi keterlambatan "<menit>"
  #   And user menekan tombol tambah
  #   Then sistem akan menapilkan pesan popup. "Isi terlebih dahulu hari kerja"
  #   Examples:
  #     | tipeJadwal            | hari | bulan     | tahun | namaJadwal    | menit |
  #     | Jadwal kerja flexible |    5 | September |  2025 | Jadwal Revisi |    15 |
