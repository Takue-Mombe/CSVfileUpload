$(document).ready(function () {
    // Fetch data from the Spring Boot API
    $.get("/api/get-all-users", function (data) {
        // Update the table with fetched data
        updateTable(data);
    });
});

function updateTable(data) {
    var tableBody = $("#userData tbody");

    // Clear existing table rows
    tableBody.empty();

    // Iterate through the data and append rows to the table
    data.forEach(function (user) {
        var row = $("<tr>");
        row.append($("<td>").text(user.id));
        row.append($("<td>").text(user.hitmail));
        row.append($("<td>").text(user.password));
        tableBody.append(row);
    });
}
