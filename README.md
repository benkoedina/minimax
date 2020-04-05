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

Pentago játék implementációja.

A pentago játék szabályai:
    A tábla négy darab 3*3-as kisebb mezőből áll, tehát így kapjuk meg a 6*6-os játékfelületet.
    A játékosok elkezdik egymás után a táblára helyezni fekete illetve fehér golyóikat.
    A csavar: minden egyes golyófeltétel után a soron levő játékosnak el kell forgatni valamelyik 3*3-as mezőt 90 fokkal balra vagy jobbra. 
    Az nyer, akinek függőlegesen, vízszintesen vagy átlósan először jön össze az öt bogyó.
    
Implementálás:
  -minimax és alfa-béta nyesésre alapozik
  
