Spacetagger
=====
*Seria.1616892*

Features:
* **12 Scene tutte diverse!**
    + Nemici che cambiano sempre
    + Path creative
    + Grafica decorativa
* **10 nuovi nemici**:
    + EnemyKamikaze: segue la navicella per schiantarcisi addosso
    + EnemyBerzerk: spara a raffica
    + EnemyCluster: un nemico che datagli una lista di nemici da costruttore li lega in automatico al centrale
    + EnemyClusterSquare *extends EnemyCluster*: un cluster di nemici a quadrato che gira attorno al nemico
    + EnemyCutter: ha una path a taglierino, molto difficile da colpire
    + EnemySnakeHead *extends EnemySimple*: la testa del serpentone intermedio, ovvero un nemico con tanti nemici in coda
    + EnemySnakeTail *extends EnemySimple*: i vari nemici in coda
    + EnemyBig1, spara nemici
    + EnemyBig2, spara laser e segue la navicella andandogli addosso
* **6 Nuove Path**
    + Chain Path: una path che lega due nemici, diversa da addChildEntity perche si comporta come un elastico: piu' e' lontano il nemico e piu veloce si muove e viceversa se il nemico e' vicino si rallenta.
    + CircleDownPath: traiettoria circolare unita a traiettoria in basso nella y
    + CutterPath: path tipica di EnemyCutter
    + DownSlidePath: path che va in basso
    + FollowShipPath: la path usata dai kamikaze
    + IntermediatePath: unisce CircleDownPath e LinePath, path usata molto nel livello del primo snake.
* **5 PowerUp**
    + FuryPowerUp: duemila spari, velocita' aumentata per poco, invincibilita'
    + ShieldPowerUp: mette uno scudo davanti alla nave
    + SmartShotPowerUp: sparo a ricerca, uccide il nemico piu vicino. Funziona in modo sorprendentemente intelligente
    + SuperShipPowerUp: navicella piu' veloce, danni ridotti a 1/3, triplo sparo a ricerca intelligente
    + TripleShotPowerUp: triplo sparo
* **7 Nuovi spari:**
    + SmartShot a ricerca
    + TripleShot triplo shot
    + FuryShot a raffica
    + TripleSmartShot *extends SmartShot*
    + BorgShot del nemico
    + BorgLazerShot usato da EnemyBig2
    + BossShot ovvero quintuplo sparo!
* **Tantissimi elementi decorativi**: 2 pianeti, 3 nebulose, 2 shotDecorators, 1 scudo, 1 navicella nuova, 4 nemici, nuovo asteroide...
* **BOSS**:
    + Temutissimo e agguerrito, composto da tanti pezzi che consequenzialmente sparano e cambiano comportamento alla morte dei pezzi rimanenti
* **Asteroid Cluster**: una fascia di asteroidi casuali, estende Asteroid
* **AsteroidPointless**: un asteroide senza powerup
* Musica originale a cura di **Devim Beatz**

**TODO**

* Check di sicurezza per code horror (non si sa mai)
* Javadoc approfondito
* Linkare le risorse utilizzate, esportarle e impacchettarle
* JAR da far funzionare


```sh
spacetagger.com
```