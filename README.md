# Dört İşlem Hesap Makinesi(OSGi)
Bu uygulama, kullanıcılara girdikleri iki sayıyla dört işlem yapmalarını sağlar ve sonucu gösterir.


## Özellikler
- Uygulama Türkçe ve İngilizce dil desteği sunar. Bilgisayarın dili ne ise ona göre çalışır.
- Varsayılan dil Türkçe'dir, ancak etkin "locale" ayarına göre İngilizce olarak da çalışabilir.
- İki OSGi servisiyle yapılandırılmıştır.
- Birinci servis, metin tabanlı sayıları dönüştürmekle sorumludur.
- İkinci servis, kullanıcı arayüzünü ve dört işlemi sunar.
- İşlemler tam sayılarla gerçekleştirilir.
- Eclipse IDE üzerinde çalıştırılabilir.
- Kullanıcı arayüzü için Swing kullanılmıştır.

## Nasıl Kullanılır?
Eclipse IDE üzerinde projeyi açın.
Projeyi çalıştırın.
Uygulama başladığında, kullanıcı arayüzü belirecektir.
İki sayıyı girin ve işlem türünü seçin (toplama, çıkarma, çarpma veya bölme).
Sonuç kısmında işlem sonucu görüntülenecektir.
Büyük sayılar girildiğinde sonuç kısmında sayıyı tam görmek için UI büyültülebilir.


## Dil Değiştirme
Varsayılan olarak Türkçe dili kullanılır.
Eğer bilgisayarınızın dili İngilizce ise uygulama dili İngilizce olarak değişecektir ve girdileri de İngilizce olarak yazmanız gerekecektir. Eğer Türkçe girmeye çalışırsanız uygulama uyarı verecektir.


## OSGi Nedir?
OSGi (Open Services Gateway initiative), modüler ve bileşen tabanlı yazılım geliştirmeyi destekleyen bir standarttır. Bu uygulamada OSGi kullanılarak, yazılımın modüler ve esnek olması sağlanmıştır. Bu, yazılımı bağımsız bileşenlere ayırarak, geliştirme, dağıtım ve sürdürme süreçlerini kolaylaştırır.

## Lokalizasyon(Localization)
Uygulamanın dil desteği için ResourceBundle sınıfı kullanılmıştır. Bu sınıf, çeşitli dil ve ülke ayarlarına göre metinleri yerelleştirmek için kullanılır. Projede, dil dosyaları içeren bir kaynak klasörü bulunur. Uygulama, bilgisayarın diline göre İngilizce ya da Türkçe olarak çalışır.

## Yapılandırmayı Başlatmak(Launch Configuration)
Uygulamayı Eclipse IDE üzerinde çalıştırmak için öncelikle bir Launch Configuration ayarlaması yapmanız gerekmektedir. Bunun için, Eclipse IDE'de projenizin bulunduğu dizinde sağ tıklayarak bir bağlam menüsü açın. Ardından "Run As" veya "Debug As" seçeneğine gelin ve buradan "Run Configurations" veya "Debug Configurations" seçeneğini tıklayın. Karşınıza çıkacak pencerede "OSGi Framework" veya "OSGi Framework Application" adında yeni bir yapılandırma oluşturun. Projenizi seçin ve başlangıç noktası olarak OSGi Framework'un başlatılmasını sağlayacak olan sınıfı belirtin. Ayarlarınızı tamamladıktan sonra "Apply" veya "Run" düğmesine tıklayarak uygulamanızı çalıştırabilirsiniz.
