/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildrenEquipRandomErrorRes;
/*     */ import mzm.gsp.children.SChildrenEquipRandomRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
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
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChildrenEquipRandomReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int pos;
/*     */   private final boolean useyuanbao;
/*     */   private final int useyuanbaonum;
/*     */   private final long totalyuanbaonum;
/*     */   
/*     */   public PCChildrenEquipRandomReq(long roleid, long childrenid, int pos, int useyuanbao, int useyuanbaonum, long totalyuanbaonum)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.childrenid = childrenid;
/*  39 */     this.pos = pos;
/*  40 */     this.useyuanbao = (useyuanbao == 1);
/*  41 */     this.useyuanbaonum = useyuanbaonum;
/*  42 */     this.totalyuanbaonum = totalyuanbaonum;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  47 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  48 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipRandomReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  51 */       return false;
/*     */     }
/*  53 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  54 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipRandomReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  57 */       return false;
/*     */     }
/*  59 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  60 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  61 */     long totalNum = QingfuInterface.getBalance(userid, true);
/*  62 */     if (totalNum != this.totalyuanbaonum) {
/*  63 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipRandomReq.processImp@total yuan bao num error|roleid=%d|sTotalNum=%d|cTotalNum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(totalNum), Long.valueOf(this.totalyuanbaonum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  72 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipRandomReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  84 */     if (xChildInfo == null) {
/*  85 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipRandomReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     int period = xChildInfo.getChild_period();
/*  98 */     if (period != 2) {
/*  99 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipRandomReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 104 */       return false;
/*     */     }
/* 106 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 107 */     Item xItem = (Item)xAdulthoodInfo.getEquipitem().get(Integer.valueOf(this.pos));
/* 108 */     if (xItem == null) {
/* 109 */       sendError(5);
/* 110 */       return false;
/*     */     }
/* 112 */     int cfgid = xItem.getCfgid();
/* 113 */     SChildrenEquipItemCfg childrenEquipItemCfg = SChildrenEquipItemCfg.get(cfgid);
/* 114 */     if (childrenEquipItemCfg == null) {
/* 115 */       GameServer.logger().error(String.format("[Children]PCChildrenEquipRandomReq.processImp@SChildrenEquipItemCfg is null|cfgid=%d", new Object[] { Integer.valueOf(cfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 119 */       return false;
/*     */     }
/* 121 */     ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem(xItem);
/* 122 */     int orginalPropA = childrenEquipItem.getPropA();
/* 123 */     int nowPropA = childrenEquipItem.randomPropA(orginalPropA);
/* 124 */     if (nowPropA == 0) {
/* 125 */       sendError(4);
/* 126 */       return false;
/*     */     }
/* 128 */     Map<Integer, Integer> costItemMap = new HashMap();
/* 129 */     int costMainItemCount = SChildrenConsts.getInstance().child_random_property_item_count;
/* 130 */     if (SChildrenConsts.getInstance().child_random_property_sub_item > 0) {
/* 131 */       int num = ItemInterface.getItemNumberById(this.roleid, SChildrenConsts.getInstance().child_random_property_sub_item);
/*     */       
/* 133 */       if (num >= costMainItemCount) {
/* 134 */         costItemMap.put(Integer.valueOf(SChildrenConsts.getInstance().child_random_property_sub_item), Integer.valueOf(costMainItemCount));
/* 135 */         costMainItemCount = 0;
/* 136 */       } else if (num > 0) {
/* 137 */         costItemMap.put(Integer.valueOf(SChildrenConsts.getInstance().child_random_property_sub_item), Integer.valueOf(num));
/* 138 */         costMainItemCount -= num;
/*     */       }
/*     */     }
/* 141 */     if (costMainItemCount > 0) {
/* 142 */       Integer count = (Integer)costItemMap.get(Integer.valueOf(SChildrenConsts.getInstance().child_random_property_main_item));
/* 143 */       if (count == null) {
/* 144 */         count = Integer.valueOf(0);
/*     */       }
/* 146 */       count = Integer.valueOf(count.intValue() + costMainItemCount);
/* 147 */       costItemMap.put(Integer.valueOf(SChildrenConsts.getInstance().child_random_property_main_item), count);
/*     */     }
/* 149 */     boolean ret = false;
/* 150 */     if (this.useyuanbao) {
/* 151 */       ret = ItemInterface.removeItemsWithCutYuanbao(userid, this.roleid, CostType.COST_BIND_FIRST_CHILD_EQUIP_RANDOM_PROP, costItemMap, this.useyuanbaonum, new TLogArg(LogReason.CHILDREN_ADULT_EQUIP_RANDOM_PROP_COST, this.pos));
/*     */     }
/*     */     else
/*     */     {
/* 155 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleid, costItemMap, new TLogArg(LogReason.CHILDREN_ADULT_EQUIP_RANDOM_PROP_COST, this.pos));
/*     */       
/* 157 */       if (itemOperateResult.success()) {
/* 158 */         ret = true;
/*     */       } else {
/* 160 */         ret = false;
/* 161 */         sendError(1);
/* 162 */         return false;
/*     */       }
/*     */     }
/* 165 */     if (!ret) {
/* 166 */       sendError(3);
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     childrenEquipItem.setPropA(nowPropA);
/* 171 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 173 */     childrenOutFightObj.updateEquipment();
/* 174 */     childrenOutFightObj.synPropertyChange(this.roleid);
/* 175 */     SChildrenEquipRandomRes res = new SChildrenEquipRandomRes();
/* 176 */     res.childrenid = this.childrenid;
/* 177 */     res.pos = this.pos;
/* 178 */     res.originalproptype = orginalPropA;
/* 179 */     res.nowproptype = nowPropA;
/* 180 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 182 */     ChildrenManager.tlogAdultEquipOper(this.roleid, this.childrenid, childrenEquipItem.getTlogUuid(), cfgid, costMainItemCount, 1, orginalPropA, nowPropA, 0, 0);
/*     */     
/* 184 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 188 */     SChildrenEquipRandomErrorRes res = new SChildrenEquipRandomErrorRes();
/* 189 */     res.ret = error;
/* 190 */     OnlineManager.getInstance().sendAtOnce(this.roleid, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenEquipRandomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */