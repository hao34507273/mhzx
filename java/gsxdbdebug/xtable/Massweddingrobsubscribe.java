/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MassWeddingRobSubscribe;
/*    */ import xbean.MassWeddingRobSubscribeRoles;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Massweddingrobsubscribe
/*    */ {
/*    */   public static MassWeddingRobSubscribe get(Long key)
/*    */   {
/* 12 */     return (MassWeddingRobSubscribe)_Tables_.getInstance().massweddingrobsubscribe.get(key);
/*    */   }
/*    */   
/*    */   public static MassWeddingRobSubscribe get(Long key, MassWeddingRobSubscribe value)
/*    */   {
/* 17 */     return (MassWeddingRobSubscribe)_Tables_.getInstance().massweddingrobsubscribe.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassWeddingRobSubscribe value)
/*    */   {
/* 22 */     _Tables_.getInstance().massweddingrobsubscribe.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().massweddingrobsubscribe.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassWeddingRobSubscribe value)
/*    */   {
/* 32 */     return _Tables_.getInstance().massweddingrobsubscribe.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().massweddingrobsubscribe.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MassWeddingRobSubscribe> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().massweddingrobsubscribe.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassWeddingRobSubscribe> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().massweddingrobsubscribe;
/*    */   }
/*    */   
/*    */   public static MassWeddingRobSubscribe select(Long key)
/*    */   {
/* 52 */     (MassWeddingRobSubscribe)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MassWeddingRobSubscribe get(MassWeddingRobSubscribe v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, MassWeddingRobSubscribeRoles> selectRobsubscribemap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, MassWeddingRobSubscribeRoles> get(MassWeddingRobSubscribe v)
/*    */       {
/* 67 */         return v.getRobsubscribemapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Massweddingrobsubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */