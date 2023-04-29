/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.bag.confbean.ItemType2BagCfg;
/*     */ import mzm.gsp.homeland.main.DoubleOutPutBean;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ChangeItemInfo;
/*     */ import mzm.gsp.lifeskill.SLianYaoRes;
/*     */ import mzm.gsp.lifeskill.SSyncCommonInfo;
/*     */ import mzm.gsp.lifeskill.event.LianYaoEvent;
/*     */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.LianYaoSkillConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleLifeSkill;
/*     */ import xtable.Role2lifeskill;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PLianYaoReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int skillBagId;
/*     */   private final List<Integer> itemKeyList;
/*  37 */   private static final Logger logger = Logger.getLogger(PLianYaoReq.class);
/*     */   
/*     */   public PLianYaoReq(long roleId, int skillBagId, List<Integer> itemidList) {
/*  40 */     this.roleId = roleId;
/*  41 */     this.skillBagId = skillBagId;
/*  42 */     this.itemKeyList = itemidList;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!LifeSkillManager.isLifeSkillSwitchOpenForRole(this.roleId)) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     int getItemNum = 1;
/*     */     
/*  54 */     DoubleOutPutBean doubleOutPutBean = HomelandInterface.isDoubleLianYaoOutPut(this.roleId);
/*  55 */     if ((doubleOutPutBean != null) && (doubleOutPutBean.isAtHome()) && (doubleOutPutBean.isDoubleOutPut())) {
/*  56 */       getItemNum = 2;
/*     */     }
/*     */     
/*     */ 
/*  60 */     if (ItemInterface.isBagFull(this.roleId, 340600000, true))
/*     */     {
/*  62 */       sendErrMsg(1);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (ItemInterface.isBagFull(this.roleId, 340600008, true))
/*     */     {
/*  68 */       sendErrMsg(6);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     RoleLifeSkill xRoleLifeSKill = Role2lifeskill.get(Long.valueOf(this.roleId));
/*  74 */     if (xRoleLifeSKill == null) {
/*  75 */       return false;
/*     */     }
/*  77 */     Integer lv = (Integer)xRoleLifeSKill.getLifeskillbagmap().get(Integer.valueOf(this.skillBagId));
/*  78 */     if (lv == null) {
/*  79 */       return false;
/*     */     }
/*  81 */     LianYaoSkillBag lianYaoSkillBag = new LianYaoSkillBag(this.skillBagId, lv.intValue());
/*  82 */     LianYaoSkill skill = lianYaoSkillBag.randomSkill();
/*  83 */     if (skill == null) {
/*  84 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/*  85 */       commonInfo.res = 5;
/*  86 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/*  87 */       return false;
/*     */     }
/*  89 */     for (Iterator i$ = this.itemKeyList.iterator(); i$.hasNext();) { int itemKey = ((Integer)i$.next()).intValue();
/*  90 */       BasicItem item = ItemInterface.getItem(this.roleId, 340600000, itemKey);
/*     */       
/*  92 */       if (item == null) {
/*  93 */         return false;
/*     */       }
/*  95 */       SItemCfg cfg = ItemInterface.getSItemCfg(item.getCfgId());
/*  96 */       if ((cfg.type != 6) && (cfg.type != 5)) {
/*  97 */         return false;
/*     */       }
/*  99 */       if (!ItemInterface.removeItemByUuid(this.roleId, item.getFirstUuid().longValue(), 1, new TLogArg(LogReason.LIFE_SKILL_LIANYAO_REM, item.getCfgId()))) {
/* 100 */         return false;
/*     */       }
/*     */     }
/* 103 */     int needBuyItem = LianYaoSkillConsts.getInstance().NEED_ITEM_NUM - this.itemKeyList.size();
/* 104 */     int needSilver = needBuyItem * LianYaoSkillConsts.getInstance().NEED_SILVER_PER_GRID;
/* 105 */     if ((needSilver > 0) && 
/* 106 */       (!RoleInterface.cutSilver(this.roleId, needSilver, new TLogArg(LogReason.LIFE_SKILL_LIANYAO_REM)))) {
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     int costVigor = -1;
/* 112 */     if ((doubleOutPutBean != null) && (doubleOutPutBean.isAtHome())) {
/* 113 */       costVigor = lianYaoSkillBag.getCostVigor() - doubleOutPutBean.getNeedCutVigor();
/*     */     } else {
/* 115 */       costVigor = lianYaoSkillBag.getCostVigor();
/*     */     }
/*     */     
/* 118 */     if (costVigor <= 0) {
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (!RoleInterface.cutVigor(this.roleId, costVigor, new TLogArg(LogReason.VIGOR_CUT__LIANYAO))) {
/* 123 */       sendErrMsg(0);
/* 124 */       return false;
/*     */     }
/* 126 */     int itemId = skill.generateItem();
/* 127 */     if (itemId == -1) {
/* 128 */       logger.error("lian yao error skill id : " + skill.skillBag + " skill lv " + skill.level);
/* 129 */       return false;
/*     */     }
/* 131 */     TLogArg addArg = new TLogArg(LogReason.LIFE_SKILL_LIANYAO_ADD, itemId);
/*     */     
/* 133 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, itemId, getItemNum, addArg);
/* 134 */     if (result.isBagFull())
/*     */     {
/* 136 */       SItemCfg sItemCfg = SItemCfg.get(itemId);
/* 137 */       if (sItemCfg == null)
/*     */       {
/* 139 */         sendErrMsg(8);
/* 140 */         return false;
/*     */       }
/*     */       
/* 143 */       ItemType2BagCfg itemType2BagCfg = ItemType2BagCfg.get(sItemCfg.type);
/* 144 */       if (itemType2BagCfg == null)
/*     */       {
/* 146 */         sendErrMsg(1);
/*     */       }
/* 148 */       else if (itemType2BagCfg.bagId == 340600008)
/*     */       {
/* 150 */         sendErrMsg(6);
/*     */       }
/*     */       else
/*     */       {
/* 154 */         sendErrMsg(7);
/*     */       }
/* 156 */       return false;
/*     */     }
/* 158 */     SLianYaoRes res = new SLianYaoRes();
/* 159 */     res.costvigor = costVigor;
/* 160 */     res.itemkey = ((ItemOperateResult.ChangeItemInfo)result.getChangeItemInfoList().get(0)).grid;
/* 161 */     res.itemid = itemId;
/* 162 */     res.itemnum = getItemNum;
/* 163 */     OnlineManager.getInstance().send(this.roleId, res);
/* 164 */     TriggerEventsManger.getInstance().triggerEvent(new LianYaoEvent(), new LifeSkillArg(itemId, LifeSkillManager.getQuality(skill.getId()), getItemNum, this.roleId));
/* 165 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrMsg(int errCode) {
/* 169 */     SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/* 170 */     commonInfo.res = errCode;
/* 171 */     OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\PLianYaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */