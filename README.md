# MoonLakeNBT
Minecraft MoonLake NBT Lib
By Month_Light

## 简介
中文 `Minecraft Wiki` 的 `NBT` 格式页面链接: [NBT](http://minecraft-zh.gamepedia.com/NBT%E6%A0%BC%E5%BC%8F) <br />
基于 `Minecraft` 的 `NBT` 格式所制作的 `NBT` 支持库, 读写 `NBT` 文件等等.

## NBT 标签定义
每一个标签在数据树中都是一个独立的部分. 标签的第一个字节为标签类型(ID),其后两字节为存储名称的长度, 之后以 `UTF-8` 
格式的字符串的方式存储标签. 尽管在默认的情况下 `Minecraft` 本身并不会存储带有空格的名称, 但是标签名称可以包含空格.

ID | 图标 | 标签类型 | 对应类型 | 辅助信息 | 描述
--- | --- | --- | --- | --- | ---
0 | N/A | TAG_End | [NBTTagEnd](src/main/java/com/minecraft/moonlake/nbt/NBTTagEnd.java) | 无 | 用于标记复合标签的结尾. 本标签无任何名称所以只有一个零字节.
1 | ![TAG_Byte](images/NBTByte.png) | TAG_Byte | [NBTTagByte](src/main/java/com/minecraft/moonlake/nbt/NBTTagByte.java) | 1字节/8位, 有正负 | 有正负的整值数据类型, 通常用于布尔表达式.
2 | ![TAG_Short](images/NBTShort.png) | TAG_Short | [NBTTagShort](src/main/java/com/minecraft/moonlake/nbt/NBTTagShort.java) | 2字节/16位, 有正负, 字节序: BE | 有正负的整值数据类型.
3 | ![TAG_Int](images/NBTInteger.png) | TAG_Int | [NBTTagInteger](src/main/java/com/minecraft/moonlake/nbt/NBTTagInteger.java) | 4字节/32位, 有正负, 字节序: BE | 有正负的整值数据类型.
4 | ![TAG_Long](images/NBTLong.png) | TAG_Long | [NBTTagLong](src/main/java/com/minecraft/moonlake/nbt/NBTTagLong.java) | 8字节/64位, 有正负, 字节序: BE | 有正负的整值数据类型.
5 | ![TAG_Float](images/NBTFloat.png) | TAG_Float | [NBTTagFloat](src/main/java/com/minecraft/moonlake/nbt/NBTTagFloat.java) | 4字节/32位, 有正负, 字节序: BE, IEEE 754-2008 标准, binary32. | 有正负的浮点数据类型.
6 | ![TAG_Double](images/NBTDouble.png) | TAG_Double | [NBTTagDouble](src/main/java/com/minecraft/moonlake/nbt/NBTTagDouble.java) | 8字节/32位, 有正负, 字节序: BE, IEEE 754-2008 标准, binary64. | 有正负的浮点数据类型.
7 | ![TAG_Byte_Array](images/NBTByteArray.png) | TAG_Byte_Array | [NBTTagByteArray](src/main/java/com/minecraft/moonlake/nbt/NBTTagByteArray.java) | TAG_Int 的辅助信息大小以及 TAG_Byte 的辅助信息大小. | 数组.
8 | ![TAG_String](images/NBTString.png) | TAG_String | [NBTTagString](src/main/java/com/minecraft/moonlake/nbt/NBTTagString.java) | 前2个字节 (TAG_Short) 存储字符串字符的个数(字符串的长度length). 然后存储 UTF-8 标准的字符串, 没有 '\0' 结束符, 只是以单纯的字符序列的形式存储. | 一个采用 UTF-8 标准的字符串, 有尺寸限制, 也就是说会以空结尾.
9 | ![TAG_List](images/NBTList.png) | TAG_List | [NBTTagList](src/main/java/com/minecraft/moonlake/nbt/NBTTagList.java) | 辅助信息的第1个字节 (TAG_Byte) 存储列表标签类型的 ID, 接下来的4个字节 (TAG_Int) 存储列表的 size, 接下来的字节将存储 size 个列表标签类型的辅助信息. 假如第一个字节是 0x08, id是8, 对应的标签是 TAG_String, 如果 size 是 0x00000004, 接下来将会存储4个 TAG_String 标签的辅助信息. 列表标签(既然都说了是列表)存储的内容都是相同类型的标签, 所以只在第一个字节表明标签类型. | 一系列没有重复标签ID和标签名称的辅助信息.
10 | ![TAG_Compound](images/NBTCompound.png) | TAG_Compound | [NBTTagCompound](src/main/java/com/minecraft/moonlake/nbt/NBTTagCompound.java) | 标签的完整形式, 需要附加 TAG_End | 一系列完整的标签信息, 包括ID、名称以及辅助信息等. 任意两个标签都不会有相同的名称.
11 | ![TAG_Int_Array](images/NBTIntegerArray.png) | TAG_Int_Array | [NBTTagIntegerArray](src/main/java/com/minecraft/moonlake/nbt/NBTTagIntegerArray.java) | 辅助信息前4个字节 (TAG_Int) 用于存储数组的大小 size, 紧接 size*4 字节 (TAG_Int) 的数组数据. 占用存储空间: 4+4*size Byte. | 存储 TAG_Int 的辅助信息的数组.

* 图标资源和部分内容均摘自中文 [Minecraft Wiki](http://minecraft-zh.gamepedia.com/NBT%E6%A0%BC%E5%BC%8F) 侵权删.

## ing...
