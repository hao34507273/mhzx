/*    */ package mzm.gsp.friendscircle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ChangeOrnament implements Marshal, Comparable<ChangeOrnament>
/*    */ {
/*    */   public int add_item_cfg_id;
/*    */   public int cut_item_cfg_id;
/*    */   
/*    */   public ChangeOrnament() {}
/*    */   
/*    */   public ChangeOrnament(int _add_item_cfg_id_, int _cut_item_cfg_id_)
/*    */   {
/* 16 */     this.add_item_cfg_id = _add_item_cfg_id_;
/* 17 */     this.cut_item_cfg_id = _cut_item_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.add_item_cfg_id);
/* 26 */     _os_.marshal(this.cut_item_cfg_id);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.add_item_cfg_id = _os_.unmarshal_int();
/* 32 */     this.cut_item_cfg_id = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof ChangeOrnament)) {
/* 39 */       ChangeOrnament _o_ = (ChangeOrnament)_o1_;
/* 40 */       if (this.add_item_cfg_id != _o_.add_item_cfg_id) return false;
/* 41 */       if (this.cut_item_cfg_id != _o_.cut_item_cfg_id) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.add_item_cfg_id;
/* 50 */     _h_ += this.cut_item_cfg_id;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.add_item_cfg_id).append(",");
/* 58 */     _sb_.append(this.cut_item_cfg_id).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ChangeOrnament _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.add_item_cfg_id - _o_.add_item_cfg_id;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.cut_item_cfg_id - _o_.cut_item_cfg_id;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\ChangeOrnament.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */