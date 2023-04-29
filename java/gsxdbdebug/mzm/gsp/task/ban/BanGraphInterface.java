/*    */ package mzm.gsp.task.ban;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BanGraphInterface
/*    */ {
/*    */   public static boolean isGraphBan(int graphId, int banType)
/*    */   {
/* 19 */     return GraphBanManager.isGraphBan(graphId, banType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BanTaskRes banGraph(int graphId, int banType)
/*    */   {
/* 35 */     return GraphBanManager.banGraph(graphId, banType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BanTaskRes freeGraph(int graphId, int banType)
/*    */   {
/* 51 */     return GraphBanManager.freeGraph(graphId, banType);
/*    */   }
/*    */   
/*    */   public static void initCacheBanGraphInfo() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\BanGraphInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */