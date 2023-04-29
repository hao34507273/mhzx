/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SMemberLoginBro;
/*     */ import mzm.gsp.corps.SSyncCorpsInfo;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsMember;
/*     */ import xtable.Role2corps;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  20 */     new CheckAppellation(((Long)this.arg).longValue()).execute();
/*     */     
/*  22 */     return synCorpsInfo(((Long)this.arg).longValue());
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean synCorpsInfo(long roleId)
/*     */   {
/*  28 */     CorpsMember xCorpsMember = Role2corps.select(Long.valueOf(roleId));
/*  29 */     if (xCorpsMember == null)
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     long corpsId = xCorpsMember.getCorpsid();
/*  35 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/*  36 */     if (xCorps == null)
/*     */     {
/*  38 */       GameServer.logger().error(String.format("[corps]POnRoleLogin.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     SSyncCorpsInfo sync = new SSyncCorpsInfo();
/*  46 */     CorpsManager.fillCorpsSynInfo(xCorps, sync.corpsinfo);
/*  47 */     OnlineManager.getInstance().send(roleId, sync);
/*     */     
/*  49 */     CorpsManager.corpsBrocast(xCorps, true, new SMemberLoginBro(roleId));
/*     */     
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   private class CheckAppellation extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public CheckAppellation(long roleId)
/*     */     {
/*  60 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  67 */       CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.roleId));
/*  68 */       if (xCorpsMember == null)
/*     */       {
/*  70 */         return false;
/*     */       }
/*     */       
/*  73 */       long corpsId = xCorpsMember.getCorpsid();
/*  74 */       xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  75 */       if (xCorps == null)
/*     */       {
/*  77 */         GameServer.logger().error(String.format("[corps]CheckAppellation.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  82 */         return false;
/*     */       }
/*  84 */       List<String> newArgs = CorpsManager.getCorpsAppellationArgs(xCorpsMember.getDuty(), corpsId, xCorps.getCorpsname());
/*  85 */       if (newArgs == null)
/*     */       {
/*  87 */         GameServer.logger().error(String.format("[corps]CheckAppellation.processImp@ IMPOSSIBLE! get corps args err!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */         
/*     */ 
/*     */ 
/*  91 */         return false;
/*     */       }
/*  93 */       List<String> oldArgs = TitleInterface.getAppArgs(this.roleId, CorpsConsts.getInstance().CORPS_APPELLATION_ID, true);
/*  94 */       if ((oldArgs == null) || (oldArgs.size() == 0))
/*     */       {
/*  96 */         GameServer.logger().error(String.format("[corps]CheckAppellation.processImp@ corps's app args not exist!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */         
/*  98 */         return false;
/*     */       }
/* 100 */       if (newArgs.size() != oldArgs.size())
/*     */       {
/* 102 */         GameServer.logger().error(String.format("[corps]CheckAppellation.processImp@ corps's app is illegal!|roleId=%d|newArgs=%s|oldArgs=%s", new Object[] { Long.valueOf(this.roleId), newArgs.toString(), oldArgs.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 106 */         return false;
/*     */       }
/* 108 */       if (isArgSame(newArgs, oldArgs))
/*     */       {
/* 110 */         return true;
/*     */       }
/* 112 */       TitleInterface.replaceAppellationArgs(this.roleId, CorpsConsts.getInstance().CORPS_APPELLATION_ID, newArgs);
/* 113 */       return true;
/*     */     }
/*     */     
/*     */     private boolean isArgSame(List<String> newArgs, List<String> oldArgs)
/*     */     {
/* 118 */       for (int index = 0; index < newArgs.size(); index++)
/*     */       {
/* 120 */         if (!((String)newArgs.get(index)).equals(oldArgs.get(index)))
/*     */         {
/*     */ 
/*     */ 
/* 124 */           return false; }
/*     */       }
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */