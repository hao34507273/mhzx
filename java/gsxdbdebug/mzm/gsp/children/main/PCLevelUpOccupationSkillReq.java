/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SLevelUpOccupationSkillErrorRes;
/*     */ import mzm.gsp.children.SLevelUpOccupationSkillRes;
/*     */ import mzm.gsp.children.confbean.SChildrenOccupationSkillCfg;
/*     */ import mzm.gsp.children.confbean.SChildrenOccupationSkillLevelUpCostCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ 
/*     */ public class PCLevelUpOccupationSkillReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int skillid;
/*     */   
/*     */   public PCLevelUpOccupationSkillReq(long roleid, long childrenid, int skillid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.childrenid = childrenid;
/*  29 */     this.skillid = skillid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  35 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  39 */       return false;
/*     */     }
/*  41 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  42 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  49 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  62 */     if (xChildInfo == null) {
/*  63 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     int period = xChildInfo.getChild_period();
/*  70 */     if (period != 2) {
/*  71 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  85 */     int occupation = xAdulthoodInfo.getOccupation();
/*  86 */     if (occupation <= 0) {
/*  87 */       sendError(2);
/*  88 */       return false;
/*     */     }
/*  90 */     SChildrenOccupationSkillCfg childrenOccupationSkillCfg = SChildrenOccupationSkillCfg.get(this.skillid);
/*  91 */     if (childrenOccupationSkillCfg == null) {
/*  92 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@skill error|roleid=%d|childid=%d|skillid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  97 */       sendError(1);
/*  98 */       return false;
/*     */     }
/* 100 */     if (childrenOccupationSkillCfg.occupation != occupation) {
/* 101 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@skill occupation error|roleid=%d|childid=%d|skillid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 106 */       return false;
/*     */     }
/* 108 */     SChildrenOccupationSkillLevelUpCostCfg levelUpCostCfg = SChildrenOccupationSkillLevelUpCostCfg.get(childrenOccupationSkillCfg.levelUpCostClassid);
/*     */     
/* 110 */     if (levelUpCostCfg == null) {
/* 111 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@levelUpCostCfg error|roleid=%d|childid=%d|skillid=%d|levelUpCostClassid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(childrenOccupationSkillCfg.levelUpCostClassid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 116 */       return false;
/*     */     }
/* 118 */     Integer nowLevel = (Integer)xAdulthoodInfo.getOccupationskill2value().get(Integer.valueOf(this.skillid));
/* 119 */     if (nowLevel == null)
/*     */     {
/* 121 */       nowLevel = Integer.valueOf(1);
/*     */     }
/* 123 */     if (nowLevel.intValue() >= mzm.gsp.role.main.RoleInterface.getLevel(this.roleid)) {
/* 124 */       sendError(4);
/* 125 */       return false;
/*     */     }
/* 127 */     Integer needItemCount = (Integer)levelUpCostCfg.skillLv2Count.get(nowLevel);
/* 128 */     if (needItemCount == null) {
/* 129 */       sendError(4);
/* 130 */       return false;
/*     */     }
/* 132 */     if (needItemCount.intValue() <= 0) {
/* 133 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@cost item count error|roleid=%d|childid=%d|skillid=%d|occupation=%d|count=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(occupation), needItemCount }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 138 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 142 */     int minChildrenEquipmentLevel = ChildrenManager.getChildrenEquipMinLevel(xAdulthoodInfo);
/* 143 */     int skillNeedEquipLevel = childrenOccupationSkillCfg.needEquipmentLevel;
/* 144 */     if (skillNeedEquipLevel > minChildrenEquipmentLevel) {
/* 145 */       sendError(5);
/* 146 */       GameServer.logger().error(String.format("[Children]PCLevelUpOccupationSkillReq.processImp@need equipment level error|roleid=%d|childid=%d|skillid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 151 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 155 */     int totalCostNum = 0;
/* 156 */     Map<Integer, Integer> costItemMap = new HashMap();
/* 157 */     for (Iterator i$ = childrenOccupationSkillCfg.subItemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/* 158 */       if (!costItemMap.containsKey(Integer.valueOf(itemid)))
/*     */       {
/*     */ 
/* 161 */         itemNum = ItemInterface.getItemNumberById(this.roleid, itemid);
/* 162 */         if (itemNum > 0) {
/* 163 */           int needCount = needItemCount.intValue() - totalCostNum;
/* 164 */           if (needCount <= 0) {
/*     */             break;
/*     */           }
/* 167 */           if (itemNum >= needCount) {
/* 168 */             costItemMap.put(Integer.valueOf(itemid), Integer.valueOf(needCount));
/* 169 */             totalCostNum += needCount;
/* 170 */             break;
/*     */           }
/* 172 */           costItemMap.put(Integer.valueOf(itemid), Integer.valueOf(itemNum));
/* 173 */           totalCostNum += itemNum;
/*     */         }
/*     */       }
/*     */     }
/* 177 */     if ((totalCostNum < needItemCount.intValue()) && 
/* 178 */       (!costItemMap.containsKey(Integer.valueOf(childrenOccupationSkillCfg.mainItemid)))) {
/* 179 */       int mainItemCount = ItemInterface.getItemNumberById(this.roleid, childrenOccupationSkillCfg.mainItemid);
/* 180 */       if (mainItemCount > 0) {
/* 181 */         needCount = needItemCount.intValue() - totalCostNum;
/* 182 */         if (mainItemCount >= needCount) {
/* 183 */           costItemMap.put(Integer.valueOf(childrenOccupationSkillCfg.mainItemid), Integer.valueOf(needCount));
/* 184 */           totalCostNum += needCount;
/*     */         } else {
/* 186 */           costItemMap.put(Integer.valueOf(childrenOccupationSkillCfg.mainItemid), Integer.valueOf(mainItemCount));
/* 187 */           totalCostNum += mainItemCount;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 194 */     if (totalCostNum < needItemCount.intValue()) {
/* 195 */       sendError(3);
/* 196 */       return false;
/*     */     }
/* 198 */     ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleid, costItemMap, new TLogArg(mzm.gsp.tlog.LogReason.CHILDREN_ADULT_LEVEL_UP_OCCUPATION_SKILL));
/*     */     
/* 200 */     if (!itemOperateResult.success()) {
/* 201 */       sendError(3);
/* 202 */       return false;
/*     */     }
/* 204 */     int needCount = nowLevel;int itemNum = nowLevel = Integer.valueOf(nowLevel.intValue() + 1);
/* 205 */     xAdulthoodInfo.getOccupationskill2value().put(Integer.valueOf(this.skillid), nowLevel);
/* 206 */     SLevelUpOccupationSkillRes levelUpOccupationSkillRes = new SLevelUpOccupationSkillRes();
/* 207 */     levelUpOccupationSkillRes.childrenid = this.childrenid;
/* 208 */     levelUpOccupationSkillRes.skillid = this.skillid;
/* 209 */     levelUpOccupationSkillRes.lv = nowLevel.intValue();
/* 210 */     OnlineManager.getInstance().send(this.roleid, levelUpOccupationSkillRes);
/*     */     
/* 212 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/*     */     
/* 214 */     ChildrenManager.tlogAdultOccupationSkillLevelUp(this.roleid, this.childrenid, this.skillid, nowLevel.intValue() - 1, nowLevel.intValue());
/* 215 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 219 */     SLevelUpOccupationSkillErrorRes errorRes = new SLevelUpOccupationSkillErrorRes();
/* 220 */     errorRes.ret = error;
/* 221 */     OnlineManager.getInstance().sendAtOnce(this.roleid, errorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCLevelUpOccupationSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */