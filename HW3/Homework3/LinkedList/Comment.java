package LinkedList;


class Comment extends Post
{
    
    private String content;
    /**
     * 
     * @param post
     * @param content
     */
    protected Comment (Post post, String content)
    {
        super(post.getPostId(), post.getAccountId(), post.getContent(), post.getComments(), post.getLikes());
        this.content = content;
    }
    @Override
    String getContent()
    {
        return this.content;
    }
    @Override
    int getPostId()
    {
        return super.getPostId();
    }


}