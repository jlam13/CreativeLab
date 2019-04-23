package com.example.creativelab.learn.test;

import java.util.ArrayList;

public class Questions {

    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String correct;
    private String category;

    public Questions(){}

    public Questions(String question, String choice1, String choice2, String choice3, String correct, String category) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.correct = correct;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public String getCorrect() {
        return correct;
    }

    public String getCategory() {
        return category;
    }

    public static ArrayList<Questions> getDummyQuestions() {
        ArrayList<Questions> set = new ArrayList<>();

        set.add(new Questions("When creating a new project, the first layer is","unlocked by default","locked by default","hidden by default","locked by default","T1"));
        set.add(new Questions("The file format for a Photoshop file is a","AI","PNG","PSD","PSD","T1"));
        set.add(new Questions("The shortcut to undo an action more than once is","CTRL + ALT + Z","CTRL + Z","CTRL + SHIFT + Z","CTRL + ALT + Z","T1"));
        set.add(new Questions("The first option in the Layer Style window is ","Contour","Stroke","Bevel & Emboss","Bevel & Emboss","T1"));
        set.add(new Questions("Which of the following is not a blending mode?","Soft Light","Vivid Burn","Hue","Vivid Burn","T1"));
        set.add(new Questions("Select the best method/tool to change a specific color","Colour range","Selective Colour","Hue","Colour range","T1"));
        set.add(new Questions("In the stacking order, which layer would appear first in an image?","The selected layer","The bottom layer","The top layer","The top layer","T1"));
        set.add(new Questions("What tool allows you to remove/erase part of a layer using a free-hand method?","Magic Wand tool","Eraser tool","Pen tool","Eraser tool","T1"));
        set.add(new Questions("Setting the width of an image from 100px to -100px would","Make it disappear","Reflect it along the horizontal axis","Reflect it along the vertical axis","Reflect it along the horizontal axis","T1"));
        set.add(new Questions("A shortcut for rotating an image is","CTRL + R","CTRL + T","CTRL + D","CTRL + T","T1"));

        set.add(new Questions("Pressing the letter _ will select the Rectangle tool","R","M","T","M","T2"));
        set.add(new Questions("Which of the following is used to convert a raster image to a vector image?","Live Trace","Live Convert","Live Pixels","Live Trace","T2"));
        set.add(new Questions("Pressing the letter _ will select the Eyedropper tool","I","E","Y","I","T2"));
        set.add(new Questions("The Pathfinder tool is used to","combine objects into new shapes","view all previous actions","find a path","combine objects into new shapes","T2"));
        set.add(new Questions("Which of the following is not a Shape Mode?","Unite","Double","Intersect","Double","T2"));
        set.add(new Questions("Pressing the letter Q will select the","Lasso tool","Gradient tool","Quadrant tool","Lasso tool","T2"));
        set.add(new Questions("An artboard is","the printable region within a document","the non-printable region within a document","not an element of Illustrator","the printable region within a document","T2"));
        set.add(new Questions("Select > Same > Fill Colour will","Select shapes with the same colour","Fill shapes with the same colour","Select and fill shapes with the same colour","Select shapes with the same colour","T2"));
        set.add(new Questions("How would you make a stroke wider?","Stroke tool","Width tool","Height tool","Width tool","T2"));
        set.add(new Questions("Pressing the letter __ will select the Direct Selection tool","A","D","S","A","T2"));

        set.add(new Questions("Pressing the letter _ will select the Selection tool","V","S","M","V","T3"));
        set.add(new Questions("Pressing the letter _ will select the Razor tool","R","C","Z","C","T3"));
        set.add(new Questions("The timeline is the","graphical element where video, audio, and graphics clips are arranged","historical log of all changes","placeholder for imported videos","graphical element where video, audio, and graphics clips are arranged","T3"));
        set.add(new Questions("A hard cut ","is the final version of a video production","is the immediate transition from one clip to the next","is a trim of more than 20 seconds","is the immediate transition from one clip to the next","T3"));
        set.add(new Questions("Which of the following is not a transition folder?","Dissolve","Iris","Swipe","Swipe","T3"));
        set.add(new Questions("Where do you go to change the options of an Effect?","Effect Options","Effect Controls","Effects","Effect Controls","T3"));
        set.add(new Questions("Which format would you export a video in if you wanted to put it on the web?","H.264","H2.64","H.246","H.264","T3"));
        set.add(new Questions("A tracking mask and mosaic blur are typically used for","Number plates","Hands","Apples","Number plates","T3"));
        set.add(new Questions("If you are filming upside down, it is best to flip your footage","horizontally","vertically","both horizontally and vertically","both horizontally and vertically","T3"));
        set.add(new Questions("The Razor tool","cuts a clip into two clips","trims the edge of a clip","cuts a clip into multiple clips","cuts a clip into two clips","T3"));

        set.add(new Questions("To edit frame by frame, you could use the ______ keys","left and right","up and down","page up and page down","page up and page down","T4"));
        set.add(new Questions("A null object","is an invisible layer that you can create to be a super parent","is an empty layer you can create to be a super parent","does not exist","is an invisible layer that you can create to be a super parent","T4"));
        set.add(new Questions("The notation for 'frames per second' is","fps","fp/s","p","p","T4"));
        set.add(new Questions("Pressing the letter _ will set the beginning of a work area to the current time","N","E","B","B","T4"));
        set.add(new Questions("Pressing the letter _ will set the end of a work area to the current time","E","B","N","N","T4"));
        set.add(new Questions("Which 'view' will After Effects render out?","Front","Active Camera","Current View","Active Camera","T4"));
        set.add(new Questions("After Effects is primarily used for","photo editing","video editing","motion graphics","motion graphics","T4"));
        set.add(new Questions("Which of the following can be used to achieve a glitch effect?","Twitch","Posterise time","All of the above","All of the above","T4"));
        set.add(new Questions("The action that creates relationships between layer properties is known as","Pick Whipping","Project Lock","Layer Connect","Pick Whipping","T4"));
        set.add(new Questions("When a layer is selected, pressing enter will","delete the layer","allow you to change the name","lock the layer","allow you to change the name","T4"));

        set.add(new Questions("_______ is a way to group photos in one place for easy viewing","Collection","Grouping","Collage","Collection","T5"));
        set.add(new Questions("_______ add description to an image","Filters","Keywords","Tags","Keywords","T5"));
        set.add(new Questions("Red eye correction","eliminates the red from around an eye","adds red to an eye","eliminates red from the center of an eye","eliminates red from the center of an eye","T5"));
        set.add(new Questions("Pressing the letter H","displays the proprties of a photo","hides and reveals a tool","select the hue tool","hides and reveals a tool","T5"));
        set.add(new Questions("Changing the tint","adjusts the green and magenta of an image","adjusts all colours in an image","adjusts the monochromatic colours in an image","adjusts the green and magenta of an image","T5"));
        set.add(new Questions("Pressing the letter F","flips a photo","changes the font","displays a full screen preview","displays a full screen preview","T5"));
        set.add(new Questions("The grid","shows all images that have been imported","displays gridlines","shows where edits have been made","shows all images that have been imported","T5"));
        set.add(new Questions("Pressing the tab key","turns on and off the left and right panels","switches between photos","displays a full screen preview","turns on and off the left and right panels","T5"));
        set.add(new Questions("The clarity sides adds or removes","opacity","blurriness","mid-tone contrast","mid-tone contrast","T5"));
        set.add(new Questions("Split toning involves","applying one colour to the shadows and another to the highlights","applying contrasting colours","applying only two colours","applying one colour to the shadows and another to the highlights","T5"));

        set.add(new Questions("Which of the following is an appropriate colour setting for print?","RGB","PSD","MDK","RGB","T6"));
        set.add(new Questions("What is a gutter?","The space between each artboard","The space between each column","The space at the top of a page","The space between each column","T6"));
        set.add(new Questions("What is kerning?","The process of adjusting the spacing between characters in a proportional font","The process of adjusting the height of letters","The process of adjusting the width of letters","The process of adjusting the spacing between characters in a proportional font","T6"));
        set.add(new Questions("Title Case","capitalises the first word","capitalises the first letter of each word","capitalises the heading","capitalises the first letter of each word","T6"));
        set.add(new Questions("Tracking","affects the space between a word or paragraph","creates an outline around each letter","creates a path for each layer","affects the space between a word or paragraph","T6"));
        set.add(new Questions("Margins are the","border around a page","blank areas around the sides of a page","blank areas around a body of text","blank areas around the sides of a page","T6"));
        set.add(new Questions("If you are working on a file that has 300 pages of high resolution images, you would use","fast display","typical display","high quality display","fast display","T6"));
        set.add(new Questions("The master page contains","repeating elements for each page of a document","all InDesign shortcuts","a blank view","repeating elements for each page of a document","T6"));
        set.add(new Questions("InDesign is typically used for","publishing and typesetting","creating vector graphics","video editing","publishing and typesetting","T6"));
        set.add(new Questions("To avoid creep","create a box around the page","place elements 5mm from the edge","place elements far enough from the edge","place elements far enough from the edge","T6"));

        return set;
    }
}

