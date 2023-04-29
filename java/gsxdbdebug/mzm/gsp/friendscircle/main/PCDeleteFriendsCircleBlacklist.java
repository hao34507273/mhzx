/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.friendscircle.SDeleteFriendsCircleBlacklistSuccess;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleBlackRole;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ 
/*     */ public class PCDeleteFriendsCircleBlacklist extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long deleteBlackRoleId;
/*     */   private final int deleteBlackRoleServerId;
/*     */   private final boolean isOwnServer;
/*     */   
/*     */   public PCDeleteFriendsCircleBlacklist(long roleId, long deleteBlackRoleId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.deleteBlackRoleId = deleteBlackRoleId;
/*  31 */     this.deleteBlackRoleServerId = GameServerInfoManager.getZoneidFromRoleid(deleteBlackRoleId);
/*  32 */     this.isOwnServer = GameServerInfoManager.isValidZone(this.deleteBlackRoleServerId);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/*  40 */       onDeleteFriendsCircleBlacklistFail(1);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if ((!this.isOwnServer) && (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 489, true)))
/*     */     {
/*     */ 
/*     */ 
/*  48 */       onDeleteFriendsCircleBlacklistFail(61);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(this.roleId))
/*     */     {
/*  54 */       onDeleteFriendsCircleBlacklistFail(44);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String activeUserId = RoleInterface.getUserId(this.roleId);
/*  59 */     if (activeUserId == null)
/*     */     {
/*  61 */       onDeleteFriendsCircleBlacklistFail(6);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if ((this.isOwnServer) && (RoleInterface.getUserId(this.deleteBlackRoleId) == null))
/*     */     {
/*  67 */       onDeleteFriendsCircleBlacklistFail(57);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1829, true, true))
/*     */     {
/*  74 */       onDeleteFriendsCircleBlacklistFail(47);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*  79 */     if (!xRole2FriendsCircleInfo.getMy_black_role_list().remove(Long.valueOf(this.deleteBlackRoleId)))
/*     */     {
/*  81 */       onDeleteFriendsCircleBlacklistFail(60);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (!this.isOwnServer)
/*     */     {
/*  87 */       if (xRole2FriendsCircleInfo.getCross_server_black_operator().size() > 20)
/*     */       {
/*  89 */         onDeleteFriendsCircleBlacklistFail(66);
/*  90 */         return false;
/*     */       }
/*     */       
/*  93 */       CrossServerFriendsCircleBlackRole xCrossServerFriendsCircleBlackRole = Pod.newCrossServerFriendsCircleBlackRole();
/*  94 */       xCrossServerFriendsCircleBlackRole.setOperator(2);
/*  95 */       xCrossServerFriendsCircleBlackRole.setRole_server_id(this.deleteBlackRoleServerId);
/*     */       
/*  97 */       CrossServerFriendsCircleBlackRole xOldBlackRole = (CrossServerFriendsCircleBlackRole)xRole2FriendsCircleInfo.getCross_server_black_operator().put(Long.valueOf(this.deleteBlackRoleId), xCrossServerFriendsCircleBlackRole);
/*     */       
/*  99 */       if (xOldBlackRole != null)
/*     */       {
/* 101 */         onDeleteFriendsCircleBlacklistFail(63);
/* 102 */         return false;
/*     */       }
/*     */       
/* 105 */       CrossServerInterface.operatorFriendsCircleBlacklist(this.roleId, this.deleteBlackRoleId, this.deleteBlackRoleServerId, 2);
/*     */     }
/*     */     
/*     */ 
/* 109 */     SDeleteFriendsCircleBlacklistSuccess deleteSuccess = new SDeleteFriendsCircleBlacklistSuccess();
/* 110 */     deleteSuccess.black_role_id = this.deleteBlackRoleId;
/* 111 */     OnlineManager.getInstance().send(this.roleId, deleteSuccess);
/*     */     
/* 113 */     FriendsCircleManager.tlogFriendsCircleAddBlacklist(activeUserId, this.roleId, this.deleteBlackRoleId, 0);
/*     */     
/* 115 */     FriendsCircleManager.reportRoleBlackListChange(this.roleId, activeUserId, this.deleteBlackRoleId, 2, xRole2FriendsCircleInfo);
/*     */     
/*     */ 
/* 118 */     StringBuilder sBuilder = new StringBuilder();
/* 119 */     sBuilder.append("[friendscircle]PCDeleteFriendsCircleBlacklist.processImp@delete black list success");
/* 120 */     sBuilder.append("|role_id=").append(this.roleId);
/* 121 */     sBuilder.append("|delete_black_role_id=").append(this.deleteBlackRoleId);
/* 122 */     sBuilder.append("|is_own_server=").append(this.isOwnServer);
/* 123 */     sBuilder.append("|delete_black_role_server_id=").append(this.deleteBlackRoleServerId);
/*     */     
/* 125 */     GameServer.logger().info(sBuilder.toString());
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   private void onDeleteFriendsCircleBlacklistFail(int ret)
/*     */   {
/* 131 */     onDeleteFriendsCircleBlacklistFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onDeleteFriendsCircleBlacklistFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 136 */     StringBuilder sbLog = new StringBuilder();
/* 137 */     sbLog.append("[friendscircle]PCDeleteFriendsCircleBlacklist.processImp@delete friends circle black list fail");
/* 138 */     sbLog.append("|ret=").append(ret);
/* 139 */     sbLog.append("|role_id=").append(this.roleId);
/* 140 */     sbLog.append("|delete_blacked_role_id=").append(this.deleteBlackRoleId);
/* 141 */     sbLog.append("|delete_blacked_role_id_server=").append(this.deleteBlackRoleServerId);
/* 142 */     sbLog.append("|is_own_server=").append(this.isOwnServer);
/* 143 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 145 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 147 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 150 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 152 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 153 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 155 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCDeleteFriendsCircleBlacklist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */