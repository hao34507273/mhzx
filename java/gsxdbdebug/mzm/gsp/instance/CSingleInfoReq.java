/*    */ package mzm.gsp.instance;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.instance.main.PCSingleInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSingleInfoReq
/*    */   extends __CSingleInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591374;
/*    */   public int instancecfgid;
/*    */   public int process;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCSingleInfo(roleid, this.instancecfgid, this.process));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12591374;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSingleInfoReq() {}
/*    */   
/*    */ 
/*    */   public CSingleInfoReq(int _instancecfgid_, int _process_)
/*    */   {
/* 39 */     this.instancecfgid = _instancecfgid_;
/* 40 */     this.process = _process_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.instancecfgid);
/* 49 */     _os_.marshal(this.process);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.instancecfgid = _os_.unmarshal_int();
/* 55 */     this.process = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CSingleInfoReq)) {
/* 65 */       CSingleInfoReq _o_ = (CSingleInfoReq)_o1_;
/* 66 */       if (this.instancecfgid != _o_.instancecfgid) return false;
/* 67 */       if (this.process != _o_.process) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.instancecfgid;
/* 76 */     _h_ += this.process;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.instancecfgid).append(",");
/* 84 */     _sb_.append(this.process).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSingleInfoReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.instancecfgid - _o_.instancecfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.process - _o_.process;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\CSingleInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */