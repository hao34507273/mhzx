/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquipCondition
/*     */   extends AbstractCondition<MarketItem>
/*     */ {
/*     */   private final int level;
/*  19 */   private List<Integer> colors = new ArrayList();
/*  20 */   private List<Integer> skillIds = new ArrayList();
/*     */   
/*  22 */   private Integer hashCodeCache = null;
/*  23 */   private String toStringCache = null;
/*     */   
/*     */   public EquipCondition(int level, Set<Integer> colors, Set<Integer> skillIds)
/*     */   {
/*  27 */     this.level = level;
/*  28 */     this.colors.addAll(colors);
/*     */     
/*  30 */     this.skillIds.addAll(skillIds);
/*     */     
/*  32 */     Collections.sort(this.colors);
/*  33 */     Collections.sort(this.skillIds);
/*     */     
/*  35 */     this.colors = Collections.unmodifiableList(this.colors);
/*  36 */     this.skillIds = Collections.unmodifiableList(this.skillIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isTrue(MarketItem xMarketItem)
/*     */   {
/*  43 */     if (this.level != ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid()))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if ((!this.colors.isEmpty()) && (!this.colors.contains(Integer.valueOf(ItemInterface.getColor(xMarketItem.getItem().getCfgid())))))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     if ((!this.skillIds.isEmpty()) && (!this.skillIds.contains(Integer.valueOf(ItemInterface.getEquipSkill(xMarketItem.getItem())))))
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  62 */     if (obj == this)
/*     */     {
/*  64 */       return true;
/*     */     }
/*  66 */     if ((obj instanceof EquipCondition))
/*     */     {
/*  68 */       EquipCondition o = (EquipCondition)obj;
/*  69 */       return (this.level == o.level) && (this.colors.equals(o.colors)) && (this.skillIds.equals(o.skillIds));
/*     */     }
/*     */     
/*  72 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  78 */     if (this.hashCodeCache == null)
/*     */     {
/*  80 */       int _h_ = 0;
/*  81 */       _h_ += this.level;
/*  82 */       _h_ += this.colors.hashCode();
/*  83 */       _h_ += this.skillIds.hashCode();
/*  84 */       this.hashCodeCache = Integer.valueOf(_h_);
/*     */     }
/*     */     
/*  87 */     return this.hashCodeCache.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  93 */     if (this.toStringCache == null)
/*     */     {
/*  95 */       StringBuffer stringBuffer = new StringBuffer();
/*  96 */       stringBuffer.append("level:").append(this.level).append("#");
/*  97 */       stringBuffer.append("color:").append(this.colors.toString()).append("#");
/*  98 */       stringBuffer.append("skillid:").append(this.skillIds.toString());
/*  99 */       this.toStringCache = stringBuffer.toString();
/*     */     }
/*     */     
/* 102 */     return this.toStringCache;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/* 107 */     return this.level;
/*     */   }
/*     */   
/*     */   public List<Integer> getColors()
/*     */   {
/* 112 */     return this.colors;
/*     */   }
/*     */   
/*     */   public List<Integer> getSkillIds()
/*     */   {
/* 117 */     return this.skillIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\EquipCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */