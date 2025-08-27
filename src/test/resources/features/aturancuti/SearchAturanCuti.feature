Feature: Tombol Search
  Seabagai user saya ingin melakukan pencarian aturan cuti
  dengan featur searach pada halaman Aturan cuti

  @Positive
  Scenario Outline: Pencarian aturan cuti dengan data valid
    Given user sudah login sebagai admin dan berada di halaman Aturan cuti
    When user menginput "<namaAturan>" dalam field cari berdasarkan nama
    And user menekan tombol search di halaman aturan cuti
    Then muncul nama aturan cuti yang dicari "<namaAturan>"

    Examples:
      | namaAturan |
      | Cuti Hamil |

  @Negative
  Scenario Outline: Pencarian aturan cuti dengan data invalid
    Given user sudah login sebagai admin dan berada di halaman Aturan cuti
    When user menginput "<namaAturan>" dalam field cari berdasarkan nama
    And user menekan tombol search di halaman aturan cuti
    Then tidak muncul nama aturan cuti yang dicari

    Examples:
      | namaAturan  |
      | abcdef      |
      | Cuti Hamil? |
