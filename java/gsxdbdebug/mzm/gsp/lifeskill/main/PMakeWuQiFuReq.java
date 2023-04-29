/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.lifeskill.SMakeWuQIFuRes;
/*     */ import mzm.gsp.lifeskill.SSyncCommonInfo;
/*     */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*     */ import mzm.gsp.lifeskill.event.MakeWuQiFuEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBag;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleLifeSkill;
/*     */ import xtable.Role2lifeskill;
/*     */ 
/*     */ public class PMakeWuQiFuReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int skillBagId;
/*     */   private int itemId;
/*     */   
/*     */   public PMakeWuQiFuReq(long roleId, int skillBagId, int itemId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.skillBagId = skillBagId;
/*  33 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!LifeSkillManager.isLifeSkillSwitchOpenForRole(this.roleId))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (ItemInterface.isBagFull(this.roleId, 340600000, true))
/*     */     {
/*  46 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/*  47 */       commonInfo.res = 1;
/*  48 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/*  49 */       return false;
/*     */     }
/*  51 */     RoleLifeSkill xRoleRoleLifeSkill = Role2lifeskill.get(Long.valueOf(this.roleId));
/*  52 */     if (xRoleRoleLifeSkill == null)
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     Integer lv = (Integer)xRoleRoleLifeSkill.getLifeskillbagmap().get(Integer.valueOf(this.skillBagId));
/*  57 */     if (lv == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     Integer skillId = LifeSkillManager.getSkillIdByItemId(this.itemId);
/*  63 */     if (skillId == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!LifeSkillManager.isSkillInBag(this.skillBagId, skillId.intValue()))
/*     */     {
/*  70 */       GameServer.logger().error(String.format("[lifeskill]PMakeWuQiFuReq.processImp@skill not in bag|roleid=%d|skill_bagid=%d|itemid=%d|skillid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.skillBagId), Integer.valueOf(this.itemId), skillId }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillId.intValue());
/*  78 */     if (sLifeSkillBag.openLevel > lv.intValue())
/*     */     {
/*  80 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/*  81 */       commonInfo.res = 5;
/*  82 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     LifeSkillBag lifeSkillBag = new LifeSkillBag(this.skillBagId, sLifeSkillBag.openLevel);
/*  87 */     int needVigor = lifeSkillBag.getCostVigor();
/*  88 */     if (needVigor == -1)
/*     */     {
/*  90 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/*  91 */       commonInfo.res = 5;
/*  92 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/*  93 */       return false;
/*     */     }
/*  95 */     if (!RoleInterface.cutVigor(this.roleId, needVigor, new TLogArg(LogReason.VIGOR_CUT__WUQIFUMO)))
/*     */     {
/*  97 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/*  98 */       commonInfo.res = 0;
/*  99 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/* 100 */       return false;
/*     */     }
/* 102 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, this.itemId, 1, new TLogArg(LogReason.LIFE_SKILL_WUQIFU_ADD, this.itemId));
/*     */     
/* 104 */     if (result.isBagFull())
/*     */     {
/* 106 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/* 107 */       commonInfo.res = 1;
/* 108 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/* 109 */       return false;
/*     */     }
/* 111 */     SMakeWuQIFuRes res = new SMakeWuQIFuRes();
/* 112 */     res.itemid = this.itemId;
/* 113 */     OnlineManager.getInstance().send(this.roleId, res);
/* 114 */     TriggerEventsManger.getInstance().triggerEvent(new MakeWuQiFuEvent(), new LifeSkillArg(this.itemId, 0, 1, this.roleId));
/* 115 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\PMakeWuQiFuReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */