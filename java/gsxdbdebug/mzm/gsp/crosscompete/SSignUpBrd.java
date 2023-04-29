/*    */ package mzm.gsp.crosscompete;
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
/*    */ public class SSignUpBrd
/*    */   extends __SSignUpBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616729;
/*    */   public long manager_id;
/*    */   public String manager_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616729;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSignUpBrd()
/*    */   {
/* 34 */     this.manager_name = "";
/*    */   }
/*    */   
/*    */   public SSignUpBrd(long _manager_id_, String _manager_name_) {
/* 38 */     this.manager_id = _manager_id_;
/* 39 */     this.manager_name = _manager_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.manager_id);
/* 48 */     _os_.marshal(this.manager_name, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.manager_id = _os_.unmarshal_long();
/* 54 */     this.manager_name = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSignUpBrd)) {
/* 64 */       SSignUpBrd _o_ = (SSignUpBrd)_o1_;
/* 65 */       if (this.manager_id != _o_.manager_id) return false;
/* 66 */       if (!this.manager_name.equals(_o_.manager_name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.manager_id;
/* 75 */     _h_ += this.manager_name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.manager_id).append(",");
/* 83 */     _sb_.append("T").append(this.manager_name.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SSignUpBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */