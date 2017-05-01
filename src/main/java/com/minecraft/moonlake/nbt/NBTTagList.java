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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NBTTagList<E extends NBTBase> extends NBTTagDatable<List<E>> implements Iterable<E> {

    private int elementTypeId;

    public NBTTagList() {
        this(new ArrayList<>());
    }

    public NBTTagList(List<E> value) {
        this("", value);
    }

    public NBTTagList(String name) {
        this(name, new ArrayList<>());
    }

    public NBTTagList(String name, List<E> value) {
        super(name, value);
        for(E element : value)
            checkElementType(element);
    }

    @Override
    public NBTType getType() {
        return NBTType.LIST;
    }

    @Override
    public List<E> getValue() {
        // 创建一个新的数组列表并拷贝值, 而不是返回当前 value 引用
        return new ArrayList<>(value);
    }

    private void checkElementType(E element) {
        if(elementTypeId == 0)
            this.elementTypeId = element.getTypeId();
        else if(element.getTypeId() != elementTypeId)
            throw new IllegalArgumentException("列表元素值不符合的类型 Id, 应为: " + elementTypeId + ", 对应类型: " + NBTType.fromTypeId(elementTypeId) + ".");
    }

    public int getElementTypeId() {
        return elementTypeId;
    }

    public boolean add(E value) {
        checkElementType(value);
        return super.value.add(value);
    }

    public boolean remove(E value) {
        return super.value.remove(value);
    }

    public E get(int index) {
        return super.value.get(index);
    }

    public int size() {
        return super.value.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        super.value.clear();
        this.elementTypeId = 0; // 重置元素类型 id
    }

    @Override
    public void setValue(List<E> value) {
        for(E element : value)
            checkElementType(element);
        super.value = new ArrayList<>(value);
    }

    @Override
    @SuppressWarnings("all")
    public void read(DataInput input) throws IOException {
        int typeId = input.readUnsignedByte();
        super.value = new ArrayList<>();
        this.elementTypeId = typeId;
        int length = input.readInt();
        for(int i = 0; i < length; i++) {
            NBTBase nbt = NBTType.createNBTTag(typeId);
            nbt.read(input);
            add((E) nbt);
        }
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeByte(isEmpty() ? 0 : elementTypeId);
        output.writeInt(size());
        for(E element : getValue())
            element.write(output);
    }

    @Override
    @SuppressWarnings("unchecked")
    public NBTTagList<E> clone() {
        List<E> value = new ArrayList<>();
        for(E element : getValue())
            value.add((E) element.clone()); // 创建 NBTTag 对象的克隆
        return new NBTTagList<>(getName(), value);
    }

    @Override
    public Iterator<E> iterator() {
        return value.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            NBTTagList other = (NBTTagList) obj;
            if(elementTypeId == other.elementTypeId)
                return value.equals(other.value);
        }
        return false;
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean json) {
        StringBuilder builder = new StringBuilder("[");
        for(int i = 0; i < size(); i++) {
            if(i != 0)
                builder.append(",");
            if(!json)
                builder.append(i).append(":");

            NBTBase nbt = get(i);
            if(nbt instanceof NBTTagList)
                builder.append(((NBTTagList) nbt).toString(json));
            else if(nbt instanceof NBTTagCompound)
                builder.append(((NBTTagCompound) nbt).toString(json));
            else
                builder.append(nbt);
        }
        return builder.append("]").toString();
    }
}
