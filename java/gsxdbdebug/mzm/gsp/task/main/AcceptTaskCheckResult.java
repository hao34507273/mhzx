/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class AcceptTaskCheckResult
/*    */ {
/*    */   private boolean isCanTake;
/*    */   private List<Integer> noConId;
/*    */   
/*    */   public AcceptTaskCheckResult()
/*    */   {
/* 14 */     this.isCanTake = true;
/* 15 */     this.noConId = new ArrayList();
/*    */   }
/*    */   
/*    */   public boolean isCanTake()
/*    */   {
/* 20 */     return this.isCanTake;
/*    */   }
/*    */   
/*    */   public void setCanTake(boolean isCanTake)
/*    */   {
/* 25 */     this.isCanTake = isCanTake;
/*    */   }
/*    */   
/*    */   public List<Integer> getNoConId()
/*    */   {
/* 30 */     return this.noConId;
/*    */   }
/*    */   
/*    */   public void setNoConId(List<Integer> noConId)
/*    */   {
/* 35 */     this.noConId = noConId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\AcceptTaskCheckResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */