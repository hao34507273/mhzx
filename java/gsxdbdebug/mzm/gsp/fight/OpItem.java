/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class OpItem
/*    */   implements Marshal, Comparable<OpItem>
/*    */ {
/*    */   public int item_cfgid;
/*    */   public int main_target;
/*    */   
/*    */   public OpItem() {}
/*    */   
/*    */   public OpItem(int _item_cfgid_, int _main_target_)
/*    */   {
/* 18 */     this.item_cfgid = _item_cfgid_;
/* 19 */     this.main_target = _main_target_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.item_cfgid);
/* 28 */     _os_.marshal(this.main_target);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.item_cfgid = _os_.unmarshal_int();
/* 34 */     this.main_target = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof OpItem)) {
/* 41 */       OpItem _o_ = (OpItem)_o1_;
/* 42 */       if (this.item_cfgid != _o_.item_cfgid) return false;
/* 43 */       if (this.main_target != _o_.main_target) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.item_cfgid;
/* 52 */     _h_ += this.main_target;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.item_cfgid).append(",");
/* 60 */     _sb_.append(this.main_target).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(OpItem _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.item_cfgid - _o_.item_cfgid;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.main_target - _o_.main_target;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\OpItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */