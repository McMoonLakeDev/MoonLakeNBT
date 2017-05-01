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


package com.minecraft.moonlake.nbt.test;

import com.minecraft.moonlake.nbt.NBTTagCompound;
import com.minecraft.moonlake.nbt.NBTTagList;
import com.minecraft.moonlake.nbt.NBTTagString;
import com.minecraft.moonlake.nbt.NBTUtil;

import java.io.File;
import java.io.IOException;

public class NBTTest {

    public static void main(String[] args) {
        testWrite();
        testRead();
        testPlayerdata();
        testWorldLevel();
    }

    static void testPlayerdata() {
        try {
            NBTTagCompound root = NBTUtil.readFile(new File("src\\test\\Month_Light.dat"));
            System.out.println("read player: " + root.toString(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testWorldLevel() {
        try {
            NBTTagCompound root = NBTUtil.readFile(new File("src\\test\\level.dat"));
            System.out.println("read level: " + root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testWrite() {
        NBTTagCompound root = new NBTTagCompound();
        root.setString("id", "minecraft:iron_sword");
        root.setByte("Count", 1);
        root.setShort("Damage", 0);
        NBTTagCompound tag = new NBTTagCompound("tag");
        NBTTagList<NBTTagCompound> ench = new NBTTagList<>("ench");
        NBTTagCompound ench1 = new NBTTagCompound();
        ench1.setShort("id", 16);
        ench1.setShort("lvl", 32767);
        ench.add(ench1);
        NBTTagCompound display = new NBTTagCompound("display");
        NBTTagList<NBTTagString> lore = new NBTTagList<>("Lore");
        lore.add(new NBTTagString("", "lore1"));
        lore.add(new NBTTagString("", "lore2"));
        lore.add(new NBTTagString("", "lore3"));
        display.setString("Name", "Big Sword");
        display.put(lore);
        tag.put(ench);
        tag.put(display);
        root.put(tag);

        System.out.println(root.toString());

        try {
            NBTUtil.writeFile(root, new File("src\\test\\item.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testRead() {
        try {
            NBTTagCompound root = NBTUtil.readFile(new File("src\\test\\item.dat"));
            System.out.println("read: " + root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
