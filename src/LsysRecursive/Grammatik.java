/**
 * Gammatik står for at parse hvad der står i tekstfilen som kommer fra txt.java
 * vores readRules method læser bogstavet inden vores kolon og reglener efter kolon som kan læses senere.
 */
package LsysRecursive;
import java.util.ArrayList;
public class Grammatik {
    ArrayList<Rule> ruleset;
    char currentLetter;
    String textFile;
    String currRule = "";
    Rule rule;

    public Grammatik(String textFile) {
        this.textFile = textFile + '.';
        initGrammatik();
    }
    public void initGrammatik(){
        ruleset = new ArrayList<>();
        addAxiom();
        addPrimitives();
        readRules();
    }

    private void addAxiom() {

        char axiom = 'K';
        String axiomRule = "K[+A][-A]";
        Rule axRule = new Rule(axiom, axiomRule);
        ruleset.add(axRule);
    }

    public void readRules() { //læser reglerne og deler dem op i i rule-letter og rule
        for (int i = 0; i < textFile.length()-1; i++) { //kører i textfilens længde
            StringBuilder buildRule = new StringBuilder();
            char current = textFile.charAt(i);
            if (current == ':') {
                currentLetter = textFile.charAt(i - 1); //her tilføjes char til venstre for ':' til currentLetter (=ruleLetter)
                //System.out.println("regel er " + currentLetter);
            }
            if (current == ',') { //hver gang current er ',' starter sendRules metoden, og buildRule nulstilles
                addRule();
                buildRule.setLength(0);
            }
            else if (textFile.charAt(i+1) != ':' && current != ':'){ //&& Character.isLetter(current)) {//hvis current ikke er til venstre for ':' OG current er et bogstav:
                buildRule.append(current); //current appendes til buildRule der er en stringBuilder
                currRule += String.valueOf(buildRule); //currRule får buildRules string //currRule får strengen fra buildRule
            }
            else if (current == '.') { // '.' stopper metoden
                return;
            }
        }
    }
    private void addRule() { //reglerne sendes. det er også her de skal gemmes
        rule = new Rule(currentLetter, currRule);
        ruleset.add(rule);
        System.out.println("ruleset er " + ruleset.get(5).getRegel());
        currRule = ""; //currRule nulstilles
    }
    public void addPrimitives(){
        char[] primitives = new char[]{'[',']','+','-'};
        for (char c :primitives) {
            Rule primitive = new Rule(c);
            ruleset.add(primitive);
        }
    }
    public ArrayList<Rule> getRuleset(){
        return ruleset;
    }

}