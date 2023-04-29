/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildrenRefreshAmuletErrorRes;
/*     */ import mzm.gsp.children.SChildrenRefreshAmuletRes;
/*     */ import mzm.gsp.item.confbean.SPetXilianItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.PetEquipmentItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Item;
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChildrenRefreshAmuletReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final boolean useYuanbao;
/*     */   private final int costYuanBao;
/*     */   private final long yuanbaoNum;
/*     */   private final long childrenid;
/*     */   
/*     */   public PCChildrenRefreshAmuletReq(long roleid, int costtype, int costyuanbao, long yuanbaonum, long childrenid)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.useYuanbao = (costtype == 1);
/*  42 */     this.costYuanBao = costyuanbao;
/*  43 */     this.yuanbaoNum = yuanbaonum;
/*  44 */     this.childrenid = childrenid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  49 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  50 */       GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*  56 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  57 */       GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     String userid = RoleInterface.getUserId(this.roleid);
/*  64 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  65 */     long sYuanBaoNum = QingfuInterface.getBalance(userid, true);
/*  66 */     if ((this.useYuanbao) && (this.yuanbaoNum != sYuanBaoNum)) {
/*  67 */       GameServer.logger().info(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@cyuanbao not match syuanbao|roleid=%d|yuanbaonum=%d|serverYuanBaoNum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.yuanbaoNum), Long.valueOf(sYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  76 */       GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  89 */     if (xChildInfo == null) {
/*  90 */       GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int period = xChildInfo.getChild_period();
/* 103 */     if (period != 2) {
/* 104 */       GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 109 */       return false;
/*     */     }
/* 111 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 112 */     Item xItem = (Item)xAdulthoodInfo.getEquippetitem().get(Integer.valueOf(2));
/* 113 */     if (xItem == null) {
/* 114 */       sendError(3);
/* 115 */       return false;
/*     */     }
/* 117 */     int cfgid = xItem.getCfgid();
/* 118 */     SPetEquipItem petEquipItemCfg = SPetEquipItem.get(cfgid);
/* 119 */     if (petEquipItemCfg == null) {
/* 120 */       GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@SPetEquipItem is null|cfgid=%d", new Object[] { Integer.valueOf(cfgid) }));
/*     */       
/*     */ 
/* 123 */       return false;
/*     */     }
/* 125 */     if (petEquipItemCfg.equipType != 2) {
/* 126 */       return false;
/*     */     }
/* 128 */     List<SPetXilianItem> xiLianIdList = new ArrayList();
/* 129 */     for (SPetXilianItem item : SPetXilianItem.getAllSelf().values()) {
/* 130 */       if (item.xilianItemLevel >= petEquipItemCfg.equipLevel) {
/* 131 */         xiLianIdList.add(item);
/*     */       }
/*     */     }
/* 134 */     java.util.Collections.sort(xiLianIdList, new mzm.gsp.pet.main.PetXiLianItemComparator());
/* 135 */     if (xiLianIdList.size() <= 0) {
/* 136 */       sendError(2);
/* 137 */       return false;
/*     */     }
/* 139 */     boolean remove = false;
/* 140 */     for (SPetXilianItem petXilianItem : xiLianIdList)
/*     */     {
/* 142 */       if (ItemInterface.removeItemById(this.roleid, 340600000, petXilianItem.id, 1, new TLogArg(LogReason.CHILDREN_ADULT_EQUIP_REFRESH_AMULET_COST)))
/*     */       {
/* 144 */         remove = true;
/* 145 */         break;
/*     */       }
/*     */     }
/* 148 */     if (!remove) {
/* 149 */       if (!this.useYuanbao) {
/* 150 */         sendError(1);
/* 151 */         return false;
/*     */       }
/* 153 */       SPetXilianItem petXilianItem = (SPetXilianItem)xiLianIdList.get(0);
/*     */       
/* 155 */       int itemPrice = ItemInterface.getItemYuanBaoPrice(petXilianItem.id);
/* 156 */       if (itemPrice <= 0) {
/* 157 */         sendError(5);
/* 158 */         GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@itemprice error|itemcfgid=%d|price=%d", new Object[] { Integer.valueOf(petXilianItem.id), Integer.valueOf(itemPrice) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 163 */         return false;
/*     */       }
/* 165 */       if (itemPrice != this.costYuanBao) {
/* 166 */         sendError(5);
/* 167 */         return false;
/*     */       }
/*     */       
/* 170 */       if (QingfuInterface.costYuanbao(userid, this.roleid, itemPrice, CostType.COST_BIND_FIRST_CHILD_REFRESH_AMULET, new TLogArg(LogReason.CHILDREN_ADULT_EQUIP_REFRESH_AMULET_COST)) != CostResult.Success)
/*     */       {
/*     */ 
/* 173 */         sendError(4);
/* 174 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 178 */     PetEquipmentItem petEquipmentItem = new PetEquipmentItem(xItem);
/* 179 */     List<Integer> originalSkills = petEquipmentItem.getSkills();
/* 180 */     int skillNum = originalSkills.size();
/* 181 */     List<Integer> skillList = PetInterface.getRefreshPetEquipAmuletSkills(skillNum, petEquipItemCfg);
/* 182 */     int skillSize = skillList.size();
/* 183 */     if (skillSize <= 0) {
/* 184 */       GameServer.logger().error(String.format("[Children]PCChildrenRefreshAmuletReq.processImp@refresh skill number is less than zero|roleid=%d|cfgid=%d|skillSize=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(petEquipItemCfg.id), Integer.valueOf(skillSize) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 189 */       return false;
/*     */     }
/* 191 */     petEquipmentItem.setSkills(skillList);
/* 192 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 194 */     childrenOutFightObj.updatePassiveSkill();
/* 195 */     SChildrenRefreshAmuletRes refreshAmuletRes = new SChildrenRefreshAmuletRes();
/* 196 */     refreshAmuletRes.childrenid = this.childrenid;
/* 197 */     refreshAmuletRes.skillids.addAll(skillList);
/* 198 */     OnlineManager.getInstance().send(this.roleid, refreshAmuletRes);
/*     */     
/* 200 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/*     */     
/* 202 */     ChildrenManager.tlogAdultRefreshAmulet(this.roleid, this.childrenid, petEquipmentItem.getTlogUuid(), cfgid, getComplexStr(originalSkills), getComplexStr(skillList));
/*     */     
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 208 */     SChildrenRefreshAmuletErrorRes errorRes = new SChildrenRefreshAmuletErrorRes();
/* 209 */     errorRes.ret = error;
/* 210 */     OnlineManager.getInstance().sendAtOnce(this.roleid, errorRes);
/*     */   }
/*     */   
/*     */   static <T> String getComplexStr(Collection<T> params) {
/* 214 */     if ((params == null) || (params.size() <= 0)) {
/* 215 */       return "";
/*     */     }
/* 217 */     StringBuilder stringBuilder = new StringBuilder();
/* 218 */     String splitString = ",";
/* 219 */     boolean first = true;
/* 220 */     for (T param : params) {
/* 221 */       if (!first) {
/* 222 */         stringBuilder.append(splitString);
/*     */       } else {
/* 224 */         first = false;
/*     */       }
/* 226 */       stringBuilder.append(param);
/*     */     }
/* 228 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenRefreshAmuletReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */