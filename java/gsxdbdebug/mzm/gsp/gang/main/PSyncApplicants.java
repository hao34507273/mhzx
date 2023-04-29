/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import xtable.Gangmemory;
/*    */ 
/*    */ class PSyncApplicants extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gangid;
/*    */   
/*    */   PSyncApplicants(long roleid, long gangid) {
/* 11 */     this.roleid = roleid;
/* 12 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     xbean.GangMemoryBean xMemory = Gangmemory.select(Long.valueOf(this.gangid));
/* 19 */     if (xMemory == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     GangManager.syncApplicants(xMemory, this.roleid);
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSyncApplicants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */