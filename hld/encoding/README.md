# Encoding

Programs usually work with data in (at least) two different representations:

1. In memory, data is kept in objects, structs, lists, arrays, hash tables, trees, and so on. These data structures are optimized for efficient access and manipulation by the CPU (typically using pointers).
2. When you want to write data to a file or send it over the network, you have to encode it as some kind of self-contained sequence of bytes (for example, a JSON document). Since a pointer wouldn’t make sense to any other process, this sequence-of-bytes representation looks quite different from the data structures that are normally used in memory.

Thus, we need some kind of translation between the two representations. The translation from the in-memory representation to a byte sequence is called encoding (also known as serialization or marshalling), and the reverse is called decoding (parsing, deserialization, unmarshalling). Encoding involves the use of a code to change original data into a form that can be used by an external process.

Types of encoding mechanisms

1. **Language specific encoding**: Many programming languages come with built-in support for encoding in-memory objects into byte sequences. For example, Java has java.io.Serializable, Ruby has Marshal, Python has pickle.

2. **Standardized encoding**: These encodings can be written and read by many programming languages. Example: JSON, XML and CSV etc.

3. **Binary encoding**: For data that is used only internally within your organization, there is less pressure to use a lowest-common-denominator encoding format. For example, you could choose a format that is more compact or faster to parse. For a small dataset, the gains are negligible, but once you get into the terabytes, the choice of data format can have a big impact. JSON is less verbose than XML, but both still use a lot of space compared to binary formats. This observation led to the development of a profusion of **_binary encodings_** for JSON (MessagePack, BSON, BJSON, UBJSON, BISON, and Smile, to name a few) and for XML (WBXML and Fast Infoset, for example). These formats have been adopted in various niches, but none of them are as widely adopted as the textual versions of JSON and XML.

   - Thrift and Protocol buffers: Apache Thrift and Protocol Buffers (protobuf) are binary encoding libraries that are based on the same principle. Protocol Buffers was originally developed at Google, Thrift was originally developed at Facebook.

   - Avro: Apache Avro is another binary encoding format that is interestingly different from Protocol Buffers and Thrift. It was started in 2009 as a subproject of Hadoop, as a result of Thrift not being a good fit for Hadoop’s use cases

## Character encoding

Character encoding is the process of representing individual characters using a corresponding encoding system made up of other symbols and types of data. Character coding is used for many different purposes. Character encoding is also known as a character set or character map.

1. **American Standard Code for Information Interchange (ASCII)** - The type of code used for converting characters is known as American Standard Code for Information Interchange (ASCII), the most commonly used encoding scheme for files that contain text.The standard ASCII scheme has only zero to 127 character positions; 128 through 255 are undefined. The problem of undefined characters is solved by Unicode encoding, which assigns a number to every character used worldwide. Other types of codes include BinHex, Uuencode (UNIX to UNIX encoding) and Multipurpose Internet Mail Extensions (MIME).

2. **Unicode Standard** - Unicode, formally the Unicode Standard, is an information technology standard for the consistent encoding, representation, and handling of text expressed in most of the world's writing systems. The Unicode standard defines Unicode Transformation Formats (UTF): UTF-8, UTF-16, and UTF-32, and several other encodings. The most commonly used encodings are UTF-8, UTF-16, and the obsolete UCS-2.

   - **UTF-8**, the dominant encoding on the World Wide Web (used in over 95% of websites as of 2020, and up to 100% for some languages) and on most Unix-like operating systems, uses one byte(8 bits) for the first 128 code points, and up to 4 bytes for other characters. The first 128 Unicode code points represent the ASCII characters, which means that any ASCII text is also a UTF-8 text.

**Note:** An **escape sequence** in a programming language is a sequence of characters that doesn't represent itself when used inside string literal or character. It is composed of two or more characters starting with backslash \. For example: \n represents new line.

3. **Base-64 encoding** - The base64 is a binary to a text encoding scheme that represents binary data in an ASCII string format. base64 is designed to carry data stored in binary format across the channels. It takes any form of data and transforms it into a long string of plain text. The steps followed by the base64 algorithm are as follow:

- count the number of characters in a String
- if it is not multiple of 3 pad with special character i.e., = to make it multiple of 3
- encode the string in ASCII format, it will convert the **ASCII to binary** format 8-bit each
- after converting to binary format, it will divide binary data into chunks of 6-bits each
- chunks of 6-bit binary data will now be converted to decimal number format
- using the base64 Index Table, the decimals will be again converted to a string according to the table format
- finally, we will get the encoded version of our input string.

**Note**: We encode text using UTF-8 to binary and then binary to base-64 text via Base-64 encoding. When you have some binary data that you want to ship across a network, you generally don't do it by just streaming the bits and bytes over the wire in a raw format. Why? because some media are made for streaming text. You never know -- some protocols may interpret your binary data as control characters (like a modem), or your binary data could be screwed up because the underlying protocol might think that you've entered a special character combination (like how FTP translates line endings). So to get around this, people encode the binary data into characters. Base64 is one of these types of encodings.

**Note**: We can send the text data directly over the network thus removing UTF-8 and Base-64 but this won't be compatible with some of the existing system like SMTP. Base64 is also widely used for sending e-mail attachments. This is required because SMTP—in its original form—was designed to transport 7-bit ASCII characters only.

## References

1. [Designing data intensive applications, Chapter-4: Encoding & Evolution](https://www.amazon.in/Designing-Data-Intensive-Applications-Reliable-Maintainable-ebook/dp/B06XPJML5D)
2. [What is character encoding](https://www.w3.org/International/questions/qa-what-is-encoding)
3. [Unicode - UTF-8 Encoding](https://blog.hubspot.com/website/what-is-utf-8#:~:text=UTF%2D8%20is%20an%20encoding,or%20%E2%80%9CUnicode%20Transformation%20Format.%E2%80%9D)
4. [Stackoverflow - What is base-64 encoding](https://stackoverflow.com/questions/201479/what-is-base-64-encoding-used-for/201510#201510)
5. [Medium - What is base-64 encoding](https://levelup.gitconnected.com/what-is-base64-encoding-4b5ed1eb58a4)
