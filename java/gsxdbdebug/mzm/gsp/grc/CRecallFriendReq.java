/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCRecallFriend;
/*    */ 
/*    */ 
/*    */ public class CRecallFriendReq
/*    */   extends __CRecallFriendReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600370;
/*    */   public int zone_id;
/*    */   public long role_id;
/*    */   public Octets open_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     String openid = this.open_id.getString("UTF-8");
/* 26 */     Role.addRoleProcedure(roleId, new PCRecallFriend(roleId, this.role_id, openid, this.zone_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12600370;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CRecallFriendReq()
/*    */   {
/* 42 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public CRecallFriendReq(int _zone_id_, long _role_id_, Octets _open_id_) {
/* 46 */     this.zone_id = _zone_id_;
/* 47 */     this.role_id = _role_id_;
/* 48 */     this.open_id = _open_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.zone_id);
/* 57 */     _os_.marshal(this.role_id);
/* 58 */     _os_.marshal(this.open_id);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     this.zone_id = _os_.unmarshal_int();
/* 64 */     this.role_id = _os_.unmarshal_long();
/* 65 */     this.open_id = _os_.unmarshal_Octets();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CRecallFriendReq)) {
/* 75 */       CRecallFriendReq _o_ = (CRecallFriendReq)_o1_;
/* 76 */       if (this.zone_id != _o_.zone_id) return false;
/* 77 */       if (this.role_id != _o_.role_id) return false;
/* 78 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.zone_id;
/* 87 */     _h_ += (int)this.role_id;
/* 88 */     _h_ += this.open_id.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.zone_id).append(",");
/* 96 */     _sb_.append(this.role_id).append(",");
/* 97 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CRecallFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */