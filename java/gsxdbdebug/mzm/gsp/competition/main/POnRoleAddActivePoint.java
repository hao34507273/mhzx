/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.active.event.ActiveArg;
/*    */ import mzm.gsp.active.event.AddActivePointProcedure;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.FactionCompetition;
/*    */ 
/*    */ 
/*    */ public class POnRoleAddActivePoint
/*    */   extends AddActivePointProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Gang faction = GangInterface.getGangByRoleId(((ActiveArg)this.arg).roleid, true);
/* 19 */     if (faction == null) {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     FactionCompetition xFactionCompetition = CompetitionManager.getXFactionCompetitionIfNotExist(faction.getGangId());
/*    */     
/* 25 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 26 */     if (!DateTimeUtils.isInSameDay(now, xFactionCompetition.getActive_timestamp())) {
/* 27 */       xFactionCompetition.setLast_active_number(xFactionCompetition.getActive_number());
/* 28 */       xFactionCompetition.setActive_number(0);
/* 29 */       xFactionCompetition.setActive_timestamp(now);
/*    */     }
/*    */     
/* 32 */     if ((((ActiveArg)this.arg).oldPoint < SCompetitionConsts.getInstance().NeedRoleActivePoint) && (((ActiveArg)this.arg).newPoint >= SCompetitionConsts.getInstance().NeedRoleActivePoint))
/*    */     {
/* 34 */       xFactionCompetition.setActive_number(xFactionCompetition.getActive_number() + 1);
/*    */     }
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnRoleAddActivePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */