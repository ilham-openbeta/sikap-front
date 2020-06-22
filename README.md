# Sistem Informasi Kerja Praktek - Frontend
Aplikasi ini digunakan untuk memudahkan mahasiswa, dosen, dan akademik dalam pendaftaran Kerja Praktek. Aplikasi ini merupakan bagian frontend GUI dari aplikasi sikap yang dibuat menggunakan bahasa pemrograman Java. Pengguna utama aplikasi ini adalah akademik. Dosen dan Mahasiswa menggunakan aplikasi [sikap-server](https://github.com/ilham-openbeta/sikap-server)

Beberapa fitur pada aplikasi ini yaitu :
- Manipulasi Data Mahasiswa dan Dosen
- Pendaftaran Kerja Praktek dan Seminar Kerja Praktek
- Pembuatan Surat Tugas Kerja Praktek

## Screenshot
### Menu Kerja Praktek
[![kerjapraktek](https://github.com/ilham-openbeta/sikap-front/raw/master/screenshot/menu%20kerja%20praktek.png)](https://github.com/ilham-openbeta/sikap-front/raw/master/screenshot/menu%20kerja%20praktek.png)

### Menu Surat Tugas
[![surattugas](https://github.com/ilham-openbeta/sikap-front/raw/master/screenshot/menu%20surat%20tugas.png)](https://github.com/ilham-openbeta/sikap-front/raw/master/screenshot/menu%20surat%20tugas.png)

## Cara Menggunakan :
Syarat kebutuhan aplikasi :
- [sikap-server](https://github.com/ilham-openbeta/sikap-server)
- Java Runtime Environment (JRE) 1.8

Cara install :
1. Aplikasi ini membutuhkan sikap-server untuk berjalan, untuk memasangnya lihat pada repository [sikap-server](https://github.com/ilham-openbeta/sikap-server).
2. Unduh aplikasi pada halaman [release](https://github.com/ilham-openbeta/sikap-front/releases/download/v1.0/Sistem.Informasi.KP.zip).
3. Atur alamat URL pada file server.cfg dengan alamat URL [sikap-server](https://github.com/ilham-openbeta/sikap-server).
4. Jalankan aplikasi dengan perintah
```
java -jar sistem_kp.jar
```
5. Login dengan akun berikut:
Username: admin
Password: admin123
6. Template surat dapat diatur dengan merubah file .docx pada folder template.

## Cara Mengembangkan Program :
Syarat kebutuhan aplikasi :
- [sikap-server](https://github.com/ilham-openbeta/sikap-server)
- Java Development Kit (JDK) 1.8
- NetBeans IDE 8.2

Cara install :
1. Download atau Clone repositori ini.
2. Buka folder project sistem_kp menggunakan aplikasi netbeans.
3. Gunakan netbeans untuk membuild aplikasi kemudian tambahkan file yang ada di dalam "file tambahan.zip" ke folder hasil build (sistem_kp/dist).

## Detail aplikasi
Aplikasi dibuat menggunakan Design Pattern MVC-like, DAO, dan Factory Pattern. Library yang digunakan pada aplikasi :
- jcalendar-1.4.jar (Kalender)
- json-simple-1.1.1.jar (memproses data JSON untuk RESTful API client)
- poi-3.16.jar (memproses dokumen Microsoft Word)
- poi-ooxml-3.16.jar (memproses dokumen Microsoft Word)
- poi-ooxml-schemas-3.16.jar (memproses dokumen Microsoft Word)
- xmlbeans-2.6.0.jar (memproses dokumen Microsoft Word)

## Known Issues
- Hanya bisa jalan di Java versi 8 (1.8).
- Tidak bisa merubah font style pada surat yang dibuat.
- Tidak ada fitur ubah password dan kelola akun.

## Catatan
Aplikasi ini digunakan dibuat untuk menyelesaikan tugas mata kuliah kerja bengkel. Aplikasi tidak pernah diimplementasikan. Data pada aplikasi hanyalah data palsu. Logo UGM milik UGM.
