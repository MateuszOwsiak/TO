package com.mateusz.decoders;

import java.io.IOException;
import java.util.List;

public interface IDecoder {
    public List<String> split(String code);
    public void decode(String code) throws IOException;
}
