/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class JoinMatchRsp
/*    */   implements Marshal, Comparable<JoinMatchRsp>
/*    */ {
/*    */   public long matcher_server_contextid;
/*    */   
/*    */   public JoinMatchRsp()
/*    */   {
/* 14 */     this.matcher_server_contextid = 0L;
/*    */   }
/*    */   
/*    */   public JoinMatchRsp(long _matcher_server_contextid_) {
/* 18 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.matcher_server_contextid);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.matcher_server_contextid = _os_.unmarshal_long();
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 36 */     if (_o1_ == this) return true;
/* 37 */     if ((_o1_ instanceof JoinMatchRsp)) {
/* 38 */       JoinMatchRsp _o_ = (JoinMatchRsp)_o1_;
/* 39 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 46 */     int _h_ = 0;
/* 47 */     _h_ += (int)this.matcher_server_contextid;
/* 48 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuilder _sb_ = new StringBuilder();
/* 53 */     _sb_.append("(");
/* 54 */     _sb_.append(this.matcher_server_contextid).append(",");
/* 55 */     _sb_.append(")");
/* 56 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(JoinMatchRsp _o_) {
/* 60 */     if (_o_ == this) return 0;
/* 61 */     int _c_ = 0;
/* 62 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/* 63 */     if (0 != _c_) return _c_;
/* 64 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\JoinMatchRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */