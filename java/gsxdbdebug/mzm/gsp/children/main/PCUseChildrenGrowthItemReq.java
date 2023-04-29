/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SUseChildrenGrowthItemErrorRes;
/*     */ import mzm.gsp.children.SUseChildrenGrowthItemRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.item.confbean.SChildrenGrowItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCUseChildrenGrowthItemReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int itemKey;
/*     */   
/*     */   public PCUseChildrenGrowthItemReq(long roleid, long childrenid, int itemkey)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.childrenid = childrenid;
/*  32 */     this.itemKey = itemkey;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  38 */       GameServer.logger().error(String.format("[Children]PCUseChildrenGrowthItemReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  42 */       return false;
/*     */     }
/*  44 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  45 */       GameServer.logger().error(String.format("[Children]PCUseChildrenGrowthItemReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  52 */       GameServer.logger().error(String.format("[Children]PCUseChildrenGrowthItemReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  65 */     if (xChildInfo == null) {
/*  66 */       GameServer.logger().error(String.format("[Children]PCUseChildrenGrowthItemReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  70 */       return false;
/*     */     }
/*  72 */     int period = xChildInfo.getChild_period();
/*  73 */     if (period != 2) {
/*  74 */       GameServer.logger().error(String.format("[Children]PCUseChildrenGrowthItemReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  88 */     if (xAdulthoodInfo.getOccupation() <= 0) {
/*  89 */       sendError(3);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     BasicItem xBasicItem = ItemInterface.getItem(this.roleid, this.itemKey);
/*  94 */     if (xBasicItem == null) {
/*  95 */       sendError(4);
/*  96 */       return false;
/*     */     }
/*  98 */     int itemCfgid = xBasicItem.getCfgId();
/*  99 */     SChildrenGrowItemCfg childrenGrowItemCfg = SChildrenGrowItemCfg.get(itemCfgid);
/* 100 */     if (childrenGrowItemCfg == null) {
/* 101 */       sendError(4);
/* 102 */       return false;
/*     */     }
/* 104 */     int useItemCount = xAdulthoodInfo.getUsegrowthitemcount();
/* 105 */     if ((childrenGrowItemCfg.addUseCount) && 
/* 106 */       (useItemCount >= SChildrenConsts.getInstance().child_use_grow_item_max)) {
/* 107 */       sendError(2);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     float oldGrowValue = xAdulthoodInfo.getGrow();
/* 113 */     if (SChildrenConsts.getInstance().child_grow_max <= oldGrowValue) {
/* 114 */       sendError(1);
/* 115 */       return false;
/*     */     }
/* 117 */     boolean ret = ItemInterface.removeItemByGrid(this.roleid, 340600000, this.itemKey, 1, new TLogArg(LogReason.CHILDREN_ADULT_ADD_GROW_COST));
/*     */     
/* 119 */     if (!ret) {
/* 120 */       sendError(4);
/* 121 */       return false;
/*     */     }
/* 123 */     int random = CommonUtils.random(childrenGrowItemCfg.growRateMin, childrenGrowItemCfg.growRateMax);
/* 124 */     float addGrowValue = random * 1.0F / 10000.0F;
/* 125 */     float growValue = (float)Math.min(oldGrowValue + addGrowValue, SChildrenConsts.getInstance().child_grow_max);
/*     */     
/* 127 */     xAdulthoodInfo.setGrow(growValue);
/* 128 */     if (childrenGrowItemCfg.addUseCount) {
/* 129 */       xAdulthoodInfo.setUsegrowthitemcount(useItemCount + 1);
/*     */     }
/* 131 */     float newGrowValue = xAdulthoodInfo.getGrow();
/*     */     
/* 133 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 135 */     childrenOutFightObj.updateOutFightProperty();
/* 136 */     childrenOutFightObj.synPropertyChange(this.roleid);
/*     */     
/* 138 */     SUseChildrenGrowthItemRes useChildrenGrowthItemRes = new SUseChildrenGrowthItemRes();
/* 139 */     useChildrenGrowthItemRes.childrenid = this.childrenid;
/* 140 */     useChildrenGrowthItemRes.growvalue = xAdulthoodInfo.getGrow();
/* 141 */     useChildrenGrowthItemRes.itemkey = this.itemKey;
/* 142 */     useChildrenGrowthItemRes.useitemcount = xAdulthoodInfo.getUsegrowthitemcount();
/* 143 */     OnlineManager.getInstance().send(this.roleid, useChildrenGrowthItemRes);
/*     */     
/* 145 */     ChildrenManager.tlogAdultGrow(this.roleid, this.childrenid, 1, 0, oldGrowValue, xAdulthoodInfo.getGrow(), addGrowValue);
/*     */     
/*     */ 
/* 148 */     Map<Integer, Integer> intParameterMap = new HashMap();
/* 149 */     int changeValue = (int)Math.floor((newGrowValue - oldGrowValue) * 10000.0F);
/* 150 */     intParameterMap.put(Integer.valueOf(0), Integer.valueOf(changeValue));
/* 151 */     ChildrenInterface.fillChildGrowthDiary(this.childrenid, intParameterMap, null, 24);
/*     */     
/*     */ 
/* 154 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/* 155 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error)
/*     */   {
/* 160 */     SUseChildrenGrowthItemErrorRes useChildrenGrowthItemErrorRes = new SUseChildrenGrowthItemErrorRes();
/* 161 */     useChildrenGrowthItemErrorRes.ret = error;
/* 162 */     OnlineManager.getInstance().sendAtOnce(this.roleid, useChildrenGrowthItemErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCUseChildrenGrowthItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */