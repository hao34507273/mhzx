/*    */ package mzm.gsp.activity;
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
/*    */ public class SGetRedgiftActivityRewardRes
/*    */   extends __SGetRedgiftActivityRewardRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587589;
/*    */   public static final int SUCCESS = 0;
/*    */   public static final int FAIL = 1;
/*    */   public static final int LIMIT = 10;
/*    */   public int result;
/*    */   public int cfgid;
/*    */   public RedgiftData rewardinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587589;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetRedgiftActivityRewardRes()
/*    */   {
/* 39 */     this.rewardinfo = new RedgiftData();
/*    */   }
/*    */   
/*    */   public SGetRedgiftActivityRewardRes(int _result_, int _cfgid_, RedgiftData _rewardinfo_) {
/* 43 */     this.result = _result_;
/* 44 */     this.cfgid = _cfgid_;
/* 45 */     this.rewardinfo = _rewardinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     if (!this.rewardinfo._validator_()) return false;
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.result);
/* 55 */     _os_.marshal(this.cfgid);
/* 56 */     _os_.marshal(this.rewardinfo);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.result = _os_.unmarshal_int();
/* 62 */     this.cfgid = _os_.unmarshal_int();
/* 63 */     this.rewardinfo.unmarshal(_os_);
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGetRedgiftActivityRewardRes)) {
/* 73 */       SGetRedgiftActivityRewardRes _o_ = (SGetRedgiftActivityRewardRes)_o1_;
/* 74 */       if (this.result != _o_.result) return false;
/* 75 */       if (this.cfgid != _o_.cfgid) return false;
/* 76 */       if (!this.rewardinfo.equals(_o_.rewardinfo)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.result;
/* 85 */     _h_ += this.cfgid;
/* 86 */     _h_ += this.rewardinfo.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.result).append(",");
/* 94 */     _sb_.append(this.cfgid).append(",");
/* 95 */     _sb_.append(this.rewardinfo).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SGetRedgiftActivityRewardRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */