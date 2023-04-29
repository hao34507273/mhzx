/*     */ package mzm.gsp.countdown.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.countdown.SGetCountDownRedPacketFail;
/*     */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CountDownInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCountDownInfo;
/*     */ import xtable.Role2countdowninfo;
/*     */ 
/*     */ public class PGetCountDownRedPacketReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int cfgid;
/*     */   
/*     */   public PGetCountDownRedPacketReq(long roleid, int cfgid)
/*     */   {
/*  22 */     this.roleid = roleid;
/*  23 */     this.cfgid = cfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     SCountDownCfg cfg = SCountDownCfg.get(this.cfgid);
/*  30 */     if (cfg == null)
/*     */     {
/*  32 */       return false;
/*     */     }
/*  34 */     if (!CountDownManager.isCountDownSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  37 */       CountDownManager.logger.info(String.format("[countdown]PGetCountDownRedPacketReq.processImp@module close or role forbidden|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  39 */       return false;
/*     */     }
/*  41 */     if (!CountDownManager.checkRoleStatus(this.roleid))
/*     */     {
/*     */ 
/*  44 */       CountDownManager.logger.info(String.format("[countdown]PGetCountDownRedPacketReq.processImp@role status error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     RoleCountDownInfo xRoleCountDownInfo = Role2countdowninfo.get(Long.valueOf(this.roleid));
/*  50 */     if (xRoleCountDownInfo == null)
/*     */     {
/*  52 */       xRoleCountDownInfo = Pod.newRoleCountDownInfo();
/*  53 */       Role2countdowninfo.insert(Long.valueOf(this.roleid), xRoleCountDownInfo);
/*     */     }
/*  55 */     CountDownInfo xCountDownInfo = (CountDownInfo)xRoleCountDownInfo.getCount_down_infos().get(Integer.valueOf(this.cfgid));
/*  56 */     if (xCountDownInfo == null)
/*     */     {
/*  58 */       xCountDownInfo = Pod.newCountDownInfo();
/*  59 */       xRoleCountDownInfo.getCount_down_infos().put(Integer.valueOf(this.cfgid), xCountDownInfo);
/*     */     }
/*  61 */     if (xCountDownInfo.getGet_red_packet() == true)
/*     */     {
/*  63 */       onGetCountDownRedPacketFail(1, null);
/*  64 */       return false;
/*     */     }
/*  66 */     long nowInSecond = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  67 */     if (!xCountDownInfo.getCan_get_red_packet())
/*     */     {
/*  69 */       if ((nowInSecond < cfg.festival_timestamp + cfg.festival_effect_play_time) || (nowInSecond > cfg.festival_timestamp + cfg.red_packet_valid_time))
/*     */       {
/*     */ 
/*     */ 
/*  73 */         onGetCountDownRedPacketFail(4, null);
/*  74 */         return false;
/*     */       }
/*  76 */       xCountDownInfo.setCan_get_red_packet(true);
/*     */     }
/*  78 */     CountDownOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.cfgid), new PSendRedPacketAward(RoleInterface.getUserId(this.roleid), this.roleid, this.cfgid, cfg.red_packet_award_id));
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetCountDownRedPacketFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  85 */     StringBuilder sb = new StringBuilder();
/*  86 */     sb.append(String.format("[countdown]PGetCountDownRedPacketReq.processImp@get red packet fail|roleid=%d|cfgid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.cfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  89 */     if (extraInfo != null)
/*     */     {
/*  91 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/*  93 */         sb.append("|").append((String)entry.getKey());
/*  94 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*  97 */     CountDownManager.logger.info(sb.toString());
/*     */     
/*  99 */     SGetCountDownRedPacketFail protocol = new SGetCountDownRedPacketFail();
/* 100 */     protocol.cfg_id = this.cfgid;
/* 101 */     protocol.res = res;
/* 102 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\PGetCountDownRedPacketReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */