/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2privilege;
/*    */ import xtable.User2loginprivileges;
/*    */ 
/*    */ public class GrcModule implements mzm.event.Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 15 */     GrcManager.init();
/*    */     
/* 17 */     InviteFriendsManager.init();
/*    */     
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
/* 44 */     tables.add(Role2privilege.getTable());
/* 45 */     tables.add(User2loginprivileges.getTable());
/* 46 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\GrcModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */