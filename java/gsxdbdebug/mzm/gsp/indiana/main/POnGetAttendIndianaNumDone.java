/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.grc.event.GetAttendIndianaNumDoneArg;
/*     */ import mzm.gsp.grc.event.GetAttendIndianaNumDoneProcedure;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class POnGetAttendIndianaNumDone extends GetAttendIndianaNumDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  27 */     SIndianaCfg cfg = SIndianaCfg.get(((GetAttendIndianaNumDoneArg)this.arg).getActivityCfgid());
/*  28 */     if (cfg == null)
/*     */     {
/*     */ 
/*  31 */       onFail(-3, null);
/*  32 */       return false;
/*     */     }
/*  34 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getTurn()));
/*  35 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  38 */       onFail(-3, null);
/*  39 */       return false;
/*     */     }
/*  41 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getSortid()));
/*  42 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  45 */       onFail(-3, null);
/*  46 */       return false;
/*     */     }
/*  48 */     if (!((GetAttendIndianaNumDoneArg)this.arg).isSucceed())
/*     */     {
/*     */ 
/*  51 */       Map<String, Object> extraInfo = new HashMap();
/*  52 */       extraInfo.put("retcode", Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getRetCode()));
/*  53 */       onFail(((GetAttendIndianaNumDoneArg)this.arg).isTimeout() ? 11 : 12, extraInfo);
/*  54 */       return false;
/*     */     }
/*  56 */     OctetsStream result = OctetsStream.wrap(((GetAttendIndianaNumDoneArg)this.arg).getResult());
/*  57 */     int attendNum = result.unmarshal_int();
/*     */     
/*     */ 
/*  60 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(((GetAttendIndianaNumDoneArg)this.arg).getActivityCfgid());
/*  61 */     lock(Indiana_infos.getTable(), Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  62 */     IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  63 */     if (xIndianaInfo == null)
/*     */     {
/*  65 */       xIndianaInfo = Pod.newIndianaInfo();
/*  66 */       Indiana_infos.insert(Long.valueOf(globalActivityCfgid), xIndianaInfo);
/*     */     }
/*  68 */     IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getTurn()));
/*  69 */     if (xIndianaTurnInfo == null)
/*     */     {
/*  71 */       xIndianaTurnInfo = Pod.newIndianaTurnInfo();
/*  72 */       xIndianaInfo.getTurn_infos().put(Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getTurn()), xIndianaTurnInfo);
/*     */     }
/*  74 */     IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getSortid()));
/*  75 */     if (xIndianaAwardInfo == null)
/*     */     {
/*  77 */       xIndianaAwardInfo = Pod.newIndianaAwardInfo();
/*  78 */       xIndianaTurnInfo.getAward_infos().put(Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getSortid()), xIndianaAwardInfo);
/*     */     }
/*  80 */     xIndianaAwardInfo.setAttend_role_num(attendNum);
/*  81 */     xIndianaAwardInfo.setAttend_role_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*  83 */     GameServer.logger().info(String.format("[indiana]POnGetAttendIndianaNumDone.processImp@get attend indiana number done process success|activity_cfg_id=%d|turn=%d|sortid=%d|attend_role_num=%d", new Object[] { Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getTurn()), Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getSortid()), Integer.valueOf(attendNum) }));
/*     */     
/*     */ 
/*     */ 
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  92 */     StringBuilder sb = new StringBuilder();
/*  93 */     sb.append(String.format("[indiana]POnGetAttendIndianaNumDone.processImp@get attend indiana number done process fail|activity_cfg_id=%d|turn=%d|sortid=%d|res=%d", new Object[] { Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getTurn()), Integer.valueOf(((GetAttendIndianaNumDoneArg)this.arg).getSortid()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  96 */     if (extraInfo != null)
/*     */     {
/*  98 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 100 */         sb.append("|").append((String)entry.getKey());
/* 101 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 104 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\POnGetAttendIndianaNumDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */