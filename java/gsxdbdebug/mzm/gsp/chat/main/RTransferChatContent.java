/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chat.crossserver.CrossServerChatHandler;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RTransferChatContent
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long roleid;
/*    */   private final int channel;
/*    */   private final long orgKey;
/*    */   private final Protocol protocol;
/*    */   private final List<CrossServerChatHandler> handlers;
/*    */   
/*    */   public RTransferChatContent(long roleid, int channel, long orgKey, Protocol protocol, List<CrossServerChatHandler> handlers)
/*    */   {
/* 30 */     this.roleid = roleid;
/* 31 */     this.channel = channel;
/* 32 */     this.orgKey = orgKey;
/* 33 */     this.protocol = protocol;
/* 34 */     this.handlers = handlers;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 40 */     if ((this.handlers == null) || (this.handlers.isEmpty()))
/*    */     {
/* 42 */       GameServer.logger().error(String.format("[chat]RTransferChatContent.process@handlers is null or empty|roleid=%d|channel=%d|org_key=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.channel), Long.valueOf(this.orgKey) }));
/*    */       
/*    */ 
/*    */ 
/* 46 */       return;
/*    */     }
/* 48 */     final Set<Integer> destZoneids = new HashSet();
/* 49 */     for (final CrossServerChatHandler handler : this.handlers)
/*    */     {
/* 51 */       new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 56 */           List<Integer> zoneids = handler.getDestServerZoneid(RTransferChatContent.this.roleid);
/* 57 */           if ((zoneids == null) || (zoneids.isEmpty()))
/*    */           {
/* 59 */             return false;
/*    */           }
/* 61 */           destZoneids.addAll(zoneids);
/* 62 */           return true;
/*    */         }
/*    */       }.call();
/*    */     }
/* 66 */     if (destZoneids.isEmpty())
/*    */     {
/* 68 */       GameServer.logger().error(String.format("[chat]RTransferChatContent.process@dest zoneids is empty|roleid=%d|channel=%d|org_key=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.channel), Long.valueOf(this.orgKey) }));
/*    */       
/*    */ 
/* 71 */       return;
/*    */     }
/* 73 */     for (Iterator i$ = destZoneids.iterator(); i$.hasNext();) { int destZoneid = ((Integer)i$.next()).intValue();
/*    */       
/* 75 */       CrossServerInterface.transferChatContent(destZoneid, this.roleid, this.channel, this.orgKey, this.protocol.marshal(new OctetsStream()));
/*    */     }
/*    */     
/* 78 */     GameServer.logger().info(String.format("[chat]RTransferChatContent.process@transfer chat content|roleid=%d|channel=%d|org_key=%d|dest_zoneids=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.channel), Long.valueOf(this.orgKey), destZoneids.toString() }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\RTransferChatContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */