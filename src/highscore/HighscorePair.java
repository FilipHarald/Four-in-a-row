package highscore;

public class HighscorePair implements Comparable<HighscorePair>{
		private String name;
		private int score;
		
		public HighscorePair(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}

		@Override
		public int compareTo(HighscorePair pair) {
			return (this.getScore() < pair.getScore() ? 1 : -1);
		}
		
	}
