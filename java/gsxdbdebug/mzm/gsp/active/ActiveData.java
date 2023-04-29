/*    */ package mzm.gsp.active;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ActiveData implements Marshal, Comparable<ActiveData>
/*    */ {
/*    */   public int activityid;
/*    */   public int activecount;
/*    */   
/*    */   public ActiveData() {}
/*    */   
/*    */   public ActiveData(int _activityid_, int _activecount_)
/*    */   {
/* 16 */     this.activityid = _activityid_;
/* 17 */     this.activecount = _activecount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.activityid);
/* 26 */     _os_.marshal(this.activecount);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.activityid = _os_.unmarshal_int();
/* 32 */     this.activecount = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof ActiveData)) {
/* 39 */       ActiveData _o_ = (ActiveData)_o1_;
/* 40 */       if (this.activityid != _o_.activityid) return false;
/* 41 */       if (this.activecount != _o_.activecount) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.activityid;
/* 50 */     _h_ += this.activecount;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.activityid).append(",");
/* 58 */     _sb_.append(this.activecount).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ActiveData _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.activityid - _o_.activityid;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.activecount - _o_.activecount;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\ActiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */