package LinkedList;
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
        for (int i = 0; i < acc2.getBlocksUser().size(); i++)
        {
            if (acc2.getBlocksUser().get(i) != null && acc2.getBlocksUser().get(i).equals(acc1))
            {
                System.out.println("You can't send message to " + acc2.getUserName() + " because you blocked him/her.");
                return;
            }
        }

        for (int i = 0; i < acc1.getFollowing().size(); i++)
        {
            if (acc1.getFollowing().get(i) != null && acc1.getFollowing().get(i).equals(acc2))
            {
                isFollowing = true;
                break;
            }
        }
        if (isFollowing && acc1.isLogged())
        {
            // add message to sender's outbox
           

            acc1.getOutbox().add(content + " (to " + acc2.getUserName() + ")");
            
            // add message to receiver's inbox

            acc2.getInbox().add(content + " (from " + acc1.getUserName() + ")");
            senderId = acc1.getId();
            receiverId = acc2.getId();
            System.out.println("You sent a message to " + acc2.getUserName() + ".");
            acc1.setShowHistory("You sent a message to " + acc2.getUserName() + ".");
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