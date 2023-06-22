package LDLinkedList;

class TestClass4
{
    /**
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        LDLinkedList<Account> accounts = new LDLinkedList<Account>();

        Account account1 = new Account(0, "sibelgulmez", "01.01.2000", "Sofia");
        Account account2 = new Account(1, "gokhankaya", "02.02.2000", "Madrid");
        Account account3 = new Account(2, "gizemsungu", "03.03.2000", "Berlin");
        Account account4 = new Account(3, "ahmetcebeci", "04.04.2000", "kirikkale");
        Account account5 = new Account(4, "yilmazcebeci", "05.05.2000", "kirikkale");
        Account account6 = new Account(5, "mehmetcebeci", "06.06.2000", "kirikkale");
        Account account7 = new Account(6, "aysecebeci", "07.07.2000", "kirikkale");
        Account account8 = new Account(7, "receptayyiperdogan", "08.08.2000", "rize");
        Account account9 = new Account(8, "kemalkiliclaroglu", "09.09.2000", "tunceli");
        Account account10 = new Account(9, "muharremince", "10.10.2000", "yalova");


        
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        accounts.add(account6);
        accounts.add(account7);
        accounts.add(account8);
        accounts.add(account9);
        accounts.add(account10);

        account1.logIn(accounts);

        Post post1 = new Post(1, 0, "I like Java...", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post2 = new Post(2, 0, "Java the coffee...", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post3 = new Post(3, 0, "Java the programming language...", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post4 = new Post(4, 0, "Java the island...", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post5 = new Post(5, 0, "Java the tea...", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post6 = new Post(6, 0, "I love C++", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post7 = new Post(7, 0, "I love C#", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post8 = new Post(8, 0, "I love Python", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post9 = new Post(9, 0, "I love Ruby", new LDLinkedList<String>(), new LDLinkedList<Integer>());
        Post post10 = new Post(10, 0, "I love JavaScript", new LDLinkedList<String>(), new LDLinkedList<Integer>());

        account1.addPost(post1, accounts);
        account1.addPost(post2, accounts);
        account1.addPost(post3, accounts);
        account1.addPost(post4, accounts);
        account1.addPost(post5, accounts);
        account1.addPost(post6, accounts);
        account1.addPost(post7, accounts);
        account1.addPost(post8, accounts);
        account1.addPost(post9, accounts);
        account1.addPost(post10, accounts);

        account1.follow(account2);
        account1.follow(account3);
        account1.follow(account4);
        account1.follow(account5);
        account1.follow(account6);
        account1.follow(account7);
        account1.follow(account8);
        account1.follow(account9);
        account1.follow(account10);

        account1.printFollowers();
        account1.printFollowing();

        account1.unfollow(account10);
        account1.unfollow(account9);

        account1.printFollowers();
        account1.printFollowing();

        Message message1 = new Message(1, "Hello, how are you?");
        message1.sendMessage(account1, account2);

        account1.printInbox();
        account1.printOutbox();

        System.out.println("--------------------------------------------------------------------------------");
        account1.showHistory();
        account1.logOut();

        System.out.println("--------------------------------------------------------------------------------");
        
        account2.logIn(accounts);
        account2.viewProfile(account1);
        account2.viewPost(account1);

        Like like1 = new Like(post1);
        post1.addLike(like1 ,1,accounts);

        Like like2 = new Like(post2);
        post2.addLike(like2 ,1,accounts);

        Like like3 = new Like(post3);
        post3.addLike(like3 ,1,accounts);

        Like like4 = new Like(post4);
        post4.addLike(like4 ,1,accounts);

        Like like5 = new Like(post5);
        post5.addLike(like5 ,1,accounts);

        Like like6 = new Like(post6);
        post6.addLike(like6 ,1,accounts);

        Like like7 = new Like(post7);
        post7.addLike(like7 ,1,accounts);

        Like like8 = new Like(post8);
        post8.addLike(like8 ,1,accounts);

        Like like9 = new Like(post9);
        post9.addLike(like9 ,1,accounts);

        Like like10 = new Like(post10);
        post10.addLike(like10 ,1,accounts);

        account2.showLikedPosts();

        post1.removeLike(like1, 1, accounts);

        account2.showLikedPosts();

        post2.removeLike(like2, 1, accounts);
        
        account2.showLikedPosts();


        System.out.println("--------------------------------------------------------------------------------");
        Comment comment1 = new Comment(post1, "me too!");
        post1.addComment(comment1,1, accounts);

        Comment comment2 = new Comment(post2, "<3");
        post2.addComment(comment2,1, accounts);

        Comment comment3 = new Comment(post3, "I like it too");
        post3.addComment(comment3,1, accounts);

        Comment comment4 = new Comment(post4, "I love it too");
        post4.addComment(comment4,1, accounts);

        account2.showMakeComments();

        post1.removeComment(comment1, 1, accounts);

        account2.showMakeComments();

        post2.removeComment(comment2, 1, accounts);

        account2.showMakeComments();


        System.out.println("--------------------------------------------------------------------------------");

        account2.follow(account1);
        account2.follow(account3);
        account2.follow(account4);
        account2.follow(account5);
        account2.follow(account6);
        account2.follow(account7);
        account2.follow(account8);
        account2.follow(account9);
        account2.follow(account10);

        account2.printFollowers();
        account2.printFollowing();
        
        account2.block(account3);

        account2.printFollowers();
        account2.printFollowing();

        account2.block(account4);

        account2.printFollowers();
        account2.printFollowing();

        account2.unblock(account3);
        account2.unblock(account4);

        account2.follow(account3);
        account2.follow(account4);

        account2.printFollowers();
        account2.printFollowing();

        
        System.out.println("--------------------------------------------------------------------------------");
        account2.printInbox();
        account2.printOutbox();

        Message message2 = new Message(2, "Fine, and you?");
        message2.sendMessage(account2, account1);

        System.out.println("--------------------------------------------------------------------------------");
        account2.showHistory();

        System.out.println("--------------------------------------------------------------------------------");

        Interaction interaction1 = new Interaction(1, 0, 1, accounts);
        interaction1.interect();

        Interaction interaction2 = new Interaction(2, 0, 2, accounts);
        interaction2.interect();

        Interaction interaction3 = new Interaction(3, 0, 3, accounts);
        interaction3.interect();
        
        account2.logOut();

    }
}