package pl.lodz.zzpj.statj.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import pl.lodz.zzpj.statj.model.Statistic;
import pl.lodz.zzpj.statj.service.StatisticService;

import java.util.Objects;

public class StatisticAction extends AnAction
{
    private final StatisticService service = new StatisticService();

    @Override
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        Project project = Objects.requireNonNull(e.getProject());
        service.setProject(project);

        String stats = statisticToString(service.getStatistic());
        Messages.showMessageDialog(project, stats, "Statistics", null);
    }

    private String statisticToString(Statistic statistic)
    {
        return "Methods: " + statistic.getMethods();
    }
}
