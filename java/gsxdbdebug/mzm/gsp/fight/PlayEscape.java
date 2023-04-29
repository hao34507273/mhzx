/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayEscape
/*    */   implements Marshal, Comparable<PlayEscape>
/*    */ {
/*    */   public static final int SUCCESS = 0;
/*    */   public static final int FAIL = 1;
/*    */   public int fighterid;
/*    */   public int suc;
/*    */   public int sucrate;
/*    */   
/*    */   public PlayEscape() {}
/*    */   
/*    */   public PlayEscape(int _fighterid_, int _suc_, int _sucrate_)
/*    */   {
/* 22 */     this.fighterid = _fighterid_;
/* 23 */     this.suc = _suc_;
/* 24 */     this.sucrate = _sucrate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.fighterid);
/* 33 */     _os_.marshal(this.suc);
/* 34 */     _os_.marshal(this.sucrate);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.fighterid = _os_.unmarshal_int();
/* 40 */     this.suc = _os_.unmarshal_int();
/* 41 */     this.sucrate = _os_.unmarshal_int();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof PlayEscape)) {
/* 48 */       PlayEscape _o_ = (PlayEscape)_o1_;
/* 49 */       if (this.fighterid != _o_.fighterid) return false;
/* 50 */       if (this.suc != _o_.suc) return false;
/* 51 */       if (this.sucrate != _o_.sucrate) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.fighterid;
/* 60 */     _h_ += this.suc;
/* 61 */     _h_ += this.sucrate;
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.fighterid).append(",");
/* 69 */     _sb_.append(this.suc).append(",");
/* 70 */     _sb_.append(this.sucrate).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PlayEscape _o_) {
/* 76 */     if (_o_ == this) return 0;
/* 77 */     int _c_ = 0;
/* 78 */     _c_ = this.fighterid - _o_.fighterid;
/* 79 */     if (0 != _c_) return _c_;
/* 80 */     _c_ = this.suc - _o_.suc;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.sucrate - _o_.sucrate;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */