package com.mateusz;

import com.mateusz.view.IView;
import com.mateusz.view.View;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        IView view = new View();
        view.view();
    }
}
