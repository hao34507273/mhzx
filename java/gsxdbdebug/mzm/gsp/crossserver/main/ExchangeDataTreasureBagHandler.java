/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.TreasureBagExchangeData;
/*     */ import hub.TreasureBoxItem;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.RemoveModelEnum;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.RoamItemRecord;
/*     */ import xbean.TreasureBagRoamOperator;
/*     */ import xtable.Role2treasurebagroamoperator;
/*     */ import xtable.User;
/*     */ 
/*     */ public class ExchangeDataTreasureBagHandler extends ExchangeDataHandler<TreasureBagExchangeData>
/*     */ {
/*     */   protected boolean onBoxData(String userid, long roleid, TreasureBagExchangeData treasureBagExchangeData)
/*     */   {
/*  26 */     TreasureBagRoamOperator xTreasureBagRoamOperator = Role2treasurebagroamoperator.get(Long.valueOf(roleid));
/*  27 */     if (xTreasureBagRoamOperator == null)
/*     */     {
/*  29 */       return true;
/*     */     }
/*     */     
/*  32 */     for (RoamItemRecord xRoamItemRecord : xTreasureBagRoamOperator.getRecordlist())
/*     */     {
/*  34 */       TreasureBoxItem treasureBoxItem = new TreasureBoxItem();
/*  35 */       treasureBoxItem.log_reason.addAll(xRoamItemRecord.getLogreason());
/*  36 */       for (Map.Entry<Integer, Integer> entry : xRoamItemRecord.getItemmap().entrySet())
/*     */       {
/*  38 */         treasureBoxItem.item_map.put(entry.getKey(), entry.getValue());
/*     */       }
/*  40 */       treasureBoxItem.remove_model = xRoamItemRecord.getRemovemodel();
/*     */       
/*  42 */       treasureBagExchangeData.remove_item_list.add(treasureBoxItem);
/*     */     }
/*     */     
/*  45 */     Role2treasurebagroamoperator.remove(Long.valueOf(roleid));
/*  46 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean onUnboxData(String userid, long roleid, TreasureBagExchangeData treasureBagExchangeData)
/*     */   {
/*  52 */     boolean result = new PHandleTreasuerBagOnReturnOwnServer(roleid, treasureBagExchangeData).call();
/*  53 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public TreasureBagExchangeData makeContextBean()
/*     */   {
/*  59 */     return new TreasureBagExchangeData();
/*     */   }
/*     */   
/*     */   private static class PHandleTreasuerBagOnReturnOwnServer extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final TreasureBagExchangeData treasureBagExchangeData;
/*     */     
/*     */     public PHandleTreasuerBagOnReturnOwnServer(long roleId, TreasureBagExchangeData treasureBagExchangeData)
/*     */     {
/*  69 */       this.roleId = roleId;
/*  70 */       this.treasureBagExchangeData = treasureBagExchangeData;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  76 */       String userId = RoleInterface.getUserId(this.roleId);
/*  77 */       if (userId == null)
/*     */       {
/*  79 */         onFail(-1, null);
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */       
/*  85 */       if (this.treasureBagExchangeData.remove_item_list.isEmpty())
/*     */       {
/*  87 */         return true;
/*     */       }
/*     */       
/*  90 */       for (TreasureBoxItem treasureBoxItem : this.treasureBagExchangeData.remove_item_list)
/*     */       {
/*  92 */         ItemOperateResult itemOperateResult = null;
/*  93 */         if (treasureBoxItem.remove_model == ItemOperateResult.RemoveModelEnum.NO_MODEL.ordinal())
/*     */         {
/*  95 */           itemOperateResult = ItemInterface.removeItemById(this.roleId, treasureBoxItem.item_map, new TLogArg(LogReason.TREASURE_BOX_ROAM_REMOVE));
/*     */           
/*     */ 
/*  98 */           if (!itemOperateResult.success())
/*     */           {
/* 100 */             Map<String, Object> extraMap = new HashMap();
/* 101 */             extraMap.put("item_key", treasureBoxItem.item_map.keySet());
/* 102 */             extraMap.put("item_value", treasureBoxItem.item_map.values());
/*     */             
/* 104 */             onFail(-3, extraMap);
/*     */           }
/*     */           
/* 107 */           for (Map.Entry<Integer, Integer> entry : treasureBoxItem.item_map.entrySet())
/*     */           {
/* 109 */             tlogTreasureBoxRemoveBagItem(userId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), ((Integer)treasureBoxItem.log_reason.get(0)).intValue(), ((Integer)treasureBoxItem.log_reason.get(1)).intValue(), itemOperateResult.success());
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 114 */         else if (treasureBoxItem.remove_model == ItemOperateResult.RemoveModelEnum.BIND_FIRST.ordinal())
/*     */         {
/* 116 */           for (Map.Entry<Integer, Integer> entry : treasureBoxItem.item_map.entrySet())
/*     */           {
/* 118 */             itemOperateResult = ItemInterface.removeItemsWithBindFirst(this.roleId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), new TLogArg(LogReason.TREASURE_BOX_ROAM_REMOVE));
/*     */             
/*     */ 
/* 121 */             tlogTreasureBoxRemoveBagItem(userId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), ((Integer)treasureBoxItem.log_reason.get(0)).intValue(), ((Integer)treasureBoxItem.log_reason.get(1)).intValue(), itemOperateResult.success());
/*     */             
/*     */ 
/*     */ 
/* 125 */             if (!itemOperateResult.success())
/*     */             {
/* 127 */               Map<String, Object> extraMap = new HashMap();
/* 128 */               extraMap.put("item_key", entry.getKey());
/* 129 */               extraMap.put("item_value", entry.getValue());
/*     */               
/* 131 */               onFail(-4, extraMap);
/*     */             }
/*     */           }
/*     */         }
/* 135 */         else if (treasureBoxItem.remove_model == ItemOperateResult.RemoveModelEnum.UNBIND_FIRST.ordinal())
/*     */         {
/* 137 */           for (Map.Entry<Integer, Integer> entry : treasureBoxItem.item_map.entrySet())
/*     */           {
/* 139 */             itemOperateResult = ItemInterface.removeItemsWithUnBindFirst(this.roleId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), new TLogArg(LogReason.TREASURE_BOX_ROAM_REMOVE));
/*     */             
/*     */ 
/* 142 */             tlogTreasureBoxRemoveBagItem(userId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), ((Integer)treasureBoxItem.log_reason.get(0)).intValue(), ((Integer)treasureBoxItem.log_reason.get(1)).intValue(), itemOperateResult.success());
/*     */             
/*     */ 
/*     */ 
/* 146 */             if (!itemOperateResult.success())
/*     */             {
/* 148 */               Map<String, Object> extraMap = new HashMap();
/* 149 */               extraMap.put("item_key", entry.getKey());
/* 150 */               extraMap.put("item_value", entry.getValue());
/*     */               
/* 152 */               onFail(-5, extraMap);
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 158 */           onFail(-6, null);
/*     */         }
/*     */       }
/*     */       
/* 162 */       onFail(0, null);
/* 163 */       return true;
/*     */     }
/*     */     
/*     */     private void onFail(int ret, Map<String, Object> extraMap)
/*     */     {
/* 168 */       StringBuilder sBuilder = new StringBuilder();
/* 169 */       sBuilder.append("[crossserver_exchangedata]PHandleTreasuerBagOnReturnOwnServer.processImp@on fail");
/* 170 */       sBuilder.append("|role_id=").append(this.roleId);
/* 171 */       sBuilder.append("|treasuer_bag_exchange_data=").append(this.treasureBagExchangeData);
/* 172 */       sBuilder.append("|ret=").append(ret);
/*     */       
/* 174 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 176 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 178 */           sBuilder.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 182 */       GameServer.logger().info(sBuilder.toString());
/*     */     }
/*     */     
/*     */ 
/*     */     private void tlogTreasureBoxRemoveBagItem(String userId, int itemCfgId, int itemNum, int reason, int subReason, boolean isSuccuss)
/*     */     {
/* 188 */       int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */       
/* 190 */       StringBuilder sbLog = new StringBuilder();
/* 191 */       sbLog.append(mzm.gsp.GameServerInfoManager.getHostIP()).append('|');
/* 192 */       sbLog.append(userId).append('|');
/* 193 */       sbLog.append(this.roleId).append('|');
/* 194 */       sbLog.append(roleLevel).append('|');
/*     */       
/* 196 */       sbLog.append(itemCfgId).append('|');
/* 197 */       sbLog.append(itemNum).append('|');
/* 198 */       sbLog.append(reason).append('|');
/* 199 */       sbLog.append(subReason).append('|');
/* 200 */       sbLog.append(0).append('|');
/* 201 */       sbLog.append(isSuccuss ? 1 : 0);
/*     */       
/* 203 */       TLogManager.getInstance().addLog(this.roleId, "TreasureItemReturnOwnServer", sbLog.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\ExchangeDataTreasureBagHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */