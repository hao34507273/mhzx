/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.marriage.confbean.SMarriageParadeRobConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.RoleLessCold1;
/*    */ import xtable.Role2lesscold1;
/*    */ 
/*    */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     boolean mine = false;
/* 19 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).monsteridToLevel.keySet().iterator(); i$.hasNext();) { int monsterCfgid = ((Integer)i$.next()).intValue();
/* 20 */       if (MarriageManager.isParadeRobMonsterCfgid(monsterCfgid)) {
/* 21 */         mine = true;
/* 22 */         break;
/*    */       }
/*    */     }
/*    */     
/* 26 */     if (!mine) {
/* 27 */       return false;
/*    */     }
/* 29 */     Map<Long, String> role2user = new java.util.HashMap();
/* 30 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 31 */       role2user.put(Long.valueOf(roleid), mzm.gsp.role.main.RoleInterface.getUserId(roleid));
/*    */     }
/* 33 */     lock(xtable.User.getTable(), role2user.values());
/* 34 */     lock(Role2lesscold1.getTable(), ((PVEFightEndArg)this.arg).roleList);
/* 35 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 36 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 37 */       RoleLessCold1 xRoleLessCold1 = Role2lesscold1.get(Long.valueOf(roleid));
/* 38 */       if (xRoleLessCold1 == null) {
/* 39 */         xRoleLessCold1 = xbean.Pod.newRoleLessCold1();
/* 40 */         xRoleLessCold1.setRobprotecttime(curTime);
/* 41 */         Role2lesscold1.insert(Long.valueOf(roleid), xRoleLessCold1);
/*    */       }
/* 43 */       if (!DateTimeUtils.isInSameDay(xRoleLessCold1.getRobprotecttime(), curTime)) {
/* 44 */         xRoleLessCold1.setRobprotecttime(curTime);
/* 45 */         xRoleLessCold1.setRobprotectcount(0);
/*    */       }
/* 47 */       xRoleLessCold1.setRobprotectcount(xRoleLessCold1.getRobprotectcount() + 1);
/*    */     }
/*    */     
/*    */ 
/* 51 */     List<Long> awardRoles = ((PVEFightEndArg)this.arg).notEscapeRoles();
/* 52 */     for (Iterator i$ = awardRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 54 */       if (((PVEFightEndArg)this.arg).isPlayerWin) {
/* 55 */         AwardInterface.awardFixAward(SMarriageParadeRobConsts.getInstance().winProtectAward, (String)role2user.get(Long.valueOf(roleid)), roleid, false, true, new mzm.gsp.award.main.AwardReason(LogReason.MARRIAGE_PARADE_ROB_PROCTE_WIN_AWARD));
/*    */       }
/*    */       else
/*    */       {
/* 59 */         AwardInterface.awardFixAward(SMarriageParadeRobConsts.getInstance().failProtectAward, (String)role2user.get(Long.valueOf(roleid)), roleid, false, true, new mzm.gsp.award.main.AwardReason(LogReason.MARRIAGE_PARADE_ROB_PROCTE_WIN_AWARD));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */