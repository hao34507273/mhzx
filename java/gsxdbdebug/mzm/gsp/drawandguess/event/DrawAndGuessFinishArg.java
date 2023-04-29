/*    */ package mzm.gsp.drawandguess.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.drawandguess.main.IDrawAndGuessContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrawAndGuessFinishArg
/*    */ {
/*    */   private final long drawer_id;
/* 12 */   private final List<Long> all_roleids = new ArrayList();
/* 13 */   private final List<Long> suc_roleids = new ArrayList();
/*    */   private final IDrawAndGuessContext context;
/*    */   
/*    */   public DrawAndGuessFinishArg(long drawer_id, List<Long> all_roleids, List<Long> suc_roleids, IDrawAndGuessContext context)
/*    */   {
/* 18 */     this.drawer_id = drawer_id;
/* 19 */     this.all_roleids.addAll(all_roleids);
/* 20 */     this.suc_roleids.addAll(suc_roleids);
/* 21 */     this.context = context;
/*    */   }
/*    */   
/*    */   public long getDrawer_id()
/*    */   {
/* 26 */     return this.drawer_id;
/*    */   }
/*    */   
/*    */   public List<Long> getSuc_roleids()
/*    */   {
/* 31 */     return this.suc_roleids;
/*    */   }
/*    */   
/*    */   public List<Long> getAll_roleids()
/*    */   {
/* 36 */     return this.all_roleids;
/*    */   }
/*    */   
/*    */   public IDrawAndGuessContext getContext()
/*    */   {
/* 41 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\event\DrawAndGuessFinishArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */