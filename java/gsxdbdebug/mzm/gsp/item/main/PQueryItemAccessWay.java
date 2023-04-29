/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.AccessWayInfo;
/*     */ import mzm.gsp.item.AccessWayInfoList;
/*     */ import mzm.gsp.item.SResItemAccessWay;
/*     */ import mzm.gsp.item.main.access.ItemAccessInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PQueryItemAccessWay
/*     */   extends LogicProcedure
/*     */ {
/*     */   protected long roleid;
/*     */   protected List<Integer> itemIdList;
/*     */   
/*     */   public PQueryItemAccessWay(long roleid, List<Integer> itemIdList)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.itemIdList = itemIdList;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     SResItemAccessWay res = new SResItemAccessWay();
/*  36 */     int level = RoleInterface.getLevel(this.roleid);
/*  37 */     String userId = RoleInterface.getUserId(this.roleid);
/*  38 */     for (Integer itemId : this.itemIdList)
/*     */     {
/*     */ 
/*  41 */       AccessWayInfoList wayList = queryItemWayInfoList(userId, itemId.intValue(), level);
/*     */       
/*  43 */       res.itemaccessway.put(itemId, wayList);
/*     */     }
/*  45 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   protected AccessWayInfoList queryItemWayInfoList(String userid, int itemId, int level)
/*     */   {
/*  52 */     AccessWayInfoList wayList = new AccessWayInfoList();
/*     */     
/*  54 */     Set<Integer> activityIds = ItemAccessInterface.queryActivityForOutputItem(userid, this.roleid, itemId, level);
/*  55 */     if ((activityIds != null) && (activityIds.size() > 0))
/*     */     {
/*  57 */       AccessWayInfo a = new AccessWayInfo();
/*  58 */       a.accesswaytype = 2;
/*  59 */       a.idlist.addAll(activityIds);
/*  60 */       wayList.accessways.add(a);
/*     */     }
/*     */     
/*     */ 
/*  64 */     Set<Integer> npcIds = ItemAccessInterface.queryNpcForSellItem(this.roleid, itemId);
/*  65 */     if ((npcIds != null) && (npcIds.size() > 0))
/*     */     {
/*  67 */       AccessWayInfo n = new AccessWayInfo();
/*  68 */       n.accesswaytype = 3;
/*  69 */       n.idlist.addAll(npcIds);
/*  70 */       wayList.accessways.add(n);
/*     */     }
/*  72 */     Set<Integer> mapIds = ItemAccessInterface.queryMapIdForOuputItem(this.roleid, itemId);
/*  73 */     if ((mapIds != null) && (mapIds.size() > 0))
/*     */     {
/*  75 */       AccessWayInfo m = new AccessWayInfo();
/*  76 */       m.accesswaytype = 1;
/*  77 */       m.idlist.addAll(mapIds);
/*  78 */       wayList.accessways.add(m);
/*     */     }
/*     */     
/*  81 */     Set<Integer> subTypeIds = ItemAccessInterface.queryShanghuiItemSubType(this.roleid, itemId);
/*  82 */     if ((subTypeIds == null) || (subTypeIds.size() == 0))
/*     */     {
/*  84 */       Set<Integer> bigTypeIds = ItemAccessInterface.queryShanghuiItemBigType(this.roleid, itemId);
/*  85 */       if ((bigTypeIds != null) && (bigTypeIds.size() > 0))
/*     */       {
/*  87 */         AccessWayInfo big = new AccessWayInfo();
/*  88 */         big.accesswaytype = 4;
/*  89 */         big.idlist.addAll(bigTypeIds);
/*  90 */         wayList.accessways.add(big);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  95 */       AccessWayInfo sub = new AccessWayInfo();
/*  96 */       sub.accesswaytype = 6;
/*  97 */       sub.idlist.addAll(subTypeIds);
/*  98 */       wayList.accessways.add(sub);
/*     */     }
/*     */     
/* 101 */     Set<Integer> baitanSubTypes = ItemAccessInterface.queryBaitanSubType(this.roleid, itemId);
/* 102 */     if ((baitanSubTypes == null) || (baitanSubTypes.size() == 0))
/*     */     {
/* 104 */       Set<Integer> baitanBigTypes = ItemAccessInterface.queryBaitanBigType(this.roleid, itemId);
/* 105 */       if ((baitanBigTypes != null) && (baitanBigTypes.size() > 0))
/*     */       {
/* 107 */         AccessWayInfo baitan = new AccessWayInfo();
/* 108 */         baitan.accesswaytype = 5;
/* 109 */         baitan.idlist.addAll(baitanBigTypes);
/* 110 */         wayList.accessways.add(baitan);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 116 */       AccessWayInfo baitan = new AccessWayInfo();
/* 117 */       baitan.accesswaytype = 11;
/* 118 */       baitan.idlist.addAll(baitanSubTypes);
/* 119 */       wayList.accessways.add(baitan);
/*     */     }
/*     */     
/* 122 */     List<Integer> mallTypes = ItemAccessInterface.queryMallTypeForSellItem(this.roleid, itemId);
/* 123 */     if ((mallTypes != null) && (mallTypes.size() > 0))
/*     */     {
/* 125 */       AccessWayInfo mall = new AccessWayInfo();
/* 126 */       mall.accesswaytype = 7;
/* 127 */       mall.idlist.addAll(mallTypes);
/* 128 */       wayList.accessways.add(mall);
/*     */     }
/*     */     
/* 131 */     Set<Integer> jifenTypes = ItemAccessInterface.queryJifenTypeForItem(this.roleid, itemId);
/* 132 */     if ((jifenTypes != null) && (jifenTypes.size() > 0))
/*     */     {
/* 134 */       AccessWayInfo jifen = new AccessWayInfo();
/* 135 */       jifen.accesswaytype = 8;
/* 136 */       jifen.idlist.addAll(jifenTypes);
/* 137 */       wayList.accessways.add(jifen);
/*     */     }
/*     */     
/* 140 */     Set<Integer> skillbags = ItemAccessInterface.querySkillbagidForItem(this.roleid, itemId);
/* 141 */     if ((skillbags != null) && (skillbags.size() > 0))
/*     */     {
/* 143 */       AccessWayInfo skillbag = new AccessWayInfo();
/* 144 */       skillbag.accesswaytype = 9;
/* 145 */       skillbag.idlist.addAll(skillbags);
/* 146 */       wayList.accessways.add(skillbag);
/*     */     }
/* 148 */     boolean ret = ItemAccessInterface.queryGangDrugShopForItem(this.roleid, itemId);
/* 149 */     if (ret)
/*     */     {
/* 151 */       AccessWayInfo grugshop = new AccessWayInfo();
/* 152 */       grugshop.accesswaytype = 10;
/*     */       
/* 154 */       wayList.accessways.add(grugshop);
/*     */     }
/*     */     
/* 157 */     Set<Integer> baotuAccessType2Itemids = ItemAccessInterface.queryBaotuTypeForThisItem(itemId, level);
/* 158 */     if ((baotuAccessType2Itemids != null) && (!baotuAccessType2Itemids.isEmpty()))
/*     */     {
/*     */ 
/* 161 */       AccessWayInfo baotu = new AccessWayInfo();
/* 162 */       baotu.accesswaytype = 12;
/* 163 */       baotu.idlist.addAll(baotuAccessType2Itemids);
/*     */       
/* 165 */       wayList.accessways.add(baotu);
/*     */     }
/*     */     
/* 168 */     ret = ItemAccessInterface.isVitalityExchangeOutPutItem(this.roleid, itemId);
/* 169 */     if (ret)
/*     */     {
/* 171 */       AccessWayInfo vialityWayInfo = new AccessWayInfo();
/* 172 */       vialityWayInfo.accesswaytype = 13;
/*     */       
/* 174 */       wayList.accessways.add(vialityWayInfo);
/*     */     }
/* 176 */     ret = ItemAccessInterface.isHomelandShopOutPutItem(itemId);
/* 177 */     if (ret)
/*     */     {
/* 179 */       AccessWayInfo homelandShopWayInfo = new AccessWayInfo();
/* 180 */       homelandShopWayInfo.accesswaytype = 14;
/*     */       
/* 182 */       wayList.accessways.add(homelandShopWayInfo);
/*     */     }
/* 184 */     if (ItemAccessInterface.isChangeModelCardLotteryOutPutItem(itemId, level))
/*     */     {
/* 186 */       AccessWayInfo changeModelCardLotteryInfo = new AccessWayInfo();
/* 187 */       changeModelCardLotteryInfo.accesswaytype = 15;
/*     */       
/* 189 */       wayList.accessways.add(changeModelCardLotteryInfo);
/*     */     }
/* 191 */     return wayList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PQueryItemAccessWay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */