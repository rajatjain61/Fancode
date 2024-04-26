package com.fancode.automation;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FanCodeTaskAutomation {

    @Test
    public void testCompletedTaskPercentage() {
        // Base URL of the API
        String baseURL = "http://jsonplaceholder.typicode.com";

        // Retrieve users
        Response userResponse = given().get(baseURL + "/users");
        Assert.assertEquals(userResponse.getStatusCode(), 200, "Failed to fetch users");
        JsonPath userJson = userResponse.jsonPath();

        // Iterate over each user
        for (int i = 0; i < userJson.getList("id").size(); i++) {
            int userId = userJson.getInt("id[" + i + "]");
            float lat = Float.parseFloat(userJson.getString("address.geo.lat[" + i + "]"));
            float lng = Float.parseFloat(userJson.getString("address.geo.lng[" + i + "]"));

            // Check if user belongs to FanCode city
            if (lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100) {
                // Retrieve todos for the user
                Response todosResponse = given().get(baseURL + "/todos?userId=" + userId);
                Assert.assertEquals(todosResponse.getStatusCode(), 200, "Failed to fetch todos for user " + userId);
                JsonPath todosJson = todosResponse.jsonPath();

                // Calculate completed task percentage
                int totalTasks = todosJson.getList("id").size();
                int completedTasks = todosJson.getList("completed").stream().filter(c -> (Boolean) c).toList().size();
                float completedPercentage = (completedTasks * 100.0f) / totalTasks;

                // Assert completed task percentage is greater than 50%
                Assert.assertTrue(completedPercentage > 50,
                        "User " + userId + " has less than 50% completed tasks (" + completedPercentage + "%)");
            }
        }
    }
}
