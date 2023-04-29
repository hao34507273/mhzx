/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCSendRecallFriendReq;
/*    */ 
/*    */ 
/*    */ public class CSendRecallFriendReq
/*    */   extends __CSendRecallFriendReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600353;
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
/* 25 */     Role.addRoleProcedure(roleId, new PCSendRecallFriendReq(roleId, this.zone_id, this.role_id, this.open_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12600353;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CSendRecallFriendReq()
/*    */   {
/* 41 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public CSendRecallFriendReq(int _zone_id_, long _role_id_, Octets _open_id_) {
/* 45 */     this.zone_id = _zone_id_;
/* 46 */     this.role_id = _role_id_;
/* 47 */     this.open_id = _open_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 55 */     _os_.marshal(this.zone_id);
/* 56 */     _os_.marshal(this.role_id);
/* 57 */     _os_.marshal(this.open_id);
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     this.zone_id = _os_.unmarshal_int();
/* 63 */     this.role_id = _os_.unmarshal_long();
/* 64 */     this.open_id = _os_.unmarshal_Octets();
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof CSendRecallFriendReq)) {
/* 74 */       CSendRecallFriendReq _o_ = (CSendRecallFriendReq)_o1_;
/* 75 */       if (this.zone_id != _o_.zone_id) return false;
/* 76 */       if (this.role_id != _o_.role_id) return false;
/* 77 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.zone_id;
/* 86 */     _h_ += (int)this.role_id;
/* 87 */     _h_ += this.open_id.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.zone_id).append(",");
/* 95 */     _sb_.append(this.role_id).append(",");
/* 96 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CSendRecallFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */