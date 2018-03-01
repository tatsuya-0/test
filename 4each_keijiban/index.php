<DOCTYPE html>
    <html lang="ja">
        <head>
            <meta charset="utf-8">
            <title>4each</title>
        <link rel="stylesheet"type="text/css" href="style2.css">
        </head>
        
    <body>
        <?php
mb_internal_encoding("utf8");
$pdo = new
    PDO("mysql:dbname=lesson01;host=localhost;","root","mysql");
        $stmt = $pdo->query("select*from 4each_keijiban");
            
       
        ?>
        
    <headr>
        <img class="logo" src="4eachblog_logo.jpg">
        <ul>
            <li>トップ</li>
            <li>プロフィール</li>
            <li>4eachについて</li>
            <li>登録フォーム</li>
            <li>問い合わせ</li>
            <li>その他</li>
        </ul>
    </headr>
        
        <main>
            
        <div class="contents">
            <h3>人気の記事</h3>
            <ul>
                <li>PHPオススメ本</li>
                <li>PHP MｙADminの使い方</li>
                <li>いま人気のエディタTop5</li>
                <li>HTMLの基礎</li>
            </ul>
            <h3>オススメリンク</h3>
            <ul>
                <li>インターノウス</li>
                <li>XAMPPのダウンロード</li>
                <li>Eclipseのダウンロード</li>
                <li>Braketsのダウンロード</li>
            </ul>
            <h3>カテゴリ</h3>
            <ul>
                <li>HTML</li>
                <li>PHP</li>
                <li>MySQL</li>
                <li>javaScript</li>
            </ul>
        </div>
            
            <h1 >プログラミングに役立つ掲示板</h1>  
            
            <form method="post" action="insert.php">
                <h2 class="title">入力フォーム</h2>
                <div class="ab">
                <label>ハンドルネーム</label><br>
                    <input type="text"class="text"name="handlename" size="30" ><br>
                <label>タイトル</label><br>
                <input type="text"class="text"name="title"size="30"><br>
                <label>コメント</label><br>
                <textarea name="comments" cols=40 rows=8></textarea>
                <br>
                <input class="submit1"type="submit" value="送信する">
                </div>
            </form>
          
<?php
            while ($row = $stmt-> fetch()){
            
    echo"<div class='kiji'>";
    echo"<h3>".$row['title']."</h3>";

    echo $row['comments'];
    echo " <div class='handlename'>posted by".$row['handlename']."</div>";
    echo "</div>";}
                
?>
            
  
       
        </main>
            
            <footr>
                <p>copyringht internous | 4each blog is the one which provides A to Z about progeamming.</p>
            </footr>
        </body>
    </html>
        