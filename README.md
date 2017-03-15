# selenide-toy
Practice Page Object with Selenide to fetch Billboard Top100 songs' genres.

## Targets

Download top 100 billboard tracks information and search genre information with google.

-[X] PageObject to fetch top 100 billboard list;
-[ ] Query google about the song's genre;

## Notes

This is inspired by a post found in super market notice wall. 
It described an individual Java program to generate playlist based on genres in order.

This selenide maven project is developed as a fast prototype to verify an idea to fetch genre tags via Google search engine.
At that time, I have worked with selenium for some time and thought it shall be concise and brief to move to selenide, which offers most of the features we duplicated in many projects.
Therefore, it is also a fast-learning code to practice with selenide. 

The hours on this task is a good experience. I learned that genres could be tagged to both tracks and artists. They are not orthogonal and a common genre list is defined in ID3 information standard originally for MP3 format.
WinAmp has expanded the genre list from 80 to 126. Reference link is [Link](http://id3.org/id3v2.3.0#Appendix_A_-_Genre_List_from_ID3v1)

By the way, for a convenient implementation regardless the objective to learn selenide, I would recommend Python with beautiful soap to complete the targets on gener query.





