/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fight.event.RoleObserveEnd;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2observefight;
/*    */ 
/*    */ public class ClearObserverProcedure extends LogicProcedure
/*    */ {
/*    */   private Set<Long> observerRoleids;
/*    */   
/*    */   public ClearObserverProcedure(Set<Long> observerRoleids)
/*    */   {
/* 17 */     this.observerRoleids = observerRoleids;
/*    */   }
/*    */   
/*    */   public ClearObserverProcedure(long roleid) {
/* 21 */     this.observerRoleids = new java.util.HashSet();
/* 22 */     this.observerRoleids.add(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     if (this.observerRoleids.size() <= 0) {
/* 28 */       return false;
/*    */     }
/* 30 */     lock(Basic.getTable(), this.observerRoleids);
/* 31 */     for (Iterator i$ = this.observerRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 32 */       Role2observefight.remove(Long.valueOf(roleid));
/* 33 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 10);
/*    */       
/* 35 */       RoleObserveEnd roleObserveEnd = new RoleObserveEnd();
/* 36 */       TriggerEventsManger.getInstance().triggerEvent(roleObserveEnd, Long.valueOf(roleid));
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\ClearObserverProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */