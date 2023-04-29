/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class MapProtocolSendQueue implements Runnable
/*     */ {
/*     */   private static final int MAX_ROLE_NUM_ONE_TIME = 1024;
/*  18 */   private static MapProtocolSendQueue instance = null;
/*     */   private final Thread thread;
/*     */   
/*     */   public static MapProtocolSendQueue getInstance() {
/*  22 */     return instance;
/*     */   }
/*     */   
/*     */   public static void init()
/*     */   {
/*     */     try
/*     */     {
/*  29 */       instance = new MapProtocolSendQueue();
/*  30 */       instance.start();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  34 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void exit()
/*     */   {
/*  40 */     if (instance != null)
/*     */     {
/*  42 */       instance.stop();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*  47 */   private final AtomicBoolean isRunning = new AtomicBoolean(true);
/*  48 */   private final MessageQueue<SendMsgBase> queue = new MessageQueue();
/*     */   
/*     */   private MapProtocolSendQueue()
/*     */   {
/*  52 */     this.thread = new Thread(this, "map_send_thread");
/*     */   }
/*     */   
/*     */   public void start()
/*     */   {
/*  57 */     this.thread.setDaemon(true);
/*  58 */     this.thread.start();
/*     */   }
/*     */   
/*     */   public void stop()
/*     */   {
/*  63 */     this.isRunning.set(false);
/*     */     
/*     */     try
/*     */     {
/*  67 */       this.queue.put(new NullMsg());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  71 */       GameServer.logger().warn("[map]MapProtocolSendQueue.stop@stop ignore exception", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*  77 */     while (this.isRunning.get())
/*     */     {
/*     */       try
/*     */       {
/*  81 */         ((SendMsgBase)this.queue.take()).send();
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*  85 */         GameServer.logger().error("[map]MapProtocolSendQueue.run@map send thread exception occured ", e);
/*     */       }
/*     */       catch (Throwable e)
/*     */       {
/*  89 */         GameServer.logger().error("[map]MapProtocolSendQueue.run@map send thread throwable", e);
/*     */       }
/*     */     }
/*     */     
/*  93 */     GameServer.logger().debug("[map]MapProtocolSendQueue.run@map send thread stop");
/*     */   }
/*     */   
/*     */   static abstract interface SendMsgBase
/*     */   {
/*     */     public abstract void send();
/*     */   }
/*     */   
/*     */   static class NullMsg implements MapProtocolSendQueue.SendMsgBase
/*     */   {
/*     */     public void send()
/*     */     {
/* 105 */       int inputSize = MapProtocolSendQueue.instance.getQueueInputMutableSize();
/* 106 */       int outputSize = MapProtocolSendQueue.instance.getQueueOutputMutableSize();
/* 107 */       GameServer.logger().error(String.format("[map]MapProtocolSendQueue.NullMsg.send@map protocol send queue info| input=%d|output=%d", new Object[] { Integer.valueOf(inputSize), Integer.valueOf(outputSize) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static class SendProtocol
/*     */     implements MapProtocolSendQueue.SendMsgBase
/*     */   {
/*     */     long roleId;
/*     */     Protocol p;
/*     */     
/*     */     SendProtocol(long roleId, Protocol protocol)
/*     */     {
/* 120 */       this.roleId = roleId;
/* 121 */       this.p = protocol;
/*     */     }
/*     */     
/*     */     public void send()
/*     */     {
/* 126 */       OnlineManager.getInstance().sendAtOnce(this.roleId, this.p);
/*     */     }
/*     */   }
/*     */   
/*     */   static class SendMultiProtocol implements MapProtocolSendQueue.SendMsgBase
/*     */   {
/*     */     Collection<Long> targets;
/*     */     Protocol p;
/*     */     
/*     */     SendMultiProtocol(Collection<Long> targets, Protocol protocol)
/*     */     {
/* 137 */       this.targets = targets;
/* 138 */       this.p = protocol;
/*     */     }
/*     */     
/*     */     public void send()
/*     */     {
/* 143 */       if (this.targets.size() <= 1024)
/*     */       {
/* 145 */         OnlineManager.getInstance().sendMultiAtOnce(this.p, this.targets);
/*     */       }
/*     */       else
/*     */       {
/* 149 */         List<Long> roles2Send = new ArrayList();
/* 150 */         for (Iterator i$ = this.targets.iterator(); i$.hasNext();) { long rId = ((Long)i$.next()).longValue();
/*     */           
/* 152 */           roles2Send.add(Long.valueOf(rId));
/*     */           
/* 154 */           if (roles2Send.size() >= 1024)
/*     */           {
/* 156 */             OnlineManager.getInstance().sendMultiAtOnce(this.p, roles2Send);
/* 157 */             roles2Send.clear();
/*     */           }
/*     */         }
/*     */         
/* 161 */         if (!roles2Send.isEmpty())
/*     */         {
/* 163 */           OnlineManager.getInstance().sendMultiAtOnce(this.p, roles2Send);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static class BroadProtocol implements MapProtocolSendQueue.SendMsgBase
/*     */   {
/*     */     private final Protocol p;
/*     */     
/*     */     BroadProtocol(Protocol protocol)
/*     */     {
/* 175 */       this.p = protocol;
/*     */     }
/*     */     
/*     */     public void send()
/*     */     {
/* 180 */       OnlineManager.getInstance().sendAllAtOnce(this.p);
/*     */     }
/*     */   }
/*     */   
/*     */   static class SendOctetsProtocol implements MapProtocolSendQueue.SendMsgBase
/*     */   {
/*     */     private final Collection<Long> targets;
/*     */     private final long roleid;
/*     */     private final int protoType;
/*     */     private final Octets octets;
/*     */     
/*     */     SendOctetsProtocol(Collection<Long> targets, int protoType, Octets octets)
/*     */     {
/* 193 */       this.targets = targets;
/* 194 */       this.roleid = -1L;
/* 195 */       this.protoType = protoType;
/* 196 */       this.octets = octets;
/*     */     }
/*     */     
/*     */     SendOctetsProtocol(long roleid, int protoType, Octets octets)
/*     */     {
/* 201 */       this.targets = null;
/* 202 */       this.roleid = roleid;
/* 203 */       this.protoType = protoType;
/* 204 */       this.octets = octets;
/*     */     }
/*     */     
/*     */     public void send()
/*     */     {
/* 209 */       synchronized (this.octets)
/*     */       {
/* 211 */         if (this.targets != null)
/*     */         {
/* 213 */           OnlineManager.getInstance().sendMultiAtOnce(this.protoType, this.octets, this.targets);
/*     */         }
/* 215 */         else if (this.roleid >= 0L)
/*     */         {
/* 217 */           OnlineManager.getInstance().sendAtOnce(this.roleid, this.protoType, this.octets);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void send(long roleId, int protoType, OctetsStream octets)
/*     */   {
/*     */     try
/*     */     {
/* 227 */       this.queue.put(new SendOctetsProtocol(roleId, protoType, octets));
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 231 */       GameServer.logger().error("[map]MapProtocolSendQueue.send@send failed ", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendMulti(Collection<Long> targets, int protoType, OctetsStream octets)
/*     */   {
/*     */     try
/*     */     {
/* 239 */       this.queue.put(new SendOctetsProtocol(targets, protoType, octets));
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 243 */       GameServer.logger().error("[map]MapProtocolSendQueue.sendMulti@send failed ", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void send(long roleId, Protocol p)
/*     */   {
/*     */     try
/*     */     {
/* 251 */       this.queue.put(new SendProtocol(roleId, p));
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 255 */       GameServer.logger().error("[map]MapProtocolSendQueue.send@send failed ", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendMulti(Collection<Long> targets, Protocol p)
/*     */   {
/*     */     try
/*     */     {
/* 263 */       this.queue.put(new SendMultiProtocol(targets, p));
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 267 */       GameServer.logger().error("[map]MapProtocolSendQueue.sendMulti@send failed ", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendAll(Protocol p)
/*     */   {
/*     */     try
/*     */     {
/* 275 */       this.queue.put(new BroadProtocol(p));
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 279 */       GameServer.logger().error("[map]MapProtocolSendQueue.sendAll@send failed ", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendNullMsg()
/*     */   {
/*     */     try
/*     */     {
/* 287 */       this.queue.put(new NullMsg());
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 291 */       GameServer.logger().error("[map]MapProtocolSendQueue.sendNullMsg@send failed ", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getQueueMutableSize()
/*     */   {
/* 297 */     return this.queue.mutableSize();
/*     */   }
/*     */   
/*     */   int getQueueInputMutableSize()
/*     */   {
/* 302 */     return this.queue.getInputQueueMutableSize();
/*     */   }
/*     */   
/*     */   int getQueueOutputMutableSize()
/*     */   {
/* 307 */     return this.queue.getOutputQueueMutableSize();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MapProtocolSendQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */