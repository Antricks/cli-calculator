## Alleskönner

Das ist einfach eine Klasse wo Funktionen rein kommen, die irgendwas interessantes machen.
Es geht prinzipiell einfach um das Implementieren von irgendwelchen Aufgaben, die hoffentlich irgendwie spannend umzusetzen sind.

### Mein Denkvorgang beim Taschenrechner:

Hier muss ich dann wohl rekursiv den String zerlegen...
Wie mach ich das bloß...
Also erstmal Punkt vor Strich ist wichtig, also muss ich priorisiert auftrennen
Ich bau mir rekursiv eine Baumstruktur, Verzweigungen sind Operatoren, Zahlen sind Blätter des Baumes

```
2 * 5 + 10 - 3 / 4   
```

würde zu diesem Baum:

          +
      *      -
    2   5  10  /
              3  4


Und nicht zu diesem Baum:

	  *
	2    +
	    5   -
	      10   /
	         3   4


Dieser Baum wäre auch okay, der käme aber nicht bei verarbeitung in Leserichtung heraus:

	        -
	    +       /
	  *  10   3   4
	2  5

**WICHTIG IST AUCH:**

	a - b

wird zu 

	  -
	a   b

nicht zu

	  -
	b   a

**denn `a - b` muss nicht unbedingt `b - a` sein**

Lösung ist eine priorisierte Aufteilung, zuerst möglichst nach + bzw - aufteilen, dann nach den anderen Operatoren

---

Heeeeeyyy ich möchte mit Pi oder e arbeiten können! Wie mache ich das bloß am besten???
Ich habe einen Teil des Codes an den ich nur komme, wenn ich keinen Operator mehr im Input habe, perfekt!

---

Ich hätte jetzt gerne noch Klammern. Die sind im Prinzip auch nur etwas, das die Baumstruktur manipuliert. Gucken wir uns doch mal ein Beispiel an:

```
1 * (2 + 3)
```

Sollte jetzt zu diesem Baum hier werden:

```
   *
1      +
    2     3
```

Wenn ich irgendwie eine Klammer finde, muss ich also eine neue `Euation` vom Inhalt der Klammern machen. 

Der aktuelle Code würde diese Katastrophe daraus machen:

```
      +
  *      "3)"
1   "(2"
```



