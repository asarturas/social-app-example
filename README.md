# Social App Exercise

a console-based social networking application (similar to Twitter) satisfying the scenarios below.

## Features

### Posting

Alice can publish messages to a personal timeline
```
> Alice -> I love the weather today
> Bob -> Damn! We lost!
> Bob -> Good game though.
```
### Reading

I can view  Alice and  Bob’s timelines
```
> Alice
I love the weather today (5 minutes ago)
> Bob
Good game though. (1 minute ago)
Damn! We lost! (2 minutes ago)
```

### Following

Charlie can subscribe to  Alice’s and  Bob’s timelines, and view an aggregated list of all subscriptions
```
> Charlie -> I'm in New York today! Anyone want to have a coffee?
> Charlie follows Alice
> Charlie wall
Charlie - I'm in New York today! Anyone want to have a coffee? (2 seconds ago)
Alice - I love the weather today (5 minutes ago)
> Charlie follows Bob
> Charlie wall
Charlie - I'm in New York today! Anyone wants to have a coffee? (15 seconds ago)
Bob - Good game though. (1 minute ago)
Bob - Damn! We lost! (2 minutes ago)
Alice - I love the weather today (5 minutes ago)
```

## Details
* The application must use the console for input and output.
* Users submit commands to the application. There are four commands. “posting”, “reading”, etc. are not part of the commands; commands always start with the user’s name.
    * posting : `<user name> -> <message>`
    * reading : `<user name>`
    * following : `<user name> follows <another user>`
    * wall : `<user name> wall`
    
# Environment requirements

The app built with `scala` and `sbt` you have to have it installed on your machine to run locally.

Alternatively you can use dev container, which these dependencies pre installed (see below).

## How to run tests?

Locally:
```
sbt test
```

Via docker (dev):
```
docker run -it --rm -v "$PWD/:/socialapp" -w "/socialapp" spikerlabs/scala-sbt:scala-2.12.2-sbt-0.13.15 sbt test
```

## How to run app?

Locally:
```
sbt run
```

Via docker (dev):
```
docker run -it --rm -v "$PWD/:/socialapp" -w "/socialapp" spikerlabs/scala-sbt:scala-2.12.2-sbt-0.13.15 sbt run
```
