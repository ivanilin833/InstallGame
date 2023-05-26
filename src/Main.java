import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        List<File> dirList = new ArrayList<>();
        dirList.add(new File(Resource.path + "/src/main"));
        dirList.add(new File(Resource.path + "/src/test"));
        dirList.add(new File(Resource.path + "/savegames"));
        dirList.add(new File(Resource.path + "/temp"));
        dirList.add(new File(Resource.path + "/res/drawables"));
        dirList.add(new File(Resource.path + "/res/vectors"));
        dirList.add(new File(Resource.path + "/res/icons"));

        for (File file : dirList) {
            stringBuilder.append(file.mkdirs());
            stringBuilder.append("\n");
        }

        List<File> fileList = new ArrayList<>();
        fileList.add(new File(Resource.path + "/main/Main.java"));
        fileList.add(new File(Resource.path + "/main/Utils.java"));
        fileList.add(new File(Resource.path + "/temp/temp.txt"));

        for (File file : fileList) {
            try {
                stringBuilder.append(file.createNewFile());
                stringBuilder.append("\n");
            } catch (IOException e) {
                e.getMessage();
            }
        }

        try (FileWriter fw = new FileWriter(Resource.path + "/temp/temp.txt")){
            fw.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
