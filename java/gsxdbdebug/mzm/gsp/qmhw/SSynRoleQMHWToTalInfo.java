/*    */ package mzm.gsp.qmhw;
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
/*    */ public class SSynRoleQMHWToTalInfo
/*    */   extends __SSynRoleQMHWToTalInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601859;
/*    */   public QMHWInfo qmhwinfo;
/*    */   public QMHWAwardInfo awardinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601859;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynRoleQMHWToTalInfo()
/*    */   {
/* 34 */     this.qmhwinfo = new QMHWInfo();
/* 35 */     this.awardinfo = new QMHWAwardInfo();
/*    */   }
/*    */   
/*    */   public SSynRoleQMHWToTalInfo(QMHWInfo _qmhwinfo_, QMHWAwardInfo _awardinfo_) {
/* 39 */     this.qmhwinfo = _qmhwinfo_;
/* 40 */     this.awardinfo = _awardinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     if (!this.qmhwinfo._validator_()) return false;
/* 45 */     if (!this.awardinfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.qmhwinfo);
/* 51 */     _os_.marshal(this.awardinfo);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.qmhwinfo.unmarshal(_os_);
/* 57 */     this.awardinfo.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynRoleQMHWToTalInfo)) {
/* 67 */       SSynRoleQMHWToTalInfo _o_ = (SSynRoleQMHWToTalInfo)_o1_;
/* 68 */       if (!this.qmhwinfo.equals(_o_.qmhwinfo)) return false;
/* 69 */       if (!this.awardinfo.equals(_o_.awardinfo)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.qmhwinfo.hashCode();
/* 78 */     _h_ += this.awardinfo.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.qmhwinfo).append(",");
/* 86 */     _sb_.append(this.awardinfo).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\SSynRoleQMHWToTalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */