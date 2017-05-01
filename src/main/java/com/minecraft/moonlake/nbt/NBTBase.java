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

public abstract class NBTBase implements Cloneable {

    private final String name;

    public NBTBase(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract Object getValue();

    public abstract NBTType getType();

    public abstract void read(DataInput input) throws IOException;

    public abstract void write(DataOutput output) throws IOException;

    public int getTypeId() {
        return getType().getTypeId();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj instanceof NBTBase) {
            NBTBase other = (NBTBase) obj;
            return name.equals(other.name) && getTypeId() == other.getTypeId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getTypeId();
    }

    @Override
    public abstract String toString();

    @Override
    public abstract NBTBase clone();
}
