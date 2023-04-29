/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.personal.confbean.SNSConsts;
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SearchTaskOneByOne
/*    */ {
/* 10 */   private static final SearchTaskOneByOne instance = new SearchTaskOneByOne();
/*    */   
/*    */   public static SearchTaskOneByOne getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/* 17 */   private final TaskOneByOne oneByOne = new TaskOneByOne(SNSConsts.getInstance().SEARCH_QUEUE_SIZE);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean addTask(SearchBaseProcedure p)
/*    */   {
/* 25 */     if (!this.oneByOne.add(p))
/*    */     {
/* 27 */       GameServer.logger().error(String.format("[personal]SearchTaskOneByOne.addTask@one by one add failed|max_queue_size=%d", new Object[] { Integer.valueOf(SNSConsts.getInstance().SEARCH_QUEUE_SIZE) }));
/*    */       
/*    */ 
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onTaskDone() {}
/*    */   
/*    */ 
/*    */   public int taskSize()
/*    */   {
/* 43 */     return this.oneByOne.size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\SearchTaskOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */