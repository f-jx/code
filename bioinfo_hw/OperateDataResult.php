<?php
if (isset($_POST['submit'])) {
    $servername = "localhost";
    $username = "root";
    $password = "fjx";
    $dbname = "bioinfo_hw";
    $operation = $_POST['operation'];
    $tablename = $_POST['tablename'];
    $columntext = $_POST['columntext'];
    $inserttext = $_POST['inserttext'];
    $attr_condition = $_POST['attr_condition'];
    $attr_updatetext = $_POST['attr_updatetext'];
    $blastsequence = $_POST['blastsequence'];
    // 创建连接
    $conn = new mysqli($servername, $username, $password, $dbname);
    // 检测连接
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    echo "Connected successfully!<br>";
    //判断用户行为
    if ($operation == 'browse') {
        if ($tablename == '') {
            echo "Please input tablename";
        } else {
            $sql = "SELECT * FROM $tablename";
            $result = $conn->query($sql);
            if ($result) {
                // fetch_assoc()返回每一行作为关联数组，嵌套的while循环遍历关联数组中的每个键值对
                while ($row = $result->fetch_assoc()) {
                    echo "<br><br><table border='1' align='center' style='word-break:break-all; max-width:80%;'>";
                    while ($b = each($row)) {
                        echo "<tr>
                        <td width=15%>" . $b['key'] . ": </td>
                        <td>" . $b['value'] . "</td>
                        </tr>";
                    }
                    echo "</table>";
                }
            } else {
                echo "0 results";
            }
        }
    } elseif ($operation == 'create') {
        if (($tablename == '') || ($columntext == '')) {
            echo 'Please input tablename and column!';
        } else {
            global $tablename, $columntext;
            echo "($columntext)<br>";
            $sql = "create table $tablename ($columntext)";
            if ($conn->query($sql) === true) {
                echo "New table created successfully";
            } else {
                echo "Sorry, Error: " . $sql . "<br>" . $conn->error;
            }
        }
    } elseif ($operation == 'insert') {
        if (($tablename == "") || ($inserttext == '')) {
            //输入为空提示错误
            echo 'Please input tablename and insert content';
        } else {
            //声明全局变量
            global $tablename, $inserttext;
            //定义mysql插入语句
            $sql = "insert into $tablename values ($inserttext)";
            if ($conn->query($sql) === true) {
                //提示insert成功
                echo "New record created successfully";
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
        }
    } elseif ($operation == 'search') {
        if ($tablename == '' || $attr_condition == '') {
            echo "Please input TableName and condition!";
        } else {
            global $tablename, $attr_condition;
            //定义Mysql语句变量
            $sql = "SELECT * FROM $tablename WHERE $attr_condition";
            $result = $conn->query($sql);
            if ($result) {
                // fetch_assoc()返回每一行作为关联数组，嵌套的while循环遍历关联数组中的每个键值对
                while ($row = $result->fetch_assoc()) {
                    echo "<br><br><table border='1' align='center' style='word-break:break-all; max-width:80%;'>";
                    while ($b = each($row)) {
                        echo "<tr>
                        <td width=15%>" . $b['key'] . ": </td>
                        <td>" . $b['value'] . "</td>
                        </tr>";
                    }
                    echo "</table>";
                }
            } else {
                echo "0 results";
            }
        }
    } elseif ($operation == 'delete') {
        if ($tablename == '' || $attr_condition == '') {
            echo "Please input TableName and condition!";
        } else {
            global $tablename, $attr_condition;
            //定义Mysql语句变量
            $sql = "DELETE FROM $tablename WHERE $attr_condition";
            if ($conn->query($sql) === true) {
                //提示update成功
                echo "Data delete successfully";
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
        }
    } elseif ($operation == 'update') {
        if (($tablename == '') || ($attr_condition == '') || ($attr_updatetext == '')) {
            //输入为空提示错误
            echo 'Please input TableName, condition and update content!';
        } else {
            global $tablename, $attr_condition, $attr_updatetext;
            //定义mysql更新语句
            $sql = "update $tablename set $attr_updatetext where $attr_condition";
            if ($conn->query($sql) === true) {
                //提示update成功
                echo "Data update successfully";
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
        }
    } elseif ($operation == 'blast') {
        if (($tablename == "") || ($blastsequence == "")) {
            //输入为空提示错误
            echo 'Please input tablename and blast sequence';
        } else {
            //把文本框中的字符串写进blastsequence.fa中
            file_put_contents("blastsequence.fa", "$blastsequence");
            passthru('blastp -query blastsequence.fa -db ./apoptosisdb/apoptosisdb -html -evalue 1 -num_descriptions 10 -num_alignments 10');
        }
    }
    $conn->close();
}
