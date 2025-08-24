Feature: Delete Aturan Cuti
         Sebagai user saya ingin menghapus aturan cuti
        dengan feature Delete aturan cuti

  Scenario Outline: Hapus Aturan Cuti
    Given user sudah login sebagai admin dan berada di halaman Aturan Cuti.
    When user menekan tombol action pada nama "<namaAturan>" aturan cuti.
    When user menekan tombol delete
    When user menekan tombol hapus
    And pesan "Berhasil Menghapus Aturan Cuti" akan ditampilkan sistem.

    Examples:
      | namaAturan    |
      | Cuti Tahunan6 |

  Scenario Outline: Batal Aturan Cuti
    Given user sudah login sebagai admin dan berada di halaman Aturan Cuti.
    When user menekan tombol action pada nama "<namaAturan>" aturan cuti.
    When user menekan tombol delete
    When user menekan tombol hapus
    When user menekan tombol batal
    Then tidak ada nama aturan cuti yang terhapus

    Examples:
      | namaAturan    |
      | Cuti Invalid4 |
