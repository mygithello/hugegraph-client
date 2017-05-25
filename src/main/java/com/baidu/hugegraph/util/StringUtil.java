package com.baidu.hugegraph.util;

import java.util.Set;

import com.google.common.base.Preconditions;

/**
 * Created by liningrui on 2017/3/22.
 */
public class StringUtil {
    public static String descSchema(String prefix, Set<String> elems) {
        StringBuilder desc = new StringBuilder();

        if (elems != null) {
            desc.append(".").append(prefix).append("(");
            for (String elem : elems) {
                desc.append("\"").append(elem).append("\",");
            }
            int endIdx = desc.lastIndexOf(",") > 0 ?
                         desc.length() - 1 : desc.length();

            desc = desc.substring(0, endIdx).append(")");
        }

        return desc.toString();
    }

    public static void checkName(String name) {
        Preconditions.checkNotNull(name, "name can't be null.");
        Preconditions.checkNotNull(!name.isEmpty(), "name can't be empty.");
        Preconditions.checkArgument(name.length() < 256,
                "The length of name must less than 256 bytes.");
        Preconditions.checkArgument(name.substring(0, 1) != "_",
                "The first letter of name can't be '_'.");
        Preconditions.checkArgument(!name.contains("\u0001"),
                "name can't contain the character '\u0001'.");
        Preconditions.checkArgument(!name.contains("\u0002"),
                "name can't contain the character '\u0002'.");
    }
}
