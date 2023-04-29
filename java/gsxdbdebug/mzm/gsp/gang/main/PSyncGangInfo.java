/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMemoryBean;
/*    */ import xtable.Gangmemory;
/*    */ 
/*    */ class PSyncGangInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gangid;
/*    */   
/*    */   PSyncGangInfo(long roleid, long gangid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     Gang xGang = GangManager.getXGang(this.gangid, false);
/* 25 */     if (xGang == null) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     GangMemoryBean xMemoryBean = Gangmemory.select(Long.valueOf(this.gangid));
/*    */     
/* 31 */     GangManager.syncGangInfo(this.roleid, this.gangid, xGang, xMemoryBean);
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSyncGangInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */