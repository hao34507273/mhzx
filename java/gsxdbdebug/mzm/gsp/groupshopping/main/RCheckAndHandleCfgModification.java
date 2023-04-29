/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SSmallGroupShoppingItemCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xbean.SmallGroupShoppingItemInfo;
/*     */ 
/*     */ public class RCheckAndHandleCfgModification extends mzm.gsp.util.LogicRunnable
/*     */ {
/*     */   private final int activityId;
/*     */   
/*     */   RCheckAndHandleCfgModification(int activityId)
/*     */   {
/*  20 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  26 */     checkGroupPriceModification();
/*  27 */     checkGroupSizeModification();
/*  28 */     checkItemNumModification();
/*  29 */     checkNewGroupShoppingItem();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkGroupPriceModification()
/*     */   {
/*  37 */     final List<Long> groupsToClose = new java.util.ArrayList();
/*  38 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  44 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(RCheckAndHandleCfgModification.this.activityId);
/*  45 */         if (xGroupShoppingInfo == null) {
/*  46 */           return false;
/*     */         }
/*     */         
/*     */ 
/*  50 */         for (Map.Entry<Integer, BigGroupShoppingItemInfo> entry : xGroupShoppingInfo.getBig_group_infos().entrySet())
/*     */         {
/*  52 */           long groupId = ((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id();
/*  53 */           if (groupId != 0L)
/*     */           {
/*     */ 
/*  56 */             SBigGroupShoppingItemCfg cfg = SBigGroupShoppingItemCfg.get(((Integer)entry.getKey()).intValue());
/*  57 */             if (cfg != null)
/*     */             {
/*  59 */               Integer groupPrice = xtable.Shopping_group_info.selectPrice(Long.valueOf(groupId));
/*  60 */               if ((groupPrice != null) && (groupPrice.intValue() != cfg.groupPrice))
/*     */               {
/*  62 */                 groupsToClose.add(Long.valueOf(groupId));
/*  63 */                 ((BigGroupShoppingItemInfo)entry.getValue()).setGroup_id(0L);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*  68 */         for (Long groupId : xGroupShoppingInfo.getIncompleted_small_groups())
/*     */         {
/*  70 */           ShoppingGroupInfo xShoppingGroupInfo = xtable.Shopping_group_info.select(groupId);
/*  71 */           if (xShoppingGroupInfo != null)
/*     */           {
/*  73 */             SSmallGroupShoppingItemCfg cfg = SSmallGroupShoppingItemCfg.get(xShoppingGroupInfo.getGroup_shopping_item_cfgid());
/*     */             
/*  75 */             if (cfg != null)
/*     */             {
/*  77 */               if (xShoppingGroupInfo.getPrice() != cfg.groupPrice)
/*  78 */                 groupsToClose.add(groupId); }
/*     */           } }
/*  80 */         return true;
/*     */       }
/*     */     }.call();
/*  83 */     for (Long groupId : groupsToClose) {
/*  84 */       new RCloseGroupShopping(this.activityId, groupId.longValue(), true, false, false).run();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkGroupSizeModification()
/*     */   {
/*  94 */     final List<Long> bigGroupsToCheck = new java.util.ArrayList();
/*  95 */     final List<Long> smallGroupsToCheck = new java.util.ArrayList();
/*  96 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 101 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(RCheckAndHandleCfgModification.this.activityId);
/* 102 */         if (xGroupShoppingInfo == null) {
/* 103 */           return false;
/*     */         }
/* 105 */         for (Map.Entry<Integer, BigGroupShoppingItemInfo> entry : xGroupShoppingInfo.getBig_group_infos().entrySet())
/*     */         {
/* 107 */           if (((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id() != 0L)
/*     */           {
/* 109 */             Integer status = xtable.Shopping_group_info.selectStatus(Long.valueOf(((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id()));
/* 110 */             if ((status != null) && (status.intValue() == 0))
/* 111 */               bigGroupsToCheck.add(Long.valueOf(((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id()));
/*     */           }
/*     */         }
/* 114 */         smallGroupsToCheck.addAll(xGroupShoppingInfo.getIncompleted_small_groups());
/* 115 */         return true;
/*     */       }
/*     */     }.call();
/*     */     
/*     */ 
/* 120 */     for (final Long groupId : bigGroupsToCheck) {
/* 121 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 126 */           ShoppingGroupInfo xShoppingGroupInfo = xtable.Shopping_group_info.get(groupId);
/* 127 */           if (xShoppingGroupInfo == null)
/* 128 */             return false;
/* 129 */           SBigGroupShoppingItemCfg cfg = SBigGroupShoppingItemCfg.get(xShoppingGroupInfo.getGroup_shopping_item_cfgid());
/*     */           
/* 131 */           if (cfg == null)
/* 132 */             return false;
/* 133 */           if (xShoppingGroupInfo.getGroup_size() != cfg.groupSize)
/* 134 */             xShoppingGroupInfo.setGroup_size(cfg.groupSize);
/* 135 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */     
/* 140 */     final List<Long> groupsToClose = new java.util.ArrayList();
/* 141 */     for (final Long groupId : smallGroupsToCheck) {
/* 142 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 147 */           GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(RCheckAndHandleCfgModification.this.activityId);
/* 148 */           if (xGroupShoppingInfo == null)
/* 149 */             return false;
/* 150 */           ShoppingGroupInfo xShoppingGroupInfo = xtable.Shopping_group_info.get(groupId);
/* 151 */           if (xShoppingGroupInfo == null)
/* 152 */             return false;
/* 153 */           int groupShoppingItemCfgId = xShoppingGroupInfo.getGroup_shopping_item_cfgid();
/* 154 */           SSmallGroupShoppingItemCfg cfg = SSmallGroupShoppingItemCfg.get(groupShoppingItemCfgId);
/* 155 */           if (cfg == null) {
/* 156 */             return false;
/*     */           }
/*     */           
/* 159 */           if (cfg.groupSize > xShoppingGroupInfo.getGroup_size())
/*     */           {
/* 161 */             int diff = cfg.groupSize - xShoppingGroupInfo.getGroup_size();
/* 162 */             SmallGroupShoppingItemInfo xGroupShoppingItemInfo = (SmallGroupShoppingItemInfo)xGroupShoppingInfo.getSmall_group_infos().get(Integer.valueOf(groupShoppingItemCfgId));
/*     */             
/* 164 */             if (xGroupShoppingItemInfo != null)
/* 165 */               xGroupShoppingItemInfo.setRemaining_num(xGroupShoppingItemInfo.getRemaining_num() - diff);
/* 166 */             xShoppingGroupInfo.setGroup_size(cfg.groupSize);
/*     */ 
/*     */           }
/* 169 */           else if (cfg.groupSize < xShoppingGroupInfo.getGroup_size())
/*     */           {
/* 171 */             if (cfg.groupSize <= xShoppingGroupInfo.getMembers().size())
/*     */             {
/* 173 */               groupsToClose.add(groupId);
/* 174 */               int diff = xShoppingGroupInfo.getGroup_size() - xShoppingGroupInfo.getMembers().size();
/* 175 */               SmallGroupShoppingItemInfo xGroupShoppingItemInfo = (SmallGroupShoppingItemInfo)xGroupShoppingInfo.getSmall_group_infos().get(Integer.valueOf(groupShoppingItemCfgId));
/*     */               
/* 177 */               if (xGroupShoppingItemInfo != null)
/* 178 */                 xGroupShoppingItemInfo.setRemaining_num(xGroupShoppingItemInfo.getRemaining_num() + diff);
/* 179 */               xShoppingGroupInfo.setGroup_size(xShoppingGroupInfo.getMembers().size());
/*     */             }
/*     */             else
/*     */             {
/* 183 */               int diff = xShoppingGroupInfo.getGroup_size() - cfg.groupSize;
/* 184 */               SmallGroupShoppingItemInfo xGroupShoppingItemInfo = (SmallGroupShoppingItemInfo)xGroupShoppingInfo.getSmall_group_infos().get(Integer.valueOf(groupShoppingItemCfgId));
/*     */               
/* 186 */               if (xGroupShoppingItemInfo != null)
/* 187 */                 xGroupShoppingItemInfo.setRemaining_num(xGroupShoppingItemInfo.getRemaining_num() + diff);
/* 188 */               xShoppingGroupInfo.setGroup_size(cfg.groupSize);
/*     */             }
/*     */           }
/* 191 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */     
/* 196 */     for (Long groupId : groupsToClose) {
/* 197 */       new RCloseGroupShopping(this.activityId, groupId.longValue(), false, false, false).run();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void checkItemNumModification()
/*     */   {
/* 205 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 210 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(RCheckAndHandleCfgModification.this.activityId);
/* 211 */         if (xGroupShoppingInfo == null) {
/* 212 */           return false;
/*     */         }
/* 214 */         for (Map.Entry<Integer, BigGroupShoppingItemInfo> entry : xGroupShoppingInfo.getBig_group_infos().entrySet())
/*     */         {
/* 216 */           SBigGroupShoppingItemCfg cfg = SBigGroupShoppingItemCfg.get(((Integer)entry.getKey()).intValue());
/* 217 */           if ((cfg != null) && (cfg.itemNum != ((BigGroupShoppingItemInfo)entry.getValue()).getTotal_num()))
/*     */           {
/* 219 */             int itemNum = cfg.itemNum <= 0 ? 0 : cfg.itemNum;
/* 220 */             ((BigGroupShoppingItemInfo)entry.getValue()).setRemaining_num(((BigGroupShoppingItemInfo)entry.getValue()).getRemaining_num() + itemNum - ((BigGroupShoppingItemInfo)entry.getValue()).getTotal_num());
/*     */             
/* 222 */             ((BigGroupShoppingItemInfo)entry.getValue()).setTotal_num(itemNum);
/*     */           }
/*     */         }
/*     */         
/* 226 */         for (Map.Entry<Integer, SmallGroupShoppingItemInfo> entry : xGroupShoppingInfo.getSmall_group_infos().entrySet())
/*     */         {
/* 228 */           SSmallGroupShoppingItemCfg cfg = SSmallGroupShoppingItemCfg.get(((Integer)entry.getKey()).intValue());
/* 229 */           if ((cfg != null) && (cfg.itemNum != ((SmallGroupShoppingItemInfo)entry.getValue()).getTotal_num()))
/*     */           {
/* 231 */             int itemNum = cfg.itemNum <= 0 ? 0 : cfg.itemNum;
/* 232 */             ((SmallGroupShoppingItemInfo)entry.getValue()).setRemaining_num(((SmallGroupShoppingItemInfo)entry.getValue()).getRemaining_num() + itemNum - ((SmallGroupShoppingItemInfo)entry.getValue()).getTotal_num());
/*     */             
/* 234 */             ((SmallGroupShoppingItemInfo)entry.getValue()).setTotal_num(itemNum);
/*     */           }
/*     */         }
/*     */         
/* 238 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkNewGroupShoppingItem()
/*     */   {
/* 248 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 254 */         mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg groupShoppingActivityCfg = mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg.get(RCheckAndHandleCfgModification.this.activityId);
/* 255 */         if (groupShoppingActivityCfg == null) {
/* 256 */           return false;
/*     */         }
/*     */         
/* 259 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(RCheckAndHandleCfgModification.this.activityId);
/* 260 */         if (xGroupShoppingInfo == null) {
/* 261 */           return false;
/*     */         }
/*     */         
/* 264 */         for (Integer groupItemCfgId : groupShoppingActivityCfg.smallGroupItemCfgIds)
/*     */         {
/* 266 */           if (!xGroupShoppingInfo.getSmall_group_infos().containsKey(groupItemCfgId))
/*     */           {
/* 268 */             SSmallGroupShoppingItemCfg cfg = SSmallGroupShoppingItemCfg.get(groupItemCfgId.intValue());
/* 269 */             if (cfg != null)
/*     */             {
/* 271 */               SmallGroupShoppingItemInfo xSmallGroupShoppingItemInfo = xbean.Pod.newSmallGroupShoppingItemInfo();
/*     */               
/*     */ 
/* 274 */               xSmallGroupShoppingItemInfo.setTotal_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 275 */               xSmallGroupShoppingItemInfo.setRemaining_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 276 */               xGroupShoppingInfo.getSmall_group_infos().put(groupItemCfgId, xSmallGroupShoppingItemInfo);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 281 */         for (Integer groupItemCfgId : groupShoppingActivityCfg.bigGroupItemCfgIds)
/*     */         {
/* 283 */           if (!xGroupShoppingInfo.getBig_group_infos().containsKey(groupItemCfgId))
/*     */           {
/* 285 */             SBigGroupShoppingItemCfg cfg = SBigGroupShoppingItemCfg.get(groupItemCfgId.intValue());
/* 286 */             if (cfg != null)
/*     */             {
/* 288 */               BigGroupShoppingItemInfo xBigGroupShoppingItemInfo = xbean.Pod.newBigGroupShoppingItemInfo();
/*     */               
/*     */ 
/* 291 */               xBigGroupShoppingItemInfo.setTotal_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 292 */               xBigGroupShoppingItemInfo.setRemaining_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 293 */               xBigGroupShoppingItemInfo.setGroup_id(0L);
/* 294 */               xGroupShoppingInfo.getBig_group_infos().put(groupItemCfgId, xBigGroupShoppingItemInfo);
/*     */             }
/*     */           }
/*     */         }
/* 298 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\RCheckAndHandleCfgModification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */