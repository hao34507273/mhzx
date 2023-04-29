/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Groups;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GroupModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 32 */     GroupManager.init();
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 45 */     return Arrays.asList(new Table[] { Role2groupinfo.getTable(), Groups.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\GroupModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */