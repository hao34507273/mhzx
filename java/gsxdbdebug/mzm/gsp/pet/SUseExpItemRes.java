/*    */ package mzm.gsp.pet;
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
/*    */ public class SUseExpItemRes
/*    */   extends __SUseExpItemRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590612;
/*    */   public int addexp;
/*    */   public long petid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590612;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUseExpItemRes() {}
/*    */   
/*    */ 
/*    */   public SUseExpItemRes(int _addexp_, long _petid_)
/*    */   {
/* 37 */     this.addexp = _addexp_;
/* 38 */     this.petid = _petid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.addexp);
/* 47 */     _os_.marshal(this.petid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.addexp = _os_.unmarshal_int();
/* 53 */     this.petid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SUseExpItemRes)) {
/* 63 */       SUseExpItemRes _o_ = (SUseExpItemRes)_o1_;
/* 64 */       if (this.addexp != _o_.addexp) return false;
/* 65 */       if (this.petid != _o_.petid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.addexp;
/* 74 */     _h_ += (int)this.petid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.addexp).append(",");
/* 82 */     _sb_.append(this.petid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseExpItemRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.addexp - _o_.addexp;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SUseExpItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */