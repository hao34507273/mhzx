/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.RoleLessCold1;
/*    */ 
/*    */ public class POnPVPFightStart extends mzm.gsp.fight.event.PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*    */     long cutTime;
/*    */     Iterator i$;
/* 14 */     if ((((PVPFightStartArg)this.arg).context instanceof RobMarrageFightContext)) {
/* 15 */       RobMarrageFightContext robMarrageFightContext = (RobMarrageFightContext)((PVPFightStartArg)this.arg).context;
/* 16 */       long roleid = robMarrageFightContext.roleid;
/*    */       
/*    */ 
/* 19 */       lock(xtable.Role2marriage.getTable(), ((PVPFightStartArg)this.arg).getAllRoles());
/*    */       
/* 21 */       xbean.MarriageParades xMarriageParades = xtable.Marriageparade.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 22 */       MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 23 */       long roleid1 = xMarriageParade.getRoleid1();
/* 24 */       long roleid2 = xMarriageParade.getRoleid2();
/* 25 */       if ((roleid1 != roleid) && (roleid2 != roleid)) {
/* 26 */         mzm.gsp.GameServer.logger().info(String.format("POnPVPFightStart.processImp@pvp战斗玩家id错误!!|roleid=%d|roleid1=%d|roleid2=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(roleid1), Long.valueOf(roleid2) }));
/*    */         
/*    */ 
/* 29 */         return false;
/*    */       }
/*    */       
/* 32 */       mzm.gsp.marriage.SSynMarrageParadeAttackRes marrageParadeAttackRes = new mzm.gsp.marriage.SSynMarrageParadeAttackRes();
/* 33 */       marrageParadeAttackRes.attackedstate = 1;
/*    */       
/* 35 */       if (robMarrageFightContext.brideFight) {
/* 36 */         int totalState = MarriageManager.setFightStatus(1, xMarriageParade.getBridefightstatus());
/*    */         
/* 38 */         xMarriageParade.setBridefightstatus(totalState);
/*    */         
/* 40 */         marrageParadeAttackRes.paraderoletype = 0;
/*    */       } else {
/* 42 */         int totalState = MarriageManager.setFightStatus(1, xMarriageParade.getGroomfightstatus());
/*    */         
/* 44 */         xMarriageParade.setGroomfightstatus(totalState);
/*    */         
/* 46 */         marrageParadeAttackRes.paraderoletype = 1;
/*    */       }
/*    */       
/*    */ 
/* 50 */       mzm.gsp.map.main.MapInterface.brocadCastInSomebodyView(roleid, marrageParadeAttackRes, false);
/*    */       
/* 52 */       cutTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 53 */       for (i$ = ((PVPFightStartArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long activeRoleid = ((Long)i$.next()).longValue();
/* 54 */         RoleLessCold1 xRoleLessCold1 = xtable.Role2lesscold1.get(Long.valueOf(activeRoleid));
/* 55 */         if (xRoleLessCold1 == null) {
/* 56 */           xRoleLessCold1 = xbean.Pod.newRoleLessCold1();
/* 57 */           xRoleLessCold1.setRobparadetime(cutTime);
/* 58 */           xtable.Role2lesscold1.insert(Long.valueOf(activeRoleid), xRoleLessCold1);
/*    */         }
/* 60 */         xRoleLessCold1.setRobparadecount(xRoleLessCold1.getRobparadecount() + 1);
/*    */       }
/*    */     }
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */