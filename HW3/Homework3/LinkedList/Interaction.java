package LinkedList;
import java.util.LinkedList;

class Interaction
{
    private int interactionId;
    private int accountId;
    private int postId;
    private LinkedList<Account> account;
    /**
     * 
     * @param interactionId
     * @param accountId
     * @param postId
     * @param account
     */
    protected Interaction(int interactionId, int accountId, int postId, LinkedList<Account> account)
    {
        this.interactionId = interactionId;
        this.accountId = accountId;
        this.postId = postId;
        this.account = account;
        
    }
    /** */

    protected void interect()
    {
        // check if the account is viewed the post
        if (!account.get(accountId).isViewedPost())
        {
            System.out.println("You must view the post to interact with it.");
            return;
        }
        String tempPost = "";
        
        LinkedList<String> tempLikes = new LinkedList<String>();
        LinkedList<String> tempComment = new LinkedList<String>();
        LinkedList<String> tempCommetsUsers = new LinkedList<String>();

        // find the post with the given accountId and postId
        for (int i = 0; i < account.size(); i++)
        {
            if (account.get(i) != null)
            {
                for (int j = 0; j < account.get(i).getPost().size(); j++)
                {
                    if (account.get(i).getPost().get(j) != null && account.get(i).getPost().get(j).getPostId() == postId)
                    {
                        tempPost = account.get(i).getPost().get(j).getContent();
                        for (int k = 0; k < account.get(i).getPost().get(j).getLikes().size(); k++)
                        {
                            tempLikes.add(account.get(account.get(i).getPost().get(j).getLikes().get(k)).getUserName());
                        }
                        for (int k = 0; k < account.get(i).getPost().get(j).getComments().size(); k++)
                        {
                            tempComment.add(account.get(i).getPost().get(j).getComments().get(k));
                            tempCommetsUsers.add(account.get(account.get(i).getPost().get(j).getCommetsUsers().get(k)).getUserName());
                        }
                    }
                }
            }
        }

        System.out.println("(PostId: " + postId + ") " + tempPost);

        if (!tempLikes.isEmpty())
        {
            System.out.print("Likes: ");
            for (int i = 0; i < tempLikes.size(); i++)
            {
                System.out.print(tempLikes.get(i));
                if (i != tempLikes.size() - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        else
        {
            System.out.println("Likes: 0");
        }

        if (!tempComment.isEmpty())
        {
            System.out.println("Comments: ");
            for (int i = 0; i < tempComment.size(); i++)
            {
                System.out.println(tempCommetsUsers.get(i) + ": " + tempComment.get(i));
            }
        }
        else
        {
            System.out.println("Comments: 0");
        }
    }

    // Getters and Setters
    /**
     * 
     * @return
     */
    int getInteractionId()
    {
        return interactionId;
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
    int getPostId()
    {
        return postId;
    }
    /**
     * 
     * @return
     */
    LinkedList<Account> getAccount()
    {
        return account;
    }

}