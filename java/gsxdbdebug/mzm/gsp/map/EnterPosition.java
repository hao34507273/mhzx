/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class EnterPosition implements Marshal, Comparable<EnterPosition>
/*    */ {
/*    */   public int curx;
/*    */   public int cury;
/*    */   public int targetx;
/*    */   public int targety;
/*    */   public int direction;
/*    */   
/*    */   public EnterPosition() {}
/*    */   
/*    */   public EnterPosition(int _curx_, int _cury_, int _targetx_, int _targety_, int _direction_)
/*    */   {
/* 19 */     this.curx = _curx_;
/* 20 */     this.cury = _cury_;
/* 21 */     this.targetx = _targetx_;
/* 22 */     this.targety = _targety_;
/* 23 */     this.direction = _direction_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.curx);
/* 32 */     _os_.marshal(this.cury);
/* 33 */     _os_.marshal(this.targetx);
/* 34 */     _os_.marshal(this.targety);
/* 35 */     _os_.marshal(this.direction);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.curx = _os_.unmarshal_int();
/* 41 */     this.cury = _os_.unmarshal_int();
/* 42 */     this.targetx = _os_.unmarshal_int();
/* 43 */     this.targety = _os_.unmarshal_int();
/* 44 */     this.direction = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof EnterPosition)) {
/* 51 */       EnterPosition _o_ = (EnterPosition)_o1_;
/* 52 */       if (this.curx != _o_.curx) return false;
/* 53 */       if (this.cury != _o_.cury) return false;
/* 54 */       if (this.targetx != _o_.targetx) return false;
/* 55 */       if (this.targety != _o_.targety) return false;
/* 56 */       if (this.direction != _o_.direction) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.curx;
/* 65 */     _h_ += this.cury;
/* 66 */     _h_ += this.targetx;
/* 67 */     _h_ += this.targety;
/* 68 */     _h_ += this.direction;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.curx).append(",");
/* 76 */     _sb_.append(this.cury).append(",");
/* 77 */     _sb_.append(this.targetx).append(",");
/* 78 */     _sb_.append(this.targety).append(",");
/* 79 */     _sb_.append(this.direction).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(EnterPosition _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.curx - _o_.curx;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.cury - _o_.cury;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.targetx - _o_.targetx;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.targety - _o_.targety;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.direction - _o_.direction;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\EnterPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */