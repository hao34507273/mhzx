/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMemoryBean;
/*    */ import xbean.RoleApplyGang;
/*    */ import xtable.Gangmemory;
/*    */ 
/*    */ class PRemoveJoinApplyRelation
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangid;
/*    */   private final long roleid;
/*    */   
/*    */   PRemoveJoinApplyRelation(long gangid, long roleid)
/*    */   {
/* 16 */     this.gangid = gangid;
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     RoleApplyGang xApplyGang = GangManager.getXRoleApplyGang(this.roleid, true);
/*    */     
/*    */ 
/* 26 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangid));
/* 27 */     GangMemoryBean xMemory = Gangmemory.get(Long.valueOf(this.gangid));
/*    */     
/* 29 */     GangManager.removeApplyRelationAndBroadcast(this.roleid, xApplyGang, this.gangid, xGang, xMemory);
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRemoveJoinApplyRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */