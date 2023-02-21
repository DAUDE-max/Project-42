# SchoolGame
SchoolGame
Tag 1:


  Window erstellt, zu JFrame und JPanel eingelesen und as window angepasst.
  
  JPanel erstellt, versucht ein bild einzufügen;
  
  GamePanel erstellt und  JPanel idee verworfen.
  
  Das GamePanel als Herz des Systems.
  
  Größenkonstanten erstellt
  
  GameCore mit Thread erstellt
  
  updated und draw
  
 
Tag 2:


  MapClass angefangen - 2 Stunden planlos daran gearbeitet.
  
  MapClass gelöscht
  
  Quadrat erstellt welches der Player werden sollte
  
  KeyManager erstellt, der aus Tastenschläge reagert.
  
  Quadrat beweglich gemacht
  
  
Tag 3:


  Zu Images in JPanels eingelesen
  
  Quadrat und Steuerung gelöscht
  
  EntityCalss ertsellt von dem alle entitys erben sollten
  
  PlayerClass ertsellt, mit Position und Bufferd Image und draw() und update() ausgelagert.
  
  
meanwhile: 


  TileClass erstellt, einzeles Feld der Map
  
  TileManager erstellt, baut die Map zusammen
  
  (Map wird über die draw funktion manuell erstellt) !!Lösung!!
  
  
Tag 4:

  
  player movement Animiert über 2 abwechselnde Bilder
  
  zu BufferdReader eingelesen
  
  map wird jetzt über eine txt datei erstellt Prinzip:
  
  a 0 0 0 1 0 0 0 a
  
  a 0 0 0 1 0 0 0 a
  
  a 0 2 2 3 2 2 0 a
  
  a 0 2 4 4 4 2 0 a
  
  a 0 2 4 4 4 2 0 a
  
  a 0 2 4 4 4 2 0 a
  
  a 0 2 2 2 2 2 0 a
  
  a 0 0 0 0 0 0 0 a
  
  Für ein Haus(0 = erde; 1 = weg; 2 = Wand; 3 = Tür; 4 = Boden)
  
  !! Problem Kollision
  
  
Tag 5:


  Kamera erstellt und fast das gesamte Koordinaten handling überarbeitet.
  
  Tiles und Player Images designt
  
Tag 6:

  Collision erstellt und 2 Stunden lang perfektioniert
  
Tag 7:
  
  Let Objects Exist; SuperClass vererbt name, id, draw, img, und position; ObjectManager plaziert die Objekte;
  Erstellte Objekte: Coins; Door; Chest;
  
  Next Step: Objekt interaktion
  
Tag 8: 
  
   objekte führen deren aufgaben in der Player class aus sobald sie durch objektCollision aktiviert wurden;
   Objekte rufen jetzt eine activate methode aus wenn sie durch abjektCollision aktiviert werden;
   
   Coins werden im Player gezählt und sund bedingung für die Door und Chest activate();
   
 Tag 9:
 
    SEG Alarm -> nach 8 Stunden einsatz ein paar Bilder designt und InteractiveTiles ins Leben geruf, die auf Abstract tiles angebracht werden sollen und über [E]      angefunkt werden können. Das alles aber noch nicht umgesetzt;
   
   !!! Umsetzen
 
