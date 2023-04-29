/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.menpaistar.SWorldCanvassFailed;
/*     */ import mzm.gsp.menpaistar.SWorldCanvassSuccess;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Campaign;
/*     */ import xbean.MenPaiStarCampaignInfo;
/*     */ import xbean.MenPaiStarVoteInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCWorldCanvass extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final boolean useYuanbao;
/*     */   private final long clienYuanbao;
/*     */   private final Octets text;
/*     */   
/*     */   public PCWorldCanvass(long roleid, long targetRoleid, boolean useYuanbao, long clienYuanbao, Octets text)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.targetRoleid = targetRoleid;
/*  37 */     this.useYuanbao = useYuanbao;
/*  38 */     this.clienYuanbao = clienYuanbao;
/*  39 */     this.text = text;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (this.targetRoleid <= 0L)
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1009))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     long endTime = MenPaiStarConfigManager.voteEndTime();
/*  62 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  63 */     if (now >= endTime)
/*     */     {
/*     */ 
/*  66 */       Map<String, Object> extras = new HashMap();
/*  67 */       extras.put("end_time", Long.valueOf(endTime));
/*  68 */       onFailed(16, extras);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     int ocpid = RoleInterface.getOccupationId(this.targetRoleid);
/*  74 */     if (!CampaignChartManager.canJoin(ocpid))
/*     */     {
/*  76 */       Map<String, Object> extras = new HashMap();
/*  77 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  78 */       onFailed(-4, extras);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(ocpid, this.targetRoleid);
/*  84 */     if (chartObj == null)
/*     */     {
/*  86 */       onFailed(-6);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     String userid = RoleInterface.getUserId(this.roleid);
/*  91 */     if (userid == null)
/*     */     {
/*  93 */       onFailed(2);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     lock(Lockeys.get(User.getTable(), userid));
/*  99 */     lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/*     */ 
/* 102 */     if (this.useYuanbao)
/*     */     {
/* 104 */       long yuanbao = QingfuInterface.getBalance(userid, true);
/* 105 */       if (yuanbao < 0L)
/*     */       {
/* 107 */         Map<String, Object> extras = new HashMap();
/* 108 */         extras.put("userid", userid);
/* 109 */         extras.put("yuanbao", Long.valueOf(yuanbao));
/* 110 */         onFailed(2, extras);
/* 111 */         return false;
/*     */       }
/* 113 */       if (this.clienYuanbao != yuanbao)
/*     */       {
/* 115 */         Map<String, Object> extras = new HashMap();
/* 116 */         extras.put("yuanbao", Long.valueOf(yuanbao));
/* 117 */         onFailed(4, extras);
/* 118 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 123 */     MenPaiStarCampaignInfo xCampaignInfo = xtable.Role2menpaistarcampaign.get(Long.valueOf(this.targetRoleid));
/* 124 */     if (xCampaignInfo == null)
/*     */     {
/* 126 */       onFailed(-1);
/* 127 */       return false;
/*     */     }
/* 129 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 130 */     if (xCampaign == null)
/*     */     {
/* 132 */       Map<String, Object> extras = new HashMap();
/* 133 */       extras.put("occupationid", Integer.valueOf(ocpid));
/* 134 */       onFailed(-1, extras);
/* 135 */       return false;
/*     */     }
/* 137 */     if (xCampaign.getCampaign() != 1)
/*     */     {
/* 139 */       Map<String, Object> extras = new HashMap();
/* 140 */       extras.put("occupationid", Integer.valueOf(ocpid));
/* 141 */       extras.put("campaign", Integer.valueOf(xCampaign.getCampaign()));
/* 142 */       onFailed(-1, extras);
/* 143 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 147 */     MenPaiStarVoteInfo xVoteInfo = MenPaiStarManager.getAndInitXVoteInfo(this.roleid);
/* 148 */     Long lastCanvassTime = (Long)xVoteInfo.getWorld_canvass().get(Long.valueOf(this.targetRoleid));
/* 149 */     long period = TimeUnit.MINUTES.toMillis(SMenPaiStarConst.getInstance().WORLD_CHANNEL_CD);
/* 150 */     if ((lastCanvassTime != null) && (lastCanvassTime.longValue() + period > now))
/*     */     {
/* 152 */       Map<String, Object> extras = new HashMap();
/* 153 */       extras.put("last_canvass_time", lastCanvassTime);
/* 154 */       onFailed(-2, extras);
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     int trumpetCfgid = SMenPaiStarConst.getInstance().TRUMPET_CFG_ID;
/* 159 */     if (!ChatInterface.chatInTrumpet(userid, this.roleid, trumpetCfgid, 2, this.text))
/*     */     {
/* 161 */       Map<String, Object> extras = new HashMap();
/* 162 */       String text = this.text.getString("UTF-8");
/* 163 */       extras.put("text", text);
/* 164 */       onFailed(1, extras);
/* 165 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 169 */     xVoteInfo.getWorld_canvass().put(Long.valueOf(this.targetRoleid), Long.valueOf(now));
/*     */     
/*     */ 
/* 172 */     MenPaiStarManager.addTLog(this.roleid, "MenPaiStarWorldCanvassForServer", new Object[] { Integer.valueOf(this.useYuanbao ? 1 : 0), Integer.valueOf(trumpetCfgid), Integer.valueOf(ocpid), Long.valueOf(this.targetRoleid) });
/*     */     
/*     */ 
/* 175 */     SWorldCanvassSuccess rsp = new SWorldCanvassSuccess();
/* 176 */     rsp.target_roleid = this.targetRoleid;
/* 177 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 179 */     GameServer.logger().info(String.format("[menpaistar]PCWorldCanvass.processImp@world canvass success|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/*     */ 
/* 182 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 187 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 192 */     SWorldCanvassFailed rsp = new SWorldCanvassFailed();
/* 193 */     rsp.target_roleid = this.targetRoleid;
/* 194 */     rsp.use_yuanbao = ((byte)(this.useYuanbao ? 1 : 0));
/* 195 */     rsp.client_yuanbao = this.clienYuanbao;
/* 196 */     rsp.text = this.text;
/* 197 */     rsp.retcode = retcode;
/* 198 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 200 */     StringBuffer logBuilder = new StringBuffer();
/* 201 */     logBuilder.append("[menpaistar]PCWorldCanvass.onFailed@world canvass failed");
/* 202 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 203 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 204 */     logBuilder.append('|').append("use_yuanbao=").append(this.useYuanbao);
/* 205 */     logBuilder.append('|').append("client_yuanbao=").append(this.clienYuanbao);
/* 206 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 208 */     if (extraParams != null)
/*     */     {
/* 210 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 212 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 216 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCWorldCanvass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */