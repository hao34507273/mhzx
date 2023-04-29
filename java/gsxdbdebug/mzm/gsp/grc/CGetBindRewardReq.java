/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCGetBindReward;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetBindRewardReq
/*    */   extends __CGetBindRewardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600377;
/*    */   public Octets open_id;
/*    */   public int bind_type;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCGetBindReward(roleId, this.open_id.getString("UTF-8"), this.bind_type));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12600377;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetBindRewardReq()
/*    */   {
/* 40 */     this.open_id = new Octets();
/*    */   }
/*    */   
/*    */   public CGetBindRewardReq(Octets _open_id_, int _bind_type_) {
/* 44 */     this.open_id = _open_id_;
/* 45 */     this.bind_type = _bind_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.open_id);
/* 54 */     _os_.marshal(this.bind_type);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.open_id = _os_.unmarshal_Octets();
/* 60 */     this.bind_type = _os_.unmarshal_int();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CGetBindRewardReq)) {
/* 70 */       CGetBindRewardReq _o_ = (CGetBindRewardReq)_o1_;
/* 71 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 72 */       if (this.bind_type != _o_.bind_type) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.open_id.hashCode();
/* 81 */     _h_ += this.bind_type;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 89 */     _sb_.append(this.bind_type).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CGetBindRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */