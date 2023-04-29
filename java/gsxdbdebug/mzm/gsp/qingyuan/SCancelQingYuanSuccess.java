/*    */ package mzm.gsp.qingyuan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SCancelQingYuanSuccess
/*    */   extends __SCancelQingYuanSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602886;
/*    */   public long team_leader_role_id;
/*    */   public String team_leader_role_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602886;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCancelQingYuanSuccess()
/*    */   {
/* 34 */     this.team_leader_role_name = "";
/*    */   }
/*    */   
/*    */   public SCancelQingYuanSuccess(long _team_leader_role_id_, String _team_leader_role_name_) {
/* 38 */     this.team_leader_role_id = _team_leader_role_id_;
/* 39 */     this.team_leader_role_name = _team_leader_role_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.team_leader_role_id);
/* 48 */     _os_.marshal(this.team_leader_role_name, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.team_leader_role_id = _os_.unmarshal_long();
/* 54 */     this.team_leader_role_name = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SCancelQingYuanSuccess)) {
/* 64 */       SCancelQingYuanSuccess _o_ = (SCancelQingYuanSuccess)_o1_;
/* 65 */       if (this.team_leader_role_id != _o_.team_leader_role_id) return false;
/* 66 */       if (!this.team_leader_role_name.equals(_o_.team_leader_role_name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.team_leader_role_id;
/* 75 */     _h_ += this.team_leader_role_name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.team_leader_role_id).append(",");
/* 83 */     _sb_.append("T").append(this.team_leader_role_name.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\SCancelQingYuanSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */