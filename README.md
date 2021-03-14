<div dir="rtl">

# گۆڕینی ژمارە بۆ نوسراوی کوردی ناوەندی

## Introduction
دەتوانرێت بەکار بهێنرێت لەگەڵ ژمارە تەواوە ئەرێنیەکان (موجەبەکان) هەتا 999,999,999,999


## Usage
### زیادکردن بە پاکێج بۆ پرۆجێکتی خۆت 
پێویستە فۆڵدەری **KurdishNumberToWords** لە بەشی **src** زیاد بکەیتە ناو پرۆژێکتەکەت و فایلی **NumberToKurdishWords** ئاماژە پێبکەیتە پاکێجی پرۆژەکەت
</div>
```java
import KurdishNumberToWords.NumberToKurdishWords;
```
<div dir="rtl">
### بۆ گۆڕینی ژمارە بۆ نوسراوی کوردی
کاتێک فایلەکە بە سەرکەوتویی زیادکرا بۆ پاکێجەکەت، ئەوا ڕاستەوخۆ بە بەکارهێنانی مێثۆدی ***convert*** لە کلاسی **NumberToKurdishWords** ئەتوانیت گۆڕانکاریەکە ئەنجام بدەیت
</div>
```java
System.out.println(NumberToKurdishWords.convert(2021)); // دوو هەزار و بیست و یەک
```
<div dir="rtl">
### تەنها کۆپی کردنی **NumberToKurdishWords** بۆ پاکێجێکی پرۆژەکەت
زیادکردنی فایلی **NumberToKurdishWords** بۆ پرۆجێکتەکەت تەنها وا دەکات ڕاستەوخۆ بتوانی مێثۆدی **convert** بەکاربهێنیت لە کلاسەکاندا
<div>
```java
System.out.println(NumberToKurdishWords.convert(250370891)); // دوو سەد و پەنجا ملیۆن و سێ سەد و حەفتا هەزار و هەشت سەد و نەوەد و یەک
```


## Version Logs

__Version 1.0.0__
* Converts Numbers to Central Kurdish number
* can take between 0 and 999999999999