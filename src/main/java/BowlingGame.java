public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        int totalScore = 0;
        for (int i = 0; i < bowlingCode.length(); i++){
            if (bowlingCode.charAt(i) == '|' && bowlingCode.charAt(i+1) == '|') {
                break;
            }
            if (bowlingCode.charAt(i) == '|') {
                continue;
            }
            char score = bowlingCode.charAt(i);
            if (score == 'X') {
                totalScore += 10;
                int add = 0;
                int count = 0;
                int index = i;
                while (count < 2) {
                    char temp = bowlingCode.charAt(++index);
                    if (temp != '|'){
                        if (temp == 'X') {
                            add += 10;
                            count++;
                            continue;
                        }
                        if (temp == '/') {
                            add = 10;
                            count++;
                            continue;
                        }
                        if (temp == '-') {
                            count++;
                            continue;
                        } else {
                            add += temp - '0';
                            count++;
                            continue;
                        }
                    }
                }
                totalScore += add;
                continue;
            }
            if (score == '/') {
                int pre = bowlingCode.charAt(i - 1) - '0';
                totalScore = totalScore - pre + 10;
                int add = 0;
                int count = 0;
                int index = i;
                while (count < 1) {
                    char temp = bowlingCode.charAt(++index);
                    if (temp != '|'){
                        if (temp == 'X') {
                            add += 10;
                            count++;
                            continue;
                        }
                        if (temp == '-') {
                            count++;
                            continue;
                        } else {
                            add += temp - '0';
                            count++;
                            continue;
                        }
                    }
                }
                totalScore += add;
                continue;
            }
            if (score == '-') {
                continue;
            }
            else {
                totalScore += score - '0';
                continue;
            }
        }

        return totalScore;
    }


}
