/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.grc.SGetRecallRebateFailed;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RebateInfo;
/*     */ import xbean.RecallFriendBackGame;
/*     */ 
/*     */ public class PCGetRecallRebate extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int num;
/*     */   
/*     */   public PCGetRecallRebate(long roleid, int num)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if ((this.num <= 0) || (this.num > SRecallFriendConsts.getInstance().YUAN_BAO_DRAW))
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (!RecallFriendManager.canDoAction(this.roleid, 1935))
/*     */     {
/*  38 */       onFailed(5);
/*  39 */       return false;
/*     */     }
/*  41 */     if (!RecallFriendManager.isRebateFunOpen(this.roleid, true))
/*     */     {
/*  43 */       onFailed(4);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (RoleInterface.getLevel(this.roleid) < SRecallFriendConsts.getInstance().YUAN_BAO_MIN_LEVEL)
/*     */     {
/*  49 */       onFailed(-4);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     String userid = RoleInterface.getUserId(this.roleid);
/*  54 */     String openid = CommonUtils.getOpenId(userid);
/*     */     
/*  56 */     xbean.User xUser = xtable.User.get(userid);
/*  57 */     if (xUser == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  63 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*  64 */     RebateInfo xRebateInfo = xRecallFriendBackGame.getRebate_info();
/*  65 */     if (!DateTimeUtils.isInSameDay(now, xRebateInfo.getReceive_time()))
/*     */     {
/*  67 */       xRebateInfo.setReceive_num(0);
/*     */     }
/*  69 */     int dailyMax = SRecallFriendConsts.getInstance().YUAN_BAO_DRAW;
/*  70 */     if (xRebateInfo.getReceive_num() + this.num > dailyMax)
/*     */     {
/*     */ 
/*  73 */       onFailed(-3);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     if (this.num > xRebateInfo.getTotal_num())
/*     */     {
/*     */ 
/*  81 */       onFailed(-2);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     long serialNo = RecallFriendManager.getSerialNo();
/*     */     
/*  87 */     GetRecallRebateContext context = new GetRecallRebateContext();
/*  88 */     context.roleid = this.roleid;
/*  89 */     context.count = 1;
/*  90 */     OctetsStream contextOs = new OctetsStream();
/*  91 */     context.marshal(contextOs);
/*     */     
/*  93 */     if (!GrcManager.getRecallRebate(openid, this.num, serialNo, dailyMax, contextOs))
/*     */     {
/*  95 */       onFailed(-5);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     GameServer.logger().info(String.format("[recall]PCGetRecallRebate.processImp@send grc success|roleid=%d|num=%d|userid=%s|openid=%s|serial=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.num), userid, openid, Long.valueOf(serialNo) }));
/*     */     
/*     */ 
/*     */ 
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 108 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extras)
/*     */   {
/* 113 */     StringBuilder log = new StringBuilder();
/* 114 */     log.append("[recall]PCGetRecallRebate.onFailed@get rebate failed");
/* 115 */     log.append("|retcode=").append(retcode);
/* 116 */     log.append("|roleid=").append(this.roleid);
/* 117 */     if ((extras != null) && (!extras.isEmpty()))
/*     */     {
/* 119 */       for (Map.Entry<String, ?> entry : extras.entrySet())
/*     */       {
/* 121 */         log.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 124 */     GameServer.logger().error(log.toString());
/*     */     
/* 126 */     SGetRecallRebateFailed msg = new SGetRecallRebateFailed();
/* 127 */     msg.retcode = retcode;
/* 128 */     msg.num = this.num;
/* 129 */     OnlineManager.getInstance().sendAtOnce(this.roleid, msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetRecallRebate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */