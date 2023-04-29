/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.wing.main2.PCCheckWingsReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCheckWingsReq
/*    */   extends __CCheckWingsReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596542;
/*    */   public long roleid;
/*    */   public int cfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleIdMain = Role.getRoleId(this);
/* 20 */     if (roleIdMain <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleIdMain, new PCCheckWingsReq(roleIdMain, this.roleid, this.cfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12596542;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCheckWingsReq() {}
/*    */   
/*    */ 
/*    */   public CCheckWingsReq(long _roleid_, int _cfgid_)
/*    */   {
/* 42 */     this.roleid = _roleid_;
/* 43 */     this.cfgid = _cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.roleid);
/* 52 */     _os_.marshal(this.cfgid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.roleid = _os_.unmarshal_long();
/* 58 */     this.cfgid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CCheckWingsReq)) {
/* 68 */       CCheckWingsReq _o_ = (CCheckWingsReq)_o1_;
/* 69 */       if (this.roleid != _o_.roleid) return false;
/* 70 */       if (this.cfgid != _o_.cfgid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.roleid;
/* 79 */     _h_ += this.cfgid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.roleid).append(",");
/* 87 */     _sb_.append(this.cfgid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCheckWingsReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.cfgid - _o_.cfgid;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CCheckWingsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */