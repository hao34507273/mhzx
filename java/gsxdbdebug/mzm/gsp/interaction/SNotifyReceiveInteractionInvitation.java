/*    */ package mzm.gsp.interaction;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SNotifyReceiveInteractionInvitation
/*    */   extends __SNotifyReceiveInteractionInvitation__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622603;
/*    */   public long active_role_id;
/*    */   public Octets active_role_name;
/*    */   public int interaction_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12622603;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNotifyReceiveInteractionInvitation()
/*    */   {
/* 35 */     this.active_role_name = new Octets();
/*    */   }
/*    */   
/*    */   public SNotifyReceiveInteractionInvitation(long _active_role_id_, Octets _active_role_name_, int _interaction_id_) {
/* 39 */     this.active_role_id = _active_role_id_;
/* 40 */     this.active_role_name = _active_role_name_;
/* 41 */     this.interaction_id = _interaction_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.active_role_id);
/* 50 */     _os_.marshal(this.active_role_name);
/* 51 */     _os_.marshal(this.interaction_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.active_role_id = _os_.unmarshal_long();
/* 57 */     this.active_role_name = _os_.unmarshal_Octets();
/* 58 */     this.interaction_id = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SNotifyReceiveInteractionInvitation)) {
/* 68 */       SNotifyReceiveInteractionInvitation _o_ = (SNotifyReceiveInteractionInvitation)_o1_;
/* 69 */       if (this.active_role_id != _o_.active_role_id) return false;
/* 70 */       if (!this.active_role_name.equals(_o_.active_role_name)) return false;
/* 71 */       if (this.interaction_id != _o_.interaction_id) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.active_role_id;
/* 80 */     _h_ += this.active_role_name.hashCode();
/* 81 */     _h_ += this.interaction_id;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.active_role_id).append(",");
/* 89 */     _sb_.append("B").append(this.active_role_name.size()).append(",");
/* 90 */     _sb_.append(this.interaction_id).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\SNotifyReceiveInteractionInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */