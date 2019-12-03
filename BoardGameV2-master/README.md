# BoardGameV2
The following design patterns have been implemented in this game:

1. abstract factory while  creating pieces
2. prototype -->
3. composite
4. decorator while creating hurdle
5. visitor
6. observer
7. chain of responsibility
8. command piece movement
9. bridge
10.persistent data structure -->undo

This is a game of war between avengers and x-men. The game is developed in JAVAFX. All the images have been taken from internet and are copyrights of their respective owners.


#OBSERVER PATTERN

Iobservable-> thing that is observed , iobserver -> observes the things that has to observed

iobservable------------------------has-----------*->     iobservers
-registers observers                                     -update
-unregister observer
-notify
observable implements iobservable                       observer implements i observer

-> x = new observable()
->y= new Observer(x)
x.register
x.notify()
which means
-> new Observer(new Observable)

