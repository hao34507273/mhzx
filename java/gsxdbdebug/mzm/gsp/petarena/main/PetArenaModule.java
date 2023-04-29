/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Petarenarank;
/*    */ import xtable.Petarenarankbackup;
/*    */ 
/*    */ public class PetArenaModule implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     PetArenaManager.init();
/* 17 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 41 */     List<Table> tables = new ArrayList();
/* 42 */     tables.add(xtable.Role2petarenainfo.getTable());
/* 43 */     tables.add(Petarenarank.getTable());
/* 44 */     tables.add(Petarenarankbackup.getTable());
/* 45 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 51 */     return new PPetArenaMerge().call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */