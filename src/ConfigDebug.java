import java.io.File;
import java.nio.file.Files;

public class ConfigDebug {

    public static void main(String[] args) {
        Config config = new Config();

        try {
            config.apiToken = Files.readAllLines(new File("github_token").toPath()).get(0);
            config.repoPath = "test";

            config.process();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
