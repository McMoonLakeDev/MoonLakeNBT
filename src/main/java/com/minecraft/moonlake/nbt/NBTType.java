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

import java.util.HashMap;
import java.util.Map;

public enum NBTType {

    END(0, NBTTagEnd.class),
    BYTE(1, NBTTagByte.class),
    SHORT(2, NBTTagShort.class),
    INTEGER(3, NBTTagInteger.class),
    LONG(4, NBTTagLong.class),
    FLOAT(5, NBTTagFloat.class),
    DOUBLE(6, NBTTagDouble.class),
    BYTE_ARRAY(7, NBTTagByteArray.class),
    STRING(8, NBTTagString.class),
    LIST(9, NBTTagList.class),
    COMPOUND(10, NBTTagCompound.class),
    INTEGER_ARRAY(11, NBTTagIntegerArray.class),
    ;

    private final int typeId;
    private final Class<? extends NBTBase> clazz;
    private final static Map<Integer, NBTType> ID_MAP;

    static {
        ID_MAP = new HashMap<>();
        for(NBTType type : values())
            ID_MAP.put(type.getTypeId(), type);
    }

    NBTType(int typeId, Class<? extends NBTBase> clazz) {
        this.typeId = typeId;
        this.clazz = clazz;
    }

    public int getTypeId() {
        return typeId;
    }

    public Class<? extends NBTBase> getClazz() {
        return clazz;
    }

    public static NBTType fromTypeId(int typeId) {
        switch (typeId) {
            case 0:
                return END;
            case 1:
                return BYTE;
            case 2:
                return SHORT;
            case 3:
                return INTEGER;
            case 4:
                return LONG;
            case 5:
                return FLOAT;
            case 6:
                return DOUBLE;
            case 7:
                return BYTE_ARRAY;
            case 8:
                return STRING;
            case 9:
                return LIST;
            case 10:
                return COMPOUND;
            case 11:
                return INTEGER_ARRAY;
            default:
                return null;
        }
    }

    public static NBTBase createNBTTag(int typeId) {
        return createNBTTag(typeId, "");
    }

    public static NBTBase createNBTTag(int typeId, String name) {
        switch (typeId) {
            case 0:
                return new NBTTagEnd();
            case 1:
                return new NBTTagByte(name);
            case 2:
                return new NBTTagShort(name);
            case 3:
                return new NBTTagInteger(name);
            case 4:
                return new NBTTagLong(name);
            case 5:
                return new NBTTagFloat(name);
            case 6:
                return new NBTTagDouble(name);
            case 7:
                return new NBTTagByteArray(name);
            case 8:
                return new NBTTagString(name);
            case 9:
                return new NBTTagList<>(name);
            case 10:
                return new NBTTagCompound(name);
            case 11:
                return new NBTTagIntegerArray(name);
            default:
                return null;
        }
    }
}
