import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
///Users/kirilllesniak/IdeaProjects_plugin/demo8/src/main/java/Plugin_1.java

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class Plugin_1 extends AnAction{
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {

        @Nullable Editor editor = event.getData(PlatformDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();
        String encoding = "";
        try {
            encoding = URLEncoder.encode(selectedText, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        Messages.showMessageDialog(encoding, "ActionPlugin", Messages.getInformationIcon());
        String url = String.format("https://www.google.ru/search?q=%s", encoding);
        BrowserUtil.browse(url);

        //https://www.google.com
        //https://www.google.ru/search?q=футбол .
    }
    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}