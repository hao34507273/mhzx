/*    */ package mzm.gsp.gratefuldelivery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gratefuldelivery.main.PFetchRewardReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CFetchRewardReq
/*    */   extends __CFetchRewardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615692;
/*    */   public int stage;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PFetchRewardReq(this.activity_id, roleId, this.stage));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12615692;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CFetchRewardReq() {}
/*    */   
/*    */ 
/*    */   public CFetchRewardReq(int _stage_, int _activity_id_)
/*    */   {
/* 38 */     this.stage = _stage_;
/* 39 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.stage);
/* 48 */     _os_.marshal(this.activity_id);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.stage = _os_.unmarshal_int();
/* 54 */     this.activity_id = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CFetchRewardReq)) {
/* 64 */       CFetchRewardReq _o_ = (CFetchRewardReq)_o1_;
/* 65 */       if (this.stage != _o_.stage) return false;
/* 66 */       if (this.activity_id != _o_.activity_id) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.stage;
/* 75 */     _h_ += this.activity_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.stage).append(",");
/* 83 */     _sb_.append(this.activity_id).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CFetchRewardReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.stage - _o_.stage;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.activity_id - _o_.activity_id;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\CFetchRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */