package com.mateusz.view;

import java.io.IOException;

public interface IView {
    public void view() throws IOException;
    public String getDate(String code);
}
