/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleTreadResult;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnSspTreadFriendsCircleRsp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long beTrodRoleId;
/*     */   private final long activeRoleId;
/*     */   private final long serialId;
/*     */   private final int retcode;
/*     */   
/*     */   public POnSspTreadFriendsCircleRsp(long beTrodRoleId, long activeRoleId, long serialId, int retcode)
/*     */   {
/*  32 */     this.beTrodRoleId = beTrodRoleId;
/*  33 */     this.activeRoleId = activeRoleId;
/*  34 */     this.serialId = serialId;
/*  35 */     this.retcode = retcode;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     String userId = RoleInterface.getUserId(this.beTrodRoleId);
/*  42 */     if (userId == null)
/*     */     {
/*  44 */       onSspTreadFriendsCircleRspFail(6);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     lock(Lockeys.get(User.getTable(), userId));
/*  49 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.beTrodRoleId);
/*  50 */     FriendsCircleTreadResult xFriendsCircleTreadResult = (FriendsCircleTreadResult)xRole2FriendsCircleInfo.getBe_trod_result().get(Long.valueOf(this.serialId));
/*     */     
/*  52 */     if (xFriendsCircleTreadResult == null)
/*     */     {
/*  54 */       onSspTreadFriendsCircleRspFail(32);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (xFriendsCircleTreadResult.getTread_me_role_id() != this.activeRoleId)
/*     */     {
/*  60 */       onSspTreadFriendsCircleRspFail(33);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!xFriendsCircleTreadResult.getIs_cross_server())
/*     */     {
/*  66 */       xRole2FriendsCircleInfo.getBe_trod_result().remove(Long.valueOf(this.serialId));
/*     */     }
/*     */     else
/*     */     {
/*  70 */       xFriendsCircleTreadResult.setIs_ssp_replied(true);
/*  71 */       CrossServerInterface.deleteFriendsCircleTreadHistory(this.activeRoleId, this.beTrodRoleId, this.serialId, xFriendsCircleTreadResult.getTread_me_zone_id());
/*     */     }
/*     */     
/*     */ 
/*  75 */     StringBuilder sBuilder = new StringBuilder();
/*  76 */     sBuilder.append("[friendscircle]POnSspTreadFriendsCircleRsp.processImp@handle ssp tread friends circle rsp success");
/*  77 */     sBuilder.append("|be_trod_role_id=").append(this.beTrodRoleId);
/*  78 */     sBuilder.append("|active_role_id=").append(this.activeRoleId);
/*  79 */     sBuilder.append("|serial_id=").append(this.serialId);
/*  80 */     sBuilder.append("|is_cross_server=").append(xFriendsCircleTreadResult.getIs_cross_server());
/*  81 */     sBuilder.append("|ret_code=").append(this.retcode);
/*     */     
/*  83 */     GameServer.logger().info(sBuilder.toString());
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private void onSspTreadFriendsCircleRspFail(int ret)
/*     */   {
/*  89 */     onSspTreadFriendsCircleRspFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onSspTreadFriendsCircleRspFail(int ret, Map<String, Object> extraMap)
/*     */   {
/*  94 */     StringBuilder sbLog = new StringBuilder();
/*  95 */     sbLog.append("[friendscircle]POnSspTreadFriendsCircleRsp.processImp@handle ssp tread friends circle rsp failed");
/*  96 */     sbLog.append("|ret=").append(ret);
/*  97 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/*  98 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/*  99 */     sbLog.append("|serial_id=").append(this.serialId);
/* 100 */     sbLog.append("|ret_code=").append(this.retcode);
/*     */     
/* 102 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 104 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 106 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 109 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnSspTreadFriendsCircleRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */