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

public abstract class NBTTagNumber<T extends Number> extends NBTTagDatable<T> {

    public NBTTagNumber(String name, T value) {
        super(name, value);
    }

    public int intValue() {
        return getValue().intValue();
    }

    public long longValue() {
        return getValue().longValue();
    }

    public float floatValue() {
        return getValue().floatValue();
    }

    public double doubleValue() {
        return getValue().doubleValue();
    }

    public byte byteValue() {
        return getValue().byteValue();
    }

    public short shortValue() {
        return getValue().shortValue();
    }
}
