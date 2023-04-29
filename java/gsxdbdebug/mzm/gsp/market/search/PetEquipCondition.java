/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import xbean.MarketItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetEquipCondition
/*     */   extends AbstractCondition<MarketItem>
/*     */ {
/*     */   private final int property;
/*  20 */   private List<Integer> skillIds = new ArrayList();
/*     */   
/*  22 */   private Integer hashCodeCache = null;
/*  23 */   private String toStringCache = null;
/*     */   
/*     */   public PetEquipCondition(int property, Set<Integer> skillIds)
/*     */   {
/*  27 */     this.property = property;
/*     */     
/*  29 */     this.skillIds.addAll(skillIds);
/*  30 */     Collections.sort(this.skillIds);
/*  31 */     this.skillIds = Collections.unmodifiableList(this.skillIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isTrue(MarketItem xMarketItem)
/*     */   {
/*  38 */     if ((xMarketItem == null) || (xMarketItem.getRest_num() <= 0))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if ((this.property != 0) && (!ItemInterface.isPetEquipItemHasProperty(xMarketItem.getItem(), getProperty())))
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     if (this.skillIds.isEmpty())
/*     */     {
/*  48 */       return true;
/*     */     }
/*  50 */     Set<Integer> hasSkills = ItemInterface.getPetEquipItemSkills(xMarketItem.getItem());
/*  51 */     if (hasSkills.isEmpty())
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     for (Iterator i$ = this.skillIds.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */       
/*  57 */       if (hasSkills.contains(Integer.valueOf(skillid)))
/*     */       {
/*  59 */         return true;
/*     */       }
/*     */     }
/*  62 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  69 */     if (obj == this)
/*     */     {
/*  71 */       return true;
/*     */     }
/*     */     
/*  74 */     if ((obj instanceof PetEquipCondition))
/*     */     {
/*  76 */       PetEquipCondition o = (PetEquipCondition)obj;
/*  77 */       return (o.getProperty() == getProperty()) && (o.skillIds.equals(this.skillIds));
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  85 */     if (this.hashCodeCache == null)
/*     */     {
/*  87 */       int _h_ = 0;
/*  88 */       _h_ += this.property;
/*  89 */       _h_ += this.skillIds.hashCode();
/*  90 */       this.hashCodeCache = Integer.valueOf(_h_);
/*     */     }
/*     */     
/*  93 */     return this.hashCodeCache.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getProperty()
/*     */   {
/*  99 */     return this.property;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 105 */     if (this.toStringCache == null)
/*     */     {
/* 107 */       StringBuffer stringBuffer = new StringBuffer();
/* 108 */       stringBuffer.append("property:").append(this.property).append("#");
/* 109 */       stringBuffer.append("skillid:").append(this.skillIds.toString());
/* 110 */       this.toStringCache = stringBuffer.toString();
/*     */     }
/*     */     
/* 113 */     return this.toStringCache;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getSkillIds()
/*     */   {
/* 119 */     return this.skillIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetEquipCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */