# my-spring-boot-rabbitmq-workshop

RabbitMQ, çok yaygın olarak kullanılan açık kaynaklı bir mesaj kuyruğu sunucusudur. RabbitMQ mesajlaşma protokolü olan AMQP (Advanced Message Queuing Protocol)’ü kullanır. RabbitMQ’nun fikri AMQP’nin taslak olması ile aynı zamanlara denk gelir.


AMQP Nedir?

Açılımı Advanced Message Queue Protocol(İleri Mesaj Kuyruk Protokolü) demektir. RabbitMQ protokol olarak bunu kullanır. 2006 yılında çıkmıştır bir Message Queue(mesaj kuyruklama) sistemidir.


RabbitMQ’u şöyle bir örnek üzerinden anlatayım. Bir e-mail gönderdiğimiz event düşünün eğer e-mail gönder eventine kodu yazarsak array’da yahut liste veri yapısında 1000'lerce e-mail varsa göndermek çok uzun sürecektir. Bu şekilde sorunları çözmek için Message Queue’lar bire birdir. Asenkron olarak bilgi dağıtımı işlemi için kullanılır.


Erlang /OTP programlama dili ile yazılmıştır. Yakın zamanda Pivotal firması tarafından satın alınmıştır.

RabbitMQ’nun kullanıldığı büyük projelerden bazıları şunlardır; Hufflington Post(Huff Live), Indeed, VMWare(VFabrik), SoundCloud, Mozilla, Ericson(NMX).

Kullanılan alanlar ve kullanım amacı: Yoğun e-mail gönderilen senaryolarda. Yoğun veri işleminin olduğu senaryolarda. Yoğun işlem hacminin bulunduğu yerlerde. Veri kaybedilmemesi durumu olduğu yerlerde kullanılır.

RabbitMQ ve Bileşenleri:

Pulisher → | Exchange →Routes →Queue | →Consumer


Publisher: Bir yazılımdır. Elle kendimizin oluşturması gerekmektedir. Üretici ve mesaj göndericisidir. Milyonlarca veri gönderdiğimizi düşünün.
RabbitMQ her veriyi sıraya koyuyor. Bunları mail atacak olan birime gönderiyor diyebiliriz. Kelime anlamı olarakda paylaşıcı gibi bir anlamı ve çağrışımı vardır. Gönderme işlemini kuyruğa alarak yapar.

Consumer: RabbitMQ’dan gelen mesajı alıp işleyen birimdir. Kelime anlamı olarak tüketici demektir.

RabbitMQ[Exchange]: Mesajlarımızı gönderebilmemiz için anahtar kelimelere ihtiyacımız var. Bu anahtar kelimelere göre ilgili kuruğa veriyi göndermemizi sağlar.

Routing Key: Mesajlarımızı ilgili yerlere göndermemiz için eklediğimiz anahtar kelimelerdir. Exchange alıyor bakıyor anahtar kelime mesela mail.
Hmm o zaman email gönderen sunucuya göndermem için ilgili kuyruklara atmam gerekiyor diye düşünüyor.

Queue: Kelime anlamı kuyruk demektir. 10 tane kuruk düşünün. Yaptığı iş aslında Consumer(tüketici)’lere verileri teker teker göndermek. Birden fazla consumer olabilir yani birden fazla consumer’e mesajlar gönderilebilir.

Channels:

Publisher ← iki yönlü → RabbitMQ ← iki yönlü → Consumer


Channels Publisher’den RabbitMQ’a ve RabbitMQ’dan da Consumer’a giden veri channel’lar yani kanallar aracılığıyla yapılır.
Consumer veriyi aldığını onaylamak için geri bildirim gönderir. Channel’lar 2 yönlü bildirim sağlar.


Exchange Type: 3 çeşittir. Belirli standartlar altında mesajları göndermemizi sağlıyor.

1-) Direct Exchange: Routing Key belirlenir ve bu bilgi ilgili kuyruğa yazılır. Consumer bu anahtar bilgisine göre işlem yapar.

2-) Fanout Exchange: Exchange içinde yer alan tüm mesajlar, tüm kuruklara gönderilir. Routing Key olanlar ise göz ardı edilir.

3-) Topic Exchange: Verilen anahtara göre farklı farklı kuyruklara yazma işlemini Topic Exchange yapar. Ayrıca kendine göre WildCard desteği bulunur. Örneğin * ve # ile belirli bir gruba yada tüm mesajlara erişmek mümkündür.


RabbitMQ’nun Terminalden Çalıştırılması:

$: rabbitmq_plugins enable rabbitmq_management
Sonrasında bir tarayıcıya girelim.
Chrome :> localhost:15672 > username: guest | password : guest şeklinde girelim.
Artık RabbitMQ’nun arayüzündeyiz.


Spring Boot ve RabbitMQ’u birlikte kullanarak yaptığım örnek bir demo proje:

github.com/huseyinaydn99/spring-boot-tutorials-demos/spring-boot-rabbitmq-example-demo

Teşekkürler. Umarım faydalı olmuştur.