/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.menpaistar.main.PCVote;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CVote
/*    */   extends __CVote__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612374;
/*    */   public long target_roleid;
/*    */   public int vote_num;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCVote(roleId, this.target_roleid, this.vote_num));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12612374;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CVote() {}
/*    */   
/*    */ 
/*    */   public CVote(long _target_roleid_, int _vote_num_)
/*    */   {
/* 42 */     this.target_roleid = _target_roleid_;
/* 43 */     this.vote_num = _vote_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.target_roleid);
/* 52 */     _os_.marshal(this.vote_num);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.target_roleid = _os_.unmarshal_long();
/* 58 */     this.vote_num = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CVote)) {
/* 68 */       CVote _o_ = (CVote)_o1_;
/* 69 */       if (this.target_roleid != _o_.target_roleid) return false;
/* 70 */       if (this.vote_num != _o_.vote_num) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.target_roleid;
/* 79 */     _h_ += this.vote_num;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.target_roleid).append(",");
/* 87 */     _sb_.append(this.vote_num).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CVote _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.vote_num - _o_.vote_num;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\CVote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */