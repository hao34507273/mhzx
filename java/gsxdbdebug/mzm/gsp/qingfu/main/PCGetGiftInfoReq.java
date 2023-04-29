/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.ReceiverGiftInfo;
/*     */ import mzm.gsp.qingfu.SGetGiftInfoError;
/*     */ import mzm.gsp.qingfu.SGetGiftInfoRsp;
/*     */ import mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TimeLimitGiftInfo;
/*     */ import xbean.TimeLimitGiftP2PInfo;
/*     */ 
/*     */ public class PCGetGiftInfoReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int giftBagCfgId;
/*     */   
/*     */   public PCGetGiftInfoReq(long roleId, int activityId, int giftBagCfgId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.activityId = activityId;
/*  31 */     this.giftBagCfgId = giftBagCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if ((this.activityId <= 0) || (this.giftBagCfgId <= 0))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     if (!OpenInterface.getOpenStatus(585))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2201, true))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     STimeLimitGiftBagCfg sTimeLimitGiftBagCfg = STimeLimitGiftBagCfg.get(this.giftBagCfgId);
/*  55 */     if (sTimeLimitGiftBagCfg == null)
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     if (sTimeLimitGiftBagCfg.activityId != this.activityId)
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (sTimeLimitGiftBagCfg.canGift == 0)
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     SGetGiftInfoError sGetGiftInfoError = new SGetGiftInfoError();
/*  70 */     sGetGiftInfoError.activity_id = this.activityId;
/*  71 */     sGetGiftInfoError.gift_bag_cfg_id = this.giftBagCfgId;
/*     */     
/*  73 */     if (!ActivityInterface.isActivityOpen(this.activityId))
/*     */     {
/*  75 */       sGetGiftInfoError.code = 1;
/*  76 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetGiftInfoError);
/*  77 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGetGiftInfoReq.processImp@activity closed|roleId=%d|activityId=%d|giftBagCfgId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId) }));
/*     */       
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     SGetGiftInfoRsp sGetGiftInfoRsp = new SGetGiftInfoRsp();
/*  84 */     sGetGiftInfoRsp.activity_id = this.activityId;
/*  85 */     sGetGiftInfoRsp.gift_bag_cfg_id = this.giftBagCfgId;
/*     */     
/*  87 */     TimeLimitGiftInfo xSenderTimeLimitGiftInfo = TimeLimitGiftActivityManager.getTimeLimitGiftInfo(this.roleId, this.activityId, this.giftBagCfgId, false);
/*     */     
/*  89 */     if (xSenderTimeLimitGiftInfo == null)
/*     */     {
/*  91 */       sGetGiftInfoRsp.send_available = sTimeLimitGiftBagCfg.sendCountMax;
/*     */     }
/*     */     else
/*     */     {
/*  95 */       sGetGiftInfoRsp.send_available = (sTimeLimitGiftBagCfg.sendCountMax - xSenderTimeLimitGiftInfo.getSend_count());
/*  96 */       sGetGiftInfoRsp.send_available = (sGetGiftInfoRsp.send_available < 0 ? 0 : sGetGiftInfoRsp.send_available);
/*     */     }
/*     */     
/*  99 */     Map<Long, Integer> closeFriendId2intimacyMap = TimeLimitGiftActivityManager.getCloseFriendsByIntimacy(this.roleId, sTimeLimitGiftBagCfg.friendIntimacyMin, false);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */     for (Iterator i$ = closeFriendId2intimacyMap.keySet().iterator(); i$.hasNext();) { long friendId = ((Long)i$.next()).longValue();
/*     */       
/* 108 */       ReceiverGiftInfo receiverGiftInfo = new ReceiverGiftInfo();
/* 109 */       sGetGiftInfoRsp.receiver_gift_info_map.put(Long.valueOf(friendId), receiverGiftInfo);
/*     */       
/* 111 */       TimeLimitGiftInfo xTimeLimitGiftInfo = TimeLimitGiftActivityManager.getTimeLimitGiftInfo(friendId, this.activityId, this.giftBagCfgId, false);
/*     */       
/*     */ 
/* 114 */       receiverGiftInfo.receive_available = (xTimeLimitGiftInfo == null ? sTimeLimitGiftBagCfg.receiveCountMax : sTimeLimitGiftBagCfg.receiveCountMax - xTimeLimitGiftInfo.getReceive_count());
/*     */       
/*     */ 
/* 117 */       receiverGiftInfo.receive_available = (receiverGiftInfo.receive_available < 0 ? 0 : receiverGiftInfo.receive_available);
/*     */       
/*     */ 
/* 120 */       if (xSenderTimeLimitGiftInfo == null)
/*     */       {
/* 122 */         receiverGiftInfo.sender2receiver_count = 0;
/*     */       }
/*     */       else {
/* 125 */         TimeLimitGiftP2PInfo xTimeLimitGiftP2PInfo = (TimeLimitGiftP2PInfo)xSenderTimeLimitGiftInfo.getReceiver_info().get(Long.valueOf(friendId));
/* 126 */         if (xTimeLimitGiftP2PInfo == null)
/*     */         {
/* 128 */           receiverGiftInfo.sender2receiver_count = 0;
/*     */         }
/*     */         else
/* 131 */           receiverGiftInfo.sender2receiver_count = xTimeLimitGiftP2PInfo.getGift_count();
/*     */       }
/*     */     }
/* 134 */     OnlineManager.getInstance().send(this.roleId, sGetGiftInfoRsp);
/* 135 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetGiftInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */