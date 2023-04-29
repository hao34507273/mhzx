/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ObserveFight;
/*     */ import xtable.Role2observefight;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PObserveFightReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long observerRoleid;
/*     */   private long beObservedRoleid;
/*     */   
/*     */   public PObserveFightReq(long observerRoleid, long beObservedRoleid)
/*     */   {
/*  27 */     this.beObservedRoleid = beObservedRoleid;
/*  28 */     this.observerRoleid = observerRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     long trulyBeObservedRoleid = -1L;
/*  35 */     int observeTeamType = -1;
/*  36 */     long fightid = -1L;
/*  37 */     if (FightInterface.isInFight(this.beObservedRoleid)) {
/*  38 */       trulyBeObservedRoleid = this.beObservedRoleid;
/*     */     } else {
/*  40 */       ObserveFight xObserveFight = Role2observefight.select(Long.valueOf(this.beObservedRoleid));
/*  41 */       if (xObserveFight != null) {
/*  42 */         int observeType = xObserveFight.getObservetype();
/*  43 */         switch (observeType) {
/*     */         case 0: 
/*  45 */           trulyBeObservedRoleid = xObserveFight.getObservevalue();
/*  46 */           observeTeamType = xObserveFight.getObserveteamtype();
/*  47 */           fightid = xObserveFight.getFightid();
/*  48 */           break;
/*     */         case 1: 
/*  50 */           MapInterface.observeMonsterFight(this.observerRoleid, (int)xObserveFight.getObservevalue());
/*  51 */           return true;
/*     */         
/*     */         default: 
/*  54 */           GameServer.logger().error(String.format("[Fight]PCObserveFightWithLeader.processImp@donot exist observe type|type=%d|roleid=%d|beObserveRoleid=%d", new Object[] { Integer.valueOf(observeType), Long.valueOf(this.observerRoleid), Long.valueOf(this.beObservedRoleid) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  61 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*  65 */     if (trulyBeObservedRoleid < 0L) {
/*  66 */       FightManager.sendNormalResult(this.observerRoleid, 104, new String[0]);
/*  67 */       return false;
/*     */     }
/*  69 */     long beObservedWorldid = MapInterface.getRoleWorldInstanceId(trulyBeObservedRoleid);
/*  70 */     long observeWorldid = MapInterface.getRoleWorldInstanceId(this.observerRoleid);
/*  71 */     ObserveFightChecker beObservedFightChecker = (ObserveFightChecker)FightManager.OBSERVEFIGHTCHECK_MAP.get(Long.valueOf(beObservedWorldid));
/*  72 */     ObserveFightChecker observeFightChecker = (ObserveFightChecker)FightManager.OBSERVEFIGHTCHECK_MAP.get(Long.valueOf(observeWorldid));
/*  73 */     boolean sign = false;
/*     */     
/*  75 */     if (beObservedFightChecker != null) {
/*  76 */       ObserveFightChecker.CheckResult checkResult = beObservedFightChecker.observeFightCheck(trulyBeObservedRoleid, beObservedWorldid, this.observerRoleid, observeWorldid);
/*     */       
/*  78 */       if (checkResult.result != 301) {
/*  79 */         FightManager.sendNormalResult(this.observerRoleid, checkResult.result, checkResult.getArgs());
/*  80 */         return false;
/*     */       }
/*  82 */       sign = true;
/*     */     }
/*     */     
/*  85 */     if (observeFightChecker != null) {
/*  86 */       ObserveFightChecker.CheckResult checkResult = observeFightChecker.observeFightCheck(trulyBeObservedRoleid, beObservedWorldid, this.observerRoleid, observeWorldid);
/*     */       
/*  88 */       if (checkResult.result != 301) {
/*  89 */         FightManager.sendNormalResult(this.observerRoleid, checkResult.result, checkResult.getArgs());
/*  90 */         return false;
/*     */       }
/*  92 */       sign = true;
/*     */     }
/*  94 */     if (!sign) {
/*  95 */       if (observeWorldid != beObservedWorldid) {
/*  96 */         FightManager.sendNormalResult(this.observerRoleid, 302, new String[0]);
/*  97 */         return false;
/*     */       }
/*     */       
/* 100 */       List<Long> normalRoleList = TeamInterface.getNormalRoleList(this.observerRoleid);
/* 101 */       if (normalRoleList.size() > 0) {
/* 102 */         long leaderid = ((Long)normalRoleList.get(0)).longValue();
/* 103 */         if ((this.observerRoleid != leaderid) && 
/* 104 */           (normalRoleList.contains(Long.valueOf(this.observerRoleid))) && 
/* 105 */           (this.beObservedRoleid != leaderid))
/*     */         {
/* 107 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 113 */     if (observeTeamType == -1) {
/* 114 */       return FightManager.reqObserveFight(this.observerRoleid, trulyBeObservedRoleid);
/*     */     }
/* 116 */     return FightManager.reqObserveFightByOthers(this.observerRoleid, trulyBeObservedRoleid, fightid, observeTeamType);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PObserveFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */