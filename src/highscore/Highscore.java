package highscore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Highscore {
	
	public static List<String> getHighscore() {
		try {
			return Files.readAllLines(Paths.get("highscore.data"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void addToHighScore(String playerName){
		try {
			List<String> lines = Files.readAllLines(Paths.get("highscore.data"));
			HighscorePair[] pairs = new HighscorePair[lines.size()];
			boolean playerFound = false;
			for(int i = 0; i < lines.size(); i++){					
				String[] temp = lines.get(i).split(","); 
				int score = Integer.parseInt(temp[1]);
				playerFound = temp[0].equals(playerName);
				if(playerFound){					
					score++;
				}
				pairs[i] = new HighscorePair(temp[0], score);
			}
			
			Arrays.sort(pairs);
			String s = "";
			for(HighscorePair hP : pairs){
				s += hP.getName()  + "," + hP.getScore() + "\n";
			}
			if(!playerFound){
				s += playerName  + "," + 1 + "\n";
			}
			Files.write(Paths.get("highscore.data"), s.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
