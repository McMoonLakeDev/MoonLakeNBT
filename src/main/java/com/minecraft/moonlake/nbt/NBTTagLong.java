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

public class NBTTagLong extends NBTTagNumber<Long> {

    public NBTTagLong() {
        this(0L);
    }

    public NBTTagLong(long value) {
        this("", value);
    }

    public NBTTagLong(String name) {
        this(name, 0L);
    }

    public NBTTagLong(String name, Long value) {
        super(name, value);
    }

    public void set(long value) {
        super.value = value;
    }

    @Override
    public NBTType getType() {
        return NBTType.LONG;
    }

    @Override
    public void read(DataInput input) throws IOException {
        super.value = input.readLong();
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeLong(value);
    }

    @Override
    public NBTTagLong clone() {
        return new NBTTagLong(getName(), value);
    }
}
