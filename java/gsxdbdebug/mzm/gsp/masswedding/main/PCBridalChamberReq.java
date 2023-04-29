/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.masswedding.SBridalChamberErrorRes;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xbean.MassWeddingRob;
/*     */ import xbean.MassWeddingRobRoles;
/*     */ import xbean.MassWeddingRobSubscribe;
/*     */ import xbean.MassWeddingRobSubscribeRoles;
/*     */ 
/*     */ public class PCBridalChamberReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long supportRoleid;
/*     */   
/*     */   public PCBridalChamberReq(long roleid, long supportRoleid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.supportRoleid = supportRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(this.roleid, 164)))
/*     */     {
/*  37 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, RoleInterface.getName(this.roleid), 164);
/*     */       
/*  39 */       return false;
/*     */     }
/*  41 */     long marryRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.supportRoleid);
/*  42 */     if (marryRoleid < 0L) {
/*  43 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberReq.processImp@not married|roleid=%d|supportRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.supportRoleid) }));
/*     */       
/*     */ 
/*  46 */       return false;
/*     */     }
/*  48 */     String supportUserid = RoleInterface.getUserId(this.supportRoleid);
/*  49 */     String marryRoleUserid = RoleInterface.getUserId(marryRoleid);
/*  50 */     String userId = RoleInterface.getUserId(this.roleid);
/*  51 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { supportUserid, marryRoleUserid, userId }));
/*  52 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.supportRoleid), Long.valueOf(marryRoleid) }));
/*  53 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  54 */     if (xMassWedding == null) {
/*  55 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberReq.processImp.processImp@xMassWedding is null", new Object[0]));
/*     */       
/*  57 */       return false;
/*     */     }
/*  59 */     if (xMassWedding.getStage() != 2) {
/*  60 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberReq.processImp.processImp@not in STAGE_ROB_MARRIAGE", new Object[0]));
/*     */       
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (mzm.gsp.map.main.MapInterface.getRoleWorldInstanceId(this.roleid) != xMassWedding.getWorldid()) {
/*  66 */       GameServer.logger().info(String.format("[MassWedding]PCBridalChamberReq.processImp@not in massWedding world|world=%d", new Object[] { Long.valueOf(xMassWedding.getWorldid()) }));
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*  72 */     if (xMassWeddingRankInfos == null) {
/*  73 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not has rank data|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  75 */       return false;
/*     */     }
/*  77 */     Integer index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(this.supportRoleid));
/*  78 */     if (index == null) {
/*  79 */       index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(marryRoleid));
/*     */     }
/*  81 */     if (index == null) {
/*  82 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in rank|roleid=%d|supportRoleid=%d|marryroleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.supportRoleid), Long.valueOf(marryRoleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*  91 */     if (index.intValue() >= SMassWeddingConsts.getInstance().maxCouple) {
/*  92 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in topN|roleid=%d|supportRoleid=%d|marryroleid=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.supportRoleid), Long.valueOf(marryRoleid), index }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     MassWeddingRob xMassWeddingRob = MassWeddingManager.getMassWeddingRob(true);
/* 103 */     if (xMassWeddingRob == null) {
/* 104 */       xMassWeddingRob = xbean.Pod.newMassWeddingRob();
/* 105 */       xtable.Massweddingrob.insert(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()), xMassWeddingRob);
/*     */     }
/* 107 */     if (MassWeddingManager.robedRoleids(xMassWeddingRob, xMassWeddingRankInfos, this.roleid).size() > 0) {
/* 108 */       sendErrorRes(1, new String[0]);
/* 109 */       return false;
/*     */     }
/* 111 */     MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(index.intValue());
/* 112 */     long roleidA = xMassWeddingRankInfo.getRoleida();
/* 113 */     MassWeddingRobRoles xMassWeddingRobRoles = (MassWeddingRobRoles)xMassWeddingRob.getRobmap().get(Long.valueOf(roleidA));
/* 114 */     if (xMassWeddingRobRoles == null) {
/* 115 */       xMassWeddingRobRoles = xbean.Pod.newMassWeddingRobRoles();
/* 116 */       xMassWeddingRob.getRobmap().put(Long.valueOf(roleidA), xMassWeddingRobRoles);
/*     */     }
/* 118 */     if (MassWeddingManager.isRobEnd(xMassWeddingRobRoles)) {
/* 119 */       sendErrorRes(2, new String[0]);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     boolean isMale = RoleInterface.getGender(this.supportRoleid) == 1;
/* 124 */     if (isMale) {
/* 125 */       xMassWeddingRobRoles.getGrooms().add(Long.valueOf(this.roleid));
/*     */     } else {
/* 127 */       xMassWeddingRobRoles.getBrides().add(Long.valueOf(this.roleid));
/*     */     }
/* 129 */     if (MassWeddingManager.isRobEnd(xMassWeddingRobRoles)) {
/* 130 */       if (xMassWeddingRobRoles.getGrooms().size() > xMassWeddingRobRoles.getBrides().size()) {
/* 131 */         MassWeddingManager.asynSendRobWinAward(xMassWeddingRobRoles.getGrooms());
/* 132 */         MassWeddingManager.asynSendRobFailAward(xMassWeddingRobRoles.getBrides());
/*     */         
/* 134 */         mzm.gsp.award.main.AwardInterface.award(SMassWeddingConsts.getInstance().coupleAwardid, userId, this.supportRoleid, false, true, new AwardReason(mzm.gsp.tlog.LogReason.MASSWEDDING_ROB_COUPE_AWARD));
/*     */         
/* 136 */         mzm.gsp.award.main.AwardInterface.award(SMassWeddingConsts.getInstance().coupleAwardid, userId, marryRoleid, false, true, new AwardReason(mzm.gsp.tlog.LogReason.MASSWEDDING_ROB_COUPE_AWARD));
/*     */       }
/*     */       else {
/* 139 */         MassWeddingManager.asynSendRobWinAward(xMassWeddingRobRoles.getBrides());
/* 140 */         MassWeddingManager.asynSendRobFailAward(xMassWeddingRobRoles.getGrooms());
/*     */       }
/*     */     }
/*     */     
/* 144 */     mzm.gsp.masswedding.SBridalChamberRes bridalChamberRes = new mzm.gsp.masswedding.SBridalChamberRes();
/* 145 */     bridalChamberRes.roleid = this.supportRoleid;
/* 146 */     OnlineManager.getInstance().send(this.roleid, bridalChamberRes);
/*     */     
/* 148 */     mzm.gsp.masswedding.SBridalChamberInfoRes bridalChamberInfoRes = new mzm.gsp.masswedding.SBridalChamberInfoRes();
/* 149 */     bridalChamberInfoRes.roleid = this.supportRoleid;
/* 150 */     bridalChamberInfoRes.bride = xMassWeddingRobRoles.getBrides().size();
/* 151 */     bridalChamberInfoRes.groom = xMassWeddingRobRoles.getGrooms().size();
/* 152 */     OnlineManager.getInstance().send(this.roleid, bridalChamberInfoRes);
/*     */     
/*     */ 
/* 155 */     MassWeddingRobSubscribe xMassWeddingRobSubscribe = MassWeddingManager.getMassWeddingRobSubScribe(true);
/* 156 */     MassWeddingRobSubscribeRoles xMassWeddingRobSubscribeRoles = null;
/* 157 */     if (xMassWeddingRobSubscribe != null) {
/* 158 */       xMassWeddingRobSubscribeRoles = (MassWeddingRobSubscribeRoles)xMassWeddingRobSubscribe.getRobsubscribemap().get(Long.valueOf(this.supportRoleid));
/* 159 */       if (xMassWeddingRobSubscribeRoles == null) {
/* 160 */         xMassWeddingRobSubscribeRoles = (MassWeddingRobSubscribeRoles)xMassWeddingRobSubscribe.getRobsubscribemap().get(Long.valueOf(marryRoleid));
/*     */       }
/*     */     }
/* 163 */     if (xMassWeddingRobSubscribeRoles != null) {
/* 164 */       OnlineManager.getInstance().sendMulti(bridalChamberInfoRes, xMassWeddingRobSubscribeRoles.getRoleids());
/*     */     }
/* 166 */     MassWeddingManager.tlogMassWeddingRob(RoleInterface.getUserId(this.roleid), this.roleid, RoleInterface.getLevel(this.roleid), roleidA, xMassWeddingRankInfo.getRoleidb(), this.supportRoleid);
/*     */     
/* 168 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int ret, String... args) {
/* 172 */     SBridalChamberErrorRes bridalChamberErrorRes = new SBridalChamberErrorRes();
/* 173 */     bridalChamberErrorRes.result = ret;
/* 174 */     for (String arg : args) {
/* 175 */       bridalChamberErrorRes.args.add(arg);
/*     */     }
/* 177 */     OnlineManager.getInstance().sendAtOnce(this.roleid, bridalChamberErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCBridalChamberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */