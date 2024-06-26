# Instush: Java Image Processing Library

Instush is a Java library that provides various image processing functions. You can use it to read images from PPM files, manipulate images by flipping them horizontally or vertically, convert images to grayscale, scale images, blend images, and morph between two images gradually.

## Usage
### Reading an Image

To read an image from a PPM file, use the read method:

    Color[][] image = Instush.read("filename.ppm");

### Flipping an Image

You can flip an image horizontally or vertically using the flippedHorizontally or flippedVertically methods, respectively:
    
    Color[][] flippedHorizontal = Instush.flippedHorizontally(image);
    Color[][] flippedVertical = Instush.flippedVertically(image);

### Converting to Grayscale

Convert an image to grayscale using the greyscaled method:
    
    Color[][] grayscale = Instush.greyscaled(image);

### Scaling an Image

Scale an image to a specified width and height using the scaled method:
    
    Color[][] scaledImage = Instush.scaled(image, width, height);

### Blending Images

Blend two images together using the blend method:
    
    Color[][] blendedImage = Instush.blend(image1, image2, alpha);

### Morphing Images

Morph one image into another gradually using the morph method:
    
    Instush.morph(sourceImage, targetImage, numberOfSteps);

### Showing an Image

Display an image on the screen using the show method:
    
    Instush.show(image);

## Examples

### Command-Line Tools

Instush also provides command-line tools for common operations:

    Editor1: Flip, or convert an image to grayscale from a PPM file.
    Editor2: Scale an image from a PPM file to a specified width and height.
    Editor3: Morph between two images from PPM files gradually.

### Usage examples:

    sh
    java Editor1 filename.ppm fh
    java Editor2 filename.ppm 100 200
    java Editor3 source.ppm target.ppm 50

Replace filename.ppm, source.ppm, and target.ppm with your actual file names, and adjust parameters as needed.

## Installation

To use this library, you need to have the following:

    Java Development Kit (JDK) installed
    StdDraw and StdIn libraries for handling input and output Include these in your project’s build path to run the examples provided.

## License
This library is provided under the MIT License. Feel free to use and modify it according to your needs.
