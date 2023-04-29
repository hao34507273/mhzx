/*    */ package mzm.gsp.watchmoon.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class WatchMoonFinishArg
/*    */ {
/*  9 */   public final List<Long> roleList = new ArrayList();
/*    */   
/*    */   public WatchMoonFinishArg(List<Long> roleList)
/*    */   {
/* 13 */     this.roleList.addAll(roleList);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\event\WatchMoonFinishArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */