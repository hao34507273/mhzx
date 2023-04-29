/*    */ package mzm.gsp.makeup;
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
/*    */ public class SSynMakeupInfo
/*    */   extends __SSynMakeupInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625926;
/*    */   public FactionMakeUpInfo factionmakeupinfo;
/*    */   public RoleMakeUpInfo rolemakeupinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625926;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynMakeupInfo()
/*    */   {
/* 34 */     this.factionmakeupinfo = new FactionMakeUpInfo();
/* 35 */     this.rolemakeupinfo = new RoleMakeUpInfo();
/*    */   }
/*    */   
/*    */   public SSynMakeupInfo(FactionMakeUpInfo _factionmakeupinfo_, RoleMakeUpInfo _rolemakeupinfo_) {
/* 39 */     this.factionmakeupinfo = _factionmakeupinfo_;
/* 40 */     this.rolemakeupinfo = _rolemakeupinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     if (!this.factionmakeupinfo._validator_()) return false;
/* 45 */     if (!this.rolemakeupinfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.factionmakeupinfo);
/* 51 */     _os_.marshal(this.rolemakeupinfo);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.factionmakeupinfo.unmarshal(_os_);
/* 57 */     this.rolemakeupinfo.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynMakeupInfo)) {
/* 67 */       SSynMakeupInfo _o_ = (SSynMakeupInfo)_o1_;
/* 68 */       if (!this.factionmakeupinfo.equals(_o_.factionmakeupinfo)) return false;
/* 69 */       if (!this.rolemakeupinfo.equals(_o_.rolemakeupinfo)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.factionmakeupinfo.hashCode();
/* 78 */     _h_ += this.rolemakeupinfo.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.factionmakeupinfo).append(",");
/* 86 */     _sb_.append(this.rolemakeupinfo).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\SSynMakeupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */