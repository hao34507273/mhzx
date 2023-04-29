/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VerifyMaster2_Re
/*    */   extends __VerifyMaster2_Re__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 605;
/*    */   public Octets rolename;
/*    */   public int ret;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 605;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public VerifyMaster2_Re()
/*    */   {
/* 32 */     this.rolename = new Octets();
/* 33 */     this.ret = -1;
/*    */   }
/*    */   
/*    */   public VerifyMaster2_Re(Octets _rolename_, int _ret_) {
/* 37 */     this.rolename = _rolename_;
/* 38 */     this.ret = _ret_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.rolename);
/* 47 */     _os_.marshal(this.ret);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.rolename = _os_.unmarshal_Octets();
/* 53 */     this.ret = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof VerifyMaster2_Re)) {
/* 63 */       VerifyMaster2_Re _o_ = (VerifyMaster2_Re)_o1_;
/* 64 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 65 */       if (this.ret != _o_.ret) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.rolename.hashCode();
/* 74 */     _h_ += this.ret;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 82 */     _sb_.append(this.ret).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\VerifyMaster2_Re.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */