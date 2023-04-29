/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryRoleActivityParticipationReq;
/*     */ import idip.IDIPPacket_QueryRoleActivityParticipationReq;
/*     */ import idip.IDIPPacket_QueryRoleActivityParticipationRsp;
/*     */ import idip.Participation;
/*     */ import idip.QueryRoleActivityParticipationReq;
/*     */ import idip.QueryRoleActivityParticipationRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*     */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*     */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.bounty.main.BountyInterface;
/*     */ import mzm.gsp.husong.main.HuSongInterface;
/*     */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shimen.main.ShimenInterface;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryRoleActivityParticipationReq extends PIDIPCmd<IDIPCmd_QueryRoleActivityParticipationReq>
/*     */ {
/*     */   public PIDIPCmd_QueryRoleActivityParticipationReq(IDIPCmd_QueryRoleActivityParticipationReq cmd)
/*     */   {
/*  31 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  37 */     String openId = ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).OpenId;
/*  38 */     int areaId = ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).AreaId;
/*  39 */     int partition = ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).Partition;
/*     */     
/*  41 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  42 */     xbean.User xUser = xtable.User.get(userId);
/*  43 */     if (null == xUser)
/*     */     {
/*  45 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result = 1;
/*  46 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  47 */       ((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).sendResponse();
/*     */       
/*  49 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleActivityParticipationReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).PlatId), openId, ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  60 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result = 1;
/*  61 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  62 */       ((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).sendResponse();
/*     */       
/*  64 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleActivityParticipationReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).PlatId), openId, ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  75 */       roleId = Long.parseLong(((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  79 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result = 1;
/*  80 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  81 */       ((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).sendResponse();
/*     */       
/*  83 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleActivityParticipationReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).PlatId), openId, ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  93 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result = 1;
/*  94 */       ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  95 */       ((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).sendResponse();
/*     */       
/*  97 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleActivityParticipationReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).PlatId), openId, ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     Participation participation = new Participation();
/*     */     
/* 107 */     participation.DriveMonsterNum = ActivityInterface.getActivityCount(userId, roleId, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, true);
/*     */     
/*     */ 
/* 110 */     participation.ArenaNum = ActivityInterface.getActivityCount(userId, roleId, JingjiActivityCfgConsts.getInstance().ACTIVITYID, true);
/*     */     
/*     */ 
/* 113 */     participation.MonsterCompleteNum = ActivityInterface.getActivityCount(userId, roleId, SLuanShiYaoMoConsts.getInstance().ACTIVITYID, true);
/*     */     
/*     */ 
/* 116 */     participation.RewardCompleteNum = (BountyInterface.getRankDoneTaskIdsNum(roleId, 3) + BountyInterface.getRankDoneTaskIdsNum(roleId, 4) + BountyInterface.getRankDoneTaskIdsNum(roleId, 5));
/*     */     
/*     */ 
/*     */ 
/* 120 */     participation.SchoolClearNum = ActivityInterface.getActivityCount(userId, roleId, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, true);
/*     */     
/*     */ 
/* 123 */     participation.BattleClearNum = mzm.gsp.jiuxiao.main.JiuXiaoInterface.getCurJiuXiaoLayer(userId, roleId, true);
/*     */     
/* 125 */     participation.MansionClearNum = ActivityInterface.getActivityCount(userId, roleId, SParaseleneCfgConsts.getInstance().ActivityId, true);
/*     */     
/*     */ 
/*     */ 
/* 129 */     participation.DayMasterMissionFinish = ShimenInterface.getShimenFinishCount(userId, roleId, true);
/*     */     
/* 131 */     participation.DayQiyuanAnswer = mzm.gsp.question.main.QuestionInterface.getZhuxianQiyuanFinifshCount(userId, roleId, true);
/*     */     
/* 133 */     participation.DayConvoyMissionFinish = ActivityInterface.getActivityCount(userId, roleId, HuSongInterface.getHuSongActivityid(), true);
/*     */     
/*     */ 
/* 136 */     participation.DayRewardMissionFinish = ActivityInterface.getActivityCount(userId, roleId, BountyInterface.getBountyActivityId(), true);
/*     */     
/*     */ 
/* 139 */     participation.DaySchoolAnswer = ActivityInterface.getActivityCount(userId, roleId, mzm.gsp.question.main.QYXTQuestionActivity.getQYXTActivityCfgId(), true);
/*     */     
/*     */ 
/* 142 */     participation.WeekFactionMissionFinish = ActivityInterface.getActivityCount(userId, roleId, mzm.gsp.factiontask.main.FactionTaskInterface.getFactionTaskActivityId(), true);
/*     */     
/*     */ 
/* 145 */     participation.DayWatchMoon = mzm.gsp.watchmoon.main.WatchmoonInterface.getWatchmoonCount(userId, roleId, true);
/*     */     
/* 147 */     participation.DayActivityLiveness = ActiveInterface.getTotalActiveValue(roleId);
/*     */     
/* 149 */     Role role = RoleInterface.getRole(roleId, true);
/* 150 */     participation.OnlineTime = role.getDayOnlineSeconds();
/*     */     
/* 152 */     ((QueryRoleActivityParticipationRsp)((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).body).ParticipationList.add(participation);
/* 153 */     ((QueryRoleActivityParticipationRsp)((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).body).ParticipationList_count = 1;
/* 154 */     ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result = 0;
/* 155 */     ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 156 */     ((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).sendResponse();
/*     */     
/* 158 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryRoleActivityParticipationReq.handle@query role activity participation success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleActivityParticipationRsp)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).PlatId), openId, ((QueryRoleActivityParticipationReq)((IDIPPacket_QueryRoleActivityParticipationReq)((IDIPCmd_QueryRoleActivityParticipationReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 163 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryRoleActivityParticipationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */