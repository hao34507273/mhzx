/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCBindFriend;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBindFriendReq
/*    */   extends __CBindFriendReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600372;
/*    */   public Octets open_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCBindFriend(roleId, this.open_id.getString("UTF-8")));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12600372;
/*    */   }
/*    */   
/*    */ 
/*    */   public CBindFriendReq()
/*    */   {
/* 39 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public CBindFriendReq(Octets _open_id_) {
/* 43 */     this.open_id = _open_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.open_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.open_id = _os_.unmarshal_Octets();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CBindFriendReq)) {
/* 66 */       CBindFriendReq _o_ = (CBindFriendReq)_o1_;
/* 67 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.open_id.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CBindFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */