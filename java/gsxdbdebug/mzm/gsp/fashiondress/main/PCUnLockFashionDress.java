/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SFashionDressNormalFailed;
/*     */ import mzm.gsp.fashiondress.SSelectPropertySuccess;
/*     */ import mzm.gsp.fashiondress.SUnLockFashionDressSuccess;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressUnLockConditionCfg;
/*     */ import mzm.gsp.fashiondress.event.FashionDressObserverArg;
/*     */ import mzm.gsp.fashiondress.event.GetNewFashionDress;
/*     */ import mzm.gsp.fashiondress.event.GetNewFashionDressArg;
/*     */ import mzm.gsp.fashiondress.event.PassiveSkillChangeArg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FashionDressInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.TransferOccupationFashionDress;
/*     */ import xdb.Lockeys;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2fashiondress;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUnLockFashionDress extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fashionDressCfgId;
/*     */   
/*     */   public PCUnLockFashionDress(long paramLong, int paramInt)
/*     */   {
/*  46 */     this.roleId = paramLong;
/*  47 */     this.fashionDressCfgId = paramInt;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if (!FashionDressManager.isFashionDressSwitchOpen(this.roleId, "PCUnLockFashionDress.processImp", true, true)) {
/*  54 */       return false;
/*     */     }
/*  56 */     if (!FashionDressManager.isLevelOpen(this.roleId, "PCUnLockFashionDress.processImp", true)) {
/*  57 */       return false;
/*     */     }
/*  59 */     String str = RoleInterface.getUserId(this.roleId);
/*  60 */     lock(Lockeys.get(User.getTable(), str));
/*  61 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 977, true, true)) {
/*  62 */       return false;
/*     */     }
/*  64 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(this.roleId));
/*  65 */     if (localRole2FashionDressInfo == null)
/*     */     {
/*  67 */       localRole2FashionDressInfo = Pod.newRole2FashionDressInfo();
/*  68 */       localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/*  69 */       Role2fashiondress.add(Long.valueOf(this.roleId), localRole2FashionDressInfo);
/*     */     }
/*  71 */     Map localMap = localRole2FashionDressInfo.getFashion_dress_map();
/*  72 */     if (localMap.get(Integer.valueOf(this.fashionDressCfgId)) != null)
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[fashiondress]PCUnLockFashionDress.processImp@aleardy has the fashion dress|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  76 */       return false;
/*     */     }
/*  78 */     SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(this.fashionDressCfgId);
/*  79 */     if (localSFashionDressCfg == null)
/*     */     {
/*  81 */       GameServer.logger().error(String.format("[fashiondress]PCUnLockFashionDress.processImp@fashion dress config not exist|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  83 */       return false;
/*     */     }
/*  85 */     if ((localSFashionDressCfg.fashionShowType == 2) && (!isReplaceFashionDressSwitchOpen())) {
/*  86 */       return false;
/*     */     }
/*  88 */     int i = RoleInterface.getGender(this.roleId);
/*  89 */     int j = RoleInterface.getOccupationId(this.roleId);
/*  90 */     if ((localSFashionDressCfg.fashionShowType == 1) && ((localSFashionDressCfg.gender != i) || (localSFashionDressCfg.menpai != j)))
/*     */     {
/*  92 */       localObject1 = new HashMap();
/*  93 */       ((Map)localObject1).put("gender", Integer.valueOf(i));
/*  94 */       ((Map)localObject1).put("men_pai", Integer.valueOf(j));
/*  95 */       ((Map)localObject1).put("fashion_dress_gender", Integer.valueOf(localSFashionDressCfg.gender));
/*  96 */       ((Map)localObject1).put("fashion_dress_menpai", Integer.valueOf(localSFashionDressCfg.menpai));
/*     */       
/*  98 */       onUnLockFashionDressFail(10, (Map)localObject1);
/*  99 */       return false;
/*     */     }
/* 101 */     if (localSFashionDressCfg.fashionShowType == 2)
/*     */     {
/* 103 */       if ((localSFashionDressCfg.gender != i) && (localSFashionDressCfg.gender != 0))
/*     */       {
/* 105 */         localObject1 = new HashMap();
/* 106 */         ((Map)localObject1).put("gender", Integer.valueOf(i));
/* 107 */         ((Map)localObject1).put("fashion_dress_gender", Integer.valueOf(localSFashionDressCfg.gender));
/*     */         
/* 109 */         onUnLockFashionDressFail(11, (Map)localObject1);
/* 110 */         return false;
/*     */       }
/* 112 */       if (localSFashionDressCfg.menpai != 0)
/*     */       {
/* 114 */         localObject1 = new HashMap();
/* 115 */         ((Map)localObject1).put("men_pai", Integer.valueOf(j));
/* 116 */         ((Map)localObject1).put("fashion_dress_menpai", Integer.valueOf(localSFashionDressCfg.menpai));
/*     */         
/* 118 */         onUnLockFashionDressFail(12, (Map)localObject1);
/* 119 */         return false;
/*     */       }
/*     */     }
/* 122 */     Object localObject1 = SFashionDressUnLockConditionCfg.get(localSFashionDressCfg.unlockConditionId);
/* 123 */     if (((SFashionDressUnLockConditionCfg)localObject1).conditionType != 1)
/*     */     {
/* 125 */       GameServer.logger().error(String.format("[fashiondress]PCUnLockFashionDress.processImp@fashion dress unlock type not match|role_id=%d|fashion_dress_cfg_id=%d|fashion_dress_cfg_unlock_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(((SFashionDressUnLockConditionCfg)localObject1).conditionType) }));
/*     */       
/* 127 */       return false;
/*     */     }
/* 129 */     int k = localSFashionDressCfg.costItemId;
/* 130 */     int m = localSFashionDressCfg.costItemNum;
/* 131 */     int n = ItemInterface.getItemNumberById(this.roleId, k);
/* 132 */     if (n < m)
/*     */     {
/* 134 */       GameServer.logger().error(String.format("[fashiondress]PCUnLockFashionDress.processImp@item not enough|role_id=%d|fashion_dress_cfg_id=%d|item_id=%d|cost_item_num=%d|has_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
/*     */       
/* 136 */       return false;
/*     */     }
/* 138 */     TLogArg localTLogArg = new TLogArg(LogReason.FSHION_DRESS_COST_ITEM);
/* 139 */     boolean bool1 = ItemInterface.removeItemById(this.roleId, 340600000, k, localSFashionDressCfg.costItemNum, localTLogArg);
/* 140 */     if (!bool1)
/*     */     {
/* 142 */       GameServer.logger().error(String.format("[fashiondress]PCUnLockFashionDress.processImp@cost item error|role_id=%d|fashion_dress_cfg_id=%d|item_id=%d|cost_item_num=%d|has_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
/*     */       
/* 144 */       return false;
/*     */     }
/* 146 */     long l = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*     */     
/* 148 */     FashionDressInfo localFashionDressInfo = Pod.newFashionDressInfo();
/* 149 */     localFashionDressInfo.setStart_time(l);
/*     */     
/* 151 */     localMap.put(Integer.valueOf(this.fashionDressCfgId), localFashionDressInfo);
/*     */     
/* 153 */     SUnLockFashionDressSuccess localSUnLockFashionDressSuccess = new SUnLockFashionDressSuccess();
/* 154 */     localSUnLockFashionDressSuccess.fashiondresscfgid = this.fashionDressCfgId;
/*     */     
/* 156 */     OnlineManager.getInstance().send(this.roleId, localSUnLockFashionDressSuccess);
/*     */     
/* 158 */     Set localSet = localRole2FashionDressInfo.getActivate_property_set();
/* 159 */     Object localObject2; if ((localSet.isEmpty()) && (!localSFashionDressCfg.propertySkillList.isEmpty()))
/*     */     {
/* 161 */       localSet.add(Integer.valueOf(this.fashionDressCfgId));
/*     */       
/* 163 */       localObject2 = new SSelectPropertySuccess();
/* 164 */       ((SSelectPropertySuccess)localObject2).fashiondresscfgid = this.fashionDressCfgId;
/*     */       
/* 166 */       OnlineManager.getInstance().send(this.roleId, (Protocol)localObject2);
/*     */     }
/* 168 */     FashionDressManager.triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(this.roleId));
/* 169 */     if (localSFashionDressCfg.effectTime > 0)
/*     */     {
/* 171 */       localObject2 = new FashionDressObserverArg(this.roleId, localSFashionDressCfg.effectTime * 3600L, this.fashionDressCfgId);
/*     */       
/* 173 */       FashionDressManager.triggerFashionDressObserverEvent((FashionDressObserverArg)localObject2);
/*     */     }
/* 175 */     boolean bool2 = unLockTransferOccupationFashionDress(l, localRole2FashionDressInfo);
/* 176 */     if (!bool2) {
/* 177 */       return false;
/*     */     }
/* 179 */     FashionDressManager.onUnlockFashionDress(str, this.roleId, localRole2FashionDressInfo, this.fashionDressCfgId);
/*     */     
/* 181 */     TriggerEventsManger.getInstance().triggerEvent(new GetNewFashionDress(), new GetNewFashionDressArg(this.roleId, this.fashionDressCfgId, localSFashionDressCfg.fashionDressType), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/* 183 */     FashionDressManager.tlogFashionDressOperator(str, this.roleId, this.fashionDressCfgId, FashionDressTLogEnum.ITEM_UNLOCK);
/*     */     
/* 185 */     GameServer.logger().info(String.format("[fashiondress]PCUnLockFashionDress.processImp@unlock fashion dress success|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */     
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   private boolean unLockTransferOccupationFashionDress(long paramLong, Role2FashionDressInfo paramRole2FashionDressInfo)
/*     */   {
/* 192 */     Map localMap1 = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 193 */     int i = RoleInterface.getGender(this.roleId);
/* 194 */     for (Map.Entry localEntry : localMap1.entrySet())
/*     */     {
/* 196 */       int j = ((Integer)localEntry.getKey()).intValue();
/* 197 */       if (j > 100)
/*     */       {
/* 199 */         i = j % 100;
/* 200 */         j /= 100;
/*     */       }
/*     */       
/* 203 */       TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/* 204 */       int k = FashionDressManager.getNewOccupationFashionDress(this.fashionDressCfgId, j, i);
/* 205 */       if (k <= 0)
/*     */       {
/* 207 */         localObject1 = new HashMap();
/* 208 */         ((Map)localObject1).put("new_occupation", Integer.valueOf(j));
/* 209 */         ((Map)localObject1).put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/*     */         
/* 211 */         onUnLockFashionDressFail(13, (Map)localObject1);
/* 212 */         return false;
/*     */       }
/* 214 */       Object localObject1 = SFashionDressCfg.get(this.fashionDressCfgId);
/* 215 */       SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(k);
/* 216 */       if (((SFashionDressCfg)localObject1).effectTime != localSFashionDressCfg.effectTime)
/*     */       {
/* 218 */         localObject2 = new HashMap();
/* 219 */         ((Map)localObject2).put("new_occupation", Integer.valueOf(j));
/* 220 */         ((Map)localObject2).put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/* 221 */         ((Map)localObject2).put("new_occupation_effect_time", Integer.valueOf(localSFashionDressCfg.effectTime));
/* 222 */         ((Map)localObject2).put("old_occupation_effect_time", Integer.valueOf(((SFashionDressCfg)localObject1).effectTime));
/*     */         
/* 224 */         onUnLockFashionDressFail(14, (Map)localObject2);
/* 225 */         return false;
/*     */       }
/* 227 */       Object localObject2 = Pod.newFashionDressInfo();
/* 228 */       ((FashionDressInfo)localObject2).setExtend_time(0L);
/* 229 */       ((FashionDressInfo)localObject2).setStart_time(paramLong);
/*     */       
/* 231 */       Map localMap2 = localTransferOccupationFashionDress.getFashion_dress_map();
/* 232 */       FashionDressInfo localFashionDressInfo = (FashionDressInfo)localMap2.put(Integer.valueOf(k), localObject2);
/* 233 */       if (localFashionDressInfo != null)
/*     */       {
/* 235 */         localObject3 = new HashMap();
/* 236 */         ((Map)localObject3).put("new_occupation", Integer.valueOf(j));
/* 237 */         ((Map)localObject3).put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/* 238 */         ((Map)localObject3).put("new_occupation_fashion_dress_cfg_list", localMap2.keySet().toString());
/*     */         
/* 240 */         onUnLockFashionDressFail(15, (Map)localObject3);
/* 241 */         return false;
/*     */       }
/* 243 */       Object localObject3 = SFashionDressCfg.get(k);
/*     */       
/* 245 */       Set localSet = localTransferOccupationFashionDress.getActivate_property_set();
/* 246 */       if ((localSet.isEmpty()) && (!((SFashionDressCfg)localObject3).propertySkillList.isEmpty())) {
/* 247 */         localSet.add(Integer.valueOf(k));
/*     */       }
/*     */     }
/* 250 */     return true;
/*     */   }
/*     */   
/*     */   private void onUnLockFashionDressFail(int paramInt, Map<String, ?> paramMap)
/*     */   {
/* 255 */     StringBuilder localStringBuilder = new StringBuilder();
/* 256 */     localStringBuilder.append("[fashiondress]PCUnLockFashionDress.processImp@unlock fashion dress failed");
/* 257 */     localStringBuilder.append("|ret=").append(paramInt);
/* 258 */     localStringBuilder.append("|role_id=").append(this.roleId);
/* 259 */     localStringBuilder.append("|fashion_dress_cfg_id=").append(this.fashionDressCfgId);
/* 260 */     if ((paramMap != null) && (!paramMap.isEmpty())) {
/* 261 */       for (localObject = paramMap.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 262 */         localStringBuilder.append('|').append((String)localEntry.getKey()).append('=').append(localEntry.getValue());
/*     */       }
/*     */     }
/* 265 */     GameServer.logger().error(localStringBuilder.toString());
/*     */     
/* 267 */     Object localObject = new SFashionDressNormalFailed();
/* 268 */     ((SFashionDressNormalFailed)localObject).result = paramInt;
/*     */     
/* 270 */     OnlineManager.getInstance().sendAtOnce(this.roleId, (Protocol)localObject);
/*     */   }
/*     */   
/*     */   private boolean isReplaceFashionDressSwitchOpen()
/*     */   {
/* 275 */     if (!OpenInterface.getOpenStatus(283))
/*     */     {
/* 277 */       HashMap localHashMap = new HashMap();
/* 278 */       localHashMap.put("switch_id", Integer.valueOf(283));
/* 279 */       onUnLockFashionDressFail(18, localHashMap);
/* 280 */       return false;
/*     */     }
/* 282 */     if (OpenInterface.isBanPlay(this.roleId, 283))
/*     */     {
/* 284 */       OpenInterface.sendBanPlayMsg(this.roleId, 283);
/* 285 */       return false;
/*     */     }
/* 287 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PCUnLockFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */