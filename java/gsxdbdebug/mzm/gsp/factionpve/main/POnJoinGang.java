/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.JoinGangProcedure;
/*    */ import xbean.FactionPVE;
/*    */ import xbean.FactionPVETmp;
/*    */ 
/*    */ public class POnJoinGang
/*    */   extends JoinGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(((GangArg)this.arg).gangId);
/* 14 */     FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(((GangArg)this.arg).gangId);
/*    */     
/* 16 */     FactionPVEManager.checkAndInitXFactionPVEAndXFactionPVETmp(xFactionPVE, xFactionPVETmp);
/*    */     
/*    */ 
/* 19 */     FactionPVEManager.syncStartTime(((GangArg)this.arg).roleId, xFactionPVE);
/*    */     
/*    */ 
/* 22 */     FactionPVEManager.sendFactionPVETimes(((GangArg)this.arg).roleId, xFactionPVE);
/*    */     
/*    */ 
/* 25 */     FactionPVEManager.sendFactionPVEStage(((GangArg)this.arg).roleId, xFactionPVETmp);
/*    */     
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */