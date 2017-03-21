# Genre Clawer

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) 
[![Build Status](https://travis-ci.org/maxwu/Genre-Clawer.svg?branch=master)](https://travis-ci.org/maxwu/Genre-Clawer) [![codecov](https://codecov.io/gh/maxwu/Genre-Clawer/branch/master/graph/badge.svg)](https://codecov.io/gh/maxwu/Genre-Clawer) [![Build Status](https://travis-ci.org/maxwu/Genre-Clawer.svg?branch=dev)](https://travis-ci.org/maxwu/Genre-Clawer) [![codecov](https://codecov.io/gh/maxwu/Genre-Clawer/branch/dev/graph/badge.svg)](https://codecov.io/gh/maxwu/Genre-Clawer)

A clawer to fetch song's genre information from internet. This project is a practice on PageObject with Selenide. 
Based on it, an app was developed to generate billboard top 100 song list with genre information and dump them into YAML.

Besides selenide, HtmlUnit is introduced as a headless browser to fetch genre results silently without browser window popped up.

## User Guide

### Java Application Cli

Usage: 

>java -jar selenide-genre-clawer-1.2.jar [-h]|[-n ${size}] [-c ${client}]
>
>"-h": Show help message and exit.
>
>"-n": Size of song list fetched from BillBoard Top100 music. This option is int type and defaults to 10.
>
>"-c": Case insensitive client type from {"HtmlUnit", "Selenide" and Jsoup (in progress)}. 
Option is case insensitive string of client name.
>  
>   HtmlUnit is the default client type.
>    
>   Using Selenide requests Chrome Browser configured up with Selenium and WebDriverManager.
   
#### Example 1: Fetch billboard top 5 songs genres
By default, HtmlUnit headless browser is used in this example.
```shell
# To fetch billboard top5 songs genres:
>>>java -jar ./target/Genre-Clawer-1.3.jar -n5
Got total 5 songs
1:
  song: Shape Of You
  artist: Ed Sheeran
  genres: [Pop]
2:
  song: Bad And Boujee
  artist: Migos Featuring Lil Uzi Vert
  genres: [Hip-hop, rap]
3:
  song: That's What I Like
  artist: Bruno Mars
  genres: [Pop]
4:
  song: I Don't Wanna Live Forever (Fifty Shades Darker)
  artist: Zayn / Taylor Swift
  genres: [Pop]
5:
  song: Love On The Brain
  artist: Rihanna
  genres: [Contemporary R&B, Pop]

Success rate = 100.00%
```

#### Example 2: Fetch genres for song name "Love On The Brain" and artist name "Rihanna"
Obviously, this example will utilize default HtmlUnit headless browser.

```shell
>>java -jar ./target/Genre-Clawer-1.3.jar -s "Love On The Brain" -a "Rihanna"
Got total 1 songs
1:
  song: Love On The Brain
  artist: Rihanna
  genres: [Contemporary R&B, Pop]

Success rate = 100.00%
```

### Maven 

(TBD)

## Targets

Download top 100 billboard tracks information and search genre information with google.

-[X] PageObject to fetch top 100 billboard list;

-[X] Query google about the song's genre;
  
  - [X] Resolved Exception handling in Page Object with Selenide.
  
  - [X] Improve the success rate (now it is 83% after introduced multiple keywords to query with google)

-[X] From v1.2, introduced JSoup and HtmlUnit as convenient search strategies.

  - [ ] JSoup HttpClient, due to the lack of JavaScript engine, this strategy will move to search on Wikipedia instead.
  - [X] HtmlUnit query strategy.
  - [ ] Refactor the query to strategy factory.

The genre list for top 100 billboard songs is accessible on [Github Link](https://github.com/maxwu/selenide-genre-clawer/blob/master/BB_top100_genres.yaml)

In general, __92%__ of songs in list have easily patterned Google genre query results.
(With multiple google query options, the success rate increased from 47.96% to 83%)
(With 2nd pattern of genre presentation style on google page, success rate increased from 83% to 92%)

The sample of first 10 songs genre query results. YAML structure is mapped with [$rank : {song: $str, artist: $str, genres: $list } ].

```yaml
1:
  song: Shape Of You
  artist: Ed Sheeran
  genres: [Pop]
2:
  song: Bad And Boujee
  artist: Migos Featuring Lil Uzi Vert
  genres: [Hip-hop, rap]
3:
  song: That's What I Like
  artist: Bruno Mars
  genres: [Pop]
4:
  song: I Don't Wanna Live Forever (Fifty Shades Darker)
  artist: Zayn / Taylor Swift
  genres: [Pop]
5:
  song: Love On The Brain
  artist: Rihanna
  genres: [Contemporary R&B, Pop]
6:
  song: Tunnel Vision
  artist: Kodak Black
  genres: [Pop]
7:
  song: Paris
  artist: The Chainsmokers
  genres: [Dance, electronic]
8:
  song: Bounce Back
  artist: Big Sean
  genres: [Hip-hop, rap]
9:
  song: Rockabye
  artist: Clean Bandit Featuring Sean Paul & Anne-Marie
  genres: [Dance, electronic, Pop]
10:
  song: Closer
  artist: The Chainsmokers Featuring Halsey
  genres: [Dance, electronic]
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

As recommended by Andrei on Selenide.org, the PageObject is expected to interact with method not Web Elements with test logic. 
In cases of sophisticated logic or Web Claw scenarios, the exceptions are handled with PageObject or abstraction on top of it.

Selenide has wrapped the Element Extraction operations with Instance Proxy. Within the proxy.invoke(), the logic of invokeAndRetry() will pack exceptions up to a Throwable type with more concise information.

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

- Try to introduce multi-thread to run the query faster. 

Selenide relies on Selenium to support multiple browsers if we pay attention on the static methods. 
The selenide development community is open to support multiple browser support but which is not released. 
In general, the way is to create multiple WebDrivers and tell out which driver to speak to while calling the proxies. 

- Add simple HttpClient clawer solution and make cross check with selenide.
  As a learning practice, cross-check is also a common way for API testing.
  
- Create Jenkins task to [http://jenkins.maxwu.me](http://jenkins.maxwu.me) and package this project with Pipeline.

