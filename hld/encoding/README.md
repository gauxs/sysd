# Encodings
Programs usually work with data in (at least) two different representations:
1. In memory, data is kept in objects, structs, lists, arrays, hash tables, trees, and so on. These data structures are optimized for efficient access and manipulation by the CPU (typically using pointers).
2. When you want to write data to a file or send it over the network, you have to encode it as some kind of self-contained sequence of bytes (for example, a JSON document). Since a pointer wouldn’t make sense to any other process, this sequence-of-bytes representation looks quite different from the data structures that are normally used in memory.

Thus, we need some kind of translation between the two representations. The translation from the in-memory representation to a byte sequence is called encoding (also known as serialization or marshalling), and the reverse is called decoding (parsing, deserialization, unmarshalling).

## References
1. [DDIA Chapter-4: Encoding & Evolution](https://www.amazon.in/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/9352135245/ref=sr_1_2?adgrpid=58563655643&ext_vrnc=hi&gclid=Cj0KCQjwpcOTBhCZARIsAEAYLuUSfHwV3-7i3tvemw-oCjK8Of4E6Tv0Ug8f7EIFmMwTIZJGEspx3_YaArP2EALw_wcB&hvadid=294119043831&hvdev=c&hvlocphy=9061996&hvnetw=g&hvqmt=b&hvrand=17260569075925717915&hvtargid=kwd-340293264171&hydadcr=25367_1900683&keywords=data+intensive+application&qid=1651596791&sr=8-2)
