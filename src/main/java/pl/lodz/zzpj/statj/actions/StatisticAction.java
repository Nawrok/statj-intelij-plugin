package pl.lodz.zzpj.statj.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import pl.lodz.zzpj.statj.AppBundle;
import pl.lodz.zzpj.statj.model.Statistic;
import pl.lodz.zzpj.statj.service.StatisticService;

import java.util.Objects;

public class StatisticAction extends AnAction {
    private final StatisticService service = new StatisticService();

    @Override
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        Project project = Objects.requireNonNull(e.getProject());
        service.setProject(project);

        String stats = statisticToString(service.getStatistic());
        Messages.showMessageDialog(project, stats, AppBundle.INSTANCE.getMessage("statistics"), null);
    }

    private String statisticToString(Statistic statistic)
    {
        return String.format("%-9s%-15s\n", AppBundle.INSTANCE.getMessage("value"),
                AppBundle.INSTANCE.getMessage("stats_name")) + "-".repeat(17) + '\n' +
                String.format("%-12s%-15s\n", statistic.getClasses(), AppBundle.INSTANCE.getMessage("classes")) +
                String.format("%-12s%-15s\n", statistic.getMethods(), AppBundle.INSTANCE.getMessage("methods")) +
                String.format("%-12s%-15s\n", statistic.getFields(), AppBundle.INSTANCE.getMessage("fields"));
    }
}
