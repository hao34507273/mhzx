/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SExtendFashionDressTimeSuccess;
/*     */ import mzm.gsp.fashiondress.SFashionDressNormalFailed;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.event.FashionDressObserverArg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FashionDressInfo;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.TransferOccupationFashionDress;
/*     */ import xdb.Lockeys;
/*     */ import xio.Protocol;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCExtendFashionDressTime extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fashionDressCfgId;
/*     */   private final int useItemNum;
/*     */   
/*     */   public PCExtendFashionDressTime(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/*  36 */     this.roleId = paramLong;
/*  37 */     this.fashionDressCfgId = paramInt1;
/*  38 */     this.useItemNum = paramInt2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (this.useItemNum <= 0) {
/*  45 */       return false;
/*     */     }
/*  47 */     if (!FashionDressManager.isFashionDressSwitchOpen(this.roleId, "PCExtendFashionDressTime.processImp", true, true)) {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!FashionDressManager.isLevelOpen(this.roleId, "PCExtendFashionDressTime.processImp", true)) {
/*  51 */       return false;
/*     */     }
/*  53 */     String str = RoleInterface.getUserId(this.roleId);
/*  54 */     lock(Lockeys.get(User.getTable(), str));
/*  55 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 972, true, true)) {
/*  56 */       return false;
/*     */     }
/*  58 */     Role2FashionDressInfo localRole2FashionDressInfo = xtable.Role2fashiondress.get(Long.valueOf(this.roleId));
/*  59 */     if (localRole2FashionDressInfo == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[fashiondress]PCExtendFashionDressTime.processImp@role fashion dress info is null|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  63 */       return false;
/*     */     }
/*  65 */     FashionDressInfo localFashionDressInfo = (FashionDressInfo)localRole2FashionDressInfo.getFashion_dress_map().get(Integer.valueOf(this.fashionDressCfgId));
/*  66 */     if (localFashionDressInfo == null)
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[fashiondress]PCExtendFashionDressTime.processImp@role fashion dress info not exist,may be expired|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  70 */       return false;
/*     */     }
/*  72 */     SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(this.fashionDressCfgId);
/*  73 */     if ((localSFashionDressCfg.effectTime <= 0) || (localSFashionDressCfg.costItemId <= 0) || (localSFashionDressCfg.costItemNum <= 0))
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[fashiondress]PCExtendFashionDressTime.processImp@role fashion dress can not extend time|role_id=%d|fashion_dress_cfg_id=%d|cost_item_id=%d|cost_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(localSFashionDressCfg.costItemId), Integer.valueOf(localSFashionDressCfg.costItemNum) }));
/*     */       
/*  77 */       return false;
/*     */     }
/*  79 */     int i = ItemInterface.getItemNumberById(this.roleId, 340600000, localSFashionDressCfg.costItemId);
/*  80 */     if (i < this.useItemNum)
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[fashiondress]PCExtendFashionDressTime.processImp@item not enough|role_id=%d|fashion_dress_cfg_id=%d|cost_item_id=%d|cost_item_num=%d|has_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(localSFashionDressCfg.costItemId), Integer.valueOf(localSFashionDressCfg.costItemNum), Integer.valueOf(i) }));
/*     */       
/*  84 */       return false;
/*     */     }
/*  86 */     boolean bool1 = ItemInterface.removeItemById(this.roleId, localSFashionDressCfg.costItemId, this.useItemNum, new TLogArg(LogReason.FSHION_DRESS_EXTEND_COST_ITEM));
/*  87 */     if (!bool1)
/*     */     {
/*  89 */       GameServer.logger().error(String.format("[fashiondress]PCExtendFashionDressTime.processImp@item remove failed|role_id=%d|fashion_dress_cfg_id=%d|cost_item_id=%d|cost_item_num=%d|has_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(localSFashionDressCfg.costItemId), Integer.valueOf(localSFashionDressCfg.costItemNum), Integer.valueOf(i) }));
/*     */       
/*  91 */       return false;
/*     */     }
/*  93 */     int j = localSFashionDressCfg.effectTime * 60 / localSFashionDressCfg.costItemNum * this.useItemNum;
/*  94 */     localFashionDressInfo.setExtend_time(localFashionDressInfo.getExtend_time() + j * 60);
/*     */     
/*  96 */     long l1 = localSFashionDressCfg.effectTime * 3600L + localFashionDressInfo.getExtend_time();
/*     */     
/*  98 */     long l2 = DateTimeUtils.getCurrTimeInMillis() / 1000L - localFashionDressInfo.getStart_time();
/*     */     
/* 100 */     SExtendFashionDressTimeSuccess localSExtendFashionDressTimeSuccess = new SExtendFashionDressTimeSuccess();
/* 101 */     localSExtendFashionDressTimeSuccess.fashiondresscfgid = this.fashionDressCfgId;
/* 102 */     localSExtendFashionDressTimeSuccess.lefttime = (l1 - l2);
/*     */     
/* 104 */     OnlineManager.getInstance().send(this.roleId, localSExtendFashionDressTimeSuccess);
/*     */     
/* 106 */     FashionDressObserverArg localFashionDressObserverArg = new FashionDressObserverArg(this.roleId, localSExtendFashionDressTimeSuccess.lefttime, this.fashionDressCfgId);
/*     */     
/* 108 */     FashionDressManager.triggerFashionDressObserverEvent(localFashionDressObserverArg);
/*     */     
/* 110 */     boolean bool2 = extendTransferOccupationFashionDressTime(localRole2FashionDressInfo, localFashionDressInfo.getExtend_time());
/* 111 */     if (!bool2) {
/* 112 */       return false;
/*     */     }
/* 114 */     FashionDressManager.tlogFashionDressOperator(str, this.roleId, this.fashionDressCfgId, FashionDressTLogEnum.EXTEND_TIME);
/*     */     
/* 116 */     GameServer.logger().info(String.format("[fashiondress]PCExtendFashionDressTime.processImp@extend fashion dress time success|role_id=%d|fashion_dress_cfg_id=%d|use_item_num=%d|extend_time=%d|now_left_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(this.useItemNum), Integer.valueOf(j), Long.valueOf(localSExtendFashionDressTimeSuccess.lefttime) }));
/*     */     
/* 118 */     return true;
/*     */   }
/*     */   
/*     */   private boolean extendTransferOccupationFashionDressTime(Role2FashionDressInfo paramRole2FashionDressInfo, long paramLong)
/*     */   {
/* 123 */     Map localMap = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 124 */     if (localMap.isEmpty()) {
/* 125 */       return true;
/*     */     }
/* 127 */     int i = RoleInterface.getGender(this.roleId);
/* 128 */     for (Map.Entry localEntry : localMap.entrySet())
/*     */     {
/* 130 */       int j = ((Integer)localEntry.getKey()).intValue();
/* 131 */       if (j > 100)
/*     */       {
/* 133 */         i = j % 100;
/* 134 */         j /= 100;
/*     */       }
/*     */       
/* 137 */       TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/* 138 */       int k = FashionDressManager.getNewOccupationFashionDress(this.fashionDressCfgId, j, i);
/* 139 */       if (k <= 0)
/*     */       {
/* 141 */         localObject1 = new HashMap();
/* 142 */         ((Map)localObject1).put("new_occupation", Integer.valueOf(j));
/* 143 */         ((Map)localObject1).put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/*     */         
/* 145 */         onExtendFashionDressTimeFail(13, (Map)localObject1);
/* 146 */         return false;
/*     */       }
/* 148 */       Object localObject1 = SFashionDressCfg.get(this.fashionDressCfgId);
/* 149 */       SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(k);
/* 150 */       if (((SFashionDressCfg)localObject1).effectTime != localSFashionDressCfg.effectTime)
/*     */       {
/* 152 */         localObject2 = new HashMap();
/* 153 */         ((Map)localObject2).put("new_occupation", Integer.valueOf(j));
/* 154 */         ((Map)localObject2).put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/* 155 */         ((Map)localObject2).put("new_fashion_dress_effect_time", Integer.valueOf(localSFashionDressCfg.effectTime));
/* 156 */         ((Map)localObject2).put("old_fashion_dress_effect_time", Integer.valueOf(((SFashionDressCfg)localObject1).effectTime));
/*     */         
/* 158 */         onExtendFashionDressTimeFail(14, (Map)localObject2);
/* 159 */         return false;
/*     */       }
/* 161 */       Object localObject2 = (FashionDressInfo)localTransferOccupationFashionDress.getFashion_dress_map().get(Integer.valueOf(k));
/* 162 */       if (localObject2 == null)
/*     */       {
/* 164 */         HashMap localHashMap = new HashMap();
/* 165 */         localHashMap.put("new_occupation", Integer.valueOf(j));
/* 166 */         localHashMap.put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/* 167 */         localHashMap.put("new_occupation_cfg_list", localTransferOccupationFashionDress.getFashion_dress_map().keySet());
/* 168 */         onExtendFashionDressTimeFail(17, localHashMap);
/*     */         
/* 170 */         return false;
/*     */       }
/* 172 */       ((FashionDressInfo)localObject2).setExtend_time(paramLong);
/*     */     }
/* 174 */     return true;
/*     */   }
/*     */   
/*     */   private void onExtendFashionDressTimeFail(int paramInt, Map<String, ?> paramMap)
/*     */   {
/* 179 */     StringBuilder localStringBuilder = new StringBuilder();
/* 180 */     localStringBuilder.append("[fashiondress]PCExtendFashionDressTime.processImp@extend fashion dress failed");
/* 181 */     localStringBuilder.append("|ret=").append(paramInt);
/* 182 */     localStringBuilder.append("|role_id=").append(this.roleId);
/* 183 */     localStringBuilder.append("|fashion_dress_cfg_id=").append(this.fashionDressCfgId);
/* 184 */     localStringBuilder.append("|use_item_num=").append(this.useItemNum);
/* 185 */     if ((paramMap != null) && (!paramMap.isEmpty())) {
/* 186 */       for (localObject = paramMap.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 187 */         localStringBuilder.append('|').append((String)localEntry.getKey()).append('=').append(localEntry.getValue());
/*     */       }
/*     */     }
/* 190 */     GameServer.logger().error(localStringBuilder.toString());
/*     */     
/* 192 */     Object localObject = new SFashionDressNormalFailed();
/* 193 */     ((SFashionDressNormalFailed)localObject).result = paramInt;
/*     */     
/* 195 */     OnlineManager.getInstance().sendAtOnce(this.roleId, (Protocol)localObject);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PCExtendFashionDressTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */