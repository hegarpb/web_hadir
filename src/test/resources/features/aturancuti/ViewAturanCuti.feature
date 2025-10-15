Feature: View Aturan Cuti
  Sebagai user saya ingin melihat detail aturan cuti 
  agar saya dapat mengetahui informasi lengkapnya

  Scenario Outline: Melihat detail aturan cuti
    Given user login sebagai admin dan diarahkan ke halaman aturan cuti
    When user menekan tombol action pada nama "<namaAturan>" cuti
    And user menekan tombol view
    Then detail aturan cuti akan tampil

    Examples:
      | namaAturan |
      | Cuti View  |
