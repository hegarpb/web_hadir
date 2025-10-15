package com.dikahadir.utils;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class InternetSpeedUtil {

    /**
     * Cek kecepatan internet.
     *
     * @param testUrl   URL file untuk test (misal: https://speed.hetzner.de/100MB.bin)
     * @param sampleMB  jumlah MB yang diunduh untuk sampling
     * @param minMbps   ambang batas minimal kecepatan
     * @return true jika speed >= minMbps, false jika gagal atau di bawah ambang
     */
    public static boolean isInternetFastEnough(double minMbps) {
        int sampleBytes = 10 * 1024 * 1024;

        try {
            long start = System.nanoTime();

            URL url = new URL("https://speed.cloudflare.com/__down?bytes=" + sampleBytes);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(7000);
            conn.setReadTimeout(7000);

            int totalRead = 0;
            byte[] buf = new byte[16 * 1024];
            try (InputStream in = conn.getInputStream()) {
                int n;
                while ((n = in.read(buf)) != -1 && totalRead < sampleBytes) {
                    totalRead += n;
                }
            }

            if (totalRead == 0) {
                return false; // tidak ada data
            }

            long end = System.nanoTime();
            double seconds = (end - start) / 1e9;
            double measuredMbps = (totalRead * 8.0 / 1_000_000) / seconds;

            System.out.printf("[UTIL] Speed: %.2f Mbps%n", measuredMbps);

            return measuredMbps >= minMbps;

        } catch (Exception e) {
            System.err.println("[UTIL] Error: " + e.getMessage());
            return false;
        }
    }
}
