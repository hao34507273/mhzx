/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossfield.GetRoleCrossFieldRankContext;
/*     */ import mzm.gsp.crossfield.GetRoleCrossFieldRank_ClientReq;
/*     */ import mzm.gsp.crossfield.SGetRoleCrossFieldRankFail;
/*     */ import mzm.gsp.crossfield.SGetRoleCrossFieldRankSuccess;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetRoleCrossFieldRank
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int rankType;
/*     */   
/*     */   public PCGetRoleCrossFieldRank(long roleid, int rankType)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.rankType = rankType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!CrossFieldManager.isCrossFieldSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  40 */       onFail(-1, null);
/*  41 */       return false;
/*     */     }
/*  43 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1582, true))
/*     */     {
/*     */ 
/*  46 */       onFail(-2, null);
/*  47 */       return false;
/*     */     }
/*  49 */     int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/*  50 */     if (currentSeason <= 0)
/*     */     {
/*  52 */       onFail(8, null);
/*  53 */       return false;
/*     */     }
/*  55 */     switch (this.rankType)
/*     */     {
/*     */ 
/*     */     case 39: 
/*  59 */       SGetRoleCrossFieldRankSuccess protocol = new SGetRoleCrossFieldRankSuccess();
/*  60 */       protocol.rank_type = this.rankType;
/*  61 */       protocol.rank = (SingleCrossFieldChartManager.getInstance().getRank(this.roleid) + 1);
/*  62 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*  63 */       CrossFieldManager.logger.info(String.format("[crossfield]PCGetRoleCrossFieldRank.processImp@get role single cross field rank success|roleid=%d|rank_type=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rankType), Integer.valueOf(protocol.rank) }));
/*     */       
/*     */ 
/*  66 */       return true;
/*     */     
/*     */ 
/*     */     case 40: 
/*  70 */       GetRoleCrossFieldRankContext context = new GetRoleCrossFieldRankContext();
/*  71 */       context.oper_type = 0;
/*  72 */       context.count = 1;
/*  73 */       context.extra_info.replace(new GetRoleCrossFieldRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/*  74 */       if (!CrossServerInterface.getRoleSingleCrossFieldRankInfo(currentSeason, this.roleid, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/*  78 */         onFail(9, null);
/*  79 */         return false;
/*     */       }
/*  81 */       CrossFieldManager.logger.info(String.format("[crossfield]PCGetRoleCrossFieldRank.processImp@get role single cross field rank from grc|roleid=%d|rank_type=%d|rankid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rankType), Integer.valueOf(currentSeason) }));
/*     */       
/*     */ 
/*  84 */       return true;
/*     */     }
/*     */     
/*     */     
/*  88 */     onFail(-3, null);
/*  89 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  96 */     StringBuilder sb = new StringBuilder();
/*  97 */     sb.append(String.format("[crossfield]PCGetRoleCrossFieldRank.processImp@get role single cross field rank fail|roleid=%d|rank_type=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rankType), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 100 */     if (extraInfo != null)
/*     */     {
/* 102 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 104 */         sb.append("|").append((String)entry.getKey());
/* 105 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 108 */     CrossFieldManager.logger.info(sb.toString());
/* 109 */     if (res > 0)
/*     */     {
/* 111 */       SGetRoleCrossFieldRankFail protocol = new SGetRoleCrossFieldRankFail();
/* 112 */       protocol.res = res;
/* 113 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PCGetRoleCrossFieldRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */