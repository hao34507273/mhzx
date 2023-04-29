/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildrenEquipLevelUpErrorRes;
/*     */ import mzm.gsp.children.SChildrenEquipLevelUpRes;
/*     */ import mzm.gsp.children.confbean.ChildrenEquipLevelBean;
/*     */ import mzm.gsp.children.confbean.SChildrenEquipLevelCfg;
/*     */ import mzm.gsp.item.confbean.SChildrenEquipItemCfg;
/*     */ import mzm.gsp.item.confbean.SChildrenEquipLevelUpItemCfg;
/*     */ import mzm.gsp.item.main.ChildrenEquipItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Item;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChildrenEquipLevelUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int pos;
/*     */   private final int itemCfgId;
/*     */   private boolean isUseAll;
/*     */   
/*     */   public PCChildrenEquipLevelUpReq(long roleid, long childrenid, int pos, int itemCfgId, int isUseAll)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.childrenid = childrenid;
/*  35 */     this.pos = pos;
/*  36 */     this.itemCfgId = itemCfgId;
/*  37 */     this.isUseAll = (isUseAll == 1);
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  42 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  43 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  47 */       return false;
/*     */     }
/*  49 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  50 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  53 */       return false;
/*     */     }
/*  55 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  56 */     lock(User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/*     */     
/*  58 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  59 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  72 */     if (xChildInfo == null) {
/*  73 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     int period = xChildInfo.getChild_period();
/*  86 */     if (period != 2) {
/*  87 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*  94 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  95 */     Item xItem = (Item)xAdulthoodInfo.getEquipitem().get(Integer.valueOf(this.pos));
/*  96 */     if (xItem == null) {
/*  97 */       sendError(3);
/*  98 */       return false;
/*     */     }
/* 100 */     int cfgid = xItem.getCfgid();
/* 101 */     SChildrenEquipItemCfg childrenEquipItemCfg = SChildrenEquipItemCfg.get(cfgid);
/* 102 */     if (childrenEquipItemCfg == null) {
/* 103 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@SChildrenEquipItemCfg is null|cfgid=%d", new Object[] { Integer.valueOf(cfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 107 */       return false;
/*     */     }
/* 109 */     ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem(xItem);
/* 110 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 112 */     int childrenLevel = childrenOutFightObj.getLevel();
/* 113 */     int originalEquipLevel = childrenEquipItem.getLevel();
/* 114 */     int originalExp = childrenEquipItem.getExp();
/* 115 */     if (originalEquipLevel >= childrenLevel) {
/* 116 */       sendError(6);
/* 117 */       return false;
/*     */     }
/* 119 */     int stage = childrenEquipItem.getStage();
/* 120 */     SChildrenEquipLevelCfg childrenEquipLevelCfg = childrenEquipItem.getChildrenEquipLevelCfg();
/* 121 */     if (childrenEquipLevelCfg == null) {
/* 122 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@SChildrenEquipLevelCfg is null|cfgid=%d", new Object[] { Integer.valueOf(cfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     SChildrenEquipLevelUpItemCfg childrenEquipLevelUpItemCfg = SChildrenEquipLevelUpItemCfg.get(this.itemCfgId);
/* 130 */     if (childrenEquipLevelUpItemCfg == null) {
/* 131 */       sendError(2);
/* 132 */       return false;
/*     */     }
/* 134 */     ChildrenEquipLevelBean nowLevelBean = (ChildrenEquipLevelBean)childrenEquipLevelCfg.level2EquipLevelBean.get(Integer.valueOf(originalEquipLevel));
/* 135 */     if (nowLevelBean == null) {
/* 136 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@ChildrenEquipLevelBean is null|cfgid=%d|level=%d", new Object[] { Integer.valueOf(cfgid), Integer.valueOf(originalEquipLevel) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 141 */       return false;
/*     */     }
/* 143 */     if (!nowLevelBean.itemids.contains(Integer.valueOf(this.itemCfgId))) {
/* 144 */       sendError(2);
/* 145 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@item can not use|cfgid=%d|level=%d|equipitemCfgid=%d", new Object[] { Integer.valueOf(cfgid), Integer.valueOf(originalEquipLevel), Integer.valueOf(this.itemCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (nowLevelBean.needStage > stage) {
/* 154 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@stage not enough|cfgid=%d|level=%d|stage=%d|needStage=%d", new Object[] { Integer.valueOf(cfgid), Integer.valueOf(originalEquipLevel), Integer.valueOf(stage), Integer.valueOf(nowLevelBean.needStage) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 159 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 163 */     int itemNum = this.isUseAll ? ItemInterface.getItemNumberByType(this.roleid, 340600000, childrenEquipLevelUpItemCfg.type, true) : 1;
/* 164 */     int preferExp = CommonUtils.multiply(itemNum, childrenEquipLevelUpItemCfg.exp);
/* 165 */     if (preferExp <= 0) {
/* 166 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipLevelUpReq.processImp@calExp error|roleid=%d|is_use_all=%b|exp=%d", new Object[] { Long.valueOf(this.roleid), Boolean.valueOf(this.isUseAll), Integer.valueOf(childrenEquipLevelUpItemCfg.exp) }));
/*     */       
/*     */ 
/*     */ 
/* 170 */       return false;
/*     */     }
/* 172 */     int totalCanUseExp = preferExp + originalExp;
/* 173 */     for (int level = originalEquipLevel; level < childrenLevel; level++) {
/* 174 */       ChildrenEquipLevelBean equipLevelBean = (ChildrenEquipLevelBean)childrenEquipLevelCfg.level2EquipLevelBean.get(Integer.valueOf(level));
/* 175 */       if (equipLevelBean == null) {
/*     */         break;
/*     */       }
/* 178 */       if (stage < equipLevelBean.needStage) {
/*     */         break;
/*     */       }
/* 181 */       if (!childrenEquipLevelCfg.level2EquipLevelBean.containsKey(Integer.valueOf(level + 1))) {
/*     */         break;
/*     */       }
/* 184 */       if (!equipLevelBean.itemids.contains(Integer.valueOf(this.itemCfgId))) {
/*     */         break;
/*     */       }
/* 187 */       if (equipLevelBean.levelUpExp == totalCanUseExp)
/*     */       {
/* 189 */         childrenEquipItem.setLevel(level + 1);
/* 190 */         childrenEquipItem.setExp(0);
/* 191 */         totalCanUseExp = 0;
/* 192 */         break; }
/* 193 */       if (equipLevelBean.levelUpExp > totalCanUseExp) {
/* 194 */         childrenEquipItem.setExp(totalCanUseExp);
/* 195 */         totalCanUseExp = 0;
/* 196 */         break;
/*     */       }
/* 198 */       totalCanUseExp -= equipLevelBean.levelUpExp;
/* 199 */       int nowLevel = childrenEquipItem.getLevel() + 1;
/* 200 */       childrenEquipItem.setLevel(nowLevel);
/* 201 */       childrenEquipItem.setExp(0);
/*     */     }
/*     */     
/* 204 */     int useExp = preferExp - totalCanUseExp;
/* 205 */     if (useExp <= 0)
/*     */     {
/* 207 */       childrenEquipItem.setExp(Math.abs(useExp));
/*     */     } else {
/* 209 */       int extraExp = useExp % childrenEquipLevelUpItemCfg.exp;
/* 210 */       int useItemCount = useExp / childrenEquipLevelUpItemCfg.exp;
/* 211 */       if (extraExp > 0) {
/* 212 */         childrenEquipItem.setExp(childrenEquipItem.getExp() + childrenEquipLevelUpItemCfg.exp - extraExp);
/* 213 */         useItemCount++;
/*     */       }
/*     */       
/* 216 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemsByItemType(this.roleid, childrenEquipLevelUpItemCfg.type, useItemCount, true, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.CHILDREN_ADULT_EQUIP_LEVEL_UP_COST, this.pos));
/* 217 */       if (!itemOperateResult.success())
/*     */       {
/* 219 */         sendError(1);
/* 220 */         return false;
/*     */       }
/*     */     }
/* 223 */     int nowEquipLevel = childrenEquipItem.getLevel();
/* 224 */     int nowExp = childrenEquipItem.getExp();
/* 225 */     if (nowEquipLevel > originalEquipLevel) {
/* 226 */       childrenOutFightObj.updateEquipment();
/* 227 */       childrenOutFightObj.synPropertyChange(this.roleid);
/*     */     }
/* 229 */     SChildrenEquipLevelUpRes childrenEquipLevelUpRes = new SChildrenEquipLevelUpRes();
/* 230 */     childrenEquipLevelUpRes.childrenid = this.childrenid;
/* 231 */     childrenEquipLevelUpRes.exp = nowExp;
/* 232 */     childrenEquipLevelUpRes.level = nowEquipLevel;
/* 233 */     childrenEquipLevelUpRes.pos = this.pos;
/* 234 */     OnlineManager.getInstance().send(this.roleid, childrenEquipLevelUpRes);
/*     */     
/* 236 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/*     */     
/* 238 */     ChildrenManager.tlogAdultEquipOper(this.roleid, this.childrenid, childrenEquipItem.getTlogUuid(), cfgid, this.pos, 2, originalEquipLevel, nowEquipLevel, originalExp, nowExp);
/*     */     
/* 240 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 244 */     SChildrenEquipLevelUpErrorRes res = new SChildrenEquipLevelUpErrorRes();
/* 245 */     res.ret = error;
/* 246 */     OnlineManager.getInstance().sendAtOnce(this.roleid, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenEquipLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */