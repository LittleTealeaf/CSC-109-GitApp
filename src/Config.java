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

    }
}
