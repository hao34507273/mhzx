/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import idip.Participation;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.bounty.main.BountyInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.jiuxiao.main.JiuXiaoInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class QueryRoleActivityParticipationHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*    */     throws Exception
/*    */   {
/* 27 */     String userid = (String)params.get(0);
/* 28 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 30 */     xbean.User xUser = xtable.User.get(userid);
/* 31 */     if (null == xUser)
/*    */     {
/* 33 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 34 */       rsp.retcode = retcode;
/* 35 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 36 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 38 */       GameServer.logger().error(String.format("[gmt]QueryRoleActivityParticipationHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */       
/*    */ 
/* 41 */       return;
/*    */     }
/*    */     
/*    */ 
/* 45 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */     {
/* 47 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 48 */       rsp.retcode = retcode;
/* 49 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 50 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 52 */       GameServer.logger().error(String.format("[gmt]QueryRoleActivityParticipationHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid) }));
/*    */       
/*    */ 
/*    */ 
/* 56 */       return;
/*    */     }
/*    */     
/* 59 */     Participation participation = new Participation();
/*    */     
/* 61 */     participation.DriveMonsterNum = ActivityInterface.getActivityCount(userid, roleid, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, true);
/*    */     
/*    */ 
/* 64 */     participation.ArenaNum = ActivityInterface.getActivityCount(userid, roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID, true);
/*    */     
/*    */ 
/* 67 */     participation.MonsterCompleteNum = ActivityInterface.getActivityCount(userid, roleid, SLuanShiYaoMoConsts.getInstance().ACTIVITYID, true);
/*    */     
/*    */ 
/* 70 */     participation.RewardCompleteNum = (BountyInterface.getRankDoneTaskIdsNum(roleid, 3) + BountyInterface.getRankDoneTaskIdsNum(roleid, 4) + BountyInterface.getRankDoneTaskIdsNum(roleid, 5));
/*    */     
/*    */ 
/*    */ 
/* 74 */     participation.SchoolClearNum = ActivityInterface.getActivityCount(userid, roleid, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, true);
/*    */     
/*    */ 
/* 77 */     participation.BattleClearNum = JiuXiaoInterface.getCurJiuXiaoLayer(userid, roleid, true);
/*    */     
/* 79 */     participation.MansionClearNum = ActivityInterface.getActivityCount(userid, roleid, SParaseleneCfgConsts.getInstance().ActivityId, true);
/*    */     
/*    */ 
/* 82 */     rsp.retcode = Retcode.SUCCESS.value;
/* 83 */     Response response = new Response();
/* 84 */     response.data = participation;
/* 85 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 87 */     GameServer.logger().info(String.format("[gmt]QueryRoleActivityParticipationHandler.execute@query role activity participation success|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryRoleActivityParticipationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */