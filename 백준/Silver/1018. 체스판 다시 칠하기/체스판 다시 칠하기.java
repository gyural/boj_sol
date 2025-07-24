import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);

		String[] input = sn.nextLine().split(" ");

		String startW= "WBWBWBWB";
		String startB= "BWBWBWBW";

		List<String> startWBoard = new ArrayList<>();
		for (int i=0; i<8; i++){
			if (i % 2 == 0){
				startWBoard.add(startW);
			} else{
				startWBoard.add(startB);
			}
		}

		List<String> startBBoard = new ArrayList<>();
		for (int i=0; i<8; i++){
			if (i % 2 == 1){
				startWBoard.add(startW);
			} else{
				startWBoard.add(startB);
			}
		}

		int y = Integer.parseInt(input[0]);
		int x = Integer.parseInt(input[1]);

		int result = 2100000000;

		List<String> board = new ArrayList<>();

		for (int i=0; i<y; i++){
			String line = sn.nextLine();

			board.add(line);

		}

		for (int startY=0; startY+8<=y; startY++){
			for (int startX=0; startX+8<=x; startX++){


				for (int bw = 0; bw < 2; bw++) {
					int count = 0;
					char firstChar = bw == 0 ? 'W' : 'B';

					for (int i = 0; i < 8; i++) {
						String line = "";

						char startChar = ' ';
						if (firstChar == 'W'){
							startChar = i % 2 == 0? 'W' : 'B';

						} else if (firstChar == 'B'){
							startChar = i % 2 == 0? 'B' : 'W';
						}

						for (int j = 0; j < 8; j++) {
							line += board.get(i + startY).charAt(j + startX);
						}

						count += getDiffLine(line, startChar);
					}

			 		result = Math.min(result, count);
				}

				}
			}
		System.out.println(result);
}
	public static int getDiffLine(String line, char start){
		int res = 0;

		for (int i=0; i<line.length(); i++){
			char curColor = line.charAt(i);

			if (i % 2 == 0){
				res = curColor != start? res+1 : res;
			} else{
				res = curColor == start? res+1 : res;
			}
		}

		return res;
	}
}
