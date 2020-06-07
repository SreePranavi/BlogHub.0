package com.t.bloghub0.ui.slideshow

import android.service.quicksettings.Tile
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "My Blogs" + "\n \n" +
                " Road Not Taken" + "\n \n " +
                " Two roads diverged in a yellow wood,\n" +
                "And sorry I could not travel both\n" +
                "And be one traveler, long I stood\n" +
                "And looked down one as far as I could\n" +
                "To where it bent in the undergrowth" +
                "Then took the other, as just as fair,\n" +
                "And having perhaps the better claim,\n" +
                "Because it was grassy and wanted wear;\n" +
                "Though as for that the passing there\n" +
                "Had worn them really about the same,\n" +
                "\n" +
                "And both that morning equally lay\n" +
                "In leaves no step had trodden black.\n" +
                "Oh, I kept the first for another day!\n" +
                "Yet knowing how way leads on to way,\n" +
                "I doubted if I should ever come back." +
                "\n" +
                "I shall be telling this with a sigh\n" +
                "Somewhere ages and ages hence:\n" +
                "Two roads diverged in a wood, and I—\n" +
                "I took the one less traveled by,\n" +
                "And that has made all the difference." +
                "\n  \n \n \n" +
                " Stopping By The Woods On A Snowy Evening" + "\n \n " +
                "Whose woods these are I think I know.   \n" +
                "His house is in the village though;   \n" +
                "He will not see me stopping here   \n" +
                "To watch his woods fill up with snow.   \n" +
                "\n" +
                "My little horse must think it queer   \n" +
                "To stop without a farmhouse near   \n" +
                "Between the woods and frozen lake   \n" +
                "The darkest evening of the year.   \n" +
                "\n" +
                "He gives his harness bells a shake   \n" +
                "To ask if there is some mistake.   \n" +
                "The only other sound’s the sweep   \n" +
                "Of easy wind and downy flake.   \n" +
                "\n" +
                "The woods are lovely, dark and deep,   \n" +
                "But I have promises to keep,   \n" +
                "And miles to go before I sleep,   \n" +
                "And miles to go before I sleep."



    }
    val text: LiveData<String> = _text


}