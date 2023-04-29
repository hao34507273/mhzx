/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCGrcSendGift;
/*    */ 
/*    */ 
/*    */ public class CGrcSendGift
/*    */   extends __CGrcSendGift__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600338;
/*    */   public int gift_type;
/*    */   public Octets to;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGrcSendGift(roleId, this.gift_type, this.to));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12600338;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGrcSendGift()
/*    */   {
/* 39 */     this.to = new Octets();
/*    */   }
/*    */   
/*    */   public CGrcSendGift(int _gift_type_, Octets _to_) {
/* 43 */     this.gift_type = _gift_type_;
/* 44 */     this.to = _to_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.gift_type);
/* 53 */     _os_.marshal(this.to);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.gift_type = _os_.unmarshal_int();
/* 59 */     this.to = _os_.unmarshal_Octets();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CGrcSendGift)) {
/* 69 */       CGrcSendGift _o_ = (CGrcSendGift)_o1_;
/* 70 */       if (this.gift_type != _o_.gift_type) return false;
/* 71 */       if (!this.to.equals(_o_.to)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.gift_type;
/* 80 */     _h_ += this.to.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.gift_type).append(",");
/* 88 */     _sb_.append("B").append(this.to.size()).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CGrcSendGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */