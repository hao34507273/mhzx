/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fight.event.RoleObserveEnd;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ObserveFight;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2observefight;
/*    */ 
/*    */ public class PSelfObserveEnd extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PSelfObserveEnd(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     ObserveFight xObserveFight = Role2observefight.select(Long.valueOf(this.roleid));
/* 24 */     if (xObserveFight == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     Fight fight = FightManager.getFight(xObserveFight.getFightid());
/* 30 */     if (fight == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     lock(Lockeys.get(Role2observefight.getTable(), Long.valueOf(this.roleid)));
/* 36 */     fight.remObserver(Arrays.asList(new Long[] { Long.valueOf(this.roleid) }), false);
/* 37 */     Role2observefight.remove(Long.valueOf(this.roleid));
/* 38 */     RoleStatusInterface.unsetStatus(this.roleid, 10);
/*    */     
/* 40 */     RoleObserveEnd roleObserveEnd = new RoleObserveEnd();
/* 41 */     TriggerEventsManger.getInstance().triggerEvent(roleObserveEnd, Long.valueOf(this.roleid));
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PSelfObserveEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */