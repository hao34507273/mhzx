/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.group.MapGroupType;
/*     */ import mzm.gsp.masswedding.SSynMessWeddingCeremony;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PonArrivalPointSeq extends LogicProcedure
/*     */ {
/*     */   private final int seq;
/*     */   private final long roleidA;
/*     */   private final long roleidB;
/*     */   
/*     */   public PonArrivalPointSeq(int seq, long roleidA, long roleidB)
/*     */   {
/*  32 */     this.seq = seq;
/*  33 */     this.roleidA = roleidA;
/*  34 */     this.roleidB = roleidB;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  39 */     String useridA = RoleInterface.getUserId(this.roleidA);
/*  40 */     String useridB = RoleInterface.getUserId(this.roleidB);
/*  41 */     lock(User.getTable(), Arrays.asList(new String[] { useridA, useridB }));
/*  42 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleidA), Long.valueOf(this.roleidB) }));
/*     */     
/*  44 */     GameServer.logger().info(String.format("[MassWedding]PonArrivalPointSeq.processImp@cur seq|seq=%d|roleidA=%d|roleidB=%d", new Object[] { Integer.valueOf(this.seq), Long.valueOf(this.roleidA), Long.valueOf(this.roleidB) }));
/*     */     
/*     */ 
/*     */ 
/*  48 */     SMassWeddingPlayCfg massWeddingPlayCfg = SMassWeddingPlayCfg.get(this.seq);
/*  49 */     if (massWeddingPlayCfg == null) {
/*  50 */       GameServer.logger().error(String.format("[MassWedding]PonArrivalPointSeq.processImp@cfg is null", new Object[] { Integer.valueOf(this.seq), Long.valueOf(this.roleidA), Long.valueOf(this.roleidB) }));
/*     */       
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  56 */     long worldid = xMassWedding.getWorldid();
/*  57 */     if (massWeddingPlayCfg.controlid > 0) {
/*  58 */       mzm.gsp.map.main.ControllerInterface.triggerWorldControllerWithMaxSpawnNum(xMassWedding.getWorldid(), massWeddingPlayCfg.controlid, massWeddingPlayCfg.controlCount);
/*     */     }
/*     */     
/*     */ 
/*  62 */     if (massWeddingPlayCfg.trigger != 0) {
/*  63 */       SSynMessWeddingCeremony synMessWeddingCeremony = new SSynMessWeddingCeremony();
/*  64 */       synMessWeddingCeremony.triggertype = massWeddingPlayCfg.trigger;
/*  65 */       MassWeddingManager.fillCoupleInfo(synMessWeddingCeremony.coupleinfo, this.roleidA, this.roleidB);
/*  66 */       MapInterface.brocadCastInWorld(worldid, synMessWeddingCeremony, true);
/*     */       
/*  68 */       Map<Integer, Integer> extraMap = new java.util.HashMap();
/*  69 */       extraMap.put(Integer.valueOf(501), Integer.valueOf(massWeddingPlayCfg.trigger));
/*  70 */       MapInterface.changeMapGroupExtraInfos(MapGroupType.MGT_GROUP_WEDDING, this.roleidA, extraMap, null);
/*     */     }
/*  72 */     if (massWeddingPlayCfg.stopSec > 0) {
/*  73 */       new PauseSession(massWeddingPlayCfg.stopSec, this.seq, this.roleidA, this.roleidB);
/*     */ 
/*     */     }
/*  76 */     else if (!moveOn(this.seq, xMassWedding, this.roleidA, this.roleidB))
/*     */     {
/*  78 */       MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*  79 */       MassWeddingManager.onMassWeddingMoveFinish(useridA, useridB, this.roleidA, this.roleidB, xMassWedding, xMassWeddingRankInfos);
/*     */     }
/*     */     
/*     */ 
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean moveOn(int curSeq, MassWedding xMassWedding, long roleidA, long roleidB)
/*     */   {
/*  98 */     Set<Integer> removeExtraInfoKeys = new java.util.HashSet();
/*  99 */     removeExtraInfoKeys.add(Integer.valueOf(501));
/* 100 */     MapInterface.changeMapGroupExtraInfos(MapGroupType.MGT_GROUP_WEDDING, roleidA, null, removeExtraInfoKeys);
/*     */     
/* 102 */     LocationToSeq locationToSeq = null;
/* 103 */     int nextNum = MassWeddingManager.getNextListenPointNum(curSeq);
/* 104 */     if (nextNum < 0) {
/* 105 */       locationToSeq = MassWeddingManager.getPointSeqsBetween(curSeq, Integer.MAX_VALUE);
/*     */     } else {
/* 107 */       locationToSeq = MassWeddingManager.getPointSeqsBetween(curSeq, nextNum);
/*     */     }
/*     */     
/* 110 */     if ((locationToSeq == null) || (locationToSeq.pathList.size() <= 0))
/*     */     {
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     Location location = (Location)locationToSeq.pathList.get(locationToSeq.pathList.size() - 1);
/* 117 */     int sceneid = MapInterface.getSceneInstanceId(xMassWedding.getWorldid(), SMassWeddingConsts.getInstance().mapid, false);
/*     */     
/* 119 */     MassWeddingZoneForm massWeddingZoneForm = new MassWeddingZoneForm(location.x, location.y, ((Integer)locationToSeq.seqs.get(locationToSeq.seqs.size() - 1)).intValue(), roleidA, roleidB, sceneid, SMassWeddingConsts.getInstance().pointScacle);
/*     */     
/*     */ 
/*     */ 
/* 123 */     MapInterface.registerZoneEvent(sceneid, massWeddingZoneForm, 3, new MassWeddingParadeZoneListener(), new RegisterZoneCallBack(massWeddingZoneForm));
/*     */     
/*     */ 
/* 126 */     MapInterface.groupMove(MapGroupType.MGT_GROUP_WEDDING, roleidA, locationToSeq.pathList);
/*     */     
/* 128 */     if (GameServer.logger().isDebugEnabled()) {
/* 129 */       StringBuffer stringBuffer = new StringBuffer();
/* 130 */       for (Location location2 : locationToSeq.pathList) {
/* 131 */         stringBuffer.append(location2.x).append(",").append(location2.y).append("|");
/*     */       }
/*     */       
/* 134 */       GameServer.logger().debug(String.format("[Marriage]MarriageMarriage.nextSeq@location|path=%s", new Object[] { stringBuffer.toString() }));
/*     */     }
/*     */     
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   static class PauseSession extends Session
/*     */   {
/*     */     final long roleA;
/*     */     final long roleB;
/*     */     
/*     */     public PauseSession(long interval, long seq, long roleidA, long roleidB) {
/* 146 */       super(seq);
/* 147 */       this.roleA = roleidA;
/* 148 */       this.roleB = roleidB;
/*     */     }
/*     */     
/*     */     int getSeq() {
/* 152 */       return (int)getOwerId();
/*     */     }
/*     */     
/*     */     protected void onTimeOut()
/*     */     {
/* 157 */       final int stopSeq = getSeq();
/* 158 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 162 */           String useridA = RoleInterface.getUserId(PonArrivalPointSeq.PauseSession.this.roleA);
/* 163 */           String useridB = RoleInterface.getUserId(PonArrivalPointSeq.PauseSession.this.roleB);
/* 164 */           lock(User.getTable(), Arrays.asList(new String[] { useridA, useridB }));
/* 165 */           lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(PonArrivalPointSeq.PauseSession.this.roleA), Long.valueOf(PonArrivalPointSeq.PauseSession.this.roleB) }));
/*     */           
/* 167 */           MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 168 */           if (!PonArrivalPointSeq.moveOn(stopSeq, xMassWedding, PonArrivalPointSeq.PauseSession.this.roleA, PonArrivalPointSeq.PauseSession.this.roleB))
/*     */           {
/* 170 */             MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*     */             
/* 172 */             MassWeddingManager.onMassWeddingMoveFinish(useridA, useridB, PonArrivalPointSeq.PauseSession.this.roleA, PonArrivalPointSeq.PauseSession.this.roleB, xMassWedding, xMassWeddingRankInfos);
/*     */           }
/*     */           
/* 175 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PonArrivalPointSeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */