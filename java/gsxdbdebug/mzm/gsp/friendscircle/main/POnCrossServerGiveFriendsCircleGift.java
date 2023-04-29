/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentCfg;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentItemGradeCfg;
/*     */ import mzm.gsp.friendscircle.SReceiveFriendsCircleGiftSuccess;
/*     */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAdd;
/*     */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAddArg;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleReceiveGift;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleReceiveGiftArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleGiftResult;
/*     */ import xbean.Pod;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnCrossServerGiveFriendsCircleGift
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long activeGiveGiftRoleId;
/*     */   private final String activeGiveRoleName;
/*     */   private final int activeGiveGiftZoneId;
/*     */   private final long receiveGiftRoleId;
/*     */   private final int giftItemCfgId;
/*     */   private final int giftItemNum;
/*     */   private final int giftGrade;
/*     */   private final int addPopularityValue;
/*     */   private final String giveGiftMessage;
/*     */   private final long serialId;
/*  51 */   private int result = 0;
/*     */   
/*     */   public int getResult()
/*     */   {
/*  55 */     return this.result;
/*     */   }
/*     */   
/*  58 */   private String receiveRoleName = null;
/*     */   private int receiveRoleTotalPopularity;
/*     */   private int receiveRoleWeekPopularity;
/*     */   private int receiveRoleGiftNum;
/*     */   
/*     */   public String getReceiveRoleName()
/*     */   {
/*  65 */     return this.receiveRoleName;
/*     */   }
/*     */   
/*     */   public int getReceiveRoleTotalPopularity()
/*     */   {
/*  70 */     return this.receiveRoleTotalPopularity;
/*     */   }
/*     */   
/*     */   public int getReceiveRoleWeekPopularity()
/*     */   {
/*  75 */     return this.receiveRoleWeekPopularity;
/*     */   }
/*     */   
/*     */   public int getReceiveRoleGiftNum()
/*     */   {
/*  80 */     return this.receiveRoleGiftNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public POnCrossServerGiveFriendsCircleGift(long activeGiveGiftRoleId, String activeGiveRoleName, int activeGiveGiftZoneId, long receiveGiftRoleId, int giftItemId, int giftItemNum, int giftGrade, int addPopularityValue, String giveGiftMessage, long serialId)
/*     */   {
/*  87 */     this.activeGiveGiftRoleId = activeGiveGiftRoleId;
/*  88 */     this.activeGiveRoleName = activeGiveRoleName;
/*  89 */     this.activeGiveGiftZoneId = activeGiveGiftZoneId;
/*  90 */     this.receiveGiftRoleId = receiveGiftRoleId;
/*  91 */     this.giftItemCfgId = giftItemId;
/*  92 */     this.giftItemNum = giftItemNum;
/*  93 */     this.giftGrade = giftGrade;
/*  94 */     this.addPopularityValue = addPopularityValue;
/*  95 */     this.giveGiftMessage = giveGiftMessage;
/*  96 */     this.serialId = serialId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/* 102 */     String receiveGiftUserId = RoleInterface.getUserId(this.receiveGiftRoleId);
/* 103 */     if (receiveGiftUserId == null)
/*     */     {
/* 105 */       this.result = 1;
/* 106 */       onCrossServerGiveFriendsCircleGiftFail(6);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     lock(Lockeys.get(User.getTable(), receiveGiftUserId));
/* 111 */     int roleLevel = RoleInterface.getLevel(this.receiveGiftRoleId);
/* 112 */     if (roleLevel < SFriendsCircleConsts.getInstance().give_gift_open_role_level)
/*     */     {
/* 114 */       this.result = 4;
/* 115 */       onCrossServerGiveFriendsCircleGiftFail(44);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.receiveGiftRoleId);
/*     */     
/* 121 */     FriendsCircleGiftResult xOldFriendsCircleGiftResult = (FriendsCircleGiftResult)xRole2FriendsCircleInfo.getBe_sent_gift().get(Long.valueOf(this.serialId));
/*     */     
/* 123 */     if (xOldFriendsCircleGiftResult != null)
/*     */     {
/* 125 */       this.result = 3;
/* 126 */       onCrossServerGiveFriendsCircleGiftFail(34);
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     this.receiveRoleName = RoleInterface.getName(this.receiveGiftRoleId);
/*     */     
/* 132 */     FriendsCircleGiftResult xFriendsCircleGiftResult = Pod.newFriendsCircleGiftResult();
/* 133 */     xFriendsCircleGiftResult.setGive_gift_role_id(this.activeGiveGiftRoleId);
/* 134 */     xFriendsCircleGiftResult.setGive_gift_zone_id(this.activeGiveGiftZoneId);
/* 135 */     xFriendsCircleGiftResult.setIs_cross_server(true);
/* 136 */     xFriendsCircleGiftResult.setIs_ssp_replied(false);
/* 137 */     xFriendsCircleGiftResult.setItem_cfg_id(this.giftItemCfgId);
/* 138 */     xFriendsCircleGiftResult.setItem_grade(this.giftGrade);
/* 139 */     xFriendsCircleGiftResult.setItem_num(this.giftItemNum);
/* 140 */     xFriendsCircleGiftResult.setAdd_popularity_value(this.addPopularityValue);
/*     */     
/* 142 */     xRole2FriendsCircleInfo.getBe_sent_gift().put(Long.valueOf(this.serialId), xFriendsCircleGiftResult);
/*     */     
/* 144 */     int nowWeekPopularity = FriendsCircleManager.addAndGetWeekPopularity(this.receiveGiftRoleId, xRole2FriendsCircleInfo, this.addPopularityValue).intValue();
/*     */     
/* 146 */     xRole2FriendsCircleInfo.setTotal_popularity_value(xRole2FriendsCircleInfo.getTotal_popularity_value() + this.addPopularityValue);
/*     */     
/*     */ 
/* 149 */     xRole2FriendsCircleInfo.setReceive_gift_num(xRole2FriendsCircleInfo.getReceive_gift_num() + this.giftItemNum);
/*     */     
/* 151 */     this.receiveRoleTotalPopularity = xRole2FriendsCircleInfo.getTotal_popularity_value();
/* 152 */     this.receiveRoleWeekPopularity = xRole2FriendsCircleInfo.getCurrent_week_popularity_value();
/* 153 */     this.receiveRoleGiftNum = xRole2FriendsCircleInfo.getReceive_gift_num();
/*     */     
/*     */ 
/* 156 */     SReceiveFriendsCircleGiftSuccess sReceiveFriendsCircleGiftSuccess = new SReceiveFriendsCircleGiftSuccess();
/* 157 */     sReceiveFriendsCircleGiftSuccess.gift_grade = this.giftGrade;
/* 158 */     sReceiveFriendsCircleGiftSuccess.item_cfg_id = this.giftItemCfgId;
/* 159 */     sReceiveFriendsCircleGiftSuccess.popularity_week_value = nowWeekPopularity;
/* 160 */     sReceiveFriendsCircleGiftSuccess.popularity_total_value = xRole2FriendsCircleInfo.getTotal_popularity_value();
/* 161 */     sReceiveFriendsCircleGiftSuccess.active_send_gift_role_name.setString(this.activeGiveRoleName, "UTF-8");
/* 162 */     sReceiveFriendsCircleGiftSuccess.message.setString(this.giveGiftMessage, "UTF-8");
/* 163 */     sReceiveFriendsCircleGiftSuccess.now_receive_gift_num = xRole2FriendsCircleInfo.getReceive_gift_num();
/*     */     
/* 165 */     OnlineManager.getInstance().send(this.receiveGiftRoleId, sReceiveFriendsCircleGiftSuccess);
/*     */     
/*     */ 
/* 168 */     SFriendsCircleGivePresentItemGradeCfg sFriendsCircleGivePresentItemGradeCfg = SFriendsCircleGivePresentItemGradeCfg.get(this.giftItemCfgId);
/* 169 */     if (sFriendsCircleGivePresentItemGradeCfg != null)
/*     */     {
/* 171 */       Integer giftCfgId = (Integer)sFriendsCircleGivePresentItemGradeCfg.grade_map.get(Integer.valueOf(this.giftGrade));
/* 172 */       if (giftCfgId != null)
/*     */       {
/* 174 */         SFriendsCircleGivePresentCfg sFriendsCircleGivePresentBroadcastCfg = SFriendsCircleGivePresentCfg.get(giftCfgId.intValue());
/* 175 */         if ((sFriendsCircleGivePresentBroadcastCfg != null) && (sFriendsCircleGivePresentBroadcastCfg.is_broadcast))
/*     */         {
/* 177 */           FriendsCircleManager.sendGiveGiftBulletin(this.activeGiveRoleName, RoleInterface.getName(this.receiveGiftRoleId), this.giftItemCfgId, this.giftItemNum, this.giveGiftMessage, sFriendsCircleGivePresentBroadcastCfg.is_broadcast_effect ? sFriendsCircleGivePresentBroadcastCfg.special_effect_cfg_id : -1);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 189 */     TriggerEventsManger.getInstance().triggerEvent(new FriendsCirclePopularityAdd(), new FriendsCirclePopularityAddArg(this.receiveGiftRoleId, this.addPopularityValue, xRole2FriendsCircleInfo.getTotal_popularity_value(), xRole2FriendsCircleInfo.getCurrent_week_popularity_value()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.receiveGiftRoleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 196 */     TriggerEventsManger.getInstance().triggerEvent(new FriendsCircleReceiveGift(), new FriendsCircleReceiveGiftArg(this.receiveGiftRoleId, this.activeGiveGiftRoleId, this.giftItemCfgId, this.giftItemNum), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.receiveGiftRoleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 203 */     FriendsCircleManager.reportGiveFriendsCircleGift(this.receiveGiftRoleId, this.activeGiveGiftRoleId, this.giftItemCfgId, this.giftItemNum, this.addPopularityValue, 0, this.giveGiftMessage, this.serialId);
/*     */     
/*     */ 
/* 206 */     StringBuilder sbLog = new StringBuilder();
/* 207 */     sbLog.append("[friendscircle]POnCrossServerGiveFriendsCircleGift.processImp@give friends gfit success");
/* 208 */     sbLog.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/* 209 */     sbLog.append("|active_give_role_name=").append(this.activeGiveRoleName);
/* 210 */     sbLog.append("|active_give_gift_zone_id=").append(this.activeGiveGiftZoneId);
/* 211 */     sbLog.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/* 212 */     sbLog.append("|gift_item_num=").append(this.giftItemNum);
/* 213 */     sbLog.append("|gift_grade=").append(this.giftGrade);
/* 214 */     sbLog.append("|serial_id=").append(this.serialId);
/*     */     
/* 216 */     GameServer.logger().info(sbLog.toString());
/* 217 */     return true;
/*     */   }
/*     */   
/*     */   private void onCrossServerGiveFriendsCircleGiftFail(int ret)
/*     */   {
/* 222 */     onCrossServerGiveFriendsCircleGiftFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCrossServerGiveFriendsCircleGiftFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 227 */     StringBuilder sbLog = new StringBuilder();
/* 228 */     sbLog.append("[friendscircle]POnCrossServerGiveFriendsCircleGift.processImp@give friends gfit failed");
/* 229 */     sbLog.append("|ret=").append(ret);
/* 230 */     sbLog.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/* 231 */     sbLog.append("|active_give_role_name=").append(this.activeGiveRoleName);
/* 232 */     sbLog.append("|active_give_gift_zone_id=").append(this.activeGiveGiftZoneId);
/* 233 */     sbLog.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/* 234 */     sbLog.append("|gift_item_num=").append(this.giftItemNum);
/* 235 */     sbLog.append("|gift_grade=").append(this.giftGrade);
/* 236 */     sbLog.append("|serial_id=").append(this.serialId);
/*     */     
/* 238 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 240 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 242 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 245 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerGiveFriendsCircleGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */