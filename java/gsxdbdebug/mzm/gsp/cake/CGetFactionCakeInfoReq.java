/*    */ package mzm.gsp.cake;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.cake.main.PCGetFactionCakeInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetFactionCakeInfoReq
/*    */   extends __CGetFactionCakeInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627719;
/*    */   public int activityid;
/*    */   public long factionid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGetFactionCakeInfoReq(roleId, this.activityid, this.factionid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12627719;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetFactionCakeInfoReq() {}
/*    */   
/*    */ 
/*    */   public CGetFactionCakeInfoReq(int _activityid_, long _factionid_)
/*    */   {
/* 42 */     this.activityid = _activityid_;
/* 43 */     this.factionid = _factionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activityid);
/* 52 */     _os_.marshal(this.factionid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activityid = _os_.unmarshal_int();
/* 58 */     this.factionid = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGetFactionCakeInfoReq)) {
/* 68 */       CGetFactionCakeInfoReq _o_ = (CGetFactionCakeInfoReq)_o1_;
/* 69 */       if (this.activityid != _o_.activityid) return false;
/* 70 */       if (this.factionid != _o_.factionid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activityid;
/* 79 */     _h_ += (int)this.factionid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activityid).append(",");
/* 87 */     _sb_.append(this.factionid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetFactionCakeInfoReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activityid - _o_.activityid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.factionid - _o_.factionid);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\CGetFactionCakeInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */