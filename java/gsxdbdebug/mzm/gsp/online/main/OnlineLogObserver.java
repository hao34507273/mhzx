/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class OnlineLogObserver
/*    */   extends Observer
/*    */ {
/*    */   OnlineLogObserver()
/*    */   {
/* 25 */     super(LogManager.getInstance().getOnlineLogIntervalSeconds());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 31 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 35 */         Map<Integer, Map<String, Integer>> platform2Channel2Number = new HashMap();
/*    */         
/* 37 */         List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/*    */         
/* 39 */         for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 40 */           int platform = RoleInterface.getPlatform(roleid);
/* 41 */           String channel = RoleInterface.getChannel(roleid);
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */           if (((channel != null) && (!channel.isEmpty())) || (Onlines.getInstance().find(Long.valueOf(roleid)) != null))
/*    */           {
/*    */ 
/*    */ 
/* 51 */             Map<String, Integer> channel2Num = (Map)platform2Channel2Number.get(Integer.valueOf(platform));
/* 52 */             if (channel2Num == null) {
/* 53 */               channel2Num = new HashMap();
/* 54 */               platform2Channel2Number.put(Integer.valueOf(platform), channel2Num);
/*    */             }
/* 56 */             Integer num = (Integer)channel2Num.get(channel);
/* 57 */             if (num == null) {
/* 58 */               num = Integer.valueOf(0);
/*    */             }
/* 60 */             num = Integer.valueOf(num.intValue() + 1);
/* 61 */             channel2Num.put(channel, num);
/*    */           }
/*    */         }
/* 64 */         if (GameServerInfoManager.isRoamServer()) {
/* 65 */           int totalOnlineNum = 0;
/* 66 */           for (Map<String, Integer> channel2Num : platform2Channel2Number.values()) {
/* 67 */             for (Integer num : channel2Num.values()) {
/* 68 */               totalOnlineNum += num.intValue();
/*    */             }
/*    */           }
/* 71 */           CrossServerInterface.reportGameServerBalanceInfo(totalOnlineNum);
/*    */         }
/*    */         else {
/* 74 */           for (Map.Entry<Integer, Map<String, Integer>> platformEntry : platform2Channel2Number.entrySet()) {
/* 75 */             platform = ((Integer)platformEntry.getKey()).intValue();
/* 76 */             Map<String, Integer> channel2Num = (Map)platformEntry.getValue();
/* 77 */             for (Map.Entry<String, Integer> channelEntry : channel2Num.entrySet()) {
/* 78 */               String channel = (String)channelEntry.getKey();
/* 79 */               int num = ((Integer)channelEntry.getValue()).intValue();
/*    */               
/* 81 */               String logStr = String.format("%d|%s|%d", new Object[] { Integer.valueOf(platform), channel, Integer.valueOf(num) });
/*    */               
/*    */ 
/*    */ 
/*    */ 
/* 86 */               LogManager.getInstance().addLog("onlinenum", logStr);
/*    */             }
/*    */           }
/*    */         }
/*    */         int platform;
/* 91 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 95 */     });
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineLogObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */