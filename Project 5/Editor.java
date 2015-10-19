import java.util.*;
import java.io.*;
import java.awt.Color;

public class Editor 
{

	/**
	 * main method - the selection process takes place here 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("What picture would you like to edit? ");		//prompts the user to choose what file to edit
		Picture picture = new Picture(in.next());
		boolean quit = false;

		while(!quit)	//loop that keeps running until the user quits
		{
			System.out.print("Operations\n1. Grow\n2. Grayscale\n3. Invert\n4. Rotate Left\n5. Median Filter\n6. Display\n7. Quit\nEnter command: ");	//prompts the user to choose what to do
			int action = in.nextInt();
			System.out.println();

			switch(action)
			{
			case 1: 
				picture = grow(picture);
				break;
			case 2:
				picture = grayscale(picture);
				break;
			case 3:
				picture = invert(picture);							//switch statement that decides what to do based on the users choice
				break;	
			case 4: 
				picture = rotateLeft(picture);
				break;
			case 5:
				picture = medianFilter(picture);
				break;
			case 6: 
				picture.show();
				break;

			case 7: quit = true;
			}
		}

	}
	/**
	 * 
	 * @param picture - the most updated version of the file read in originally
	 * @return bigPicture - a version of picture twice as large as the one read in
	 */
	public static Picture grow(Picture picture)
	{
		Picture bigPicture = new Picture(picture.width() * 2, picture.height() * 2);

		int x = 0;
		int y = 0;

		for(int i = 0; i < picture.width() ; i++)
		{	
			for(int j = 0; j < picture.height() ; j++)
			{
				Color value = picture.get(i, j);
				
				bigPicture.set(x,y,value);
				bigPicture.set(x+1,y,value);						//sets the four pixels to the color value of the one original
				bigPicture.set(x,y+1,value);
				bigPicture.set(x+1,y+1,value);

				y+=2;
			}
			x+=2;
			y = 0;
		}
		return bigPicture;
	}
	/**
	 * 
	 * @param picture  - the most updated version of the file read in originally
	 * @return grayPicture - the grayscale version of picture
	 */
	public static Picture grayscale(Picture picture)
	{
		Picture grayPicture = new Picture(picture.width(), picture.height());

		for(int i = 0 ; i < grayPicture.width() ; i++)
			for(int j = 0 ; j < grayPicture.height() ; j++)
			{
				Color value = picture.get(i, j);

				int gray = (int) (value.getRed() * 0.3 + 0.5) + (int) (value.getGreen() * 0.59 + 0.5) + (int) (value.getBlue() * 0.11 + 0.5) ;	//creates a color that is the provided amount of the original value, rounded to the nearest whole int

				Color grayscale = new Color(gray, gray, gray);
				grayPicture.set(i,j,grayscale);

			} 

		return grayPicture;
	}
	/**
	 * 
	 * @param picture - the most updated version of the file read in originally
	 * @return invertedPicture - the inverted version of picture
	 */
	public static Picture invert(Picture picture)
	{
		Picture invertedPicture = new Picture(picture.width(), picture.height());

		for(int i = 0 ; i < invertedPicture.width() ; i++)
			for(int j = 0 ; j < invertedPicture.height() ; j++)
			{
				Color value = picture.get(i, j);

				int red = (int) (255 - value.getRed());
				int green = (int) (255 - value.getGreen());		//creates a color that is 255 minus the original color value which inverts the color
				int blue = (int) (255 - value.getBlue());

				Color inverted = new Color(red, green, blue);
				invertedPicture.set(i,j,inverted);
			}

		return invertedPicture;
	}
	/**
	 * 
	 * @param picture - the most updated version of the file read in originally
	 * @return rotatedPicture - the rotated version of picture
	 */
	public static Picture rotateLeft(Picture picture)
	{
		Picture rotatedPicture = new Picture(picture.height(), picture.width());

		for(int row = 0 ; row < picture.width() ; row++)
			for(int coll = 0 ; coll < picture.height() ; coll++)
			{
				rotatedPicture.set(coll,picture.width() - 1 - row, picture.get(row, coll));		//rotates the picture
			}

		return rotatedPicture;
	}

	public static Picture medianFilter(Picture picture)
	{
		Picture medianPicture = new Picture(picture.width(), picture.height());
		
		int count = 0;

		for(int i = 1 ; i < medianPicture.width() - 1 ; i++)
			for(int j = 1 ; j < medianPicture.height() - 1 ; j++)
			{
				int[] red = new int[9];
				int[] green = new int[9];
				int[] blue = new int[9];

				for(int x = -1 ; x < 2 ; x++)					//loops through the 3x3 grid around the pixel
					for(int y = -1 ; y < 2 ; y++)
					{
						Color median = picture.get(i + x , j + y);

						red[count] = median.getRed();
						green[count] = median.getGreen();				//stores the color value of the pixels in the arrays
						blue[count] = median.getBlue();


						count++;
					}
				
				count = 0;
				
				sort(red);
				sort(green);			//sorts the arrays
				sort(blue);
			
				Color filtered = new Color(red[4], green[4], blue[4]);		//sets the new color value to the median of the color values of the 3x3 grid
				
			medianPicture.set(i,j, filtered);
			
			}

		return medianPicture;
	}

	/**
	 * 
	 * @param array sorts the array of color values using a selection sort
	 */
	public static void sort(int[] array)
	{
		for(int i = 0 ; i < array.length ; i++)
		{
			int smaller = i;
			int temp = 0;
			for(int j = i + 1 ; j < array.length ; j++ )
			{
				if(array[j] < array[smaller])
					smaller = j;

			}

			temp = array[i];
			array[i] = array[smaller];
			array[smaller] = temp;
		}

	}

}
