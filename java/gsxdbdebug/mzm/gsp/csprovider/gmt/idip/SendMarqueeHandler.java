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
/*     */ public class SendMarqueeHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  19 */     long indexId = Long.parseLong((String)params.get(0));
/*  20 */     long beginTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(1)));
/*  21 */     long endTime = TimeUnit.SECONDS.toMillis(Long.parseLong((String)params.get(2)));
/*  22 */     String content = (String)params.get(3);
/*  23 */     int rollFre = Integer.parseInt((String)params.get(4));
/*  24 */     int rollNum = Integer.parseInt((String)params.get(5));
/*     */     
/*  26 */     if (MarqueeInterface.contains(indexId))
/*     */     {
/*  28 */       int retcode = Retcode.SEND_MARQUEE_ID_DUPLICATED.value;
/*  29 */       rsp.retcode = retcode;
/*  30 */       Response response = IdipGmtUtil.getResponse(retcode, "marqueeid duplicated");
/*  31 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  33 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@index_id duplicated|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/*  37 */       return;
/*     */     }
/*     */     
/*  40 */     if (indexId <= 0L)
/*     */     {
/*  42 */       int retcode = Retcode.SEND_MARQUEE_ID_LESS_THAN_ZERO.value;
/*  43 */       rsp.retcode = retcode;
/*  44 */       Response response = IdipGmtUtil.getResponse(retcode, "marqueeid <= 0");
/*  45 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  47 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@index_id <= 0|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/*  51 */       return;
/*     */     }
/*     */     
/*  54 */     if (beginTime < 0L)
/*     */     {
/*  56 */       int retcode = Retcode.SEND_MARQUEE_BEGIN_TIME_LESS_THAN_ZERO.value;
/*  57 */       rsp.retcode = retcode;
/*  58 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time < 0");
/*  59 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  61 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@begin time < 0|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return;
/*     */     }
/*     */     
/*  68 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  69 */     if (endTime <= now)
/*     */     {
/*  71 */       int retcode = Retcode.SEND_MARQUEE_END_TIME_LESS_THAN_NOW.value;
/*  72 */       rsp.retcode = retcode;
/*  73 */       Response response = IdipGmtUtil.getResponse(retcode, "end time <= now");
/*  74 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  76 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@end time <= now|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/*  80 */       return;
/*     */     }
/*     */     
/*  83 */     if (beginTime >= endTime)
/*     */     {
/*  85 */       int retcode = Retcode.SEND_MARQUEE_BEGIN_TIME_GREATER_THAN_END_TIME.value;
/*  86 */       rsp.retcode = retcode;
/*  87 */       Response response = IdipGmtUtil.getResponse(retcode, "begin time >= end time");
/*  88 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  90 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@begin time >= end time|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/*  94 */       return;
/*     */     }
/*     */     
/*  97 */     if (content.isEmpty())
/*     */     {
/*  99 */       int retcode = Retcode.SEND_MARQUEE_CONTENT_IS_EMPTY.value;
/* 100 */       rsp.retcode = retcode;
/* 101 */       Response response = IdipGmtUtil.getResponse(retcode, "contnet is empty");
/* 102 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 104 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@content is empty|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/* 108 */       return;
/*     */     }
/*     */     
/* 111 */     if (content.length() > 3200)
/*     */     {
/* 113 */       int retcode = Retcode.SEND_MARQUEE_CONTENT_TOO_LONG.value;
/* 114 */       rsp.retcode = retcode;
/* 115 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("content length > %d", new Object[] { Integer.valueOf(3200) }));
/*     */       
/* 117 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 119 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@content length > MAX_MARQUEE_CONTENT_LEN|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/* 123 */       return;
/*     */     }
/*     */     
/* 126 */     if (rollFre <= 0)
/*     */     {
/* 128 */       int retcode = Retcode.SEND_MARQUEE_ROLL_FRE_INVALID.value;
/* 129 */       rsp.retcode = retcode;
/* 130 */       Response response = IdipGmtUtil.getResponse(retcode, "roll_fre <= 0");
/* 131 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 133 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@roll_fre <= 0|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/* 137 */       return;
/*     */     }
/*     */     
/*     */ 
/* 141 */     if ((rollNum <= 0) && (rollNum != -1))
/*     */     {
/* 143 */       int retcode = Retcode.SEND_MARQUEE_ROLL_NUM_INVALID.value;
/* 144 */       rsp.retcode = retcode;
/* 145 */       Response response = IdipGmtUtil.getResponse(retcode, "roll_num invalid");
/* 146 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 148 */       GameServer.logger().error(String.format("[gmt]SendMarqueeHandler.execute@roll_num invalid|index_id=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d", new Object[] { Long.valueOf(indexId), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum) }));
/*     */       
/*     */ 
/*     */ 
/* 152 */       return;
/*     */     }
/*     */     
/* 155 */     MarqueeDataInfo marquee = new MarqueeDataInfo(beginTime, endTime, "", content, rollFre, rollNum, indexId);
/* 156 */     MarqueeInterface.addMarquee(marquee);
/*     */     
/* 158 */     String retDesc = "";
/* 159 */     if (beginTime <= now)
/*     */     {
/* 161 */       retDesc = "跑马灯已经生效";
/*     */     }
/*     */     else
/*     */     {
/* 165 */       retDesc = String.format("跑马灯将于%s生效，现在时间%s", new Object[] { DateTimeUtils.formatTimestamp(beginTime), DateTimeUtils.formatTimestamp(now) });
/*     */     }
/*     */     
/*     */ 
/* 169 */     rsp.retcode = Retcode.SUCCESS.value;
/* 170 */     Response response = new Response();
/* 171 */     response.msg = retDesc;
/* 172 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 174 */     GameServer.logger().info(String.format("[gmt]SendMarqueeHandler.execute@do send marquee done|marqueeid=%d|begin_time=%d|end_time=%d|content=%s|roll_fre=%d|roll_num=%d|index_id=%d", new Object[] { Long.valueOf(marquee.getMarqueeId()), Long.valueOf(beginTime), Long.valueOf(endTime), content, Integer.valueOf(rollFre), Integer.valueOf(rollNum), Long.valueOf(indexId) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\SendMarqueeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */