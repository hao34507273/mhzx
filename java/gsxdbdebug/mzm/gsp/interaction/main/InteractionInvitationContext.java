/*     */ package mzm.gsp.interaction.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.interaction.confbean.SInteractionConsts;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class InteractionInvitationContext
/*     */ {
/*  19 */   private static final Map<Long, InteractionInvitationContext> contexts = new HashMap();
/*  20 */   private static final ReadWriteLock contextLock = new ReentrantReadWriteLock();
/*     */   
/*     */   final int interactionId;
/*     */   
/*     */   final long activeRoleId;
/*     */   final long passiveRoleId;
/*     */   final long sessionId;
/*     */   
/*     */   private InteractionInvitationContext(int interactionId, long activeRoleId, long passiveRoleId, long sessionId)
/*     */   {
/*  30 */     this.interactionId = interactionId;
/*  31 */     this.activeRoleId = activeRoleId;
/*  32 */     this.passiveRoleId = passiveRoleId;
/*  33 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static InteractionInvitationContext get(long roleId)
/*     */   {
/*  41 */     contextLock.readLock().lock();
/*     */     try
/*     */     {
/*  44 */       return (InteractionInvitationContext)contexts.get(Long.valueOf(roleId));
/*     */     }
/*     */     finally
/*     */     {
/*  48 */       contextLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean exists(int interactionId, long activeRoleId, long passiveRoleId)
/*     */   {
/*  57 */     InteractionInvitationContext activeContext = get(activeRoleId);
/*  58 */     if (activeContext == null)
/*  59 */       return false;
/*  60 */     if ((activeContext.interactionId != interactionId) || (activeContext.activeRoleId != activeRoleId) || (activeContext.passiveRoleId != passiveRoleId))
/*     */     {
/*     */ 
/*  63 */       return false;
/*     */     }
/*  65 */     InteractionInvitationContext passiveContext = get(passiveRoleId);
/*  66 */     if (passiveContext == null)
/*  67 */       return false;
/*  68 */     if ((passiveContext.interactionId != interactionId) || (passiveContext.activeRoleId != activeRoleId) || (passiveContext.passiveRoleId != passiveRoleId))
/*     */     {
/*     */ 
/*  71 */       return false;
/*     */     }
/*  73 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean add(int interactionId, long activeRoleId, long passiveRoleId)
/*     */   {
/*  83 */     contextLock.writeLock().lock();
/*     */     try
/*     */     {
/*  86 */       if ((contexts.containsKey(Long.valueOf(activeRoleId))) || (contexts.containsKey(Long.valueOf(passiveRoleId)))) {
/*  87 */         return false;
/*     */       }
/*  89 */       int confirmCountdown = SInteractionConsts.getInstance().CONFIRM_COUNTDOWN;
/*  90 */       Session session = new InteractionInvitationSession(confirmCountdown, interactionId, activeRoleId, passiveRoleId);
/*     */       
/*  92 */       InteractionInvitationContext context = new InteractionInvitationContext(interactionId, activeRoleId, passiveRoleId, session.getSessionId());
/*     */       
/*  94 */       contexts.put(Long.valueOf(activeRoleId), context);
/*  95 */       contexts.put(Long.valueOf(passiveRoleId), context);
/*  96 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 100 */       contextLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static InteractionInvitationContext remove(long roleId)
/*     */   {
/* 109 */     contextLock.writeLock().lock();
/*     */     try
/*     */     {
/* 112 */       InteractionInvitationContext context = (InteractionInvitationContext)contexts.remove(Long.valueOf(roleId));
/* 113 */       InteractionInvitationContext localInteractionInvitationContext1; if (context == null)
/* 114 */         return null;
/* 115 */       Session.removeSession(context.sessionId);
/*     */       
/* 117 */       if (context.activeRoleId == roleId) {
/* 118 */         contexts.remove(Long.valueOf(context.passiveRoleId));
/*     */       } else {
/* 120 */         contexts.remove(Long.valueOf(context.activeRoleId));
/*     */       }
/* 122 */       return context;
/*     */     }
/*     */     finally
/*     */     {
/* 126 */       contextLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\InteractionInvitationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */