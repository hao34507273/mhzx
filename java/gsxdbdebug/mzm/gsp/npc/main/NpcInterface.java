/*     */ package mzm.gsp.npc.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.task.confbean.SNpc2Task;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NpcInterface
/*     */ {
/*     */   public static SNpc getNpc(int npcId)
/*     */   {
/*  16 */     return NpcManager.getNpc(npcId);
/*     */   }
/*     */   
/*     */   public static SNpc2Task getSNpc2Task(int npcId) {
/*  20 */     return NpcManager.getNpc2Task(npcId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getAllNpcId()
/*     */   {
/*  29 */     return NpcManager.getAllNpcId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkNpcService(int npcId, int serviceId, long roleId)
/*     */   {
/*  42 */     return NpcServiceManager.checkNpcService(npcId, serviceId, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkNpcService(long roleid, int serviceid, int npcid, ConditionChecker checker)
/*     */   {
/*  56 */     return NpcServiceManager.checkNpcService(npcid, serviceid, roleid, checker);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkNpcServiceIgnoreNpcLocationCond(int npcid, int serviceid, long roleid)
/*     */   {
/*  69 */     return NpcServiceManager.checkNpcService(npcid, serviceid, roleid, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isNpcServiceAvailable(int serviceId, long roleId)
/*     */   {
/*  80 */     return NpcServiceManager.isNpcServiceAvailable(serviceId, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getAllNpcTradeServiceId()
/*     */   {
/*  89 */     return NpcTradeManager.getAllNpcTradeServiceId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isSellItem(int serviceId, int itemId)
/*     */   {
/* 100 */     return NpcTradeManager.isSellItem(serviceId, itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean containsServiceId(int npcId, int serviceId)
/*     */   {
/* 111 */     return NpcManager.containsServiceId(npcId, serviceId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getNPCShopItemPrice(int itemid)
/*     */   {
/* 121 */     return NpcTradeManager.getNPCShopItemPrice(itemid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean banNpcService(int npcServiceid)
/*     */   {
/* 131 */     return NpcManager.banNpcService(npcServiceid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean unBanNpcService(int npcServiceid)
/*     */   {
/* 141 */     return NpcManager.unBanNpcService(npcServiceid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getBanNpcServices()
/*     */   {
/* 148 */     return NpcManager.getBanNpcServices();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */