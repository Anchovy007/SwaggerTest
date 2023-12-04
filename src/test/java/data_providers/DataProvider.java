package data_providers;

import static petstore.swagger.instances.file_paths.Paths.*;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "Correct_statuses")
    public static Object[][] positiveStatusData() {
        return new Object[][] {
                {new String[] {"available"}},
                {new String[] {"pending"}},
                {new String[] {"sold"}}};
    }

    @org.testng.annotations.DataProvider(name = "Incorrect_id")
    public static Object[][] getIncorrectId() {
        return new Object[][]{
                {"asd"},
                {"213ddd"}};
    }

    @org.testng.annotations.DataProvider(name = "Incorrect_statuses")
    public static Object[][] getIncorrectStatuses() {
        return new Object[][]{
                {new String[] {"availabqele"}},
                {new String[] {"qqqqq"}},
                {new String[] {"12345"}},
                {new String[] {"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"}},
                {new String[] {"DROP TABLE"}},
                {new String[] {"https://yandex.ru/"}}};
    }

    @org.testng.annotations.DataProvider(name = "Path_to_files_to_add_images")
    public static Object[][] getPathsToFiles() {
        return new Object[][]{
                {TEXT_FILE_PATH},
                {DOC_FILE_PATH},
                {HTML_FILE_PATH}};
    }
}