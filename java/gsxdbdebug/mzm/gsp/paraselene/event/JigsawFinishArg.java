/*    */ package mzm.gsp.paraselene.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class JigsawFinishArg
/*    */ {
/*  8 */   private List<Long> sucroleids = new ArrayList();
/*  9 */   private List<Long> failedroleids = new ArrayList();
/* 10 */   private List<Long> allRoleids = new ArrayList();
/*    */   private int jigsawcfgid;
/*    */   private boolean ispassed;
/*    */   private JigsawContext context;
/*    */   
/*    */   public JigsawFinishArg(List<Long> sucroleids, List<Long> failedroleids, boolean ispassed, int jigsawcfgid, JigsawContext context) {
/* 16 */     this.sucroleids.addAll(sucroleids);
/* 17 */     this.failedroleids.addAll(failedroleids);
/* 18 */     this.ispassed = ispassed;
/* 19 */     this.jigsawcfgid = jigsawcfgid;
/* 20 */     this.context = context;
/* 21 */     this.allRoleids.addAll(sucroleids);
/* 22 */     this.allRoleids.addAll(failedroleids);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public JigsawContext getContext()
/*    */   {
/* 29 */     return this.context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Long> getSucroleids()
/*    */   {
/* 36 */     return this.sucroleids;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Long> getFailedroleids()
/*    */   {
/* 43 */     return this.failedroleids;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getJigsawcfgid()
/*    */   {
/* 50 */     return this.jigsawcfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isIspassed()
/*    */   {
/* 57 */     return this.ispassed;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Long> getAllRoleids()
/*    */   {
/* 64 */     return this.allRoleids;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\event\JigsawFinishArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */