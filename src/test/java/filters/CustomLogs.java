package filters;

import io.qameta.allure.restassured.AllureRestAssured;

public class CustomLogs {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private CustomLogs() {
    }

    public AllureRestAssured customTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }

    public static CustomLogs customLogs() {
        return InitLogs.logs;
    }

    private static class InitLogs {
        private static final CustomLogs logs = new CustomLogs();
    }
}
