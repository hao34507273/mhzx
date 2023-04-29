/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentCfg;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentItemGradeCfg;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.friendscircle.SGiveFriendsCircleGiftSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleGift;
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
/*     */ 
/*     */ 
/*     */ public class POnCrossServerGiveFriendsCircleGiftRsp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long activeGiveGiftRoleId;
/*     */   private final String receiveGiftRoleName;
/*     */   private final int receiveGiveGiftZoneId;
/*     */   private final long receiveGiftRoleId;
/*     */   private final int giftItemCfgId;
/*     */   private final int giftItemNum;
/*     */   private final int giftGrade;
/*     */   private final int addPopularityValue;
/*     */   private final String giveGiftMessage;
/*     */   private final int receiveRoleTotalPopularity;
/*     */   private final int receiveRoleWeekPopularity;
/*     */   private final int receiveRoleGiftNum;
/*     */   private final long serialId;
/*     */   private final int result;
/*     */   
/*     */   public POnCrossServerGiveFriendsCircleGiftRsp(long activeGiveGiftRoleId, String activeGiveRoleName, int receiveGiveGiftZoneId, long receiveGiftRoleId, int giftItemId, int giftItemNum, int giftGrade, int addPopularityValue, String giveGiftMessage, int receiveRoleTotalPopularity, int receiveRoleWeekPopularity, int receiveRoleGiftNum, long serialId, int result)
/*     */   {
/*  53 */     this.activeGiveGiftRoleId = activeGiveGiftRoleId;
/*  54 */     this.receiveGiftRoleName = activeGiveRoleName;
/*  55 */     this.receiveGiveGiftZoneId = receiveGiveGiftZoneId;
/*  56 */     this.receiveGiftRoleId = receiveGiftRoleId;
/*  57 */     this.giftItemCfgId = giftItemId;
/*  58 */     this.giftItemNum = giftItemNum;
/*  59 */     this.giftGrade = giftGrade;
/*  60 */     this.addPopularityValue = addPopularityValue;
/*  61 */     this.giveGiftMessage = giveGiftMessage;
/*  62 */     this.receiveRoleTotalPopularity = receiveRoleTotalPopularity;
/*  63 */     this.receiveRoleWeekPopularity = receiveRoleWeekPopularity;
/*  64 */     this.receiveRoleGiftNum = receiveRoleGiftNum;
/*  65 */     this.serialId = serialId;
/*  66 */     this.result = result;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  72 */     String userId = RoleInterface.getUserId(this.activeGiveGiftRoleId);
/*  73 */     if (userId == null)
/*     */     {
/*  75 */       onCrossServerGiveFriendsCircleGiftRspFail(6);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (this.result == 1)
/*     */     {
/*  81 */       onCrossServerGiveFriendsCircleGiftRspFail(30);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if ((this.result != 0) && (this.result != 3))
/*     */     {
/*     */ 
/*  88 */       onCrossServerGiveFriendsCircleGiftRspFail(42);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     lock(Lockeys.get(User.getTable(), userId));
/*  93 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.activeGiveGiftRoleId);
/*     */     
/*  95 */     CrossServerFriendsCircleGift xCrossServerFriendsCircleGift = (CrossServerFriendsCircleGift)xRole2FriendsCircleInfo.getCross_server_send_gift().get(Long.valueOf(this.serialId));
/*     */     
/*  97 */     if (xCrossServerFriendsCircleGift == null)
/*     */     {
/*  99 */       onCrossServerGiveFriendsCircleGiftRspFail(39);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (xCrossServerFriendsCircleGift.getIs_server_replied())
/*     */     {
/* 105 */       onCrossServerGiveFriendsCircleGiftRspFail(34);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if ((xCrossServerFriendsCircleGift.getItem_cfg_id() != this.giftItemCfgId) || (xCrossServerFriendsCircleGift.getItem_grade() != this.giftGrade) || (xCrossServerFriendsCircleGift.getItem_num() != this.giftItemNum) || (xCrossServerFriendsCircleGift.getReceive_gift_role_id() != this.receiveGiftRoleId) || (xCrossServerFriendsCircleGift.getReceive_gift_role_zone_id() != this.receiveGiveGiftZoneId) || (xCrossServerFriendsCircleGift.getAdd_popularity_value() != this.addPopularityValue))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 116 */       Map<String, Object> extraMap = new HashMap();
/* 117 */       extraMap.put("x_gift_item_cfg_id", Integer.valueOf(xCrossServerFriendsCircleGift.getItem_cfg_id()));
/* 118 */       extraMap.put("x_gift_grade", Integer.valueOf(xCrossServerFriendsCircleGift.getItem_grade()));
/* 119 */       extraMap.put("x_gift_num", Integer.valueOf(xCrossServerFriendsCircleGift.getItem_num()));
/* 120 */       extraMap.put("x_receive_gift_role_id", Long.valueOf(xCrossServerFriendsCircleGift.getReceive_gift_role_id()));
/* 121 */       extraMap.put("x_receive_gift_zone_id", Integer.valueOf(xCrossServerFriendsCircleGift.getReceive_gift_role_zone_id()));
/* 122 */       extraMap.put("x_add_popularity_value", Integer.valueOf(xCrossServerFriendsCircleGift.getAdd_popularity_value()));
/*     */       
/* 124 */       onCrossServerGiveFriendsCircleGiftRspFail(40, extraMap);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     xCrossServerFriendsCircleGift.setIs_server_replied(true);
/*     */     
/*     */ 
/* 131 */     SFriendsCircleGivePresentItemGradeCfg sFriendsCircleGivePresentItemGradeCfg = SFriendsCircleGivePresentItemGradeCfg.get(this.giftItemCfgId);
/* 132 */     if (sFriendsCircleGivePresentItemGradeCfg != null)
/*     */     {
/* 134 */       Integer giftCfgId = (Integer)sFriendsCircleGivePresentItemGradeCfg.grade_map.get(Integer.valueOf(this.giftGrade));
/* 135 */       if (giftCfgId != null)
/*     */       {
/* 137 */         SFriendsCircleGivePresentCfg sFriendsCircleGivePresentCfg = SFriendsCircleGivePresentCfg.get(giftCfgId.intValue());
/* 138 */         if ((sFriendsCircleGivePresentCfg != null) && (sFriendsCircleGivePresentCfg.is_broadcast))
/*     */         {
/* 140 */           FriendsCircleManager.sendGiveGiftBulletin(RoleInterface.getName(this.activeGiveGiftRoleId), this.receiveGiftRoleName, this.giftItemCfgId, this.giftItemNum, this.giveGiftMessage, sFriendsCircleGivePresentCfg.is_broadcast_effect ? sFriendsCircleGivePresentCfg.special_effect_cfg_id : -1);
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
/*     */ 
/* 153 */     SGiveFriendsCircleGiftSuccess sGiveFriendsCircleGiftSuccess = new SGiveFriendsCircleGiftSuccess();
/* 154 */     sGiveFriendsCircleGiftSuccess.item_cfg_id = this.giftItemCfgId;
/* 155 */     sGiveFriendsCircleGiftSuccess.gift_grade = this.giftGrade;
/* 156 */     sGiveFriendsCircleGiftSuccess.receive_gift_role_name.setString(this.receiveGiftRoleName, "UTf-8");
/* 157 */     sGiveFriendsCircleGiftSuccess.popularity_total_value = this.receiveRoleTotalPopularity;
/* 158 */     sGiveFriendsCircleGiftSuccess.popularity_week_value = this.receiveRoleWeekPopularity;
/* 159 */     sGiveFriendsCircleGiftSuccess.now_receive_gift_num = this.receiveRoleGiftNum;
/* 160 */     sGiveFriendsCircleGiftSuccess.message.setString(this.giveGiftMessage, "UTF-8");
/* 161 */     sGiveFriendsCircleGiftSuccess.receive_gift_role_id = this.receiveGiftRoleId;
/*     */     
/* 163 */     OnlineManager.getInstance().send(this.activeGiveGiftRoleId, sGiveFriendsCircleGiftSuccess);
/*     */     
/* 165 */     StringBuilder sBuilder = new StringBuilder();
/* 166 */     sBuilder.append("[friendscircle]POnCrossServerGiveFriendsCircleGiftRsp.processImp@handle give friends circle gift rsp failed");
/* 167 */     sBuilder.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/* 168 */     sBuilder.append("|receive_gift_role_name=").append(this.receiveGiftRoleName);
/* 169 */     sBuilder.append("|active_give_gift_zone_id=").append(this.receiveGiveGiftZoneId);
/* 170 */     sBuilder.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/* 171 */     sBuilder.append("|gift_item_num=").append(this.giftItemNum);
/* 172 */     sBuilder.append("|gift_grade=").append(this.giftGrade);
/* 173 */     sBuilder.append("|serial_id=").append(this.serialId);
/* 174 */     sBuilder.append("|result=").append(this.result);
/*     */     
/* 176 */     GameServer.logger().info(sBuilder.toString());
/* 177 */     return true;
/*     */   }
/*     */   
/*     */   private void onCrossServerGiveFriendsCircleGiftRspFail(int ret)
/*     */   {
/* 182 */     onCrossServerGiveFriendsCircleGiftRspFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCrossServerGiveFriendsCircleGiftRspFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 187 */     StringBuilder sbLog = new StringBuilder();
/* 188 */     sbLog.append("[friendscircle]POnCrossServerGiveFriendsCircleGiftRsp.processImp@handle give friends circle gift rsp failed");
/* 189 */     sbLog.append("|ret=").append(ret);
/* 190 */     sbLog.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/* 191 */     sbLog.append("|receive_gift_role_name=").append(this.receiveGiftRoleName);
/* 192 */     sbLog.append("|receive_give_gift_zone_id=").append(this.receiveGiveGiftZoneId);
/* 193 */     sbLog.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/* 194 */     sbLog.append("|gift_item_num=").append(this.giftItemNum);
/* 195 */     sbLog.append("|gift_grade=").append(this.giftGrade);
/* 196 */     sbLog.append("|serial_id=").append(this.serialId);
/* 197 */     sbLog.append("|result=").append(this.result);
/*     */     
/* 199 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 201 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 203 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 206 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 208 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 209 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 211 */     OnlineManager.getInstance().sendAtOnce(this.activeGiveGiftRoleId, sFriendsCircleNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerGiveFriendsCircleGiftRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */