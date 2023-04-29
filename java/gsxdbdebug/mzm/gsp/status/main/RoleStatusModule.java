/*    */ package mzm.gsp.status.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import xdb.TTable;
/*    */ import xtable.Gamestatus;
/*    */ 
/*    */ public class RoleStatusModule implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 12 */     Gamestatus.getTable().addListener(new RoleStatusChangedListener(), new String[] { "value", "gamestatus" });
/* 13 */     RoleStatusManager.init();
/* 14 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\RoleStatusModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */