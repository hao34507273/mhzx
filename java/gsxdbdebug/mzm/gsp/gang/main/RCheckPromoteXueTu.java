/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.Gang;
/*    */ import xbean.GangDutyMembers;
/*    */ 
/*    */ class RCheckPromoteXueTu extends LogicRunnable
/*    */ {
/*    */   private final long gangid;
/*    */   
/*    */   RCheckPromoteXueTu(long gangid)
/*    */   {
/* 19 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 25 */     Gang xGang = GangManager.getXGang(this.gangid, false);
/* 26 */     if (xGang == null) {
/* 27 */       return;
/*    */     }
/*    */     
/* 30 */     GangDutyMembers xMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().XUETU_ID));
/* 31 */     if (xMembers == null) {
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     long promoteid = -1L;
/* 36 */     long promoteLevel = -1L;
/*    */     
/* 38 */     for (Iterator i$ = xMembers.getMembers().iterator(); i$.hasNext();) { long xueTuId = ((Long)i$.next()).longValue();
/* 39 */       if (OnlineManager.getInstance().isOnline(xueTuId))
/*    */       {
/*    */ 
/*    */ 
/* 43 */         int level = RoleInterface.getLevel(xueTuId);
/* 44 */         if (level > promoteLevel) {
/* 45 */           promoteid = xueTuId;
/* 46 */           promoteLevel = level;
/*    */         }
/*    */       }
/*    */     }
/* 50 */     if (promoteid > 0L) {
/* 51 */       new PPromoteXueTu(this.gangid, promoteid).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RCheckPromoteXueTu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */