/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossfield.CrossFieldRankData;
/*     */ import mzm.gsp.crossfield.GetCrossFieldRankContext;
/*     */ import mzm.gsp.crossfield.GetCrossFieldRank_ClientReq;
/*     */ import mzm.gsp.crossfield.SGetCrossFieldRankFail;
/*     */ import mzm.gsp.crossfield.SGetCrossFieldRankSuccess;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetCrossFieldRank
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int rankType;
/*     */   private final int startPos;
/*     */   private final int num;
/*     */   
/*     */   public PCGetCrossFieldRank(long roleid, int rankType, int startPos, int num)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.rankType = rankType;
/*  37 */     this.startPos = startPos;
/*  38 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if ((this.startPos <= 0) || (this.num <= 0))
/*     */     {
/*     */ 
/*  47 */       onFail(-3, null);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!CrossFieldManager.isCrossFieldSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  53 */       onFail(-1, null);
/*  54 */       return false;
/*     */     }
/*  56 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1582, true))
/*     */     {
/*     */ 
/*  59 */       onFail(-2, null);
/*  60 */       return false;
/*     */     }
/*  62 */     int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/*  63 */     if (currentSeason <= 0)
/*     */     {
/*  65 */       onFail(8, null);
/*  66 */       return false;
/*     */     }
/*  68 */     switch (this.rankType)
/*     */     {
/*     */ 
/*     */     case 39: 
/*  72 */       List<SingleCrossFieldChartObj> chartObjs = SingleCrossFieldChartManager.getInstance().getchartObjs(this.startPos - 1, this.startPos - 1 + this.num - 1);
/*     */       
/*  74 */       SGetCrossFieldRankSuccess protocol = new SGetCrossFieldRankSuccess();
/*  75 */       protocol.rank_type = this.rankType;
/*  76 */       for (int i = 0; i < chartObjs.size(); i++)
/*     */       {
/*  78 */         SingleCrossFieldChartObj chartObj = (SingleCrossFieldChartObj)chartObjs.get(i);
/*  79 */         CrossFieldRankData rankData = new CrossFieldRankData();
/*  80 */         rankData.rank = (this.startPos + i);
/*  81 */         rankData.roleid = chartObj.getRoleid();
/*  82 */         rankData.name.setString(RoleInterface.getName(rankData.roleid), "UTF-8");
/*  83 */         rankData.occupation = RoleInterface.getOccupationId(rankData.roleid);
/*  84 */         rankData.star_num = chartObj.getStarNum();
/*  85 */         rankData.timestamp = ((int)(chartObj.getTimestamp() / 1000L));
/*  86 */         protocol.rank_list.add(rankData);
/*     */       }
/*  88 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/*  90 */       CrossFieldManager.logger.info(String.format("[crossfield]PCGetCrossFieldRank.processImp@get single cross field rank success|roleid=%d|rank_type=%d|start_pos=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rankType), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*     */       
/*     */ 
/*  93 */       return true;
/*     */     
/*     */ 
/*     */     case 40: 
/*  97 */       GetCrossFieldRankContext context = new GetCrossFieldRankContext();
/*  98 */       context.oper_type = 0;
/*  99 */       context.count = 1;
/* 100 */       context.extra_info.replace(new GetCrossFieldRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/* 101 */       if (!CrossServerInterface.getSingleCrossFieldRankRange(currentSeason, this.startPos - 1, this.startPos - 1 + this.num - 1, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/* 105 */         onFail(9, null);
/* 106 */         return false;
/*     */       }
/* 108 */       CrossFieldManager.logger.info(String.format("[crossfield]PCGetRoleCrossFieldRank.processImp@get single cross field rank from grc|roleid=%d|rank_type=%d|rankid=%d|start_pos=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rankType), Integer.valueOf(currentSeason), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*     */       
/*     */ 
/* 111 */       return true;
/*     */     }
/*     */     
/*     */     
/* 115 */     onFail(-3, null);
/* 116 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 123 */     StringBuilder sb = new StringBuilder();
/* 124 */     sb.append(String.format("[crossfield]PCGetCrossFieldRank.processImp@get single cross field rank fail|roleid=%d|rank_type=%d|start_pos=%d|num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rankType), Integer.valueOf(this.startPos), Integer.valueOf(this.num), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 127 */     if (extraInfo != null)
/*     */     {
/* 129 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 131 */         sb.append("|").append((String)entry.getKey());
/* 132 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 135 */     CrossFieldManager.logger.info(sb.toString());
/* 136 */     if (res > 0)
/*     */     {
/* 138 */       SGetCrossFieldRankFail protocol = new SGetCrossFieldRankFail();
/* 139 */       protocol.res = res;
/* 140 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PCGetCrossFieldRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */