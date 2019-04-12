<?php session_start();
//Login
//Created on:190315
//Created by:jason
//Modified on:190315
//Modified by:jason
if (isset($_POST['submit'])) {
    $username = $_POST['user'];
    $password = $_POST['psswd'];
    if ($username != 'jason') {
        print "<font color=red>Oohps, your user name is NOT correct!</font><BR><BR>";
    } elseif ($password != 'jason') {
        print "<font color = red>Oohps, your password is NOT correct!</font><BR><BR>";
    } else {
        $_SESSION["username"] = $username;
        $_SESSION["password"] = $password;
        echo "<fieldset>Hello " . $_SESSION["username"] . "!<br><br><a href='MyWebsite.php'>Here is my website!</a></fieldset>";
    }
}
