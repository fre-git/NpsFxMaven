package com.fre.npsfxmaven.model;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public interface IReaderAndWriter {
    File readFile(String filePath);
    Set<Storable>  processFile(String fileString);
    String saveFile(Collection<Storable> treeSet, String pathName) throws IOException;
    String saveFileAs(Collection<Storable> treeSet) throws IOException;
}
