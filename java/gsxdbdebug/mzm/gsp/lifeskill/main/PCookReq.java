/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.homeland.main.DoubleOutPutBean;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.lifeskill.SCookRes;
/*     */ import mzm.gsp.lifeskill.SSyncCommonInfo;
/*     */ import mzm.gsp.lifeskill.event.CookEvent;
/*     */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleLifeSkill;
/*     */ import xtable.Role2lifeskill;
/*     */ 
/*     */ public class PCookReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int skillBagId;
/*     */   
/*     */   public PCookReq(long roleId, int skillBagId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.skillBagId = skillBagId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!LifeSkillManager.isLifeSkillSwitchOpenForRole(this.roleId)) {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     int getItemNum = 1;
/*     */     
/*  42 */     DoubleOutPutBean doubleOutPutBean = HomelandInterface.isDoubleCookOutPut(this.roleId);
/*  43 */     if ((doubleOutPutBean != null) && (doubleOutPutBean.isAtHome()) && (doubleOutPutBean.isDoubleOutPut())) {
/*  44 */       getItemNum = 2;
/*     */     }
/*     */     
/*  47 */     if (ItemInterface.isBagFull(this.roleId, 340600000, true)) {
/*  48 */       sendErrMsg(1);
/*  49 */       return false;
/*     */     }
/*  51 */     RoleLifeSkill xRoleLifeSKill = Role2lifeskill.get(Long.valueOf(this.roleId));
/*  52 */     if (xRoleLifeSKill == null) {
/*  53 */       return false;
/*     */     }
/*  55 */     Integer lv = (Integer)xRoleLifeSKill.getLifeskillbagmap().get(Integer.valueOf(this.skillBagId));
/*  56 */     if (lv == null) {
/*  57 */       return false;
/*     */     }
/*  59 */     LianYaoSkillBag lianYaoSkillBag = new LianYaoSkillBag(this.skillBagId, lv.intValue());
/*  60 */     LianYaoSkill skill = lianYaoSkillBag.randomSkill();
/*  61 */     if (skill == null) {
/*  62 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/*  63 */       commonInfo.res = 5;
/*  64 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     int costVigor = -1;
/*  69 */     if ((doubleOutPutBean != null) && (doubleOutPutBean.isAtHome())) {
/*  70 */       costVigor = lianYaoSkillBag.getCostVigor() - doubleOutPutBean.getNeedCutVigor();
/*     */     } else {
/*  72 */       costVigor = lianYaoSkillBag.getCostVigor();
/*     */     }
/*     */     
/*  75 */     if (costVigor <= 0) {
/*  76 */       return false;
/*     */     }
/*  78 */     if (!RoleInterface.cutVigor(this.roleId, costVigor, new TLogArg(LogReason.VIGOR_CUT__COOK))) {
/*  79 */       sendErrMsg(0);
/*  80 */       return false;
/*     */     }
/*  82 */     int itemId = skill.generateItem();
/*  83 */     if (itemId == -1) {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, itemId, getItemNum, new TLogArg(LogReason.LIFE_SKILL_COOK_ADD, itemId));
/*  88 */     if (result.isBagFull()) {
/*  89 */       sendErrMsg(1);
/*  90 */       return false;
/*     */     }
/*  92 */     SCookRes res = new SCookRes();
/*  93 */     res.costvigor = costVigor;
/*  94 */     res.itemid = itemId;
/*  95 */     res.itemnum = getItemNum;
/*  96 */     OnlineManager.getInstance().send(this.roleId, res);
/*  97 */     TriggerEventsManger.getInstance().triggerEvent(new CookEvent(), new LifeSkillArg(itemId, LifeSkillManager.getQuality(skill.getId()), getItemNum, this.roleId));
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrMsg(int errCode) {
/* 102 */     SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/* 103 */     commonInfo.res = errCode;
/* 104 */     OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\PCookReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */