<?php
require_once 'jpgraph.php';
require_once 'jpgraph_line.php';
require_once 'jpgraph_bar.php';
if (isset($_POST['submit'])) {
    $servername = "localhost";
    $username = "root";
    $password = "fjx";
    $dbname = "bioinfo_hw";
    $show = $_POST['show'];
    $entry = $_POST['entry'];
    $blastsequence = $_POST['blastsequence'];
    // 创建连接
    $conn = new mysqli($servername, $username, $password, $dbname);
    // 检测连接
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    // echo "Connected successfully!<br>";
    // 判断用户行为，若是search by entry则直接使用Post传递过来的全局变量$entry；
    // 若是search by blast则利用blast比对找出最佳匹配的entry，并将其赋值给全局变量$entry
    if ($show == "entry") {
        if ($entry == "") {
            echo "Please input entry!";
        }
    } else if ($show == "blast") {
        if ($blastsequence == "") {
            // 输入为空提示错误
            echo 'Please input blast sequence';
        } else {
            global $entry;
            // 把文本框中的字符串写进blastsequence.fa中
            file_put_contents("blastsequence.fa", "$blastsequence");
            // 使用blastp输出最佳比对的seq_id，并用sed来提取entry字符串，重新为变量$entry赋值，其中\\1需要两次转义。
            $entry = exec("blastp -query blastsequence.fa -db ./apoptosisdb/apoptosisdb -outfmt '7 sseqid' -max_target_seqs 5 | sed -n '6 p' | sed 's/.*|\(.*\)|.*/\\1/g'");
        }
    }
    // 利用变量$entry，查询数据库对应的Fold Change值
    $sql = "SELECT * FROM expression WHERE Entry='$entry'";
    $result = $conn->query($sql);
    $row = $result->fetch_assoc();
    $fc = $row["Fold_Change"];

    // 使用查询得到的Fold Change值做图
    $celltype = array('ESCs', 'EPSCs');
    $ydata = array(1, $fc);
    $width = 900;
    $height = 400;

    // Create a graph instance
    $graph = new Graph($width, $height);

    // Specify what scale we want to use,
    // int = integer scale for the X-axis
    // int = integer scale for the Y-axis
    $graph->SetScale('intint');

    // Setup a title for the graph
    $graph->title->Set('Differential Expression');

    // Setup titles and X-axis labels
    $graph->xaxis->title->Set('(cell type)');
    $graph->xaxis->SetTickLabels($celltype);
    // Setup Y-axis title
    $graph->yaxis->title->Set('(Fold Change)');

    // Create the linear plot
    // $lineplot=new LinePlot($ydata);
    $barplot = new BarPlot($ydata);
    // $lineplot->SetFillColor('orange@0.5');

    // Add the plot to the graph
    $graph->Add($barplot);

    // Display the graph
    $graph->Stroke();
}
