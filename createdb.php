<?php

// Server name must be localhost
$servername = "localhost";

// User name
$username = " ";

// Password
$password = " ";

// Creating a connection
$conn = new mysqli($servername,
			$username, $password);

// Check connection
if ($conn->connect_error) {
	die("Connection failure: "
		. $conn->connect_error);
}

// Creating a database named bookingsite
$sql = "CREATE DATABASE bookingsite";
if ($conn->query($sql) === TRUE) {
	echo "Database with name bookingsite";
} else {
	echo "Error: " . $conn->error;
}
$conn->close();
?>
