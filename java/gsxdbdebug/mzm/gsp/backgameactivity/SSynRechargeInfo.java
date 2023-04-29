/*    */ package mzm.gsp.backgameactivity;
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
/*    */ public class SSynRechargeInfo
/*    */   extends __SSynRechargeInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620565;
/*    */   public int activityid;
/*    */   public RechargeInfo rechargeinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12620565;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynRechargeInfo()
/*    */   {
/* 32 */     this.rechargeinfo = new RechargeInfo();
/*    */   }
/*    */   
/*    */   public SSynRechargeInfo(int _activityid_, RechargeInfo _rechargeinfo_) {
/* 36 */     this.activityid = _activityid_;
/* 37 */     this.rechargeinfo = _rechargeinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.rechargeinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.activityid);
/* 47 */     _os_.marshal(this.rechargeinfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.activityid = _os_.unmarshal_int();
/* 53 */     this.rechargeinfo.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynRechargeInfo)) {
/* 63 */       SSynRechargeInfo _o_ = (SSynRechargeInfo)_o1_;
/* 64 */       if (this.activityid != _o_.activityid) return false;
/* 65 */       if (!this.rechargeinfo.equals(_o_.rechargeinfo)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.activityid;
/* 74 */     _h_ += this.rechargeinfo.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.activityid).append(",");
/* 82 */     _sb_.append(this.rechargeinfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\SSynRechargeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */