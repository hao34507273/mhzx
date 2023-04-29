/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class RolePosition
/*    */   implements Marshal, Comparable<RolePosition>
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   public RolePosition() {}
/*    */   
/*    */   public RolePosition(int _x_, int _y_)
/*    */   {
/* 18 */     this.x = _x_;
/* 19 */     this.y = _y_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.x);
/* 28 */     _os_.marshal(this.y);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.x = _os_.unmarshal_int();
/* 34 */     this.y = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof RolePosition)) {
/* 41 */       RolePosition _o_ = (RolePosition)_o1_;
/* 42 */       if (this.x != _o_.x) return false;
/* 43 */       if (this.y != _o_.y) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.x;
/* 52 */     _h_ += this.y;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.x).append(",");
/* 60 */     _sb_.append(this.y).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RolePosition _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.x - _o_.x;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.y - _o_.y;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\RolePosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */