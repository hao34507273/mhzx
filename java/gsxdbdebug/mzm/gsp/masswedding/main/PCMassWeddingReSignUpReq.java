/*     */ package mzm.gsp.masswedding.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.masswedding.SMassWeddingReSignUpErrorRes;
/*     */ import mzm.gsp.masswedding.SMassWeddingReSignUpRes;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xbean.Pod;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMassWeddingReSignUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int addPrice;
/*     */   
/*     */   public PCMassWeddingReSignUpReq(long roleid, int addprice)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.addPrice = addprice;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  38 */     if (this.addPrice <= 0) {
/*  39 */       GameServer.logger().error(String.format("[MassWedding]PCMassWeddingReSignUpReq.processImp@addprice parameter error|price=%d|roleid=%d", new Object[] { Integer.valueOf(this.addPrice), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*  48 */     List<Long> teamRoleids = TeamInterface.getNormalRoleList(this.roleid);
/*  49 */     int teamRoleSize = teamRoleids.size();
/*  50 */     if (teamRoleids.size() != 2) {
/*  51 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@normal team num is not enough|size=%d|roleid=%d", new Object[] { Integer.valueOf(teamRoleSize), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  58 */       return false;
/*     */     }
/*  60 */     for (Iterator i$ = teamRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  61 */       if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(roleid, 164)))
/*     */       {
/*  63 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 164);
/*     */         
/*  65 */         return false;
/*     */       }
/*     */     }
/*  68 */     Map<Long, String> role2User = new HashMap();
/*  69 */     for (Iterator i$ = teamRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  70 */       role2User.put(Long.valueOf(roleid), RoleInterface.getUserId(roleid));
/*     */     }
/*     */     
/*  73 */     lock(User.getTable(), role2User.values());
/*     */     
/*  75 */     lock(xtable.Role2properties.getTable(), role2User.keySet());
/*     */     
/*     */ 
/*  78 */     if (!MarriageInterface.isMarriageRelation(((Long)teamRoleids.get(0)).longValue(), ((Long)teamRoleids.get(1)).longValue())) {
/*  79 */       sendErrorRet(2, new String[0]);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (MarriageInterface.isInForceDivorce(this.roleid)) {
/*  84 */       sendErrorRet(1, new String[0]);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/*  90 */     if (xMassWedding == null) {
/*  91 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@masswedding is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  94 */       return false;
/*     */     }
/*  96 */     long worldid = MapInterface.getRoleWorldInstanceId(this.roleid);
/*  97 */     if (worldid != xMassWedding.getWorldid()) {
/*  98 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@not in masswedding world|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/* 101 */       return false;
/*     */     }
/* 103 */     int stage = xMassWedding.getStage();
/* 104 */     if (stage != 0) {
/* 105 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@not in signUp stage|roleid=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(stage) }));
/*     */       
/*     */ 
/*     */ 
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     long groom = ((Long)teamRoleids.get(0)).longValue();
/* 113 */     long bride = ((Long)teamRoleids.get(1)).longValue();
/* 114 */     if (RoleInterface.getGender(bride) == 1) {
/* 115 */       groom = ((Long)teamRoleids.get(1)).longValue();
/* 116 */       bride = ((Long)teamRoleids.get(0)).longValue();
/*     */     }
/* 118 */     MassWeddingSignUpChart groomChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getObjByKey(Long.valueOf(groom));
/* 119 */     if (groomChart == null) {
/* 120 */       sendErrorRet(3, new String[0]);
/* 121 */       return false;
/*     */     }
/* 123 */     int totalPrice = groomChart.roleAPrice + groomChart.roleBPrice + this.addPrice;
/* 124 */     if (totalPrice <= 0) {
/* 125 */       GameServer.logger().error(String.format("[MassWedding]PCMassWeddingReSignUpReq.processImp@addprice parameter error|price=%d|roleid=%d", new Object[] { Integer.valueOf(this.addPrice), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */       return false;
/*     */     }
/* 134 */     MassWeddingSignUpChart massWeddingSignUpChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getRankObj(SMassWeddingConsts.getInstance().maxCouple - 1);
/*     */     
/* 136 */     if ((massWeddingSignUpChart != null) && 
/* 137 */       (totalPrice <= massWeddingSignUpChart.roleAPrice + massWeddingSignUpChart.roleBPrice)) {
/* 138 */       sendErrorRet(4, new String[0]);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     long gold = RoleInterface.getGold(this.roleid);
/* 143 */     if (gold < this.addPrice) {
/* 144 */       sendErrorRet(2, new String[0]);
/* 145 */       return false;
/*     */     }
/* 147 */     boolean ret = RoleInterface.cutGold(this.roleid, this.addPrice, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.MASSWEDDING_RE_SIGN_UP));
/* 148 */     if (!ret) {
/* 149 */       sendErrorRet(3, new String[0]);
/* 150 */       return false;
/*     */     }
/* 152 */     MassWeddingSignUpChart newMassWeddingSignUpChart = null;
/* 153 */     if (this.roleid == groom) {
/* 154 */       newMassWeddingSignUpChart = new MassWeddingSignUpChart(groom, groomChart.roleAPrice + this.addPrice, bride, groomChart.roleBPrice);
/*     */     }
/*     */     else {
/* 157 */       newMassWeddingSignUpChart = new MassWeddingSignUpChart(groom, groomChart.roleAPrice, bride, groomChart.roleBPrice + this.addPrice);
/*     */     }
/*     */     
/* 160 */     MassWeddingSignUpChartManager.getInstance().rank(newMassWeddingSignUpChart);
/*     */     
/*     */ 
/* 163 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 164 */     if (xMassWeddingRankInfos == null) {
/* 165 */       xMassWeddingRankInfos = Pod.newMassWeddingRankInfos();
/* 166 */       xtable.Massweddingrank.insert(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()), xMassWeddingRankInfos);
/*     */     }
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
/*     */ 
/*     */ 
/* 181 */     xMassWeddingRankInfos.getMassweddingrankinfos().clear();
/* 182 */     xMassWeddingRankInfos.getRoleid2index().clear();
/*     */     
/* 184 */     int i = 0;
/* 185 */     int maxCacheCouples = SMassWeddingConsts.getInstance().maxCacheCouples;
/* 186 */     for (MassWeddingSignUpChart chart : MassWeddingSignUpChartManager.getInstance().getAllChartObjs()) {
/* 187 */       if (i >= maxCacheCouples)
/*     */       {
/* 189 */         MassWeddingManager.asynSendOutOfRankMail(chart);
/* 190 */         MassWeddingSignUpChartManager.getInstance().delete(chart.getKey());
/*     */       }
/*     */       else {
/* 193 */         MassWeddingRankInfo xMassWeddingRankInfo = Pod.newMassWeddingRankInfo();
/* 194 */         xMassWeddingRankInfo.setRoleida(chart.roleidA);
/* 195 */         xMassWeddingRankInfo.setRoleaoffer(chart.roleAPrice);
/* 196 */         xMassWeddingRankInfo.setRoleidb(chart.roleidB);
/* 197 */         xMassWeddingRankInfo.setRoleidboffer(chart.roleBPrice);
/* 198 */         xMassWeddingRankInfos.getMassweddingrankinfos().add(xMassWeddingRankInfo);
/* 199 */         xMassWeddingRankInfos.getRoleid2index().put(Long.valueOf(chart.roleidA), Integer.valueOf(i));
/* 200 */         i++;
/*     */       }
/*     */     }
/* 203 */     int myPrice = newMassWeddingSignUpChart.roleAPrice + newMassWeddingSignUpChart.roleBPrice;
/* 204 */     Integer rank = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(groom));
/* 205 */     if (rank == null) {
/* 206 */       GameServer.logger().error(String.format("[MassWedding]PCMassWeddingReSignUpReq.processImp@rank is null|groom=%d", new Object[] { Long.valueOf(groom) }));
/*     */       
/* 208 */       rank = Integer.valueOf(-1);
/*     */     }
/* 210 */     MassWeddingManager.asynSendMassWeddingSignUpInfo(java.util.Arrays.asList(new Long[] { Long.valueOf(groom), Long.valueOf(bride) }), myPrice, rank.intValue() + 1);
/* 211 */     SMassWeddingReSignUpRes massWeddingReSignUpRes = new SMassWeddingReSignUpRes();
/* 212 */     massWeddingReSignUpRes.addprice = this.addPrice;
/* 213 */     OnlineManager.getInstance().send(this.roleid, massWeddingReSignUpRes);
/* 214 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRet(int ret, String... args) {
/* 218 */     SMassWeddingReSignUpErrorRes massWeddingReSignUpErrorRes = new SMassWeddingReSignUpErrorRes();
/* 219 */     massWeddingReSignUpErrorRes.result = ret;
/* 220 */     for (String arg : args) {
/* 221 */       massWeddingReSignUpErrorRes.args.add(arg);
/*     */     }
/* 223 */     OnlineManager.getInstance().sendAtOnce(this.roleid, massWeddingReSignUpErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCMassWeddingReSignUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */