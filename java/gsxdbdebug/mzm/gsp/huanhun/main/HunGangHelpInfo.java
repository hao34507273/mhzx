/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.CallHelpData;
/*     */ import xbean.GangHelpInfo;
/*     */ 
/*     */ public class HunGangHelpInfo
/*     */ {
/*     */   private final GangHelpInfo xHelpInfo;
/*     */   
/*     */   public HunGangHelpInfo(GangHelpInfo xHelpInfo)
/*     */   {
/*  13 */     this.xHelpInfo = xHelpInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addRoleHelp(long roleId, int boxIndex, int itemId, int num, long nowSecond)
/*     */   {
/*  32 */     CallHelpData xCallHelpData = (CallHelpData)this.xHelpInfo.getRole2helpdata().get(Long.valueOf(roleId));
/*  33 */     if (xCallHelpData == null)
/*     */     {
/*  35 */       xCallHelpData = xbean.Pod.newCallHelpData();
/*  36 */       this.xHelpInfo.getRole2helpdata().put(Long.valueOf(roleId), xCallHelpData);
/*     */     }
/*  38 */     xbean.BoxData xBoxData = (xbean.BoxData)xCallHelpData.getBoxindex2data().get(Integer.valueOf(boxIndex));
/*  39 */     if (xBoxData == null)
/*     */     {
/*  41 */       xBoxData = xbean.Pod.newBoxData();
/*  42 */       xCallHelpData.getBoxindex2data().put(Integer.valueOf(boxIndex), xBoxData);
/*     */     }
/*  44 */     xBoxData.setItemid(itemId);
/*  45 */     xBoxData.setNum(num);
/*  46 */     xBoxData.setStarttime(nowSecond);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void rmRoleHelp(long roleId, java.util.Set<Integer> boxIndexs)
/*     */   {
/*  59 */     if ((boxIndexs == null) || (boxIndexs.size() == 0))
/*     */     {
/*  61 */       return;
/*     */     }
/*  63 */     CallHelpData xCallHelpData = (CallHelpData)this.xHelpInfo.getRole2helpdata().get(Long.valueOf(roleId));
/*  64 */     if (xCallHelpData == null)
/*     */     {
/*  66 */       return;
/*     */     }
/*  68 */     for (java.util.Iterator i$ = boxIndexs.iterator(); i$.hasNext();) { int index = ((Integer)i$.next()).intValue();
/*     */       
/*  70 */       xCallHelpData.getBoxindex2data().remove(Integer.valueOf(index));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   java.util.Set<Integer> rmRoleHelp(long roleId)
/*     */   {
/*  82 */     CallHelpData xCallHelpData = (CallHelpData)this.xHelpInfo.getRole2helpdata().get(Long.valueOf(roleId));
/*  83 */     if (xCallHelpData == null)
/*     */     {
/*  85 */       return new java.util.HashSet();
/*     */     }
/*  87 */     java.util.Set<Integer> indexs = xCallHelpData.getBoxindex2data().keySet();
/*  88 */     if ((indexs == null) || (indexs.size() == 0))
/*     */     {
/*  90 */       return new java.util.HashSet();
/*     */     }
/*  92 */     this.xHelpInfo.getRole2helpdata().remove(Long.valueOf(roleId));
/*  93 */     return indexs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isBoxCallHelped(long roleId, int boxIndex)
/*     */   {
/* 107 */     CallHelpData xCallHelpData = (CallHelpData)this.xHelpInfo.getRole2helpdata().get(Long.valueOf(roleId));
/* 108 */     if (xCallHelpData == null)
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     return xCallHelpData.getBoxindex2data().containsKey(Integer.valueOf(boxIndex));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HunGangHelpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */