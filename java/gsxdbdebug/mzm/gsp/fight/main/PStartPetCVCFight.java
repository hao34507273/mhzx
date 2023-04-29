/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.HashSet;
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
/*     */ public class PStartPetCVCFight extends LogicProcedure
/*     */ {
/*     */   private final FightInterface.PetFightInfo activeFightInfo;
/*     */   private final FightInterface.PetFightInfo passiveFightInfo;
/*     */   private final FightContext context;
/*     */   private final int fightType;
/*     */   private final FightReason fightReason;
/*     */   
/*     */   public PStartPetCVCFight(FightInterface.PetFightInfo active, FightInterface.PetFightInfo passive, FightContext context, int fightType, FightReason fightReason)
/*     */   {
/*  27 */     this.context = context;
/*  28 */     this.fightType = fightType;
/*  29 */     this.fightReason = fightReason;
/*  30 */     this.activeFightInfo = active;
/*  31 */     this.passiveFightInfo = passive;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     xbean.Fight xFight = xbean.Pod.newFight();
/*  38 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*     */     
/*  40 */     Set<Long> allRoles = new HashSet();
/*  41 */     allRoles.add(Long.valueOf(this.activeFightInfo.roleId));
/*  42 */     allRoles.add(Long.valueOf(this.passiveFightInfo.roleId));
/*     */     
/*  44 */     lock(Basic.getTable(), allRoles);
/*     */     
/*  46 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  47 */     if (fightTypeCfg == null) {
/*  48 */       GameServer.logger().error(String.format("[fight]PStartPetFight.processImp@wrong fighttype|fightType=%d|activeroleid=%d|passiveroleid=%d|fightreason=%d", new Object[] { Integer.valueOf(this.fightType), Long.valueOf(this.activeFightInfo.roleId), Long.valueOf(this.passiveFightInfo.roleId), Integer.valueOf(this.fightReason.value) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  54 */       PetFightCVCFailArg arg = new PetFightCVCFailArg();
/*  55 */       arg.activeRoleId = this.activeFightInfo.roleId;
/*  56 */       arg.passiveRoleId = this.passiveFightInfo.roleId;
/*  57 */       arg.fightContext = this.context;
/*  58 */       arg.faliReason = PetFightCVCFailArg.FailReason.FIGHT_TYPE_NOT_EXIST;
/*  59 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new PetFightCVCFail(), arg);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     Long fightIdLong = Role2fight.get(Long.valueOf(this.activeFightInfo.roleId));
/*  65 */     if (fightIdLong != null) {
/*  66 */       FightManager.sendNormalResult(this.activeFightInfo.roleId, 101, new String[0]);
/*     */       
/*  68 */       PetFightCVCFailArg arg = new PetFightCVCFailArg();
/*  69 */       arg.activeRoleId = this.activeFightInfo.roleId;
/*  70 */       arg.passiveRoleId = this.passiveFightInfo.roleId;
/*  71 */       arg.fightContext = this.context;
/*  72 */       arg.faliReason = PetFightCVCFailArg.FailReason.ROLE_IS_IN_FIGHT;
/*  73 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new PetFightCVCFail(), arg);
/*  74 */       GameServer.logger().error(String.format("[fight]PStartPetFight.processImp@active player in fight|fightType=%d|activeroleid=%d|passiveroleid=%d|fightreason=%d", new Object[] { Integer.valueOf(this.fightType), Long.valueOf(this.activeFightInfo.roleId), Long.valueOf(this.passiveFightInfo.roleId), Integer.valueOf(this.fightReason.value) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (this.context != null) {
/*  83 */       xFight.setContext(this.context);
/*  84 */       if (this.context.isRecordEnable()) {
/*  85 */         xFight.setFight_recorder(new FightRecorder());
/*     */       }
/*     */     }
/*     */     
/*  89 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  90 */     xFight.setCfgtype(this.fightType);
/*  91 */     xFight.setFightreason(this.fightReason.value);
/*  92 */     xFight.setStarttime(curTime);
/*  93 */     xFight.setObservers(new java.util.LinkedHashMap());
/*  94 */     xFight.setGenresultatonce(true);
/*  95 */     FightManager.startPetCVCFight(fightid, xFight, this.activeFightInfo, this.passiveFightInfo);
/*     */     
/*     */ 
/*  98 */     if (fightTypeCfg.maxDuration > 0) {
/*  99 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/* 100 */       xFight.setTimer(fightTimer);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 108 */     FightManager.logger.info(String.format("[Fight]PStartPetFight.processImp@fight roles|roles=%s|time=%d|fightUUid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(allRoles), Long.valueOf(curTime), Long.valueOf(fightid), Integer.valueOf(this.fightReason.value) }));
/*     */     
/*     */ 
/*     */ 
/* 112 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPetCVCFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */