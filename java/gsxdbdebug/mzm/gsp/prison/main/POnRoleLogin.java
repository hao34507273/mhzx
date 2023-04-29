/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.JailProtectInfo;
/*    */ import xbean.PrisonInfo;
/*    */ import xtable.Role2jailprotect;
/*    */ import xtable.Role2prisoninfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (PrisonInterface.isRoleInJailMap(((Long)this.arg).longValue()))
/*    */     {
/*    */ 
/* 22 */       MapInterface.setLimitPolygonMovementStatus(((Long)this.arg).longValue(), true, null);
/*    */     }
/*    */     
/* 25 */     if (PrisonInterface.isRoleInJail(((Long)this.arg).longValue()))
/*    */     {
/* 27 */       PrisonInfo xPrisonInfo = Role2prisoninfo.get((Long)this.arg);
/*    */       
/* 29 */       RoleJailStat roleJailStat = PrisonInterface.checkCanLetRoleOutOfJail(((Long)this.arg).longValue(), xPrisonInfo);
/* 30 */       if (roleJailStat.canGetOutOfJail)
/*    */       {
/* 32 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 36 */       xPrisonInfo.setInjailonlinetime(roleJailStat.inJailOnlineTime);
/*    */       
/* 38 */       Session.removeSession(xPrisonInfo.getSessionid(), ((Long)this.arg).longValue());
/* 39 */       xPrisonInfo.setSessionid(new RoleOutOfJailSession(roleJailStat.inJailLeftTime, ((Long)this.arg).longValue()).getSessionId());
/*    */       
/* 41 */       xPrisonInfo.setJailaction(1);
/*    */       
/*    */ 
/* 44 */       if (!RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 1661, true))
/*    */       {
/* 46 */         RoleStatusInterface.setStatus(((Long)this.arg).longValue(), 1661, false);
/*    */       }
/*    */       
/* 49 */       MapInterface.forceTransferToScene(((Long)this.arg).longValue(), JailWorldManager.getInstance().getWorldId(), ((Integer)JailWorldManager.getInstance().getMapCfgIds().get(0)).intValue(), SPKConsts.getInstance().WANTED_ENTER_PRISON_MAP_X, SPKConsts.getInstance().WANTED_ENTER_PRISON_MAP_Y);
/*    */       
/*    */ 
/* 52 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 57 */     int buffId = RoleInterface.getGender(((Long)this.arg).longValue()) == 2 ? SPKConsts.getInstance().FEMALE_PRISON_BUFF_ID : SPKConsts.getInstance().MALE_PRISON_BUFF_ID;
/*    */     
/*    */ 
/* 60 */     if (BuffInterface.isContainBuff(((Long)this.arg).longValue(), buffId))
/*    */     {
/*    */ 
/* 63 */       BuffInterface.uninstallBuf(((Long)this.arg).longValue(), buffId);
/*    */       
/* 65 */       MapInterface.setLimitPolygonMovementStatus(((Long)this.arg).longValue(), false, null);
/*    */     }
/*    */     
/*    */ 
/* 69 */     JailProtectInfo xJailProtectInfo = Role2jailprotect.get((Long)this.arg);
/* 70 */     long jailProtectLeftTime = PrisonInterface.getRoleJailProtectTimeLeft(xJailProtectInfo);
/* 71 */     if (jailProtectLeftTime > 0L)
/*    */     {
/* 73 */       if (!RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 1662, true))
/*    */       {
/* 75 */         RoleStatusInterface.setStatus(((Long)this.arg).longValue(), 1662, false);
/*    */       }
/*    */       
/* 78 */       Session oldSession = Session.getSession(xJailProtectInfo.getSessionid());
/* 79 */       if ((oldSession == null) || (oldSession.getOwerId() != ((Long)this.arg).longValue()))
/*    */       {
/*    */ 
/* 82 */         xJailProtectInfo.setSessionid(new JailProtectSession(jailProtectLeftTime, ((Long)this.arg).longValue()).getSessionId());
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 87 */       if (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 1662, true))
/*    */       {
/* 89 */         RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 1662);
/*    */       }
/* 91 */       Role2jailprotect.remove((Long)this.arg);
/*    */     }
/*    */     
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */