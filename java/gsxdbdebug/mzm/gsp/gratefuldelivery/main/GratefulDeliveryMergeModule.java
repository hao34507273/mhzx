/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Table;
/*    */ import xtable.Grateful_delivery_status;
/*    */ import xtable.Role2gratefuldelivery;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GratefulDeliveryMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 23 */     List<Table> tables = new ArrayList();
/* 24 */     tables.add(Grateful_delivery_status.getTable());
/* 25 */     tables.add(Role2gratefuldelivery.getTable());
/* 26 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     if (!new PMergeGratefulDeliveryStatus(null).call())
/*    */     {
/* 34 */       MergeMain.formatLogError("GratefulDeliveryMergeModule#handleMerget()|merge GratefulDeliveryStatus failed", new Object[0]);
/* 35 */       return false;
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   private class PMergeGratefulDeliveryStatus
/*    */     extends LogicProcedure
/*    */   {
/*    */     private PMergeGratefulDeliveryStatus() {}
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 48 */       long viceZoneId = MergeMain.getViceZoneid();
/* 49 */       for (SDeliveryCfg cfg : SDeliveryCfg.getAll().values())
/*    */       {
/* 51 */         Grateful_delivery_status.remove(Long.valueOf(GameServerInfoManager.toGlobalId(cfg.activityId, viceZoneId)));
/*    */       }
/* 53 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\GratefulDeliveryMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */