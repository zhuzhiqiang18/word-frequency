package com.I9lou.es.uitl;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class PathUtils {
    static final FileSystem ACTUAL_DEFAULT = FileSystems.getDefault();
    static volatile FileSystem DEFAULT;

    private PathUtils() {
    }

    public static Path get(String first, String... more) {
        return DEFAULT.getPath(first, more);
    }

    public static Path get(URI uri) {
        return uri.getScheme().equalsIgnoreCase("file") ? DEFAULT.provider().getPath(uri) : Paths.get(uri);
    }

    public static Path get(Path[] roots, String path) {
        Path[] var2 = roots;
        int var3 = roots.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Path root = var2[var4];
            Path normalizedRoot = root.normalize();
            Path normalizedPath = normalizedRoot.resolve(path).normalize();
            if (normalizedPath.startsWith(normalizedRoot)) {
                return normalizedPath;
            }
        }

        return null;
    }

    public static Path get(Path[] roots, URI uri) {
        return get(roots, get(uri).normalize().toString());
    }

    public static FileSystem getDefaultFileSystem() {
        return DEFAULT;
    }

    static {
        DEFAULT = ACTUAL_DEFAULT;
    }
}
