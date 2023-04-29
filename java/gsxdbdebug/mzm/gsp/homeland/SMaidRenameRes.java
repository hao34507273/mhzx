/*    */ package mzm.gsp.homeland;
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
/*    */ public class SMaidRenameRes
/*    */   extends __SMaidRenameRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605492;
/*    */   public long maiduuid;
/*    */   public Octets name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12605492;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMaidRenameRes()
/*    */   {
/* 32 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public SMaidRenameRes(long _maiduuid_, Octets _name_) {
/* 36 */     this.maiduuid = _maiduuid_;
/* 37 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.maiduuid);
/* 46 */     _os_.marshal(this.name);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.maiduuid = _os_.unmarshal_long();
/* 52 */     this.name = _os_.unmarshal_Octets();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SMaidRenameRes)) {
/* 62 */       SMaidRenameRes _o_ = (SMaidRenameRes)_o1_;
/* 63 */       if (this.maiduuid != _o_.maiduuid) return false;
/* 64 */       if (!this.name.equals(_o_.name)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.maiduuid;
/* 73 */     _h_ += this.name.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.maiduuid).append(",");
/* 81 */     _sb_.append("B").append(this.name.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SMaidRenameRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */