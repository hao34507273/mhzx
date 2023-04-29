/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.award.AwardBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMarrigeParadeGetMoney
/*    */   extends __SMarrigeParadeGetMoney__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599840;
/*    */   public AwardBean awardbean;
/*    */   public ParadeRoleInfo role1info;
/*    */   public ParadeRoleInfo role2info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599840;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMarrigeParadeGetMoney()
/*    */   {
/* 35 */     this.awardbean = new AwardBean();
/* 36 */     this.role1info = new ParadeRoleInfo();
/* 37 */     this.role2info = new ParadeRoleInfo();
/*    */   }
/*    */   
/*    */   public SMarrigeParadeGetMoney(AwardBean _awardbean_, ParadeRoleInfo _role1info_, ParadeRoleInfo _role2info_) {
/* 41 */     this.awardbean = _awardbean_;
/* 42 */     this.role1info = _role1info_;
/* 43 */     this.role2info = _role2info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     if (!this.awardbean._validator_()) return false;
/* 48 */     if (!this.role1info._validator_()) return false;
/* 49 */     if (!this.role2info._validator_()) return false;
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.awardbean);
/* 55 */     _os_.marshal(this.role1info);
/* 56 */     _os_.marshal(this.role2info);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.awardbean.unmarshal(_os_);
/* 62 */     this.role1info.unmarshal(_os_);
/* 63 */     this.role2info.unmarshal(_os_);
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SMarrigeParadeGetMoney)) {
/* 73 */       SMarrigeParadeGetMoney _o_ = (SMarrigeParadeGetMoney)_o1_;
/* 74 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/* 75 */       if (!this.role1info.equals(_o_.role1info)) return false;
/* 76 */       if (!this.role2info.equals(_o_.role2info)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.awardbean.hashCode();
/* 85 */     _h_ += this.role1info.hashCode();
/* 86 */     _h_ += this.role2info.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.awardbean).append(",");
/* 94 */     _sb_.append(this.role1info).append(",");
/* 95 */     _sb_.append(this.role2info).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SMarrigeParadeGetMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */