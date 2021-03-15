package pl.lodz.zzpj.statj.service;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import pl.lodz.zzpj.statj.model.Statistic;

public class StatisticService
{
    private Project project;

    public Statistic getStatistic()
    {
        Statistic statistic = new Statistic();

        FileTypeIndex.processFiles(JavaFileType.INSTANCE,
                virtualFile ->
                {
                    statistic.setClasses(statistic.getClasses() + 1);

                    PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
                    if (psiFile == null)
                    {
                        return false;
                    }

                    psiFile.accept(new JavaRecursiveElementVisitor()
                    {
                        @Override
                        public void visitField(PsiField field)
                        {
                            super.visitField(field);
                            statistic.setFields(statistic.getFields() + 1);
                        }

                        @Override
                        public void visitMethod(PsiMethod method)
                        {
                            super.visitMethod(method);
                            statistic.setMethods(statistic.getMethods() + 1);
                        }
                    });

                    return true;
                },
                GlobalSearchScope.projectScope(project));

        return statistic;
    }

    public void setProject(Project project)
    {
        this.project = project;
    }
}
