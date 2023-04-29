/*    */ package mzm.gsp.grc;
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
/*    */ public class SGetInviteFriendsInfoResp
/*    */   extends __SGetInviteFriendsInfoResp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600351;
/*    */   public Octets invite_code;
/*    */   public int invitee_num;
/*    */   public int award_gift_times;
/*    */   public long rebate_bind_yuanbao;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600351;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetInviteFriendsInfoResp()
/*    */   {
/* 36 */     this.invite_code = new Octets();
/*    */   }
/*    */   
/*    */   public SGetInviteFriendsInfoResp(Octets _invite_code_, int _invitee_num_, int _award_gift_times_, long _rebate_bind_yuanbao_) {
/* 40 */     this.invite_code = _invite_code_;
/* 41 */     this.invitee_num = _invitee_num_;
/* 42 */     this.award_gift_times = _award_gift_times_;
/* 43 */     this.rebate_bind_yuanbao = _rebate_bind_yuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.invite_code);
/* 52 */     _os_.marshal(this.invitee_num);
/* 53 */     _os_.marshal(this.award_gift_times);
/* 54 */     _os_.marshal(this.rebate_bind_yuanbao);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.invite_code = _os_.unmarshal_Octets();
/* 60 */     this.invitee_num = _os_.unmarshal_int();
/* 61 */     this.award_gift_times = _os_.unmarshal_int();
/* 62 */     this.rebate_bind_yuanbao = _os_.unmarshal_long();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SGetInviteFriendsInfoResp)) {
/* 72 */       SGetInviteFriendsInfoResp _o_ = (SGetInviteFriendsInfoResp)_o1_;
/* 73 */       if (!this.invite_code.equals(_o_.invite_code)) return false;
/* 74 */       if (this.invitee_num != _o_.invitee_num) return false;
/* 75 */       if (this.award_gift_times != _o_.award_gift_times) return false;
/* 76 */       if (this.rebate_bind_yuanbao != _o_.rebate_bind_yuanbao) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.invite_code.hashCode();
/* 85 */     _h_ += this.invitee_num;
/* 86 */     _h_ += this.award_gift_times;
/* 87 */     _h_ += (int)this.rebate_bind_yuanbao;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append("B").append(this.invite_code.size()).append(",");
/* 95 */     _sb_.append(this.invitee_num).append(",");
/* 96 */     _sb_.append(this.award_gift_times).append(",");
/* 97 */     _sb_.append(this.rebate_bind_yuanbao).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetInviteFriendsInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */