[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<br>

<p align="center">
  <h2 align="center">Java_Hexagonal_Architecture_employee-permission</h2>
  <p align="center">
    Domain: <a href="https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/tree/main/domain">Domain</a>
    Infrastructure : <a href="https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/tree/main/infrastructure">Infrastructure</a>
    <br />
    <br />
    <a href="https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/issues">Report Bug</a>
    ·
    <a href="https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/issues">Request Feature</a>
  </p>
</p>


## Acknowledgements

- ibrahimaltinoluk
- mustafapicakci
- kenanyasinsarigul

## Author
Tugay İPEK- <a href="https://github.com/tugayipek1/">Github</a>

[contributors-shield]: https://img.shields.io/github/contributors/tugayipek1/Java_Hexagonal_Architecture_employee-permission.svg?style=for-the-badge
[contributors-url]: https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/tugayipek1/Java_Hexagonal_Architecture_employee-permission.svg?style=for-the-badge
[forks-url]: https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/network/members
[stars-shield]: https://img.shields.io/github/stars/tugayipek1/Java_Hexagonal_Architecture_employee-permission.svg?style=for-the-badge
[stars-url]: https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/stargazers
[issues-shield]: https://img.shields.io/github/issues/tugayipek1/Java_Hexagonal_Architecture_employee-permission.svg?style=for-the-badge
[issues-url]: https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/issues
[license-shield]: https://img.shields.io/github/license/tugayipek1/Java_Hexagonal_Architecture_employee-permission.svg?style=for-the-badge
[license-url]: https://github.com/tugayipek1/Java_Hexagonal_Architecture_employee-permission/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://github.com/tugayipek1

# Hexagonal Mimari Örnek Uygulaması Hakkında

Domain ve Infrastructure katmanının bulunduğu iki ana maven modülü bulunmaktadır.

## Domain

Domain modülü herhangi bir db, que yada framework'e bağımlı değildir.
Sorumluluğu olan business'ı yerine getirir.

- Varlıkların kalıcılığını (diske yazma, hafızada tutma) sağlama,
- Kullanıcıdan veri alma (Http, CLI, Form...),
  sorumluluğunu `application` katmanına bırakır.

Bu repodaki örnek business, personelin bina ve daireler içerisindeki giriş çıkış yetkileri ile ilgilidir

## Application

Bu modül, domain katmanındaki business'ı çalıştır hale getirecek etkileşimleri (springboot http) ve altyapıları (postgresql db) sağlamaktadır.

## Application katmanı nasıl geliştirilmeli?

### Crud işlemleri

Domain katmanı crud işlemlerini `com.acme.domain.<entity>.service` paketi içerisindeki servis implementayonları sayesinde gerçekleştirir. Ancak varlıkların kalıcılığını sağlanması sorumluluğunu application katmanına bırakır. Application katmanının bunu sağlayabilmesi için domain katmanının verdiği apiler `com.acme.domain.<entity>.port` altındaki repository interface'leridir.

## Örnek Case Hakkında

- Uygulamada firma tanımlanabilir.
- Binanın bir adresi olmalı.
- Firmaya ait yalnızca bir bina tanımlanabilir.
- Binaya ait katlar bulunuyor.
- Bir binada en fazla 5 kat bulunabilir.
- Katlara girmek isteyen personellerin hangi yetkilere sahip olması gerektiği katlara tanımlanabilir.
- Katlara ait daireler bulunuyor.
- Bir katta en fazla 4 daire olabilir.
- Dairelere girmek isteyen personellerin hangi yetkilere sahip olması gerektiği daireye tanımlanabilir.
- Firmaya ait departmanlar bulunuyor.
- Deparmana ait personellerin yetkileri departmana tanımlanabilir.
- Departmana ait personeller bulunuyor.
- Sistemde bir takım yetkileri bulunuyor.
- Sistemdeki yetkiler hem departman hem de personele verilebiliyor.
- Personel ait yetkiler departmanına ait yetkileri ezmektedir.

Her departman'ın personellerine ait genel kısıtlar bulunuyor. Örneğin IT departmanında çalışan personeller yalnızca 1. ve 2. kata çıkabilir. yada sadece daire 5 ve 7 ye giriş yapabilir. gibi..

Her giriş çıkış işlemi ve başarı durumu loglanmalı.
