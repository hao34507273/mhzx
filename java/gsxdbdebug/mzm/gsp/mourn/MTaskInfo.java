/*    */ package mzm.gsp.mourn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MTaskInfo
/*    */   implements Marshal, Comparable<MTaskInfo>
/*    */ {
/*    */   public static final int UN_ACCEPTED = 1;
/*    */   public static final int ALREADY_ACCEPTED = 2;
/*    */   public static final int FINISHED = 3;
/*    */   public int state;
/*    */   
/*    */   public MTaskInfo() {}
/*    */   
/*    */   public MTaskInfo(int _state_)
/*    */   {
/* 19 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.state);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 32 */     this.state = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof MTaskInfo)) {
/* 39 */       MTaskInfo _o_ = (MTaskInfo)_o1_;
/* 40 */       if (this.state != _o_.state) return false;
/* 41 */       return true;
/*    */     }
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 47 */     int _h_ = 0;
/* 48 */     _h_ += this.state;
/* 49 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 53 */     StringBuilder _sb_ = new StringBuilder();
/* 54 */     _sb_.append("(");
/* 55 */     _sb_.append(this.state).append(",");
/* 56 */     _sb_.append(")");
/* 57 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MTaskInfo _o_) {
/* 61 */     if (_o_ == this) return 0;
/* 62 */     int _c_ = 0;
/* 63 */     _c_ = this.state - _o_.state;
/* 64 */     if (0 != _c_) return _c_;
/* 65 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\MTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */