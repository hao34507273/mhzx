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
/*    */ public class SCancelShouTuSuccess
/*    */   extends __SCancelShouTuSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601608;
/*    */   public long masterroleid;
/*    */   public String masterrolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601608;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCancelShouTuSuccess()
/*    */   {
/* 34 */     this.masterrolename = "";
/*    */   }
/*    */   
/*    */   public SCancelShouTuSuccess(long _masterroleid_, String _masterrolename_) {
/* 38 */     this.masterroleid = _masterroleid_;
/* 39 */     this.masterrolename = _masterrolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.masterroleid);
/* 48 */     _os_.marshal(this.masterrolename, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.masterroleid = _os_.unmarshal_long();
/* 54 */     this.masterrolename = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SCancelShouTuSuccess)) {
/* 64 */       SCancelShouTuSuccess _o_ = (SCancelShouTuSuccess)_o1_;
/* 65 */       if (this.masterroleid != _o_.masterroleid) return false;
/* 66 */       if (!this.masterrolename.equals(_o_.masterrolename)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.masterroleid;
/* 75 */     _h_ += this.masterrolename.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.masterroleid).append(",");
/* 83 */     _sb_.append("T").append(this.masterrolename.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SCancelShouTuSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */