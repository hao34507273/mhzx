/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayCapture
/*    */   implements Marshal, Comparable<PlayCapture>
/*    */ {
/*    */   public static final int CAPTURE_SUCCESS = 0;
/*    */   public static final int CAPTURE_FAIL = 1;
/*    */   public int fighterid;
/*    */   public int capturedfighterid;
/*    */   public int result;
/*    */   
/*    */   public PlayCapture() {}
/*    */   
/*    */   public PlayCapture(int _fighterid_, int _capturedfighterid_, int _result_)
/*    */   {
/* 22 */     this.fighterid = _fighterid_;
/* 23 */     this.capturedfighterid = _capturedfighterid_;
/* 24 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.fighterid);
/* 33 */     _os_.marshal(this.capturedfighterid);
/* 34 */     _os_.marshal(this.result);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.fighterid = _os_.unmarshal_int();
/* 40 */     this.capturedfighterid = _os_.unmarshal_int();
/* 41 */     this.result = _os_.unmarshal_int();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof PlayCapture)) {
/* 48 */       PlayCapture _o_ = (PlayCapture)_o1_;
/* 49 */       if (this.fighterid != _o_.fighterid) return false;
/* 50 */       if (this.capturedfighterid != _o_.capturedfighterid) return false;
/* 51 */       if (this.result != _o_.result) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.fighterid;
/* 60 */     _h_ += this.capturedfighterid;
/* 61 */     _h_ += this.result;
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.fighterid).append(",");
/* 69 */     _sb_.append(this.capturedfighterid).append(",");
/* 70 */     _sb_.append(this.result).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PlayCapture _o_) {
/* 76 */     if (_o_ == this) return 0;
/* 77 */     int _c_ = 0;
/* 78 */     _c_ = this.fighterid - _o_.fighterid;
/* 79 */     if (0 != _c_) return _c_;
/* 80 */     _c_ = this.capturedfighterid - _o_.capturedfighterid;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.result - _o_.result;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */