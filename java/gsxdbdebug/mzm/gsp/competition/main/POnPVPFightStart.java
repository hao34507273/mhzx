/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import xbean.CompetitionTmp;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnPVPFightStart extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (!(((PVPFightStartArg)this.arg).context instanceof CompetitionFightContext)) {
/* 16 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 20 */     lock(Basic.getTable(), ((PVPFightStartArg)this.arg).activeRoles);
/* 21 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 22 */       xbean.RoleCompetition xRC = CompetitionManager.getXRoleCompetitionIfNotExist(r);
/* 23 */       CompetitionManager.deductActionPoint(r, xRC, SCompetitionConsts.getInstance().DeductActionPointWhenPK, 2);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 28 */     CompetitionTmp xTmp = CompetitionManager.getXCompetitionTmpIfNotExist();
/* 29 */     xTmp.getFights().add(Long.valueOf(((PVPFightStartArg)this.arg).fightid));
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */