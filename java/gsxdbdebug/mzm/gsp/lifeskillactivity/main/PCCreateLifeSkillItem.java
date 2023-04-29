/*     */ package mzm.gsp.lifeskillactivity.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.activity4.confbean.SCreateAndCostInfo;
/*     */ import mzm.gsp.activity4.confbean.SLifeSkillActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.SYaoDianLevelActivityCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.lifeskill.main.LianYaoSkill;
/*     */ import mzm.gsp.lifeskill.main.LianYaoSkillBag;
/*     */ import mzm.gsp.lifeskillactivity.SCreateLifeSkillItemFailed;
/*     */ import mzm.gsp.lifeskillactivity.SCreateLifeSkillItemSuccess;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.mysteryshop.main.MysteryShopInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangMember;
/*     */ import xbean.RoleLifeSkill;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2gangmember;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCreateLifeSkillItem extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCCreateLifeSkillItem(long roleid, int activityCfgid)
/*     */   {
/*  41 */     this.roleid = roleid;
/*  42 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     SLifeSkillActivityCfg sLifeSkillActivityCfg = SLifeSkillActivityCfg.get(this.activityCfgid);
/*  52 */     if (sLifeSkillActivityCfg == null)
/*     */     {
/*  54 */       onFailed(-3);
/*  55 */       return false;
/*     */     }
/*  57 */     SYaoDianLevelActivityCfg sYaoDianLevelActivityCfg = SYaoDianLevelActivityCfg.get(this.activityCfgid);
/*  58 */     if (sYaoDianLevelActivityCfg == null)
/*     */     {
/*  60 */       onFailed(-3);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  67 */     if (!LifeSkillActivityManager.isFunOpen(this.roleid, sLifeSkillActivityCfg.openId))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  74 */     if (ServerInterface.getCurrentServerLevel() < sLifeSkillActivityCfg.openServerLevel)
/*     */     {
/*  76 */       onFailed(-9);
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  82 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(sLifeSkillActivityCfg.npcCfgId, sLifeSkillActivityCfg.npcServiceCfgId, this.roleid))
/*     */     {
/*  84 */       onFailed(-8);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  90 */     if (!MapInterface.isNearByNPC(this.roleid, sLifeSkillActivityCfg.npcCfgId))
/*     */     {
/*  92 */       onFailed(-7);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     String userid = RoleInterface.getUserId(this.roleid);
/*  97 */     if (userid == null)
/*     */     {
/*  99 */       onFailed(-2);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 105 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 110 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 2011, true, true))
/*     */     {
/* 112 */       return false;
/*     */     }
/* 114 */     int lifeskillLevel = 0;
/* 115 */     RoleLifeSkill xRoleLifeSKill = xtable.Role2lifeskill.get(Long.valueOf(this.roleid));
/* 116 */     if (xRoleLifeSKill != null)
/*     */     {
/* 118 */       Integer lv = (Integer)xRoleLifeSKill.getLifeskillbagmap().get(Integer.valueOf(sLifeSkillActivityCfg.lifeSkillId));
/* 119 */       if (lv != null)
/*     */       {
/* 121 */         lifeskillLevel = lv.intValue();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     if (lifeskillLevel < sLifeSkillActivityCfg.openLifeSkillLevel)
/*     */     {
/* 129 */       onFailed(-13);
/* 130 */       return false;
/*     */     }
/* 132 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleid));
/* 133 */     if (xGangMember == null)
/*     */     {
/* 135 */       onFailed(-10);
/* 136 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 141 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/* 142 */     if ((xGang == null) || (!LifeSkillActivityManager.isInGang(xGang, this.roleid)))
/*     */     {
/* 144 */       onFailed(-10);
/* 145 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 150 */     if (xGang.getVitality() < sLifeSkillActivityCfg.openLivelyLowRate)
/*     */     {
/* 152 */       onFailed(-11);
/* 153 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 158 */     Map.Entry<Integer, SCreateAndCostInfo> entry = sYaoDianLevelActivityCfg.yaodianLevel2CreateAndCostInfo.floorEntry(Integer.valueOf(xGang.getYaodian().getLevel()));
/* 159 */     if (entry == null)
/*     */     {
/* 161 */       onFailed(-12);
/* 162 */       return false;
/*     */     }
/* 164 */     SCreateAndCostInfo sCreateAndCostInfo = (SCreateAndCostInfo)entry.getValue();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 170 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/* 172 */     if (!result.isCanJoin())
/*     */     {
/* 174 */       Map<String, Object> extras = new HashMap();
/* 175 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/* 176 */       onFailed(-5, extras);
/* 177 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */     int count = ActivityInterface.getActivityCount(userid, this.roleid, this.activityCfgid, true);
/* 185 */     if (count >= sCreateAndCostInfo.maxNum)
/*     */     {
/* 187 */       Map<String, Object> extras = new HashMap();
/* 188 */       extras.put("count", Integer.valueOf(count));
/* 189 */       extras.put("maxNum", Integer.valueOf(sCreateAndCostInfo.maxNum));
/* 190 */       onFailed(-6, extras);
/* 191 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 198 */     if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */     {
/* 200 */       onFailed(-4);
/* 201 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 207 */     long leftCurrencyNum = MysteryShopInterface.getLeftCurrencyValue(this.roleid, sCreateAndCostInfo.costType);
/* 208 */     if (sCreateAndCostInfo.costNum > leftCurrencyNum)
/*     */     {
/* 210 */       onFailed(-15);
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     LianYaoSkillBag lianYaoSkillBag = new LianYaoSkillBag(sCreateAndCostInfo.lifeSkillId, lifeskillLevel);
/* 215 */     LianYaoSkill skill = lianYaoSkillBag.randomSkill();
/* 216 */     if (skill == null)
/*     */     {
/* 218 */       onFailed(-3);
/* 219 */       return false;
/*     */     }
/* 221 */     int itemId = skill.generateItem();
/* 222 */     if (itemId <= 0)
/*     */     {
/* 224 */       onFailed(-3);
/* 225 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 230 */     int costVigor = lianYaoSkillBag.getCostVigor();
/* 231 */     if (costVigor <= 0)
/*     */     {
/* 233 */       onFailed(-3);
/* 234 */       return false;
/*     */     }
/* 236 */     if (!RoleInterface.cutVigor(this.roleid, costVigor, new TLogArg(LogReason.VIGOR_CUT__LIFE_SKILL_ACTIVITY)))
/*     */     {
/* 238 */       onFailed(-14);
/* 239 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 244 */     TLogArg logArg = LifeSkillActivityManager.newTLogArg(sCreateAndCostInfo.costType);
/* 245 */     logArg.addItem2num(itemId, 1);
/* 246 */     if (sCreateAndCostInfo.costType == 1)
/*     */     {
/* 248 */       MysteryShopInterface.fillCurrencyData(userid, this.roleid, logArg, sCreateAndCostInfo.costNum);
/*     */     }
/* 250 */     boolean ret = MysteryShopInterface.costCurrencyValue(this.roleid, sCreateAndCostInfo.costNum, sCreateAndCostInfo.costType, logArg);
/*     */     
/* 252 */     if (!ret)
/*     */     {
/* 254 */       onFailed(-15);
/* 255 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 260 */     TLogArg addArg = new TLogArg(LogReason.LIFE_SKILL_ACTIVITY_ADD, itemId);
/* 261 */     ItemOperateResult addResult = ItemInterface.addItem(this.roleid, itemId, 1, addArg);
/* 262 */     if (!addResult.success())
/*     */     {
/* 264 */       onFailed(-4);
/* 265 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 273 */     ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */     
/*     */ 
/* 276 */     ActivityInterface.logActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 278 */     ActivityInterface.tlogActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 281 */     SCreateLifeSkillItemSuccess sCreateLifeSkillItemSuccess = new SCreateLifeSkillItemSuccess();
/* 282 */     sCreateLifeSkillItemSuccess.activity_cfgid = this.activityCfgid;
/* 283 */     sCreateLifeSkillItemSuccess.item_id = itemId;
/* 284 */     sCreateLifeSkillItemSuccess.item_num = 1;
/* 285 */     OnlineManager.getInstance().send(this.roleid, sCreateLifeSkillItemSuccess);
/*     */     
/* 287 */     GameServer.logger().info(String.format("[lifeskillactivity]PCCreateLifeSkillItem.processImp@getReward success|roleid=%d|activity_cfgid=%d|itemId=%d|times=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(itemId), Integer.valueOf(count + 1) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 292 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 297 */     onFailed(retcode, null);
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
/* 308 */     SCreateLifeSkillItemFailed rsp = new SCreateLifeSkillItemFailed();
/* 309 */     rsp.activity_cfgid = this.activityCfgid;
/* 310 */     rsp.retcode = retcode;
/* 311 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 313 */     StringBuffer logBuilder = new StringBuffer();
/* 314 */     logBuilder.append("[lifeskillactivity]PCCreateLifeSkillItem.onFailed@getReward failed");
/* 315 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 316 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 317 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 319 */     if (extraParams != null)
/*     */     {
/* 321 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 323 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 327 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskillactivity\main\PCCreateLifeSkillItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */