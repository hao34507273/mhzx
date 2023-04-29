/*    */ package mzm.gsp.award;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MultiRoleAwardBean implements Marshal, Comparable<MultiRoleAwardBean>
/*    */ {
/*    */   public int id;
/*    */   public int count;
/*    */   
/*    */   public MultiRoleAwardBean() {}
/*    */   
/*    */   public MultiRoleAwardBean(int _id_, int _count_)
/*    */   {
/* 16 */     this.id = _id_;
/* 17 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.id);
/* 26 */     _os_.marshal(this.count);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.id = _os_.unmarshal_int();
/* 32 */     this.count = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof MultiRoleAwardBean)) {
/* 39 */       MultiRoleAwardBean _o_ = (MultiRoleAwardBean)_o1_;
/* 40 */       if (this.id != _o_.id) return false;
/* 41 */       if (this.count != _o_.count) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.id;
/* 50 */     _h_ += this.count;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.id).append(",");
/* 58 */     _sb_.append(this.count).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MultiRoleAwardBean _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.id - _o_.id;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.count - _o_.count;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\MultiRoleAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */