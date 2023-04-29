/*     */ package mzm.gsp.role.changemodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import xbean.RoleChange;
/*     */ import xtable.Rolechangetable;
/*     */ 
/*     */ public class RoleChangeInfo
/*     */ {
/*     */   private long roleId;
/*     */   private RoleChange xChange;
/*     */   private boolean remainRoleLock;
/*     */   private boolean containsXData;
/*     */   
/*     */   public RoleChangeInfo(long roleId, boolean remainRoleLock)
/*     */   {
/*  18 */     this.roleId = roleId;
/*  19 */     this.remainRoleLock = remainRoleLock;
/*  20 */     if (remainRoleLock)
/*     */     {
/*  22 */       this.xChange = Rolechangetable.get(Long.valueOf(roleId));
/*  23 */       if (this.xChange == null)
/*     */       {
/*  25 */         this.xChange = xbean.Pod.newRoleChange();
/*  26 */         Rolechangetable.insert(Long.valueOf(roleId), this.xChange);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  31 */       this.xChange = Rolechangetable.select(Long.valueOf(roleId));
/*     */     }
/*  33 */     this.containsXData = (this.xChange != null);
/*     */   }
/*     */   
/*     */   public boolean isContainsXData()
/*     */   {
/*  38 */     return this.containsXData;
/*     */   }
/*     */   
/*     */   long getRoleId()
/*     */   {
/*  43 */     return this.roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static enum AddRes
/*     */   {
/*  54 */     SUC,  NO_ID,  CONTAINS,  UNREMAIN_ROLE_LOCK;
/*     */     
/*     */ 
/*     */ 
/*     */     private AddRes() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   AddRes addChangeId(int changeId)
/*     */   {
/*  65 */     if (!this.remainRoleLock)
/*     */     {
/*  67 */       return AddRes.UNREMAIN_ROLE_LOCK;
/*     */     }
/*  69 */     if (!RoleChangeModelManager.isChangeIdExist(changeId))
/*     */     {
/*  71 */       return AddRes.NO_ID;
/*     */     }
/*  73 */     List<Integer> changeIds = this.xChange.getChangeids();
/*  74 */     if (changeIds.contains(Integer.valueOf(changeId)))
/*     */     {
/*  76 */       return AddRes.CONTAINS;
/*     */     }
/*  78 */     changeIds.add(Integer.valueOf(changeId));
/*  79 */     return AddRes.SUC;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean rmChangeId(int changeId)
/*     */   {
/*  90 */     if (!this.remainRoleLock)
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     List<Integer> changeIds = this.xChange.getChangeids();
/*  95 */     if (!changeIds.contains(Integer.valueOf(changeId)))
/*     */     {
/*  97 */       return true;
/*     */     }
/*  99 */     changeIds.remove(new Integer(changeId));
/* 100 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getRoleChangeIds()
/*     */   {
/* 110 */     if (!isContainsXData())
/*     */     {
/* 112 */       return new ArrayList();
/*     */     }
/* 114 */     return this.xChange.getChangeids();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getNeedShowChangeId()
/*     */   {
/* 124 */     if (!isContainsXData())
/*     */     {
/* 126 */       return -1;
/*     */     }
/* 128 */     return getMaxPriority(this.xChange.getChangeids());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean needNoticeOthersChange(int changeId)
/*     */   {
/* 139 */     if (!isContainsXData())
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     List<Integer> changeIds = this.xChange.getChangeids();
/* 144 */     if (!changeIds.contains(Integer.valueOf(changeId)))
/*     */     {
/* 146 */       return false;
/*     */     }
/* 148 */     return changeId == getNeedShowChangeId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getMaxPriority(Collection<Integer> changeIds)
/*     */   {
/* 159 */     if ((changeIds == null) || (changeIds.size() == 0))
/*     */     {
/* 161 */       return -1;
/*     */     }
/* 163 */     return ((Integer)java.util.Collections.max(changeIds, new RoleChangeIdComparator())).intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\RoleChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */