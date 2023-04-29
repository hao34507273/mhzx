/*    */ package mzm.gsp.drawandguess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class PointInfo implements Marshal
/*    */ {
/*    */   public float point_x;
/*    */   public float point_y;
/*    */   
/*    */   public PointInfo() {}
/*    */   
/*    */   public PointInfo(float _point_x_, float _point_y_)
/*    */   {
/* 16 */     this.point_x = _point_x_;
/* 17 */     this.point_y = _point_y_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.point_x);
/* 26 */     _os_.marshal(this.point_y);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.point_x = _os_.unmarshal_float();
/* 32 */     this.point_y = _os_.unmarshal_float();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof PointInfo)) {
/* 39 */       PointInfo _o_ = (PointInfo)_o1_;
/* 40 */       if (this.point_x != _o_.point_x) return false;
/* 41 */       if (this.point_y != _o_.point_y) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += Float.floatToIntBits(this.point_x);
/* 50 */     _h_ += Float.floatToIntBits(this.point_y);
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.point_x).append(",");
/* 58 */     _sb_.append(this.point_y).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\PointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */