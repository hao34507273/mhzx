/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Advert;
/*    */ import xtable.Nonerealtimesnsroles;
/*    */ import xtable.Role2personal;
/*    */ 
/*    */ public class PersonalModule implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     SNSManager.init();
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
/* 43 */     tables.add(Role2personal.getTable());
/* 44 */     tables.add(Advert.getTable());
/* 45 */     tables.add(Nonerealtimesnsroles.getTable());
/* 46 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 52 */     return new PSnsMerge().call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PersonalModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */