/*    */ package mzm.gsp.leitai.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.leitai.LeiTaiTeamRoleInfo;
/*    */ import mzm.gsp.leitai.SRefreshTeamListRes;
/*    */ import mzm.gsp.leitai.confbean.SLeiTaiConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class PCRefreshTeamList extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCRefreshTeamList(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (!MapInterface.isRoleInPkZone(SLeiTaiConsts.getInstance().LEI_TAI_MAP_ID, this.roleid)) {
/* 27 */       LeiTaiManager.sendNormalResult(this.roleid, 3, new String[0]);
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     xbean.LeiTaiBean xLeiTaiBean = xtable.Leitai.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */     
/* 33 */     Set<Long> teamLeaderids = LeiTaiManager.getInstance().randomTeam(SLeiTaiConsts.getInstance().LEI_TAI_REFRESH_NUM, this.roleid, xLeiTaiBean);
/*    */     
/* 35 */     SRefreshTeamListRes sRefreshSingleListRes = new SRefreshTeamListRes();
/* 36 */     for (Iterator i$ = teamLeaderids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 38 */       Long teamid = TeamInterface.getTeamidByRoleid(roleid, false);
/* 39 */       if (teamid != null) {
/* 40 */         LeiTaiTeamRoleInfo teamRoleInfo = new LeiTaiTeamRoleInfo();
/*    */         
/* 42 */         mzm.gsp.role.main.Role role = RoleInterface.getRole(roleid, false);
/* 43 */         LeiTaiManager.fillinLeiTaiRoleInfo(role, teamRoleInfo.roleinfo);
/* 44 */         teamRoleInfo.num = TeamInterface.getTeamMemberList(teamid.longValue(), false).size();
/* 45 */         sRefreshSingleListRes.leitaiteamrolelist.add(teamRoleInfo);
/*    */       }
/*    */     }
/*    */     
/* 49 */     OnlineManager.getInstance().send(this.roleid, sRefreshSingleListRes);
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\PCRefreshTeamList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */