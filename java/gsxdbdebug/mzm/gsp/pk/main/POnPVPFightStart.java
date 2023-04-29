/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.SNotifyPKStarted;
/*    */ import xbean.RolePKInformation;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ public class POnPVPFightStart
/*    */   extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!(((PVPFightStartArg)this.arg).context instanceof PKFightContext))
/* 21 */       return false;
/* 22 */     PKFightContext context = (PKFightContext)((PVPFightStartArg)this.arg).context;
/*    */     
/*    */ 
/* 25 */     Lockeys.lock(Basic.getTable(), ((PVPFightStartArg)this.arg).activeRoles);
/*    */     
/*    */ 
/* 28 */     int mainRolePKTimes = 1;
/* 29 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 31 */       RolePKInformation xRolePKInformation = PKManager.getOrCreateRolePKInformation(roleId);
/* 32 */       xRolePKInformation.setActive_pk_times(xRolePKInformation.getActive_pk_times() + 1);
/* 33 */       if (roleId == context.mainActiveRoleId)
/* 34 */         mainRolePKTimes = xRolePKInformation.getActive_pk_times();
/* 35 */       PKStatusManager.unsetProtection(roleId);
/*    */     }
/*    */     
/*    */ 
/* 39 */     SNotifyPKStarted sNotifyPKStarted = new SNotifyPKStarted();
/* 40 */     sNotifyPKStarted.active_role_id = context.mainActiveRoleId;
/* 41 */     sNotifyPKStarted.target_role_id = context.mainTargetRoleId;
/* 42 */     OnlineManager.getInstance().sendMulti(sNotifyPKStarted, ((PVPFightStartArg)this.arg).getAllRoles());
/*    */     
/*    */ 
/* 45 */     int i = 0;
/* 46 */     long[] otherActiveRoles = { 0L, 0L, 0L, 0L };
/* 47 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 49 */       if (roleId != context.mainActiveRoleId)
/*    */       {
/* 51 */         otherActiveRoles[i] = roleId;
/* 52 */         i++;
/*    */       }
/*    */     }
/* 55 */     i = 0;
/* 56 */     long[] otherTargetRoles = { 0L, 0L, 0L, 0L };
/* 57 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).passiveRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 59 */       if (roleId != context.mainTargetRoleId)
/*    */       {
/* 61 */         otherTargetRoles[i] = roleId;
/* 62 */         i++;
/*    */       }
/*    */     }
/* 65 */     PKLogManager.tlogPKStarted(context.mainActiveRoleId, mainRolePKTimes, context.mainTargetRoleId, otherActiveRoles[0], otherActiveRoles[1], otherActiveRoles[2], otherActiveRoles[3], otherTargetRoles[0], otherTargetRoles[1], otherTargetRoles[2], otherTargetRoles[3]);
/*    */     
/*    */ 
/*    */ 
/* 69 */     PKLogManager.info(String.format("POnPVPFightStart.processImp()@pk started|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(context.mainActiveRoleId), Long.valueOf(context.mainTargetRoleId) }));
/*    */     
/*    */ 
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */