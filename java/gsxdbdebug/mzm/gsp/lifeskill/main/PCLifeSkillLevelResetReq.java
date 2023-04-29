/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gang.main.ModBangGongResult;
/*     */ import mzm.gsp.lifeskill.SLifeSkillLevelResetFailed;
/*     */ import mzm.gsp.lifeskill.SLifeSkillLevelResetSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.LifeSkillConsts;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBagCfg;
/*     */ import mzm.gsp.skill.confbean.STLifeSkillBagLevelResetCfg;
/*     */ import mzm.gsp.skill.confbean.STLifeSkillBagLevelResetCfgInfo;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleLifeSkill;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2lifeskill;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCLifeSkillLevelResetReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int skillBagId;
/*     */   private final long returnSilver;
/*     */   private final long returnBanggong;
/*     */   
/*     */   public PCLifeSkillLevelResetReq(long roleId, int skillBagId, long returnSilver, long returnBanggong)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.skillBagId = skillBagId;
/*  43 */     this.returnSilver = returnSilver;
/*  44 */     this.returnBanggong = returnBanggong;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if ((this.returnSilver < 0L) || (this.returnBanggong < 0L))
/*     */     {
/*  55 */       onFailed(-4);
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  62 */     if (!LifeSkillManager.isLifeSkillResetFunOpen(this.roleId))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  69 */     if (RoleInterface.getLevel(this.roleId) < LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_ROLE_LEVEL)
/*     */     {
/*  71 */       onFailed(-5);
/*  72 */       return false;
/*     */     }
/*  74 */     String userid = RoleInterface.getUserId(this.roleId);
/*  75 */     if (userid == null)
/*     */     {
/*  77 */       onFailed(-2);
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  83 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  88 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2101, true, true))
/*     */     {
/*  90 */       return false;
/*     */     }
/*  92 */     RoleLifeSkill xRoleLifeSKill = Role2lifeskill.get(Long.valueOf(this.roleId));
/*  93 */     if (xRoleLifeSKill == null)
/*     */     {
/*  95 */       Map<String, Object> extraInfo = new HashMap();
/*  96 */       extraInfo.put("xRoleLifeSKill", "null");
/*  97 */       onFailed(-4, extraInfo);
/*  98 */       return false;
/*     */     }
/* 100 */     Integer lv = (Integer)xRoleLifeSKill.getLifeskillbagmap().get(Integer.valueOf(this.skillBagId));
/* 101 */     if (lv == null)
/*     */     {
/* 103 */       Map<String, Object> extraInfo = new HashMap();
/* 104 */       extraInfo.put("level", "null");
/* 105 */       onFailed(-4, extraInfo);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 111 */     if (lv.intValue() <= LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_TO)
/*     */     {
/* 113 */       Map<String, Object> extraInfo = new HashMap();
/* 114 */       extraInfo.put("level", lv);
/* 115 */       onFailed(-4, extraInfo);
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 121 */     SLifeSkillBagCfg sLifeSkillBagCfg = SLifeSkillBagCfg.get(this.skillBagId);
/* 122 */     if (sLifeSkillBagCfg == null)
/*     */     {
/* 124 */       Map<String, Object> extraInfo = new HashMap();
/* 125 */       extraInfo.put("sLifeSkillBagCfg", "null");
/* 126 */       onFailed(-3, extraInfo);
/* 127 */       return false;
/*     */     }
/* 129 */     STLifeSkillBagLevelResetCfg sTLifeSkillBagLevelResetCfg = STLifeSkillBagLevelResetCfg.get(sLifeSkillBagCfg.levelUpTypeId);
/* 130 */     if (sTLifeSkillBagLevelResetCfg == null)
/*     */     {
/* 132 */       Map<String, Object> extraInfo = new HashMap();
/* 133 */       extraInfo.put("sTLifeSkillBagLevelResetCfg", "null");
/* 134 */       onFailed(-3, extraInfo);
/* 135 */       return false;
/*     */     }
/* 137 */     STLifeSkillBagLevelResetCfgInfo startResetCfgInfo = (STLifeSkillBagLevelResetCfgInfo)sTLifeSkillBagLevelResetCfg.level2skillResetInfo.get(Integer.valueOf(LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_TO - 1));
/* 138 */     if (startResetCfgInfo == null)
/*     */     {
/* 140 */       if (LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_TO - 1 >= LifeSkillConsts.getInstance().SKILLBAG_ORGINAL_LEVEL)
/*     */       {
/* 142 */         Map<String, Object> extraInfo = new HashMap();
/* 143 */         extraInfo.put("startResetCfgInfo", "null");
/* 144 */         onFailed(-3, extraInfo);
/* 145 */         return false;
/*     */       }
/* 147 */       startResetCfgInfo = new STLifeSkillBagLevelResetCfgInfo();
/* 148 */       startResetCfgInfo.returnSilver = 0;
/* 149 */       startResetCfgInfo.returnBanggong = 0;
/*     */     }
/* 151 */     STLifeSkillBagLevelResetCfgInfo endResetCfgInfo = (STLifeSkillBagLevelResetCfgInfo)sTLifeSkillBagLevelResetCfg.level2skillResetInfo.get(Integer.valueOf(lv.intValue() - 1));
/* 152 */     if (endResetCfgInfo == null)
/*     */     {
/* 154 */       Map<String, Object> extraInfo = new HashMap();
/* 155 */       extraInfo.put("endResetCfgInfo", "null");
/* 156 */       onFailed(-3, extraInfo);
/* 157 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 162 */     double returnSilver = Math.ceil((endResetCfgInfo.returnSilver - startResetCfgInfo.returnSilver) * (LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_RESTORE_RATE / 10000.0D));
/*     */     
/* 164 */     double returnBangGong = Math.ceil((endResetCfgInfo.returnBanggong - startResetCfgInfo.returnBanggong) * (LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_RESTORE_RATE / 10000.0D));
/*     */     
/* 166 */     if ((returnSilver != this.returnSilver) || (returnBangGong != this.returnBanggong))
/*     */     {
/* 168 */       Map<String, Object> extraInfo = new HashMap();
/* 169 */       extraInfo.put("returnSilver_server", Double.valueOf(returnSilver));
/* 170 */       extraInfo.put("returnBangGong_server", Double.valueOf(returnBangGong));
/* 171 */       onFailed(-4, extraInfo);
/* 172 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 177 */     if (this.returnBanggong > 0L)
/*     */     {
/* 179 */       long gangId = GangInterface.getGangId(this.roleId);
/* 180 */       if (gangId <= 0L)
/*     */       {
/* 182 */         Map<String, Object> extraInfo = new HashMap();
/* 183 */         extraInfo.put("gangId", Long.valueOf(gangId));
/* 184 */         onFailed(-8, extraInfo);
/* 185 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 191 */     if ((this.returnSilver > 0L) && (!RoleInterface.addSilverWithinMax(this.roleId, this.returnSilver, new TLogArg(LogReason.LIFE_SKILL_LEVEL_RESET_ADD_SILVER)).isSucceed()))
/*     */     {
/*     */ 
/*     */ 
/* 195 */       onFailed(-6);
/* 196 */       return false;
/*     */     }
/* 198 */     if ((this.returnBanggong > 0L) && (!GangInterface.addBangGongWithinMax(this.roleId, this.returnBanggong, new TLogArg(LogReason.LIFE_SKILL_LEVEL_RESET_ADD_BANGGONG)).isSucceed()))
/*     */     {
/*     */ 
/*     */ 
/* 202 */       onFailed(-7);
/* 203 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 208 */     xRoleLifeSKill.getLifeskillbagmap().put(Integer.valueOf(this.skillBagId), Integer.valueOf(LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_TO));
/*     */     
/* 210 */     SLifeSkillLevelResetSuccess res = new SLifeSkillLevelResetSuccess();
/* 211 */     res.skill_bag_id = this.skillBagId;
/* 212 */     res.after_level = LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_TO;
/* 213 */     res.return_silver = this.returnSilver;
/* 214 */     res.return_banggong = this.returnBanggong;
/* 215 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 220 */     TLogManager.getInstance().addLog(this.roleId, "LifeSkillLevelReset", LifeSkillManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Integer.valueOf(this.skillBagId), Long.valueOf(this.returnSilver), Long.valueOf(this.returnBanggong), lv, Integer.valueOf(LifeSkillConsts.getInstance().LIFESKILL_LEVEL_RESET_TO) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 226 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 231 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 242 */     SLifeSkillLevelResetFailed rsp = new SLifeSkillLevelResetFailed();
/* 243 */     rsp.skill_bag_id = this.skillBagId;
/* 244 */     rsp.ret_code = retcode;
/* 245 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 247 */     StringBuffer logBuilder = new StringBuffer();
/* 248 */     logBuilder.append("[lifeskill]PCLifeSkillLevelResetReq.onFailed@reset failed");
/* 249 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 250 */     logBuilder.append('|').append("skillBagId=").append(this.skillBagId);
/* 251 */     logBuilder.append('|').append("returnSilver_client=").append(this.returnSilver);
/* 252 */     logBuilder.append('|').append("returnBanggong_client=").append(this.returnBanggong);
/* 253 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 255 */     if (extraParams != null)
/*     */     {
/* 257 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 259 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 263 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\PCLifeSkillLevelResetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */