package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String cur = st.nextToken();
        int kx = cur.charAt(0) - 64, ky = Character.getNumericValue(cur.charAt(1));
        cur = st.nextToken();
        int sx = cur.charAt(0) - 64, sy = Character.getNumericValue(cur.charAt(1));

        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            cur = br.readLine();

            switch (cur) {
                case "R":
                    if (kx < 8) {
                        kx++;
                        if (kx == sx && ky == sy) {
                            if (sx < 8) sx++;
                            else kx--;
                        }
                    }
                    break;
                case "L":
                    if (kx > 1) {
                        kx--;
                        if (kx == sx && ky == sy) {
                            if (sx > 1) sx--;
                            else kx++;
                        }
                    }
                    break;
                case "B":
                    if (ky > 1) {
                        ky--;
                        if (kx == sx && ky == sy) {
                            if (sy > 1) sy--;
                            else ky++;
                        }
                    }
                    break;
                case "T":
                    if (ky < 8) {
                        ky++;
                        if (kx == sx && ky == sy) {
                            if (sy < 8) sy++;
                            else ky--;
                        }
                    }
                    break;
                case "RT":
                    if (kx < 8 && ky < 8) {
                        kx++;
                        ky++;
                        if (kx == sx && ky == sy) {
                            if (sx < 8 && sy < 8) {
                                sx++;
                                sy++;
                            }
                            else {
                                kx--;
                                ky--;
                            }
                        }
                    }
                    break;
                case "LT":
                    if (kx > 1 && ky < 8) {
                        kx--;
                        ky++;
                        if (kx == sx && ky == sy) {
                            if (sx > 1 && sy < 8) {
                                sx--;
                                sy++;
                            }
                            else {
                                kx++;
                                ky--;
                            }
                        }
                    }
                    break;
                case "RB":
                    if (kx < 8 && ky > 1) {
                        kx++;
                        ky--;
                        if (kx == sx && ky == sy) {
                            if (sx < 8 && sy > 1) {
                                sx++;
                                sy--;
                            }
                            else {
                                kx--;
                                ky++;
                            }
                        }
                    }
                    break;
                case "LB":
                    if (kx > 1 && ky > 1) {
                        kx--;
                        ky--;
                        if (kx == sx && ky == sy) {
                            if (sx > 1 && sy > 1) {
                                sx--;
                                sy--;
                            }
                            else {
                                kx++;
                                ky++;
                            }
                        }
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char)(kx + 64)).append(ky).append("\n")
                .append((char)(sx + 64)).append(sy);

        System.out.println(sb);
    }
}
