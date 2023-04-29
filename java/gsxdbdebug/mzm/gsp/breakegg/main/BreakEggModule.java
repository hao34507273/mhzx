/*    */ package mzm.gsp.breakegg.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.breakegg.invite.InviteConfirmInterface;
/*    */ import mzm.gsp.breakegg.invite.InviteManager;
/*    */ import xdb.Table;
/*    */ import xtable.Role2counter;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BreakEggModule
/*    */   implements Module, MergeModule, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 22 */     ActivityInterface.registerActivityByLogicType(127, new BreakEggActivityHandler(), false);
/*    */     
/* 24 */     InviteConfirmInterface.registerConfirmHandler(1, new BreakEggConfirmHandler());
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 49 */     List<Table> tables = new ArrayList();
/* 50 */     tables.add(Role2counter.getTable());
/* 51 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\BreakEggModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */