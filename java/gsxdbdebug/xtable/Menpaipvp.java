/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.MenpaiPVP;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Menpaipvp
/*    */ {
/*    */   public static MenpaiPVP get(Long key)
/*    */   {
/* 12 */     return (MenpaiPVP)_Tables_.getInstance().menpaipvp.get(key);
/*    */   }
/*    */   
/*    */   public static MenpaiPVP get(Long key, MenpaiPVP value)
/*    */   {
/* 17 */     return (MenpaiPVP)_Tables_.getInstance().menpaipvp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MenpaiPVP value)
/*    */   {
/* 22 */     _Tables_.getInstance().menpaipvp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().menpaipvp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MenpaiPVP value)
/*    */   {
/* 32 */     return _Tables_.getInstance().menpaipvp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().menpaipvp.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MenpaiPVP> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().menpaipvp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MenpaiPVP> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().menpaipvp;
/*    */   }
/*    */   
/*    */   public static MenpaiPVP select(Long key)
/*    */   {
/* 52 */     (MenpaiPVP)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MenpaiPVP get(MenpaiPVP v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectMenpai2world(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, Long> get(MenpaiPVP v)
/*    */       {
/* 67 */         return v.getMenpai2worldAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectFights(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Long> get(MenpaiPVP v)
/*    */       {
/* 78 */         return v.getFightsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIsfinished(Long key)
/*    */   {
/* 85 */     (Boolean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Boolean get(MenpaiPVP v)
/*    */       {
/* 89 */         return Boolean.valueOf(v.getIsfinished());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Menpaipvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */