/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class PointRaceQueryRsp
/*    */   implements Marshal, Comparable<PointRaceQueryRsp>
/*    */ {
/*    */   public byte exist;
/*    */   
/*    */   public PointRaceQueryRsp() {}
/*    */   
/*    */   public PointRaceQueryRsp(byte _exist_)
/*    */   {
/* 17 */     this.exist = _exist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.exist);
/* 26 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 30 */     this.exist = _os_.unmarshal_byte();
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 35 */     if (_o1_ == this) return true;
/* 36 */     if ((_o1_ instanceof PointRaceQueryRsp)) {
/* 37 */       PointRaceQueryRsp _o_ = (PointRaceQueryRsp)_o1_;
/* 38 */       if (this.exist != _o_.exist) return false;
/* 39 */       return true;
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 45 */     int _h_ = 0;
/* 46 */     _h_ += this.exist;
/* 47 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuilder _sb_ = new StringBuilder();
/* 52 */     _sb_.append("(");
/* 53 */     _sb_.append(this.exist).append(",");
/* 54 */     _sb_.append(")");
/* 55 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PointRaceQueryRsp _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     _c_ = this.exist - _o_.exist;
/* 62 */     if (0 != _c_) return _c_;
/* 63 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceQueryRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */