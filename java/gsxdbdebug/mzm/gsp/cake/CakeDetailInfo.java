/*    */ package mzm.gsp.cake;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CakeDetailInfo
/*    */   implements Marshal, Comparable<CakeDetailInfo>
/*    */ {
/*    */   public static final int STAGE_MAKE_ING = 1;
/*    */   public static final int STAGE_FREE = 2;
/*    */   public int curturn;
/*    */   public int cakeid;
/*    */   public int state;
/*    */   public long cookstarttime;
/*    */   
/*    */   public CakeDetailInfo() {}
/*    */   
/*    */   public CakeDetailInfo(int _curturn_, int _cakeid_, int _state_, long _cookstarttime_)
/*    */   {
/* 23 */     this.curturn = _curturn_;
/* 24 */     this.cakeid = _cakeid_;
/* 25 */     this.state = _state_;
/* 26 */     this.cookstarttime = _cookstarttime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.curturn);
/* 35 */     _os_.marshal(this.cakeid);
/* 36 */     _os_.marshal(this.state);
/* 37 */     _os_.marshal(this.cookstarttime);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.curturn = _os_.unmarshal_int();
/* 43 */     this.cakeid = _os_.unmarshal_int();
/* 44 */     this.state = _os_.unmarshal_int();
/* 45 */     this.cookstarttime = _os_.unmarshal_long();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof CakeDetailInfo)) {
/* 52 */       CakeDetailInfo _o_ = (CakeDetailInfo)_o1_;
/* 53 */       if (this.curturn != _o_.curturn) return false;
/* 54 */       if (this.cakeid != _o_.cakeid) return false;
/* 55 */       if (this.state != _o_.state) return false;
/* 56 */       if (this.cookstarttime != _o_.cookstarttime) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.curturn;
/* 65 */     _h_ += this.cakeid;
/* 66 */     _h_ += this.state;
/* 67 */     _h_ += (int)this.cookstarttime;
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append(this.curturn).append(",");
/* 75 */     _sb_.append(this.cakeid).append(",");
/* 76 */     _sb_.append(this.state).append(",");
/* 77 */     _sb_.append(this.cookstarttime).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CakeDetailInfo _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.curturn - _o_.curturn;
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     _c_ = this.cakeid - _o_.cakeid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.state - _o_.state;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = Long.signum(this.cookstarttime - _o_.cookstarttime);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\CakeDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */