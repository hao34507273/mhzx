/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import xbean.CrossCompeteAgainstTmp;
/*    */ import xbean.RoamCrossCompeteRole;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnPVPFightStart extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (!(((PVPFightStartArg)this.arg).context instanceof PVPFightContext)) {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     PVPFightContext context = (PVPFightContext)((PVPFightStartArg)this.arg).context;
/*    */     
/*    */ 
/* 22 */     lock(Basic.getTable(), ((PVPFightStartArg)this.arg).activeRoles);
/* 23 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 24 */       RoamCrossCompeteRole xRC = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, true);
/* 25 */       CrossCompeteRoamManager.deductActionPoint(r, xRC, SCrossCompeteConsts.getInstance().DeductActionPointWhenPK, 2);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 31 */     xbean.CrossCompeteTmp xCompeteTmp = CrossCompeteRoamManager.createXCrossCompeteTmp();
/* 32 */     CrossCompeteAgainstTmp xAgainstTmp = CrossCompeteRoamManager.createXAgainstTmpIfNotExist(xCompeteTmp, context.activeFactionid, context.passiveFactionid);
/*    */     
/*    */ 
/* 35 */     xAgainstTmp.getPvp_fights().add(Long.valueOf(((PVPFightStartArg)this.arg).fightid));
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */