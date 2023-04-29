/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.fight.event.PetFightCVCFail;
/*     */ import mzm.gsp.fight.event.PetFightCVCFailArg;
/*     */ import mzm.gsp.fight.event.PetFightCVCFailArg.FailReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2fight;
/*     */ 
/*     */ public class PStartPetCVCRobotFight extends LogicProcedure
/*     */ {
/*     */   private final FightInterface.PetFightInfo activeFightInfo;
/*     */   private final FightInterface.PetFightRobotInfo passiveFightInfo;
/*     */   private final FightContext context;
/*     */   private final int fightType;
/*     */   private final FightReason fightReason;
/*     */   
/*     */   public PStartPetCVCRobotFight(FightInterface.PetFightInfo active, FightInterface.PetFightRobotInfo passive, FightContext context, int fightType, FightReason fightReason)
/*     */   {
/*  28 */     this.context = context;
/*  29 */     this.fightType = fightType;
/*  30 */     this.fightReason = fightReason;
/*  31 */     this.activeFightInfo = active;
/*  32 */     this.passiveFightInfo = passive;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     xbean.Fight xFight = xbean.Pod.newFight();
/*  39 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*     */     
/*  41 */     Set<Long> allRoles = new HashSet();
/*  42 */     allRoles.add(Long.valueOf(this.activeFightInfo.roleId));
/*  43 */     allRoles.add(Long.valueOf(this.passiveFightInfo.roleId));
/*     */     
/*  45 */     lock(Basic.getTable(), allRoles);
/*     */     
/*  47 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  48 */     if (fightTypeCfg == null) {
/*  49 */       GameServer.logger().error(String.format("[fight]PStartPetCVCRobotFight.processImp@wrong fighttype|fightType=%d|activeroleid=%d|passiveroleid=%d|fightreason=%d", new Object[] { Integer.valueOf(this.fightType), Long.valueOf(this.activeFightInfo.roleId), Long.valueOf(this.passiveFightInfo.roleId), Integer.valueOf(this.fightReason.value) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  55 */       PetFightCVCFailArg arg = new PetFightCVCFailArg();
/*  56 */       arg.activeRoleId = this.activeFightInfo.roleId;
/*  57 */       arg.passiveRoleId = this.passiveFightInfo.roleId;
/*  58 */       arg.fightContext = this.context;
/*  59 */       arg.faliReason = PetFightCVCFailArg.FailReason.FIGHT_TYPE_NOT_EXIST;
/*  60 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new PetFightCVCFail(), arg);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     Long fightIdLong = Role2fight.get(Long.valueOf(this.activeFightInfo.roleId));
/*  66 */     if (fightIdLong != null) {
/*  67 */       FightManager.sendNormalResult(this.activeFightInfo.roleId, 101, new String[0]);
/*     */       
/*  69 */       PetFightCVCFailArg arg = new PetFightCVCFailArg();
/*  70 */       arg.activeRoleId = this.activeFightInfo.roleId;
/*  71 */       arg.passiveRoleId = this.passiveFightInfo.roleId;
/*  72 */       arg.fightContext = this.context;
/*  73 */       arg.faliReason = PetFightCVCFailArg.FailReason.ROLE_IS_IN_FIGHT;
/*  74 */       GameServer.logger().error(String.format("[fight]PStartPetCVCRobotFight.processImp@active player in fight|fightType=%d|activeroleid=%d|passiveroleid=%d|fightreason=%d", new Object[] { Integer.valueOf(this.fightType), Long.valueOf(this.activeFightInfo.roleId), Long.valueOf(this.passiveFightInfo.roleId), Integer.valueOf(this.fightReason.value) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  79 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new PetFightCVCFail(), arg);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (this.context != null) {
/*  84 */       xFight.setContext(this.context);
/*  85 */       if (this.context.isRecordEnable()) {
/*  86 */         xFight.setFight_recorder(new FightRecorder());
/*     */       }
/*     */     }
/*     */     
/*  90 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  91 */     xFight.setCfgtype(this.fightType);
/*  92 */     xFight.setFightreason(this.fightReason.value);
/*  93 */     xFight.setStarttime(curTime);
/*  94 */     xFight.setObservers(new LinkedHashMap());
/*  95 */     xFight.setGenresultatonce(true);
/*  96 */     FightManager.startPetCVCRobotFight(fightid, xFight, this.activeFightInfo, this.passiveFightInfo);
/*     */     
/*     */ 
/*  99 */     if (fightTypeCfg.maxDuration > 0) {
/* 100 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/* 101 */       xFight.setTimer(fightTimer);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 109 */     FightManager.logger.info(String.format("[Fight]PStartPetCVCRobotFight.processImp@fight roles|roles=%s|time=%d|fightUUid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(allRoles), Long.valueOf(curTime), Long.valueOf(fightid), Integer.valueOf(this.fightReason.value) }));
/*     */     
/*     */ 
/*     */ 
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPetCVCRobotFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */