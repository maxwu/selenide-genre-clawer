package me.maxwu.genre.app;

import me.maxwu.genre.IGenreCmd;
import me.maxwu.genre.htmlUnit.HtmlUnitBase;
import me.maxwu.genre.selenide.SelenideBase;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Configuration.screenshots;
import static me.maxwu.genre.GenreTerm.isDefaultGenreList;

/**
 * Created by maxwu on 3/15/17.
 */
public class App  {
    Map<Integer, Map<String, Object>> map;
    static IGenreCmd commander;
    static int size;

    public App(String clientOpt, int size) {
        if (clientOpt.equals("HTMLUNIT")){
            commander = new HtmlUnitBase();
        }else if (clientOpt.equals("SELENIDE")){
            screenshots = false;
            commander = new SelenideBase();
        }

        map = commander.getBillboardTop100Map(size);
        System.out.println("Got total " + map.size() + " songs");

        map.forEach((k, v) -> v.put("genres", commander.getSongGenres(v.get("song").toString(), v.get("artist").toString())));
    }

    private static void showHelpAndExit(int status){
        System.out.println("Please visit https://github.com/maxwu/Genre-Clawer for more information.");
        System.exit(status);
    }

    private static App parseCli(String[] args){
        Options options = new Options();
        options.addOption("h", false, "Show help and exit");
        options.addOption("c", true, "Sets client to HtmlUnit(default), Selenide or Jsoup");
        options.addOption("n", true, "Size of song list from Billboard Top100");
        CommandLineParser parser = new DefaultParser();
        CommandLine cli = null;
        // Default configurations:
        String clientOpt = "HTMLUNIT";
        int size = 10;

        try {
            cli = parser.parse(options, args);
            if(cli.hasOption("h")) {
                showHelpAndExit(0);
            }
            if(cli.hasOption("c")) {
                clientOpt = cli.getOptionValue("c").toUpperCase();
            }
            if(cli.hasOption("n")) {
                size = Integer.valueOf(cli.getOptionValue("n")).intValue();
            }
        }catch (Exception e){
            showHelpAndExit(-1);
        }

        return new App(clientOpt, size);
    }

    public static void main(String[] args){
        Map<Integer, Map<String, Object>> map = parseCli(args).map;
        System.out.println(new Yaml().dump(map));
        if (!map.isEmpty()) {
            System.out.printf("Success rate = %.2f%%\n",
                    map.values().stream()
                            .filter(v -> !isDefaultGenreList((List<String>)v.get("genres")))
                            .count() * 100.0f / map.size()
            );
        }
    }
}
