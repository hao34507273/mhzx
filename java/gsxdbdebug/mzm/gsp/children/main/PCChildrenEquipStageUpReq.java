/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildrenEquipLevelUpRes;
/*     */ import mzm.gsp.children.SChildrenEquipStageUpErrorRes;
/*     */ import mzm.gsp.children.SChildrenEquipStageUpRes;
/*     */ import mzm.gsp.children.confbean.ChildrenEquipLevelBean;
/*     */ import mzm.gsp.children.confbean.ChildrenEquipStageBean;
/*     */ import mzm.gsp.children.confbean.SChildrenEquipLevelCfg;
/*     */ import mzm.gsp.item.confbean.SChildrenEquipItemCfg;
/*     */ import mzm.gsp.item.main.ChildrenEquipItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Item;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChildrenEquipStageUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int pos;
/*     */   private final boolean useYuanBao;
/*     */   private final int useYuanBaoNum;
/*     */   private final long totalYuanBaoNum;
/*     */   
/*     */   public PCChildrenEquipStageUpReq(long roleid, long childrenid, int pos, int useYuanbao, int useYuanBaoNum, long totalYuanBaoNum)
/*     */   {
/*  41 */     this.roleid = roleid;
/*  42 */     this.childrenid = childrenid;
/*  43 */     this.pos = pos;
/*  44 */     this.useYuanBao = (useYuanbao == 1);
/*  45 */     this.useYuanBaoNum = useYuanBaoNum;
/*  46 */     this.totalYuanBaoNum = totalYuanBaoNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid))
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipStageUpReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  56 */       return false;
/*     */     }
/*  58 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid))
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipStageUpReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  62 */       return false;
/*     */     }
/*  64 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  65 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  66 */     long totalNum = QingfuInterface.getBalance(userid, true);
/*  67 */     if (totalNum != this.totalYuanBaoNum)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipStageUpReq.processImp@total yuan bao num error|roleid=%d|sTotalNum=%d|cTotalNum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(totalNum), Long.valueOf(this.totalYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true))
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipStageUpReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid))
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  90 */     if (xChildInfo == null)
/*     */     {
/*  92 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipStageUpReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     int period = xChildInfo.getChild_period();
/* 104 */     if (period != 2)
/*     */     {
/* 106 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipStageUpReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/* 112 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 113 */     Item xItem = (Item)xAdulthoodInfo.getEquipitem().get(Integer.valueOf(this.pos));
/* 114 */     if (xItem == null)
/*     */     {
/* 116 */       sendError(3);
/* 117 */       return false;
/*     */     }
/* 119 */     int cfgid = xItem.getCfgid();
/* 120 */     SChildrenEquipItemCfg childrenEquipItemCfg = SChildrenEquipItemCfg.get(cfgid);
/* 121 */     if (childrenEquipItemCfg == null)
/*     */     {
/* 123 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipStageUpReq.processImp@SChildrenEquipItemCfg is null|cfgid=%d", new Object[] { Integer.valueOf(cfgid) }));
/*     */       
/*     */ 
/* 126 */       return false;
/*     */     }
/* 128 */     ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem(xItem);
/* 129 */     int nowStage = childrenEquipItem.getStage();
/* 130 */     if (childrenEquipItem.isToMaxStage())
/*     */     {
/* 132 */       sendError(4);
/* 133 */       return false;
/*     */     }
/* 135 */     ChildrenEquipStageBean equipNowStageBean = childrenEquipItem.getChildrenEquipStageBean(nowStage);
/* 136 */     if (equipNowStageBean == null)
/*     */     {
/* 138 */       sendError(4);
/* 139 */       return false;
/*     */     }
/* 141 */     int nowLevel = childrenEquipItem.getLevel();
/* 142 */     if (equipNowStageBean.needLevel > nowLevel)
/*     */     {
/* 144 */       sendError(5);
/* 145 */       return false;
/*     */     }
/* 147 */     Map<Integer, Integer> costItemMap = new HashMap();
/* 148 */     int costMainItemCount = equipNowStageBean.needItemNum;
/* 149 */     for (Iterator i$ = equipNowStageBean.subItemids.iterator(); i$.hasNext();) { int subItemid = ((Integer)i$.next()).intValue();
/*     */       
/* 151 */       int num = ItemInterface.getItemNumberById(this.roleid, subItemid);
/* 152 */       if (num >= costMainItemCount)
/*     */       {
/* 154 */         costItemMap.put(Integer.valueOf(subItemid), Integer.valueOf(costMainItemCount));
/* 155 */         costMainItemCount = 0;
/* 156 */         break;
/*     */       }
/* 158 */       if (num > 0)
/*     */       {
/* 160 */         costItemMap.put(Integer.valueOf(subItemid), Integer.valueOf(num));
/* 161 */         costMainItemCount -= num;
/*     */       }
/*     */     }
/* 164 */     if (costMainItemCount > 0)
/*     */     {
/* 166 */       Integer count = (Integer)costItemMap.get(Integer.valueOf(equipNowStageBean.mainItemid));
/* 167 */       if (count == null)
/*     */       {
/* 169 */         count = Integer.valueOf(0);
/*     */       }
/* 171 */       count = Integer.valueOf(count.intValue() + costMainItemCount);
/* 172 */       costItemMap.put(Integer.valueOf(equipNowStageBean.mainItemid), count);
/*     */     }
/* 174 */     boolean ret = false;
/* 175 */     if (this.useYuanBao)
/*     */     {
/* 177 */       ret = ItemInterface.removeItemsWithCutYuanbao(userid, this.roleid, CostType.COST_BIND_FIRST_CHILD_EQUIP_STAGE_UP, costItemMap, this.useYuanBaoNum, new TLogArg(LogReason.CHILDREN_ADULT_EQUIP_STAGE_UP_COST, this.pos));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 182 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleid, costItemMap, new TLogArg(LogReason.CHILDREN_ADULT_EQUIP_STAGE_UP_COST, this.pos));
/*     */       
/* 184 */       if (itemOperateResult.success())
/*     */       {
/* 186 */         ret = true;
/*     */       }
/*     */       else
/*     */       {
/* 190 */         ret = false;
/* 191 */         sendError(1);
/* 192 */         return false;
/*     */       }
/*     */     }
/* 195 */     if (!ret)
/*     */     {
/* 197 */       sendError(6);
/* 198 */       return false;
/*     */     }
/*     */     
/* 201 */     nowStage++;
/* 202 */     childrenEquipItem.setStage(nowStage);
/* 203 */     SChildrenEquipStageUpRes stageUpRes = new SChildrenEquipStageUpRes();
/* 204 */     stageUpRes.childrenid = this.childrenid;
/* 205 */     stageUpRes.pos = this.pos;
/* 206 */     stageUpRes.stage = nowStage;
/* 207 */     OnlineManager.getInstance().send(this.roleid, stageUpRes);
/*     */     
/* 209 */     ChildrenManager.tlogAdultEquipOper(this.roleid, this.childrenid, childrenEquipItem.getTlogUuid(), cfgid, this.pos, 3, nowStage - 1, nowStage, 0, 0);
/*     */     
/* 211 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/* 212 */     int originalEquipLevel = childrenEquipItem.getLevel();
/* 213 */     int childrenLevel = childrenOutFightObj.getLevel();
/* 214 */     int originalExp = childrenEquipItem.getExp();
/* 215 */     SChildrenEquipLevelCfg childrenEquipLevelCfg = childrenEquipItem.getChildrenEquipLevelCfg();
/* 216 */     for (int level = originalEquipLevel; level < childrenLevel; level++)
/*     */     {
/* 218 */       ChildrenEquipLevelBean equipLevelBean = (ChildrenEquipLevelBean)childrenEquipLevelCfg.level2EquipLevelBean.get(Integer.valueOf(level));
/* 219 */       if (equipLevelBean == null) {
/*     */         break;
/*     */       }
/*     */       
/* 223 */       if (nowStage < equipLevelBean.needStage) {
/*     */         break;
/*     */       }
/*     */       
/* 227 */       if (!childrenEquipLevelCfg.level2EquipLevelBean.containsKey(Integer.valueOf(level + 1))) {
/*     */         break;
/*     */       }
/*     */       
/* 231 */       int exp = childrenEquipItem.getExp();
/* 232 */       if (equipLevelBean.levelUpExp > exp) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 238 */       childrenEquipItem.setLevel(level + 1);
/* 239 */       exp -= equipLevelBean.levelUpExp;
/* 240 */       childrenEquipItem.setExp(exp);
/*     */     }
/*     */     
/* 243 */     int nowEquipLevel = childrenEquipItem.getLevel();
/* 244 */     if (nowEquipLevel > originalEquipLevel)
/*     */     {
/* 246 */       int nowExp = childrenEquipItem.getExp();
/* 247 */       SChildrenEquipLevelUpRes childrenEquipLevelUpRes = new SChildrenEquipLevelUpRes();
/* 248 */       childrenEquipLevelUpRes.childrenid = this.childrenid;
/* 249 */       childrenEquipLevelUpRes.exp = nowExp;
/* 250 */       childrenEquipLevelUpRes.level = nowEquipLevel;
/* 251 */       childrenEquipLevelUpRes.pos = this.pos;
/* 252 */       OnlineManager.getInstance().send(this.roleid, childrenEquipLevelUpRes);
/* 253 */       ChildrenManager.tlogAdultEquipOper(this.roleid, this.childrenid, childrenEquipItem.getTlogUuid(), cfgid, this.pos, 2, originalEquipLevel, nowEquipLevel, originalExp, nowExp);
/*     */     }
/*     */     
/* 256 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error)
/*     */   {
/* 261 */     SChildrenEquipStageUpErrorRes res = new SChildrenEquipStageUpErrorRes();
/* 262 */     res.ret = error;
/* 263 */     OnlineManager.getInstance().sendAtOnce(this.roleid, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenEquipStageUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */