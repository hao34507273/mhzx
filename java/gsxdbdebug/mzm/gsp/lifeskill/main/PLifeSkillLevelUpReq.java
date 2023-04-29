/*    */ package mzm.gsp.lifeskill.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.lifeskill.SLifeSkillLevelUpRes;
/*    */ import mzm.gsp.lifeskill.SSyncCommonInfo;
/*    */ import mzm.gsp.lifeskill.event.LifeSkillLevelUpArg;
/*    */ import mzm.gsp.lifeskill.event.LifeSkillLevelUpEvent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.skill.confbean.LifeSkillConsts;
/*    */ import mzm.gsp.skill.main.SkillLogType;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleLifeSkill;
/*    */ 
/*    */ public class PLifeSkillLevelUpReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int skillBagId;
/*    */   
/*    */   public PLifeSkillLevelUpReq(long roleId, int skillBagId)
/*    */   {
/* 29 */     this.roleId = roleId;
/* 30 */     this.skillBagId = skillBagId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     if (!LifeSkillManager.isLifeSkillSwitchOpenForRole(this.roleId)) {
/* 37 */       return false;
/*    */     }
/* 39 */     RoleLifeSkill xRoleLifeSKill = xtable.Role2lifeskill.get(Long.valueOf(this.roleId));
/* 40 */     if (xRoleLifeSKill == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     Integer lv = (Integer)xRoleLifeSKill.getLifeskillbagmap().get(Integer.valueOf(this.skillBagId));
/* 44 */     if (lv == null) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     int maxLv = Math.min(LifeSkillConsts.getInstance().SKILLBAG_MAX_LEVEL, RoleInterface.getLevel(this.roleId) + LifeSkillConsts.getInstance().SKILLBAG_MORE_THAN_ROLE_LEVEL);
/* 49 */     if (lv.intValue() >= maxLv) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     LifeSkillBag lifeSkillBag = new LifeSkillBag(this.skillBagId, lv.intValue());
/* 54 */     Integer needSilver = lifeSkillBag.getLeveluNeedSilver();
/* 55 */     Integer needBangGong = lifeSkillBag.getLevelUpNeedBangGong();
/* 56 */     if ((needSilver == null) || (needBangGong == null)) {
/* 57 */       if (GameServer.logger().isDebugEnabled()) {
/* 58 */         GameServer.logger().debug("PLifeSkillLevelUpReq.processImp@fail! 生活技能升级所需要的数据信息错误！");
/*    */       }
/* 60 */       return false;
/*    */     }
/* 62 */     if (!RoleInterface.cutSilver(this.roleId, needSilver.intValue(), new TLogArg(LogReason.LIFE_SKILL_LEVEL_UP_REM))) {
/* 63 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/* 64 */       commonInfo.res = 2;
/* 65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/* 66 */       return false;
/*    */     }
/* 68 */     if (!GangInterface.cutBangGong(this.roleId, needBangGong.intValue(), new TLogArg(LogReason.GANG_LIFE_SKILL_LEVELUP_REM))) {
/* 69 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/* 70 */       commonInfo.res = 3;
/* 71 */       OnlineManager.getInstance().sendAtOnce(this.roleId, commonInfo);
/* 72 */       return false;
/*    */     }
/* 74 */     xRoleLifeSKill.getLifeskillbagmap().put(Integer.valueOf(this.skillBagId), Integer.valueOf(lv.intValue() + 1));
/* 75 */     SLifeSkillLevelUpRes res = new SLifeSkillLevelUpRes();
/* 76 */     res.skillbagid = this.skillBagId;
/* 77 */     res.level = ((Integer)xRoleLifeSKill.getLifeskillbagmap().get(Integer.valueOf(this.skillBagId))).intValue();
/* 78 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 80 */     int skillType = lifeSkillBag.getSkillBagType();
/* 81 */     lifeSkillBag.setLevel(lv.intValue() + 1);
/*    */     
/* 83 */     LifeSkillLevelUpArg arg = new LifeSkillLevelUpArg(this.roleId, this.skillBagId, lv.intValue(), lv.intValue() + 1, skillType, lifeSkillBag.getAllAvaliableItemCount());
/* 84 */     TriggerEventsManger.getInstance().triggerEvent(new LifeSkillLevelUpEvent(), arg);
/*    */     
/* 86 */     TLogManager.getInstance().addLog(this.roleId, "SkillLevelUp", LifeSkillManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Integer.valueOf(this.skillBagId), SkillLogType.LIFE_SKILL, lv, Integer.valueOf(lv.intValue() + 1) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\PLifeSkillLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */