README FILE FOR askisijava.java

Εντολη μεταγλωτισης:javac askisijava.java
Εντολη εκτελεσης:   ->java askisijava 10 expressionism good
                    ->java askisijava 15 naturalism
                    ->java askisijava 25 impressionism excellent
                    ->java askisijava 40 naturalism good
                    ->java askisijava 5 expressionism bad

Εχω ορισει την κλαση askisijava σαν την κλαση-προγραμμα μου και μεσα της οριζω
την main καθως και τις κλασεις artifact->masterpiece->painting-sculpture ολες
public static και οι painting-sculpture ως final αφου δεν εχουν αλλες subclasses.
Η Integer.parseInt μετατρεπει την πρωτη τιμη του termianl σε ακεραιο ενω οι αλλες
δυο σε string. Οριζω εναν πινακα artarray αντικειμενων artifact που τον δηλωνω δυναμικα
και για επειτα για καθε N κανω new ενα paintig / sculpture.
Στην for για Ν επαναληψεις:Με την Math.floor(Math.random) επιτυγχανω την τυχαιοτητα στην 
δημιουργια των sculpture και painting ενω επισης με τις διαφορες random.. μεταβλητες
εχω περιπτωσεις για να δινω τιμες στα material,volume,length,width κτλ των objects.
Και αναλογα το randomInt δημιουργω painting η sculpture.
Τελος καλω την auction με τα ορισματα που ζητουνται σιν το N, και μεσα σε αυτην την
συανρτηση για Ν φορες καλω την getIndex,getInfo, και evaluate εκτπωνοντας καταλληλο 
μηνυμα για την τελευταια αναλογα την επιστρεφομενη τιμη της, για καθε object του πινακα
που εχω δημιουργησει.
class artifact:περιεχει τον index,year και το ονομα του creator, εναν κενο public constructor
δυο void συανρτησεις getInfo,getIndex που εκτυπωνει τα περιεχομενα της αμφοτερα και η αλλη τον
index και μια boolen evaluate που χρησιμευει για τα painting,sculpture. 
class masterpiece:κανει extend την artifact και ομοια με την artifact αλλα εχει δυο επιπλεον 
strings τα movement,condition και οι συναρτησεις της παρομοιας λειτουργιας οπως και της artifact.
class painting:κανει extend και εχει επισης τα length,width,surface και ενα string technique. Εχει 
εναν constructor που περναω τιμες για ολα τα μελη του καθως και τα protected των υπερκλασεων.
Εχει μια getInfo που εκτυπωνει ολα τα παραπανω μελη με την χρηση της getInfo των superclass της με
την κληση τους με την εντολη "super."  και αρα και τα protected των υπερκλασεων της. Επισης
η evaluate που δεχεται τον πινακα απο artifact και δυο τα strings που δωσαμε απο την γραμμη εντολων
και για καθε ενα artifact ελεγχει αν ικανοποιει το condition και το movement τους επιστρεφει τιμη 
true η false, ειτε δεχεται ενα μονο string και βαζει τιμη good στην condition.
class sculpture:πανομοιοτυπα περιεχομενα και λειτουργια με της painting αλλα αντι για length,width
εχει τις μεταβλητες volume και ενα string material, κατα τα αλλα οι getInfo,evaluate καθως και ο
εχουν ιδια συμπεριφορα εκτος του οτι οταν δεχεται μονο ενα string τοτε βαζει στην condition την τιμη
excellent. 
Τελος για τις deafault τιμες εχω δυο evaluate και auction που παιρνουν απο ενα string (το move)
λιγοτερο και καλλοθνται αμα δεν δωσουμε τριτη τιμη σαν ορισμα στην γραμμη εντολων και οι λειτουργιες
τους ειναι παρομοιες με δεδομενη την move για good σε painting και excellent σε sculpture.