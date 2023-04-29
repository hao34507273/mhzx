/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.LinkedList;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*    */ import mzm.gsp.chat.SSynOfflineChatContents;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatContentBuffer
/*    */ {
/* 16 */   private final SSynOfflineChatContents protocol = new SSynOfflineChatContents();
/* 17 */   private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
/*    */   
/*    */   public ChatContentBuffer(int channelType, long ownerid)
/*    */   {
/* 21 */     this.protocol.channel_type = channelType;
/* 22 */     this.protocol.ownerid = ownerid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addChatContent(Octets chatContent)
/*    */   {
/* 32 */     this.rwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 35 */       while (this.protocol.contents.size() >= RoleChatManager.getBufferSize(this.protocol.channel_type))
/*    */       {
/* 37 */         this.protocol.contents.removeFirst();
/*    */       }
/* 39 */       this.protocol.contents.addLast(chatContent);
/*    */     }
/*    */     finally
/*    */     {
/* 43 */       this.rwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void sendOfflineChatContents(long roleid)
/*    */   {
/* 54 */     this.rwLock.readLock().lock();
/*    */     try
/*    */     {
/* 57 */       SSynOfflineChatContents copyProtocol = new SSynOfflineChatContents();
/* 58 */       copyProtocol.channel_type = this.protocol.channel_type;
/* 59 */       copyProtocol.ownerid = this.protocol.ownerid;
/* 60 */       copyProtocol.contents.addAll(this.protocol.contents);
/* 61 */       OnlineManager.getInstance().send(roleid, copyProtocol);
/*    */     }
/*    */     finally
/*    */     {
/* 65 */       this.rwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatContentBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */