package LinkedList;
import java.util.LinkedList;

class Post
{
    private int postId;
    private int accountId;
    private String content;
    private LinkedList<String> comments = new LinkedList<String>();
    private LinkedList<Integer> likes = new LinkedList<Integer>();
    private LinkedList<Integer> commetsUsers = new LinkedList<Integer>();

    private int likeCount;
    /**
     * 
     * @param postId
     * @param accountId
     * @param content
     * @param comments
     * @param likes
     */
    protected Post(int postId, int accountId, String content,LinkedList<String> comments, LinkedList<Integer> likes)
    {
        this.postId = postId;
        this.accountId = accountId;
        this.content = content;
        this.comments = comments;
        this.likes = likes;
    }
    /**
     * 
     * @param like
     * @param accountID
     * @param accounts
     */
    protected void addLike(Like like , int accountID, LinkedList<Account> accounts)
    {
        // check account login with the given ID
        if (!accounts.get(accountID).isLogged())
        {
            System.out.println("You must login to like a post.");
            return;
        }
        likes.add(accountID);
        System.out.println("You liked post " + postId + " in your timeline.");
        accounts.get(accountID).setShowHistory("You liked post " + postId + " in your timeline.");
        accounts.get(accountID).addLikedPosts(like);
    }
    /**
     * 
     * @param like
     * @param accountID
     * @param accounts
     */
    protected void removeLike(Like like , int accountID, LinkedList<Account> accounts)
    {
        // check account login with the given ID
        if (!accounts.get(accountID).isLogged())
        {
            System.out.println("You must login to unlike a post.");
            return;
        }

        // no like
        if (likes.isEmpty())
        {
            System.out.println("You didn't like this post.");
            return;
        }

        for (int i = 0; i < likes.size(); i++)
        {
            if (likes.get(i) == accountID)
            {
                likes.remove(i);
                accounts.get(accountID).removeLikedPosts(like);
                accounts.get(accountID).setShowHistory("You unliked post " + postId + " in your timeline.");
                return;
            }
        }
    }
    /**
     * 
     * @param comment
     * @param accountID
     * @param accounts
     */
    protected void addComment(Comment comment, int accountID ,LinkedList<Account> accounts)
    {
        // check account login with the given ID
        if (!accounts.get(accountID).isLogged())
        {
            System.out.println("You must login to comment a post.");
            return;
        }
        comments.add(comment.getContent());
        commetsUsers.add(accountID);
        accounts.get(accountID).addCommentList(comment);
        System.out.println("You commented post " + postId + " in your timeline.");
        accounts.get(accountID).setShowHistory("You commented post " + postId + " in your timeline.");
    }
    /**
     * 
     * @param comment
     * @param accountID
     * @param accounts
     */
    protected void removeComment(Comment comment, int accountID ,LinkedList<Account> accounts)
    {
        // check account login with the given ID
        if (!accounts.get(accountID).isLogged())
        {
            System.out.println("You must login to remove a comment.");
            return;
        }
        // there is no such comment
        if (comments.isEmpty())
        {
            System.out.println("There is no such comment");
            return;
        }

        
        for (int i = 0; i < commetsUsers.size(); i++)
        {
            if (commetsUsers.get(i) == accountID)
            {
                comments.remove(i);
                commetsUsers.remove(i);
                accounts.get(accountID).removeCommentList(comment);
                accounts.get(accountID).setShowHistory("You removed your comment from post " + postId + " in your timeline.");
                return;
            }
        }
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
    LinkedList<String> getComments()
    {
        return comments;
    }
    /**
     * 
     * @return
     */
    LinkedList<Integer> getLikes()
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
    LinkedList<Integer> getCommetsUsers()
    {
        return commetsUsers;
    }
}