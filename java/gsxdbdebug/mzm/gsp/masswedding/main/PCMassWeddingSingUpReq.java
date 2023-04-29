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
/*     */ import mzm.gsp.masswedding.SMassWeddingSignUpErrorRes;
/*     */ import mzm.gsp.masswedding.SMassWeddingSignUpRes;
/*     */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassWedding;
/*     */ import xbean.MassWeddingRankInfo;
/*     */ import xbean.MassWeddingRankInfos;
/*     */ import xbean.Pod;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMassWeddingSingUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int myPrice;
/*     */   
/*     */   public PCMassWeddingSingUpReq(long roleid, int myPrice)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.myPrice = myPrice;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     if (this.myPrice <= 0) {
/*  38 */       GameServer.logger().error(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@myPrice parameter error|price=%d|roleid=%d", new Object[] { Integer.valueOf(this.myPrice), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  45 */       return false;
/*     */     }
/*  47 */     if (this.myPrice < SMassWeddingConsts.getInstance().minPrice) {
/*  48 */       GameServer.logger().error(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@myPrice parameter error|price=%d|roleid=%d", new Object[] { Integer.valueOf(this.myPrice), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*  57 */     List<Long> teamRoleids = mzm.gsp.team.main.TeamInterface.getNormalRoleList(this.roleid);
/*  58 */     int teamRoleSize = teamRoleids.size();
/*  59 */     if (teamRoleids.size() != 2) {
/*  60 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@normal team num is not enough|size=%d|roleid=%d", new Object[] { Integer.valueOf(teamRoleSize), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     if (!teamRoleids.contains(Long.valueOf(this.roleid))) {
/*  70 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@role is not in team|size=%d|roleid=%d", new Object[] { Integer.valueOf(teamRoleSize), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*  76 */     for (Iterator i$ = teamRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  77 */       if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(roleid, 164)))
/*     */       {
/*  79 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 164);
/*     */         
/*  81 */         return false;
/*     */       }
/*     */     }
/*  84 */     Map<Long, String> role2User = new HashMap();
/*  85 */     for (Iterator i$ = teamRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  86 */       role2User.put(Long.valueOf(roleid), RoleInterface.getUserId(roleid));
/*     */     }
/*     */     
/*  89 */     lock(User.getTable(), role2User.values());
/*     */     
/*  91 */     lock(xtable.Role2properties.getTable(), role2User.keySet());
/*     */     
/*     */ 
/*  94 */     if (!MarriageInterface.isMarriageRelation(((Long)teamRoleids.get(0)).longValue(), ((Long)teamRoleids.get(1)).longValue())) {
/*  95 */       sendErrorRet(2, new String[0]);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if (MarriageInterface.isInForceDivorce(this.roleid)) {
/* 100 */       sendErrorRet(1, new String[0]);
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 106 */     if (xMassWedding == null) {
/* 107 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@masswedding is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/* 110 */       return false;
/*     */     }
/* 112 */     long worldid = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 113 */     if (worldid != xMassWedding.getWorldid()) {
/* 114 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@not in masswedding world|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/* 117 */       return false;
/*     */     }
/* 119 */     int stage = xMassWedding.getStage();
/* 120 */     if (stage != 0) {
/* 121 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@not in signUp stage|roleid=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(stage) }));
/*     */       
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/* 127 */     MassWeddingSignUpChart massWeddingSignUpChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getRankObj(SMassWeddingConsts.getInstance().maxCouple - 1);
/*     */     
/* 129 */     if ((massWeddingSignUpChart != null) && 
/* 130 */       (this.myPrice <= massWeddingSignUpChart.roleAPrice + massWeddingSignUpChart.roleBPrice)) {
/* 131 */       sendErrorRet(5, new String[0]);
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 136 */     long groom = ((Long)teamRoleids.get(0)).longValue();
/* 137 */     long bride = ((Long)teamRoleids.get(1)).longValue();
/* 138 */     if (RoleInterface.getGender(bride) == 1) {
/* 139 */       groom = ((Long)teamRoleids.get(1)).longValue();
/* 140 */       bride = ((Long)teamRoleids.get(0)).longValue();
/*     */     }
/* 142 */     MassWeddingSignUpChart groomChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getObjByKey(Long.valueOf(groom));
/* 143 */     if (groomChart != null) {
/* 144 */       sendErrorRet(4, new String[0]);
/* 145 */       return false;
/*     */     }
/* 147 */     long gold = RoleInterface.getGold(this.roleid);
/* 148 */     if (gold < this.myPrice) {
/* 149 */       sendErrorRet(3, new String[0]);
/* 150 */       return false;
/*     */     }
/* 152 */     boolean ret = RoleInterface.cutGold(this.roleid, this.myPrice, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.MASSWEDDING_SIGN_UP));
/* 153 */     if (!ret) {
/* 154 */       sendErrorRet(3, new String[0]);
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     MassWeddingSignUpChart newMassWeddingSignUpChart = null;
/* 159 */     if (this.roleid == groom) {
/* 160 */       newMassWeddingSignUpChart = new MassWeddingSignUpChart(groom, this.myPrice, bride, 0);
/*     */     } else {
/* 162 */       newMassWeddingSignUpChart = new MassWeddingSignUpChart(groom, 0, bride, this.myPrice);
/*     */     }
/* 164 */     MassWeddingSignUpChartManager.getInstance().rank(newMassWeddingSignUpChart);
/*     */     
/*     */ 
/* 167 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 168 */     if (xMassWeddingRankInfos == null) {
/* 169 */       xMassWeddingRankInfos = Pod.newMassWeddingRankInfos();
/* 170 */       xtable.Massweddingrank.insert(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()), xMassWeddingRankInfos);
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
/* 185 */     xMassWeddingRankInfos.getMassweddingrankinfos().clear();
/* 186 */     xMassWeddingRankInfos.getRoleid2index().clear();
/*     */     
/* 188 */     int i = 0;
/* 189 */     int maxCacheCouples = SMassWeddingConsts.getInstance().maxCacheCouples;
/* 190 */     for (MassWeddingSignUpChart chart : MassWeddingSignUpChartManager.getInstance().getAllChartObjs())
/* 191 */       if (i >= maxCacheCouples)
/*     */       {
/* 193 */         MassWeddingManager.asynSendOutOfRankMail(chart);
/* 194 */         MassWeddingSignUpChartManager.getInstance().delete(chart.getKey());
/*     */       }
/*     */       else {
/* 197 */         MassWeddingRankInfo xMassWeddingRankInfo = Pod.newMassWeddingRankInfo();
/* 198 */         xMassWeddingRankInfo.setRoleida(chart.roleidA);
/* 199 */         xMassWeddingRankInfo.setRoleaoffer(chart.roleAPrice);
/* 200 */         xMassWeddingRankInfo.setRoleidb(chart.roleidB);
/* 201 */         xMassWeddingRankInfo.setRoleidboffer(chart.roleBPrice);
/* 202 */         xMassWeddingRankInfos.getMassweddingrankinfos().add(xMassWeddingRankInfo);
/* 203 */         xMassWeddingRankInfos.getRoleid2index().put(Long.valueOf(chart.roleidA), Integer.valueOf(i));
/* 204 */         i++;
/*     */       }
/* 206 */     Integer rank = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(groom));
/* 207 */     if (rank == null) {
/* 208 */       GameServer.logger().error(String.format("[MassWedding]PCMassWeddingSingUpReq.processImp@rank is null|groom=%d", new Object[] { Long.valueOf(groom) }));
/*     */       
/* 210 */       rank = Integer.valueOf(-1);
/*     */     }
/* 212 */     MassWeddingManager.asynSendMassWeddingSignUpInfo(java.util.Arrays.asList(new Long[] { Long.valueOf(groom), Long.valueOf(bride) }), this.myPrice, rank.intValue() + 1);
/* 213 */     SMassWeddingSignUpRes massWeddingSignUpRes = new SMassWeddingSignUpRes();
/* 214 */     massWeddingSignUpRes.myprice = this.myPrice;
/* 215 */     OnlineManager.getInstance().send(this.roleid, massWeddingSignUpRes);
/* 216 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRet(int ret, String... args) {
/* 220 */     SMassWeddingSignUpErrorRes massWeddingSignUpErrorRes = new SMassWeddingSignUpErrorRes();
/* 221 */     massWeddingSignUpErrorRes.result = ret;
/* 222 */     for (String arg : args) {
/* 223 */       massWeddingSignUpErrorRes.args.add(arg);
/*     */     }
/* 225 */     OnlineManager.getInstance().sendAtOnce(this.roleid, massWeddingSignUpErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCMassWeddingSingUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */