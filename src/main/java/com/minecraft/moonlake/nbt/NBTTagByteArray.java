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
import java.util.Arrays;

public class NBTTagByteArray extends NBTTagDatable<Byte[]> {

    public NBTTagByteArray() {
        this(new Byte[0]);
    }

    public NBTTagByteArray(byte[] value) {
        this("", value);
    }

    public NBTTagByteArray(Byte[] value) {
        this("", value);
    }

    public NBTTagByteArray(String name) {
        this(name, new Byte[0]);
    }

    public NBTTagByteArray(String name, byte[] value) {
        super(name, null); // 先传一个 null 值之后再重新设置新值
        set(value);
    }

    public NBTTagByteArray(String name, Byte[] value) {
        super(name, value);
    }

    @Override
    public NBTType getType() {
        return NBTType.BYTE_ARRAY;
    }

    public void set(byte[] value) {
        Byte[] value0 = new Byte[value.length];
        for(int i = 0; i < value0.length; i++)
            value0[i] = value[i];
        super.value = value0;
    }

    public byte[] get() {
        byte[] value0 = new byte[value.length];
        for(int i = 0; i < value0.length; i++)
            value0[i] = value[i];
        return value0;
    }

    @Override
    public void read(DataInput input) throws IOException {
        byte[] value = new byte[input.readInt()];
        input.readFully(value);
        set(value);
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeInt(value.length);
        output.write(get());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && Arrays.equals(value, ((NBTTagByteArray) obj).value);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for(int i = 0; i < getValue().length; i++)
            builder.append(value[i]).append(",");
        return builder.append("]").toString();
    }

    @Override
    public NBTTagByteArray clone() {
        return new NBTTagByteArray(getName(), value);
    }
}
