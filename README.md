# selenide-toy
Practice Page Object with Selenide to fetch Billboard Top100 songs' genres.

## Targets

Download top 100 billboard tracks information and search genre information with google.

-[X] PageObject to fetch top 100 billboard list;

-[X] Query google about the song's genre;
  
  - [X] Resolved Exception handling in Page Object with Selenide.
  
  - [X] Improve the success rate (now it is 83% after introduced multiple keywords to query with google)

The genre list for top 100 billboard songs is accessible on [Github Link](https://github.com/maxwu/selenide-toy/blob/master/BB_top100_genres.yaml)

In general, __83%__ of songs in list have easily patterned Google genre query results.
(With multiple google query options, the success rate increased from 47.96% to 83%)

The sample of first 10 songs genre query results:

    ```yaml
    How Far I'll Go: [Film music]
    T-Shirt: [NA]
    Let Me Love You: [Dance, electronic]
    Rockabye: [NA]
    Bad And Boujee: [Hip-hop, rap]
    Any Ol' Barstool: [Country]
    Play That Song: [Funk]
    I Got You: [Classic R&B]
    Rolex: [NA]
    Hometown Girl: [NA]
    ```

## Backgrounds

This is inspired by a post found in super market notice wall. 
It described an individual Java program to generate playlist based on genres in order.

This selenide maven project is developed as a fast prototype to verify an idea to fetch genre tags via Google search engine.
At that time, I have worked with selenium for some time and thought it shall be concise and brief to move to selenide, which offers most of the features we duplicated in many projects.
Therefore, it is also a fast-learning code to practice with selenide. 

The hours on this task is a good experience. I learned that genres could be tagged to both tracks and artists. They are not orthogonal and a common genre list is defined in ID3 information standard originally for MP3 format.
WinAmp has expanded the genre list from 80 to 126. Reference link is [Link](http://id3.org/id3v2.3.0#Appendix_A_-_Genre_List_from_ID3v1)

By the way, for a convenient implementation regardless the objective to learn selenide, I would recommend Python with beautiful soap to complete the targets on gener query.

## Notes 

__Exception Handling__

As recommended by Andrei on Selenide.org, the PageObject is expected to interact with method not Web Elements with test logics. In cases of sophsticated logics or Web Clawer scenarios, the exceptions are handled with PageObject or abstraction on top of it.

- The error type to capture is __Throwable__, or, more specifically __UIAssertionError__. 

- The error shall be captured when properties are __first accessed__ with the WebElement or ElementCollection, not the association time as defined in getters by PageObject with Selectors.

    ```java
    try{
        genres = Arrays.asList($("#rso div._uX div._XWk").getText().split("/"));
    }catch (ElementNotFound e){
        logger.info("Mark genre to NA due to error:\n" + e.toString());
        genres = new ArrayList<>(Arrays.asList("NA"));
    }
    ```
    
## TODO

- -Try to insert a state to query the 2nd time if simple query cannot return easily patterned result.-

- Try to introduce multi-thread to run the query faster.



