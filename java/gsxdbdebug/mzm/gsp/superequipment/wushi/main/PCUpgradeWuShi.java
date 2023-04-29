/*     */ package mzm.gsp.superequipment.wushi.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.superequipment.SUpgradeWuShiSuccess;
/*     */ import mzm.gsp.superequipment.SWuShiError;
/*     */ import mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg;
/*     */ import mzm.gsp.superequipment.wushi.confbean.WuShiCfg;
/*     */ import mzm.gsp.superequipment.wushi.event.ActivateWuShi;
/*     */ import mzm.gsp.superequipment.wushi.event.ActivateWuShiArg;
/*     */ import mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShi;
/*     */ import mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShiArg;
/*     */ import mzm.gsp.superequipment.wushi.event.UpgradeWuShi;
/*     */ import mzm.gsp.superequipment.wushi.event.UpgradeWuShiArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Pod;
/*     */ import xbean.WuShiInfo;
/*     */ import xbean.WuShiInfoMap;
/*     */ import xtable.Role2wushiinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCUpgradeWuShi
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int itemCfgId;
/*     */   final int wushicfgid;
/*     */   final int consumetype;
/*     */   
/*     */   public PCUpgradeWuShi(long roleId, int itemCfgId, int wushicfgid, int consumetype)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.itemCfgId = itemCfgId;
/*  41 */     this.wushicfgid = wushicfgid;
/*  42 */     this.consumetype = consumetype;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     boolean ret = WuShiManager.checkSwitchAndCross(this.roleId, 1613);
/*  49 */     if (!ret)
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     SItemCfg itemCfg = SItemCfg.get(this.itemCfgId);
/*  55 */     if (itemCfg == null)
/*     */     {
/*  57 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(1));
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     WuShiCfg wuShiCfg = WuShiCfg.get(this.wushicfgid);
/*  62 */     if (wuShiCfg == null)
/*     */     {
/*  64 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(1));
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     int consumeCount = ItemInterface.getItemNumberById(this.roleId, itemCfg.id);
/*  70 */     if (consumeCount == 0)
/*     */     {
/*  72 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(3));
/*  73 */       return false;
/*     */     }
/*  75 */     if (this.consumetype == 2)
/*     */     {
/*  77 */       consumeCount = 1;
/*     */     }
/*     */     
/*     */ 
/*  81 */     WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(this.roleId));
/*  82 */     if (xWuShiInfoMap == null)
/*     */     {
/*  84 */       xWuShiInfoMap = Pod.newWuShiInfoMap();
/*  85 */       Role2wushiinfo.insert(Long.valueOf(this.roleId), xWuShiInfoMap);
/*     */     }
/*     */     
/*  88 */     Map<Integer, WuShiInfo> xWuShiCfgId2WuShiInfo = xWuShiInfoMap.getWushicfgid2wushiinfo();
/*     */     
/*  90 */     for (Map.Entry<Integer, WuShiInfo> entry : xWuShiCfgId2WuShiInfo.entrySet())
/*     */     {
/*  92 */       if ((WuShiCfg.get(((Integer)entry.getKey()).intValue()).typeId == WuShiCfg.get(this.wushicfgid).typeId) && (((Integer)entry.getKey()).intValue() != this.wushicfgid))
/*     */       {
/*  94 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     WuShiInfo xWuShiInfo;
/*     */     
/* 101 */     if (!xWuShiCfgId2WuShiInfo.containsKey(Integer.valueOf(this.wushicfgid)))
/*     */     {
/* 103 */       if (wuShiCfg.wuShiLevel != 1)
/*     */       {
/* 105 */         return false;
/*     */       }
/* 107 */       WuShiInfo xWuShiInfo = Pod.newWuShiInfo();
/* 108 */       xWuShiInfo.setIsactivate(4);
/* 109 */       xWuShiInfo.setFragmentcount(0);
/* 110 */       xWuShiCfgId2WuShiInfo.put(Integer.valueOf(this.wushicfgid), xWuShiInfo);
/*     */     }
/*     */     else
/*     */     {
/* 114 */       xWuShiInfo = (WuShiInfo)xWuShiCfgId2WuShiInfo.get(Integer.valueOf(this.wushicfgid));
/*     */     }
/*     */     
/*     */     WuShiCfg wuShiCfgNextLevel;
/* 118 */     if (xWuShiInfo.getIsactivate() == 4)
/*     */     {
/* 120 */       wuShiCfgNextLevel = wuShiCfg;
/*     */     }
/* 122 */     else if (xWuShiInfo.getIsactivate() == 3)
/*     */     {
/* 124 */       WuShiCfg wuShiCfgNextLevel = WuShiCfg.get(wuShiCfg.nextLevelId);
/* 125 */       if (wuShiCfgNextLevel == null)
/*     */       {
/* 127 */         OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(7));
/* 128 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 133 */       return false;
/*     */     }
/*     */     WuShiCfg wuShiCfgNextLevel;
/*     */     int fragToAddPerItem;
/* 137 */     if (itemCfg.type == 134)
/*     */     {
/* 139 */       if (wuShiCfgNextLevel.fragmentItemId != itemCfg.id)
/*     */       {
/* 141 */         OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(6));
/* 142 */         return false;
/*     */       }
/* 144 */       fragToAddPerItem = 1;
/*     */     } else { int fragToAddPerItem;
/* 146 */       if (itemCfg.type == 133)
/*     */       {
/* 148 */         SWuShiItemCfg wuShiItemCfg = (SWuShiItemCfg)itemCfg;
/* 149 */         if (WuShiCfg.get(wuShiItemCfg.wuShiCfgId).typeId != wuShiCfg.typeId)
/*     */         {
/* 151 */           OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(6));
/* 152 */           return false;
/*     */         }
/* 154 */         fragToAddPerItem = wuShiItemCfg.fragmentCount;
/*     */       }
/*     */       else
/*     */       {
/* 158 */         OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(6));
/* 159 */         return false;
/*     */       } }
/*     */     int fragToAddPerItem;
/* 162 */     int wushicfgid = this.wushicfgid;
/*     */     
/* 164 */     int removeCount = 0;
/* 165 */     int fragmentCount = xWuShiInfo.getFragmentcount();
/*     */     
/* 167 */     boolean isUpgrade = false;
/*     */     
/*     */ 
/* 170 */     for (int i = 0; i < consumeCount; i++)
/*     */     {
/* 172 */       removeCount++;
/* 173 */       int fragLeft = fragToAddPerItem;
/* 174 */       if ((wuShiCfgNextLevel != null) && (fragmentCount + fragLeft >= wuShiCfgNextLevel.fragmentCount))
/*     */       {
/* 176 */         fragLeft -= wuShiCfgNextLevel.fragmentCount - fragmentCount;
/* 177 */         fragmentCount = fragLeft;
/* 178 */         wushicfgid = wuShiCfgNextLevel.id;
/* 179 */         isUpgrade = true;
/* 180 */         break;
/*     */       }
/* 182 */       fragmentCount += fragLeft;
/*     */     }
/*     */     
/*     */ 
/* 186 */     xWuShiInfo.setFragmentcount(fragmentCount);
/*     */     
/* 188 */     int isOn = 2;
/* 189 */     if (xWuShiInfoMap.getOnwushicfgid() == this.wushicfgid)
/*     */     {
/* 191 */       isOn = 1;
/*     */     }
/*     */     
/* 194 */     if (isUpgrade)
/*     */     {
/*     */ 
/* 197 */       if (wushicfgid == this.wushicfgid)
/*     */       {
/* 199 */         if (xWuShiInfo.getIsactivate() == 4)
/*     */         {
/* 201 */           xWuShiInfo.setIsactivate(3);
/* 202 */           TriggerEventsManger.getInstance().triggerEvent(new ActivateWuShi(), new ActivateWuShiArg(this.roleId, wushicfgid));
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 208 */         WuShiInfo xNewWuShiInfo = xWuShiInfo.copy();
/* 209 */         if (xNewWuShiInfo.getIsactivate() == 4)
/*     */         {
/*     */ 
/* 212 */           xNewWuShiInfo.setIsactivate(3);
/* 213 */           TriggerEventsManger.getInstance().triggerEvent(new ActivateWuShi(), new ActivateWuShiArg(this.roleId, wushicfgid));
/*     */         }
/*     */         
/*     */ 
/* 217 */         xWuShiCfgId2WuShiInfo.put(Integer.valueOf(wushicfgid), xNewWuShiInfo);
/*     */         
/* 219 */         xWuShiCfgId2WuShiInfo.remove(Integer.valueOf(this.wushicfgid));
/*     */         
/* 221 */         if (isOn == 1)
/*     */         {
/*     */ 
/*     */ 
/* 225 */           xWuShiInfoMap.setOnwushicfgid(wushicfgid);
/* 226 */           TriggerEventsManger.getInstance().triggerEvent(new PutOnSuperEquipmentWuShi(), new PutOnSuperEquipmentWuShiArg(this.roleId, wushicfgid));
/*     */         }
/*     */         
/* 229 */         TriggerEventsManger.getInstance().triggerEvent(new UpgradeWuShi(), new UpgradeWuShiArg(this.roleId, wushicfgid, this.wushicfgid, fragmentCount, isOn));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 235 */     ret = ItemInterface.removeItemById(this.roleId, this.itemCfgId, removeCount, new TLogArg(LogReason.SUPER_EQUIPMENT_WUSHI_UPGRADE));
/*     */     
/* 237 */     if (!ret)
/*     */     {
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     WuShiTlogManager.tlogUpgrade(this.roleId, this.wushicfgid, wushicfgid, this.itemCfgId, removeCount, fragmentCount);
/*     */     
/* 244 */     int isActivate = ((WuShiInfo)xWuShiCfgId2WuShiInfo.get(Integer.valueOf(wushicfgid))).getIsactivate();
/*     */     
/* 246 */     OnlineManager.getInstance().send(this.roleId, new SUpgradeWuShiSuccess(wushicfgid, this.wushicfgid, fragmentCount, isActivate));
/*     */     
/* 248 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\PCUpgradeWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */