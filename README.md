# minimax

Gyakorlat

Tesztelje ezt a demo-t.

Feladat

Válasszon ki egy olyan játékot (a tic-tac-toe-t leszámítva), amely a labor elején felsorolt négy kritériumot teljesíti,
(innen böngészhet) majd írjon programot, amely az alfa-béta algoritmust használva lehet˝ové teszi a számítógép
elleni játékot. Grafikus interfész nem szükséges.

Kritériumok

A program a parancssor argumentumain keresztül vegye át a játék nehézségi szintjét:
• -d <N> – a program a játékfát pontosan N mélységig bontsa le
• -t <N> – a program egy lépésen legfennebb N másodpercet gondolkozzék.

Feltöltend˝o

1. README.md — a feladatot, illetve a heurisztikus kiértékelési függvény részletes leírását tartalmazó dokumentum.
2. Forráskód. Bármilyen programozási nyelv használható.

Adminisztratív

A kiválasztott feladatot 1-4 f˝os csapatokban kell megoldani. Minden csapat külön játékon kell dolgozzon. A
feladatot, a csapat összetételét, illetve a projektre mutató GitHub linket az összesített táblázat minmax fülébe
kell bevezetni.

Pentago játék implementációja:

A pentago játék szabályai:

    A tábla négy darab 3*3-as kisebb mezőből áll, tehát így kapjuk meg a 6*6-os játékfelületet.
    A játékosok elkezdik egymás után a táblára helyezni fekete illetve fehér golyóikat.
    A csavar: minden egyes golyófeltétel után a soron levő játékosnak el kell forgatni valamelyik 3*3-as mezőt 90 fokkal balra vagy jobbra. 
    Az nyer, akinek függőlegesen, vízszintesen vagy átlósan először jön össze az öt bogyó.
    
Implementálás:

  -minimax és alfa-béta nyesésre alapozik
  - W a fehér golyókat képviseli, a B- a fekete gólyókat
  - mindig a vendég játékos kezd, ő választhat először, hogy hova akar tenni és melyik negyedet szeretné forgatni. 
  - a vendég játékos lépései ellenőrző függvényekkel vannak leellenőrizve: helyes a lépés, helyes a forgatás, nyerő lépés-e
  - ha mindezek megvalósultak és jöhet a gép, akkor lép érvénybe az alfa-béta nyesés ötvözve a minimax algoritmussal, tehát a számítógép fog következni
  - a számítógép mindig okos lépést tesz meg, nehéz őt megverni.
  -ha még nincs a gépnek sem nyerő pozíciója, amely egy függvénnyel van megnézve, akkor következik a vendég játékos, hogy letegye a kiválasztott helyre az ő golyóját. 
  - és ez így megy tovább egy while ciklusban mindaddig amíg valaki nyer. 
  
 Futtatás után:
 
   - a mezőket kell megadnia a vendég játékosnak, hogy melyik oszlop és melyik soron szeretné elhelyezni az ő golyóját, valamint melyik negyedet szeretné forgatni
   - minden lépés után kirajzolja a tábla jelenlegi állását, hogy mit tett a vendég játékos valamint a számítógép.
  
  
  
  
