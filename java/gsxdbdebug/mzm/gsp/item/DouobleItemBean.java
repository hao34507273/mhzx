/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class DouobleItemBean
/*    */   implements Marshal, Comparable<DouobleItemBean>
/*    */ {
/*    */   public int trigger_item_id;
/*    */   public int double_item_id;
/*    */   public int double_item_number;
/*    */   
/*    */   public DouobleItemBean() {}
/*    */   
/*    */   public DouobleItemBean(int _trigger_item_id_, int _double_item_id_, int _double_item_number_)
/*    */   {
/* 19 */     this.trigger_item_id = _trigger_item_id_;
/* 20 */     this.double_item_id = _double_item_id_;
/* 21 */     this.double_item_number = _double_item_number_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.trigger_item_id);
/* 30 */     _os_.marshal(this.double_item_id);
/* 31 */     _os_.marshal(this.double_item_number);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.trigger_item_id = _os_.unmarshal_int();
/* 37 */     this.double_item_id = _os_.unmarshal_int();
/* 38 */     this.double_item_number = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof DouobleItemBean)) {
/* 45 */       DouobleItemBean _o_ = (DouobleItemBean)_o1_;
/* 46 */       if (this.trigger_item_id != _o_.trigger_item_id) return false;
/* 47 */       if (this.double_item_id != _o_.double_item_id) return false;
/* 48 */       if (this.double_item_number != _o_.double_item_number) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.trigger_item_id;
/* 57 */     _h_ += this.double_item_id;
/* 58 */     _h_ += this.double_item_number;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.trigger_item_id).append(",");
/* 66 */     _sb_.append(this.double_item_id).append(",");
/* 67 */     _sb_.append(this.double_item_number).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(DouobleItemBean _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.trigger_item_id - _o_.trigger_item_id;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.double_item_id - _o_.double_item_id;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.double_item_number - _o_.double_item_number;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\DouobleItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */