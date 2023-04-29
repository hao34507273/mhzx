/*    */ package mzm.gsp.bandstand.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import xdb.Table;
/*    */ import xtable.Role2bandstandinfo;
/*    */ 
/*    */ public class BandstandModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     ActivityInterface.registerActivityByLogicType(138, new BandstandHandler(), false);
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 42 */     List<Table> tables = new ArrayList();
/* 43 */     tables.add(Role2bandstandinfo.getTable());
/* 44 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\BandstandModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */