/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class PendingMessageManager<K>
/*    */ {
/* 10 */   private static final PendingMessageManager<Long> rolePendingMessageManager = new PendingMessageManager();
/*    */   
/*    */   public static final PendingMessageManager<Long> getRolePendingMessageManager()
/*    */   {
/* 14 */     return rolePendingMessageManager;
/*    */   }
/*    */   
/* 17 */   private Map<K, List<AbstractMapMsgHandler>> pendingMessages = new HashMap();
/*    */   
/*    */   public void addPendingMessage(K key, AbstractMapMsgHandler msg)
/*    */   {
/* 21 */     List<AbstractMapMsgHandler> messages = (List)this.pendingMessages.get(key);
/* 22 */     if (messages == null)
/*    */     {
/* 24 */       messages = new LinkedList();
/* 25 */       this.pendingMessages.put(key, messages);
/*    */     }
/*    */     
/* 28 */     messages.add(msg);
/*    */   }
/*    */   
/*    */   public void clearPendingMessage(K key)
/*    */   {
/* 33 */     this.pendingMessages.remove(key);
/*    */   }
/*    */   
/*    */   public void redoPendingMessages(K key)
/*    */   {
/* 38 */     List<AbstractMapMsgHandler> messages = (List)this.pendingMessages.remove(key);
/* 39 */     if (messages == null)
/*    */     {
/* 41 */       return;
/*    */     }
/*    */     
/* 44 */     for (AbstractMapMsgHandler msg : messages)
/*    */     {
/* 46 */       msg.execute();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\PendingMessageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */