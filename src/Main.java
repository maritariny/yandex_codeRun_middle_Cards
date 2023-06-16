import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long a, b, c;
        String[] parts = reader.readLine().split(" ");
        a = Long.parseLong(parts[0]);
        b = Long.parseLong(parts[1]);
        c = Long.parseLong(parts[2]);
        long[] res = solve(n, a, b, c);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static long[] solve(int n, long a, long b, long c) {
        long sum = ((long) (1 + n) * n / 2) - a;
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigNplus1 = BigInteger.valueOf(n + 1);
        BigInteger nnplus1 = bigN.multiply(bigNplus1);
        BigInteger bb = BigInteger.valueOf((1 + 2L * n));
        BigInteger bigSum2 = nnplus1.multiply(bb).divide(BigInteger.valueOf(6));
        long sum2 = bigSum2.longValue() - b;
        BigInteger bigSum3 = bigN.multiply(bigN).multiply(bigNplus1).multiply(bigNplus1).divide(BigInteger.valueOf(4));
        long sum3 = bigSum3.longValue() - c;
        long x = 0, y = 0, z = 0;

        for (int i = 1; i <= n; i++) {
            double tempYDouble = (Math.pow(2 * sum2 - sum * sum + 2 * i * sum - 3L * i * i, 0.5) + sum - i) / 2;
            int tempY = (int) tempYDouble;
            long tempZLong = sum - i - tempY;
            int tempZ = (int) tempZLong;
            if (i + tempY + tempZ == sum && (long) i * i + (long) tempY * tempY + (long) tempZ * tempZ == sum2
            && (long) i * i * i + (long) tempY * tempY  * tempY + (long) tempZ * tempZ * tempZ == sum3) {
                x = i;
                y = tempY;
                z = tempZ;
            }
        }
        return new long[]{x, y, z};
    }
}