/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Role2PetMarkInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2petmark
/*    */ {
/*    */   public static Role2PetMarkInfo get(Long key)
/*    */   {
/* 12 */     return (Role2PetMarkInfo)_Tables_.getInstance().role2petmark.get(key);
/*    */   }
/*    */   
/*    */   public static Role2PetMarkInfo get(Long key, Role2PetMarkInfo value)
/*    */   {
/* 17 */     return (Role2PetMarkInfo)_Tables_.getInstance().role2petmark.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2PetMarkInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2petmark.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2petmark.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2PetMarkInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2petmark.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2petmark.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2PetMarkInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2petmark.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2PetMarkInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2petmark;
/*    */   }
/*    */   
/*    */   public static Role2PetMarkInfo select(Long key)
/*    */   {
/* 52 */     (Role2PetMarkInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public Role2PetMarkInfo get(Role2PetMarkInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectNext_pet_mark_id(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Role2PetMarkInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getNext_pet_mark_id());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.PetMarkInfo> selectPetmarkid2info(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.PetMarkInfo> get(Role2PetMarkInfo v)
/*    */       {
/* 78 */         return v.getPetmarkid2infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Long> selectPetid2petmarkid(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Long> get(Role2PetMarkInfo v)
/*    */       {
/* 89 */         return v.getPetid2petmarkidAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2petmark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */