<?php
function isPrime($n) {
    if ($n <= 1) {
        return false;
    }
    for ($i = 2; $i <= sqrt($n); $i++) {
        if ($n % $i == 0) {
            return false;
        }
    }
    return true;
}

$n = 2; 
if (isPrime($n)) {
    echo "$n is a prime number";
} else {
    echo "$n is not a prime number";
}
?>