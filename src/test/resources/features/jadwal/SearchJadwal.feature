Feature: Sebagai user saya ingin mencari nama jadwal
         menggunakan feature search pada halaman jadwal

  @Positive
  Scenario Outline: Search jadwal dengan data valid
    Given user melakukan login dan berada di halaman jadwal
    When user menginput "<namaJadwal>" pada kolom pencarian
    When user menekan tombol search pada halaman jadwal
    Then "<namaJadwal>" yang dicari user akan ditampilkan

    Examples:
      | namaJadwal |
      | Indolakto  |

  @Negative
  Scenario Outline: Search jadwal dengan data invalid
    Given user melakukan login dan berada di halaman jadwal
    When user menginput "<namaJadwal>" pada kolom pencarian
    When user menekan tombol search pada halaman jadwal
    Then nama jadwal yang dicari user tidak akan ditampilkan

    Examples:
      | namaJadwal |
      | abcd       |
