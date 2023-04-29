/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChuShiSuccess
/*    */   extends __SChuShiSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601602;
/*    */   public long apprenticeroleid;
/*    */   public String apprenticerolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601602;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChuShiSuccess()
/*    */   {
/* 34 */     this.apprenticerolename = "";
/*    */   }
/*    */   
/*    */   public SChuShiSuccess(long _apprenticeroleid_, String _apprenticerolename_) {
/* 38 */     this.apprenticeroleid = _apprenticeroleid_;
/* 39 */     this.apprenticerolename = _apprenticerolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.apprenticeroleid);
/* 48 */     _os_.marshal(this.apprenticerolename, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.apprenticeroleid = _os_.unmarshal_long();
/* 54 */     this.apprenticerolename = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SChuShiSuccess)) {
/* 64 */       SChuShiSuccess _o_ = (SChuShiSuccess)_o1_;
/* 65 */       if (this.apprenticeroleid != _o_.apprenticeroleid) return false;
/* 66 */       if (!this.apprenticerolename.equals(_o_.apprenticerolename)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.apprenticeroleid;
/* 75 */     _h_ += this.apprenticerolename.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.apprenticeroleid).append(",");
/* 83 */     _sb_.append("T").append(this.apprenticerolename.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SChuShiSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */