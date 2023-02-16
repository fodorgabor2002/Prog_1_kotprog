Kedves felhasználó!
Az src mappában találod a játék belépési pontját.(PlayTheGame.java).
Linuxos terminalban az src mappában az alábbi két parancsot kell beírni a program elindításához:
javac PlayTheGame.java
java PlayTheGame


A játékban színes karakterek vannak használva, ezek fontosak az átláthatóság érdekében. Amennyiben nem sikerül
elindítani valami miatt, vagy színtelen az egész, akkor kérlek IntelliJ IDEA köznyezetben indítsd el a játékot.


A játék során a zárójelezett karaktereket, vagy az előte kiírt parancsot beírva tudsz cselekedni
	- pl ha azt írja, hogy Yes (Y) or No (N), akkor a "yes, "y", "no", "n" mind megfelelő beírt szöveg.
Ahol van kötőjel, ott a megadott intervallumom belül adhatzs meg értéket
	- pl (A0-C3) esetén ami helyes: a0, a1, a2, b0, b1, b2, c0, c1, c2
Megjegyzés: a kis- és nagybetűket tetszőlegesen be lehet írni, le van kezelve. 


Egységek speciális képességeihez magyarázat:
Shooter - Tud lőni, ha nincs mellette ellenfél. Ellenkező esetben 50% sebzéssel tud közelharcin támadni.
	A visszatámadás így 25%-os sebzéssel megy közelharc esetén.
Defensive Stance - Várakozás esetén a következő sebzésnek csak a 70%-a fog rád hatni.
No Melee Penalty - A "Shooter" egység nem szenved -50% sebzést közelharc esetén.
Resurrect Allies - Egy másik szövetséges egységet [darabszám * 100] élettel feltámaszt.
Flyer - Át tud repülni egységeket, így nem kell őket megkerülni.


Jó játékot!