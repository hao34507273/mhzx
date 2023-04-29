/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SYuanBao2banggongRes;
/*     */ import mzm.gsp.gang.confbean.SBangGongYuanBaoRedeemCfg;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2gangmember;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCYuanBao2banggongReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int yuanBao;
/*     */   private final long clientYuanBao;
/*     */   
/*     */   public PCYuanBao2banggongReq(long roleId, int yuanBao, long clientYuanBao)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.yuanBao = yuanBao;
/*  40 */     this.clientYuanBao = clientYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!isYuanBao2BangGongSwitchOpen(this.roleId))
/*     */     {
/*  48 */       onFail(331);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     String userId = RoleInterface.getUserId(this.roleId);
/*  53 */     if (userId == null)
/*     */     {
/*  55 */       onFail(333);
/*  56 */       return false;
/*     */     }
/*  58 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  60 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1911, true, true))
/*     */     {
/*  62 */       onFail(61);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*  68 */     if (xGangMember == null)
/*     */     {
/*  70 */       onFail(45);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     long gangId = xGangMember.getGangid();
/*     */     
/*  76 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  77 */     if (xGang == null)
/*     */     {
/*  79 */       onFail(57);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (!GangManager.isInGang(xGang, this.roleId))
/*     */     {
/*  85 */       onFail(58);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (GangManager.getDiffDay(xGangMember.getJointime(), DateTimeUtils.getCurrTimeInMillis()) < SGangConst.getInstance().REDEEM_BANGGONG_NEED_JOIN_DAY)
/*     */     {
/*  91 */       onFail(43);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     SBangGongYuanBaoRedeemCfg sBangGongYuanBaoRedeemCfg = SBangGongYuanBaoRedeemCfg.get(this.yuanBao);
/*  96 */     if (sBangGongYuanBaoRedeemCfg == null)
/*     */     {
/*  98 */       onFail(334);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     long serverYuanBao = QingfuInterface.getBalance(userId, true);
/* 103 */     if (serverYuanBao != this.clientYuanBao)
/*     */     {
/* 105 */       onFail(334);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if (this.yuanBao > serverYuanBao)
/*     */     {
/* 111 */       onFail(59);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     int nowYuanBaoRedeemBangGong = xGangMember.getYuanbao_redeem_bang_gong();
/* 116 */     if (nowYuanBaoRedeemBangGong > SGangConst.getInstance().yuanbao_2_bang_gong_limit)
/*     */     {
/* 118 */       onFail(335);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     int nowTotalYuanBaoRedeemBanggong = nowYuanBaoRedeemBangGong + sBangGongYuanBaoRedeemCfg.redeem_bang_gong;
/* 123 */     if (nowTotalYuanBaoRedeemBanggong > SGangConst.getInstance().yuanbao_2_bang_gong_limit)
/*     */     {
/* 125 */       onFail(336);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, this.yuanBao, CostType.COST_BIND_FIRST_BANG_GONG_CHANGE, new TLogArg(LogReason.GANG_BANG_GONG_YUAN_BAO_CHANG_COST));
/*     */     
/* 131 */     if (costResult != CostResult.Success)
/*     */     {
/* 133 */       Map<String, Object> extraMap = new HashMap();
/* 134 */       extraMap.put("code", Integer.valueOf(costResult.code));
/* 135 */       extraMap.put("desc", costResult.desc);
/*     */       
/* 137 */       onFail(60, extraMap);
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     ModBangGongResult modBangGongResult = GangInterface.addBangGongWithinMax(this.roleId, sBangGongYuanBaoRedeemCfg.redeem_bang_gong, new TLogArg(LogReason.GANG_BANG_GONG_YUAN_BAO_CHANG));
/*     */     
/* 143 */     if (!modBangGongResult.isSucceed())
/*     */     {
/* 145 */       if (modBangGongResult.getRes() == ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT)
/*     */       {
/* 147 */         SGangNormalResult result = new SGangNormalResult();
/* 148 */         result.result = 52;
/* 149 */         OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*     */       }
/*     */       
/* 152 */       Map<String, Object> extraMap = new HashMap();
/* 153 */       extraMap.put("ret", Integer.valueOf(modBangGongResult.getRes().ordinal()));
/* 154 */       extraMap.put("desc", modBangGongResult.getRes().name());
/* 155 */       onFail(52, extraMap);
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     xGangMember.setYuanbao_redeem_bang_gong(nowTotalYuanBaoRedeemBanggong);
/* 160 */     xGangMember.setNextupdateredeemtimestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/* 163 */     tlogYuanBaoExchangeBanggong(userId, sBangGongYuanBaoRedeemCfg.redeem_bang_gong, nowTotalYuanBaoRedeemBanggong);
/*     */     
/* 165 */     SYuanBao2banggongRes sYuanBao2banggongRes = new SYuanBao2banggongRes();
/* 166 */     sYuanBao2banggongRes.yuan_bao = this.yuanBao;
/* 167 */     sYuanBao2banggongRes.yuan_bao_to_banggong_total = nowTotalYuanBaoRedeemBanggong;
/*     */     
/* 169 */     OnlineManager.getInstance().send(this.roleId, sYuanBao2banggongRes);
/*     */     
/* 171 */     StringBuilder sbLog = new StringBuilder();
/* 172 */     sbLog.append("|role_id=").append(this.roleId);
/* 173 */     sbLog.append("|yuan_bao=").append(this.yuanBao);
/* 174 */     sbLog.append("|client_yuan_bao=").append(this.clientYuanBao);
/*     */     
/* 176 */     GameServer.logger().info(sbLog.toString());
/*     */     
/* 178 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isYuanBao2BangGongSwitchOpen(long roleId)
/*     */   {
/* 183 */     if (!OpenInterface.getOpenStatus(514))
/*     */     {
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     if (OpenInterface.isBanPlay(roleId, 514))
/*     */     {
/* 190 */       OpenInterface.sendBanPlayMsg(roleId, 514);
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 199 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 204 */     StringBuilder sbLog = new StringBuilder();
/* 205 */     sbLog.append("[gang]PCYuanBao2banggongReq.processImp@yuan bao 2 bang gong failed");
/* 206 */     sbLog.append("|ret=").append(ret);
/* 207 */     sbLog.append("|role_id=").append(this.roleId);
/* 208 */     sbLog.append("|yuan_bao=").append(this.yuanBao);
/* 209 */     sbLog.append("|client_yuan_bao=").append(this.clientYuanBao);
/*     */     
/* 211 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 213 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 215 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 218 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 220 */     SGangNormalResult sGangNormalRes = new SGangNormalResult();
/* 221 */     sGangNormalRes.result = ret;
/*     */     
/* 223 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sGangNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void tlogYuanBaoExchangeBanggong(String userId, int exchangeBangGong, int nowTotalExchange)
/*     */   {
/* 231 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 233 */     StringBuilder sbLog = new StringBuilder();
/* 234 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 235 */     sbLog.append(userId).append('|');
/* 236 */     sbLog.append(this.roleId).append('|');
/* 237 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 239 */     sbLog.append(this.yuanBao).append('|');
/* 240 */     sbLog.append(exchangeBangGong).append('|');
/* 241 */     sbLog.append(nowTotalExchange);
/*     */     
/* 243 */     TLogManager.getInstance().addLog(this.roleId, "YuanBaoExchangeBangGongStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCYuanBao2banggongReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */