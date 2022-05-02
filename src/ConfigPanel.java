import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class ConfigPanel extends JPanel {
    private App app;
    
    private TextBox apiToken;
    private TextBox githubUsername;
    private TextBox repoPath;
    private TextBox repoName;
    private TextBox description;
    private JCheckBox isPrivate;

    public ConfigPanel(App app) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.app = app;
        this.add(this.apiToken = new TextBox("GitHub API Token:"));
        this.add(this.githubUsername = new TextBox("GitHub Username:"));
        this.add(this.repoPath = new TextBox("Repository path:"));
        this.add(this.repoName = new TextBox("Repository name:"));
        this.add(this.description = new TextBox("Repository description:"));
        this.add(this.isPrivate = new JCheckBox("Make private repository"));
    }

    public void updateConfig() {
        this.app.config.apiToken = this.apiToken.getInput();
        this.app.config.githubUsername = this.githubUsername.getInput();
        this.app.config.repoPath = this.repoPath.getInput();
        this.app.config.repoName = this.repoName.getInput();
        this.app.config.description = this.description.getInput();
        this.app.config.isPrivate = this.isPrivate.isSelected();
    }
}
