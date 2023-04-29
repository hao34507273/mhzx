/*    */ package mzm.gsp.compensate.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Systemcompensate;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompensateModule
/*    */   implements Module, PostModuleInitListner, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
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
/*    */ 
/*    */ 
/*    */   public void postInit() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 49 */     List<Table> tables = new ArrayList();
/* 50 */     tables.add(Systemcompensate.getTable());
/* 51 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 57 */     return new PMergeSystemcompensate().call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\compensate\main\CompensateModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */