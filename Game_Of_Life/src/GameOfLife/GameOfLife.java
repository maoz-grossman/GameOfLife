package GameOfLife;



public class GameOfLife extends Thread {

	public static int firstGen(boolean[][] matt) {
		int creaturenum;
		int y;
		int x;
		// we limit the minimum/maximum  number of creature, and the values of x and y
		do { creaturenum=MyConsole.readInt("How many creatures would you like to start with?");
		if(creaturenum<=0||creaturenum>(matt.length*matt.length))
			System.out.println("Wrong value for the  number of creatures. Try again.");
		}
		while(creaturenum<=0||creaturenum>(matt.length*matt.length));
		for(int i=0;i<creaturenum;i++) {
			do {
				do {
					do {
						System.out.println("Creature number "+(i+1));
						x=MyConsole.readInt("Enter X value:");	
						if(x<=0||x>matt.length)
							System.out.println("Wrong X value for creature number "+(1+i)+". Try again.");
						// it checks if x is in in the range
					}while(x<=0||x>matt.length);
					y=MyConsole.readInt("Enter Y value:");
					if(y<=0||y>matt.length)
						System.out.println("Wrong Y value for creature number "+(1+i)+". Try again.");
					//it checks if y is in the range.
				}while(y<=0||y>matt.length);
				if(matt[y-1][x-1]==true)
					System.out.println("you already entered these values of x and y");}
			//it checks if we entered the same values twice. 
			while(matt[y-1][x-1]==true);
			matt[y-1][x-1]=true;
		}
		return creaturenum;
	}

	public static int numOfNeighbors(boolean[][] matt, int y, int x) {
		int numOfNeighbors=0;	
		//it checks  three cells of the array every time,from it's altitude to  it's longitude(9 cells),every time we call the function.
		for (int i=y-1;i<=y+1;i++) {
			//the loop goes as long as we don't pass the the length of the array
			if(i<matt.length&&i>=0)
				for(int j=x-1;j<=x+1;j++) {
					if(j<matt.length&&j>=0) {
						if(matt[i][j]==true) 
							//the number of true is the number of the living creature.
							numOfNeighbors++;
					}

				}
		}
		// it checks how many are living in a 9 cells,includes the x and y we chose ,but we want to know how many neighbors it has.
		if (matt[y][x]==true&&numOfNeighbors>0)
			numOfNeighbors--;
		return numOfNeighbors;
	}

	public static void printBoard(boolean[][] matt) {
		boolean[][]printMat;
		printMat=new boolean[matt.length+2][matt.length+2];



		for (int i=0;i<matt.length;i++) {
			for (int j=0;j<matt.length;j++) 
				printMat[i+1][j+1]=matt[i][j];
		}
		for (int i=0;i<printMat.length;i++) {
			if(i==0||i==printMat.length-1)
				System.out.print("   ");
			else if(i>0 && i<10)
				System.out.print(" "+i+" ");
			//because above ten we spend two tabs for a number, and we want to keep on the same space between the numbers.
			else if(i>=10 && i<printMat.length-1)
				System.out.print(" "+i);
		}
		System.out.println();	
		for (int i=0;i<printMat.length;i++) {
			for (int j=0;j<printMat.length;j++) {

				if(j==0 && i>=1 && i<10 && i<printMat.length-1)
					System.out.print(" "+i+"|");
				//Because when it's more then ten it moves the lines of the matrix.
				if(j==0 &&  i>=10 && i<printMat.length-1)
					System.out.print(i+"|");
				if(j==printMat.length-1 && i>=1 && i<printMat.length-1)
					System.out.print(" |");
				if(i==0 && j>0 && j!=printMat.length-1)
					System.out.print("---");
				// to start the first and the last line after'and before, the numbers or the"|" tab.
				if(i==0 && j==0 || j==printMat.length-1)
					System.out.print("   ");
				if(i<printMat.length-1 && printMat[i][j]==true)
					System.out.print(" * ");
				else if(i<printMat.length-1 && i>0 && j>0 && j<printMat.length-1 && printMat[i][j]!=true)
					System.out.print("   ");
				if(i==printMat.length-1 && j>0&&j!=printMat.length-1)
					System.out.print("---");
				if(i==printMat.length-1 && j==0 || j==printMat.length-1)
					System.out.print("   ");
			}
			if(i<printMat.length-1)
				System.out.println("");
		}
	}
	
	//it copies two matrixes 
	public static void copymatt(boolean[][]matt1,boolean[][]matt2) {
		for(int i=0;i<matt1.length;i++) {
			for(int j=0;j<matt1.length;j++)
				matt2[i][j]=matt1[i][j];
		}
	}



	public static int[] nextGen(boolean[][] matt) {
		boolean[][]matt2;
		// a temporary array that gets the newest information about the  current generation and informs the first array.
		matt2=new boolean[matt.length][matt.length];
		int[]nextgen;
		nextgen=new int[2];
		for(int i=1;i<matt.length-1;i++) {
			for(int j=1;j<matt.length-1;j++) {
				int newORlost=numOfNeighbors(matt,i,j);
				//if there is no living creature in the cell but it has 3 neighbors,it receives a creature.  
				if(matt[i][j]==false) {
					if(newORlost==3) {
						matt2[i][j]=true;
						// it means we have a new born.
						nextgen[0]++;}
				}
				if(matt[i][j]==true) {
					//if a creature has more than 3 or less than 2 neighbors it dies
					if(newORlost>3||newORlost<2) {
						//it means we have a new dead creature.
						nextgen[1]++;
						matt2[i][j]=false;
					}
					// it keeps  alive if it has 3 or 2 neighbors. 
					if((newORlost==3||newORlost==2))
						matt2[i][j]=true;	
				}	
			}
		}
		// it counts how many creature are living in sides of the matrix
		for (int i=0;i<matt.length;i+=matt.length-1) {
			for(int j=0;j<matt.length;j++) {
				if(matt[i][j]==true)
					nextgen[1]++;
				//j cannot be 0 or matt.length-1 because we already counted them in the first IF 
				if(matt[j][i]==true&&j!=0&&j!=matt.length-1)
					//the creature in the sides of the matrix should die.  
					nextgen[1]++;	


			}
		}
		//we move the information from the second array(matt2) to the first one(the parameter of the function) 	
		copymatt(matt2,matt);
		return nextgen;
	}

	public void run() {
		int MatrixSize,maxgen,creaturenum;
		//we limit the size of the matrix and the maximum number of generation to be more than 1
		do {  MatrixSize=MyConsole.readInt("Please enter the size of the matrix:");
		if(MatrixSize==1||MatrixSize<1)
			System.out.println("Wrong value for the the size of the matrix. Try again.");	
		}
		while(MatrixSize<=1);
		do {maxgen=MyConsole.readInt("Please enter the maximum number of generations: ");
		if(maxgen<0||maxgen==0)
			System.out.println("Wrong value for the maximum number of generations. Try again.");
		}
		while(maxgen<=0);
		boolean[][] arr;
		arr= new boolean [MatrixSize][MatrixSize];
		int k=firstGen(arr);
		System.out.println("\n");
		System.out.println("The game begins!");
		System.out.println("Generation number 1");
		printBoard(arr);
		System.out.println();
		System.out.println("The number of creatures in this generation is:"+k);
		System.out.println("The number of creatures born when moving to this generation is:"+k);
		System.out.println("The number of creatures died when moving to this generation is:"+0);
		System.out.println();
		try {
			sleep(1000);
		} catch (InterruptedException e) {
		}
		cleanscreen();
		// it means we arrived to the last generation although we didn't even  check anything.
		if (maxgen==1)
			System.out.println("Game over: we reached the maximum number of generation we wanted");
		for(int i=1;i<maxgen;i++) { 
			int nextgen[]= (nextGen(arr));
			k=(k+nextgen[0])-nextgen[1];
			System.out.println();
			System.out.println("Generation number "+(i+1));
			printBoard(arr);
			creaturenum= numofcreatures(arr);
			System.out.println();
			System.out.println("The number of creatures in this generation is:"+creaturenum);
			System.out.println("The number of creatures born when moving to this generation is:"+nextgen[0]);
			System.out.println("The number of creatures died when moving to this generation is:"+nextgen[1]);
			//if there are no creature on the matrix it means  they all died 
			try {
				sleep(700);
			} catch (InterruptedException e) {
			}
			cleanscreen();
			if(creaturenum==0) {
				System.out.println("Game over:there are no creatures on the metrix");
				break;}
			// if the values of The number of the dead or the born didn't change, it means the last generation is equals to the currant generation
			if(nextgen[0]==0&&nextgen[1]==0) {
				System.out.println("Game over: this generation equals to the previous one.");
				break;
			}
			//the last loop
			if(i==maxgen-1)
				System.out.println("Game over: we reached the maximum number of generation we wanted");
			System.out.println();
		}
	}
	//it checks how many creature on the matrix are living(how many true we have on the matrix) 
	public static int numofcreatures(boolean[][] matt) {
		int number=0;
		for(int i=0;i<matt.length;i++) {
			for(int j=0;j<matt.length;j++)
				if(matt[i][j]==true)
					number++;	
		}
		return number;
	}
	public void cleanscreen() {
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	public static void main(String[] args) {
		GameOfLife game= new GameOfLife();
		game.start();
	}
}
