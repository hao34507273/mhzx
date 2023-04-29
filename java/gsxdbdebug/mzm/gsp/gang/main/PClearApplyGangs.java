/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ class PClearApplyGangs extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PClearApplyGangs(long roleid)
/*    */   {
/* 11 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     xbean.RoleApplyGang xApplyGang = GangManager.getXRoleApplyGang(this.roleid, true);
/*    */     
/* 18 */     if (xApplyGang == null) {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     for (Iterator i$ = xApplyGang.getGangs().iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/* 23 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new PRemoveJoinApplyRelation(gangid, this.roleid));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PClearApplyGangs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */