package Homework1;
class Message
{
    private int messageId;
    private int senderId;
    private int receiverId;
    private String content;
    /**
     * 
     * @param messageId
     * @param content
     */
    protected Message(int messageId,String content)
    {
        this.messageId = messageId;
        this.content = content;
    }
    /**
     * 
     * @param acc1
     * @param acc2
     */
    protected void sendMessage(Account acc1, Account acc2)
    {
        boolean isFollowing = false;

        // check if the sender blocked the receiver
        for (int i = 0; i < acc2.getBlocksUser().length; i++)
        {
            if (acc2.getBlocksUser()[i] != null && acc2.getBlocksUser()[i].equals(acc1))
            {
                System.out.println("You can't send message to " + acc2.getUserName() + " because you blocked him/her.");
                return;
            }
        }

        for (int i = 0; i < acc1.getFollowing().length; i++)
        {
            if (acc1.getFollowing()[i] != null && acc1.getFollowing()[i].equals(acc2.getUserName()))
            {
                isFollowing = true;
                break;
            }
        }
        if (isFollowing && acc1.isLogged())
        {
            // add message to sender's outbox
            for (int i = 0; i < acc1.getOutbox().length; i++)
            {
                if (acc1.getOutbox()[i] == null)
                {
                    acc1.getOutbox()[i] = "Messagge: " + content + " (to " + acc2.getUserName() + ")";
                    break;
                }
            }
            
            // add message to receiver's inbox

            for (int i = 0; i < acc2.getInbox().length; i++)
            {
                if (acc2.getInbox()[i] == null)
                {
                    acc2.getInbox()[i] = "Messagge: "+ content + " (from " + acc1.getUserName() + ")";
                    break;
                }
            }
            senderId = acc1.getId();
            receiverId = acc2.getId();
        }
    }

    // Getters and Setters
    /**
     * 
     * @return
     */
    int getMessageId()
    {
        return messageId;
    }
    /**
     * 
     * @return
     */
    int getSenderId()
    {
        return senderId;
    }
    /**
     * 
     * @return
     */
    int getReceiverId()
    {
        return receiverId;
    }
    /**
     * 
     * @return
     */
    String getContent()
    {
        return content;
    }

}