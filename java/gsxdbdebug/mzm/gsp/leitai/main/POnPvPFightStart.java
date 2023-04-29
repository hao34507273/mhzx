/*    */ package mzm.gsp.leitai.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import xbean.LeiTaiFight;
/*    */ 
/*    */ public class POnPvPFightStart extends mzm.gsp.fight.event.PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     mzm.gsp.fight.main.FightContext fightContext = ((PVPFightStartArg)this.arg).context;
/* 11 */     if ((fightContext instanceof LeiTaiFightContext)) {
/* 12 */       LeiTaiFightContext context = (LeiTaiFightContext)fightContext;
/*    */       
/* 14 */       long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 15 */       xbean.LeiTaiBean xLeiTaiBean = xtable.Leitai.get(Long.valueOf(localid));
/* 16 */       if (xLeiTaiBean == null) {
/* 17 */         xLeiTaiBean = xbean.Pod.newLeiTaiBean();
/* 18 */         xtable.Leitai.insert(Long.valueOf(localid), xLeiTaiBean);
/*    */       }
/* 20 */       LeiTaiFight xLeiTaiFight = xbean.Pod.newLeiTaiFight();
/* 21 */       xLeiTaiFight.setActiveroleid(context.activeRoleid);
/* 22 */       int activeSize = ((PVPFightStartArg)this.arg).activeRoles.size();
/* 23 */       if (context.isActiveTeam) {
/* 24 */         xLeiTaiFight.setActiveteamnum(activeSize);
/*    */       }
/* 26 */       else if (activeSize > 1) {
/* 27 */         xLeiTaiFight.setActiveteamnum(activeSize);
/*    */       }
/*    */       
/* 30 */       xLeiTaiFight.setPassiveroleid(context.passiveRoleid);
/* 31 */       int passiveSize = ((PVPFightStartArg)this.arg).passiveRoles.size();
/* 32 */       if (context.isPassiveTeam) {
/* 33 */         xLeiTaiFight.setPassiveteamnum(passiveSize);
/*    */       }
/* 35 */       else if (passiveSize > 1) {
/* 36 */         xLeiTaiFight.setPassiveteamnum(passiveSize);
/*    */       }
/*    */       
/* 39 */       xLeiTaiBean.getFightmap().put(Long.valueOf(((PVPFightStartArg)this.arg).fightid), xLeiTaiFight);
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\POnPvPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */