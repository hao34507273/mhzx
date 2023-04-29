/*     */ package mzm.gsp.countdown.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.countdown.SGetCountDownRedPacketFail;
/*     */ import mzm.gsp.countdown.SGetCountDownRedPacketSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CountDownInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCountDownInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2countdowninfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendRedPacketAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final int cfgid;
/*     */   private final int awardid;
/*     */   
/*     */   public PSendRedPacketAward(String userid, long roleid, int cfgid, int awardid)
/*     */   {
/*  29 */     this.userid = userid;
/*  30 */     this.roleid = roleid;
/*  31 */     this.cfgid = cfgid;
/*  32 */     this.awardid = awardid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!CountDownManager.isCountDownSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  46 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  48 */     RoleCountDownInfo xRoleCountDownInfo = Role2countdowninfo.get(Long.valueOf(this.roleid));
/*  49 */     if (xRoleCountDownInfo == null)
/*     */     {
/*  51 */       xRoleCountDownInfo = Pod.newRoleCountDownInfo();
/*  52 */       Role2countdowninfo.insert(Long.valueOf(this.roleid), xRoleCountDownInfo);
/*     */     }
/*  54 */     CountDownInfo xCountDownInfo = (CountDownInfo)xRoleCountDownInfo.getCount_down_infos().get(Integer.valueOf(this.cfgid));
/*  55 */     if (xCountDownInfo == null)
/*     */     {
/*  57 */       xCountDownInfo = Pod.newCountDownInfo();
/*  58 */       xRoleCountDownInfo.getCount_down_infos().put(Integer.valueOf(this.cfgid), xCountDownInfo);
/*     */     }
/*  60 */     if (xCountDownInfo.getGet_red_packet() == true)
/*     */     {
/*     */ 
/*  63 */       onGetCountDownRedPacketFail(1, null);
/*  64 */       return false;
/*     */     }
/*  66 */     if (!xCountDownInfo.getCan_get_red_packet())
/*     */     {
/*     */ 
/*  69 */       onGetCountDownRedPacketFail(2, null);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     AwardReason awardReason = new AwardReason(LogReason.COUNT_DOWN_RED_PACKET_AWARD, this.cfgid);
/*  74 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(this.awardid, this.userid, this.roleid, false, true, awardReason);
/*  75 */     if (awardModel == null)
/*     */     {
/*     */ 
/*  78 */       onGetCountDownRedPacketFail(3, null);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     xCountDownInfo.setGet_red_packet(true);
/*  83 */     SGetCountDownRedPacketSuccess protocol = new SGetCountDownRedPacketSuccess();
/*  84 */     protocol.cfg_id = this.cfgid;
/*  85 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  87 */     CountDownManager.logger.info(String.format("[countdown]PSendRedPacketAward.processImp@get red packet success|userid=%s|roleid=%d|cfgid=%d|awardid=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.cfgid), Integer.valueOf(this.awardid) }));
/*     */     
/*     */ 
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetCountDownRedPacketFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  95 */     StringBuilder sb = new StringBuilder();
/*  96 */     sb.append(String.format("[countdown]PSendRedPacketAward.processImp@get red packet fail|userid=%s|roleid=%d|cfgid=%d|awardid=%d|res=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.cfgid), Integer.valueOf(this.awardid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  99 */     if (extraInfo != null)
/*     */     {
/* 101 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 103 */         sb.append("|").append((String)entry.getKey());
/* 104 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 107 */     CountDownManager.logger.info(sb.toString());
/*     */     
/* 109 */     SGetCountDownRedPacketFail protocol = new SGetCountDownRedPacketFail();
/* 110 */     protocol.cfg_id = this.cfgid;
/* 111 */     protocol.res = res;
/* 112 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\PSendRedPacketAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */