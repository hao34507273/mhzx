/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PGM_ApplyMe extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final long targetid;
/*    */   private final int count;
/*    */   
/*    */   public PGM_ApplyMe(long targetid, int count)
/*    */   {
/* 14 */     this.targetid = targetid;
/* 15 */     this.count = count;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     int counter = 0;
/* 22 */     List<Long> roleids = OnlineManager.getInstance().getAllRolesInWorld();
/* 23 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 24 */       if (roleid != this.targetid)
/*    */       {
/*    */ 
/* 27 */         boolean suc = new PCAppplyAddFriend(roleid, this.targetid, "test Added!").call();
/* 28 */         if (suc) { counter++; if (counter >= this.count) {
/*    */             break;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PGM_ApplyMe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */