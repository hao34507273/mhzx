/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.SRecallAllBrd;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRecallAllReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PRecallAllReq(long roleid)
/*    */   {
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     Team xTeam = TeamManager.getXTeamByRoleid(this.roleid, true);
/* 30 */     if (xTeam == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     if (!TeamManager.isLeader(this.roleid, xTeam))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     List<Long> tempLeaveList = TeamManager.getTempLeaveMemberListByXTeam(xTeam);
/* 42 */     if ((tempLeaveList != null) && (!tempLeaveList.isEmpty()))
/*    */     {
/* 44 */       SRecallAllBrd brd = new SRecallAllBrd();
/* 45 */       OnlineManager.getInstance().sendMulti(brd, tempLeaveList);
/*    */     }
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PRecallAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */