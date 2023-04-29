/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.PopularityRankData;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.friendscircle.SWeekPopularityChartRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class PCWeekPopularityChartReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fromOrder;
/*     */   private final int toOrder;
/*     */   
/*     */   public PCWeekPopularityChartReq(long roleId, int startPos, int toOrder)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.fromOrder = startPos;
/*  31 */     this.toOrder = toOrder;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if ((this.fromOrder <= 0) || (this.toOrder <= 0) || (this.toOrder < this.fromOrder))
/*     */     {
/*  39 */       onWeekPopularityChartReqFail(43);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/*  45 */       onWeekPopularityChartReqFail(1);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 469, true))
/*     */     {
/*  51 */       onWeekPopularityChartReqFail(52);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1826, true))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     SWeekPopularityChartRes sWeekPopularityChartRes = new SWeekPopularityChartRes();
/*  62 */     sWeekPopularityChartRes.current_week_popularity_value = FriendsCircleManager.getWeekPopularityValue(this.roleId, false);
/*  63 */     sWeekPopularityChartRes.my_rank = (FriendsCicrlePopularityRankManager.getInstance().getRank(Long.valueOf(this.roleId)) + 1);
/*     */     
/*  65 */     sWeekPopularityChartRes.rank_list.addAll(getRankData(this.fromOrder - 1, this.toOrder - 1));
/*     */     
/*  67 */     OnlineManager.getInstance().send(this.roleId, sWeekPopularityChartRes);
/*     */     
/*  69 */     return true;
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
/*     */   private List<PopularityRankData> getRankData(int fromOrder, int toOrder)
/*     */     throws UnsupportedEncodingException
/*     */   {
/*  85 */     List<PopularityRankData> popularityRankDataList = new ArrayList();
/*     */     
/*  87 */     List<FriendsCicrlePopularityChart> popularityRankChartList = FriendsCicrlePopularityRankManager.getInstance().getRankObjs(fromOrder, toOrder);
/*     */     
/*  89 */     int startRank = fromOrder;
/*  90 */     for (FriendsCicrlePopularityChart friendsCicrlePopularityChart : popularityRankChartList)
/*     */     {
/*  92 */       long roleId = friendsCicrlePopularityChart.getRoleid();
/*  93 */       PopularityRankData popularityRankData = new PopularityRankData();
/*  94 */       popularityRankData.roleid = roleId;
/*  95 */       popularityRankData.popularity_value = friendsCicrlePopularityChart.getPopularityValue();
/*     */       
/*  97 */       popularityRankData.name.setString(RoleInterface.getName(roleId), "UTF-8");
/*  98 */       popularityRankData.rank = (++startRank);
/*  99 */       popularityRankData.occupation_id = RoleInterface.getOccupationId(roleId);
/*     */       
/* 101 */       popularityRankDataList.add(popularityRankData);
/*     */     }
/* 103 */     return popularityRankDataList;
/*     */   }
/*     */   
/*     */   private void onWeekPopularityChartReqFail(int ret)
/*     */   {
/* 108 */     onWeekPopularityChartReqFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onWeekPopularityChartReqFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 113 */     StringBuilder sbLog = new StringBuilder();
/* 114 */     sbLog.append("[friendscircle]PCWeekPopularityChartReq.processImp@get week popularity chart req failed");
/* 115 */     sbLog.append("|ret=").append(ret);
/* 116 */     sbLog.append("|role_id=").append(this.roleId);
/* 117 */     sbLog.append("|from_order=").append(this.fromOrder);
/* 118 */     sbLog.append("|to_order=").append(this.toOrder);
/*     */     
/* 120 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 122 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 124 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 127 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 129 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 130 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 132 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCWeekPopularityChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */