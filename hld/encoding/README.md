# Encodings
Programs usually work with data in (at least) two different representations:
1. In memory, data is kept in objects, structs, lists, arrays, hash tables, trees, and so on. These data structures are optimized for efficient access and manipulation by the CPU (typically using pointers).
2. When you want to write data to a file or send it over the network, you have to encode it as some kind of self-contained sequence of bytes (for example, a JSON document). Since a pointer wouldn’t make sense to any other process, this sequence-of-bytes representation looks quite different from the data structures that are normally used in memory.

Thus, we need some kind of translation between the two representations. The translation from the in-memory representation to a byte sequence is called encoding (also known as serialization or marshalling), and the reverse is called decoding (parsing, deserialization, unmarshalling).

Encoding involves the use of a code to change original data into a form that can be used by an external process.

#### Types of encoding formats
1. Language specific formats
   - python's pickle
2. JSON, XML and Binary variants
3. Thrift and Protocol buffers
4. Avro

## Character encoding
Character encoding is the process of representing individual characters using a corresponding encoding system made up of other symbols and types of data. Character coding is used for many different purposes. Character encoding is also known as a character set or character map.

#### American Standard Code for Information Interchange (ASCII)
The type of code used for converting characters is known as American Standard Code for Information Interchange (ASCII), the most commonly used encoding scheme for files that contain text. 

The standard ASCII scheme has only zero to 127 character positions; 128 through 255 are undefined. The problem of undefined characters is solved by Unicode encoding, which assigns a number to every character used worldwide. Other types of codes include BinHex, Uuencode (UNIX to UNIX encoding) and Multipurpose Internet Mail Extensions (MIME).

#### Unicode
Unicode, formally the Unicode Standard, is an information technology standard for the consistent encoding, representation, and handling of text expressed in most of the world's writing systems. 

The Unicode standard defines Unicode Transformation Formats (UTF): UTF-8, UTF-16, and UTF-32, and several other encodings. The most commonly used encodings are UTF-8, UTF-16, and the obsolete UCS-2.

UTF-8, the dominant encoding on the World Wide Web (used in over 95% of websites as of 2020, and up to 100% for some languages) and on most Unix-like operating systems, uses one byte(8 bits) for the first 128 code points, and up to 4 bytes for other characters. The first 128 Unicode code points represent the ASCII characters, which means that any ASCII text is also a UTF-8 text.

#### Base-64 encoding


## References
1. [DDIA Chapter-4: Encoding & Evolution](https://www.amazon.in/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/9352135245/ref=sr_1_2?adgrpid=58563655643&ext_vrnc=hi&gclid=Cj0KCQjwpcOTBhCZARIsAEAYLuUSfHwV3-7i3tvemw-oCjK8Of4E6Tv0Ug8f7EIFmMwTIZJGEspx3_YaArP2EALw_wcB&hvadid=294119043831&hvdev=c&hvlocphy=9061996&hvnetw=g&hvqmt=b&hvrand=17260569075925717915&hvtargid=kwd-340293264171&hydadcr=25367_1900683&keywords=data+intensive+application&qid=1651596791&sr=8-2)
2. [Stackoverflow - What is base-64 encoding](https://stackoverflow.com/questions/201479/what-is-base-64-encoding-used-for/201510#201510)
3. [Medium - What is base-64 encoding](https://levelup.gitconnected.com/what-is-base64-encoding-4b5ed1eb58a4)
