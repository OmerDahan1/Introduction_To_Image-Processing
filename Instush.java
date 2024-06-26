import java.awt.Color;

/**
 * A library of image processing functions.
 */
public class Instush {

	public static void main(String[] args) {
	    // Can be used for testing, as needed.
	}

	/**
	 * Returns an image created from a given PPM file.
	 * SIDE EFFECT: Sets standard input to the given file.
	 * @return the image, as a 2D array of Color values
	 */
	public static Color[][] read(String filename) {
		StdIn.setInput(filename);
		// Reads the PPM file header (ignoring some items)
		StdIn.readString();
		int numCols = StdIn.readInt();
		int numRows = StdIn.readInt();
		StdIn.readInt();
		// Creates the image
		Color[][] image = new Color[numRows][numCols];
		// Reads the RGB values from the file, into the image.
		// For each pixel (i,j), reads 3 values from the file,
		// creates from the 3 colors a new Color object, and
		// makes pixel (i,j) refer to that object.
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				image[i][j] = new Color(StdIn.readInt(),StdIn.readInt(),StdIn.readInt());
			}
		}
		return image;
	}

	/**
	 * Prints the pixels of a given image.
	 * Each pixel is printed as a triplet of (r,g,b) values.
	 * For debugging purposes.
	 * @param image - the image to be printed
	 */
	public static void print(Color[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print("(");
				System.out.printf("%3s", image[i][j].getRed() + ",");    // Prints the color's red component
				System.out.printf("%4s", image[i][j].getGreen() + ",");  // Prints the color's green component
				System.out.printf("%4s", image[i][j].getBlue());   // Prints the color's blue component
				System.out.print(") ");
			}
			System.out.println();
		}
	}

	/**
	 * Returns an image which is the horizontally flipped version of the given image.
	 * @param image - the image to flip
	 * @return the horizontally flipped image
	 */
	public static Color[][] flippedHorizontally(Color[][] image) {
		Color[][] flippedHorizontally = new Color[image.length][image[0].length];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				flippedHorizontally[i][j] = image[i][image[0].length - j - 1];
			}
		}
		return flippedHorizontally;
	}

	/**
	 * Returns an image which is the vertically flipped version of the given image.
	 * @param image - the image to flip
	 * @return the vertically flipped image
	 */
	public static Color[][] flippedVertically(Color[][] image){
		Color[][] flippedVertically = new Color[image.length][image[0].length];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				flippedVertically[i][j] = image[image.length - i - 1][j];
			}
		}
		return flippedVertically;
	}

	/**
	 * Returns the average of the RGB values of all the pixels in a given image.
	 * @param image - the image
	 * @return the average of all the RGB values of the image
	 */
	public static double average(Color[][] image) {
		// Replace the following statement with your code
		return 0.0;
	}

	/**
	 * Returns the luminance value of a given pixel. Luminance is a weighted average
	 * of the RGB values of the pixel, given by 0.299 * r + 0.587 * g + 0.114 * b.
	 * Used as a shade of grey, as part of the greyscaling process.
	 * @param pixel - the pixel
	 * @return the greyscale value of the pixel, as a Color object
	 *         (r = g = b = the greyscale value)
	 */
	public static Color luminance(Color pixel) {
		int lumPixel =(int)(0.299 * pixel.getRed() + 0.587 * pixel.getGreen() + 0.114 * pixel.getBlue());
		return new Color(lumPixel,lumPixel,lumPixel);
	}

	/**
	 * Returns an image which is the greyscaled version of the given image.
	 * @param image - the image
	 * @return rhe greyscaled version of the image
	 */
	public static Color[][] greyscaled(Color[][] image) {
		Color[][] greyScaled = new Color[image.length][image[0].length];
		for (int i = 0; i < greyScaled.length; i++) {
			for (int j = 0; j < greyScaled[0].length; j++) {
				greyScaled[i][j] = luminance(image[i][j]);
			}
		}
		return greyScaled;
	}

	/**
	 * Returns an umage which is the scaled version of the given image.
	 * The image is scaled (resized) to be of the given width and height.
	 * @param image - the image
	 * @param width - the width of the scaled image
	 * @param height - the height of the scaled image
	 * @return - the scaled image
	 */
	public static Color[][] scaled(Color[][] image, int width, int height) {
		Color[][] scaled = new Color[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				scaled[i][j] = image[i * image.length / height][j * image[0].length / width];
			}
		}
		return scaled;
	}

	/**
	 * Returns a blended color which is the linear combination of two colors.
	 * Each r, g, b, value v is calculated using v = (1 - alpha) * v1 + alpha * v2.
	 *
	 * @param  c1 - the first color
	 * @param c2 - the second color
	 * @param alpha - the linear combination parameter
	 * @return the blended color
	 */
	public static Color blend(Color c1, Color c2, double alpha) {
		int blendedRed = (int)(alpha * c1.getRed() + (1 - alpha) * c2.getRed());
		int blendedGreen = (int)( alpha * c1.getGreen() + (1 - alpha) *  c2.getGreen());
		int blendedBlue = (int)( alpha * c1.getBlue() + (1 - alpha) * c2.getBlue());
		Color c3 = new Color(blendedRed, blendedGreen, blendedBlue);
		return c3;
	}

	/**
	 * Returns an image which is the blending of the two given images.
	 * The blending is the linear combination of (1 - alpha) parts the
	 * first image and (alpha) parts the second image.
	 * The two images must have the same dimensions.
	 * @param image1 - the first image
	 * @param image2 - the second image
	 * @param alpha - the linear combination parameter
	 * @return - the blended image
	 */
	public static Color[][] blend(Color[][] image1, Color[][] image2, double alpha) {
		Color[][] blended = new Color[image1.length][image1[0].length];
		for (int i = 0; i < blended.length; i++) {
			for (int j = 0; j < blended[0].length; j++) {
				blended[i][j] = blend(image1[i][j],image2[i][j],alpha);
			}
		}
		return blended;
	}

	/**
	 * Morphs the source image into the target image, gradually, in n steps.
	 * Animates the morphing process by displaying the morphed image in each step.
	 * The target image is an image which is scaled to be a version of the target
	 * image, scaled to have the width and height of the source image.
	 * @param source - source image
	 * @param target - target image
	 * @param n - number of morphing steps
	 */
	public static void morph(Color[][] source, Color[][] target, int n) {
		Color image[][] = new Color[source.length][source[0].length];
		target = scaled(target, source[0].length, source.length);
		for (int i = 0; i <= n; i++) {
			image = blend(source, target, (double) (n - i) / n);
			show(image);
		}
	}
	/**
	 * Renders (displays) an image on the screen, using StdDraw.
	 *
	 * @param image - the image to show
	 */
	public static void show(Color[][] image) {
		StdDraw.setCanvasSize(image[0].length, image.length);
		int width = image[0].length;
		int height = image.length;
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.show(25);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Sets the pen color to the color of the pixel
				StdDraw.setPenColor(image[i][j].getRed(),
						image[i][j].getGreen(),
						image[i][j].getBlue());
				// Draws the pixel as a tiny filled square of size 1
				StdDraw.filledSquare(j + 0.5, height - i - 0.5, 0.5);
			}
		}
		StdDraw.show();
	}
}