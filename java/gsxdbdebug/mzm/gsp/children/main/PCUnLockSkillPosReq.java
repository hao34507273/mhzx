/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SUnLockSkillPosErrorRes;
/*     */ import mzm.gsp.children.SUnLockSkillPosRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.confbean.SChildrenUnLockSkillCfg;
/*     */ import mzm.gsp.children.confbean.UnLockSkillCost;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ 
/*     */ public class PCUnLockSkillPosReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long childrenid;
/*     */   private boolean useYuanBao;
/*     */   private final long useyuanbaonum;
/*     */   private int unLockNumNow;
/*     */   
/*     */   public PCUnLockSkillPosReq(long roleid, long childrenid, int useyuanbao, long useyuanbaonum, int nownum)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.childrenid = childrenid;
/*  35 */     this.useYuanBao = (useyuanbao != 0);
/*  36 */     this.useyuanbaonum = useyuanbaonum;
/*  37 */     this.unLockNumNow = nownum;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  42 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  43 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  46 */       return false;
/*     */     }
/*  48 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  49 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  51 */       return false;
/*     */     }
/*  53 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  55 */     lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/*     */     
/*  57 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  58 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  70 */     if (xChildInfo == null) {
/*  71 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*  74 */       return false;
/*     */     }
/*  76 */     int period = xChildInfo.getChild_period();
/*  77 */     if (period != 2) {
/*  78 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  92 */     int unLockNum = xAdulthoodInfo.getUnlockskillposnum();
/*  93 */     if (unLockNum != this.unLockNumNow) {
/*  94 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@child unlock error|roleid=%d|childid=%d|unlock=%d|clientUnLock=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockNum), Integer.valueOf(this.unLockNumNow) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/* 101 */     if (SChildrenConsts.getInstance().child_common_skill_max <= unLockNum + SChildrenConsts.getInstance().child_init_skill_pos_max)
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@can not unlock|roleid=%d|childid=%d|unLock=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockNum) }));
/*     */       
/*     */ 
/*     */ 
/* 107 */       sendError(3);
/* 108 */       return false;
/*     */     }
/* 110 */     UnLockSkillCost unLockSkillCost = null;
/* 111 */     Iterator i$ = SChildrenUnLockSkillCfg.getAll().values().iterator(); if (i$.hasNext()) { SChildrenUnLockSkillCfg unLockSkillCfg = (SChildrenUnLockSkillCfg)i$.next();
/* 112 */       if (unLockNum < unLockSkillCfg.unLockSkillCostList.size()) {
/* 113 */         unLockSkillCost = (UnLockSkillCost)unLockSkillCfg.unLockSkillCostList.get(unLockNum);
/*     */       }
/*     */     }
/*     */     
/* 117 */     if (unLockSkillCost == null) {
/* 118 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@can not unlock|roleid=%d|childid=%d|unLock=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockNum) }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       sendError(3);
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     int totalCostNum = 0;
/* 127 */     int needItemCount = unLockSkillCost.unLockItemNum;
/* 128 */     if (needItemCount <= 0) {
/* 129 */       GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@need item count error|roleid=%d|childid=%d|unLock=%d|needItemCount=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockNum), Integer.valueOf(needItemCount) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 134 */       return false;
/*     */     }
/* 136 */     Map<Integer, Integer> costItemMap = new HashMap();
/* 137 */     totalCostNum = calCostItem(costItemMap, totalCostNum, needItemCount, unLockSkillCost.unLocksubItem1);
/*     */     
/* 139 */     if (totalCostNum < needItemCount) {
/* 140 */       totalCostNum = calCostItem(costItemMap, totalCostNum, needItemCount, unLockSkillCost.unLockMainItem);
/*     */     }
/* 142 */     if (totalCostNum < needItemCount) {
/* 143 */       if (!this.useYuanBao) {
/* 144 */         sendError(2);
/* 145 */         return false;
/*     */       }
/* 147 */       int yuanbaoPrice = ItemInterface.getItemYuanBaoPrice(unLockSkillCost.unLockMainItem);
/* 148 */       if (yuanbaoPrice <= 0) {
/* 149 */         GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@yuanbao price error|roleid=%d|childid=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockSkillCost.unLockMainItem), Integer.valueOf(yuanbaoPrice) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 154 */         return false;
/*     */       }
/* 156 */       int extraNum = needItemCount - totalCostNum;
/* 157 */       long totalPrice = yuanbaoPrice * 1L * extraNum;
/* 158 */       if (totalPrice <= 0L) {
/* 159 */         GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@yuanbao price error|roleid=%d|childid=%d|itemid=%d|price=%d|totalPrice=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockSkillCost.unLockMainItem), Integer.valueOf(yuanbaoPrice), Long.valueOf(totalPrice), Integer.valueOf(extraNum) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 165 */         return false;
/*     */       }
/* 167 */       if (totalPrice != this.useyuanbaonum) {
/* 168 */         GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@yuanbao price error|roleid=%d|childid=%d|itemid=%d|price=%d|totalPrice=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockSkillCost.unLockMainItem), Integer.valueOf(yuanbaoPrice), Long.valueOf(totalPrice), Integer.valueOf(extraNum) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 174 */         sendError(4);
/* 175 */         return false;
/*     */       }
/* 177 */       if (totalPrice > 2147483647L) {
/* 178 */         GameServer.logger().error(String.format("[Children]PCUnLockSkillPosReq.processImp@total price error|roleid=%d|childid=%d|itemid=%d|price=%d|totalPrice=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(unLockSkillCost.unLockMainItem), Integer.valueOf(yuanbaoPrice), Long.valueOf(totalPrice), Integer.valueOf(extraNum) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */         return false;
/*     */       }
/* 186 */       int totalPriceToInt = (int)totalPrice;
/* 187 */       CostResult costResult = mzm.gsp.qingfu.main.QingfuInterface.costYuanbao(userid, this.roleid, totalPriceToInt, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_CHILD_UNLOCK_SKILL_POS, new TLogArg(LogReason.CHILDREN_ADULT_UNLOCK_SKILL_POS, this.unLockNumNow));
/*     */       
/*     */ 
/* 190 */       if (costResult != CostResult.Success) {
/* 191 */         sendError(1);
/* 192 */         return false;
/*     */       }
/*     */     }
/* 195 */     if (costItemMap.size() > 0) {
/* 196 */       ItemOperateResult operateResult = ItemInterface.removeItemById(this.roleid, costItemMap, new TLogArg(LogReason.CHILDREN_ADULT_UNLOCK_SKILL_POS, this.unLockNumNow));
/*     */       
/* 198 */       if (!operateResult.success()) {
/* 199 */         sendError(2);
/* 200 */         return false;
/*     */       }
/*     */     }
/* 203 */     int finalUnLockNum = unLockNum + 1;
/* 204 */     xAdulthoodInfo.setUnlockskillposnum(finalUnLockNum);
/* 205 */     SUnLockSkillPosRes unLockSkillPosRes = new SUnLockSkillPosRes();
/* 206 */     unLockSkillPosRes.childrenid = this.childrenid;
/* 207 */     unLockSkillPosRes.nownum = finalUnLockNum;
/* 208 */     OnlineManager.getInstance().send(this.roleid, unLockSkillPosRes);
/*     */     
/* 210 */     ChildrenManager.tlogAdultUnLockSkillPos(this.roleid, this.childrenid, unLockNum, finalUnLockNum);
/* 211 */     GameServer.logger().info(String.format("[Children]PCUnLockSkillPosReq.processImp@unlock skill|roleid=%d|beforeNum=%d|afterNum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(unLockNum), Integer.valueOf(finalUnLockNum) }));
/*     */     
/*     */ 
/*     */ 
/* 215 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 219 */     SUnLockSkillPosErrorRes unLockSkillPosErrorRes = new SUnLockSkillPosErrorRes();
/* 220 */     unLockSkillPosErrorRes.ret = error;
/* 221 */     OnlineManager.getInstance().sendAtOnce(this.roleid, unLockSkillPosErrorRes);
/*     */   }
/*     */   
/*     */   private int calCostItem(Map<Integer, Integer> costMap, int totalCostNum, int needItemCount, int needItemid) {
/* 225 */     if (costMap.containsKey(Integer.valueOf(needItemid))) {
/* 226 */       return totalCostNum;
/*     */     }
/* 228 */     int itemNum = ItemInterface.getItemNumberById(this.roleid, needItemid);
/* 229 */     if (itemNum <= 0) {
/* 230 */       return totalCostNum;
/*     */     }
/* 232 */     int needCount = needItemCount - totalCostNum;
/* 233 */     if (needCount <= 0) {
/* 234 */       return totalCostNum;
/*     */     }
/* 236 */     if (itemNum >= needCount) {
/* 237 */       costMap.put(Integer.valueOf(needItemid), Integer.valueOf(needCount));
/* 238 */       totalCostNum += needCount;
/* 239 */       return totalCostNum;
/*     */     }
/* 241 */     costMap.put(Integer.valueOf(needItemid), Integer.valueOf(itemNum));
/* 242 */     totalCostNum += itemNum;
/* 243 */     return totalCostNum;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCUnLockSkillPosReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */