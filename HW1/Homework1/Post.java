package Homework1;
class Post
{
    private int postId;
    private int accountId;
    private String content;
    private String[] comments = new String[0];
    private int[] likes = new int[0];
    private int[] commetsUsers = new int[0];
    private int likeCount;
    /**
     * 
     * @param postId
     * @param accountId
     * @param content
     * @param comments
     * @param likes
     */
    protected Post(int postId, int accountId, String content, String[] comments, int[] likes)
    {
        this.postId = postId;
        this.accountId = accountId;
        this.content = content;
        this.comments = comments;
        this.likes = likes;
        this.likeCount = 0;
    }
    /**
     * 
     * @param like
     * @param accountID
     * @param accounts
     */
    protected void addLike(Like like , int accountID, Account[] accounts)
    {
        // check account login with the given ID
        if (!accounts[accountID].isLogged())
        {
            System.out.println("You must login to like a post.");
            return;
        }
        int[] newLikes = new int[likes.length + 1];
        for (int i = 0; i < likes.length; i++)
        {
            newLikes[i] = likes[i];
        }
        newLikes[newLikes.length - 1] = accountID;
        likes = newLikes;
        likeCount++;
    
    }
    /**
     * 
     * @param comment
     * @param accountID
     * @param accounts
     */
    protected void addComment(Comment comment, int accountID ,Account[] accounts)
    {
        // check account login with the given ID
        if (!accounts[accountID].isLogged())
        {
            System.out.println("You must login to comment a post.");
            return;
        }
        String[] newComments = new String[comments.length + 1];
        int[] newCommetsUsers = new int[commetsUsers.length + 1];
        for (int i = 0; i < comments.length; i++)
        {
            newComments[i] = comments[i];
            newCommetsUsers[i] = commetsUsers[i];
        }
        newComments[newComments.length - 1] = comment.getContent();
        newCommetsUsers[newCommetsUsers.length - 1] = accountID;
        comments = newComments;
        commetsUsers = newCommetsUsers;
    }

    // Getters and Setters
    /**
     * 
     * @return
     */
    int getPostId()
    {
        return postId;
    }
    /**
     * 
     * @return
     */
    int getAccountId()
    {
        return accountId;
    }
    /**
     * 
     * @return
     */
    String getContent()
    {
        return content;
    }
    /**
     * 
     * @return
     */
    String[] getComments()
    {
        return comments;
    }
    /**
     * 
     * @return
     */
    int[] getLikes()
    {
        return likes;
    }
    /**
     * 
     * @return
     */
    int getLikeCount()
    {
        return likeCount;
    }
    /**
     * 
     * @return
     */
    int[] getCommetsUsers()
    {
        return commetsUsers;
    }
}