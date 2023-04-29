/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xbean.MassWeddingRob;
/*     */ import xbean.MassWeddingRobRoles;
/*     */ import xbean.MassWeddingRobSubscribe;
/*     */ import xbean.MassWeddingRobSubscribeRoles;
/*     */ 
/*     */ public class PCBridalChamberInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long bridalChamberRoleid;
/*     */   
/*     */   public PCBridalChamberInfoReq(long roleid, long bridalChamberRoleid)
/*     */   {
/*  21 */     this.roleid = roleid;
/*  22 */     this.bridalChamberRoleid = bridalChamberRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  27 */     if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(this.roleid, 164)))
/*     */     {
/*  29 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, mzm.gsp.role.main.RoleInterface.getName(this.roleid), 164);
/*     */       
/*  31 */       return false;
/*     */     }
/*  33 */     long marryRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.bridalChamberRoleid);
/*  34 */     if (marryRoleid < 0L) {
/*  35 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberInfoReq.processImp@not married|roleid=%d|bridalChamberRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.bridalChamberRoleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  42 */       return false;
/*     */     }
/*  44 */     xbean.MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  45 */     long worldid = mzm.gsp.map.main.MapInterface.getRoleWorldInstanceId(this.roleid);
/*  46 */     if (xMassWedding.getWorldid() != worldid) {
/*  47 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberInfoReq.processImp@not in massWedding world|roleid=%d|bridalChamberRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.bridalChamberRoleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*  56 */     if (xMassWedding.getStage() != 2) {
/*  57 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberInfoReq.processImp@not in STAGE_ROB_MARRIAGE|roleid=%d|bridalChamberRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.bridalChamberRoleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*  68 */     if (xMassWeddingRankInfos == null) {
/*  69 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberInfoReq.processImp@not has rank data|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  73 */       return false;
/*     */     }
/*  75 */     Integer index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(this.bridalChamberRoleid));
/*  76 */     if (index == null) {
/*  77 */       index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(marryRoleid));
/*     */     }
/*  79 */     if (index == null) {
/*  80 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in rank|roleid=%d|supportRoleid=%d|marryroleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.bridalChamberRoleid), Long.valueOf(marryRoleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*  89 */     if (index.intValue() >= mzm.gsp.masswedding.confbean.SMassWeddingConsts.getInstance().maxCouple) {
/*  90 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in topN|roleid=%d|supportRoleid=%d|marryroleid=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.bridalChamberRoleid), Long.valueOf(marryRoleid), index }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*  99 */     long localId = mzm.gsp.GameServerInfoManager.getLocalId();
/* 100 */     MassWeddingRob xMassWeddingRob = MassWeddingManager.getMassWeddingRob(true);
/* 101 */     if (xMassWeddingRob == null) {
/* 102 */       xMassWeddingRob = xbean.Pod.newMassWeddingRob();
/* 103 */       xtable.Massweddingrob.insert(Long.valueOf(localId), xMassWeddingRob);
/*     */     }
/* 105 */     xbean.MassWeddingRankInfo xMassWeddingRankInfo = (xbean.MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(index.intValue());
/* 106 */     long roleidA = xMassWeddingRankInfo.getRoleida();
/* 107 */     MassWeddingRobSubscribe xMassWeddingRobSubscribe = MassWeddingManager.getMassWeddingRobSubScribe(true);
/* 108 */     if (xMassWeddingRobSubscribe == null) {
/* 109 */       xMassWeddingRobSubscribe = xbean.Pod.newMassWeddingRobSubscribe();
/* 110 */       xtable.Massweddingrobsubscribe.insert(Long.valueOf(localId), xMassWeddingRobSubscribe);
/*     */     }
/*     */     
/* 113 */     MassWeddingRobSubscribeRoles xMassWeddingRobSubscribeRoles = (MassWeddingRobSubscribeRoles)xMassWeddingRobSubscribe.getRobsubscribemap().get(Long.valueOf(roleidA));
/*     */     
/* 115 */     if (xMassWeddingRobSubscribeRoles == null) {
/* 116 */       xMassWeddingRobSubscribeRoles = xbean.Pod.newMassWeddingRobSubscribeRoles();
/* 117 */       xMassWeddingRobSubscribe.getRobsubscribemap().put(Long.valueOf(roleidA), xMassWeddingRobSubscribeRoles);
/*     */     }
/* 119 */     MassWeddingManager.unSubScribe(xMassWeddingRobSubscribe, this.roleid);
/* 120 */     xMassWeddingRobSubscribeRoles.getRoleids().add(Long.valueOf(this.roleid));
/*     */     
/* 122 */     mzm.gsp.masswedding.SBridalChamberInfoRes bridalChamberInfoRes = new mzm.gsp.masswedding.SBridalChamberInfoRes();
/* 123 */     bridalChamberInfoRes.roleid = this.bridalChamberRoleid;
/* 124 */     MassWeddingRobRoles xMassWeddingRobRoles = (MassWeddingRobRoles)xMassWeddingRob.getRobmap().get(Long.valueOf(this.bridalChamberRoleid));
/* 125 */     if (xMassWeddingRobRoles == null) {
/* 126 */       xMassWeddingRobRoles = (MassWeddingRobRoles)xMassWeddingRob.getRobmap().get(Long.valueOf(marryRoleid));
/*     */     }
/* 128 */     if (xMassWeddingRobRoles != null) {
/* 129 */       bridalChamberInfoRes.bride = xMassWeddingRobRoles.getBrides().size();
/* 130 */       bridalChamberInfoRes.groom = xMassWeddingRobRoles.getGrooms().size();
/*     */     }
/* 132 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, bridalChamberInfoRes);
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCBridalChamberInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */