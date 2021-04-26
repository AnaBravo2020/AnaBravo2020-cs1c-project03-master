package stacks;


public class Navigator {
//Attributes:

//Current webpage the user is viewing
    private String currentLink;

//Stack one for "Back" button links; stack two for "Forward" button links
    private final StackList<String> backLinks;
    private final StackList<String> forwardLinks;

    boolean myString = true; // keeps track of whether it is the first string or not

//Methods:
    Navigator() {
//initializing empty string
        currentLink = "";
//initializing backLinks
        backLinks = new StackList<String>();
//initializing forwardLinks
        forwardLinks = new StackList<String>();
    }

    public void setCurrentLink(String currentLink) {
        if (myString) {
            //currentLink to supplied address
            this.currentLink = currentLink;
            myString = false;

        } else {
            this.currentLink = currentLink;
            backLinks.push(this.currentLink);
            forwardLinks.clear();
        }
    }

    public void goBack() {
//checks if there is a link on backLinks
//if there is no link
        if (backLinks.isEmpty()) {
            System.out.print("No links on stack");
        } else {
//pushes old currentLink onto forwardLinks stack
            forwardLinks.push(currentLink);
            this.currentLink = backLinks.pop();
        }

    }

    public void goForward() {
//checks if there is a link on the forwardLinks stack using isEmpty() method
//if there is no link
        if (forwardLinks.isEmpty()) {
            System.out.print("No links on stack");
        } else {
//push old currentLink to the backLinks
            backLinks.push(currentLink);
            this.currentLink = forwardLinks.pop();
        }

    }

    public String getCurrentLink() {
        return currentLink;
    }

//The accessor method for the whole backLinks stack

    public StackList<String> getBackLinks() {
        return backLinks;
    }

//The accessor method for the whole forwardLinks stack

    public StackList<String> getForwardLinks() {
        return forwardLinks;
    }

}