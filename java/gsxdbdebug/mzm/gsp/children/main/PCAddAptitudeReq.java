/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SAddAptitudeErrorRes;
/*     */ import mzm.gsp.children.SAddAptitudeRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.item.confbean.SChildrenAptitudeItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCAddAptitudeReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int aptType;
/*     */   private final int itemId;
/*     */   
/*     */   public PCAddAptitudeReq(long roleid, long childrenid, int apttype, int itemId)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.childrenid = childrenid;
/*  32 */     this.aptType = apttype;
/*  33 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  38 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  39 */       GameServer.logger().error(String.format("[Children]PCAddAptitudeReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  42 */       return false;
/*     */     }
/*  44 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  45 */       GameServer.logger().error(String.format("[Children]PCAddAptitudeReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  47 */       return false;
/*     */     }
/*  49 */     int maxValue = 0;
/*  50 */     switch (this.aptType) {
/*     */     case 1: 
/*  52 */       maxValue = SChildrenConsts.getInstance().child_hp_aptitude_max;
/*  53 */       break;
/*     */     case 3: 
/*  55 */       maxValue = SChildrenConsts.getInstance().child_mag_atk_aptitude_max;
/*  56 */       break;
/*     */     case 5: 
/*  58 */       maxValue = SChildrenConsts.getInstance().child_mag_def_aptitude_max;
/*  59 */       break;
/*     */     case 2: 
/*  61 */       maxValue = SChildrenConsts.getInstance().child_phy_atk_aptitude_max;
/*  62 */       break;
/*     */     case 4: 
/*  64 */       maxValue = SChildrenConsts.getInstance().child_phy_def_aptitude_max;
/*  65 */       break;
/*     */     case 6: 
/*  67 */       maxValue = SChildrenConsts.getInstance().child_speed_aptitude_max;
/*  68 */       break;
/*     */     default: 
/*  70 */       GameServer.logger().error(String.format("[Children]PCAddAptitudeReq.processImp@can not set this apt prop|type=%d|roleid=%d", new Object[] { Integer.valueOf(this.aptType), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  77 */       GameServer.logger().error(String.format("[Children]PCAddAptitudeReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  88 */     if (xChildInfo == null) {
/*  89 */       GameServer.logger().error(String.format("[Children]PCAddAptitudeReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     int period = xChildInfo.getChild_period();
/* 101 */     if (period != 2) {
/* 102 */       GameServer.logger().error(String.format("[Children]PCAddAptitudeReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/* 106 */       return false;
/*     */     }
/* 108 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 109 */     if (xAdulthoodInfo.getOccupation() <= 0) {
/* 110 */       sendError(3);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     BasicItem basicItem = ItemInterface.getItemByCfgId(this.roleid, this.itemId);
/* 116 */     if ((basicItem == null) || (basicItem.getNumber() < 1)) {
/* 117 */       sendError(4);
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */     int itemCfgid = basicItem.getCfgId();
/* 129 */     SChildrenAptitudeItemCfg childrenAptitudeItemCfg = SChildrenAptitudeItemCfg.get(itemCfgid);
/* 130 */     if (childrenAptitudeItemCfg == null) {
/* 131 */       sendError(4);
/* 132 */       return false;
/*     */     }
/* 134 */     if (!ItemInterface.removeItemById(this.roleid, this.itemId, 1, new TLogArg(LogReason.CHILDREN_ADULT_ADD_APT_COST))) {
/* 135 */       sendError(4);
/* 136 */       return false;
/*     */     }
/* 138 */     int useAptItemCount = xAdulthoodInfo.getUseaptitudeitemcount();
/* 139 */     if ((childrenAptitudeItemCfg.addUseCount) && 
/* 140 */       (useAptItemCount >= SChildrenConsts.getInstance().child_use_aptitude_item_max)) {
/* 141 */       sendError(2);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 147 */     int aptValue = childrenOutFightObj.getAptValue(this.aptType);
/* 148 */     if (aptValue >= maxValue) {
/* 149 */       sendError(1);
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (childrenAptitudeItemCfg.addUseCount) {
/* 154 */       xAdulthoodInfo.setUseaptitudeitemcount(useAptItemCount + 1);
/*     */     }
/*     */     
/* 157 */     int offset = maxValue - aptValue;
/*     */     
/* 159 */     double expval = offset * (childrenAptitudeItemCfg.expectAddRate * 1.0D / 10000.0D);
/* 160 */     double fluctuate = Math.min(expval * (childrenAptitudeItemCfg.fluctuateRate * 1.0D / 10000.0D), childrenAptitudeItemCfg.fluctuateMax);
/*     */     
/*     */ 
/* 163 */     int random = CommonUtils.random((int)(expval - fluctuate), (int)(expval + fluctuate));
/* 164 */     int addValue = Math.max(random, childrenAptitudeItemCfg.addMin);
/* 165 */     addValue = Math.min(addValue, offset);
/* 166 */     int beforeValue = childrenOutFightObj.getAptValue(this.aptType);
/* 167 */     childrenOutFightObj.addAptValue(this.aptType, addValue);
/* 168 */     int afterValue = childrenOutFightObj.getAptValue(this.aptType);
/* 169 */     childrenOutFightObj.updateOutFightProperty();
/* 170 */     childrenOutFightObj.synPropertyChange(this.roleid);
/*     */     
/* 172 */     int changeValue = afterValue - beforeValue;
/*     */     
/* 174 */     SAddAptitudeRes addAptitudeRes = new SAddAptitudeRes();
/* 175 */     addAptitudeRes.apttype = this.aptType;
/* 176 */     addAptitudeRes.aptvalue = childrenOutFightObj.getAptValue(this.aptType);
/* 177 */     addAptitudeRes.childrenid = this.childrenid;
/* 178 */     addAptitudeRes.useitemcount = xAdulthoodInfo.getUseaptitudeitemcount();
/* 179 */     OnlineManager.getInstance().send(this.roleid, addAptitudeRes);
/*     */     
/* 181 */     ChildrenManager.tlogAdultGrow(this.roleid, this.childrenid, 2, this.aptType, beforeValue, afterValue, addValue);
/*     */     
/*     */ 
/* 184 */     Map<Integer, Integer> intParameterMap = new HashMap();
/* 185 */     intParameterMap.put(Integer.valueOf(0), Integer.valueOf(this.aptType));
/* 186 */     intParameterMap.put(Integer.valueOf(1), Integer.valueOf(changeValue));
/* 187 */     ChildrenInterface.fillChildGrowthDiary(this.childrenid, intParameterMap, null, 23);
/*     */     
/* 189 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/* 190 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error)
/*     */   {
/* 195 */     SAddAptitudeErrorRes addAptitudeErrorRes = new SAddAptitudeErrorRes();
/* 196 */     addAptitudeErrorRes.ret = error;
/* 197 */     OnlineManager.getInstance().sendAtOnce(this.roleid, addAptitudeErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCAddAptitudeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */