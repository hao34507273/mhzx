/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleTreadResult;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class POnCrossServerDeleteTreadFriendsCircleRsp extends LogicProcedure
/*     */ {
/*     */   private final long activeTreadRoleId;
/*     */   private final long beTrodRoleId;
/*     */   private final long treadSerialId;
/*     */   private final int result;
/*     */   
/*     */   public POnCrossServerDeleteTreadFriendsCircleRsp(long activeTreadRoleId, long beTrodRoleId, long treadSerialId, int result)
/*     */   {
/*  24 */     this.activeTreadRoleId = activeTreadRoleId;
/*  25 */     this.beTrodRoleId = beTrodRoleId;
/*  26 */     this.treadSerialId = treadSerialId;
/*  27 */     this.result = result;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if ((this.result == 1) || (this.result == 0))
/*     */     {
/*     */ 
/*  36 */       Xdb.executor().schedule(new RDelayDelteTreadHistory(this.activeTreadRoleId, this.beTrodRoleId, this.treadSerialId), 180000L, TimeUnit.MILLISECONDS);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  41 */     StringBuilder sBuilder = new StringBuilder();
/*  42 */     sBuilder.append("[friendscircle]POnCrossServerDeleteTreadFriendsCircleRsp.processImp@get rsp");
/*  43 */     sBuilder.append("|result=").append(this.result);
/*  44 */     sBuilder.append("|active_tread_role_id=").append(this.activeTreadRoleId);
/*  45 */     sBuilder.append("|be_trod_role_id=").append(this.beTrodRoleId);
/*  46 */     sBuilder.append("|tread_serial_id=").append(this.treadSerialId);
/*     */     
/*  48 */     GameServer.logger().info(sBuilder.toString());
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   private static class RDelayDelteTreadHistory extends LogicProcedure implements Runnable
/*     */   {
/*     */     private final long activeTreadRoleId;
/*     */     private final long beTrodRoleId;
/*     */     private final long treadSerialId;
/*     */     
/*     */     public RDelayDelteTreadHistory(long activeTreadRoleId, long beTrodRoleId, long treadSerialId)
/*     */     {
/*  60 */       this.activeTreadRoleId = activeTreadRoleId;
/*  61 */       this.beTrodRoleId = beTrodRoleId;
/*  62 */       this.treadSerialId = treadSerialId;
/*     */     }
/*     */     
/*     */ 
/*     */     public void run()
/*     */     {
/*  68 */       execute();
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  74 */       String userId = RoleInterface.getUserId(this.beTrodRoleId);
/*  75 */       if (userId == null)
/*     */       {
/*  77 */         onDelayDelteTreadHistoryFail(6);
/*  78 */         return false;
/*     */       }
/*     */       
/*  81 */       Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.beTrodRoleId);
/*     */       
/*  83 */       FriendsCircleTreadResult xFriendsCircleTreadResult = (FriendsCircleTreadResult)xRole2FriendsCircleInfo.getBe_trod_result().get(Long.valueOf(this.treadSerialId));
/*     */       
/*  85 */       if (xFriendsCircleTreadResult == null)
/*     */       {
/*  87 */         onDelayDelteTreadHistoryFail(32);
/*  88 */         return false;
/*     */       }
/*     */       
/*  91 */       if (!xFriendsCircleTreadResult.getIs_cross_server())
/*     */       {
/*  93 */         onDelayDelteTreadHistoryFail(48);
/*  94 */         return false;
/*     */       }
/*     */       
/*  97 */       if (!xFriendsCircleTreadResult.getIs_ssp_replied())
/*     */       {
/*  99 */         onDelayDelteTreadHistoryFail(49);
/* 100 */         return false;
/*     */       }
/*     */       
/* 103 */       if (xFriendsCircleTreadResult.getTread_me_role_id() != this.activeTreadRoleId)
/*     */       {
/* 105 */         onDelayDelteTreadHistoryFail(33);
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       xRole2FriendsCircleInfo.getBe_trod_result().remove(Long.valueOf(this.treadSerialId));
/*     */       
/* 111 */       StringBuilder sbLog = new StringBuilder();
/* 112 */       sbLog.append("[friendscircle]RDelayDelteTreadHistory.processImp@handle cross server delete thread  rsp success");
/* 113 */       sbLog.append("|active_tread_role_id=").append(this.activeTreadRoleId);
/* 114 */       sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 115 */       sbLog.append("|tread_serial_id=").append(this.treadSerialId);
/*     */       
/* 117 */       GameServer.logger().info(sbLog.toString());
/* 118 */       return true;
/*     */     }
/*     */     
/*     */     private void onDelayDelteTreadHistoryFail(int ret)
/*     */     {
/* 123 */       onDelayDelteTreadHistoryFail(ret, null);
/*     */     }
/*     */     
/*     */     private void onDelayDelteTreadHistoryFail(int ret, Map<String, Object> extraMap)
/*     */     {
/* 128 */       StringBuilder sbLog = new StringBuilder();
/* 129 */       sbLog.append("[friendscircle]RDelayDelteTreadHistory.processImp@handle cross server delete thread  rsp failed");
/* 130 */       sbLog.append("|ret=").append(ret);
/* 131 */       sbLog.append("|active_tread_role_id=").append(this.activeTreadRoleId);
/* 132 */       sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 133 */       sbLog.append("|tread_serial_id=").append(this.treadSerialId);
/*     */       
/* 135 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 137 */         for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */         {
/* 139 */           sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */         }
/*     */       }
/* 142 */       GameServer.logger().error(sbLog.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerDeleteTreadFriendsCircleRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */