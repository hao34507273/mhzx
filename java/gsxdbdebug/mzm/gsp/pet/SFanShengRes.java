/*    */ package mzm.gsp.pet;
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
/*    */ public class SFanShengRes
/*    */   extends __SFanShengRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590598;
/*    */   public long oldpetid;
/*    */   public PetInfo newpetinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12590598;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFanShengRes()
/*    */   {
/* 32 */     this.newpetinfo = new PetInfo();
/*    */   }
/*    */   
/*    */   public SFanShengRes(long _oldpetid_, PetInfo _newpetinfo_) {
/* 36 */     this.oldpetid = _oldpetid_;
/* 37 */     this.newpetinfo = _newpetinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.newpetinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.oldpetid);
/* 47 */     _os_.marshal(this.newpetinfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.oldpetid = _os_.unmarshal_long();
/* 53 */     this.newpetinfo.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SFanShengRes)) {
/* 63 */       SFanShengRes _o_ = (SFanShengRes)_o1_;
/* 64 */       if (this.oldpetid != _o_.oldpetid) return false;
/* 65 */       if (!this.newpetinfo.equals(_o_.newpetinfo)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.oldpetid;
/* 74 */     _h_ += this.newpetinfo.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.oldpetid).append(",");
/* 82 */     _sb_.append(this.newpetinfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SFanShengRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */