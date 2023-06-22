package Homework1;
class Interaction
{
    private int interactionId;
    private int accountId;
    private int postId;
    private Account[] account;
    /**
     * 
     * @param interactionId
     * @param accountId
     * @param postId
     * @param account
     */
    protected Interaction(int interactionId, int accountId, int postId, Account[] account)
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
        if (!account[accountId].isViewedPost())
        {
            System.out.println("You must view the post to interact with it.");
            return;
        }
        String tempPost = "";
        String[] tempLikes = new String[0];
        String[] tempComment = new String[0];
        String[] tempCommetsUsers = new String[0];

        // find the post with the given accountId and postId
        for (int i = 0; i < account.length; i++)
        {
            if (account[i] != null)
            {
                for (int j = 0; j < account[i].getPost().length; j++)
                {
                    if (account[i].getPost()[j] != null && account[i].getPost()[j].getAccountId() == accountId && account[i].getPost()[j].getPostId() == postId)
                    {
                        tempPost = account[i].getPost()[j].getContent();
                        if (account[i].getPost()[j].getLikes() != null)
                        {
                            tempLikes = new String[account[i].getPost()[j].getLikes().length];

                            for (int k = 0; k < account[i].getPost()[j].getLikes().length; k++)
                            {
                                tempLikes[k] = account[account[i].getPost()[j].getLikes()[k]].getUserName();
                            }
                        }

                        if (account[i].getPost()[j].getComments() != null)
                        {
                            tempComment = new String[account[i].getPost()[j].getComments().length];
                            tempCommetsUsers = new String[account[i].getPost()[j].getComments().length];

                            for (int k = 0; k < account[i].getPost()[j].getComments().length; k++)
                            {
                                tempComment[k] = account[i].getPost()[j].getComments()[k];
                                tempCommetsUsers[k] = account[account[i].getPost()[j].getCommetsUsers()[k]].getUserName();
                            }

                        }
                    }
                }
            }
        }

        System.out.println("(PostId: " + postId + ") " + tempPost);

        if(tempLikes.length == 0)
            System.out.println("Like: 0");
        for(int i = 0; i < tempLikes.length; i++)
        {
            if(tempLikes[i] != null)
                System.out.println("Like: " + tempLikes[i]);
            
        }
        if(tempComment.length == 0)
            System.out.println("Comment: 0");
        for(int i = 0; i < tempComment.length; i++)
        {
            if(tempComment[i] != null)
                System.out.println("Comment: " + tempComment[i] + " by " + tempCommetsUsers[i]);
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
    Account[] getAccount()
    {
        return account;
    }

}