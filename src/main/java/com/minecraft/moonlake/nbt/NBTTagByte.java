/*
 * Copyright (C) 2017 The MoonLake Authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.minecraft.moonlake.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * <h1>NBTTagByte</h1>
 * NBT 标签字节类型数据
 *
 * @version 1.0
 * @author Month_Light
 * @see NBTTagNumber
 * @see Byte
 */
public class NBTTagByte extends NBTTagNumber<Byte> {

    /**
     * NBT 标签字节类型数据构造函数
     */
    public NBTTagByte() {
        this((byte) 0);
    }

    /**
     * NBT 标签字节类型数据构造函数
     *
     * @param value 值
     */
    public NBTTagByte(byte value) {
        this("", value);
    }

    /**
     * NBT 标签字节类型数据构造函数
     *
     * @param name 特殊名
     */
    public NBTTagByte(String name) {
        this(name, (byte) 0);
    }

    /**
     * NBT 标签字节类型数据构造函数
     *
     * @param name 特殊名
     * @param value 值
     */
    public NBTTagByte(String name, Byte value) {
        super(name, value);
    }

    /**
     * 设置此 NBT 标签字节数据的值
     *
     * @param value 新值
     */
    public void set(byte value) {
        super.value = value;
    }

    @Override
    public NBTType getType() {
        return NBTType.BYTE;
    }

    @Override
    public void read(DataInput input) throws IOException {
        super.value = input.readByte();
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeByte(value);
    }

    @Override
    public NBTTagByte clone() {
        return new NBTTagByte(getName(), value);
    }
}
