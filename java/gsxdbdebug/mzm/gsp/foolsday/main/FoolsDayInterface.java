/*    */ package mzm.gsp.foolsday.main;
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
/*    */ public class FoolsDayInterface
/*    */ {
/*    */   public static boolean synAddChestByIdip(long roleid, int activityCfgid, int buffid)
/*    */   {
/* 19 */     return new PAddChestByIdip(roleid, activityCfgid, buffid).call();
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
/*    */   public static void asynAddChestByIdip(long roleid, int activityCfgid, int buffid)
/*    */   {
/* 35 */     new PAddChestByIdip(roleid, activityCfgid, buffid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\FoolsDayInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */