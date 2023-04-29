/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetCondition
/*     */   extends AbstractCondition<MarketPet>
/*     */ {
/*  18 */   private Integer hashCodeCache = null;
/*  19 */   private String toStringCache = null;
/*     */   
/*  21 */   private List<Integer> petTypes = new ArrayList();
/*  22 */   private List<Integer> qualitys = new ArrayList();
/*     */   private final int skillNum;
/*  24 */   private List<Integer> skillIds = new ArrayList();
/*     */   
/*     */ 
/*     */   public PetCondition(Set<Integer> petTypes, Set<Integer> qualitys, int skillNum, Set<Integer> skillIds)
/*     */   {
/*  29 */     this.petTypes.addAll(petTypes);
/*  30 */     Collections.sort(this.petTypes);
/*  31 */     this.petTypes = Collections.unmodifiableList(this.petTypes);
/*     */     
/*  33 */     this.qualitys.addAll(qualitys);
/*  34 */     Collections.sort(this.qualitys);
/*  35 */     this.qualitys = Collections.unmodifiableList(this.qualitys);
/*     */     
/*  37 */     this.skillNum = skillNum;
/*     */     
/*  39 */     this.skillIds.addAll(skillIds);
/*  40 */     Collections.sort(this.skillIds);
/*  41 */     this.skillIds = Collections.unmodifiableList(this.skillIds);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isTrue(MarketPet t)
/*     */   {
/*  47 */     if (t == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     int q = PetInterface.getPetScoreLevel(t.getPet());
/*  52 */     if ((!this.qualitys.isEmpty()) && (!this.qualitys.contains(Integer.valueOf(q))))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     int petCfgId = t.getPet().getTemplateid();
/*  58 */     int pettype = PetInterface.getPetType(petCfgId);
/*  59 */     if ((!this.petTypes.isEmpty()) && (!this.petTypes.contains(Integer.valueOf(pettype))))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     Set<Integer> skillSet = PetInterface.getPetHasSkills(t.getPet());
/*  65 */     if (this.skillNum == 0)
/*     */     {
/*  67 */       return isSkillOk(skillSet);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  72 */     if ((skillSet == null) || (skillSet.isEmpty()) || (skillSet.size() < this.skillNum))
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     return isSkillOk(skillSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  89 */     if (obj == this)
/*     */     {
/*  91 */       return true;
/*     */     }
/*     */     
/*  94 */     if ((obj instanceof PetCondition))
/*     */     {
/*  96 */       PetCondition o = (PetCondition)obj;
/*     */       
/*  98 */       if (o.skillNum != this.skillNum)
/*     */       {
/* 100 */         return false;
/*     */       }
/*     */       
/* 103 */       if (!o.qualitys.equals(this.qualitys))
/*     */       {
/* 105 */         return false;
/*     */       }
/*     */       
/* 108 */       if (!o.petTypes.equals(this.petTypes))
/*     */       {
/* 110 */         return false;
/*     */       }
/*     */       
/* 113 */       if (!o.skillIds.equals(this.skillIds))
/*     */       {
/* 115 */         return false;
/*     */       }
/*     */       
/* 118 */       return true;
/*     */     }
/*     */     
/* 121 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 127 */     if (this.hashCodeCache == null)
/*     */     {
/* 129 */       int _h_ = 0;
/* 130 */       _h_ += this.qualitys.hashCode();
/* 131 */       _h_ += this.petTypes.hashCode();
/* 132 */       _h_ += this.skillNum;
/* 133 */       _h_ += this.skillIds.hashCode();
/* 134 */       this.hashCodeCache = Integer.valueOf(_h_);
/*     */     }
/*     */     
/* 137 */     return this.hashCodeCache.intValue();
/*     */   }
/*     */   
/*     */   private boolean isSkillOk(Set<Integer> skillSet)
/*     */   {
/* 142 */     if (this.skillIds.isEmpty())
/*     */     {
/* 144 */       return true;
/*     */     }
/*     */     
/* 147 */     for (Iterator i$ = this.skillIds.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */       
/* 149 */       if (skillSet.contains(Integer.valueOf(skillid)))
/*     */       {
/* 151 */         return true;
/*     */       }
/*     */     }
/* 154 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 160 */     if (this.toStringCache == null)
/*     */     {
/* 162 */       StringBuffer stringBuffer = new StringBuffer();
/* 163 */       stringBuffer.append("skillnum:").append(this.skillNum).append("#");
/* 164 */       stringBuffer.append("petTypes:").append(this.petTypes.toString()).append("#");
/* 165 */       stringBuffer.append("qualitys:").append(this.qualitys.toString()).append("#");
/* 166 */       stringBuffer.append("skillid:").append(this.skillIds.toString());
/* 167 */       this.toStringCache = stringBuffer.toString();
/*     */     }
/*     */     
/* 170 */     return this.toStringCache;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getPetTypes()
/*     */   {
/* 176 */     return this.petTypes;
/*     */   }
/*     */   
/*     */   public List<Integer> getQualitys()
/*     */   {
/* 181 */     return this.qualitys;
/*     */   }
/*     */   
/*     */   public int getSkillNum()
/*     */   {
/* 186 */     return this.skillNum;
/*     */   }
/*     */   
/*     */   public List<Integer> getSkillIds()
/*     */   {
/* 191 */     return this.skillIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */