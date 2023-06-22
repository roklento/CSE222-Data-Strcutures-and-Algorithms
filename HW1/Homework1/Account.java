package Homework1;
class Account 
{

    private int id;
    private String userName;
    private String birthDate;
    private String location;
    private boolean isLogged;
    private boolean isViewedProfile;
    private boolean isViewedPost;
    private Post[] post = new Post[10];
    private String[] followers = new String[10];
    private String[] following = new String[10];
    private String[] inbox = new String[10];
    private String[] outbox = new String[10];
    private Account[] blocksUser = new Account[10];
    
   
    /**
     * 
     * @param id
     * @param userName
     * @param birthDate
     * @param location
     */
    protected Account(int id, String userName, String birthDate, String location) 
    {
        this.id = id;
        this.userName = userName;
        this.birthDate = birthDate;
        this.location = location;
        this.isLogged = false;
        this.isViewedProfile = false;
        this.isViewedPost = false;

        // print created account
        System.out.println("Account created: " + this.userName);

    }
    /**
     * 
     * @param post
     * @param accounts
     */

    protected void addPost(Post post ,Account[] accounts) 
    {
        if(this.isLogged())
        {
            //if post is already added
            for (int i = 0; i < this.post.length; i++) 
            {
                if (this.post[i] != null && this.post[i].getPostId() == post.getPostId()) 
                {
                    System.out.println("Post already added!");
                    return;
                }
            }
            // if post is already added to another account
            for (int i = 1; i < accounts.length; i++) 
            {
                if(accounts[i] != null)
                {
                    for (int j = 0; j < accounts[i].post.length; j++) 
                    {
                        if (accounts[i].post[j] != null && accounts[i].post[j].getPostId() == post.getPostId()) 
                        {
                            System.out.println("Post already added to another account!");
                            return;
                        }
                    }
                }
            }
            // add post
            for (int i = 0; i < this.post.length; i++) 
            {
                if (this.post[i] == null) 
                {
                    this.post[i] = post;
                    break;
                }
            }
        }
        
    }
    /** */
    protected void printPosts() 
    {
        if (this.isLogged()) 
        {
            for (int i = 0; i < this.post.length; i++) 
            {
                if (this.post[i] != null) 
                {
                    System.out.println(this.post[i].getContent());
                }
            }
        }
    }
    /** */
    protected void printInbox() 
    {
        boolean flag = false;
        if (this.isLogged()) 
        {
            for (int i = 0; i < this.inbox.length; i++) 
            {
                if (this.inbox[i] == null && !flag) 
                {
                    System.out.println("Inbox is empty!");
                }
                if(this.inbox[i] == null)
                {
                    break;
                }
                else
                {
                    flag = true;
                    System.out.println( "Inbox -> "+ this.inbox[i]);
                }
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }

    /**
     * 
     */

    protected void printOutbox() 
    {
        boolean flag = false;
        if (this.isLogged()) 
        {
            for (int i = 0; i < this.outbox.length; i++) 
            {
                if (this.outbox[i] == null && !flag) 
                {
                    System.out.println("Outbox is empty!");
                }
                if(this.outbox[i] == null)
                {
                    break;
                }
                else 
                {
                    flag = true;
                    System.out.println("Outbox -> " + this.outbox[i]);
                }
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }
    /**
     * 
     * @param follower
     */

    protected void follow(Account follower) 
    {
        if(this.isLogged())
        {
            for (int i = 0; i < this.followers.length; i++) 
            {
                if (this.following[i] == null && follower.followers[i] == null) 
                {
                    this.following[i] = follower.getUserName();
                    follower.followers[i] = this.getUserName();
                    System.out.println("You are now following " + follower.getUserName());
                    break;
                }
                
            }
        }
    }
        

    /** */
    protected void printFollowers() 
    {
        if (this.isLogged()) 
        {
            for (int i = 0; i < this.followers.length; i++) 
            {
                if (this.followers[i] != null) 
                {
                    System.out.println(this.followers[i]);
                }
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }

    /** */

    protected void printFollowing() 
    {
        if (this.isLogged()) 
        {
            for (int i = 0; i < this.following.length; i++) 
            {
                if (this.following[i] != null) 
                {
                    System.out.println(this.following[i]);
                }
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }
    /**
     * 
     * @param account
     */
    protected void logIn(Account[] account) 
    {
        // all accounts are viewedPrfile and  viewedPost set false
        for (int i = 0; i < account.length; i++) 
        {
            if (account[i] != null) 
            {
                account[i].setViewedProfile(false);
                account[i].setViewedPost(false);
            }
        }
        // nobody is logged in
        boolean nobodyIsLogged = true;
        for (int i = 0; i < account.length; i++) 
        {
            if (account[i] != null && account[i].isLogged()) 
            {
                nobodyIsLogged = false;
                break;
            }
            
        }
        if(nobodyIsLogged)
        {
            this.isLogged = true;
            System.out.println("Logged in-> " + this.getUserName());
        }
        else
        {
            System.out.println("You are the only one logged in!");
        }
        

    }
    /** */
    protected void logOut() 
    {
        if(this.isLogged)
        {
            this.isLogged = false;
            System.out.println("Logged out-> " + this.getUserName());

        }
        else
        {
            System.out.println("You are not logged in!");
        }
        
    }
    /**
     * 
     * @param account
     */
    protected void viewProfile(Account account) 
    {
        if (this.isLogged()) 
        {
            // if account is not blocked
            for(int i = 0; i < account.blocksUser.length; i++)
            {
                if(account.blocksUser[i] == null)
                {
                    break;
                }
                if(account.blocksUser[i].equals(this))
                {
                    System.out.println("You are blocked by this account!");
                    return;
                }
            }
            System.out.println("ID: " + account.getId());
            System.out.println("Username: " + account.getUserName());
            System.out.println("Birthdate: " + account.getBirthDate());
            System.out.println("Location: " + account.getLocation());

            int followingCount = 0;
            for (int i = 0; i < account.getFollowing().length; i++) 
            {
                if (account.getFollowing()[i] != null) 
                {
                    followingCount++;
                }
            }

            int followersCount = 0;
            for (int i = 0; i < account.getFollowers().length; i++) 
            {
                if (account.getFollowers()[i] != null) 
                {
                    followersCount++;
                }
            }
            System.out.println(account.getUserName() + " is following " + followingCount + " account(s)" + " and has " + followersCount + " follower(s)");

            //print followers name
            if(followersCount == 0)
                System.out.print("Followers: 0");
            else
                System.out.print("Followers: ");
            for (int i = 0; i < account.getFollowers().length; i++) 
            {
                if (account.getFollowers()[i] != null) 
                {
                    System.out.print (account.getFollowers()[i] +  " ");
                }
            }
            System.out.println();

            //print following name
            if(followingCount == 0)
                System.out.print("Following: 0");
            else
                System.out.print("Following: ");

            for (int i = 0; i < account.getFollowing().length; i++) 
            {
                if (account.getFollowing()[i] != null) 
                {
                    System.out.print(account.getFollowing()[i] + " ");
                }
            }
            System.out.println();
            
            //pring number of posts

            int postCount = 0;
            for (int i = 0; i < account.getPost().length; i++) 
            {
                if (account.getPost()[i] != null) 
                {
                    postCount++;
                }
            }
            System.out.println(account.getUserName() + " has " + postCount + " post(s)");
            account.setViewedProfile(true);
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }
    /**
     * 
     * @param account
     */
    protected void viewPost(Account account) 
    {
        if (this.isLogged && account.isViewedProfile()) 
        {
            for (int i = 0; i < account.getPost().length; i++) 
            {
                if (account.getPost()[i] != null) 
                {
                    System.out.println("(PostID: " + account.getPost()[i].getPostId() + ") " + account.getUserName() + ": " + account.getPost()[i].getContent());
                    
                }
            }
            account.setViewedPost(true);
        }
        else
        {
            System.out.println("You are not logged in or you haven't viewed the profile!");
        }
    }
    /**
     * 
     * @param account2
     */
    protected void block(Account account2)
    {
        if(this.isLogged)
        {
            // add account2 to blocked list
            for (int i = 0; i < this.blocksUser.length; i++) 
            {
                if (this.blocksUser[i] == null) 
                {
                    this.blocksUser[i] = account2;
                    System.out.println("You blocked " + account2.getUserName());
                    break;
                }
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
            
    }

    //Getters and Setters
    /**
     * 
     * @return
     */
    int getId() 
    {
        return id;
    }
    /**
     * 
     * @return
     */
    String getUserName() 
    {
        return userName;
    }
    /**
     * 
     * @return
     */
    String getBirthDate() 
    {
        return birthDate;
    }
    /**
     * 
     * @return
     */
    String getLocation()
    {
        return location;
    }
    /**
     * 
     * @return
     */
    Post[] getPost() 
    {
        return post;
    }
    /**
     * 
     * @return
     */
    String[] getFollowers()
    {
        return followers;
    }
    /**
     * 
     * @return
     */
    String[] getFollowing() 
    {
        return following;
    }
    /**
     * 
     * @return
     */
    String[] getInbox() 
    {
        return inbox;
    }
    /**
     * 
     * @return
     */
    String[] getOutbox() 
    {
        return outbox;
    }
    /**
     * 
     * @return
     */
    boolean isLogged() 
    {
        return isLogged;
    }
    /**
     * 
     * @return
     */
    boolean isViewedProfile() 
    {
        return isViewedProfile;
    }
    /**
     * 
     * @return
     */
    boolean isViewedPost() 
    {
        return isViewedPost;
    }
    /**
     * 
     * @param id
     */
    void setViewedProfile(boolean isViewedProfile) 
    {
        this.isViewedProfile = isViewedProfile;
    }
    /**
     * 
     * @param isViewedPost
     */
    void setViewedPost(boolean isViewedPost) 
    {
        this.isViewedPost = isViewedPost;
    }
    /**
     * 
     * @param isLogged
     */
    Account[] getBlocksUser() 
    {
        return blocksUser;
    }

}
