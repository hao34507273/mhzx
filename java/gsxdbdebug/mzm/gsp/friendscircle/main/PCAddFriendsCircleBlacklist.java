/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friendscircle.SAddFriendsCircleBlacklistSuccess;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleBlackRole;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAddFriendsCircleBlacklist extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long blackedRoleId;
/*     */   private final int blackedRoleServerId;
/*     */   private boolean isOwnServer;
/*     */   
/*     */   public PCAddFriendsCircleBlacklist(long roleId, long blackedRoleId, int blackRoleServerId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.blackedRoleId = blackedRoleId;
/*  31 */     this.blackedRoleServerId = blackRoleServerId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     int serverCalRoleZoneId = GameServerInfoManager.getZoneidFromRoleid(this.blackedRoleId);
/*  38 */     if (this.blackedRoleServerId != serverCalRoleZoneId)
/*     */     {
/*  40 */       Map<String, Object> extraMap = new HashMap();
/*  41 */       extraMap.put("client_server_id", Integer.valueOf(this.blackedRoleServerId));
/*  42 */       extraMap.put("server_cal_role_zone_id", Integer.valueOf(serverCalRoleZoneId));
/*     */       
/*  44 */       onAddFriendsCircleBlacklistFail(62, extraMap);
/*  45 */       return false;
/*     */     }
/*  47 */     this.isOwnServer = GameServerInfoManager.isValidZone(this.blackedRoleServerId);
/*     */     
/*  49 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/*  51 */       onAddFriendsCircleBlacklistFail(1);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(this.roleId))
/*     */     {
/*  57 */       onAddFriendsCircleBlacklistFail(44);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if ((!this.isOwnServer) && (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 489, true)))
/*     */     {
/*     */ 
/*     */ 
/*  65 */       onAddFriendsCircleBlacklistFail(61);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     String activeUserId = RoleInterface.getUserId(this.roleId);
/*  70 */     if (activeUserId == null)
/*     */     {
/*  72 */       onAddFriendsCircleBlacklistFail(6);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if ((this.isOwnServer) && (RoleInterface.getUserId(this.blackedRoleId) == null))
/*     */     {
/*  78 */       onAddFriendsCircleBlacklistFail(57);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if ((this.isOwnServer) && (RoleInterface.getLevel(this.blackedRoleId) < SFriendsCircleConsts.getInstance().friends_circle_open_role_level))
/*     */     {
/*     */ 
/*  85 */       onAddFriendsCircleBlacklistFail(44);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     lock(xdb.Lockeys.get(User.getTable(), activeUserId));
/*     */     
/*  91 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1828, true, true))
/*     */     {
/*  93 */       onAddFriendsCircleBlacklistFail(47);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*  98 */     if (xRole2FriendsCircleInfo.getMy_black_role_list().size() >= SFriendsCircleConsts.getInstance().max_black_role_num_limit)
/*     */     {
/* 100 */       onAddFriendsCircleBlacklistFail(58);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (xRole2FriendsCircleInfo.getMy_black_role_list().contains(Long.valueOf(this.blackedRoleId)))
/*     */     {
/* 106 */       onAddFriendsCircleBlacklistFail(59);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     if (!this.isOwnServer)
/*     */     {
/* 112 */       if (xRole2FriendsCircleInfo.getCross_server_black_operator().size() > 20)
/*     */       {
/* 114 */         onAddFriendsCircleBlacklistFail(66);
/* 115 */         return false;
/*     */       }
/*     */       
/* 118 */       CrossServerFriendsCircleBlackRole xCrossServerFriendsCircleBlackRole = xbean.Pod.newCrossServerFriendsCircleBlackRole();
/* 119 */       xCrossServerFriendsCircleBlackRole.setOperator(1);
/* 120 */       xCrossServerFriendsCircleBlackRole.setRole_server_id(this.blackedRoleServerId);
/*     */       
/* 122 */       CrossServerFriendsCircleBlackRole xOldRecord = (CrossServerFriendsCircleBlackRole)xRole2FriendsCircleInfo.getCross_server_black_operator().put(Long.valueOf(this.blackedRoleId), xCrossServerFriendsCircleBlackRole);
/*     */       
/* 124 */       if (xOldRecord != null)
/*     */       {
/* 126 */         onAddFriendsCircleBlacklistFail(63);
/* 127 */         return false;
/*     */       }
/*     */       
/* 130 */       CrossServerInterface.operatorFriendsCircleBlacklist(this.roleId, this.blackedRoleId, this.blackedRoleServerId, 1);
/*     */     }
/*     */     
/* 133 */     xRole2FriendsCircleInfo.getMy_black_role_list().add(Long.valueOf(this.blackedRoleId));
/*     */     
/* 135 */     SAddFriendsCircleBlacklistSuccess sAddFriendsCircleBlacklistSuccess = new SAddFriendsCircleBlacklistSuccess();
/* 136 */     sAddFriendsCircleBlacklistSuccess.black_role_id = this.blackedRoleId;
/*     */     
/* 138 */     OnlineManager.getInstance().send(this.roleId, sAddFriendsCircleBlacklistSuccess);
/*     */     
/* 140 */     FriendsCircleManager.tlogFriendsCircleAddBlacklist(activeUserId, this.roleId, this.blackedRoleId, 1);
/*     */     
/* 142 */     FriendsCircleManager.reportRoleBlackListChange(this.roleId, activeUserId, this.blackedRoleId, 1, xRole2FriendsCircleInfo);
/*     */     
/*     */ 
/* 145 */     StringBuilder sBuilder = new StringBuilder();
/* 146 */     sBuilder.append("[friendscircle]PCAddFriendsCircleBlacklist.processImp@add black list success");
/* 147 */     sBuilder.append("|role_id=").append(this.roleId);
/* 148 */     sBuilder.append("|black_role_id=").append(this.blackedRoleId);
/*     */     
/* 150 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   private void onAddFriendsCircleBlacklistFail(int ret)
/*     */   {
/* 157 */     onAddFriendsCircleBlacklistFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onAddFriendsCircleBlacklistFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 162 */     StringBuilder sbLog = new StringBuilder();
/* 163 */     sbLog.append("[friendscircle]PCAddFriendsCircleBlacklist.processImp@add friends circle black list fail");
/* 164 */     sbLog.append("|ret=").append(ret);
/* 165 */     sbLog.append("|role_id=").append(this.roleId);
/* 166 */     sbLog.append("|blacked_role_id=").append(this.blackedRoleId);
/* 167 */     sbLog.append("|blackedRoleServerId=").append(this.blackedRoleServerId);
/* 168 */     sbLog.append("|is_own_server=").append(this.isOwnServer);
/* 169 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 171 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 173 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 176 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 178 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 179 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 181 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCAddFriendsCircleBlacklist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */