/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.CrossCompeteTmp;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Crosscompete_tmp
/*    */ {
/*    */   public static CrossCompeteTmp get(Long key)
/*    */   {
/* 12 */     return (CrossCompeteTmp)_Tables_.getInstance().crosscompete_tmp.get(key);
/*    */   }
/*    */   
/*    */   public static CrossCompeteTmp get(Long key, CrossCompeteTmp value)
/*    */   {
/* 17 */     return (CrossCompeteTmp)_Tables_.getInstance().crosscompete_tmp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossCompeteTmp value)
/*    */   {
/* 22 */     _Tables_.getInstance().crosscompete_tmp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().crosscompete_tmp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossCompeteTmp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().crosscompete_tmp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().crosscompete_tmp.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossCompeteTmp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().crosscompete_tmp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossCompeteTmp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().crosscompete_tmp;
/*    */   }
/*    */   
/*    */   public static CrossCompeteTmp select(Long key)
/*    */   {
/* 52 */     (CrossCompeteTmp)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossCompeteTmp get(CrossCompeteTmp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<CrossCompeteMatch, xbean.CrossCompeteAgainstTmp> selectAgainsts(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<CrossCompeteMatch, xbean.CrossCompeteAgainstTmp> get(CrossCompeteTmp v)
/*    */       {
/* 67 */         return v.getAgainstsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Crosscompete_tmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */