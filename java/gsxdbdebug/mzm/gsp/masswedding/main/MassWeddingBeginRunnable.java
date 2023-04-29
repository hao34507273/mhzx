/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingGroomsmanAndBridesmaidCfg;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingInitPosCfg;
/*     */ import mzm.gsp.mounts.main.MountsInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ 
/*     */ public class MassWeddingBeginRunnable extends mzm.gsp.util.LogicRunnable
/*     */ {
/*     */   private final long roleidA;
/*     */   private final long roleidB;
/*     */   private final int num;
/*     */   
/*     */   public MassWeddingBeginRunnable(long roleIdA, long roleidB, int num)
/*     */   {
/*  35 */     this.roleidA = roleIdA;
/*  36 */     this.roleidB = roleidB;
/*  37 */     this.num = num;
/*     */   }
/*     */   
/*     */   public void process() throws Exception
/*     */   {
/*  42 */     final boolean isATeamLeader = TeamInterface.getTeamLeaderByRoleid(this.roleidA, false, false) == this.roleidA;
/*  43 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  47 */         TeamInterface.leaveTeam(MassWeddingBeginRunnable.this.roleidA);
/*  48 */         RoleStatusInterface.setStatus(MassWeddingBeginRunnable.this.roleidA, 36, false);
/*  49 */         MountsInterface.unRideMounts(MassWeddingBeginRunnable.this.roleidA);
/*  50 */         return true;
/*     */       }
/*  52 */     }.call();
/*  53 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  57 */         TeamInterface.leaveTeam(MassWeddingBeginRunnable.this.roleidB);
/*  58 */         RoleStatusInterface.setStatus(MassWeddingBeginRunnable.this.roleidB, 36, false);
/*  59 */         MountsInterface.unRideMounts(MassWeddingBeginRunnable.this.roleidB);
/*  60 */         return true;
/*     */       }
/*  62 */     }.call();
/*  63 */     boolean ret = new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  68 */         lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(MassWeddingBeginRunnable.this.roleidA), Long.valueOf(MassWeddingBeginRunnable.this.roleidB) }));
/*  69 */         MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  70 */         if (xMassWedding == null) {
/*  71 */           GameServer.logger().info(String.format("[MassWedding]MassWeddingBeginProcedure.processImp@xMassWedding is null|roleidA=%d|roleidB=%d", new Object[] { Long.valueOf(MassWeddingBeginRunnable.this.roleidA), Long.valueOf(MassWeddingBeginRunnable.this.roleidB) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  78 */           return false;
/*     */         }
/*  80 */         MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*  81 */         if (xMassWeddingRankInfos == null) {
/*  82 */           GameServer.logger().info(String.format("[MassWedding]MassWeddingBeginProcedure.processImp@xMassWeddingRank is null|roleidA=%d|roleidB=%d", new Object[] { Long.valueOf(MassWeddingBeginRunnable.this.roleidA), Long.valueOf(MassWeddingBeginRunnable.this.roleidB) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */           return false;
/*     */         }
/*  91 */         MassWeddingRankInfo xMassWeddingRankInfo = null;
/*  92 */         Integer roleRank = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(MassWeddingBeginRunnable.this.roleidA));
/*  93 */         if (roleRank != null) {
/*  94 */           xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(roleRank.intValue());
/*     */         }
/*     */         
/*  97 */         if (xMassWeddingRankInfo == null) {
/*  98 */           GameServer.logger().info(String.format("[MassWedding]MassWeddingBeginProcedure.processImp@xMassWeddingRank rolerank is null|roleidA=%d|roleidB=%d", new Object[] { Long.valueOf(MassWeddingBeginRunnable.this.roleidA), Long.valueOf(MassWeddingBeginRunnable.this.roleidB) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 105 */           return false;
/*     */         }
/* 107 */         if (xMassWeddingRankInfo.getRoleida() != MassWeddingBeginRunnable.this.roleidA) {
/* 108 */           GameServer.logger().info(String.format("[MassWedding]MassWeddingBeginProcedure.processImp@xMassWeddingRank rolerank is null|roleidA=%d|roleidB=%d|num=%d", new Object[] { Long.valueOf(MassWeddingBeginRunnable.this.roleidA), Long.valueOf(MassWeddingBeginRunnable.this.roleidB), Integer.valueOf(MassWeddingBeginRunnable.this.num) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */           return false;
/*     */         }
/*     */         
/* 118 */         int randomValue = xdb.Xdb.random().nextInt(SMassWeddingGroomsmanAndBridesmaidCfg.getAll().size());
/* 119 */         int i = 0;
/* 120 */         int cfgid = 0;
/* 121 */         for (Iterator i$ = SMassWeddingGroomsmanAndBridesmaidCfg.getAll().keySet().iterator(); i$.hasNext();) { int massWeddingGroomsmanAndBridesmaid = ((Integer)i$.next()).intValue();
/* 122 */           if (i == randomValue) {
/* 123 */             cfgid = massWeddingGroomsmanAndBridesmaid;
/* 124 */             break;
/*     */           }
/* 126 */           i++;
/*     */         }
/*     */         
/* 129 */         SMassWeddingInitPosCfg massWeddingInitPosCfg = SMassWeddingInitPosCfg.get(MassWeddingBeginRunnable.this.num + 1);
/* 130 */         if (isATeamLeader)
/*     */         {
/* 132 */           MapInterface.forceTransferToScene(MassWeddingBeginRunnable.this.roleidA, xMassWedding.getWorldid(), SMassWeddingConsts.getInstance().mapid, massWeddingInitPosCfg.x, massWeddingInitPosCfg.y);
/*     */           
/* 134 */           MapInterface.forceTransferToScene(MassWeddingBeginRunnable.this.roleidB, xMassWedding.getWorldid(), SMassWeddingConsts.getInstance().mapid, massWeddingInitPosCfg.x, massWeddingInitPosCfg.y);
/*     */         }
/*     */         else {
/* 137 */           MapInterface.forceTransferToScene(MassWeddingBeginRunnable.this.roleidB, xMassWedding.getWorldid(), SMassWeddingConsts.getInstance().mapid, massWeddingInitPosCfg.x, massWeddingInitPosCfg.y);
/*     */           
/* 139 */           MapInterface.forceTransferToScene(MassWeddingBeginRunnable.this.roleidA, xMassWedding.getWorldid(), SMassWeddingConsts.getInstance().mapid, massWeddingInitPosCfg.x, massWeddingInitPosCfg.y);
/*     */         }
/*     */         
/*     */ 
/* 143 */         Map<Integer, Integer> groupExtraInfos = new HashMap();
/* 144 */         groupExtraInfos.put(Integer.valueOf(500), Integer.valueOf(cfgid));
/* 145 */         MapInterface.addMapGroup(mzm.gsp.map.main.group.MapGroupType.MGT_GROUP_WEDDING, MassWeddingBeginRunnable.this.roleidA, Arrays.asList(new Long[] { Long.valueOf(MassWeddingBeginRunnable.this.roleidA), Long.valueOf(MassWeddingBeginRunnable.this.roleidB) }), SMassWeddingConsts.getInstance().marrySpeed, groupExtraInfos);
/*     */         
/*     */ 
/* 148 */         int nextNum = MassWeddingManager.getNextListenPointNum(-1);
/* 149 */         LocationToSeq locationToSeq = MassWeddingManager.getPointSeqsBetween(-1, nextNum);
/* 150 */         GameServer.logger().info(String.format("[MassWedding]MassWeddingBeginRunnable.process@next trigger num|seq=%d|roleidA=%d|roleidB=%d", new Object[] { Integer.valueOf(nextNum), Long.valueOf(MassWeddingBeginRunnable.this.roleidA), Long.valueOf(MassWeddingBeginRunnable.this.roleidB) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */         Location location = (Location)locationToSeq.pathList.get(locationToSeq.pathList.size() - 1);
/* 160 */         int sceneid = MapInterface.getSceneInstanceId(xMassWedding.getWorldid(), SMassWeddingConsts.getInstance().mapid, false);
/*     */         
/* 162 */         MassWeddingZoneForm massWeddingZoneForm = new MassWeddingZoneForm(location.x, location.y, nextNum, MassWeddingBeginRunnable.this.roleidA, MassWeddingBeginRunnable.this.roleidB, sceneid, SMassWeddingConsts.getInstance().pointScacle);
/*     */         
/*     */ 
/* 165 */         MapInterface.registerZoneEvent(sceneid, massWeddingZoneForm, 3, new MassWeddingParadeZoneListener(), new RegisterZoneCallBack(massWeddingZoneForm));
/*     */         
/* 167 */         new MassWeddingBeginSession(MassWeddingBeginRunnable.this.num * SMassWeddingConsts.getInstance().marryIntervalSec, MassWeddingBeginRunnable.this.roleidA, locationToSeq.pathList);
/*     */         
/*     */ 
/* 170 */         BuffInterface.installBuff(MassWeddingBeginRunnable.this.roleidA, SMassWeddingConsts.getInstance().maleBuff);
/* 171 */         BuffInterface.installBuff(MassWeddingBeginRunnable.this.roleidB, SMassWeddingConsts.getInstance().femaleBuff);
/*     */         
/*     */ 
/* 174 */         TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.masswedding.event.MassWeddingJoin(), new mzm.gsp.masswedding.event.MassWeddingJoinArg(MassWeddingBeginRunnable.this.roleidA, MassWeddingBeginRunnable.this.roleidB));
/*     */         
/* 176 */         return true;
/*     */       }
/*     */     }.call();
/* 179 */     if (!ret) {
/* 180 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 184 */           RoleStatusInterface.unsetStatus(MassWeddingBeginRunnable.this.roleidA, 36);
/* 185 */           return true;
/*     */         }
/*     */         
/* 188 */       }.call();
/* 189 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 193 */           RoleStatusInterface.unsetStatus(MassWeddingBeginRunnable.this.roleidB, 36);
/* 194 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingBeginRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */