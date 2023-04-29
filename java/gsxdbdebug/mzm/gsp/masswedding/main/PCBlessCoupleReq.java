/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.masswedding.SBlessCoupleRes;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BlessRoles;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingBless;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xbean.Pod;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBlessCoupleReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long blessRoleid;
/*     */   private final Octets content;
/*     */   
/*     */   public PCBlessCoupleReq(long roleid, long blessRoleid, Octets content)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.blessRoleid = blessRoleid;
/*  33 */     this.content = content;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  38 */     long marryRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.blessRoleid);
/*  39 */     if (marryRoleid < 0L) {
/*  40 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not married|roleid=%d|blessRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.blessRoleid) }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*  45 */     if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(this.roleid, 164)))
/*     */     {
/*  47 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, RoleInterface.getName(this.roleid), 164);
/*     */       
/*  49 */       return false;
/*     */     }
/*  51 */     String reqUserid = RoleInterface.getUserId(this.roleid);
/*  52 */     lock(User.getTable(), Arrays.asList(new String[] { reqUserid }));
/*  53 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.blessRoleid), Long.valueOf(marryRoleid) }));
/*  54 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  55 */     if (xMassWedding == null) {
/*  56 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@xMassWedding is null", new Object[0]));
/*  57 */       return false;
/*     */     }
/*  59 */     if (xMassWedding.getStage() < 1) {
/*  60 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in marry stage", new Object[0]));
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (MapInterface.getRoleWorldInstanceId(this.roleid) != xMassWedding.getWorldid()) {
/*  65 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in massWedding world|world=%d", new Object[] { Long.valueOf(xMassWedding.getWorldid()) }));
/*     */       
/*     */ 
/*  68 */       return false;
/*     */     }
/*  70 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*  71 */     if (xMassWeddingRankInfos == null) {
/*  72 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not has rank data|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  74 */       return false;
/*     */     }
/*  76 */     Integer index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(this.blessRoleid));
/*  77 */     if (index == null) {
/*  78 */       index = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(marryRoleid));
/*     */     }
/*  80 */     if (index == null) {
/*  81 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in rank|roleid=%d|blessRoleid=%d|marryroleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.blessRoleid), Long.valueOf(marryRoleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*  90 */     if (index.intValue() >= SMassWeddingConsts.getInstance().maxCouple) {
/*  91 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@not in topN|roleid=%d|blessRoleid=%d|marryroleid=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.blessRoleid), Long.valueOf(marryRoleid), index }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     MassWeddingBless xMassWeddingBless = MassWeddingManager.getMassWeddingBless(true);
/* 102 */     if (xMassWeddingBless == null) {
/* 103 */       xMassWeddingBless = Pod.newMassWeddingBless();
/* 104 */       xtable.Massweddingbless.insert(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()), xMassWeddingBless);
/*     */     }
/* 106 */     if (MassWeddingManager.isBlessed(xMassWeddingBless, this.roleid) == 1) {
/* 107 */       GameServer.logger().info(String.format("[MassWedding]PCBlessCoupleReq.processImp@blessed|roleid=%d|blessRoleid=%d|marryroleid=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.blessRoleid), Long.valueOf(marryRoleid), index }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */       return false;
/*     */     }
/* 116 */     MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(index.intValue());
/* 117 */     long roleidA = xMassWeddingRankInfo.getRoleida();
/* 118 */     BlessRoles xBlessRoles = (BlessRoles)xMassWeddingBless.getBlessmap().get(Long.valueOf(roleidA));
/* 119 */     if (xBlessRoles == null) {
/* 120 */       xBlessRoles = Pod.newBlessRoles();
/* 121 */       xMassWeddingBless.getBlessmap().put(Long.valueOf(roleidA), xBlessRoles);
/*     */     }
/* 123 */     xBlessRoles.getBlessroles().add(Long.valueOf(this.roleid));
/*     */     
/*     */ 
/* 126 */     mzm.gsp.award.main.AwardInterface.award(SMassWeddingConsts.getInstance().blessAwardid, reqUserid, this.roleid, false, true, new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.MASSWEDDING_BLESS_AWARD));
/*     */     
/* 128 */     SBlessCoupleRes blessCoupleRes = new SBlessCoupleRes();
/* 129 */     OnlineManager.getInstance().send(this.roleid, blessCoupleRes);
/*     */     
/*     */ 
/* 132 */     ChatInterface.sendBullet(this.roleid, this.content);
/*     */     
/*     */ 
/* 135 */     MassWeddingManager.tlogMassWeddingBless(RoleInterface.getUserId(this.roleid), this.roleid, RoleInterface.getLevel(this.roleid), xMassWeddingRankInfo.getRoleida(), xMassWeddingRankInfo.getRoleidb(), this.content.getString());
/*     */     
/*     */ 
/* 138 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCBlessCoupleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */