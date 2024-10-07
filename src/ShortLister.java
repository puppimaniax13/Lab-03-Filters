import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                List<String> shortWords;

                while(reader.ready()){
                    rec = reader.readLine();
                    shortWords = Arrays.asList(rec.split(","));
                    for (String shorts : shortWords) {
                        ShortWordFilter filter = new ShortWordFilter();
                        if(filter.accept(shorts)){
                            System.out.println(shorts);
                        }
                    }
                    System.out.println();
                }
                reader.close();
                System.out.println("\n ------- \n Data File Read.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
