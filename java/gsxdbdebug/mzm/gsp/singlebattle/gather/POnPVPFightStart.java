/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleFightContext;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class POnPVPFightStart
/*    */   extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!(((PVPFightStartArg)this.arg).context instanceof SingleBattleFightContext))
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     Set<Long> allFightRoleIds = new HashSet();
/* 22 */     allFightRoleIds.addAll(((PVPFightStartArg)this.arg).activeRoles);
/* 23 */     allFightRoleIds.addAll(((PVPFightStartArg)this.arg).passiveRoles);
/*    */     
/* 25 */     for (Iterator i$ = allFightRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 27 */       if (RoleStatusInterface.containsStatus(roleId, 1516))
/*    */       {
/*    */ 
/*    */ 
/* 31 */         new PStopBattleGather(roleId, 1).execute(); }
/*    */     }
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */