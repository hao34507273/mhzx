/*    */ package mzm.gsp.couple;
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
/*    */ public class SRefuseCommonRideRes
/*    */   extends __SRefuseCommonRideRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600583;
/*    */   public long refuseroleid;
/*    */   public String refuserolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600583;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRefuseCommonRideRes()
/*    */   {
/* 34 */     this.refuserolename = "";
/*    */   }
/*    */   
/*    */   public SRefuseCommonRideRes(long _refuseroleid_, String _refuserolename_) {
/* 38 */     this.refuseroleid = _refuseroleid_;
/* 39 */     this.refuserolename = _refuserolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.refuseroleid);
/* 48 */     _os_.marshal(this.refuserolename, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.refuseroleid = _os_.unmarshal_long();
/* 54 */     this.refuserolename = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SRefuseCommonRideRes)) {
/* 64 */       SRefuseCommonRideRes _o_ = (SRefuseCommonRideRes)_o1_;
/* 65 */       if (this.refuseroleid != _o_.refuseroleid) return false;
/* 66 */       if (!this.refuserolename.equals(_o_.refuserolename)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.refuseroleid;
/* 75 */     _h_ += this.refuserolename.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.refuseroleid).append(",");
/* 83 */     _sb_.append("T").append(this.refuserolename.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\SRefuseCommonRideRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */