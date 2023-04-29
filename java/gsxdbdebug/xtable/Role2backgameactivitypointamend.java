/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.BackGameActivityAmendInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2backgameactivitypointamend
/*    */ {
/*    */   public static BackGameActivityAmendInfo get(Long key)
/*    */   {
/* 12 */     return (BackGameActivityAmendInfo)_Tables_.getInstance().role2backgameactivitypointamend.get(key);
/*    */   }
/*    */   
/*    */   public static BackGameActivityAmendInfo get(Long key, BackGameActivityAmendInfo value)
/*    */   {
/* 17 */     return (BackGameActivityAmendInfo)_Tables_.getInstance().role2backgameactivitypointamend.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BackGameActivityAmendInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2backgameactivitypointamend.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2backgameactivitypointamend.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BackGameActivityAmendInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2backgameactivitypointamend.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2backgameactivitypointamend.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, BackGameActivityAmendInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2backgameactivitypointamend.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BackGameActivityAmendInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2backgameactivitypointamend;
/*    */   }
/*    */   
/*    */   public static BackGameActivityAmendInfo select(Long key)
/*    */   {
/* 52 */     (BackGameActivityAmendInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public BackGameActivityAmendInfo get(BackGameActivityAmendInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectActivityidset(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(BackGameActivityAmendInfo v)
/*    */       {
/* 67 */         return v.getActivityidsetAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2backgameactivitypointamend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */