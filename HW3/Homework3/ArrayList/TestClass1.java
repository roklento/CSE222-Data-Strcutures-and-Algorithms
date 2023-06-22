package ArrayList;
import java.util.ArrayList;
class TestClass1
{
    /**
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        ArrayList<Account> accounts = new ArrayList<Account>();

        Account account1 = new Account(0, "sibelgulmez", "01.01.2000", "Sofia");
        Account account2 = new Account(1, "gokhankaya", "02.02.2000", "Madrid");
        Account account3 = new Account(2, "gizemsungu", "03.03.2000", "Berlin");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        account1.logIn(accounts);

        Post post1 = new Post(1, 0, "I like Java...", new ArrayList<String>(), new ArrayList<Integer>());
        Post post2 = new Post(2, 0, "Java the coffee...", new ArrayList<String>(), new ArrayList<Integer>());

        account1.addPost(post1, accounts);
        account1.addPost(post2, accounts);

        account1.follow(account2);
        account1.follow(account3);

        account1.logOut();

        account2.logIn(accounts);

        account2.viewProfile(account1);
        account2.viewPost(account1);

        Like like1 = new Like(post1);
        post1.addLike(like1 ,1,accounts);

        Comment comment1 = new Comment(post1, "me too!");
        post1.addComment(comment1,1, accounts);

        account2.follow(account3);
        account2.follow(account1);

        Message message1 = new Message(1, "This homework is too easy...");
        message1.sendMessage(account2, account3);
        account2.logOut();

        account3.logIn(accounts);
        
        account3.printOutbox();
        account3.printInbox();

        account3.viewProfile(account1);
        account3.viewPost(account1);

        Interaction interaction1 = new Interaction(1, 0, 1, accounts);
       
        interaction1.interect();

        Interaction interaction2 = new Interaction(2, 0, 2, accounts);

        interaction2.interect();

        Like like2 = new Like(post1);
        post1.addLike(like2 ,2,accounts);

        Like like3 = new Like(post2);
        post2.addLike(like3 ,2,accounts);

        Interaction interaction3 = new Interaction(3, 0, 1, accounts);
        interaction3.interect();

        Interaction interaction4 = new Interaction(4, 0, 2, accounts);
        interaction4.interect();

        account3.logOut();

    }
}