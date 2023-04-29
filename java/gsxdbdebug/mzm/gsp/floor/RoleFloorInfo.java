/*    */ package mzm.gsp.floor;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class RoleFloorInfo
/*    */   implements Marshal, Comparable<RoleFloorInfo>
/*    */ {
/*    */   public int floor;
/*    */   public int usedtime;
/*    */   
/*    */   public RoleFloorInfo() {}
/*    */   
/*    */   public RoleFloorInfo(int _floor_, int _usedtime_)
/*    */   {
/* 18 */     this.floor = _floor_;
/* 19 */     this.usedtime = _usedtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.floor);
/* 28 */     _os_.marshal(this.usedtime);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.floor = _os_.unmarshal_int();
/* 34 */     this.usedtime = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof RoleFloorInfo)) {
/* 41 */       RoleFloorInfo _o_ = (RoleFloorInfo)_o1_;
/* 42 */       if (this.floor != _o_.floor) return false;
/* 43 */       if (this.usedtime != _o_.usedtime) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.floor;
/* 52 */     _h_ += this.usedtime;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.floor).append(",");
/* 60 */     _sb_.append(this.usedtime).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoleFloorInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.floor - _o_.floor;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.usedtime - _o_.usedtime;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\RoleFloorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */