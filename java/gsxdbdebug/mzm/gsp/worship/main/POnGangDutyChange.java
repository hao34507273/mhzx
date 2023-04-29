/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.event.DutyChangeProcedure;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangDutyChange
/*    */   extends DutyChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Set<Long> changeRoleIds = new HashSet();
/* 22 */     changeRoleIds.add(Long.valueOf(((GangArg)this.arg).roleId));
/* 23 */     changeRoleIds.addAll(((GangArg)this.arg).extraMemberList);
/* 24 */     Gang faction = GangInterface.getGang(((GangArg)this.arg).gangId, false);
/* 25 */     if (faction == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (!changeRoleIds.contains(Long.valueOf(faction.getBangZhuId())))
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     WorshipManager.setFactionMasterNpc(((GangArg)this.arg).gangId);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\POnGangDutyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */