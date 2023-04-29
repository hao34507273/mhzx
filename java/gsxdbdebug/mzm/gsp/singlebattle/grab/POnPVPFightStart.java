/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleFightContext;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnPVPFightStart
/*    */   extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!(((PVPFightStartArg)this.arg).context instanceof SingleBattleFightContext))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     Set<Long> allFightRoleIds = new HashSet();
/* 28 */     allFightRoleIds.addAll(((PVPFightStartArg)this.arg).activeRoles);
/* 29 */     allFightRoleIds.addAll(((PVPFightStartArg)this.arg).passiveRoles);
/*    */     
/* 31 */     for (Iterator i$ = allFightRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 33 */       if (RoleStatusInterface.containsStatus(roleId, 1514))
/*    */       {
/*    */ 
/*    */ 
/* 37 */         new PStopGrab(roleId, 1).execute(); }
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */