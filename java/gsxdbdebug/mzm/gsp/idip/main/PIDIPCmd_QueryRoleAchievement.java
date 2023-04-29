/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryRoleArchivementReq;
/*     */ import idip.IDIPPacket_QueryRoleArchivementReq;
/*     */ import idip.IDIPPacket_QueryRoleArchivementRsp;
/*     */ import idip.QueryRoleArchivementReq;
/*     */ import idip.QueryRoleArchivementRsp;
/*     */ import idip.SArchiveInfo;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.achievement.main.AchievementInterface;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryRoleAchievement extends PIDIPCmd<IDIPCmd_QueryRoleArchivementReq>
/*     */ {
/*     */   public PIDIPCmd_QueryRoleAchievement(IDIPCmd_QueryRoleArchivementReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     String openId = ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).OpenId;
/*  30 */     int areaId = ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).AreaId;
/*  31 */     int partition = ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).Partition;
/*     */     
/*  33 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  34 */     xbean.User xUser = xtable.User.get(userId);
/*  35 */     if (null == xUser)
/*     */     {
/*  37 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result = 1;
/*  38 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  39 */       ((IDIPCmd_QueryRoleArchivementReq)this.cmd).sendResponse();
/*     */       
/*  41 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleAchievement.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result = 1;
/*  53 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  54 */       ((IDIPCmd_QueryRoleArchivementReq)this.cmd).sendResponse();
/*     */       
/*  56 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleAchievement.handle@roleid length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long roleid = -1L;
/*     */     try
/*     */     {
/*  67 */       roleid = Long.parseLong(((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  71 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result = 1;
/*  72 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  73 */       ((IDIPCmd_QueryRoleArchivementReq)this.cmd).sendResponse();
/*     */       
/*  75 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleAchievement.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  85 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result = 1;
/*  86 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  87 */       ((IDIPCmd_QueryRoleArchivementReq)this.cmd).sendResponse();
/*     */       
/*  89 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleAchievement.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     int size = ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).ArchivementList.size();
/*  98 */     if (size > 50)
/*     */     {
/* 100 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result = 1;
/* 101 */       ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg = "query list size > max num";
/* 102 */       ((IDIPCmd_QueryRoleArchivementReq)this.cmd).sendResponse();
/*     */       
/* 104 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleAchievement.handle@query list size > max num|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     QueryRoleArchivementRsp rsp = (QueryRoleArchivementRsp)((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).body;
/* 113 */     if (size == 0)
/*     */     {
/* 115 */       Pair<Integer, Integer> pair = AchievementInterface.getFinishedAchievementNumAndScore(roleid, true);
/* 116 */       rsp.ReachNum = ((Integer)pair.first).intValue();
/* 117 */       rsp.TotalArchivementPoint = ((Integer)pair.second).intValue();
/*     */     }
/* 119 */     else if ((size == 1) && (((Integer)((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).ArchivementList.get(0)).intValue() == 0))
/*     */     {
/* 121 */       Pair<Integer, Integer> pair = AchievementInterface.getFinishedAchievementNumAndScore(roleid, true);
/* 122 */       rsp.ReachNum = ((Integer)pair.first).intValue();
/* 123 */       rsp.TotalArchivementPoint = ((Integer)pair.second).intValue();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 128 */       Pair<Integer, Map<Integer, Integer>> pair = AchievementInterface.getMultiAchievementState(roleid, ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).ArchivementList, true);
/*     */       
/* 130 */       Map<Integer, Integer> goals = (Map)pair.second;
/* 131 */       int achieves = 0;
/* 132 */       for (Map.Entry<Integer, Integer> entry : goals.entrySet())
/*     */       {
/* 134 */         SArchiveInfo achieveInfo = new SArchiveInfo();
/* 135 */         achieveInfo.ArchiveId = ((Integer)entry.getKey()).intValue();
/* 136 */         if (((Integer)entry.getValue()).intValue() != 1)
/*     */         {
/* 138 */           achieveInfo.IsReach = 1;
/* 139 */           achieves++;
/*     */         }
/* 141 */         rsp.ArchivementList.add(achieveInfo);
/*     */       }
/*     */       
/* 144 */       rsp.TotalArchivementPoint = ((Integer)pair.first).intValue();
/* 145 */       rsp.ReachNum = achieves;
/*     */     }
/*     */     
/* 148 */     rsp.ArchivementList_count = rsp.ArchivementList.size();
/*     */     
/* 150 */     ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result = 0;
/* 151 */     ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 152 */     ((IDIPCmd_QueryRoleArchivementReq)this.cmd).sendResponse();
/*     */     
/* 154 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryRoleAchievement.handle@query success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleArchivementRsp)((IDIPCmd_QueryRoleArchivementReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryRoleArchivementReq)((IDIPPacket_QueryRoleArchivementReq)((IDIPCmd_QueryRoleArchivementReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryRoleAchievement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */