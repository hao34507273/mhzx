/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.item.SCommonErrorInfo;
/*     */ import mzm.gsp.item.SItemClickRemoveSuccess;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.STimeEffectItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCItemClickRemoveReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuId;
/*     */   private int itemCfgId;
/*     */   
/*     */   public PCItemClickRemoveReq(long roleId, long uuId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.uuId = uuId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     String userId = RoleInterface.getUserId(this.roleId);
/*  43 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  45 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.uuId);
/*  46 */     if (basicItem == null)
/*     */     {
/*  48 */       onItemClickRemoveReqFail(102);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1061, true, true))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     this.itemCfgId = basicItem.getCfgId();
/*     */     
/*  59 */     SItemCfg sItemCfg = SItemCfg.get(this.itemCfgId);
/*  60 */     if (sItemCfg == null)
/*     */     {
/*  62 */       onItemClickRemoveReqFail(101);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!checkIsCanRemove(basicItem, sItemCfg.type))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     boolean removeResult = ItemManager.removeExpiredItemByUuid(this.roleId, this.uuId, basicItem.getNumber(), new TLogArg(LogReason.CLICK_REMOVE_ITEM));
/*     */     
/*  73 */     if (!removeResult)
/*     */     {
/*  75 */       onItemClickRemoveReqFail(40);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     SItemClickRemoveSuccess sItemClickRemoveSuccess = new SItemClickRemoveSuccess();
/*  80 */     sItemClickRemoveSuccess.item_cfg_id = this.itemCfgId;
/*     */     
/*  82 */     OnlineManager.getInstance().send(this.roleId, sItemClickRemoveSuccess);
/*     */     
/*  84 */     StringBuilder sb = new StringBuilder();
/*  85 */     sb.append("[item]PCItemClickRemoveReq.processImp@item click remove success");
/*  86 */     sb.append("|role_id=").append(this.roleId);
/*  87 */     sb.append("|uuid=").append(this.uuId);
/*  88 */     sb.append("|item_cfg_id=").append(this.itemCfgId);
/*     */     
/*  90 */     GameServer.logger().info(sb.toString());
/*     */     
/*  92 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkIsCanRemove(BasicItem basicItem, int itemType)
/*     */   {
/*  97 */     if (checkTimeIsCanRemove(basicItem.xItem))
/*     */     {
/*  99 */       return true;
/*     */     }
/*     */     
/* 102 */     switch (itemType)
/*     */     {
/*     */     case 113: 
/* 105 */       Integer leftExpBottleValue = basicItem.getExtra(ItemStoreEnum.LEFT_BOTTLE_EXP_VALUE);
/* 106 */       if ((leftExpBottleValue == null) || (leftExpBottleValue.intValue() != 0))
/*     */       {
/* 108 */         Map<String, Object> extraMap = new HashMap();
/* 109 */         extraMap.put("left_exp_bottle_value", leftExpBottleValue);
/*     */         
/* 111 */         onItemClickRemoveReqFail(1180, extraMap);
/* 112 */         return false;
/*     */       }
/* 114 */       return true;
/*     */     
/*     */     case 114: 
/* 117 */       Integer leftDoubleItemTimes = basicItem.getExtra(ItemStoreEnum.LEFT_DOUBLE_ITEM_USE_TIMES);
/* 118 */       if ((leftDoubleItemTimes == null) || (leftDoubleItemTimes.intValue() != 0))
/*     */       {
/* 120 */         Map<String, Object> extraMap = new HashMap();
/* 121 */         extraMap.put("left_double_item_times", leftDoubleItemTimes);
/*     */         
/* 123 */         onItemClickRemoveReqFail(1180, extraMap);
/* 124 */         return false;
/*     */       }
/* 126 */       return true;
/*     */     }
/*     */     
/* 129 */     onItemClickRemoveReqFail(1179);
/* 130 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onItemClickRemoveReqFail(int ret)
/*     */   {
/* 136 */     onItemClickRemoveReqFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onItemClickRemoveReqFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 141 */     StringBuilder sbLog = new StringBuilder();
/* 142 */     sbLog.append("[item]PCItemClickRemoveReq.processImp@item click remove failed");
/* 143 */     sbLog.append("|ret=").append(ret);
/* 144 */     sbLog.append("|role_id=").append(this.roleId);
/* 145 */     sbLog.append("|uuid=").append(this.uuId);
/* 146 */     sbLog.append("|item_cfg_id=").append(this.itemCfgId);
/*     */     
/* 148 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 150 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 152 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 155 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 157 */     SCommonErrorInfo sCommonErrorInfo = new SCommonErrorInfo();
/* 158 */     sCommonErrorInfo.errorcode = ret;
/*     */     
/* 160 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonErrorInfo);
/*     */   }
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
/*     */   private boolean checkTimeIsCanRemove(Item xItem)
/*     */   {
/* 174 */     if (xItem == null)
/*     */     {
/* 176 */       return false;
/*     */     }
/*     */     
/* 179 */     int itemCfgId = xItem.getCfgid();
/*     */     
/* 181 */     STimeEffectItemCfg sTimeEffectItemCfg = STimeEffectItemCfg.get(itemCfgId);
/* 182 */     if (sTimeEffectItemCfg == null)
/*     */     {
/* 184 */       return false;
/*     */     }
/*     */     
/* 187 */     if ((sTimeEffectItemCfg.item_time_type == 2) || (sTimeEffectItemCfg.item_time_type == 3))
/*     */     {
/*     */ 
/* 190 */       Map<Integer, Integer> xExtraMap = xItem.getExtra();
/* 191 */       Integer endTime = (Integer)xExtraMap.get(Integer.valueOf(231));
/* 192 */       if ((endTime != null) && (endTime.intValue() <= DateTimeUtils.getCurrTimeInMillis() / 1000L))
/*     */       {
/* 194 */         return true;
/*     */       }
/*     */     }
/* 197 */     else if (sTimeEffectItemCfg.item_time_type == 1)
/*     */     {
/* 199 */       STimePointCommonCfg sBeginTimePointCommonCfg = STimePointCommonCfg.get(sTimeEffectItemCfg.begin_effect_time_cfg_id);
/* 200 */       STimePointCommonCfg sEndTimePointCommonCfg = STimePointCommonCfg.get(sTimeEffectItemCfg.end_effect_time_cfg_id);
/* 201 */       if ((sBeginTimePointCommonCfg == null) && (sEndTimePointCommonCfg == null))
/*     */       {
/* 203 */         return false;
/*     */       }
/*     */       
/* 206 */       int endTime = sEndTimePointCommonCfg == null ? 0 : (int)(TimeCommonUtil.getTimePoint(sEndTimePointCommonCfg) / 1000L);
/*     */       
/*     */ 
/* 209 */       int currentTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 210 */       if ((currentTime > endTime) && (endTime > 0))
/*     */       {
/* 212 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 216 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCItemClickRemoveReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */