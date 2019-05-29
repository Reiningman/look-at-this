public class Parse {

    // Assignment 2.1

    // returns true, if s is a properly parenthesized string,
    // otherwise false.  The opening parenthesis '(' is closed with
    // ')', '[' with ']', '{' with '}', and '<' with '>'.  A properly
    // parenthesized string contains either nothing, or an opening
    // parenthesis followed by a properly parenthesized string, then
    // a closing parenthesis matching the opening parenthesis, then a
    // properly parenthesized string.  Examples for properly
    // parenthesized strings are "", "()<>", "(([(<>)])){()}<{}>".
    // By contrast, "(", ")", "(a)", "()(]" are not properly
    // parenthesized.
    public static boolean parseRec(String s)
    {
        // TODO: implement this method using recursion
        String t = doesThings(s, "");
        return t.length()==0;
    }

    private static String doesThings (String s, String stack){
        if (s.length()==0) return stack;
        char c = s.charAt(0);
        char e = 0;
        if (stack.length()!=0 ) {e= stack.charAt(stack.length()-1);}
        s = s.substring(1);

        if (c == '(' || c == '[' || c == '<' || c == '{') {
            stack = stack+c;
            return doesThings(s,stack);
        }
        else if ((c == ')' && e == '(') || (c == ']' &&e=='[') || (c == '>' && e == '<')  || (c == '}'&&e=='{')) {

                stack = stack.substring(0,stack.length()-1);

            return doesThings(s,stack);
        } else {
            stack =stack +"!";
            return doesThings(s,stack);
        }

    }

    private static char contraChar (char c) {
        switch (c) {
            case ')' :
                return '(';
            case '>' :
                return '<';
            case ']' :
                return '[';
            case '}' :
                return '{';
            default : return '!';
        }
    }

    // Assignment 2.2 (partly also in CharStack.java)

    // returns true, if s is a properly parenthesized string,
    // otherwise false.  See parseRec for details.
    public static boolean parseStack(String s)
    {
        char e;
        char contra;
        char c;
        CharStack stack = new CharStack();
        for (int i = 0; i < s.length() ; i++) {
            c = s.charAt(i);

            if (c == '(' || c == '[' || c == '<' || c == '{') {
                stack.push(c);
            }
            else if (c == ')'  || c == ']' || c == '>' || c == '}') {
                contra = contraChar(c);
                if (!stack.isEmpty()) {
                    e = stack.pop();
                    if (e != contra) return false;
                } else return false;

            } else {
                return false;
            }

        }
        return true;
    }

    // Fragen:

    // 1) Vergleichen Sie ParseRec mit ParseStack (+CharStack).  Was
    // war einfacher zu programmieren?  Was war einfacher zu
    // verstehen?  Waren bestimmte Aspekte in einer Variante einfacher
    // und andere in der anderen?

    // 2) Braucht ParseStack für sehr tief verschachtelte Strings mehr
    // oder weniger Speicher als ParseRec?  Begründen Sie Ihre
    // Antwort.  Eine faktisch falsche Antwort auf diese Frage ist
    // nicht so tragisch, solange die Begründung erkennen läßt, dass
    // sie sich ernsthaft damit auseinendergesetzt haben.


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
        System.out.println(parseRec("()"));
        System.out.println(parseRec("(a)"));
        System.out.println(parseRec("(]<>)"));
        System.out.println(parseRec("()<>"));
        System.out.println(parseRec("(([(<>)])){()}<{}>"));
        System.out.println();

        System.out.println(parseStack("()"));
        System.out.println(parseStack("(a)"));
        System.out.println(parseStack("(]<>)"));
        System.out.println(parseStack("()<>"));
        System.out.println(parseStack("(([(<>)])){()}<{}>"));
    }
}

