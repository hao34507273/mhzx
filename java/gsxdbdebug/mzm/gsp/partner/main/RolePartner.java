/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import xbean.PartnerBag;
/*     */ import xbean.Property;
/*     */ import xtable.Role2partnerbag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RolePartner
/*     */ {
/*     */   private final long roleId;
/*     */   private PartnerBag partnerBag;
/*     */   
/*     */   RolePartner(long roleId, boolean isRetainLock)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     if (isRetainLock)
/*     */     {
/*  30 */       this.partnerBag = Role2partnerbag.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  34 */       this.partnerBag = Role2partnerbag.select(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean hasXPartnerData()
/*     */   {
/*  45 */     return this.partnerBag != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PartnerOutFightObj getPartnerOutFightObjById(int partnerId)
/*     */   {
/*  57 */     Property xProperty = (Property)this.partnerBag.getPartner2property().get(Integer.valueOf(partnerId));
/*  58 */     if (xProperty == null)
/*     */     {
/*  60 */       return null;
/*     */     }
/*  62 */     return new PartnerOutFightObj(this.roleId, xProperty);
/*     */   }
/*     */   
/*     */   long getRoleId()
/*     */   {
/*  67 */     return this.roleId;
/*     */   }
/*     */   
/*     */   public PartnerBag getPartnerBag()
/*     */   {
/*  72 */     return this.partnerBag;
/*     */   }
/*     */   
/*     */   public void setPartnerBag(PartnerBag partnerBag)
/*     */   {
/*  77 */     this.partnerBag = partnerBag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getDefaultLineUpIndex()
/*     */   {
/*  87 */     return this.partnerBag.getDefaultlineupnum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean ownPartner(int partnerId)
/*     */   {
/*  98 */     if (this.partnerBag == null)
/*     */     {
/* 100 */       return false;
/*     */     }
/* 102 */     if (this.partnerBag.getOwnpartnerids() == null)
/*     */     {
/* 104 */       return false;
/*     */     }
/* 106 */     return this.partnerBag.getOwnpartnerids().contains(Integer.valueOf(partnerId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Partner getXPartner(int partnerId)
/*     */   {
/* 117 */     if (!ownPartner(partnerId))
/*     */     {
/* 119 */       return null;
/*     */     }
/* 121 */     Property xProperty = (Property)this.partnerBag.getPartner2property().get(Integer.valueOf(partnerId));
/* 122 */     if (xProperty == null)
/*     */     {
/* 124 */       return null;
/*     */     }
/* 126 */     return new Partner(this.roleId, xProperty);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Property> getAllProperty()
/*     */   {
/* 136 */     return this.partnerBag.getPartner2property();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getAllPartnerScore()
/*     */   {
/* 146 */     Map<Integer, Integer> scores = new HashMap();
/* 147 */     if (this.partnerBag == null)
/*     */     {
/* 149 */       return scores;
/*     */     }
/* 151 */     for (Iterator i$ = this.partnerBag.getOwnpartnerids().iterator(); i$.hasNext();) { int partnerId = ((Integer)i$.next()).intValue();
/*     */       
/* 153 */       Property xProperty = (Property)this.partnerBag.getPartner2property().get(Integer.valueOf(partnerId));
/* 154 */       if (xProperty != null)
/*     */       {
/*     */ 
/*     */ 
/* 158 */         scores.put(Integer.valueOf(partnerId), Integer.valueOf(xProperty.getFightvalue())); }
/*     */     }
/* 160 */     return scores;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> getAllPartners()
/*     */   {
/* 170 */     return new HashSet(this.partnerBag.getOwnpartnerids());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\RolePartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */