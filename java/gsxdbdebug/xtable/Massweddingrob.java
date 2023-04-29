/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MassWeddingRob;
/*    */ import xbean.MassWeddingRobRoles;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Massweddingrob
/*    */ {
/*    */   public static MassWeddingRob get(Long key)
/*    */   {
/* 12 */     return (MassWeddingRob)_Tables_.getInstance().massweddingrob.get(key);
/*    */   }
/*    */   
/*    */   public static MassWeddingRob get(Long key, MassWeddingRob value)
/*    */   {
/* 17 */     return (MassWeddingRob)_Tables_.getInstance().massweddingrob.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassWeddingRob value)
/*    */   {
/* 22 */     _Tables_.getInstance().massweddingrob.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().massweddingrob.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassWeddingRob value)
/*    */   {
/* 32 */     return _Tables_.getInstance().massweddingrob.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().massweddingrob.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MassWeddingRob> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().massweddingrob.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassWeddingRob> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().massweddingrob;
/*    */   }
/*    */   
/*    */   public static MassWeddingRob select(Long key)
/*    */   {
/* 52 */     (MassWeddingRob)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MassWeddingRob get(MassWeddingRob v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, MassWeddingRobRoles> selectRobmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, MassWeddingRobRoles> get(MassWeddingRob v)
/*    */       {
/* 67 */         return v.getRobmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Massweddingrob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */