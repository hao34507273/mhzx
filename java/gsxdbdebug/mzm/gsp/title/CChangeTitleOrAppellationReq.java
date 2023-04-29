/*    */ package mzm.gsp.title;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.title.main.PChangeTitleOrAppellationReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeTitleOrAppellationReq
/*    */   extends __CChangeTitleOrAppellationReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593927;
/*    */   public int changeid;
/*    */   public int changetype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleid, new PChangeTitleOrAppellationReq(roleid, this.changeid, this.changetype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12593927;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeTitleOrAppellationReq() {}
/*    */   
/*    */ 
/*    */   public CChangeTitleOrAppellationReq(int _changeid_, int _changetype_)
/*    */   {
/* 41 */     this.changeid = _changeid_;
/* 42 */     this.changetype = _changetype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.changeid);
/* 51 */     _os_.marshal(this.changetype);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.changeid = _os_.unmarshal_int();
/* 57 */     this.changetype = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CChangeTitleOrAppellationReq)) {
/* 67 */       CChangeTitleOrAppellationReq _o_ = (CChangeTitleOrAppellationReq)_o1_;
/* 68 */       if (this.changeid != _o_.changeid) return false;
/* 69 */       if (this.changetype != _o_.changetype) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.changeid;
/* 78 */     _h_ += this.changetype;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.changeid).append(",");
/* 86 */     _sb_.append(this.changetype).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChangeTitleOrAppellationReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.changeid - _o_.changeid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.changetype - _o_.changetype;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\CChangeTitleOrAppellationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */