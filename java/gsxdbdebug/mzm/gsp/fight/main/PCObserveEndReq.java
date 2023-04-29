/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fight.event.RoleObserveEnd;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.ObserveFight;
/*    */ import xtable.Role2observefight;
/*    */ 
/*    */ public class PCObserveEndReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCObserveEndReq(long roleid)
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
/* 28 */     long fightid = xObserveFight.getFightid();
/* 29 */     List<Long> remObservers = new ArrayList();
/* 30 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 31 */     if (teamId != null) {
/* 32 */       if (TeamInterface.isTeamLeader(teamId.longValue(), this.roleid, false)) {
/* 33 */         remObservers.addAll(TeamInterface.getNormalRoleList(this.roleid));
/*    */       } else {
/* 35 */         remObservers.add(Long.valueOf(this.roleid));
/*    */       }
/*    */     } else {
/* 38 */       remObservers.add(Long.valueOf(this.roleid));
/*    */     }
/*    */     
/* 41 */     Fight fight = FightManager.getFight(fightid);
/* 42 */     if (fight == null)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     lock(Role2observefight.getTable(), remObservers);
/* 48 */     fight.remObserver(remObservers, true);
/* 49 */     for (Iterator i$ = remObservers.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 50 */       Role2observefight.remove(Long.valueOf(roleid));
/* 51 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 10);
/*    */       
/* 53 */       RoleObserveEnd roleObserveEnd = new RoleObserveEnd();
/* 54 */       TriggerEventsManger.getInstance().triggerEvent(roleObserveEnd, Long.valueOf(roleid));
/*    */     }
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCObserveEndReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */