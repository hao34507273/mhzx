/*    */ package mzm.gsp.open.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ class ModuleFunSwitchInfo
/*    */ {
/*    */   private final int moduleid;
/*    */   private final int funid;
/*    */   private List<Integer> params;
/*    */   
/*    */   ModuleFunSwitchInfo(int moduleid, int funid)
/*    */   {
/* 16 */     this(moduleid, funid, null);
/*    */   }
/*    */   
/*    */   ModuleFunSwitchInfo(int moduleid, int funid, List<Integer> params)
/*    */   {
/* 21 */     this.moduleid = moduleid;
/* 22 */     this.funid = funid;
/*    */     
/* 24 */     setParams(params);
/*    */   }
/*    */   
/*    */   public int getModuleid()
/*    */   {
/* 29 */     return this.moduleid;
/*    */   }
/*    */   
/*    */   public int getFunid()
/*    */   {
/* 34 */     return this.funid;
/*    */   }
/*    */   
/*    */   public List<Integer> getParams()
/*    */   {
/* 39 */     if (this.params == null)
/*    */     {
/* 41 */       return Collections.emptyList();
/*    */     }
/*    */     
/* 44 */     return this.params;
/*    */   }
/*    */   
/*    */   void setParams(List<Integer> params)
/*    */   {
/* 49 */     if ((params == null) || (params.isEmpty()))
/*    */     {
/* 51 */       this.params = null;
/* 52 */       return;
/*    */     }
/*    */     
/* 55 */     if (this.params == null)
/*    */     {
/* 57 */       this.params = new LinkedList();
/*    */     }
/*    */     else
/*    */     {
/* 61 */       this.params.clear();
/*    */     }
/* 63 */     this.params.addAll(params);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\main\ModuleFunSwitchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */