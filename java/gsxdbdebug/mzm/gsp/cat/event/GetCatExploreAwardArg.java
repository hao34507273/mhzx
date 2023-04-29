/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*    */ 
/*    */ public class GetCatExploreAwardArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long catid;
/*    */   public final Map<Integer, Integer> items;
/*    */   
/*    */   public GetCatExploreAwardArg(long roleid, long catid, Map<Integer, Integer> items)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.catid = catid;
/* 19 */     if (items != null)
/*    */     {
/* 21 */       Map<Integer, Integer> tmp = new java.util.HashMap(items);
/* 22 */       this.items = Collections.unmodifiableMap(tmp);
/*    */     }
/*    */     else
/*    */     {
/* 26 */       this.items = Collections.emptyMap();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean haveBird()
/*    */   {
/* 32 */     for (Iterator i$ = this.items.keySet().iterator(); i$.hasNext();) { int itemCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 34 */       if (itemCfgid == SCatCfgConsts.getInstance().BIRD)
/*    */       {
/* 36 */         return true;
/*    */       }
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\GetCatExploreAwardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */