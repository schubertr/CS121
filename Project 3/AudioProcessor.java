import java.util.Scanner;

public class AudioProcessor {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter wav file name: ");							//asks you what file you want to edit
		
		double[] sample = StdAudio.read(in.next());							//stores the .wav file data into an array of doubles called "sample
		
		boolean quit = false;												//creates a boolean entitled "quit" that by default is set as false
		
		int j = sample.length - 1;											//creates int j for reversing
	
		while(!quit)														//while loop that will keep running until user sets the boolean "quit" to true by entering 'q'
		{
			System.out.print("Select command (p, r, s, n, v, o, q): ");     //select command
			String actionString = in.next();							    //store command in a string
			
			char action = actionString.charAt(0);							//convert string to character
			
			switch(action)													//switch on the character "action"
			{
			case 'p': {
				System.out.println("Playing sound");						//tells you it is playing
			
				StdAudio.play(sample);										//plays the sound
						break;
			}
			
			case 'r':{
				
			System.out.println("Reversing sound");							//tells you it is reversing
			
			double[] newSample = new double [sample.length];				//creates a new array to temporarily hold the reversed array
			
			for(int i = 0 ; i < sample.length ; i++, j--)					//for loop that reverses sample and stores in in newSample
						{
							newSample[j] = sample[i];
						}
							sample = newSample;								//replaces the original array with the reversed one
							
							break;
			}
			case 's': {
			
				System.out.print("Speed up by how much? " );				//asks you for a double (how much to speed up by)
						double speed = in.nextDouble();

						double[] newSample = new double [(int) (sample.length/speed)];			//creates an array that is the size of the original array divided by the factor you want to speed it up by
					  
						System.out.println("Speeding up sound");			//tells you it is speeding up the sound
						
						for(int i = 0 ; i < newSample.length; i++)			//for loop that speeds up the sample
						{
					
								newSample[i] = sample[(int) (i * speed)];
						}
						sample = newSample;									//replaces the original array with the new one
				
			}
			
			break;
				
			case 'n':
				System.out.print("Add how much noise? ");					//asks you how much noise you want to add
				double noise = in.nextDouble();
				
				System.out.println("Adding noise");							//tells you it is adding noise
				
				for ( int i = 0; i < sample.length; i++ ) 					//for loop that adds noise
				
				{
				sample[i] += noise;
				
				if ( sample[i] > 1 )									//if statement that makes sure no value is less than -1 or greater than 1
					sample[i] = 1; 
					else if ( sample[i] < -1)								
						sample[i] = -1;
				}				
				break;
				
			case 'v':
				
				System.out.print("Scale volume by how much? ");			//asks you for a factor to scale the volume by
				
				double volume = in.nextDouble();
				
				System.out.println("Scaling volume");						//tells you it is scaling the volume
				
				for ( int i = 0; i < sample.length; i++ ) 				//for loop that scales the volume
				
				{
				
				sample[i] *= volume;
				
				
				if ( sample[i] > 1 )						//if statement that makes sure no value is less than -1 or greater than 1

					sample[i] = 1; 
				else if ( sample[i] < -1)
					sample[i] = -1;
				}
				
				break;
				
			case 'o':
				
				System.out.print("Save to what file name? ");			//asks you for a name to call the new file
				String newFileName = in.next();
				
				StdAudio.save(newFileName, sample);						//saves the new file
				
				break;
				
			case 'q': quit = true; 								//quits the program when 'q' is entered
			
			break;
			}
			
			
			
		}

	}

}
