/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Campaigncharts;
/*    */ import xtable.Menpaistarchart;
/*    */ import xtable.Role2menpaistarcampaign;
/*    */ 
/*    */ public class MenPaiStarModule implements mzm.event.Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     MenPaiStarManager.init();
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
/* 42 */     tables.add(Role2menpaistarcampaign.getTable());
/* 43 */     tables.add(xtable.Role2menpaistarvote.getTable());
/*    */     
/* 45 */     tables.add(xtable.Menpaistar.getTable());
/* 46 */     tables.add(Campaigncharts.getTable());
/* 47 */     tables.add(Menpaistarchart.getTable());
/* 48 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 54 */     return new PMenPaiStarMerge().call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\MenPaiStarModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */