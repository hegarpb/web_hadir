# Bacaan Proyek (Project Readme)
QA atau Quality Assurance adalah proses untuk memastikan kualitas perangkat lunak agar sesuai dengan kebutuhan, standar, dan bebas dari defect sebelum digunakan oleh pengguna. QA tidak hanya fokus mencari bug, tapi juga memastikan setiap tahapan pengembangan berjalan dengan benar melalui perencanaan, pengujian manual maupun otomatis, serta dokumentasi yang baik. Intinya QA berperan menjaga kualitas produk agar memberikan pengalaman terbaik bagi user.
jika dalam pengembangan sotware kita mengenal SDLC yaitu, proses pengembangan software dari requirement sampai maintenance, sedangkan STLC adalah siklus yang fokus pada aktivitas testing untuk memastikan kualitas software. 
STLC merupakan serangkaian tahapan terstruktur yang dilakukan oleh tim QA/tester dalam proses pengujian perangkat lunak.Tujuannya memastikan software yang dikembangkan sesuai kebutuhan, berkualitas, dan bebas dari defect kritis sebelum rilis.


Proyek ini mengikuti pendekatan Behavior-Driven Development (BDD), yang utamanya menggunakan Cucumber untuk Siklus Hidup Pengujian Perangkat Lunak (STLC).

STLC untuk proyek ini mencakup fase-fase berikut:

1.  **Requirement Analysis**:Requirement Analysis adalah tahap awal dalam STLC di mana QA menganalisis dokumen requirement (Software Requirement Specification, User Story Acceptance Criteria) untuk memahami apa yang harus diuji. Deliverable : daftar kebutuhan yang bisa diuji.

2.  **Test Planning**: Test Planning adalah tahap di mana QA Lead/QA Engineer menyusun strategi, scope , tujuan testing, metode yang digunakan, timeline, resource dan tools yang akan digunakan untuk aktivitas testing.  (Cucumber, Selenium, dll.), resource, dan timeline. dalam project ini : Memastikan semua fitur utama aplikasi (Login, Jadwal Kerja, Jabatan, dll.) berfungsi sesuai requirement, dan regression test bisa dilakukan otomatis.

3.  **Test Case Design (Test Case Development)**:Test Case Design adalah proses membuat test case berdasarkan requirement, use case, atau user story untuk memastikan semua fungsionalitas sistem diuji secara menyeluruh.
Dalam konteks  Automation ini , test case dituangkan dalam bentuk BDD feature file (.feature) atau skenario yang nantinya di-translate ke script otomatis. Deliverable: .feature files   

4.  **Test Environment Setup**: Test Environment Setup adalah proses menyiapkan lingkungan (hardware, software, network, tools, test data) tempat QA menjalankan pengujian. Intinya: memastikan semua kondisi sudah siap sebelum test case dieksekusi. termasuk dependensi seperti Selenium WebDriver, dan menyiapkan test runner.

5.  **Test Execution**:Test Execution adalah tahap di mana QA menjalankan test case (manual maupun automation) pada test environment yang sudah disiapkan, lalu mencatat hasil aktual dibandingkan dengan hasil yang diharapkan (expected result). Intinya: eksekusi semua test case untuk memvalidasi apakah aplikasi bekerja sesuai requirement. Dalam project yang saya kerjakan terdapat 56 test case dimana 51 status pass dan 5 status fail dikarenakan ada bug pada menu yang diuji.

6.  **Test Cycle Closure**: Test Cycle Closure adalah tahap penutupan setelah semua aktivitas testing selesai dilakukan. Pada tahap ini QA melakukan evaluasi keseluruhan, memastikan semua tujuan testing tercapai, lalu menyusun Test Summary Report (TSR) sebagai dokumentasi akhir.
Dalam project yang saya kerjakan proses ini merupakan laporan (ExtentReports) untuk merangkum hasil pengujian, dan Memberi gambaran kualitas aplikasi. Deliverable: extent Report.

Pendekatan BDD ini memastikan bahwa pengujian selaras erat dengan kebutuhan bisnis dan mudah dipahami oleh semua pemangku kepentingan.

