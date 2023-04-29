/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.chatgift.event.ChatGiftTimeOutArg;
/*    */ import xbean.ChannelSet;
/*    */ 
/*    */ public class ROnChatGiftTimeOutEvent extends mzm.gsp.chatgift.event.ChatGiftTimeOutEventRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 14 */     if ((((ChatGiftTimeOutArg)this.arg).chatGiftIds == null) || (((ChatGiftTimeOutArg)this.arg).chatGiftIds.size() == 0)) {
/* 15 */       ChatGiftManager.logDebug("ROnChatGiftTimeOutEvent.processImp@ time out chatgiftids error!", new Object[0]);
/* 16 */       return;
/*    */     }
/*    */     
/* 19 */     for (Iterator i$ = ((ChatGiftTimeOutArg)this.arg).chatGiftIds.iterator(); i$.hasNext();) { long chatGiftId = ((Long)i$.next()).longValue();
/*    */       
/* 21 */       xbean.ChatGift xChatGift = xtable.Chatgifttable.select(Long.valueOf(chatGiftId));
/* 22 */       if (xChatGift == null) {
/* 23 */         ChatGiftManager.logDebug("ROnChatGiftTimeOutEvent.processImp@ChatGift is null error!", new Object[0]);
/*    */       }
/*    */       else
/*    */       {
/* 27 */         Map<Integer, ChannelSet> channelMap = xChatGift.getChannelinfo();
/* 28 */         Iterator i$; if ((channelMap != null) && (channelMap.size() > 0)) {
/* 29 */           for (i$ = channelMap.entrySet().iterator(); i$.hasNext();) { channelEntry = (Map.Entry)i$.next();
/* 30 */             if ((((ChannelSet)channelEntry.getValue()).getChanelids() != null) && (((ChannelSet)channelEntry.getValue()).getChanelids().size() > 0)) {
/* 31 */               for (Long channelId : ((ChannelSet)channelEntry.getValue()).getChanelids())
/*    */               {
/* 33 */                 new POnChannelChatGiftOutCfg(((Integer)channelEntry.getKey()).intValue(), channelId.longValue(), chatGiftId).call();
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */         
/*    */         Map.Entry<Integer, ChannelSet> channelEntry;
/* 40 */         new POnRoleChatGiftTimeOut(xChatGift.getRoleid(), chatGiftId).call();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\ROnChatGiftTimeOutEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */