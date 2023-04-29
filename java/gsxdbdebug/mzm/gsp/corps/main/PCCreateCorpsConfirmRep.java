/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SSynCreateCorpsConfirmBro;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CreateCorpsConfBean;
/*     */ import xtable.Role2createcorpsconf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCCreateCorpsConfirmRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long sessionId;
/*     */   private final int reply;
/*     */   
/*     */   public PCCreateCorpsConfirmRep(long roleId, int reply, long sessionId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.reply = reply;
/*  30 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(this.roleId, false, false);
/*  37 */     if (leaderId <= 0L)
/*     */     {
/*  39 */       GameServer.logger().error(String.format("[corps]PCCreateCorpsConfirmRep.processImp@ not have team!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  41 */       return false;
/*     */     }
/*  43 */     CreateCorpsConfBean xConfBean = Role2createcorpsconf.get(Long.valueOf(leaderId));
/*  44 */     if (xConfBean == null)
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[corps]PCCreateCorpsConfirmRep.processImp@ not int confirm state!|roleId=%d|leaderId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!xConfBean.getAllroles().contains(Long.valueOf(this.roleId)))
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[corps]PCCreateCorpsConfirmRep.processImp@ not in confirm members!|roleId=%d|leaderId=%d|members=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(leaderId), xConfBean.getAllroles() }));
/*     */       
/*     */ 
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     List<Long> members = xConfBean.getAllroles();
/*     */     
/*  63 */     if (this.reply == 2)
/*     */     {
/*  65 */       OnlineManager.getInstance().sendMulti(new SSynCreateCorpsConfirmBro(this.roleId, this.reply), members);
/*     */       
/*  67 */       Session.removeSession(xConfBean.getSessionid());
/*     */       
/*  69 */       Role2createcorpsconf.remove(Long.valueOf(leaderId));
/*  70 */       return true;
/*     */     }
/*  72 */     if (xConfBean.getAcceptroles().contains(Long.valueOf(this.roleId)))
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[corps]PCCreateCorpsConfirmRep.processImp@ already accept!|roleId=%d|leaderId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     xConfBean.getAcceptroles().add(Long.valueOf(this.roleId));
/*  80 */     OnlineManager.getInstance().sendMulti(new SSynCreateCorpsConfirmBro(this.roleId, this.reply), members);
/*     */     
/*  82 */     afterAllAccepted(leaderId, xConfBean);
/*     */     
/*  84 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void afterAllAccepted(long leaderId, CreateCorpsConfBean xConfBean)
/*     */   {
/*  95 */     if (!xConfBean.getAcceptroles().containsAll(xConfBean.getAllroles()))
/*     */     {
/*  97 */       return;
/*     */     }
/*     */     
/* 100 */     Session.removeSession(xConfBean.getSessionid());
/*     */     
/* 102 */     Role2createcorpsconf.remove(Long.valueOf(leaderId));
/*     */     
/*     */ 
/* 105 */     new PCreateCorps(leaderId, xConfBean.getCorpsname(), xConfBean.getCorpsdeclaration(), xConfBean.getCorpsbadge()).execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCCreateCorpsConfirmRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */