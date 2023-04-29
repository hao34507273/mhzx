/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
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
/*     */ 
/*     */ public class POnRoleLoginFaBaoBag
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   private static final int MAX_CACHE_NUM = 30;
/*  32 */   private static final List<Integer> MOVE_ITEM_TYPE = Arrays.asList(new Integer[] { Integer.valueOf(44), Integer.valueOf(42) });
/*     */   
/*  34 */   private int gridId = 0;
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  41 */     RoleItemBag newBag = ItemManager.getBag(roleId, 340600006);
/*     */     
/*     */ 
/*  44 */     if (newBag == null)
/*     */     {
/*     */ 
/*  47 */       if (!ItemManager.createRoleItemBag(roleId, 340600006))
/*     */       {
/*  49 */         return false;
/*     */       }
/*  51 */       newBag = ItemManager.getBag(roleId, 340600006);
/*     */       
/*     */ 
/*  54 */       List<StringBuilder> logInfos = new ArrayList();
/*     */       
/*     */ 
/*  57 */       RoleItemBag oldBag = ItemManager.getRoleItemBag(roleId);
/*  58 */       moveItem(newBag, oldBag, logInfos);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */       tlogMoveInfos(((Long)this.arg).longValue(), logInfos);
/*     */     }
/*     */     
/*     */ 
/*  71 */     ItemManager.syncBagInfo(roleId, 340600006);
/*     */     
/*  73 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void moveItem(RoleItemBag newBag, RoleItemBag oldBag, List<StringBuilder> logInfos)
/*     */   {
/*  85 */     if (oldBag == null)
/*     */     {
/*  87 */       return;
/*     */     }
/*  89 */     Iterator<Map.Entry<Integer, Item>> it = oldBag.xBag.getItems().entrySet().iterator();
/*     */     
/*     */ 
/*  92 */     while ((it.hasNext()) && (this.gridId < newBag.getCapacity()))
/*     */     {
/*  94 */       Map.Entry<Integer, Item> entry = (Map.Entry)it.next();
/*  95 */       SItemCfg sItemCfg = SItemCfg.get(((Item)entry.getValue()).getCfgid());
/*  96 */       if ((sItemCfg != null) && 
/*     */       
/*     */ 
/*     */ 
/* 100 */         (MOVE_ITEM_TYPE.contains(Integer.valueOf(sItemCfg.type))))
/*     */       {
/* 102 */         it.remove();
/* 103 */         newBag.xBag.getItems().put(Integer.valueOf(this.gridId), entry.getValue());
/*     */         
/* 105 */         addLog(logInfos, entry, this.gridId);
/*     */         
/* 107 */         this.gridId += 1;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addLog(List<StringBuilder> logInfos, Map.Entry<Integer, Item> entry, int toGridId)
/*     */   {
/* 121 */     StringBuilder sb = new StringBuilder();
/* 122 */     sb.append("[");
/* 123 */     sb.append(((Item)entry.getValue()).getCfgid()).append("_");
/* 124 */     sb.append(((Item)entry.getValue()).getNumber()).append("_");
/* 125 */     sb.append(entry.getKey()).append("_");
/* 126 */     sb.append(toGridId);
/* 127 */     sb.append("]");
/* 128 */     logInfos.add(sb);
/* 129 */     if (logInfos.size() >= 30)
/*     */     {
/* 131 */       tlogMoveInfos(((Long)this.arg).longValue(), logInfos);
/* 132 */       logInfos.clear();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogMoveInfos(long roleid, List<StringBuilder> logInfos)
/*     */   {
/* 144 */     if (logInfos.size() <= 0)
/*     */     {
/* 146 */       return;
/*     */     }
/* 148 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 149 */     String userid = RoleInterface.getUserId(roleid);
/* 150 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 152 */     StringBuilder sb = new StringBuilder();
/* 153 */     for (StringBuilder logInfo : logInfos)
/*     */     {
/* 155 */       sb.append(logInfo);
/* 156 */       sb.append(",");
/*     */     }
/* 158 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), sb.toString() };
/*     */     
/* 160 */     TLogManager.getInstance().addLog(roleid, "MoveFaBaoBagItem", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginFaBaoBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */