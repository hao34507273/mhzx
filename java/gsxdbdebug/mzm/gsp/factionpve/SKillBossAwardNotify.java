/*    */ package mzm.gsp.factionpve;
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
/*    */ 
/*    */ public class SKillBossAwardNotify
/*    */   extends __SKillBossAwardNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613645;
/*    */   public int bossid;
/*    */   public AwardBean award;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613645;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SKillBossAwardNotify()
/*    */   {
/* 34 */     this.award = new AwardBean();
/*    */   }
/*    */   
/*    */   public SKillBossAwardNotify(int _bossid_, AwardBean _award_) {
/* 38 */     this.bossid = _bossid_;
/* 39 */     this.award = _award_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.award._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.bossid);
/* 49 */     _os_.marshal(this.award);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.bossid = _os_.unmarshal_int();
/* 55 */     this.award.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SKillBossAwardNotify)) {
/* 65 */       SKillBossAwardNotify _o_ = (SKillBossAwardNotify)_o1_;
/* 66 */       if (this.bossid != _o_.bossid) return false;
/* 67 */       if (!this.award.equals(_o_.award)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.bossid;
/* 76 */     _h_ += this.award.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.bossid).append(",");
/* 84 */     _sb_.append(this.award).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SKillBossAwardNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */