/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.corps.CorpsBriefInfo;
/*     */ import xbean.Corps;
/*     */ import xbean.CorpsDutyMembers;
/*     */ 
/*     */ public class CorpsInfo
/*     */ {
/*     */   private final Corps xCorps;
/*     */   
/*     */   CorpsInfo(Corps xCorps)
/*     */   {
/*  16 */     this.xCorps = xCorps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getCorpsId()
/*     */   {
/*  26 */     return this.xCorps.getCorpsid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCorpsName()
/*     */   {
/*  36 */     return this.xCorps.getCorpsname();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getCorpsCreateTime()
/*     */   {
/*  46 */     return this.xCorps.getCreatetime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCorpsBadgeId()
/*     */   {
/*  56 */     return this.xCorps.getCorpsbadge();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getAllMemberIds()
/*     */   {
/*  66 */     Set<Long> allMembers = new java.util.HashSet();
/*  67 */     for (CorpsDutyMembers xCorpsDutyMembers : this.xCorps.getDuty2members().values())
/*     */     {
/*  69 */       allMembers.addAll(xCorpsDutyMembers.getMembers());
/*     */     }
/*  71 */     return allMembers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getCaptain()
/*     */   {
/*  81 */     CorpsDutyMembers xCorpsDutyMembers = (CorpsDutyMembers)this.xCorps.getDuty2members().get(Integer.valueOf(1));
/*  82 */     if (xCorpsDutyMembers == null)
/*     */     {
/*  84 */       return -1L;
/*     */     }
/*  86 */     long captainId = -1L;
/*  87 */     Set<Long> capatains = xCorpsDutyMembers.getMembers();
/*  88 */     Iterator i$ = capatains.iterator(); if (i$.hasNext()) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  90 */       captainId = roleId;
/*     */     }
/*     */     
/*  93 */     return captainId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getNormalMemberIds()
/*     */   {
/* 103 */     Set<Long> members = new java.util.HashSet();
/* 104 */     CorpsDutyMembers xCorpsDutyMembers = (CorpsDutyMembers)this.xCorps.getDuty2members().get(Integer.valueOf(2));
/* 105 */     if (xCorpsDutyMembers == null)
/*     */     {
/* 107 */       return members;
/*     */     }
/* 109 */     members.addAll(xCorpsDutyMembers.getMembers());
/* 110 */     return members;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getMultiFightValueAVG()
/*     */   {
/* 120 */     Set<Long> members = getAllMemberIds();
/* 121 */     if ((members == null) || (members.size() == 0))
/*     */     {
/* 123 */       return 0.0F;
/*     */     }
/* 125 */     float totalValue = 0.0F;
/* 126 */     for (Iterator i$ = getAllMemberIds().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 128 */       totalValue += mzm.gsp.role.main.RoleInterface.getRoleMFValue(roleId);
/*     */     }
/* 130 */     if (totalValue <= 0.0F)
/*     */     {
/* 132 */       return 0.0F;
/*     */     }
/* 134 */     return totalValue / members.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void fillBriefInfo(CorpsBriefInfo briefInfo)
/*     */   {
/* 144 */     CorpsManager.fillCorpsBriefInfo(this.xCorps, briefInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CorpsBriefInfo getBriefInfo()
/*     */   {
/* 154 */     CorpsBriefInfo briefInfo = new CorpsBriefInfo();
/* 155 */     fillBriefInfo(briefInfo);
/* 156 */     return briefInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\CorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */