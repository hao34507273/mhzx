/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AllWorlds;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Allparaworlds
/*    */ {
/*    */   public static AllWorlds get(Long key)
/*    */   {
/* 12 */     return (AllWorlds)_Tables_.getInstance().allparaworlds.get(key);
/*    */   }
/*    */   
/*    */   public static AllWorlds get(Long key, AllWorlds value)
/*    */   {
/* 17 */     return (AllWorlds)_Tables_.getInstance().allparaworlds.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AllWorlds value)
/*    */   {
/* 22 */     _Tables_.getInstance().allparaworlds.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().allparaworlds.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AllWorlds value)
/*    */   {
/* 32 */     return _Tables_.getInstance().allparaworlds.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().allparaworlds.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AllWorlds> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().allparaworlds.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AllWorlds> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().allparaworlds;
/*    */   }
/*    */   
/*    */   public static AllWorlds select(Long key)
/*    */   {
/* 52 */     (AllWorlds)getTable().select(key, new TField()
/*    */     {
/*    */       public AllWorlds get(AllWorlds v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Long> selectTeamid2worldid(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Long> get(AllWorlds v)
/*    */       {
/* 67 */         return v.getTeamid2worldidAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Allparaworlds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */