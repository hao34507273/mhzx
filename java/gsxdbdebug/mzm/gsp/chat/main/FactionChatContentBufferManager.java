/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chat.SSynOfflineChatContents;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FactionChatContentBufferManager
/*     */ {
/*  19 */   private static FactionChatContentBufferManager instance = new FactionChatContentBufferManager();
/*     */   
/*     */   static FactionChatContentBufferManager getInstance()
/*     */   {
/*  23 */     return instance;
/*     */   }
/*     */   
/*  26 */   private final HashMap<Long, ChatContentBuffer> buffers = new HashMap();
/*  27 */   private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addChatContent(long gangid, Octets chatContent)
/*     */   {
/*  37 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  39 */       return;
/*     */     }
/*  41 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  44 */       ChatContentBuffer buffer = (ChatContentBuffer)this.buffers.get(Long.valueOf(gangid));
/*  45 */       if (buffer != null)
/*     */       {
/*  47 */         buffer.addChatContent(chatContent); return;
/*     */       }
/*     */       
/*     */     }
/*     */     finally
/*     */     {
/*  53 */       this.rwLock.readLock().unlock();
/*     */     }
/*  55 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  58 */       ChatContentBuffer buffer = (ChatContentBuffer)this.buffers.get(Long.valueOf(gangid));
/*  59 */       if (buffer == null)
/*     */       {
/*  61 */         buffer = new ChatContentBuffer(2, gangid);
/*  62 */         this.buffers.put(Long.valueOf(gangid), buffer);
/*     */       }
/*  64 */       buffer.addChatContent(chatContent);
/*     */     }
/*     */     finally
/*     */     {
/*  68 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sendOfflineChatContents(long roleid, long gangid)
/*     */   {
/*  80 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  83 */       ChatContentBuffer buffer = (ChatContentBuffer)this.buffers.get(Long.valueOf(gangid));
/*  84 */       if (buffer != null)
/*     */       {
/*  86 */         buffer.sendOfflineChatContents(roleid);
/*     */       }
/*     */       else {
/*  89 */         sendEmptyOfflineChatContents(roleid, gangid);
/*     */       }
/*     */     }
/*     */     finally {
/*  93 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendEmptyOfflineChatContents(long roleid, long gangid)
/*     */   {
/* 105 */     SSynOfflineChatContents protocol = new SSynOfflineChatContents();
/* 106 */     protocol.channel_type = 2;
/* 107 */     protocol.ownerid = gangid;
/* 108 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onGangDissolve(long gangid)
/*     */   {
/* 118 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 121 */       this.buffers.remove(Long.valueOf(gangid));
/*     */     }
/*     */     finally
/*     */     {
/* 125 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\FactionChatContentBufferManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */