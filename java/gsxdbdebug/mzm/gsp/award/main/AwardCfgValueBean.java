/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AwardCfgValueBean
/*     */ {
/*     */   private long yuanbao;
/*     */   private long gold;
/*     */   private long silver;
/*     */   private long goldIngot;
/*  19 */   private int gang = 0;
/*  20 */   private Map<Integer, Integer> tokenMap = new HashMap();
/*     */   
/*     */   private long roleExp;
/*     */   
/*     */   private long petExp;
/*     */   
/*     */   private long xiuLianExp;
/*     */   
/*  28 */   private Map<Integer, Integer> itemMap = new HashMap();
/*     */   
/*     */   public long getYuanbao()
/*     */   {
/*  32 */     return this.yuanbao;
/*     */   }
/*     */   
/*     */   public void setYuanbao(long yuanbao)
/*     */   {
/*  37 */     this.yuanbao = yuanbao;
/*     */   }
/*     */   
/*     */   public long getGold()
/*     */   {
/*  42 */     return this.gold;
/*     */   }
/*     */   
/*     */   public void setGold(long gold)
/*     */   {
/*  47 */     this.gold = gold;
/*     */   }
/*     */   
/*     */   public long getSilver()
/*     */   {
/*  52 */     return this.silver;
/*     */   }
/*     */   
/*     */   public void setSilver(long silver)
/*     */   {
/*  57 */     this.silver = silver;
/*     */   }
/*     */   
/*     */   public long getGoldIngot()
/*     */   {
/*  62 */     return this.goldIngot;
/*     */   }
/*     */   
/*     */   public void setGoldIngot(long goldIngot)
/*     */   {
/*  67 */     this.goldIngot = goldIngot;
/*     */   }
/*     */   
/*     */   public int getGang()
/*     */   {
/*  72 */     return this.gang;
/*     */   }
/*     */   
/*     */   public void setGang(int gang)
/*     */   {
/*  77 */     this.gang = gang;
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getTokenMap()
/*     */   {
/*  82 */     return this.tokenMap;
/*     */   }
/*     */   
/*     */   public void setTokenMap(Map<Integer, Integer> tokenMap)
/*     */   {
/*  87 */     this.tokenMap = tokenMap;
/*     */   }
/*     */   
/*     */   public long getRoleExp()
/*     */   {
/*  92 */     return this.roleExp;
/*     */   }
/*     */   
/*     */   public void setRoleExp(long roleExp)
/*     */   {
/*  97 */     this.roleExp = roleExp;
/*     */   }
/*     */   
/*     */   public long getPetExp()
/*     */   {
/* 102 */     return this.petExp;
/*     */   }
/*     */   
/*     */   public void setPetExp(long petExp)
/*     */   {
/* 107 */     this.petExp = petExp;
/*     */   }
/*     */   
/*     */   public long getXiuLianExp()
/*     */   {
/* 112 */     return this.xiuLianExp;
/*     */   }
/*     */   
/*     */   public void setXiuLianExp(long xiuLianExp)
/*     */   {
/* 117 */     this.xiuLianExp = xiuLianExp;
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getItemMap()
/*     */   {
/* 122 */     return this.itemMap;
/*     */   }
/*     */   
/*     */   public void setItemMap(Map<Integer, Integer> itemMap)
/*     */   {
/* 127 */     this.itemMap = itemMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardCfgValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */