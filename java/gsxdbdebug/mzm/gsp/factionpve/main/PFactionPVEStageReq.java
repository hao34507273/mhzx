/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionPVETmp;
/*    */ import xtable.Factionpve_tmp;
/*    */ 
/*    */ 
/*    */ public class PFactionPVEStageReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PFactionPVEStageReq(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     Gang faction = GangInterface.getGang(this.roleid, false);
/*    */     
/* 25 */     if (faction == null) {
/* 26 */       FactionPVEManager.sendFactionPVEStage(this.roleid, null);
/* 27 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 31 */     FactionPVETmp xFactionPVETmp = Factionpve_tmp.select(Long.valueOf(faction.getGangId()));
/*    */     
/* 33 */     FactionPVEManager.sendFactionPVEStage(this.roleid, xFactionPVETmp);
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\PFactionPVEStageReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */