package com.cvhau.javaexample.stackwalker;

import com.cvhau.javaexample.stackwalker.sub.SubWalker;

public class Walker {
    private final SubWalker subWalker;

    public Walker() {
        subWalker = new SubWalker();
    }

    public SubWalker getSubWalker() {
        return subWalker;
    }
}
