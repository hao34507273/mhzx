/*      */ package mzm.gsp.role.main;
/*      */ 
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.aircraft.main.AircraftInterface;
/*      */ import mzm.gsp.aircraft.main.AircraftInterface.RideAircraftObj;
/*      */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*      */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface.ChangeModelCardLevelEntry;
/*      */ import mzm.gsp.fabao.main.FabaoInterface;
/*      */ import mzm.gsp.fabaolingqi.main.FabaoArtifactInterface;
/*      */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.item.main.EquipmentItem;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.mall.main.MallInterface;
/*      */ import mzm.gsp.map.main.scene.Position;
/*      */ import mzm.gsp.mounts.main.MountsInterface;
/*      */ import mzm.gsp.mounts.main.MountsInterface.RideMountsObj;
/*      */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*      */ import mzm.gsp.occupation.confbean.SRoleLevelFlyCfg;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.SCommonResultRes;
/*      */ import mzm.gsp.role.SSyncExpConvertXiuLian;
/*      */ import mzm.gsp.role.SSyncMoneyChange;
/*      */ import mzm.gsp.role.SSyncRoleAddExp;
/*      */ import mzm.gsp.role.changemodel.RoleChangeInterface;
/*      */ import mzm.gsp.role.event.RoleAddPointArg;
/*      */ import mzm.gsp.role.event.RoleAddPointEvent;
/*      */ import mzm.gsp.role.event.RoleLevelUp;
/*      */ import mzm.gsp.role.event.RoleLevelUpArg;
/*      */ import mzm.gsp.role.result.CutRoleExpResult;
/*      */ import mzm.gsp.role.result.CutRoleExpResult.Reason;
/*      */ import mzm.gsp.role.result.ReleaseStorageExpResult;
/*      */ import mzm.gsp.role.result.ReleaseStorageExpResult.Reason;
/*      */ import mzm.gsp.roledye.ColorIds;
/*      */ import mzm.gsp.roledye.main.RoleDyeInterface;
/*      */ import mzm.gsp.server.main.ServerInterface;
/*      */ import mzm.gsp.superequipment.wushi.main.WuShiInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogManager;
/*      */ import mzm.gsp.wing.main2.WingInterface;
/*      */ import mzm.gsp.wing.main2.WingInterface.WingExteriorInfo;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.BasicPropertiesSystem;
/*      */ import xbean.Location;
/*      */ import xbean.Properties;
/*      */ import xbean.TransferOccupationPropertiesSys;
/*      */ import xdb.Procedure;
/*      */ import xtable.Role2properties;
/*      */ 
/*      */ public class Role
/*      */ {
/*      */   public static int shuxing;
/*      */   public static final int BASE_RATE = 10000;
/*      */   public static final String TLOG_NAME = "PlayerExpFlow";
/*      */   protected final long roleId;
/*      */   protected final Properties xProperties;
/*      */   protected final xbean.Basic xBasic;
/*      */   private boolean isRetainRoleLock;
/*      */   
/*      */   Role(long roleId, boolean isRetainRoleLock)
/*      */   {
/*   77 */     this.roleId = roleId;
/*   78 */     this.isRetainRoleLock = isRetainRoleLock;
/*   79 */     if (isRetainRoleLock) {
/*   80 */       this.xProperties = Role2properties.get(Long.valueOf(roleId));
/*   81 */       this.xBasic = xtable.Basic.get(Long.valueOf(roleId));
/*      */     } else {
/*   83 */       this.xProperties = Role2properties.select(Long.valueOf(roleId));
/*   84 */       this.xBasic = xtable.Basic.select(Long.valueOf(roleId));
/*      */     }
/*      */   }
/*      */   
/*      */   public long getId()
/*      */   {
/*   90 */     return this.roleId;
/*      */   }
/*      */   
/*      */   public String getUserId() {
/*   94 */     return this.xBasic.getUser_id();
/*      */   }
/*      */   
/*      */   public int getVelocity() {
/*   98 */     Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*   99 */     return (int)occupation.getMoveSpeed();
/*      */   }
/*      */   
/*      */   public int getModelId() {
/*  103 */     Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  104 */     return occupation.getModelId();
/*      */   }
/*      */   
/*      */   public long getSilver() {
/*  108 */     return this.xProperties.getSilver();
/*      */   }
/*      */   
/*      */   public long getGold() {
/*  112 */     return this.xProperties.getGold();
/*      */   }
/*      */   
/*      */   public long getGoldIngot() {
/*  116 */     return this.xProperties.getGoldingot();
/*      */   }
/*      */   
/*      */   private void addPotentialPointForOneSys(BasicPropertiesSystem xBPSys, boolean activity, int fromLevel, int toLevel) {
/*  120 */     Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  121 */     boolean isAutoSpecial = xBPSys.getIsautospecialpoint();
/*  122 */     Map xBasicPropertyMap = xBPSys.getBasicpropertymap();
/*  123 */     int potentialPoint = xBPSys.getPotentialpoint();
/*  124 */     int[] basicArray = { 29, 26, 25, 28, 27 };
/*      */     int[] arr$;
/*  126 */     int i$; for (int curLevel = fromLevel + 1; curLevel <= toLevel; curLevel++)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  131 */       if ((curLevel < OccupationManager.getInstance().getOpenResetFuncLevel()) && (activity)) {
/*  132 */         arr$ = basicArray;
/*  133 */         int len$ = basicArray.length;
/*      */         
/*  135 */         for (i$ = 0; i$ < len$;) {
/*  136 */           int propType = arr$[i$];
/*  137 */           Integer oldValue = (Integer)xBasicPropertyMap.get(Integer.valueOf(propType));
/*  138 */           if (oldValue == null) {
/*  139 */             oldValue = Integer.valueOf(0);
/*      */           }
/*      */           
/*  142 */           int addValue = occupation.getPortentialAddPoint(propType, curLevel);
/*  143 */           xBasicPropertyMap.put(Integer.valueOf(propType), Integer.valueOf(oldValue.intValue() + addValue));i$++; continue;
/*      */           
/*      */ 
/*      */ 
/*  147 */           int[] arr$ = basicArray;
/*  148 */           int len$ = basicArray.length;
/*      */           
/*  150 */           for (int i$ = 0; i$ < len$; i$++) {
/*  151 */             int propType = arr$[i$];
/*  152 */             int addValue = occupation.getPortentialAddPoint(propType, curLevel);
/*  153 */             potentialPoint += addValue;
/*      */           }
/*  155 */           if (curLevel < RoleCommonConstants.getInstance().ZHUAN_SHENG_OLD_LEVEL) {
/*  156 */             potentialPoint += 0;
/*  157 */           } else if (curLevel > RoleCommonConstants.getInstance().ZHUAN_SHENG_OLD_LEVEL) {
/*  158 */             potentialPoint -= 5;
/*  159 */             Procedure.execute(new PMGM_setfightvalue(this.roleId, RoleCommonConstants.getInstance().ZHUAN_SHENG_NEW_LEVEL));
/*      */           } else {
/*  161 */             potentialPoint += RoleCommonConstants.getInstance().ZHUAN_SHENG_AWARD_POINT;
/*  162 */             Procedure.execute(new PMGM_setfightvalue(this.roleId, RoleCommonConstants.getInstance().ZHUAN_SHENG_NEW_LEVEL));
/*      */           }
/*      */         }
/*      */       } }
/*  166 */     xBPSys.setPotentialpoint(potentialPoint);
/*  167 */     if (isAutoSpecial)
/*  168 */       autoSpecialPoint(xBPSys);
/*      */   }
/*      */   
/*      */   boolean autoSpecialPoint(BasicPropertiesSystem xBPSys) {
/*  172 */     Map xAutoAssignPointPref = xBPSys.getAutoassignpointpref();
/*  173 */     Map realAssignPref = xAutoAssignPointPref;
/*  174 */     Map xBasicPropertyMap = xBPSys.getBasicpropertymap();
/*  175 */     int potentialPoint = xBPSys.getPotentialpoint();
/*  176 */     boolean canDevideBy2 = true;
/*  177 */     int totalAssignPref = 0;
/*  178 */     Iterator i$ = xAutoAssignPointPref.entrySet().iterator();
/*      */     
/*      */ 
/*      */ 
/*  182 */     while (i$.hasNext()) {
/*  183 */       Map.Entry propEntry = (Map.Entry)i$.next();
/*  184 */       int assignPref = ((Integer)propEntry.getValue()).intValue();
/*  185 */       totalAssignPref += assignPref;
/*  186 */       if (assignPref % 2 != 0) {
/*  187 */         canDevideBy2 = false;
/*      */       }
/*      */     }
/*      */     
/*  191 */     if (totalAssignPref <= 0) {
/*  192 */       return false;
/*      */     }
/*  194 */     if (canDevideBy2) {
/*  195 */       totalAssignPref /= 2;
/*  196 */       realAssignPref = new HashMap();
/*  197 */       i$ = xAutoAssignPointPref.entrySet().iterator();
/*      */       
/*  199 */       while (i$.hasNext()) {
/*  200 */         Map.Entry propEntry = (Map.Entry)i$.next();
/*  201 */         realAssignPref.put(propEntry.getKey(), Integer.valueOf(((Integer)propEntry.getValue()).intValue() / 2));
/*      */       }
/*      */     }
/*      */     
/*  205 */     while (potentialPoint >= totalAssignPref) { Map.Entry propEntry;
/*      */       int assignPref;
/*  207 */       Integer oldPropValue; for (i$ = realAssignPref.entrySet().iterator(); i$.hasNext(); xBasicPropertyMap.put(propEntry.getKey(), Integer.valueOf(oldPropValue.intValue() + assignPref))) {
/*  208 */         propEntry = (Map.Entry)i$.next();
/*  209 */         assignPref = ((Integer)propEntry.getValue()).intValue();
/*  210 */         oldPropValue = (Integer)xBasicPropertyMap.get(propEntry.getKey());
/*  211 */         if (oldPropValue == null) {
/*  212 */           oldPropValue = Integer.valueOf(0);
/*      */         }
/*      */       }
/*      */       
/*  216 */       potentialPoint -= totalAssignPref;
/*      */     }
/*      */     
/*  219 */     xBPSys.setPotentialpoint(potentialPoint);
/*  220 */     TriggerEventsManger.getInstance().triggerEvent(new RoleAddPointEvent(), new RoleAddPointArg(this.roleId, true));
/*  221 */     return true;
/*      */   }
/*      */   
/*      */   void addPortentialPoint(int fromLevel, int toLevel) {
/*  225 */     Map xBPSysMap = this.xProperties.getPropertysysmap();
/*  226 */     Iterator i$ = xBPSysMap.entrySet().iterator();
/*      */     
/*  228 */     while (i$.hasNext()) {
/*  229 */       Map.Entry entry = (Map.Entry)i$.next();
/*  230 */       addPotentialPointForOneSys((BasicPropertiesSystem)entry.getValue(), ((Integer)entry.getKey()).intValue() == this.xProperties.getActivitybpsys(), fromLevel, toLevel);
/*      */     }
/*      */     
/*  233 */     Map xTransferOccupationPropertiesMap = this.xProperties.getTransfer_occupation_property_sys_map();
/*  234 */     i$ = xTransferOccupationPropertiesMap.entrySet().iterator();
/*      */     
/*  236 */     while (i$.hasNext()) {
/*  237 */       Map.Entry entry1 = (Map.Entry)i$.next();
/*  238 */       TransferOccupationPropertiesSys xTransferOccupationPropertiesSys = (TransferOccupationPropertiesSys)entry1.getValue();
/*  239 */       int activityBpSys = xTransferOccupationPropertiesSys.getActivity_bp_sys();
/*  240 */       Map xBasicPropertiesSystemMap = xTransferOccupationPropertiesSys.getProperty_sys_map();
/*  241 */       Iterator i$1 = xBasicPropertiesSystemMap.entrySet().iterator();
/*      */       
/*  243 */       while (i$1.hasNext()) {
/*  244 */         Map.Entry basicEntry = (Map.Entry)i$1.next();
/*  245 */         addPotentialPointForOneSys((BasicPropertiesSystem)basicEntry.getValue(), ((Integer)basicEntry.getKey()).intValue() == activityBpSys, fromLevel, toLevel);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean addExp(int exp, TLogArg logArg, boolean needExchange) {
/*  251 */     if (exp <= 0) {
/*  252 */       return false;
/*      */     }
/*  254 */     int orgExpValue = this.xProperties.getExp();
/*  255 */     int orgLevel = this.xProperties.getLevel();
/*  256 */     RoleAddExp roleAddExp = new RoleAddExp(this.roleId, OccupationManager.getOccupationById(getOccupationId(), getGender()), this.xProperties, exp);
/*  257 */     if (logArg.logReason.equals(LogReason.ROLE_GM_EXP_ADD_RELEASE)) {
/*  258 */       roleAddExp.setDebug_can_fly(true);
/*      */     }
/*      */     
/*  261 */     roleAddExp.calAddExpValue();
/*  262 */     if (!roleAddExp.isSuc()) {
/*  263 */       return false;
/*      */     }
/*  265 */     this.xProperties.setExp(roleAddExp.getExpShowValue());
/*  266 */     if (roleAddExp.levelChange()) {
/*  267 */       setLevel(roleAddExp.getFinalLevel(), exp, logArg);
/*      */     }
/*      */     
/*  270 */     convertXiuExp(logArg, needExchange, roleAddExp.getNeedConvertXiuExp(), roleAddExp.isBeginConvertXiuExp());
/*  271 */     OnlineManager.getInstance().send(this.roleId, new SSyncRoleAddExp(exp));
/*  272 */     RoleLogManager.logRoleExpAdd(this.roleId, roleAddExp.getOrglevel(), roleAddExp.getFinalLevel(), roleAddExp.getRealAddExp(), logArg, roleAddExp.getExpShowValue());
/*  273 */     int releasedExp = roleAddExp.getReleasedExp();
/*  274 */     if (releasedExp > 0) {
/*  275 */       tlogExpRelease(getUserId(), this.roleId, orgExpValue, orgLevel, this.xProperties.getExp(), this.xProperties.getLevel(), releasedExp, logArg);
/*      */     }
/*      */     
/*  278 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private void convertXiuExp(TLogArg logArg, boolean needExchange, int convertValue, boolean fristTime)
/*      */   {
/*  284 */     if ((convertValue > 0) && (needExchange)) {
/*  285 */       convertXiuLianExp(convertValue, logArg);
/*  286 */       if (fristTime) {
/*  287 */         SCommonResultRes sCommonResultRes = new SCommonResultRes();
/*  288 */         sCommonResultRes.result = 6;
/*  289 */         OnlineManager.getInstance().send(this.roleId, sCommonResultRes);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   ReleaseStorageExpResult releaseStorageExp(String userId, TLogArg logArg)
/*      */   {
/*  296 */     ReleaseStorageExpResult res = new ReleaseStorageExpResult();
/*  297 */     int orgExpValue = this.xProperties.getExp();
/*  298 */     int orgLevel = this.xProperties.getLevel();
/*  299 */     SRoleLevelFlyCfg cfg = SRoleLevelFlyCfg.get(orgLevel);
/*  300 */     if (cfg == null) {
/*  301 */       GameServer.logger().error(String.format("[role]Role.releaseStorageExp@ current level is not fly level point!|roleId=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(orgLevel) }));
/*  302 */       res.fillErrResult(ReleaseStorageExpResult.Reason.NOT_FLY_POINT);
/*  303 */       return res; }
/*  304 */     if ((cfg.releaseOpenId > 0) && (OpenInterface.getOpenStatus(cfg.releaseOpenId))) {
/*  305 */       int serverLevel = ServerInterface.getCurrentServerLevel();
/*  306 */       if (orgLevel >= serverLevel) {
/*  307 */         GameServer.logger().error(String.format("[role]Role.releaseStorageExp@ orgLevel is bigger than serverLevel!|roleId=%d|level=%d|serverLevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(orgLevel), Integer.valueOf(serverLevel) }));
/*  308 */         res.fillErrResult(ReleaseStorageExpResult.Reason.ROLE_LV_TOO_HIGH);
/*  309 */         return res;
/*      */       }
/*  311 */       Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  312 */       int totalLvExpMax = occupation.getToNextLevelNeedExp(orgLevel);
/*  313 */       int needReleaseExp = orgExpValue - totalLvExpMax;
/*  314 */       int convert2exp = 0;
/*  315 */       int convert2xiu = 0;
/*  316 */       if (orgExpValue > totalLvExpMax) {
/*  317 */         RoleAddExp roleAddExp = new RoleAddExp(this.roleId, occupation, totalLvExpMax, orgLevel, needReleaseExp);
/*  318 */         if (logArg.logReason.equals(LogReason.ROLE_GM_EXP_RELEASE)) {
/*  319 */           roleAddExp.setDebug_can_fly(true);
/*      */         }
/*      */         
/*  322 */         roleAddExp.setCalRelease(true);
/*  323 */         roleAddExp.calAddExpValue();
/*  324 */         if (!roleAddExp.isSuc()) {
/*  325 */           res.fillErrResult(ReleaseStorageExpResult.Reason.CAL_EXP_ERR);
/*  326 */           return res;
/*      */         }
/*      */         
/*  329 */         this.xProperties.setExp(roleAddExp.getExpShowValue());
/*  330 */         if (roleAddExp.levelChange()) {
/*  331 */           setLevel(roleAddExp.getFinalLevel(), needReleaseExp, logArg);
/*      */         }
/*      */         
/*  334 */         convertXiuExp(logArg, true, roleAddExp.getNeedConvertXiuExp(), roleAddExp.isBeginConvertXiuExp());
/*  335 */         convert2exp = roleAddExp.getRealAddExp();
/*  336 */         convert2xiu = roleAddExp.getNeedConvertXiuExp();
/*      */       } else {
/*  338 */         GameServer.logger().info(String.format("[role]Role.releaseStorageExp@ current exp is not to level max!|roleId=%d|level=%d|totalLvExpMax=%d|orgExpValue=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(orgLevel), Integer.valueOf(totalLvExpMax), Integer.valueOf(orgExpValue) }));
/*      */       }
/*      */       
/*  341 */       tlogExpRelease(userId, this.roleId, orgExpValue, orgLevel, this.xProperties.getExp(), this.xProperties.getLevel(), orgExpValue <= totalLvExpMax ? 0 : needReleaseExp, logArg);
/*  342 */       res.fillSucResult(orgLevel, this.xProperties.getLevel(), needReleaseExp, convert2exp, convert2xiu);
/*  343 */       return res;
/*      */     }
/*      */     
/*  346 */     GameServer.logger().error(String.format("[role]Role.releaseStorageExp@ open forbid!|roleId=%d|level=%d|openId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(orgLevel), Integer.valueOf(cfg.releaseOpenId) }));
/*  347 */     res.fillErrResult(ReleaseStorageExpResult.Reason.OPEN_FORBID);
/*  348 */     return res;
/*      */   }
/*      */   
/*      */   static void tlogExpRelease(String userId, long roleId, int orgExpValue, long orgLevel, int curExpValue, int curLevel, int needReleaseExp, TLogArg arg)
/*      */   {
/*  353 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  354 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(curLevel), Integer.valueOf(orgExpValue), Long.valueOf(orgLevel), Integer.valueOf(curExpValue), Integer.valueOf(curLevel), Integer.valueOf(needReleaseExp < 0 ? 0 : needReleaseExp), Integer.valueOf(arg.logReason.value), Integer.valueOf(arg.subReason) };
/*  355 */     TLogManager.getInstance().addLog(roleId, "RoleExpRelease", colums);
/*      */   }
/*      */   
/*      */   CutRoleExpResult cutRoleExp(int cutValue, TLogArg logArg) {
/*  359 */     int orgLevel = this.xProperties.getLevel();
/*  360 */     int orgShowValue = this.xProperties.getExp();
/*  361 */     CutRoleExpResult res = new CutRoleExpResult();
/*  362 */     if (cutValue <= 0) {
/*  363 */       res.setCutSuc(false);
/*  364 */       res.setReason(CutRoleExpResult.Reason.PARAMETER_ILLEGAL);
/*  365 */       return res;
/*      */     }
/*  367 */     int orgValue = this.xProperties.getExp();
/*  368 */     if (orgValue < cutValue) {
/*  369 */       res.setCutSuc(false);
/*  370 */       res.setReason(CutRoleExpResult.Reason.PARAMETER_OVERFLOW);
/*  371 */       return res;
/*      */     }
/*  373 */     this.xProperties.setExp(orgValue - cutValue);
/*  374 */     RoleLogManager.tLogRoleExpCut(this.roleId, orgLevel, orgShowValue, this.xProperties.getLevel(), this.xProperties.getExp(), cutValue, logArg);
/*  375 */     res.setCutSuc(true);
/*  376 */     return res;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   @Deprecated
/*      */   private boolean addExpOld(int exp, TLogArg logArg, boolean needExchange)
/*      */   {
/*  384 */     if (exp <= 0) {
/*  385 */       return false;
/*      */     }
/*  387 */     Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  388 */     int level = this.xProperties.getLevel();
/*  389 */     int maxLevel = occupation.getMaxLevel();
/*  390 */     maxLevel = Math.min(maxLevel, ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL);
/*  391 */     int needExp = occupation.getToNextLevelNeedExp(level);
/*      */     
/*  393 */     if (level >= maxLevel) {
/*  394 */       int totalExp = this.xProperties.getExp() + exp;
/*  395 */       if (totalExp > 0) {
/*  396 */         if (needExchange) {
/*  397 */           convertXiuLianExp(totalExp, logArg);
/*      */         }
/*      */         
/*  400 */         totalExp = 0;
/*      */       }
/*      */       
/*  403 */       if (this.xProperties.getExp() != totalExp) {
/*  404 */         this.xProperties.setExp(totalExp);
/*      */       }
/*      */       
/*  407 */       return false;
/*      */     }
/*  409 */     int remainExp = exp + this.xProperties.getExp();
/*  410 */     int tmpLevel = level;
/*  411 */     int realAddExp = exp;
/*      */     int totalExp;
/*      */     do {
/*  414 */       totalExp = remainExp;
/*  415 */       remainExp -= needExp;
/*  416 */       needExp = occupation.getToNextLevelNeedExp(tmpLevel);
/*  417 */       if (tmpLevel == maxLevel) {
/*  418 */         SCommonResultRes sCommonResultRes = new SCommonResultRes();
/*  419 */         sCommonResultRes.result = 6;
/*  420 */         OnlineManager.getInstance().send(this.roleId, sCommonResultRes);
/*  421 */         if (totalExp <= 0) break;
/*  422 */         realAddExp = exp - totalExp;
/*  423 */         if (needExchange) {
/*  424 */           convertXiuLianExp(totalExp, logArg);
/*      */         }
/*      */         
/*  427 */         totalExp = 0; break;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  432 */       tmpLevel++;
/*  433 */     } while (remainExp >= 0);
/*      */     
/*  435 */     this.xProperties.setExp(totalExp);
/*  436 */     if (tmpLevel != level) {
/*  437 */       setLevel(tmpLevel, exp, logArg);
/*      */     }
/*      */     
/*  440 */     SSyncRoleAddExp sSyncRoleAddExp = new SSyncRoleAddExp();
/*  441 */     sSyncRoleAddExp.addexp = exp;
/*  442 */     OnlineManager.getInstance().send(this.roleId, sSyncRoleAddExp);
/*  443 */     RoleLogManager.logRoleExpAdd(this.roleId, level, tmpLevel, realAddExp, logArg, 0);
/*  444 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public RoleExpUpdateRet addExpForIdip(int exp, TLogArg logArg)
/*      */   {
/*  450 */     return RoleExpUpdateRet.EXP_NUM_SIGN_ERROR;
/*      */   }
/*      */   
/*      */   public RoleExpUpdateRet addExpForIdipOld(int exp, TLogArg logArg) {
/*  454 */     if (exp <= 0) {
/*  455 */       return RoleExpUpdateRet.EXP_NUM_SIGN_ERROR;
/*      */     }
/*  457 */     Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  458 */     int level = this.xProperties.getLevel();
/*  459 */     int maxLevel = occupation.getMaxLevel();
/*  460 */     maxLevel = Math.min(maxLevel, ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL);
/*  461 */     int needExp = occupation.getToNextLevelNeedExp(level);
/*      */     
/*  463 */     if (level >= maxLevel) {
/*  464 */       int totalExp = this.xProperties.getExp() + exp;
/*  465 */       if (totalExp > 0) {
/*  466 */         convertXiuLianExp(totalExp, logArg);
/*  467 */         totalExp = 0;
/*      */       }
/*      */       
/*  470 */       if (this.xProperties.getExp() != totalExp) {
/*  471 */         this.xProperties.setExp(totalExp);
/*      */       }
/*      */       
/*  474 */       return RoleExpUpdateRet.ROLE_LEVEL_HAS_REACH_TOP_LIMIT_ERROR;
/*      */     }
/*  476 */     int remainExp = exp + this.xProperties.getExp();
/*  477 */     int tmpLevel = level;
/*      */     int totalExp;
/*      */     do {
/*  480 */       totalExp = remainExp;
/*  481 */       remainExp -= needExp;
/*  482 */       needExp = occupation.getToNextLevelNeedExp(tmpLevel);
/*  483 */       if (tmpLevel == maxLevel) {
/*  484 */         SCommonResultRes sCommonResultRes = new SCommonResultRes();
/*  485 */         sCommonResultRes.result = 6;
/*  486 */         OnlineManager.getInstance().send(this.roleId, sCommonResultRes);
/*  487 */         if (totalExp <= 0) break;
/*  488 */         convertXiuLianExp(totalExp, logArg);
/*  489 */         totalExp = 0; break;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  494 */       tmpLevel++;
/*  495 */     } while (remainExp >= 0);
/*      */     
/*  497 */     this.xProperties.setExp(totalExp);
/*  498 */     if (tmpLevel != level) {
/*  499 */       setLevel(tmpLevel, exp, logArg);
/*      */     }
/*      */     
/*  502 */     SSyncRoleAddExp sSyncRoleAddExp = new SSyncRoleAddExp();
/*  503 */     sSyncRoleAddExp.addexp = exp;
/*  504 */     OnlineManager.getInstance().send(this.roleId, sSyncRoleAddExp);
/*  505 */     return RoleExpUpdateRet.SUCCESS;
/*      */   }
/*      */   
/*      */ 
/*      */   public RoleExpUpdateRet addExpForAqIdip(int exp, TLogArg logArg)
/*      */   {
/*  511 */     return addExpForIdip(exp, logArg);
/*      */   }
/*      */   
/*      */   public RoleExpUpdateRet cutExpForIdip(int exp, TLogArg logArg) {
/*  515 */     if (exp <= 0)
/*  516 */       return RoleExpUpdateRet.EXP_NUM_SIGN_ERROR;
/*  517 */     if (this.xProperties.getExp() >= exp) {
/*  518 */       this.xProperties.setExp(this.xProperties.getExp() - exp);
/*  519 */       return RoleExpUpdateRet.SUCCESS;
/*      */     }
/*  521 */     return RoleExpUpdateRet.EXP_NUM_CUT_NOT_ENOUGH_ERROR;
/*      */   }
/*      */   
/*      */   public RoleExpUpdateRet cutExpForAqIdip(int exp, TLogArg logArg)
/*      */   {
/*  526 */     if (exp <= 0)
/*  527 */       return RoleExpUpdateRet.EXP_NUM_SIGN_ERROR;
/*  528 */     if (this.xProperties.getExp() >= exp) {
/*  529 */       this.xProperties.setExp(this.xProperties.getExp() - exp);
/*  530 */       return RoleExpUpdateRet.SUCCESS;
/*      */     }
/*  532 */     this.xProperties.setExp(0);
/*  533 */     return RoleExpUpdateRet.EXP_NUM_CLEAR_AQIDIP_ERROR;
/*      */   }
/*      */   
/*      */   boolean convertXiuLianExp(int roleExp, TLogArg logArg)
/*      */   {
/*  538 */     dayUpdate();
/*  539 */     int addXiuLianHistory = this.xProperties.getConvertxiulianexp();
/*  540 */     if (addXiuLianHistory >= RoleCommonConstants.getInstance().EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT) {
/*  541 */       SCommonResultRes sCommonResultRes = new SCommonResultRes();
/*  542 */       sCommonResultRes.result = 7;
/*  543 */       OnlineManager.getInstance().send(this.roleId, sCommonResultRes);
/*  544 */       return false;
/*      */     }
/*  546 */     int addXiuLian = roleExp / RoleCommonConstants.getInstance().ONE_XIULIAN_EXP_NEED_ROLE_EXP;
/*  547 */     if (addXiuLian + addXiuLianHistory > RoleCommonConstants.getInstance().EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT) {
/*  548 */       addXiuLian = RoleCommonConstants.getInstance().EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT - addXiuLianHistory;
/*      */     }
/*      */     
/*  551 */     if (addXiuLian == 0) {
/*  552 */       return false;
/*      */     }
/*  554 */     this.xProperties.setConvertxiulianexp(addXiuLian + addXiuLianHistory);
/*  555 */     SSyncExpConvertXiuLian sSyncExpConvertXiuLian = new SSyncExpConvertXiuLian();
/*  556 */     sSyncExpConvertXiuLian.roleexp = roleExp;
/*  557 */     sSyncExpConvertXiuLian.xiulianexp = addXiuLian;
/*  558 */     OnlineManager.getInstance().send(this.roleId, sSyncExpConvertXiuLian);
/*  559 */     XiuLianSkillInterface.addXiuLianExpNotSyncClient(this.roleId, addXiuLian, logArg);
/*  560 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   void dayUpdate()
/*      */   {
/*  566 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  567 */     if (DateTimeUtils.needDailyReset(this.xProperties.getTimestamp(), currTime, 0)) {
/*  568 */       this.xProperties.setTodaypropsysswitchcount(0);
/*  569 */       Map xTransferOccupationPropertySysMap = this.xProperties.getTransfer_occupation_property_sys_map();
/*  570 */       Iterator i$ = xTransferOccupationPropertySysMap.entrySet().iterator();
/*      */       
/*  572 */       while (i$.hasNext()) {
/*  573 */         Map.Entry entry = (Map.Entry)i$.next();
/*  574 */         TransferOccupationPropertiesSys xTransferOccupationPropertiesSys = (TransferOccupationPropertiesSys)entry.getValue();
/*  575 */         xTransferOccupationPropertiesSys.setToday_prop_sys_switch_count(0);
/*      */       }
/*      */       
/*  578 */       this.xProperties.setConvertxiulianexp(0);
/*  579 */       this.xProperties.setTimestamp(currTime);
/*      */     }
/*      */   }
/*      */   
/*      */   boolean setLevel(int newLevel, int changeExp, TLogArg logArg)
/*      */   {
/*  585 */     Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  586 */     int oldLevel = getLevel();
/*  587 */     if (newLevel < oldLevel) {
/*  588 */       return false;
/*      */     }
/*  590 */     if (newLevel > occupation.getMaxLevel()) {
/*  591 */       if (!logArg.logReason.equals(LogReason.GM_ADD)) {
/*  592 */         return false;
/*      */       }
/*      */       
/*  595 */       if (newLevel > occupation.getMaxLevel() + 50) {
/*  596 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  600 */     addPortentialPoint(oldLevel, newLevel);
/*  601 */     this.xProperties.setLevel(newLevel);
/*  602 */     RoleLevelUpArg arg = new RoleLevelUpArg();
/*  603 */     arg.roleId = this.roleId;
/*  604 */     arg.oldLevel = oldLevel;
/*  605 */     arg.newLevel = newLevel;
/*  606 */     TriggerEventsManger.getInstance().triggerEvent(new RoleLevelUp(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*  607 */     String totalCash = String.valueOf(QingfuInterface.getBalance(getUserId(), true));
/*  608 */     String vipLevel = "0";
/*  609 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  610 */     String usetime = TimeUnit.MILLISECONDS.toSeconds(curTime - this.xProperties.getLeveluptime() + this.xProperties.getAccumulateleveluptime()) + "";
/*  611 */     this.xProperties.setAccumulateleveluptime(0L);
/*  612 */     this.xProperties.setLeveluptime(curTime);
/*  613 */     this.xProperties.setLevelupcurtime(curTime);
/*      */     
/*  615 */     for (int tmpLv = oldLevel + 1; tmpLv <= newLevel; tmpLv++) {
/*  616 */       String log = buildLog(new String[] { RoleInterface.getPlatform(this.roleId) + "", RoleInterface.getChannel(this.roleId), RoleInterface.getMac(this.roleId), RoleInterface.getUserId(this.roleId), this.roleId + "", oldLevel + "", tmpLv + "", totalCash, vipLevel, usetime });
/*  617 */       LogManager.getInstance().addLog("rolelevelup", log);
/*      */     }
/*      */     
/*  620 */     String tlog = buildLog(new String[] { changeExp + "", oldLevel + "", newLevel + "", usetime, logArg.getLogReason().value + "", logArg.getSubReason() + "", this.roleId + "" });
/*  621 */     TLogManager.getInstance().addLog(this.roleId, "PlayerExpFlow", tlog);
/*  622 */     return true;
/*      */   }
/*      */   
/*      */   boolean cutLevel(int newLevel, int changeExp, TLogArg logArg)
/*      */   {
/*  627 */     Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  628 */     int oldLevel = getLevel();
/*  629 */     if (changeExp == 1) {
/*  630 */       addPortentialPoint(1, 149);
/*      */     }
/*      */     
/*  633 */     if (changeExp == 2) {
/*  634 */       addPortentialPoint(1, 229);
/*      */     }
/*      */     
/*  637 */     if (changeExp == 3) {
/*  638 */       addPortentialPoint(1, 349);
/*      */     }
/*      */     
/*  641 */     if (changeExp == 4) {
/*  642 */       addPortentialPoint(1, 509);
/*      */     }
/*      */     
/*  645 */     if (changeExp == 5) {
/*  646 */       addPortentialPoint(1, 669);
/*      */     }
/*      */     
/*  649 */     if (changeExp == 6) {
/*  650 */       addPortentialPoint(1, 869);
/*      */     }
/*      */     
/*  653 */     if (changeExp >= 7) {
/*  654 */       addPortentialPoint(1, 1029);
/*      */     }
/*      */     
/*  657 */     this.xProperties.setLevel(newLevel);
/*  658 */     RoleLevelUpArg arg = new RoleLevelUpArg();
/*  659 */     arg.roleId = this.roleId;
/*  660 */     arg.oldLevel = oldLevel;
/*  661 */     arg.newLevel = newLevel;
/*  662 */     TriggerEventsManger.getInstance().triggerEvent(new RoleLevelUp(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*  663 */     String totalCash = String.valueOf(QingfuInterface.getBalance(getUserId(), true));
/*  664 */     String vipLevel = "0";
/*  665 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  666 */     String usetime = TimeUnit.MILLISECONDS.toSeconds(curTime - this.xProperties.getLeveluptime() + this.xProperties.getAccumulateleveluptime()) + "";
/*  667 */     this.xProperties.setAccumulateleveluptime(0L);
/*  668 */     this.xProperties.setLeveluptime(curTime);
/*  669 */     this.xProperties.setLevelupcurtime(curTime);
/*      */     
/*  671 */     for (int tmpLv = oldLevel + 1; tmpLv <= newLevel; tmpLv++) {
/*  672 */       String log = buildLog(new String[] { RoleInterface.getPlatform(this.roleId) + "", RoleInterface.getChannel(this.roleId), RoleInterface.getMac(this.roleId), RoleInterface.getUserId(this.roleId), this.roleId + "", oldLevel + "", tmpLv + "", totalCash, vipLevel, usetime });
/*  673 */       LogManager.getInstance().addLog("rolelevelup", log);
/*      */     }
/*      */     
/*  676 */     String tlog = buildLog(new String[] { "-1", oldLevel + "", newLevel + "", usetime, logArg.getLogReason().value + "", logArg.getSubReason() + "", this.roleId + "" });
/*  677 */     TLogManager.getInstance().addLog(this.roleId, "PlayerExpFlow", tlog);
/*  678 */     return true;
/*      */   }
/*      */   
/*      */   boolean addpoint(int point) {
/*  682 */     addPortentialPoint(1, point);
/*  683 */     return true;
/*      */   }
/*      */   
/*  686 */   private String buildLog(String[] arg) { StringBuilder sb = new StringBuilder();
/*  687 */     String[] arr$ = arg;
/*  688 */     int len$ = arg.length;
/*      */     
/*  690 */     for (int i$ = 0; i$ < len$; i$++) {
/*  691 */       String a = arr$[i$];
/*  692 */       sb.append(a).append("|");
/*      */     }
/*      */     
/*  695 */     sb.deleteCharAt(sb.length() - 1);
/*  696 */     return sb.toString();
/*      */   }
/*      */   
/*      */   public int getLevel() {
/*  700 */     return this.xProperties.getLevel();
/*      */   }
/*      */   
/*      */   public String getName() {
/*  704 */     return this.xBasic.getName();
/*      */   }
/*      */   
/*      */   public int getGender() {
/*  708 */     return this.xBasic.getGender();
/*      */   }
/*      */   
/*      */   public int getOccupationId() {
/*  712 */     return this.xBasic.getOccupationid();
/*      */   }
/*      */   
/*      */   public int getExp() {
/*  716 */     return this.xProperties.getExp();
/*      */   }
/*      */   
/*      */   public int getHP() {
/*  720 */     return this.xProperties.getHp();
/*      */   }
/*      */   
/*      */   public int getMP() {
/*  724 */     return this.xProperties.getMp();
/*      */   }
/*      */   
/*      */   public int getAnger() {
/*  728 */     return this.xProperties.getAnger();
/*      */   }
/*      */   
/*      */   public int getMaxAnger() {
/*  732 */     return SFightConsts.getInstance().ANGER_MAX;
/*      */   }
/*      */   
/*      */   public int getVigor() {
/*  736 */     return this.xProperties.getVigor();
/*      */   }
/*      */   
/*      */   public int getColorId() {
/*  740 */     return this.xProperties.getDyecolorid();
/*      */   }
/*      */   
/*      */   public long getCreateTime() {
/*  744 */     return this.xBasic.getCreatetime();
/*      */   }
/*      */   
/*      */   public long getLastLogoffTime() {
/*  748 */     return OnlineManager.getInstance().isOnline(this.roleId) ? this.xProperties.getLastlogofftime() : Math.max(this.xProperties.getKeeponlinetime(), this.xProperties.getLastlogofftime());
/*      */   }
/*      */   
/*      */   public long setLastLogOffTimeWhenLogIn() {
/*  752 */     long lastLogOffTime = getLastLogOffTimeWhenLogIn();
/*  753 */     this.xProperties.setLastlogofftime(lastLogOffTime);
/*  754 */     return lastLogOffTime;
/*      */   }
/*      */   
/*      */   public long getLastLogOffTimeWhenLogIn() {
/*  758 */     long lastLogoffTime = this.xProperties.getLastlogofftime();
/*  759 */     long lastKeepAliveTime = this.xProperties.getKeeponlinetime();
/*  760 */     return lastKeepAliveTime <= lastLogoffTime ? lastLogoffTime : lastKeepAliveTime;
/*      */   }
/*      */   
/*      */   public long getLastLoginTime() {
/*  764 */     return this.xProperties.getLastlogintime();
/*      */   }
/*      */   
/*      */   public int getFightValue() {
/*  768 */     return this.xProperties.getFightvalue();
/*      */   }
/*      */   
/*      */   public Position getPosition() {
/*  772 */     Location loc = this.xProperties.getLocation();
/*  773 */     return new Position(loc.getX(), loc.getY(), loc.getZ(), loc.getSceneid());
/*      */   }
/*      */   
/*      */   public void setHP(int hp) {
/*  777 */     this.xProperties.setHp(hp);
/*      */   }
/*      */   
/*      */   public void setMP(int mp) {
/*  781 */     this.xProperties.setMp(mp);
/*      */   }
/*      */   
/*      */   public VigorOperResult addVigor(int vigor) {
/*  785 */     return addVigor(vigor, (TLogArg)null);
/*      */   }
/*      */   
/*      */   public VigorOperResult addVigor(int vigor, TLogArg arg) {
/*  789 */     if (vigor <= 0)
/*  790 */       return VigorOperResult.VIGOR_NUM_ERROR;
/*  791 */     if (isInZero()) {
/*  792 */       return VigorOperResult.SUCCESS;
/*      */     }
/*  794 */     int oldValue = this.xProperties.getVigor();
/*  795 */     int totalVigor = this.xProperties.getVigor() + vigor;
/*  796 */     int vigorLimit = getVigorLimit();
/*  797 */     if (totalVigor >= vigorLimit) {
/*  798 */       totalVigor = vigorLimit;
/*      */     }
/*      */     
/*  801 */     this.xProperties.setVigor(totalVigor);
/*  802 */     int addVigor = totalVigor - oldValue;
/*  803 */     if (arg != null) {
/*  804 */       RoleVigorManager.logVigorChange(this.roleId, arg, totalVigor, addVigor);
/*      */     }
/*      */     
/*  807 */     return VigorOperResult.SUCCESS;
/*      */   }
/*      */   
/*      */   boolean isInZero()
/*      */   {
/*  812 */     return DateTimeUtils.getCurrTimeInMillis() < mzm.gsp.idip.main.IdipManager.zeroProfitExpireTime(this.roleId);
/*      */   }
/*      */   
/*      */   public int getVigorLimit() {
/*  816 */     int vigorLimit = RoleCommonConstants.getInstance().VIGOR_LIMIT;
/*  817 */     vigorLimit += RoleCommonConstants.getInstance().ADD_VIGOR_LIMIT_PERLV * (getLevel() - 1);
/*  818 */     vigorLimit = vigorLimit * (10000 + RoleCommonConstants.getInstance().MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE) / 10000;
/*  819 */     return vigorLimit;
/*      */   }
/*      */   
/*      */   public boolean cutVigor(int vigor) {
/*  823 */     int remainVigor = this.xProperties.getVigor() - vigor;
/*  824 */     if (remainVigor < 0) {
/*  825 */       return false;
/*      */     }
/*  827 */     this.xProperties.setVigor(remainVigor);
/*  828 */     return true;
/*      */   }
/*      */   
/*      */   public VigorOperResult cutVigorByIDIP(int vigor)
/*      */   {
/*  833 */     return cutVigorByIDIP(vigor, (TLogArg)null);
/*      */   }
/*      */   
/*      */   public VigorOperResult cutVigorByIDIP(int vigor, TLogArg arg) {
/*  837 */     if (vigor <= 0) {
/*  838 */       return VigorOperResult.VIGOR_NUM_ERROR;
/*      */     }
/*  840 */     int remainVigor = this.xProperties.getVigor() - vigor;
/*  841 */     if (remainVigor < 0) {
/*  842 */       return VigorOperResult.VIGOR_NUM_NOT_ENOUGH;
/*      */     }
/*  844 */     this.xProperties.setVigor(remainVigor);
/*  845 */     if (arg != null) {
/*  846 */       RoleVigorManager.logVigorChange(this.roleId, arg, remainVigor, vigor * -1);
/*      */     }
/*      */     
/*  849 */     return VigorOperResult.SUCCESS;
/*      */   }
/*      */   
/*      */ 
/*      */   public VigorOperResult cutVigorByAqIDIP(int vigor, TLogArg arg)
/*      */   {
/*  855 */     if (vigor <= 0) {
/*  856 */       return VigorOperResult.VIGOR_NUM_ERROR;
/*      */     }
/*  858 */     int beginValue = this.xProperties.getVigor();
/*  859 */     int remain = beginValue - vigor;
/*  860 */     if (remain < 0) {
/*  861 */       this.xProperties.setVigor(0);
/*  862 */       if (arg != null) {
/*  863 */         RoleVigorManager.logVigorChange(this.roleId, arg, 0, beginValue * -1);
/*      */       }
/*      */       
/*  866 */       return VigorOperResult.VIGOR_CLEAR_FOR_AQIDIP;
/*      */     }
/*  868 */     this.xProperties.setVigor(remain);
/*  869 */     if (arg != null) {
/*  870 */       RoleVigorManager.logVigorChange(this.roleId, arg, remain, vigor * -1);
/*      */     }
/*      */     
/*  873 */     return VigorOperResult.SUCCESS;
/*      */   }
/*      */   
/*      */ 
/*      */   void syncClientMoney()
/*      */   {
/*  879 */     SSyncMoneyChange moneyChange = new SSyncMoneyChange();
/*  880 */     moneyChange.changemoneymap.put(Integer.valueOf(0), Long.valueOf(getGold()));
/*  881 */     moneyChange.changemoneymap.put(Integer.valueOf(1), Long.valueOf(getSilver()));
/*  882 */     moneyChange.changemoneymap.put(Integer.valueOf(2), Long.valueOf(getGoldIngot()));
/*  883 */     OnlineManager.getInstance().send(getId(), moneyChange);
/*      */   }
/*      */   
/*      */   public int getBaoShiDu() {
/*  887 */     return this.xProperties.getBaoshidu();
/*      */   }
/*      */   
/*      */   boolean addBaoShiDu(int baoShiDu) {
/*  891 */     if (baoShiDu <= 0)
/*  892 */       return false;
/*  893 */     if (this.xProperties.getBaoshidu() >= RoleCommonConstants.getInstance().BAOSHIDU_LIMIT) {
/*  894 */       return false;
/*      */     }
/*  896 */     int newBaoShiDu = this.xProperties.getBaoshidu() + baoShiDu;
/*  897 */     newBaoShiDu = Math.min(newBaoShiDu, RoleCommonConstants.getInstance().BAOSHIDU_LIMIT);
/*  898 */     this.xProperties.setBaoshidu(newBaoShiDu);
/*  899 */     return true;
/*      */   }
/*      */   
/*      */   boolean costBaoShiDu(int baoShiDu)
/*      */   {
/*  904 */     if (baoShiDu <= 0) {
/*  905 */       return false;
/*      */     }
/*  907 */     int newBaoShiDu = this.xProperties.getBaoshidu() - baoShiDu;
/*  908 */     if (newBaoShiDu < 0) {
/*  909 */       return false;
/*      */     }
/*  911 */     this.xProperties.setBaoshidu(newBaoShiDu);
/*  912 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public void fillModelInfo(ModelInfo modelInfo)
/*      */   {
/*  918 */     if (this.xBasic == null) {
/*  919 */       GameServer.logger().error(String.format("[role]Role.fillModelInfo@ xBasic is null!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*      */     } else {
/*  921 */       Occupation occupation = OccupationManager.getOccupationById(getOccupationId(), getGender());
/*  922 */       int modelId = occupation.getModelId();
/*  923 */       modelInfo.modelid = modelId;
/*  924 */       modelInfo.name = getName();
/*  925 */       modelInfo.extramap.put(Integer.valueOf(32), Integer.valueOf(getGender()));
/*  926 */       modelInfo.extramap.put(Integer.valueOf(33), Integer.valueOf(getOccupationId()));
/*  927 */       EquipmentItem weapon = ItemInterface.getRoleEquipByWearPos(this.roleId, 0, this.isRetainRoleLock);
/*  928 */       if (weapon != null) {
/*  929 */         modelInfo.extramap.put(Integer.valueOf(1), Integer.valueOf(weapon.getCfgId()));
/*  930 */         modelInfo.extramap.put(Integer.valueOf(5), Integer.valueOf(weapon.getStrengthLevel()));
/*      */       }
/*      */       
/*  933 */       int equipMinLingLevel = ItemInterface.getWholeBodyMinQilinLevel(this.roleId, this.isRetainRoleLock);
/*  934 */       if (equipMinLingLevel >= 0) {
/*  935 */         modelInfo.extramap.put(Integer.valueOf(16), Integer.valueOf(equipMinLingLevel));
/*      */       }
/*      */       
/*  938 */       WingInterface.WingExteriorInfo exteriorInfo = WingInterface.getEquipedWingId(this.roleId, this.isRetainRoleLock);
/*  939 */       if (exteriorInfo != null) {
/*  940 */         modelInfo.extramap.put(Integer.valueOf(2), Integer.valueOf(exteriorInfo.getExteriorId()));
/*  941 */         modelInfo.extramap.put(Integer.valueOf(3), Integer.valueOf(exteriorInfo.getColorId()));
/*      */       }
/*      */       
/*  944 */       int fabaoId = FabaoInterface.getRoleDisplayFabaoid(this.roleId, this.isRetainRoleLock);
/*  945 */       if (fabaoId > 0) {
/*  946 */         modelInfo.extramap.put(Integer.valueOf(4), Integer.valueOf(fabaoId));
/*      */       }
/*      */       ColorIds colorIds;
/*      */       ColorIds colorIds;
/*  950 */       if (this.isRetainRoleLock) {
/*  951 */         colorIds = RoleDyeInterface.getRoleCurClothes(this.roleId);
/*      */       } else {
/*  953 */         colorIds = RoleDyeInterface.getRoleCurClothesNoLock(this.roleId);
/*      */       }
/*      */       
/*  956 */       if (colorIds != null) {
/*  957 */         modelInfo.extramap.put(Integer.valueOf(8), Integer.valueOf(colorIds.clothid));
/*  958 */         modelInfo.extramap.put(Integer.valueOf(7), Integer.valueOf(colorIds.hairid));
/*      */       }
/*      */       
/*  961 */       AircraftInterface.RideAircraftObj rideAircraftObj = AircraftInterface.getRideAircraftObj(this.roleId, this.isRetainRoleLock);
/*  962 */       if (rideAircraftObj != null) {
/*  963 */         modelInfo.extramap.put(Integer.valueOf(10), Integer.valueOf(rideAircraftObj.aircraftCfgId));
/*  964 */         modelInfo.extramap.put(Integer.valueOf(38), Integer.valueOf(rideAircraftObj.aircraftDyeColorId));
/*      */       }
/*      */       
/*  967 */       int outlookChangeId = RoleChangeInterface.getRoleNowChangeId(this.roleId, this.isRetainRoleLock);
/*  968 */       if (outlookChangeId > 0) {
/*  969 */         modelInfo.extramap.put(Integer.valueOf(13), Integer.valueOf(outlookChangeId));
/*      */       }
/*      */       
/*  972 */       int fashionDressId = FashionDressInterface.getWearFashionDress(this.roleId, this.isRetainRoleLock);
/*  973 */       if (fashionDressId > 0) {
/*  974 */         modelInfo.extramap.put(Integer.valueOf(14), Integer.valueOf(fashionDressId));
/*      */       }
/*      */       
/*  977 */       MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(this.roleId, this.isRetainRoleLock);
/*  978 */       if (rideMountsObj != null) {
/*  979 */         modelInfo.extramap.put(Integer.valueOf(19), Integer.valueOf(rideMountsObj.getMountsCfgId()));
/*  980 */         modelInfo.extramap.put(Integer.valueOf(20), Integer.valueOf(rideMountsObj.getColorId()));
/*  981 */         modelInfo.extramap.put(Integer.valueOf(21), Integer.valueOf(rideMountsObj.getMountsRank()));
/*      */       }
/*      */       
/*  984 */       int magicMarkType = mzm.gsp.magicmark.main.MagicMarkInterface.getEquipMagicMarkType(this.roleId, this.isRetainRoleLock);
/*  985 */       if (magicMarkType > 0) {
/*  986 */         modelInfo.extramap.put(Integer.valueOf(24), Integer.valueOf(magicMarkType));
/*      */       }
/*      */       
/*  989 */       int fabaoLingqiCfgid = FabaoArtifactInterface.getEquippedArtifactCfgId(this.roleId, this.isRetainRoleLock);
/*  990 */       if (fabaoLingqiCfgid > 0) {
/*  991 */         modelInfo.extramap.put(Integer.valueOf(30), Integer.valueOf(fabaoLingqiCfgid));
/*      */       }
/*      */       
/*  994 */       int wushiid = WuShiInterface.getWuShiCfgIdForRole(this.roleId, this.isRetainRoleLock);
/*  995 */       if (wushiid > 0) {
/*  996 */         modelInfo.extramap.put(Integer.valueOf(31), Integer.valueOf(wushiid));
/*      */       }
/*      */       
/*  999 */       long moralValue = MallInterface.getJifen(this.roleId, 7);
/* 1000 */       if (moralValue > 0L) {
/* 1001 */         modelInfo.extramap.put(Integer.valueOf(34), Integer.valueOf((int)moralValue));
/*      */       }
/*      */       
/* 1004 */       ChangeModelCardInterface.ChangeModelCardLevelEntry entry = ChangeModelCardInterface.getRoleCardCfgIdAndLevel(this.roleId, this.isRetainRoleLock);
/* 1005 */       if ((entry != null) && (entry.isCardActivated())) {
/* 1006 */         modelInfo.extramap.put(Integer.valueOf(35), Integer.valueOf(entry.cardCfgId));
/* 1007 */         modelInfo.extramap.put(Integer.valueOf(36), Integer.valueOf(entry.level));
/* 1008 */         modelInfo.extramap.put(Integer.valueOf(37), Integer.valueOf(entry.visible ? 0 : 1));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void setLastCalcuateTime(long time)
/*      */   {
/* 1015 */     this.xProperties.setLastcalcuatetime(time);
/*      */   }
/*      */   
/*      */   public long getLastCalcuateTime() {
/* 1019 */     return this.xProperties.getLastcalcuatetime();
/*      */   }
/*      */   
/*      */   public void setDayOnlineSeconds(int seconds) {
/* 1023 */     this.xProperties.setDayonlineseconds(seconds);
/*      */   }
/*      */   
/*      */   public int getDayOnlineSeconds() {
/* 1027 */     return this.xProperties.getDayonlineseconds();
/*      */   }
/*      */   
/*      */   public void setOnlineSeconds(long seconds) {
/* 1031 */     this.xProperties.setOnlineseconds(seconds);
/*      */   }
/*      */   
/*      */   public long getOnlineSeconds() {
/* 1035 */     return this.xProperties.getOnlineseconds();
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\Role.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */