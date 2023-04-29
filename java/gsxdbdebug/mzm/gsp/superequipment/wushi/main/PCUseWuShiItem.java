/*     */ package mzm.gsp.superequipment.wushi.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.superequipment.SUseWuShiItemResponse;
/*     */ import mzm.gsp.superequipment.SWuShiError;
/*     */ import mzm.gsp.superequipment.wushi.confbean.SWuShiItemCfg;
/*     */ import mzm.gsp.superequipment.wushi.confbean.WuShiCfg;
/*     */ import mzm.gsp.superequipment.wushi.event.ActivateWuShi;
/*     */ import mzm.gsp.superequipment.wushi.event.ActivateWuShiArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Pod;
/*     */ import xbean.WuShiInfo;
/*     */ import xbean.WuShiInfoMap;
/*     */ import xtable.Role2wushiinfo;
/*     */ 
/*     */ public class PCUseWuShiItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int bagid;
/*     */   final int grid;
/*     */   
/*     */   public PCUseWuShiItem(long roleId, int bagid, int grid)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.bagid = bagid;
/*  34 */     this.grid = grid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     boolean ret = WuShiManager.checkSwitchAndCross(this.roleId, 1614);
/*  41 */     if (!ret)
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     BasicItem wuShiBasicItem = ItemInterface.getItem(this.roleId, this.bagid, this.grid, true);
/*  47 */     if (wuShiBasicItem == null)
/*     */     {
/*  49 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(3));
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     SWuShiItemCfg wuShiItemCfg = SWuShiItemCfg.get(wuShiBasicItem.getCfgId());
/*  54 */     if (wuShiItemCfg == null)
/*     */     {
/*  56 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(1));
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     int wushicfgid = wuShiItemCfg.wuShiCfgId;
/*  62 */     WuShiCfg wuShiCfg = WuShiCfg.get(wushicfgid);
/*  63 */     if (wuShiCfg == null)
/*     */     {
/*  65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(1));
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(this.roleId));
/*  70 */     int opt; if (xWuShiInfoMap == null)
/*     */     {
/*  72 */       xWuShiInfoMap = Pod.newWuShiInfoMap();
/*  73 */       int opt = getWuShi(wushicfgid, xWuShiInfoMap);
/*  74 */       Role2wushiinfo.insert(Long.valueOf(this.roleId), xWuShiInfoMap);
/*     */     }
/*     */     else
/*     */     {
/*  78 */       Map<Integer, WuShiInfo> xWuShiCfgId2WuShiInfo = xWuShiInfoMap.getWushicfgid2wushiinfo();
/*  79 */       ret = false;
/*  80 */       for (Map.Entry<Integer, WuShiInfo> entry : xWuShiCfgId2WuShiInfo.entrySet())
/*     */       {
/*  82 */         if (WuShiCfg.get(((Integer)entry.getKey()).intValue()).typeId == wuShiCfg.typeId)
/*     */         {
/*  84 */           ret = true;
/*  85 */           wushicfgid = ((Integer)entry.getKey()).intValue();
/*  86 */           break;
/*     */         }
/*     */       }
/*     */       int opt;
/*  90 */       if (ret)
/*     */       {
/*  92 */         opt = 2;
/*     */       }
/*     */       else
/*     */       {
/*  96 */         opt = getWuShi(wushicfgid, xWuShiInfoMap);
/*     */       }
/*     */     }
/*     */     
/* 100 */     OnlineManager.getInstance().send(this.roleId, new SUseWuShiItemResponse(opt, wushicfgid));
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   private int getWuShi(int wushicfgid, WuShiInfoMap xWuShiInfoMap)
/*     */   {
/* 106 */     WuShiInfo xWuShiInfo = Pod.newWuShiInfo();
/* 107 */     xWuShiInfo.setIsactivate(3);
/* 108 */     xWuShiInfo.setFragmentcount(0);
/* 109 */     xWuShiInfoMap.getWushicfgid2wushiinfo().put(Integer.valueOf(wushicfgid), xWuShiInfo);
/* 110 */     int opt = 1;
/*     */     
/* 112 */     ItemInterface.removeItemByGrid(this.roleId, this.bagid, this.grid, 1, new TLogArg(LogReason.SUPER_EQUIPMENT_WUSHI_USE_ITEM));
/*     */     
/*     */ 
/* 115 */     TriggerEventsManger.getInstance().triggerEvent(new ActivateWuShi(), new ActivateWuShiArg(this.roleId, wushicfgid));
/* 116 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\PCUseWuShiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */