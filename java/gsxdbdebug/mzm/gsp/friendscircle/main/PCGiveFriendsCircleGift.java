/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentCfg;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentGradeCfg;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentItemGradeCfg;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleGivePresentPopularityCfg;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.friendscircle.SGiveFriendsCircleGiftSuccess;
/*     */ import mzm.gsp.friendscircle.SReceiveFriendsCircleGiftSuccess;
/*     */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAddArg;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleReceiveGift;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleReceiveGiftArg;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleSendGift;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleSendGiftArg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleGift;
/*     */ import xbean.FriendsCircleGiftResult;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGiveFriendsCircleGift extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long receiveGiftRoleId;
/*     */   private final int receiveGiftRoleZoneId;
/*     */   private final int itemCfgId;
/*     */   private final int giftGrade;
/*     */   private final long clientCurrencyValue;
/*     */   private final boolean isUseYuanBao;
/*     */   private final String message;
/*     */   private final int clientNeedYuanBao;
/*     */   
/*     */   public PCGiveFriendsCircleGift(long roleId, long receiveGiftRoleId, int receiveGiftRoleZoneId, int itemCfgId, int giftGrade, long clientCurrencyValue, boolean isUseYuanBao, Octets messageOctets, int clientNeedYuanBao)
/*     */   {
/*  64 */     this.roleId = roleId;
/*  65 */     this.receiveGiftRoleId = receiveGiftRoleId;
/*  66 */     this.receiveGiftRoleZoneId = receiveGiftRoleZoneId;
/*  67 */     this.itemCfgId = itemCfgId;
/*  68 */     this.giftGrade = giftGrade;
/*  69 */     this.clientCurrencyValue = clientCurrencyValue;
/*  70 */     this.isUseYuanBao = isUseYuanBao;
/*  71 */     this.message = messageOctets.getString("UTF-8");
/*  72 */     this.clientNeedYuanBao = clientNeedYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  78 */     int serverCalRoleZoneId = GameServerInfoManager.getZoneidFromRoleid(this.receiveGiftRoleId);
/*  79 */     if (this.receiveGiftRoleZoneId != serverCalRoleZoneId)
/*     */     {
/*  81 */       Map<String, Object> extraMap = new HashMap();
/*  82 */       extraMap.put("client_server_id", Integer.valueOf(this.receiveGiftRoleZoneId));
/*  83 */       extraMap.put("server_cal_role_zone_id", Integer.valueOf(serverCalRoleZoneId));
/*     */       
/*  85 */       onGiveFriendsCircleGiftFail(62, extraMap);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (!FriendsCircleManager.timeIsCanAddPopularity())
/*     */     {
/*  91 */       onGiveFriendsCircleGiftFail(51);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     String activeUserId = RoleInterface.getUserId(this.roleId);
/*  96 */     if (activeUserId == null)
/*     */     {
/*  98 */       onGiveFriendsCircleGiftFail(6);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/* 104 */       onGiveFriendsCircleGiftFail(1);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 452, true))
/*     */     {
/* 110 */       onGiveFriendsCircleGiftFail(4);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if (GameServerInfoManager.isValidZone(this.receiveGiftRoleZoneId))
/*     */     {
/* 116 */       String receiveGiftUserId = RoleInterface.getUserId(this.receiveGiftRoleId);
/* 117 */       if (receiveGiftUserId == null)
/*     */       {
/* 119 */         onGiveFriendsCircleGiftFail(30);
/* 120 */         return false;
/*     */       }
/* 122 */       lock(User.getTable(), Arrays.asList(new String[] { activeUserId, receiveGiftUserId }));
/* 123 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.receiveGiftRoleId) }));
/*     */       
/* 125 */       return buyGift(activeUserId, false);
/*     */     }
/*     */     
/*     */ 
/* 129 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 472, true))
/*     */     {
/*     */ 
/* 132 */       onGiveFriendsCircleGiftFail(54);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     lock(Lockeys.get(User.getTable(), activeUserId));
/*     */     
/* 138 */     return buyGift(activeUserId, true);
/*     */   }
/*     */   
/*     */   private boolean buyGift(String activeUserId, boolean isCrossServer)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 144 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 145 */     if (roleLevel < SFriendsCircleConsts.getInstance().give_gift_open_role_level)
/*     */     {
/* 147 */       onGiveFriendsCircleGiftFail(46);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1822, true, true))
/*     */     {
/* 153 */       onGiveFriendsCircleGiftFail(47);
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     if (!RoleStatusInterface.checkCanSetStatus(this.receiveGiftRoleId, 1822, false, true))
/*     */     {
/* 160 */       onGiveFriendsCircleGiftFail(69);
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     int length = (int)Math.ceil(CommonUtils.getUTF16Length(this.message) / 2.0D);
/* 165 */     if (length > SFriendsCircleConsts.getInstance().present_message_character_max_num)
/*     */     {
/* 167 */       onGiveFriendsCircleGiftFail(37);
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     if (SensitiveInterface.isContentSensitive(this.message))
/*     */     {
/* 173 */       onGiveFriendsCircleGiftFail(38);
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     long serverYuanBao = QingfuInterface.getBalance(activeUserId, true);
/* 178 */     if (serverYuanBao != this.clientCurrencyValue)
/*     */     {
/* 180 */       onGiveFriendsCircleGiftFail(7);
/* 181 */       return false;
/*     */     }
/*     */     
/* 184 */     SFriendsCircleGivePresentGradeCfg sFriendsCircleGivePresentGradeCfg = SFriendsCircleGivePresentGradeCfg.get(this.giftGrade);
/* 185 */     if (sFriendsCircleGivePresentGradeCfg == null)
/*     */     {
/* 187 */       onGiveFriendsCircleGiftFail(26);
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     SFriendsCircleGivePresentItemGradeCfg sFriendsCircleGivePresentItemGradeCfg = SFriendsCircleGivePresentItemGradeCfg.get(this.itemCfgId);
/* 192 */     if (sFriendsCircleGivePresentItemGradeCfg == null)
/*     */     {
/* 194 */       onGiveFriendsCircleGiftFail(25);
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     Integer giftCfgId = (Integer)sFriendsCircleGivePresentItemGradeCfg.grade_map.get(Integer.valueOf(this.giftGrade));
/* 199 */     if (giftCfgId == null)
/*     */     {
/* 201 */       onGiveFriendsCircleGiftFail(27);
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     SFriendsCircleGivePresentPopularityCfg sFriendsCircleGivePresentPopularityCfg = SFriendsCircleGivePresentPopularityCfg.get(this.itemCfgId);
/* 206 */     if (sFriendsCircleGivePresentPopularityCfg == null)
/*     */     {
/* 208 */       onGiveFriendsCircleGiftFail(29);
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     int needItemNum = sFriendsCircleGivePresentGradeCfg.present_num;
/* 213 */     int ownItemNum = ItemInterface.getItemNumberById(this.roleId, this.itemCfgId);
/* 214 */     int needRemoveItemNum = 0;
/* 215 */     if (ownItemNum < needItemNum)
/*     */     {
/* 217 */       if (!this.isUseYuanBao)
/*     */       {
/* 219 */         onGiveFriendsCircleGiftFail(23);
/* 220 */         return false;
/*     */       }
/*     */       
/* 223 */       int itemYuanBaoPrice = ItemInterface.getItemYuanBaoPrice(this.itemCfgId);
/* 224 */       int needYuanBao = itemYuanBaoPrice * (needItemNum - ownItemNum);
/*     */       
/* 226 */       if (needYuanBao != this.clientNeedYuanBao)
/*     */       {
/* 228 */         Map<String, Object> extraMap = new HashMap();
/* 229 */         extraMap.put("item_yuan_bao_price", Integer.valueOf(itemYuanBaoPrice));
/* 230 */         extraMap.put("need_yuan_bao", Integer.valueOf(needYuanBao));
/* 231 */         extraMap.put("need_item_num", Integer.valueOf(needItemNum));
/* 232 */         extraMap.put("own_item_num", Integer.valueOf(ownItemNum));
/*     */         
/* 234 */         onGiveFriendsCircleGiftFail(67, extraMap);
/* 235 */         return false;
/*     */       }
/*     */       
/* 238 */       if ((needYuanBao > serverYuanBao) || (needYuanBao <= 0))
/*     */       {
/* 240 */         Map<String, Object> extraMap = new HashMap();
/* 241 */         extraMap.put("item_yuan_bao_price", Integer.valueOf(itemYuanBaoPrice));
/* 242 */         extraMap.put("need_item_num", Integer.valueOf(needItemNum));
/* 243 */         extraMap.put("own_item_num", Integer.valueOf(ownItemNum));
/* 244 */         extraMap.put("need_yuan_bao", Integer.valueOf(needYuanBao));
/*     */         
/* 246 */         onGiveFriendsCircleGiftFail(8, extraMap);
/* 247 */         return false;
/*     */       }
/* 249 */       needRemoveItemNum = ownItemNum;
/*     */       
/* 251 */       CostResult costResult = QingfuInterface.costYuanbao(activeUserId, this.roleId, needYuanBao, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_FRIENDS_CIRCLE_GIVE_GIFT, new TLogArg(LogReason.FRIENDS_CIRCLE_GIVE_PRESENT_COST_YUAN_BAO));
/*     */       
/*     */ 
/* 254 */       if (costResult != CostResult.Success)
/*     */       {
/* 256 */         onGiveFriendsCircleGiftFail(9);
/* 257 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 262 */       if (this.isUseYuanBao)
/*     */       {
/* 264 */         onGiveFriendsCircleGiftFail(24);
/* 265 */         return false;
/*     */       }
/* 267 */       needRemoveItemNum = needItemNum;
/*     */     }
/*     */     
/* 270 */     if (needRemoveItemNum > 0)
/*     */     {
/* 272 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemsWithBindFirst(this.roleId, this.itemCfgId, needRemoveItemNum, new TLogArg(LogReason.FRIENDS_CIRCLE_GIVE_PRESENT_REMOVE_ITEM));
/*     */       
/* 274 */       if (!itemOperateResult.success())
/*     */       {
/* 276 */         onGiveFriendsCircleGiftFail(22);
/* 277 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 281 */     int giftItemNum = sFriendsCircleGivePresentGradeCfg.present_num;
/* 282 */     int addPopularityValue = giftItemNum * sFriendsCircleGivePresentPopularityCfg.add_popularity_values;
/*     */     
/* 284 */     TriggerEventsManger.getInstance().triggerEvent(new FriendsCircleSendGift(), new FriendsCircleSendGiftArg(this.roleId, this.receiveGiftRoleId, this.itemCfgId, giftItemNum), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/* 288 */     long serialId = 0L;
/* 289 */     if (isCrossServer)
/*     */     {
/*     */ 
/* 292 */       Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*     */       
/* 294 */       if (xRole2FriendsCircleInfo.getCross_server_black_in_role_set().contains(Long.valueOf(this.receiveGiftRoleId)))
/*     */       {
/* 296 */         onGiveFriendsCircleGiftFail(65);
/* 297 */         return false;
/*     */       }
/*     */       
/* 300 */       serialId = FriendsCircleManager.getFriendsCircleSerialId();
/*     */       
/*     */ 
/* 303 */       CrossServerFriendsCircleGift xFriendsCircleGift = Pod.newCrossServerFriendsCircleGift();
/* 304 */       xFriendsCircleGift.setIs_server_replied(false);
/* 305 */       xFriendsCircleGift.setItem_cfg_id(this.itemCfgId);
/* 306 */       xFriendsCircleGift.setItem_grade(this.giftGrade);
/* 307 */       xFriendsCircleGift.setItem_num(sFriendsCircleGivePresentGradeCfg.present_num);
/* 308 */       xFriendsCircleGift.setReceive_gift_role_id(this.receiveGiftRoleId);
/* 309 */       xFriendsCircleGift.setReceive_gift_role_zone_id(this.receiveGiftRoleZoneId);
/* 310 */       xFriendsCircleGift.setAdd_popularity_value(addPopularityValue);
/* 311 */       xFriendsCircleGift.setMessage(this.message);
/*     */       
/* 313 */       xRole2FriendsCircleInfo.getCross_server_send_gift().put(Long.valueOf(serialId), xFriendsCircleGift);
/*     */       
/* 315 */       CrossServerInterface.giveFriendsCircleGift(this.roleId, RoleInterface.getName(this.roleId), this.receiveGiftRoleId, this.receiveGiftRoleZoneId, this.itemCfgId, this.giftGrade, giftItemNum, addPopularityValue, this.message, serialId);
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 322 */       Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.receiveGiftRoleId);
/* 323 */       if (xRole2FriendsCircleInfo.getMy_black_role_list().contains(Long.valueOf(this.roleId)))
/*     */       {
/* 325 */         onGiveFriendsCircleGiftFail(65);
/* 326 */         return false;
/*     */       }
/*     */       
/* 329 */       Role2FriendsCircleInfo xActiveRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/* 330 */       if (xActiveRole2FriendsCircleInfo.getMy_black_role_list().contains(Long.valueOf(this.receiveGiftRoleId)))
/*     */       {
/* 332 */         onGiveFriendsCircleGiftFail(64);
/* 333 */         return false;
/*     */       }
/*     */       
/* 336 */       int nowWeekPopularity = FriendsCircleManager.addAndGetWeekPopularity(this.receiveGiftRoleId, xRole2FriendsCircleInfo, addPopularityValue).intValue();
/*     */       
/*     */ 
/* 339 */       xRole2FriendsCircleInfo.setReceive_gift_num(xRole2FriendsCircleInfo.getReceive_gift_num() + giftItemNum);
/*     */       
/* 341 */       xRole2FriendsCircleInfo.setTotal_popularity_value(xRole2FriendsCircleInfo.getTotal_popularity_value() + addPopularityValue);
/*     */       
/*     */ 
/* 344 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.friendscircle.event.FriendsCirclePopularityAdd(), new FriendsCirclePopularityAddArg(this.receiveGiftRoleId, addPopularityValue, xRole2FriendsCircleInfo.getTotal_popularity_value(), xRole2FriendsCircleInfo.getCurrent_week_popularity_value()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.receiveGiftRoleId)));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 351 */       TriggerEventsManger.getInstance().triggerEvent(new FriendsCircleReceiveGift(), new FriendsCircleReceiveGiftArg(this.receiveGiftRoleId, this.roleId, this.itemCfgId, giftItemNum), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.receiveGiftRoleId)));
/*     */       
/*     */ 
/*     */ 
/* 355 */       SReceiveFriendsCircleGiftSuccess sReceiveFriendsCircleGiftSuccess = new SReceiveFriendsCircleGiftSuccess();
/* 356 */       sReceiveFriendsCircleGiftSuccess.gift_grade = this.giftGrade;
/* 357 */       sReceiveFriendsCircleGiftSuccess.item_cfg_id = this.itemCfgId;
/* 358 */       sReceiveFriendsCircleGiftSuccess.popularity_week_value = nowWeekPopularity;
/* 359 */       sReceiveFriendsCircleGiftSuccess.popularity_total_value = xRole2FriendsCircleInfo.getTotal_popularity_value();
/* 360 */       sReceiveFriendsCircleGiftSuccess.now_receive_gift_num = xRole2FriendsCircleInfo.getReceive_gift_num();
/* 361 */       sReceiveFriendsCircleGiftSuccess.active_send_gift_role_name.setString(RoleInterface.getName(this.roleId), "UTF-8");
/* 362 */       sReceiveFriendsCircleGiftSuccess.message.setString(this.message, "UTF-8");
/*     */       
/* 364 */       OnlineManager.getInstance().send(this.receiveGiftRoleId, sReceiveFriendsCircleGiftSuccess);
/*     */       
/*     */ 
/* 367 */       SGiveFriendsCircleGiftSuccess sGiveFriendsCircleGiftSuccess = new SGiveFriendsCircleGiftSuccess();
/* 368 */       sGiveFriendsCircleGiftSuccess.item_cfg_id = this.itemCfgId;
/* 369 */       sGiveFriendsCircleGiftSuccess.gift_grade = this.giftGrade;
/* 370 */       sGiveFriendsCircleGiftSuccess.popularity_week_value = nowWeekPopularity;
/* 371 */       sGiveFriendsCircleGiftSuccess.popularity_total_value = xRole2FriendsCircleInfo.getTotal_popularity_value();
/* 372 */       sGiveFriendsCircleGiftSuccess.now_receive_gift_num = xRole2FriendsCircleInfo.getReceive_gift_num();
/* 373 */       sGiveFriendsCircleGiftSuccess.receive_gift_role_id = this.receiveGiftRoleId;
/* 374 */       sGiveFriendsCircleGiftSuccess.receive_gift_role_name.setString(RoleInterface.getName(this.receiveGiftRoleId), "UTF-8");
/*     */       
/* 376 */       sGiveFriendsCircleGiftSuccess.message.setString(this.message, "UTF-8");
/*     */       
/* 378 */       OnlineManager.getInstance().send(this.roleId, sGiveFriendsCircleGiftSuccess);
/*     */       
/*     */ 
/* 381 */       SFriendsCircleGivePresentCfg sFriendsCircleGivePresentCfg = SFriendsCircleGivePresentCfg.get(giftCfgId.intValue());
/* 382 */       if ((sFriendsCircleGivePresentCfg != null) && (sFriendsCircleGivePresentCfg.is_broadcast))
/*     */       {
/* 384 */         FriendsCircleManager.sendGiveGiftBulletin(RoleInterface.getName(this.roleId), RoleInterface.getName(this.receiveGiftRoleId), this.itemCfgId, giftItemNum, this.message, sFriendsCircleGivePresentCfg.is_broadcast_effect ? sFriendsCircleGivePresentCfg.special_effect_cfg_id : -1);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 390 */       serialId = FriendsCircleManager.getFriendsCircleSerialId();
/*     */       
/* 392 */       FriendsCircleGiftResult xFriendsCircleGiftResult = Pod.newFriendsCircleGiftResult();
/* 393 */       xFriendsCircleGiftResult.setGive_gift_role_id(this.roleId);
/* 394 */       xFriendsCircleGiftResult.setGive_gift_zone_id(GameServerInfoManager.getZoneId());
/* 395 */       xFriendsCircleGiftResult.setIs_cross_server(false);
/* 396 */       xFriendsCircleGiftResult.setIs_ssp_replied(false);
/* 397 */       xFriendsCircleGiftResult.setItem_cfg_id(this.itemCfgId);
/* 398 */       xFriendsCircleGiftResult.setItem_grade(this.giftGrade);
/* 399 */       xFriendsCircleGiftResult.setItem_num(giftItemNum);
/* 400 */       xFriendsCircleGiftResult.setAdd_popularity_value(addPopularityValue);
/*     */       
/* 402 */       xRole2FriendsCircleInfo.getBe_sent_gift().put(Long.valueOf(serialId), xFriendsCircleGiftResult);
/*     */       
/* 404 */       FriendsCircleManager.reportGiveFriendsCircleGift(this.receiveGiftRoleId, this.roleId, this.itemCfgId, sFriendsCircleGivePresentGradeCfg.present_num, addPopularityValue, 0, this.message, serialId);
/*     */       
/*     */ 
/* 407 */       StringBuilder sbLog = new StringBuilder();
/* 408 */       sbLog.append("[friends_circle]PCGiveFriendsCircleGift.buyGfit@send gift success");
/* 409 */       sbLog.append("|role_id=").append(this.roleId);
/* 410 */       sbLog.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/* 411 */       sbLog.append("|receive_gift_role_zone_id=").append(this.receiveGiftRoleZoneId);
/* 412 */       sbLog.append("|item_cfg_id=").append(this.itemCfgId);
/* 413 */       sbLog.append("|gift_grade=").append(this.giftGrade);
/* 414 */       sbLog.append("|client_currency_value=").append(this.clientCurrencyValue);
/* 415 */       sbLog.append("|is_use_yuan_bap=").append(this.isUseYuanBao);
/* 416 */       sbLog.append("|message=").append(this.message);
/* 417 */       sbLog.append("|serialId=").append(serialId);
/* 418 */       GameServer.logger().info(sbLog.toString());
/*     */     }
/*     */     
/* 421 */     tlogGiveFriendsCircleGift(activeUserId, this.roleId, serialId, this.receiveGiftRoleId, this.receiveGiftRoleZoneId, sFriendsCircleGivePresentGradeCfg.present_num);
/*     */     
/*     */ 
/* 424 */     return true;
/*     */   }
/*     */   
/*     */   private void onGiveFriendsCircleGiftFail(int ret)
/*     */   {
/* 429 */     onGiveFriendsCircleGiftFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onGiveFriendsCircleGiftFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 434 */     StringBuilder sbLog = new StringBuilder();
/* 435 */     sbLog.append("[friends_circle]PCGiveFriendsCircleGift.processImp@give friends circle gift  failed");
/* 436 */     sbLog.append("|ret=").append(ret);
/* 437 */     sbLog.append("|role_id=").append(this.roleId);
/* 438 */     sbLog.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/* 439 */     sbLog.append("|receive_gift_role_zone_id=").append(this.receiveGiftRoleZoneId);
/* 440 */     sbLog.append("|item_cfg_id=").append(this.itemCfgId);
/* 441 */     sbLog.append("|gift_grade=").append(this.giftGrade);
/* 442 */     sbLog.append("|client_currency_value=").append(this.clientCurrencyValue);
/* 443 */     sbLog.append("|is_use_yuan_bap=").append(this.isUseYuanBao);
/* 444 */     sbLog.append("|message=").append(this.message);
/*     */     
/* 446 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 448 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 450 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 453 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 455 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 456 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 458 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void tlogGiveFriendsCircleGift(String userId, long roleId, long serialId, long receiveGiftRoleId, int receiveGiftRoleZoneId, int itemNum)
/*     */   {
/* 467 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 469 */     StringBuilder sbLog = new StringBuilder();
/* 470 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 471 */     sbLog.append(userId).append('|');
/* 472 */     sbLog.append(roleId).append('|');
/* 473 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 475 */     sbLog.append(serialId).append('|');
/* 476 */     sbLog.append(receiveGiftRoleId).append('|');
/* 477 */     sbLog.append(receiveGiftRoleZoneId).append('|');
/* 478 */     sbLog.append(this.itemCfgId).append('|');
/* 479 */     sbLog.append(this.giftGrade).append('|');
/* 480 */     sbLog.append(itemNum);
/*     */     
/* 482 */     TLogManager.getInstance().addLog(roleId, "FriendsCircleGiveGift", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCGiveFriendsCircleGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */