Feature: Tombol Search
            Seabagai user saya ingin melakukan pencarian aturan cuti
            dengan featur searach pada halama Aturan cuti

  Scenario Outline:
    Given user sudah login sebagai admin dan berada di halaman Aturan cuti
    When user menginput nama aturan cuti dalam field cari berdasarkan nama
    When user meneekan tombol search di halaman aturan cuti
    Then muncul nama aturan cuti yang dicari
