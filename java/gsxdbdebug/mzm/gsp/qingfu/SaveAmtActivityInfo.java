/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SaveAmtActivityInfo implements Marshal, Comparable<SaveAmtActivityInfo>
/*    */ {
/*    */   public long base_save_amt;
/*    */   public int sortid;
/*    */   
/*    */   public SaveAmtActivityInfo() {}
/*    */   
/*    */   public SaveAmtActivityInfo(long _base_save_amt_, int _sortid_)
/*    */   {
/* 16 */     this.base_save_amt = _base_save_amt_;
/* 17 */     this.sortid = _sortid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.base_save_amt);
/* 26 */     _os_.marshal(this.sortid);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.base_save_amt = _os_.unmarshal_long();
/* 32 */     this.sortid = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof SaveAmtActivityInfo)) {
/* 39 */       SaveAmtActivityInfo _o_ = (SaveAmtActivityInfo)_o1_;
/* 40 */       if (this.base_save_amt != _o_.base_save_amt) return false;
/* 41 */       if (this.sortid != _o_.sortid) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += (int)this.base_save_amt;
/* 50 */     _h_ += this.sortid;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.base_save_amt).append(",");
/* 58 */     _sb_.append(this.sortid).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SaveAmtActivityInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = Long.signum(this.base_save_amt - _o_.base_save_amt);
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.sortid - _o_.sortid;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SaveAmtActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */