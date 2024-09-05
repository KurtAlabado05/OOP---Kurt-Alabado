<?php
$a = 23; 
$b = 24; 
$c = 8; 

if ($a >= $b && $a >= $c) {
    $max = $a;
} elseif ($b >= $a && $b >= $c) {
    $max = $b;
} else {
    $max = $c;
}

echo "Maximum number is: $max";
?>