/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class Location implements Marshal, Comparable<Location>
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   public Location() {}
/*    */   
/*    */   public Location(int _x_, int _y_)
/*    */   {
/* 16 */     this.x = _x_;
/* 17 */     this.y = _y_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.x);
/* 26 */     _os_.marshal(this.y);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.x = _os_.unmarshal_int();
/* 32 */     this.y = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof Location)) {
/* 39 */       Location _o_ = (Location)_o1_;
/* 40 */       if (this.x != _o_.x) return false;
/* 41 */       if (this.y != _o_.y) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.x;
/* 50 */     _h_ += this.y;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.x).append(",");
/* 58 */     _sb_.append(this.y).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Location _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.x - _o_.x;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.y - _o_.y;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\Location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */