/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MagicMarkSys;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2magicmark
/*    */ {
/*    */   public static MagicMarkSys get(Long key)
/*    */   {
/* 12 */     return (MagicMarkSys)_Tables_.getInstance().role2magicmark.get(key);
/*    */   }
/*    */   
/*    */   public static MagicMarkSys get(Long key, MagicMarkSys value)
/*    */   {
/* 17 */     return (MagicMarkSys)_Tables_.getInstance().role2magicmark.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MagicMarkSys value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2magicmark.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2magicmark.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MagicMarkSys value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2magicmark.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2magicmark.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MagicMarkSys> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2magicmark.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MagicMarkSys> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2magicmark;
/*    */   }
/*    */   
/*    */   public static MagicMarkSys select(Long key)
/*    */   {
/* 52 */     (MagicMarkSys)getTable().select(key, new TField()
/*    */     {
/*    */       public MagicMarkSys get(MagicMarkSys v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectEuqipedmagicmarktype(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MagicMarkSys v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getEuqipedmagicmarktype());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectPropmagicmarktype(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MagicMarkSys v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getPropmagicmarktype());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.MagicMarkInfo> selectMagicmarkinfos(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.MagicMarkInfo> get(MagicMarkSys v)
/*    */       {
/* 89 */         return v.getMagicmarkinfosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2magicmark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */