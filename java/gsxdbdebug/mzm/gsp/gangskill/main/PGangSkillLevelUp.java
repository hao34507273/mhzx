/*     */ package mzm.gsp.gangskill.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gangskill.SGangSkillLevelUpRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.GangSkillConst;
/*     */ import mzm.gsp.skill.confbean.SGangSkillBagLevelUpCfg;
/*     */ import mzm.gsp.skill.event.RoleSkillArg;
/*     */ import mzm.gsp.skill.event.RoleSkillLevelUp;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PGangSkillLevelUp extends LogicProcedure
/*     */ {
/*     */   private int skillid;
/*     */   private long roleid;
/*     */   
/*     */   public PGangSkillLevelUp(long roleid, int skillid)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.skillid = skillid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!GangSkillManager.isRoleStateCanOperateGangSkill(this.roleid))
/*     */     {
/*  35 */       String logStr = String.format("[gangskill]PGangSkillLevelUp.processImp@role state can not operate gang skill|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  37 */       GameServer.logger().info(logStr);
/*  38 */       return false;
/*     */     }
/*  40 */     if (!GangSkillManager.isGangSkillSwitchOpenForRole(this.roleid))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (!GangInterface.hasGang(this.roleid))
/*     */     {
/*  46 */       GangSkillManager.sendErrorInfo(this.roleid, 3);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     int skilllevel = GangSkillManager.getSkillLevel(this.roleid, this.skillid);
/*  51 */     if (skilllevel == -1)
/*     */     {
/*  53 */       GangSkillManager.sendErrorInfo(this.roleid, 6);
/*  54 */       return false;
/*     */     }
/*  56 */     if (skilllevel >= GangSkillConst.getInstance().MAX_SKILL_LEVEL)
/*     */     {
/*  58 */       GangSkillManager.sendErrorInfo(this.roleid, 4);
/*  59 */       return false;
/*     */     }
/*  61 */     int level = RoleInterface.getLevel(this.roleid);
/*  62 */     int maxlevel = GangInterface.getGangSkillLevelMaxLimit(this.roleid);
/*  63 */     if (skilllevel >= Math.min(level, maxlevel))
/*     */     {
/*  65 */       GangSkillManager.sendErrorInfo(this.roleid, 7);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     TLogArg logArg = new TLogArg(LogReason.GANG_SKILL_LEVEL_UP);
/*     */     
/*  71 */     SGangSkillBagLevelUpCfg cfg = GangSkillManager.getLevelUpcfgBySkillLevel(this.skillid, skilllevel);
/*  72 */     if (cfg == null)
/*     */     {
/*  74 */       GangSkillManager.sendErrorInfo(this.roleid, 4);
/*  75 */       return false;
/*     */     }
/*  77 */     if (level < cfg.needrolelevel)
/*     */     {
/*  79 */       GangSkillManager.sendErrorInfo(this.roleid, 5);
/*  80 */       return false;
/*     */     }
/*  82 */     if (cfg.needSilver > 0)
/*     */     {
/*  84 */       if (!RoleInterface.cutSilver(this.roleid, cfg.needSilver, logArg))
/*     */       {
/*  86 */         GangSkillManager.sendErrorInfo(this.roleid, 1);
/*  87 */         return false;
/*     */       }
/*     */     }
/*  90 */     if (cfg.needBanggong > 0)
/*     */     {
/*  92 */       if (!GangInterface.cutBangGong(this.roleid, cfg.needBanggong, logArg))
/*     */       {
/*  94 */         GangSkillManager.sendErrorInfo(this.roleid, 2);
/*  95 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  99 */     GangSkillManager.setGangSkillLevel(this.roleid, this.skillid, skilllevel + 1);
/*     */     
/* 101 */     RoleSkillLevelUp roleSkillLevelUp = new RoleSkillLevelUp();
/* 102 */     RoleSkillArg arg = new RoleSkillArg();
/* 103 */     arg.skillType = 2;
/* 104 */     arg.oldLevelMap.put(Integer.valueOf(this.skillid), Integer.valueOf(skilllevel));
/* 105 */     arg.newLevelMap.put(Integer.valueOf(this.skillid), Integer.valueOf(skilllevel + 1));
/* 106 */     arg.roleId = this.roleid;
/* 107 */     arg.skillBagList.add(Integer.valueOf(this.skillid));
/* 108 */     TriggerEventsManger.getInstance().triggerEvent(roleSkillLevelUp, arg);
/*     */     
/* 110 */     SGangSkillLevelUpRes res = new SGangSkillLevelUpRes();
/* 111 */     res.skillinfo.level = (skilllevel + 1);
/* 112 */     res.skillinfo.skillid = this.skillid;
/* 113 */     OnlineManager.getInstance().send(this.roleid, res);
/* 114 */     GangSkillManager.triggerGankSkillChangedEvent(this.roleid);
/* 115 */     GangSkillManager.tlogGangSkillLevelUp(this.roleid, this.skillid, skilllevel, skilllevel + 1);
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\main\PGangSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */