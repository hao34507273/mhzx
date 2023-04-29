/*    */ package mzm.gsp.gratefuldelivery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gratefuldelivery.main.PAvailableFriendReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAvailableFriendReq
/*    */   extends __CAvailableFriendReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615684;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PAvailableFriendReq(this.activity_id, roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12615684;
/*    */   }
/*    */   
/*    */ 
/*    */   public CAvailableFriendReq() {}
/*    */   
/*    */ 
/*    */   public CAvailableFriendReq(int _activity_id_)
/*    */   {
/* 37 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.activity_id);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.activity_id = _os_.unmarshal_int();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CAvailableFriendReq)) {
/* 60 */       CAvailableFriendReq _o_ = (CAvailableFriendReq)_o1_;
/* 61 */       if (this.activity_id != _o_.activity_id) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.activity_id;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.activity_id).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAvailableFriendReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.activity_id - _o_.activity_id;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\CAvailableFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */