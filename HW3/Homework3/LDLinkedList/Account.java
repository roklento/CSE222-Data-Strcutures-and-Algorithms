package LDLinkedList;

class Account 
{

    private int id;
    private String userName;
    private String birthDate;
    private String location;
    private boolean isLogged;
    private boolean isViewedProfile;
    private boolean isViewedPost;
    private LDLinkedList<Post> post = new LDLinkedList<Post>();
    private LDLinkedList<Account> followers = new LDLinkedList<Account>();
    private LDLinkedList<Account> following = new LDLinkedList<Account>();
    private LDLinkedList<String> inbox = new LDLinkedList<String>();
    private LDLinkedList<String> outbox = new LDLinkedList<String>();
    private LDLinkedList<Account> blocksUser = new LDLinkedList<Account>();
    private LDLinkedList<String> showHistory = new LDLinkedList<String>();
    private LDLinkedList<Post> likedPosts = new LDLinkedList<Post>();
    private LDLinkedList<Comment> comments = new LDLinkedList<Comment>();
    
   
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

    protected void addPost(Post post ,LDLinkedList<Account> accounts) 
    {
        if(this.isLogged())
        {
            //if post is already added
            for (int i = 0; i < this.post.size(); i++) 
            {
                if (this.post.get(i) != null && this.post.get(i).getPostId() == post.getPostId()) 
                {
                    System.out.println("Post already added!");
                    return;
                }
            }
            // if post is already added to another account
            for (int i = 0; i < accounts.size(); i++) 
            {
                if (accounts.get(i) != null) 
                {
                    for (int j = 0; j < accounts.get(i).getPost().size(); j++) 
                    {
                        if (accounts.get(i).getPost().get(j) != null && accounts.get(i).getPost().get(j).getPostId() == post.getPostId()) 
                        {
                            System.out.println("Post already added to another account!");
                            return;
                        }
                    }
                }
            }
            // add post
            this.post.add(post);
            System.out.println("Post added! -> " + post.getContent());
            this.setShowHistory("Post added! -> " + post.getContent());
        }
        else
        {
            System.out.println("You are not logged in!");
        }
        
    }
    /** */
    protected void printPosts() 
    {
        if (this.isLogged()) 
        {
            for (int i = 0; i < this.post.size(); i++) 
            {
                if (this.post.get(i) != null) 
                {
                    System.out.println(this.post.get(i).getContent());
                }
            }
        }
    }
    /** */
    protected void printInbox() 
    {
        if (this.isLogged()) 
        {
            if(this.inbox.isEmpty())
            {
                System.out.println("Inbox is empty!");
                return;
            }
            for (String i : this.inbox)
                System.out.println("Inbox -> " + i);
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
        if (this.isLogged()) 
        {
            if(this.outbox.isEmpty())
            {
                System.out.println("Outbox is empty!");
                return;
            }
            for (String i : this.outbox)
                System.out.println("Outbox -> " + i);
            
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
            for (int i = 0; i < follower.blocksUser.size(); i++) 
            {
                if (follower.blocksUser.get(i) != null && follower.blocksUser.get(i).equals(this)) 
                {
                    System.out.println("You are blocked by " + follower.getUserName());
                    return;
                }
            }

            for (int i = 0; i < this.blocksUser.size(); i++) 
            {
                if (this.blocksUser.get(i) != null && this.blocksUser.get(i).equals(follower)) 
                {
                    System.out.println("You have blocked " + follower.getUserName());
                    return;
                }
            }
            // if follower is already added
            for (int i = 0; i < this.following.size(); i++) 
            {
                if (this.following.get(i) != null && this.following.get(i).equals(follower)) 
                {
                    System.out.println("You are already following " + follower.getUserName());
                    return;
                }
            }

            // account cant not be followed by itself
            if (this.equals(follower)) 
            {
                System.out.println("You can not follow yourself!");
                return;
            }
            
            this.following.add(follower);
            follower.followers.add(this);
            System.out.println("You are now following " + follower.getUserName());
            this.setShowHistory("You are now following " + follower.getUserName());

        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }

    // create unfollow method
    /**
     * 
     * @param follower
     */
    protected void unfollow(Account follower) 
    {
        if(this.isLogged())
        {

            for (int i = 0; i < this.following.size(); i++) 
            {
                if (this.following.get(i) != null && this.following.get(i).equals(follower)) 
                {
                    this.following.remove(i);
                    follower.followers.remove(this);
                    System.out.println("You are not following " + follower.getUserName() + " anymore");
                    this.setShowHistory("You are not following " + follower.getUserName() + " anymore");
                    return;
                }
            }
            System.out.println("You are not already following " + follower.getUserName());
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }

    /** */    
    protected void printFollowers() 
    {
        if (this.isLogged()) 
        {
            if(!this.followers.isEmpty())
            {
                
                for (int i = 0; i < this.followers.size(); i++) 
                {
                    System.out.println(this.getUserName() + " Followers -> " +  ": " + this.followers.get(i).getUserName());
                }
            }
            else
            {
                System.out.println("You have no followers!");
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
            if(!this.following.isEmpty())
            {
                for (int i = 0; i < this.following.size(); i++) 
                {
                    System.out.println(this.getUserName() + " Following -> " +  ": " + this.following.get(i).getUserName());
                }
            }
            else
            {
                System.out.println("You are not following anyone!");
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
    protected void logIn(LDLinkedList<Account> account) 
    {
        // all accounts are viewedPrfile and  viewedPost set false
        for (int i = 0; i < account.size(); i++) 
        {
            if (account.get(i) != null) 
            {
                account.get(i).setViewedProfile(false);
                account.get(i).setViewedPost(false);
            }
        }
        // nobody is logged in
        boolean nobodyIsLogged = true;
        for (int i = 0; i < account.size(); i++) 
        {
            if (account.get(i) != null && account.get(i).isLogged()) 
            {
                nobodyIsLogged = false;
                break;
            }
            
        }
        if(nobodyIsLogged)
        {
            this.isLogged = true;
            System.out.println("Logged in-> " + this.getUserName());
            this.setShowHistory("Logged in-> " + this.getUserName());
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
            this.setShowHistory("Logged out-> " + this.getUserName());

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
            if(!account.blocksUser.isEmpty())
            {
                for(int i = 0; i < account.blocksUser.size(); i++)
                {
                    if(account.blocksUser.get(i).equals(this))
                    {
                        System.out.println("You are blocked by this account!");
                        return;
                    }
                }
            }
            System.out.println("ID: " + account.getId());
            System.out.println("Username: " + account.getUserName());
            System.out.println("Birthdate: " + account.getBirthDate());
            System.out.println("Location: " + account.getLocation());

           
            System.out.println(account.getUserName() + " is following " + account.getFollowing().size() + " account(s)" + " and has " + account.getFollowers().size() + " follower(s)");

            //print followers name
            if(account.getFollowers().isEmpty())
                System.out.print("Followers: 0");
            else
                System.out.print("Followers: ");
            for (int i = 0; i < account.getFollowers().size(); i++) 
            {
                if (account.getFollowers().get(i) != null) 
                {
                    System.out.print (account.getFollowers().get(i).getUserName() +  " ");
                }
            }
            System.out.println();

            //print following name
            if(account.getFollowing().isEmpty())
                System.out.print("Following: 0");
            else
                System.out.print("Following: ");

            for (int i = 0; i < account.getFollowing().size(); i++) 
            {
                if (account.getFollowing().get(i) != null) 
                {
                    System.out.print(account.getFollowing().get(i).getUserName() + " ");
                }
            }
            System.out.println();
            
            //pring number of posts

            int postCount = 0;
            for (int i = 0; i < account.getPost().size(); i++) 
            {
                if (account.getPost().get(i) != null) 
                {
                    postCount++;
                }
            }
            System.out.println(account.getUserName() + " has " + postCount + " post(s)");
            account.setViewedProfile(true);
            this.setShowHistory("viewProfile: " + account.getUserName());
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
            for (int i = 0; i < account.getPost().size(); i++) 
            {
                if (account.getPost().get(i) != null) 
                {
                    System.out.println("(PostID: " + account.getPost().get(i).getPostId() + ") " + account.getUserName() + ": " + account.getPost().get(i).getContent());
                    this.setShowHistory("viewPost: " + account.getUserName() + ": " + account.getPost().get(i).getContent());
                    
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
            // if already blocked
            if(!this.blocksUser.isEmpty())
            {
                for(int i = 0; i < this.blocksUser.size(); i++)
                {
                    if(this.blocksUser.get(i).equals(account2))
                    {
                        System.out.println("You have already blocked this account!");
                        return;
                    }
                }
            }
            // add account to blocked list
            this.blocksUser.add(account2);
            System.out.println("You have blocked " + account2.getUserName());
            this.setShowHistory("You have blocked " + account2.getUserName());
            // remove account from following list
            if(!account2.getFollowing().isEmpty())
            {
                for (int i = 0; i < account2.following.size(); i++) 
                {
                    if (account2.getFollowing().get(i).equals(this)) 
                    {
                        account2.following.remove(i);
                    }
                }
            }

            if(!account2.getFollowers().isEmpty())
            {
                for (int i = 0; i < account2.followers.size(); i++) 
                {
                    if (account2.getFollowers().get(i).equals(this)) 
                    {
                        account2.followers.remove(i);
                    }
                }
            }
            if(!this.getFollowing().isEmpty())
            {
                for (int i = 0; i < this.following.size(); i++) 
                {
                    if (this.getFollowing().get(i).equals(account2)) 
                    {
                        this.following.remove(i);
                    }
                }
            }
            if(!this.getFollowers().isEmpty())
            {
                for (int i = 0; i < this.followers.size(); i++) 
                {
                    if (this.getFollowers().get(i).equals(account2)) 
                    {
                        this.followers.remove(i);
                    }
                }
            }

        }
        else
        {
            System.out.println("You are not logged in!");
        }
            
    }

    // create a unblock method
    /**
     * 
     * @param account2
     */
    protected void unblock(Account account2)
    {
        if(this.isLogged)
        {
            // if not blocked
            if(!this.blocksUser.contains(account2))
            {
                System.out.println("You have not blocked this account!");
                return;
            }
        
            // remove account2 from blocked list
            for (int i = 0; i < this.blocksUser.size(); i++) 
            {
                if (this.blocksUser.get(i) == account2) 
                {
                    this.blocksUser.remove(i);
                    System.out.println("You unblocked " + account2.getUserName());
                    this.setShowHistory("You unblocked " + account2.getUserName());
                    break;
                }
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }
    /** */
    protected void showHistory() 
    {
        if (this.isLogged) 
        {
            System.out.println("History: ");
            
            if(!this.getShowHistory().isEmpty())
            {
                for (int i = 0; i < this.getShowHistory().size(); i++) 
                {
                    System.out.println(this.getShowHistory().get(i));
                }
            }
            else
            {
                System.out.println("No history");
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }

    /** */
    protected void showLikedPosts() 
    {
        if (this.isLogged) 
        {
            System.out.print("Liked Posts ID: ");
            if(!this.getLikedPosts().isEmpty())
            {
                for (int i = 0; i < this.getLikedPosts().size(); i++) 
                {
                    //if this element is not last element
                    if(i != this.getLikedPosts().size() - 1)
                    {
                        System.out.print(this.getLikedPosts().get(i).getPostId() + " -> ");
                    }
                    else
                    {
                        System.out.print(this.getLikedPosts().get(i).getPostId());
                    }
                }
                System.out.println();
            }
            else
            {
                System.out.println("No liked posts");
            }
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }

    /** */
    protected void showMakeComments() 
    {
        if (this.isLogged) 
        {
            System.out.println("Make Comments ID: ");
            if(!this.getComments().isEmpty())
            {
                for (int i = 0; i < this.getComments().size(); i++) 
                {
                    System.out.println("PostID: " + this.getComments().get(i).getPostId() + " -> " + this.getComments().get(i).getContent());
                }
            }
            else
            {
                System.out.println("No make comments");
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
    LDLinkedList<Post> getPost() 
    {
        return post;
    }
    /**
     * 
     * @return
     */
    LDLinkedList<Account> getFollowers()
    {
        return followers;
    }
    /**
     * 
     * @return
     */
    LDLinkedList<Account> getFollowing() 
    {
        return following;
    }
    /**
     * 
     * @return
     */
    LDLinkedList<String> getInbox() 
    {
        return inbox;
    }
    /**
     * 
     * @return
     */
    LDLinkedList<String> getOutbox() 
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
    LDLinkedList<Account> getBlocksUser() 
    {
        return blocksUser;
    }

    /**
     * 
     * 
     */
    LDLinkedList<String> getShowHistory() 
    {
        return showHistory;
    }
    /**
     * 
     * @param showHistory
     */
    void setShowHistory(String showHistory)
    {
        this.showHistory.add(showHistory);
    }

    // get liked posts
    /**
     * 
     * @return
     */
    LDLinkedList<Post> getLikedPosts()
    {
        return likedPosts;
    }
    /**
     * 
     * @param likedPosts
     */
    void addLikedPosts(Post likedPosts)
    {
        this.likedPosts.add(likedPosts);
    }

    /**
     * 
     * @param likedPosts
     */
    void removeLikedPosts(Post likedPosts)
    {
        for (int i = 0; i < this.likedPosts.size(); i++) 
        {
            if (this.likedPosts.get(i) == likedPosts) 
            {
                this.likedPosts.remove(i);
                break;
            }
        }
    }


    /**
     * 
     * @return
     */
    LDLinkedList<Comment> getComments()
    {
        return comments;
    }
    /**
     * 
     * @param comments
     */
    void addCommentList(Comment comments)
    {
        this.comments.add(comments);
    }

    /**
     * 
     * @param comments
     */
    void removeCommentList(Comment comments)
    {
        for (int i = 0; i < this.comments.size(); i++) 
        {
            if (this.comments.get(i) == comments) 
            {
                this.comments.remove(i);
                break;
            }
        }
    }


}
