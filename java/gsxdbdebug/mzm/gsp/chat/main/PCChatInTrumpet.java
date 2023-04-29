/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chat.SChatInTrumpet;
/*     */ import mzm.gsp.chat.SChatInTrumpetFail;
/*     */ import mzm.gsp.chat.confbean.STrumpetCfg;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCChatInTrumpet
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int trumpetCfgid;
/*     */   private final int currentYuanBaoNum;
/*     */   private final int contentType;
/*     */   private final Octets content;
/*     */   
/*     */   public PCChatInTrumpet(long roleid, int trumpetCfgid, int currentYuanBaoNum, int contentType, Octets content)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.trumpetCfgid = trumpetCfgid;
/*  39 */     this.currentYuanBaoNum = currentYuanBaoNum;
/*  40 */     this.contentType = contentType;
/*  41 */     this.content = content;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!RoleChatManager.isTrumpetSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  50 */       onFail(-1, null);
/*  51 */       return false;
/*     */     }
/*  53 */     STrumpetCfg cfg = STrumpetCfg.get(this.trumpetCfgid);
/*  54 */     if (cfg == null)
/*     */     {
/*     */ 
/*  57 */       onFail(-3, null);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  63 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  65 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  68 */     if (!ItemInterface.removeItemById(this.roleid, cfg.itemid, 1, new TLogArg(LogReason.TRUMPET_COST_ITEM)))
/*     */     {
/*  70 */       long yuanbao = QingfuInterface.getYuanbao(userid, true) + QingfuInterface.getBindYuanbao(userid, true);
/*  71 */       if (yuanbao != this.currentYuanBaoNum)
/*     */       {
/*     */ 
/*  74 */         onFail(1, null);
/*  75 */         return false;
/*     */       }
/*  77 */       if (yuanbao < cfg.yuanbao_num)
/*     */       {
/*     */ 
/*  80 */         onFail(2, null);
/*  81 */         return false;
/*     */       }
/*  83 */       if (QingfuInterface.costYuanbao(userid, this.roleid, cfg.yuanbao_num, CostType.COST_BIND_FIRST_TRUMPET, new TLogArg(LogReason.TRUMPET_COST_YUANBAO)) != CostResult.Success)
/*     */       {
/*     */ 
/*     */ 
/*  87 */         onFail(2, null);
/*  88 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  92 */     if (!RoleChatManager.canRoleSpk(this.contentType, this.content, this.roleid, 12))
/*     */     {
/*     */ 
/*  95 */       onFail(3, null);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     SChatInTrumpet protocol = new SChatInTrumpet();
/* 100 */     RoleChatManager.fillRoleInfoInChatContent(this.roleid, protocol.chatcontent, this.content, this.contentType);
/* 101 */     protocol.trumpet_cfg_id = this.trumpetCfgid;
/* 102 */     if (RoleChatManager.isPlatformTalkForbid(this.roleid))
/*     */     {
/* 104 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     }
/*     */     else
/*     */     {
/* 108 */       OnlineManager.getInstance().sendAll(protocol);
/*     */     }
/* 110 */     RoleChatManager.afterChat(this.roleid, 12);
/*     */     
/*     */ 
/* 113 */     IdipManager.chatTLog(this.roleid, 0L, 0L, 0L, 8, null, this.content);
/* 114 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 119 */     StringBuilder sb = new StringBuilder();
/* 120 */     sb.append(String.format("[chat]PCChatInTrumpet.processImp@chat in trumpet fail|roleid=%d|trumpet_cfg_id=%d|current_yuanbao_num=%d|content_type=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.trumpetCfgid), Integer.valueOf(this.currentYuanBaoNum), Integer.valueOf(this.contentType), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 123 */     if (extraInfo != null)
/*     */     {
/* 125 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 127 */         sb.append("|").append((String)entry.getKey());
/* 128 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 131 */     GameServer.logger().info(sb.toString());
/* 132 */     if (res > 0)
/*     */     {
/* 134 */       SChatInTrumpetFail protocol = new SChatInTrumpetFail();
/* 135 */       protocol.res = res;
/* 136 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInTrumpet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */