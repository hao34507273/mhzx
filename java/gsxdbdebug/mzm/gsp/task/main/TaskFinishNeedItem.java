/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskFinishNeedItem
/*    */ {
/*    */   private Map<Integer, Integer> itemMap;
/*    */   private Map<Integer, Integer> itemConMap;
/*    */   
/*    */   public TaskFinishNeedItem()
/*    */   {
/* 19 */     this.itemConMap = new HashMap();
/* 20 */     this.itemMap = new HashMap();
/*    */   }
/*    */   
/*    */   public Map<Integer, Integer> getItemMap()
/*    */   {
/* 25 */     return this.itemMap;
/*    */   }
/*    */   
/*    */   public Map<Integer, Integer> getItemConMap()
/*    */   {
/* 30 */     return this.itemConMap;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskFinishNeedItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */