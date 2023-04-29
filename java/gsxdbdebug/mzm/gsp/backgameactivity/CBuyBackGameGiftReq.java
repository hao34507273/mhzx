/*    */ package mzm.gsp.backgameactivity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.backgameactivity.main.PCBuyBackGameGiftReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBuyBackGameGiftReq
/*    */   extends __CBuyBackGameGiftReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620555;
/*    */   public int gift_id;
/*    */   public int buy_count;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCBuyBackGameGiftReq(roleId, this.gift_id, this.buy_count));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12620555;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CBuyBackGameGiftReq() {}
/*    */   
/*    */ 
/*    */   public CBuyBackGameGiftReq(int _gift_id_, int _buy_count_)
/*    */   {
/* 42 */     this.gift_id = _gift_id_;
/* 43 */     this.buy_count = _buy_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.gift_id);
/* 52 */     _os_.marshal(this.buy_count);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.gift_id = _os_.unmarshal_int();
/* 58 */     this.buy_count = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CBuyBackGameGiftReq)) {
/* 68 */       CBuyBackGameGiftReq _o_ = (CBuyBackGameGiftReq)_o1_;
/* 69 */       if (this.gift_id != _o_.gift_id) return false;
/* 70 */       if (this.buy_count != _o_.buy_count) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.gift_id;
/* 79 */     _h_ += this.buy_count;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.gift_id).append(",");
/* 87 */     _sb_.append(this.buy_count).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CBuyBackGameGiftReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.gift_id - _o_.gift_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.buy_count - _o_.buy_count;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\CBuyBackGameGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */