package ArrayList;
class Like extends Post
{   
    /**
     * 
     * @param post
     */
    protected Like (Post post)
    {
        super(post.getPostId(), post.getAccountId(), post.getContent(), post.getComments(), post.getLikes());
    }
   
}