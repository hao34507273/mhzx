/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*    */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*    */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*    */ import xdb.Table;
/*    */ import xtable.Itemsubid2count;
/*    */ import xtable.Role2itemsubid;
/*    */ 
/*    */ public class AwardPoolMerger implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/* 22 */     tables.add(Role2itemsubid.getTable());
/* 23 */     tables.add(Itemsubid2count.getTable());
/* 24 */     tables.add(xtable.Role2weightcorrectioncount.getTable());
/* 25 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     return new Merge_Itemsubid2count_Pro(null).call();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class Merge_Itemsubid2count_Pro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       long viceZoneId = MergeMain.getViceZoneid();
/*    */       
/* 44 */       List<Long> viceKeys = new ArrayList();
/*    */       
/* 46 */       for (SItemPoolSub cfg : SItemPoolSub.getAll().values())
/*    */       {
/* 48 */         SPreciousDropCfg preciousDropCfg = SPreciousDropCfg.get(cfg.preciousCfgId);
/* 49 */         if (preciousDropCfg != null)
/*    */         {
/*    */ 
/* 52 */           long viceKey = GameServerInfoManager.toGlobalId(cfg.id, viceZoneId);
/* 53 */           viceKeys.add(Long.valueOf(viceKey));
/*    */         }
/*    */       }
/*    */       
/* 57 */       for (SRandomTextTableCfg cfg : SRandomTextTableCfg.getAll().values())
/*    */       {
/*    */ 
/* 60 */         SPreciousDropCfg preciousDropCfg = SPreciousDropCfg.get(cfg.preciousCfgId);
/* 61 */         if (preciousDropCfg != null)
/*    */         {
/*    */ 
/* 64 */           long viceKey = GameServerInfoManager.toGlobalId(cfg.id, viceZoneId);
/* 65 */           viceKeys.add(Long.valueOf(viceKey));
/*    */         }
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 71 */       lock(Itemsubid2count.getTable(), viceKeys);
/*    */       
/* 73 */       for (Iterator i$ = viceKeys.iterator(); i$.hasNext();) { long viceKey = ((Long)i$.next()).longValue();
/*    */         
/* 75 */         Itemsubid2count.remove(Long.valueOf(viceKey));
/*    */       }
/* 77 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\AwardPoolMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */