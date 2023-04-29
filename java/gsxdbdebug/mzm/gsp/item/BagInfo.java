/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class BagInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public static final int BAG = 340600000;
/*    */   public static final int EQUIPBAG = 340600001;
/*    */   public static final int SUPER_EQUIPMENT_JEWEL_BAG = 340600005;
/*    */   public static final int FABAO_BAG = 340600006;
/*    */   public static final int CHANGE_MODEL_CARD_BAG = 340600007;
/*    */   public static final int TREASURE_BAG = 340600008;
/*    */   public static final int PET_MARK_BAG = 340600009;
/*    */   public String name;
/*    */   public int capacity;
/*    */   public HashMap<Integer, ItemInfo> items;
/*    */   
/*    */   public BagInfo()
/*    */   {
/* 22 */     this.name = "";
/* 23 */     this.items = new HashMap();
/*    */   }
/*    */   
/*    */   public BagInfo(String _name_, int _capacity_, HashMap<Integer, ItemInfo> _items_) {
/* 27 */     this.name = _name_;
/* 28 */     this.capacity = _capacity_;
/* 29 */     this.items = _items_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     if (this.capacity < 0) return false;
/* 34 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.items.entrySet()) {
/* 35 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 41 */     _os_.marshal(this.name, "UTF-16LE");
/* 42 */     _os_.marshal(this.capacity);
/* 43 */     _os_.compact_uint32(this.items.size());
/* 44 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.items.entrySet()) {
/* 45 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 46 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 52 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 53 */     this.capacity = _os_.unmarshal_int();
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/* 57 */       ItemInfo _v_ = new ItemInfo();
/* 58 */       _v_.unmarshal(_os_);
/* 59 */       this.items.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof BagInfo)) {
/* 67 */       BagInfo _o_ = (BagInfo)_o1_;
/* 68 */       if (!this.name.equals(_o_.name)) return false;
/* 69 */       if (this.capacity != _o_.capacity) return false;
/* 70 */       if (!this.items.equals(_o_.items)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.name.hashCode();
/* 79 */     _h_ += this.capacity;
/* 80 */     _h_ += this.items.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append("T").append(this.name.length()).append(",");
/* 88 */     _sb_.append(this.capacity).append(",");
/* 89 */     _sb_.append(this.items).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\BagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */