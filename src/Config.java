import java.io.FileWriter;
import java.nio.file.Paths;
import java.nio.file.Path;

import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
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

        //Creates the README
        writeFile("README.md",new String[] {
            "# " + repoName
        });

        //Creates the .gitignore
        writeFile(".gitignore",new String[] {
            "out/",".vscode",".idea","*.class","*.log","*.jar"
        });

        gitClient.gitInit();
        gitClient.gitAddAll();
        gitClient.gitCommit("initial commit");

        //Creates the repository
        GitHubApiClient apiClient = new GitHubApiClient(githubUsername, apiToken);
        RequestParams createRepoParams = new RequestParams();
        createRepoParams.addParam("name", repoName);
        createRepoParams.addParam("private", isPrivate);
        createRepoParams.addParam("description", description);
        CreateRepoResponse response = apiClient.createRepo(createRepoParams);

        //Adds to the remote
        gitClient.gitRemoteAdd("origin", response.getUrl());
        gitClient.gitPush(gitClient.getCurrentBranchName());
    }

    /**
     * Writes a file into the directory
     * @param fileName The file name to write into the directory
     * @param lines Array of string lines to write into the file
     */
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
