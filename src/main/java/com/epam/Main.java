package com.epam;

import com.epam.fabric.NoteFabric;

public class Main {
    public static void main(String[] args) {
        NoteFabric fabric = new NoteFabric();

        fabric.create();
        fabric.print();

        fabric.printNotesRelToCat();
    }
}
