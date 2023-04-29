/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Bag;
/*    */ import xbean.OcpEquipBag;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2ocpequipbag
/*    */ {
/*    */   public static OcpEquipBag get(Long key)
/*    */   {
/* 12 */     return (OcpEquipBag)_Tables_.getInstance().role2ocpequipbag.get(key);
/*    */   }
/*    */   
/*    */   public static OcpEquipBag get(Long key, OcpEquipBag value)
/*    */   {
/* 17 */     return (OcpEquipBag)_Tables_.getInstance().role2ocpequipbag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, OcpEquipBag value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2ocpequipbag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2ocpequipbag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, OcpEquipBag value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2ocpequipbag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2ocpequipbag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, OcpEquipBag> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2ocpequipbag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, OcpEquipBag> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2ocpequipbag;
/*    */   }
/*    */   
/*    */   public static OcpEquipBag select(Long key)
/*    */   {
/* 52 */     (OcpEquipBag)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public OcpEquipBag get(OcpEquipBag v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Bag> selectOcp2equipbag(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, Bag> get(OcpEquipBag v)
/*    */       {
/* 67 */         return v.getOcp2equipbagAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2ocpequipbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */