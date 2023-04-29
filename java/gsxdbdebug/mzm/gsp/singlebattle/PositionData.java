/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class PositionData
/*    */   implements Marshal, Comparable<PositionData>
/*    */ {
/*    */   public static final int STATE_NULL = 1;
/*    */   public static final int STATE_GRABING = 2;
/*    */   public static final int STATE_PROTECT = 3;
/*    */   public int campid;
/*    */   public int positionstate;
/*    */   
/*    */   public PositionData() {}
/*    */   
/*    */   public PositionData(int _campid_, int _positionstate_)
/*    */   {
/* 20 */     this.campid = _campid_;
/* 21 */     this.positionstate = _positionstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.campid);
/* 30 */     _os_.marshal(this.positionstate);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.campid = _os_.unmarshal_int();
/* 36 */     this.positionstate = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof PositionData)) {
/* 43 */       PositionData _o_ = (PositionData)_o1_;
/* 44 */       if (this.campid != _o_.campid) return false;
/* 45 */       if (this.positionstate != _o_.positionstate) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.campid;
/* 54 */     _h_ += this.positionstate;
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.campid).append(",");
/* 62 */     _sb_.append(this.positionstate).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PositionData _o_) {
/* 68 */     if (_o_ == this) return 0;
/* 69 */     int _c_ = 0;
/* 70 */     _c_ = this.campid - _o_.campid;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     _c_ = this.positionstate - _o_.positionstate;
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\PositionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */