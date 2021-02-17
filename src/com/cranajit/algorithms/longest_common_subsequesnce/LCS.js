const LCS = (x, y, m, n) => {
    if( m == 0 || n == 0) {
        return 0;
    }

    if(x[n-1] == y[m-1]) {
        return 1 + LCS(x, y, n-1, m-1)
    } else {
        return Math.max(LCS(x, y, n, m-1), LCS(x, y, n-1, m))
    }
}

console.log(LCS('arbdcgje', 'asbzccf', 5, 5));
