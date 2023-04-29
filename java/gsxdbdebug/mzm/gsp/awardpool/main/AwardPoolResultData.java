/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ 
/*     */ 
/*     */ public class AwardPoolResultData
/*     */ {
/*  13 */   private int gold = 0;
/*  14 */   private int silver = 0;
/*  15 */   private int gang = 0;
/*     */   
/*  17 */   private int yuanbao = 0;
/*     */   
/*  19 */   private int controllerid = 0;
/*     */   
/*     */ 
/*  22 */   private int roleExp = 0;
/*  23 */   private int petExp = 0;
/*  24 */   private int xiuLianExp = 0;
/*     */   
/*     */   private int index;
/*     */   
/*  28 */   private Map<Integer, Integer> itemMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  33 */   private Map<Integer, List<Integer>> itemId2Num = new HashMap();
/*     */   
/*     */ 
/*  36 */   private List<Integer> prepareSubPoolIds = new ArrayList();
/*     */   
/*  38 */   private List<Integer> finalSubPoolIds = new ArrayList();
/*     */   
/*     */   private int typeId;
/*     */   
/*     */   public int getIndex()
/*     */   {
/*  44 */     return this.index;
/*     */   }
/*     */   
/*     */   public void setIndex(int index)
/*     */   {
/*  49 */     this.index = index;
/*     */   }
/*     */   
/*     */ 
/*     */   void addItem(int itemid, int num)
/*     */   {
/*  55 */     if (this.itemMap.containsKey(Integer.valueOf(itemid)))
/*     */     {
/*  57 */       int count = ((Integer)this.itemMap.get(Integer.valueOf(itemid))).intValue() + num;
/*  58 */       this.itemMap.put(Integer.valueOf(itemid), Integer.valueOf(count));
/*     */     }
/*     */     else
/*     */     {
/*  62 */       this.itemMap.put(Integer.valueOf(itemid), Integer.valueOf(num));
/*     */     }
/*     */     
/*  65 */     List<Integer> numList = (List)this.itemId2Num.get(Integer.valueOf(itemid));
/*  66 */     if (numList == null)
/*     */     {
/*  68 */       numList = new ArrayList();
/*  69 */       this.itemId2Num.put(Integer.valueOf(itemid), numList);
/*     */     }
/*  71 */     numList.add(Integer.valueOf(num));
/*     */   }
/*     */   
/*     */   void add(AwardPoolResultData awardModel)
/*     */   {
/*  76 */     this.gold += awardModel.getGold();
/*  77 */     this.silver += awardModel.getSilver();
/*     */     
/*  79 */     this.gang += awardModel.getGang();
/*     */     
/*  81 */     this.roleExp += awardModel.getRoleExp();
/*  82 */     this.petExp += awardModel.getPetExp();
/*  83 */     this.xiuLianExp += awardModel.getXiuLianExp();
/*     */   }
/*     */   
/*     */ 
/*     */   void setRoleExp(int roleExp)
/*     */   {
/*  89 */     this.roleExp = roleExp;
/*     */   }
/*     */   
/*     */   void setPetExp(int petExp)
/*     */   {
/*  94 */     this.petExp = petExp;
/*     */   }
/*     */   
/*     */   void setGold(int gold)
/*     */   {
/*  99 */     this.gold = gold;
/*     */   }
/*     */   
/*     */   void setSilver(int silver)
/*     */   {
/* 104 */     this.silver = silver;
/*     */   }
/*     */   
/*     */   public int getRoleExp()
/*     */   {
/* 109 */     return this.roleExp;
/*     */   }
/*     */   
/*     */   public int getPetExp()
/*     */   {
/* 114 */     return this.petExp;
/*     */   }
/*     */   
/*     */   public int getGang()
/*     */   {
/* 119 */     return this.gang;
/*     */   }
/*     */   
/*     */   void setGang(int gang)
/*     */   {
/* 124 */     this.gang = gang;
/*     */   }
/*     */   
/*     */   public int getYuanbao()
/*     */   {
/* 129 */     return this.yuanbao;
/*     */   }
/*     */   
/*     */   public void setYuanbao(int yuanbao)
/*     */   {
/* 134 */     this.yuanbao = yuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getItemMap()
/*     */   {
/* 144 */     return this.itemMap;
/*     */   }
/*     */   
/*     */   public int getGold()
/*     */   {
/* 149 */     return this.gold;
/*     */   }
/*     */   
/*     */   public int getSilver()
/*     */   {
/* 154 */     return this.silver;
/*     */   }
/*     */   
/*     */   public int getXiuLianExp()
/*     */   {
/* 159 */     return this.xiuLianExp;
/*     */   }
/*     */   
/*     */   void setXiuLianExp(int xiuLianExp)
/*     */   {
/* 164 */     this.xiuLianExp = xiuLianExp;
/*     */   }
/*     */   
/*     */   public int getControllerId()
/*     */   {
/* 169 */     return this.controllerid;
/*     */   }
/*     */   
/*     */   void setControllerId(int controllerid)
/*     */   {
/* 174 */     this.controllerid = controllerid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, List<Integer>> getItemId2NumList()
/*     */   {
/* 184 */     return this.itemId2Num;
/*     */   }
/*     */   
/*     */   public void addPrepareSubPoolIds(int subPoolId)
/*     */   {
/* 189 */     this.prepareSubPoolIds.add(Integer.valueOf(subPoolId));
/*     */   }
/*     */   
/*     */   public void addPrepareSubPoolIds(List<Integer> subPoolIds)
/*     */   {
/* 194 */     this.prepareSubPoolIds.addAll(subPoolIds);
/*     */   }
/*     */   
/*     */   public List<Integer> getPrepareSubPoolIds()
/*     */   {
/* 199 */     List<Integer> r = new ArrayList();
/* 200 */     r.addAll(this.prepareSubPoolIds);
/* 201 */     return r;
/*     */   }
/*     */   
/*     */   public void addFinalSubPoolIds(int subPoolId)
/*     */   {
/* 206 */     this.finalSubPoolIds.add(Integer.valueOf(subPoolId));
/*     */   }
/*     */   
/*     */   public void addFinalSubPoolIds(List<Integer> subPoolIds)
/*     */   {
/* 211 */     this.finalSubPoolIds.addAll(subPoolIds);
/*     */   }
/*     */   
/*     */   public List<Integer> getFinalSubPoolIds()
/*     */   {
/* 216 */     List<Integer> r = new ArrayList();
/* 217 */     r.addAll(this.finalSubPoolIds);
/* 218 */     return r;
/*     */   }
/*     */   
/*     */   public int getTypeId()
/*     */   {
/* 223 */     return this.typeId;
/*     */   }
/*     */   
/*     */   public void setTypeId(int typeId)
/*     */   {
/* 228 */     this.typeId = typeId;
/*     */   }
/*     */   
/*     */   public String toStringForGM()
/*     */   {
/* 233 */     StringBuilder stringBuilder = new StringBuilder();
/* 234 */     boolean has = false;
/* 235 */     if (this.gold != 0)
/*     */     {
/* 237 */       has = true;
/* 238 */       stringBuilder.append("金币:").append(this.gold);
/*     */     }
/* 240 */     if (this.silver != 0)
/*     */     {
/* 242 */       if (has)
/*     */       {
/* 244 */         stringBuilder.append("、");
/*     */       }
/* 246 */       has = true;
/* 247 */       stringBuilder.append("银币:").append(this.silver);
/*     */     }
/* 249 */     if (this.gang != 0)
/*     */     {
/* 251 */       if (has)
/*     */       {
/* 253 */         stringBuilder.append("、");
/*     */       }
/* 255 */       has = true;
/* 256 */       stringBuilder.append("帮贡:").append(this.gang);
/*     */     }
/* 258 */     if (this.yuanbao != 0)
/*     */     {
/* 260 */       if (has)
/*     */       {
/* 262 */         stringBuilder.append("、");
/*     */       }
/* 264 */       has = true;
/* 265 */       stringBuilder.append("元宝:").append(this.yuanbao);
/*     */     }
/* 267 */     if (this.controllerid != 0)
/*     */     {
/* 269 */       if (has)
/*     */       {
/* 271 */         stringBuilder.append("、");
/*     */       }
/* 273 */       has = true;
/* 274 */       stringBuilder.append("控制器Id:").append(this.controllerid);
/*     */     }
/* 276 */     if (this.roleExp != 0)
/*     */     {
/* 278 */       if (has)
/*     */       {
/* 280 */         stringBuilder.append("、");
/*     */       }
/* 282 */       has = true;
/* 283 */       stringBuilder.append("人物经验:").append(this.roleExp);
/*     */     }
/*     */     
/* 286 */     if (this.petExp != 0)
/*     */     {
/* 288 */       if (has)
/*     */       {
/* 290 */         stringBuilder.append("、");
/*     */       }
/* 292 */       has = true;
/* 293 */       stringBuilder.append("宠物经验:").append(this.petExp);
/*     */     }
/* 295 */     if (this.xiuLianExp != 0)
/*     */     {
/* 297 */       if (has)
/*     */       {
/* 299 */         stringBuilder.append("、");
/*     */       }
/* 301 */       has = true;
/* 302 */       stringBuilder.append("修炼经验:").append(this.xiuLianExp);
/*     */     }
/*     */     
/* 305 */     if (!this.itemId2Num.isEmpty())
/*     */     {
/* 307 */       if (has)
/*     */       {
/* 309 */         stringBuilder.append("; ");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 314 */       has = false;
/*     */       
/*     */ 
/* 317 */       for (Map.Entry<Integer, List<Integer>> entry : this.itemId2Num.entrySet())
/*     */       {
/* 319 */         if (has)
/*     */         {
/* 321 */           stringBuilder.append("; ");
/*     */         }
/* 323 */         int itemId = ((Integer)entry.getKey()).intValue();
/* 324 */         SItemCfg itemCfg = SItemCfg.get(itemId);
/* 325 */         if (itemCfg != null)
/*     */         {
/*     */ 
/*     */ 
/* 329 */           List<Integer> numList = (List)entry.getValue();
/* 330 */           int numListSize = numList.size();
/* 331 */           if (numListSize != 0)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 336 */             stringBuilder.append(itemCfg.name).append(":");
/* 337 */             has = true;
/* 338 */             stringBuilder.append(numList.get(0));
/* 339 */             if (numListSize != 1)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 344 */               for (int i = 1; i < numListSize - 1; i++)
/*     */               {
/* 346 */                 stringBuilder.append("、");
/* 347 */                 stringBuilder.append(numList.get(i));
/*     */               }
/* 349 */               stringBuilder.append("、").append(numList.get(numListSize - 1)).append(", 共 ").append(this.itemMap.get(Integer.valueOf(itemId)));
/*     */             }
/*     */           }
/*     */         } } }
/* 353 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 359 */     return "AwardPoolResultData{gold=" + this.gold + ", silver=" + this.silver + ", gang=" + this.gang + ", yuanbao=" + this.yuanbao + ", controllerid=" + this.controllerid + ", roleExp=" + this.roleExp + ", petExp=" + this.petExp + ", xiuLianExp=" + this.xiuLianExp + ", index=" + this.index + ", itemMap=" + this.itemMap + ", itemId2Num=" + this.itemId2Num + ", prepareSubPoolIds=" + this.prepareSubPoolIds + ", finalSubPoolIds=" + this.finalSubPoolIds + ", typeId=" + this.typeId + '}';
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\AwardPoolResultData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */