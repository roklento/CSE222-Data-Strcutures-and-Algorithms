package Homework1;
class TestClass3
{   
    /**
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        Account[] accounts = new Account[10];

        Account account1 = new Account(1, "sibelgulmez", "01.01.2000", "Sofia");
        Account account2 = new Account(2, "gokhankaya", "02.02.2000", "Madrid");
        Account account3 = new Account(3, "gizemsungu", "03.03.2000", "Berlin");

        accounts[account1.getId()] = account1;
        accounts[account2.getId()] = account2;
        accounts[account3.getId()] = account3;

        account1.logIn(accounts);

        Post post1 = new Post(1, 1, "I like Java...", new String[] {}, new int[] {});
        Post post2 = new Post(2, 1, "Java the coffee...", new String[] {}, new int[] {});

        account1.addPost(post1, accounts);
        account1.addPost(post2, accounts);

        account1.follow(account2);
        account1.follow(account3);

        account1.logOut();

        account2.logIn(accounts);

        account2.viewProfile(account1);
        account2.viewPost(account1);

        Like like1 = new Like(post1);
        post1.addLike(like1 ,2,accounts);

        Comment comment1 = new Comment(post1, "me too!");
        post1.addComment(comment1,2, accounts);

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

        Interaction interaction1 = new Interaction(1, 1, 1, accounts);
       
        interaction1.interect();

        Interaction interaction2 = new Interaction(2, 1, 2, accounts);

        interaction2.interect();

        Like like2 = new Like(post1);
        post1.addLike(like2 ,3,accounts);

        Like like3 = new Like(post2);
        post2.addLike(like3 ,3,accounts);

        Interaction interaction3 = new Interaction(3, 1, 1, accounts);
        interaction3.interect();

        Interaction interaction4 = new Interaction(4, 1, 2, accounts);
        interaction4.interect();

        account3.logOut();

        System.out.println("TESTING 3");
        account3.logIn(accounts);

        account3.block(account1);

        account3.logOut();

        account1.logIn(accounts);

        account1.viewProfile(account3);
        Message message3 = new Message(3, "content3");
        message3.sendMessage(account1, account3);
        
        account1.logOut();

        account3.logIn(accounts);

        account3.printInbox();

        account3.printOutbox();
    }
}