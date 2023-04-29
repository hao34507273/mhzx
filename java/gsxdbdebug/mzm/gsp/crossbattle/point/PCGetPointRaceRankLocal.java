/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.crossbattle.GetPointRaceDataReq;
/*     */ import mzm.gsp.crossbattle.GetZonePointRaceContext;
/*     */ import mzm.gsp.crossbattle.PointRaceRankData;
/*     */ import mzm.gsp.crossbattle.SGetPointRaceRankLocalFail;
/*     */ import mzm.gsp.crossbattle.SGetPointRaceRankLocalSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointConst;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetPointRaceRankLocal
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int zone;
/*     */   private final int index;
/*     */   private final int from;
/*     */   private final int to;
/*     */   
/*     */   public PCGetPointRaceRankLocal(long roleid, int activityCfgid, int zone, int index, int from, int to)
/*     */   {
/*  42 */     this.roleid = roleid;
/*     */     
/*  44 */     this.activityCfgid = activityCfgid;
/*  45 */     this.zone = zone;
/*  46 */     this.index = index;
/*  47 */     this.from = from;
/*  48 */     this.to = to;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if ((this.activityCfgid <= 0) || (this.zone <= 0) || (this.index < 0))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     if ((this.from <= 0) || (this.to <= 0))
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     if (this.from > this.to)
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  68 */     if (cfg == null)
/*     */     {
/*  70 */       onFailed(7);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!CrossBattlePointManager.canDoAction(this.roleid, 1443))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (!CrossBattlePointManager.isFunOpen(this.roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (this.zone > SCrossBattlePointConst.getInstance().ZONE_NUM)
/*     */     {
/*  87 */       onFailed(-1);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     int size = cfg.timePoints.size();
/*  92 */     if (this.index > size)
/*     */     {
/*  94 */       onFailed(-2);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  99 */     List<Integer> timePoints = new ArrayList();
/* 100 */     if (this.index > 0)
/*     */     {
/* 102 */       TimePointInfo timePointInfo = (TimePointInfo)cfg.timePoints.get(this.index - 1);
/* 103 */       int timePointCfgid = timePointInfo.timePoint;
/* 104 */       STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/* 105 */       if (timePointCommonCfg == null)
/*     */       {
/* 107 */         Map<String, Object> extras = new HashMap();
/* 108 */         extras.put("time_point", Integer.valueOf(timePointCfgid));
/* 109 */         onFailed(7, extras);
/* 110 */         return false;
/*     */       }
/* 112 */       long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg);
/* 113 */       if (startTime >= now)
/*     */       {
/* 115 */         onFailed(-3);
/* 116 */         return false;
/*     */       }
/* 118 */       if (startTime + TimeUnit.MINUTES.toMillis(cfg.durationInMinute - cfg.prepareDurationInMinute) > now)
/*     */       {
/* 120 */         onFailed(-4);
/* 121 */         return false;
/*     */       }
/* 123 */       timePoints.add(Integer.valueOf(timePointCfgid));
/*     */     }
/*     */     else
/*     */     {
/* 127 */       for (TimePointInfo timePointInfo : cfg.timePoints)
/*     */       {
/* 129 */         int timePointCfgid = timePointInfo.timePoint;
/* 130 */         STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/* 131 */         if (timePointCommonCfg != null)
/*     */         {
/*     */ 
/*     */ 
/* 135 */           long startTime = TimeCommonUtil.getTimePoint(timePointCommonCfg);
/* 136 */           if ((startTime < now) && 
/*     */           
/*     */ 
/*     */ 
/* 140 */             (startTime + TimeUnit.MINUTES.toMillis(cfg.durationInMinute - cfg.prepareDurationInMinute) <= now))
/*     */           {
/*     */ 
/*     */ 
/* 144 */             timePoints.add(Integer.valueOf(timePointCfgid)); }
/*     */         }
/*     */       }
/*     */     }
/* 148 */     if (timePoints.isEmpty())
/*     */     {
/* 150 */       onFailed(-4);
/* 151 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 155 */     QueryPointRaceInfo queryPointRaceInfo = new QueryPointRaceInfo(this.activityCfgid, this.zone, this.index);
/* 156 */     Pair<List<CorpsPointRaceInfo>, Long> pair = PointRaceRankLocal.getInstance().getChart(queryPointRaceInfo);
/* 157 */     if (pair != null)
/*     */     {
/* 159 */       List<CorpsPointRaceInfo> chart = (List)pair.first;
/* 160 */       long createTime = ((Long)pair.second).longValue();
/* 161 */       if ((chart != null) && (createTime + TimeUnit.MINUTES.toMillis(10L) > now))
/*     */       {
/* 163 */         SGetPointRaceRankLocalSuccess rsp = new SGetPointRaceRankLocalSuccess();
/* 164 */         int chartSize = chart.size();
/* 165 */         if (this.from <= chartSize)
/*     */         {
/* 167 */           int toIndex = this.to;
/* 168 */           if (this.to > chartSize)
/*     */           {
/* 170 */             toIndex = chartSize;
/*     */           }
/* 172 */           List<CorpsPointRaceInfo> chartObjs = chart.subList(this.from - 1, toIndex);
/* 173 */           List<PointRaceRankData> datas = CrossBattlePointManager.transToPointRaceRankDatas(chartObjs, this.from);
/*     */           
/* 175 */           rsp.point_race_ranks.addAll(datas);
/*     */         }
/*     */         
/* 178 */         rsp.activity_cfgid = this.activityCfgid;
/* 179 */         rsp.zone = this.zone;
/* 180 */         rsp.time_point_cfgid = this.index;
/* 181 */         rsp.from = this.from;
/* 182 */         rsp.to = this.to;
/* 183 */         OnlineManager.getInstance().send(this.roleid, rsp);
/*     */         
/* 185 */         GameServer.logger().info(String.format("[crossbattlepoint]PCGetPointRaceRankLocal.processImp@get data from chart|activity_cfgid=%d|zone=%d|time_point_index=%d|from=%d|to=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.zone), Integer.valueOf(this.index), Integer.valueOf(this.from), Integer.valueOf(this.to) }));
/*     */         
/*     */ 
/*     */ 
/* 189 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 193 */     GetZonePointRaceContext context = new GetZonePointRaceContext();
/* 194 */     context.oper_type = 1;
/*     */     
/* 196 */     GetPointRaceDataReq req = new GetPointRaceDataReq();
/* 197 */     req.time_points.addAll(timePoints);
/* 198 */     req.roleid = this.roleid;
/* 199 */     req.from = this.from;
/* 200 */     req.to = this.to;
/* 201 */     req.index = this.index;
/* 202 */     OctetsStream reqOs = new OctetsStream();
/* 203 */     req.marshal(reqOs);
/* 204 */     context.content = reqOs;
/*     */     
/* 206 */     OctetsStream contextOs = new OctetsStream();
/* 207 */     contextOs.marshal(context);
/* 208 */     if (!CrossServerInterface.asyncGetZonePointRace(this.activityCfgid, this.zone, contextOs))
/*     */     {
/* 210 */       onFailed(-5);
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     GameServer.logger().info(String.format("[crossbattlepoint]PCGetPointRaceRankLocal.processImp@get data from grc|activity_cfgid=%d|zone=%d|time_point_index=%d|from=%d|to=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.zone), Integer.valueOf(this.index), Integer.valueOf(this.from), Integer.valueOf(this.to) }));
/*     */     
/*     */ 
/*     */ 
/* 218 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 223 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 228 */     SGetPointRaceRankLocalFail rsp = new SGetPointRaceRankLocalFail();
/* 229 */     rsp.retcode = retcode;
/* 230 */     rsp.activity_cfgid = this.activityCfgid;
/* 231 */     rsp.zone = this.zone;
/* 232 */     rsp.time_point_cfgid = this.index;
/* 233 */     rsp.from = this.from;
/* 234 */     rsp.to = this.to;
/*     */     
/* 236 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 238 */     StringBuffer logBuilder = new StringBuffer();
/* 239 */     logBuilder.append("[crossbattlepoint]PCGetPointRaceRankLocal.onFailed@get failed");
/* 240 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 241 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 242 */     logBuilder.append('|').append("zone=").append(this.zone);
/* 243 */     logBuilder.append('|').append("index=").append(this.index);
/* 244 */     logBuilder.append('|').append("from=").append(this.from);
/* 245 */     logBuilder.append('|').append("to=").append(this.to);
/* 246 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 248 */     if (extraParams != null)
/*     */     {
/* 250 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 252 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 256 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PCGetPointRaceRankLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */