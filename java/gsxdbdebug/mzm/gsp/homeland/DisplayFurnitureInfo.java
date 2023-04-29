/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class DisplayFurnitureInfo implements Marshal, Comparable<DisplayFurnitureInfo>
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   public int direction;
/*    */   public int furnitureid;
/*    */   
/*    */   public DisplayFurnitureInfo() {}
/*    */   
/*    */   public DisplayFurnitureInfo(int _x_, int _y_, int _direction_, int _furnitureid_)
/*    */   {
/* 18 */     this.x = _x_;
/* 19 */     this.y = _y_;
/* 20 */     this.direction = _direction_;
/* 21 */     this.furnitureid = _furnitureid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.x);
/* 30 */     _os_.marshal(this.y);
/* 31 */     _os_.marshal(this.direction);
/* 32 */     _os_.marshal(this.furnitureid);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.x = _os_.unmarshal_int();
/* 38 */     this.y = _os_.unmarshal_int();
/* 39 */     this.direction = _os_.unmarshal_int();
/* 40 */     this.furnitureid = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof DisplayFurnitureInfo)) {
/* 47 */       DisplayFurnitureInfo _o_ = (DisplayFurnitureInfo)_o1_;
/* 48 */       if (this.x != _o_.x) return false;
/* 49 */       if (this.y != _o_.y) return false;
/* 50 */       if (this.direction != _o_.direction) return false;
/* 51 */       if (this.furnitureid != _o_.furnitureid) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.x;
/* 60 */     _h_ += this.y;
/* 61 */     _h_ += this.direction;
/* 62 */     _h_ += this.furnitureid;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.x).append(",");
/* 70 */     _sb_.append(this.y).append(",");
/* 71 */     _sb_.append(this.direction).append(",");
/* 72 */     _sb_.append(this.furnitureid).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(DisplayFurnitureInfo _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.x - _o_.x;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.y - _o_.y;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.direction - _o_.direction;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.furnitureid - _o_.furnitureid;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\DisplayFurnitureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */