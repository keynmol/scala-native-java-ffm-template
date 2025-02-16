import java.io.*;
import java.lang.foreign.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import myscalalib_bindings.*;

public class Main {

	public static void main(String[] args) {
		Path dylibPath = null;
		try {
			dylibPath = Files.createTempDirectory("native-libs").resolve(dylibName);
			System.out.println("Loading " + dylibName);

			try (InputStream is = Main.class.getClassLoader().getResourceAsStream(dylibName)) {
				Files.copy(is, dylibPath);
			}

			System.load(dylibPath.toAbsolutePath().toString());

			// Run exported functions
			try (Arena arena = Arena.ofConfined()) {
				var config = myscalalib_config.allocate(arena);

				myscalalib_config.label(config, arena.allocateFrom("First test"));
				myscalalib_config.op(config, interface_h.ADD());
				interface_h.myscalalib_run(config, 25.0f, 150.0f);

				myscalalib_config.label(config, arena.allocateFrom("Second"));
				myscalalib_config.op(config, interface_h.MULTIPLY());
				interface_h.myscalalib_run(config, 50.0f, 10.0f);
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			System.exit(-1);
		} finally {
			if (dylibPath != null) {
				try {
					Files.delete(dylibPath);
				} catch (Exception e) {
					System.err.println(e);
					e.printStackTrace();
					System.exit(-1);
				}
			}
		}
	}

	// sic! this is sensitive to the name for the project used in the build
	private static String dylibName = "libscalanativeside." + dylibExtension();

	private static String dylibExtension() {
		String os = System.getProperty("os.name", "").toLowerCase();
		if (os.startsWith("mac os x") || os.startsWith("darwin"))
			return "dylib";
		return "so";
	}
}
