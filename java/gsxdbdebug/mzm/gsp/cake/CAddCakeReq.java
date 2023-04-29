/*    */ package mzm.gsp.cake;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.cake.main.PCAddCakeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAddCakeReq
/*    */   extends __CAddCakeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627718;
/*    */   public int activityid;
/*    */   public int clientturn;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCAddCakeReq(roleId, this.activityid, this.clientturn));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12627718;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAddCakeReq() {}
/*    */   
/*    */ 
/*    */   public CAddCakeReq(int _activityid_, int _clientturn_)
/*    */   {
/* 42 */     this.activityid = _activityid_;
/* 43 */     this.clientturn = _clientturn_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activityid);
/* 52 */     _os_.marshal(this.clientturn);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activityid = _os_.unmarshal_int();
/* 58 */     this.clientturn = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CAddCakeReq)) {
/* 68 */       CAddCakeReq _o_ = (CAddCakeReq)_o1_;
/* 69 */       if (this.activityid != _o_.activityid) return false;
/* 70 */       if (this.clientturn != _o_.clientturn) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activityid;
/* 79 */     _h_ += this.clientturn;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activityid).append(",");
/* 87 */     _sb_.append(this.clientturn).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAddCakeReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activityid - _o_.activityid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.clientturn - _o_.clientturn;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\CAddCakeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */