/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.MarqueeDataInfo;
/*     */ import mzm.gsp.idip.main.MarqueeInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class UpdateMarqueeHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  20 */     long beginTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(0)));
/*  21 */     long endTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(1)));
/*  22 */     String content = (String)params.get(2);
/*  23 */     int rollFre = Integer.parseInt((String)params.get(3));
/*  24 */     int rollNum = Integer.parseInt((String)params.get(4));
/*  25 */     long indexId = Long.parseLong((String)params.get(5));
/*     */     
/*  27 */     if (beginTime < 0L)
/*     */     {
/*  29 */       int retcode = Retcode.UPDATE_MARQUEE_BEGIN_TIME_LESS_THAN_ZERO.value;
/*  30 */       rsp.retcode = retcode;
/*  31 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time < 0");
/*  32 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  34 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@begin time < 0|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/*  38 */       return;
/*     */     }
/*     */     
/*  41 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  42 */     if (endTime <= now)
/*     */     {
/*  44 */       int retcode = Retcode.UPDATE_MARQUEE_END_TIME_LESS_THAN_NOW.value;
/*  45 */       rsp.retcode = retcode;
/*  46 */       Response response = IdipGmtUtil.getResponse(retcode, "end time <= now");
/*  47 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  49 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@end time <= now|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/*  53 */       return;
/*     */     }
/*     */     
/*  56 */     if (beginTime >= endTime)
/*     */     {
/*  58 */       int retcode = Retcode.UPDATE_MARQUEE_BEGIN_TIME_GREATER_THAN_END_TIME.value;
/*  59 */       rsp.retcode = retcode;
/*  60 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time >= end time");
/*  61 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  63 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@begin time >= end time|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     if (content.isEmpty())
/*     */     {
/*  72 */       int retcode = Retcode.UPDATE_MARQUEE_CONTENT_IS_EMPTY.value;
/*  73 */       rsp.retcode = retcode;
/*  74 */       Response response = IdipGmtUtil.getResponse(retcode, "content is empty");
/*  75 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  77 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@content is empty|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/*  81 */       return;
/*     */     }
/*  83 */     if (content.length() > 3200)
/*     */     {
/*  85 */       int retcode = Retcode.UPDATE_MARQUEE_CONTENT_TOO_LONG.value;
/*  86 */       rsp.retcode = retcode;
/*  87 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("content length > %d", new Object[] { Integer.valueOf(3200) }));
/*     */       
/*  89 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  91 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@content length > MAX_MARQUEE_CONTENT_LEN|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/*  95 */       return;
/*     */     }
/*     */     
/*  98 */     if (rollFre <= 0)
/*     */     {
/* 100 */       int retcode = Retcode.UPDATE_MARQUEE_ROLL_FRE_INVALID.value;
/* 101 */       rsp.retcode = retcode;
/* 102 */       Response response = IdipGmtUtil.getResponse(retcode, "roll_fre <= 0");
/* 103 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 105 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@rollfre <= 0|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/* 109 */       return;
/*     */     }
/*     */     
/*     */ 
/* 113 */     if ((rollNum == 0) || (rollNum < -1))
/*     */     {
/* 115 */       int retcode = Retcode.UPDATE_MARQUEE_ROLL_NUM_INVALID.value;
/* 116 */       rsp.retcode = retcode;
/* 117 */       Response response = IdipGmtUtil.getResponse(retcode, "roll_num invalid");
/* 118 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 120 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@rollNum == 0 OR rollNum < -1|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/* 124 */       return;
/*     */     }
/*     */     
/* 127 */     Long marqueeId = MarqueeInterface.getMarqueeid(indexId);
/* 128 */     if (marqueeId == null)
/*     */     {
/* 130 */       int retcode = Retcode.UPDATE_MARQUEE_NOT_EXIST.value;
/* 131 */       rsp.retcode = retcode;
/* 132 */       Response response = IdipGmtUtil.getResponse(retcode, "marquee not exist");
/* 133 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 135 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@marquee not exist|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */       
/*     */ 
/*     */ 
/* 139 */       return;
/*     */     }
/*     */     
/*     */ 
/* 143 */     String title = "";
/* 144 */     MarqueeDataInfo newMarquee = new MarqueeDataInfo(beginTime, endTime, "", content, rollFre, rollNum, indexId);
/* 145 */     newMarquee.setMarqueeId(marqueeId.longValue());
/* 146 */     boolean success = MarqueeInterface.updateMarquee(marqueeId.longValue(), newMarquee);
/* 147 */     if (!success)
/*     */     {
/* 149 */       int retcode = Retcode.UPDATE_MARQUEE_FAILED.value;
/* 150 */       rsp.retcode = retcode;
/* 151 */       Response response = IdipGmtUtil.getResponse(retcode, "marquee not exist");
/* 152 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 154 */       GameServer.logger().error(String.format("[gmt]UpdateMarqueeHandler.execute@marquee not exist|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d|marqueeid=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId), marqueeId }));
/*     */       
/*     */ 
/*     */ 
/* 158 */       return;
/*     */     }
/*     */     
/* 161 */     String retDesc = "";
/* 162 */     if (beginTime <= now)
/*     */     {
/* 164 */       retDesc = "跑马灯已经生效";
/*     */     }
/*     */     else
/*     */     {
/* 168 */       retDesc = String.format("跑马灯将于%s生效，现在时间%s", new Object[] { DateTimeUtils.formatTimestamp(beginTime), DateTimeUtils.formatTimestamp(now) });
/*     */     }
/*     */     
/*     */ 
/* 172 */     rsp.retcode = Retcode.SUCCESS.value;
/* 173 */     Response response = new Response();
/* 174 */     response.msg = retDesc;
/* 175 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 177 */     GameServer.logger().info(String.format("[gmt]UpdateMarqueeHandler.execute@update marquee done|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d|marqueeid=%d", new Object[] { Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId), marqueeId }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\UpdateMarqueeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */