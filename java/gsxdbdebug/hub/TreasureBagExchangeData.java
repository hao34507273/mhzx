/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class TreasureBagExchangeData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<TreasureBoxItem> remove_item_list;
/*    */   
/*    */   public TreasureBagExchangeData()
/*    */   {
/* 12 */     this.remove_item_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public TreasureBagExchangeData(ArrayList<TreasureBoxItem> _remove_item_list_) {
/* 16 */     this.remove_item_list = _remove_item_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (TreasureBoxItem _v_ : this.remove_item_list)
/* 21 */       if (!_v_._validator_()) return false;
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.remove_item_list.size());
/* 27 */     for (TreasureBoxItem _v_ : this.remove_item_list) {
/* 28 */       _os_.marshal(_v_);
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 35 */       TreasureBoxItem _v_ = new TreasureBoxItem();
/* 36 */       _v_.unmarshal(_os_);
/* 37 */       this.remove_item_list.add(_v_);
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof TreasureBagExchangeData)) {
/* 45 */       TreasureBagExchangeData _o_ = (TreasureBagExchangeData)_o1_;
/* 46 */       if (!this.remove_item_list.equals(_o_.remove_item_list)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.remove_item_list.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.remove_item_list).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\TreasureBagExchangeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */