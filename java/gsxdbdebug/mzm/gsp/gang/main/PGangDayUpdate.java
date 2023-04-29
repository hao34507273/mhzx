/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ 
/*    */ 
/*    */ 
/*    */ class PGangDayUpdate
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangid;
/*    */   
/*    */   PGangDayUpdate(long gangid)
/*    */   {
/* 15 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Gang xGang = GangManager.getXGang(this.gangid, true);
/*    */     
/* 23 */     if (xGang == null) {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     GangManager.updateVitalityAndClearActiveMemberNumber(this.gangid, xGang);
/*    */     
/*    */ 
/* 31 */     GangManager.mainTainDayUpdate(this.gangid, xGang);
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGangDayUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */