/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class TreasureBoxItem implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<Integer> log_reason;
/*    */   public HashMap<Integer, Integer> item_map;
/*    */   public int remove_model;
/*    */   
/*    */   public TreasureBoxItem()
/*    */   {
/* 16 */     this.log_reason = new ArrayList();
/* 17 */     this.item_map = new HashMap();
/*    */   }
/*    */   
/*    */   public TreasureBoxItem(ArrayList<Integer> _log_reason_, HashMap<Integer, Integer> _item_map_, int _remove_model_) {
/* 21 */     this.log_reason = _log_reason_;
/* 22 */     this.item_map = _item_map_;
/* 23 */     this.remove_model = _remove_model_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.compact_uint32(this.log_reason.size());
/* 32 */     for (Integer _v_ : this.log_reason) {
/* 33 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 35 */     _os_.compact_uint32(this.item_map.size());
/* 36 */     for (Map.Entry<Integer, Integer> _e_ : this.item_map.entrySet()) {
/* 37 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 38 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 40 */     _os_.marshal(this.remove_model);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 45 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 47 */       int _v_ = _os_.unmarshal_int();
/* 48 */       this.log_reason.add(Integer.valueOf(_v_));
/*    */     }
/* 50 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 52 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 54 */       int _v_ = _os_.unmarshal_int();
/* 55 */       this.item_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 57 */     this.remove_model = _os_.unmarshal_int();
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof TreasureBoxItem)) {
/* 64 */       TreasureBoxItem _o_ = (TreasureBoxItem)_o1_;
/* 65 */       if (!this.log_reason.equals(_o_.log_reason)) return false;
/* 66 */       if (!this.item_map.equals(_o_.item_map)) return false;
/* 67 */       if (this.remove_model != _o_.remove_model) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.log_reason.hashCode();
/* 76 */     _h_ += this.item_map.hashCode();
/* 77 */     _h_ += this.remove_model;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.log_reason).append(",");
/* 85 */     _sb_.append(this.item_map).append(",");
/* 86 */     _sb_.append(this.remove_model).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\TreasureBoxItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */