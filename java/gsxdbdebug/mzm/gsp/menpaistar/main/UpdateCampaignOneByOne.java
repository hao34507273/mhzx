/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ public class UpdateCampaignOneByOne
/*    */ {
/* 13 */   private static final UpdateCampaignOneByOne instance = new UpdateCampaignOneByOne();
/*    */   
/*    */   public static UpdateCampaignOneByOne getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */   
/* 20 */   private final Map<Integer, TaskOneByOne> tasks = new HashMap();
/*    */   
/*    */ 
/*    */   private UpdateCampaignOneByOne()
/*    */   {
/* 25 */     for (Iterator i$ = RoleInterface.getAllOccupationIds().iterator(); i$.hasNext();) { int occupationid = ((Integer)i$.next()).intValue();
/*    */       
/* 27 */       this.tasks.put(Integer.valueOf(occupationid), new TaskOneByOne());
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean add(int occupationid, LogicRunnable r)
/*    */   {
/* 33 */     TaskOneByOne queue = (TaskOneByOne)this.tasks.get(Integer.valueOf(occupationid));
/* 34 */     if (queue == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     return queue.add(r);
/*    */   }
/*    */   
/*    */   public boolean add(int occupationid, LogicProcedure r)
/*    */   {
/* 43 */     TaskOneByOne queue = (TaskOneByOne)this.tasks.get(Integer.valueOf(occupationid));
/* 44 */     if (queue == null)
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     return queue.add(r);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\UpdateCampaignOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */