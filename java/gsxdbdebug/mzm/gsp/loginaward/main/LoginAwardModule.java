/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2loginactivity;
/*    */ import xtable.Role2loginsignactivity;
/*    */ import xtable.Role2loginsumactivity;
/*    */ 
/*    */ public class LoginAwardModule implements mzm.event.Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     LoginActivityManager.init();
/* 17 */     LoginSumActivityManager.init();
/* 18 */     LoginSignActivityManager.init();
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 43 */     List<Table> tables = new ArrayList();
/* 44 */     tables.add(Role2loginactivity.getTable());
/* 45 */     tables.add(Role2loginsumactivity.getTable());
/* 46 */     tables.add(Role2loginsignactivity.getTable());
/*    */     
/* 48 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\LoginAwardModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */