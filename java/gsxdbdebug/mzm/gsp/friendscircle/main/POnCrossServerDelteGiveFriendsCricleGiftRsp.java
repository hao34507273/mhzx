/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleGiftResult;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnCrossServerDelteGiveFriendsCricleGiftRsp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long activeGiveGiftRoleId;
/*     */   private final long receiveGiftRoleId;
/*     */   private final long giveGiftSerialId;
/*     */   private final int result;
/*     */   
/*     */   public POnCrossServerDelteGiveFriendsCricleGiftRsp(long activeGiveGiftRoleId, long receiveGiftRoleId, long treadSerialId, int result)
/*     */   {
/*  31 */     this.activeGiveGiftRoleId = activeGiveGiftRoleId;
/*  32 */     this.receiveGiftRoleId = receiveGiftRoleId;
/*  33 */     this.giveGiftSerialId = treadSerialId;
/*  34 */     this.result = result;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.result == 1) || (this.result == 0))
/*     */     {
/*     */ 
/*  43 */       Xdb.executor().schedule(new RDelayDeleteGiveGiftHistory(this.activeGiveGiftRoleId, this.receiveGiftRoleId, this.giveGiftSerialId), 180000L, TimeUnit.MILLISECONDS);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  48 */     StringBuilder sBuilder = new StringBuilder();
/*  49 */     sBuilder.append("[friendscircle]POnCrossServerDelteGiveFriendsCricleGiftRsp.processImp@get rsp");
/*  50 */     sBuilder.append("|result=").append(this.result);
/*  51 */     sBuilder.append("|active_tread_role_id=").append(this.activeGiveGiftRoleId);
/*  52 */     sBuilder.append("|be_trod_role_id=").append(this.receiveGiftRoleId);
/*  53 */     sBuilder.append("|tread_serial_id=").append(this.giveGiftSerialId);
/*     */     
/*  55 */     GameServer.logger().info(sBuilder.toString());
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   private static class RDelayDeleteGiveGiftHistory extends LogicProcedure implements Runnable
/*     */   {
/*     */     private final long activeGiveGiftRoleId;
/*     */     private final long receiveRoleId;
/*     */     private final long giftSerialId;
/*     */     
/*     */     public RDelayDeleteGiveGiftHistory(long activeGiveGiftRoleId, long receiveRoleId, long giftSerialId)
/*     */     {
/*  67 */       this.activeGiveGiftRoleId = activeGiveGiftRoleId;
/*  68 */       this.receiveRoleId = receiveRoleId;
/*  69 */       this.giftSerialId = giftSerialId;
/*     */     }
/*     */     
/*     */ 
/*     */     public void run()
/*     */     {
/*  75 */       execute();
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  81 */       String userId = RoleInterface.getUserId(this.receiveRoleId);
/*  82 */       if (userId == null)
/*     */       {
/*  84 */         onDelayDelteTreadHistoryFail(6);
/*  85 */         return false;
/*     */       }
/*     */       
/*  88 */       Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.receiveRoleId);
/*     */       
/*  90 */       FriendsCircleGiftResult xFriendsCircleGiveGiftResult = (FriendsCircleGiftResult)xRole2FriendsCircleInfo.getBe_sent_gift().get(Long.valueOf(this.giftSerialId));
/*     */       
/*  92 */       if (xFriendsCircleGiveGiftResult == null)
/*     */       {
/*  94 */         onDelayDelteTreadHistoryFail(32);
/*  95 */         return false;
/*     */       }
/*     */       
/*  98 */       if (!xFriendsCircleGiveGiftResult.getIs_cross_server())
/*     */       {
/* 100 */         onDelayDelteTreadHistoryFail(48);
/* 101 */         return false;
/*     */       }
/*     */       
/* 104 */       if (!xFriendsCircleGiveGiftResult.getIs_ssp_replied())
/*     */       {
/* 106 */         onDelayDelteTreadHistoryFail(49);
/* 107 */         return false;
/*     */       }
/*     */       
/* 110 */       if (xFriendsCircleGiveGiftResult.getGive_gift_role_id() != this.activeGiveGiftRoleId)
/*     */       {
/* 112 */         onDelayDelteTreadHistoryFail(33);
/* 113 */         return false;
/*     */       }
/*     */       
/* 116 */       xRole2FriendsCircleInfo.getBe_sent_gift().remove(Long.valueOf(this.giftSerialId));
/*     */       
/* 118 */       StringBuilder sbLog = new StringBuilder();
/* 119 */       sbLog.append("[friendscircle]RDelayDeleteGiveGiftHistory.processImp@handle cross server delete give gift rsp success");
/* 120 */       sbLog.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/* 121 */       sbLog.append("|receive_role_id=").append(this.receiveRoleId);
/* 122 */       sbLog.append("|gift_serial_id=").append(this.giftSerialId);
/*     */       
/* 124 */       GameServer.logger().info(sbLog.toString());
/* 125 */       return true;
/*     */     }
/*     */     
/*     */     private void onDelayDelteTreadHistoryFail(int ret)
/*     */     {
/* 130 */       onDelayDelteTreadHistoryFail(ret, null);
/*     */     }
/*     */     
/*     */     private void onDelayDelteTreadHistoryFail(int ret, Map<String, Object> extraMap)
/*     */     {
/* 135 */       StringBuilder sbLog = new StringBuilder();
/* 136 */       sbLog.append("[friendscircle]RDelayDeleteGiveGiftHistory.processImp@handle cross server delete give gift rsp failed");
/* 137 */       sbLog.append("|ret=").append(ret);
/* 138 */       sbLog.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/* 139 */       sbLog.append("|receive_role_id=").append(this.receiveRoleId);
/* 140 */       sbLog.append("|gift_serial_id=").append(this.giftSerialId);
/*     */       
/* 142 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 144 */         for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */         {
/* 146 */           sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */         }
/*     */       }
/* 149 */       GameServer.logger().error(sbLog.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerDelteGiveFriendsCricleGiftRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */