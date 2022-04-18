import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.nio.file.Path;

import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;

public class Config {
    String apiToken;
    String githubUsername;
    String repoPath;
    String repoName;
    String description;
    boolean isPrivate;

    public Config() {

    }

    public void process() {
        GitSubprocessClient gitClient = new GitSubprocessClient(repoPath);

        writeFile("README.md",new String[] {
            "# " + repoName
        });
        writeFile(".gitignore",new String[] {
            "out/",".vscode",".idea","*.class","*.log","*.jar"
        });

        gitClient.gitInit();
    }

    public void writeFile(String fileName, String[] lines) {
        Path filePath = Paths.get(repoPath,fileName);
        try {
            FileWriter writer = new FileWriter(filePath.toFile().getPath());
            for(String line : lines) {
                writer.write(line);
                writer.write('\n');
            }
            writer.close();
        } catch(Exception e) {}
    }
}
