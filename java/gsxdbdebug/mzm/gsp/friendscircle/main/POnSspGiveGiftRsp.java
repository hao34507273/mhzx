/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleGiftResult;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnSspGiveGiftRsp extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long activeGiveRoleId;
/*     */   private final long receiveRoleId;
/*     */   private final int giftItemId;
/*     */   private final int giftNum;
/*     */   private final int addPopularityValue;
/*     */   private final long serialId;
/*     */   private final int retcode;
/*     */   
/*     */   public POnSspGiveGiftRsp(long activeGiveRoleId, long receiveRoleId, int giftItemId, int giftNum, int addPopularityValue, long serialId, int retcode)
/*     */   {
/*  26 */     this.activeGiveRoleId = activeGiveRoleId;
/*  27 */     this.receiveRoleId = receiveRoleId;
/*  28 */     this.giftItemId = giftItemId;
/*  29 */     this.giftNum = giftNum;
/*  30 */     this.addPopularityValue = addPopularityValue;
/*  31 */     this.serialId = serialId;
/*  32 */     this.retcode = retcode;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     String receiveUserId = mzm.gsp.role.main.RoleInterface.getUserId(this.receiveRoleId);
/*  39 */     if (receiveUserId == null)
/*     */     {
/*  41 */       onSspGiveGiftRspFail(6);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     lock(Lockeys.get(User.getTable(), receiveUserId));
/*  46 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.receiveRoleId);
/*     */     
/*  48 */     FriendsCircleGiftResult xFriendsCircleGiftResult = (FriendsCircleGiftResult)xRole2FriendsCircleInfo.getBe_sent_gift().get(Long.valueOf(this.serialId));
/*     */     
/*  50 */     if (xFriendsCircleGiftResult == null)
/*     */     {
/*  52 */       onSspGiveGiftRspFail(39);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if ((xFriendsCircleGiftResult.getGive_gift_role_id() != this.activeGiveRoleId) || (xFriendsCircleGiftResult.getItem_cfg_id() != this.giftItemId) || (xFriendsCircleGiftResult.getItem_num() != this.giftNum) || (xFriendsCircleGiftResult.getAdd_popularity_value() != this.addPopularityValue))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  61 */       Map<String, Object> extraMap = new HashMap();
/*  62 */       extraMap.put("x_active_give_gift_role_id", Long.valueOf(xFriendsCircleGiftResult.getGive_gift_role_id()));
/*  63 */       extraMap.put("x_item_cfg_id", Integer.valueOf(xFriendsCircleGiftResult.getItem_cfg_id()));
/*  64 */       extraMap.put("x_item_num", Integer.valueOf(xFriendsCircleGiftResult.getItem_num()));
/*  65 */       extraMap.put("x_add_popularity_value", Integer.valueOf(xFriendsCircleGiftResult.getAdd_popularity_value()));
/*     */       
/*  67 */       onSspGiveGiftRspFail(40, extraMap);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (xFriendsCircleGiftResult.getIs_cross_server())
/*     */     {
/*  73 */       xFriendsCircleGiftResult.setIs_ssp_replied(true);
/*  74 */       CrossServerInterface.deleteFriendsCircleGfitHistory(this.activeGiveRoleId, this.receiveRoleId, this.serialId, xFriendsCircleGiftResult.getGive_gift_zone_id());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  79 */       xRole2FriendsCircleInfo.getBe_sent_gift().remove(Long.valueOf(this.serialId));
/*     */     }
/*     */     
/*  82 */     StringBuilder sBuilder = new StringBuilder();
/*  83 */     sBuilder.append("[friendscircle]POnSspGiveGiftRsp.processImp@give gift rsp success");
/*  84 */     sBuilder.append("|active_role_id=").append(this.activeGiveRoleId);
/*  85 */     sBuilder.append("|receive_role_id=").append(this.receiveRoleId);
/*  86 */     sBuilder.append("|gift_item_id=").append(this.giftItemId);
/*  87 */     sBuilder.append("|gift_num=").append(this.giftNum);
/*  88 */     sBuilder.append("|add_popularity_value=").append(this.addPopularityValue);
/*  89 */     sBuilder.append("|serial_id=").append(this.serialId);
/*  90 */     sBuilder.append("|is_cross_server=").append(xFriendsCircleGiftResult.getIs_cross_server());
/*  91 */     sBuilder.append("|ret_code=").append(this.retcode);
/*     */     
/*  93 */     GameServer.logger().info(sBuilder.toString());
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   private void onSspGiveGiftRspFail(int ret)
/*     */   {
/*  99 */     onSspGiveGiftRspFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onSspGiveGiftRspFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 104 */     StringBuilder sbLog = new StringBuilder();
/* 105 */     sbLog.append("[friendscircle]POnSspGiveGiftRsp.processImp@give gift rsp failed");
/* 106 */     sbLog.append("|ret=").append(ret);
/* 107 */     sbLog.append("|active_role_id=").append(this.activeGiveRoleId);
/* 108 */     sbLog.append("|receive_role_id=").append(this.receiveRoleId);
/* 109 */     sbLog.append("|gift_item_id=").append(this.giftItemId);
/* 110 */     sbLog.append("|gift_num=").append(this.giftNum);
/* 111 */     sbLog.append("|add_popularity_value=").append(this.addPopularityValue);
/* 112 */     sbLog.append("|serial_id=").append(this.serialId);
/* 113 */     sbLog.append("|ret_code=").append(this.retcode);
/*     */     
/* 115 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 117 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 119 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 122 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnSspGiveGiftRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */