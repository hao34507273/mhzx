/*    */ package mzm.gsp.huanhun;
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
/*    */ 
/*    */ public class SynGangHelpInfo
/*    */   extends __SynGangHelpInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584467;
/*    */   public GangHelpInfo ganghelpinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584467;
/*    */   }
/*    */   
/*    */ 
/*    */   public SynGangHelpInfo()
/*    */   {
/* 33 */     this.ganghelpinfo = new GangHelpInfo();
/*    */   }
/*    */   
/*    */   public SynGangHelpInfo(GangHelpInfo _ganghelpinfo_) {
/* 37 */     this.ganghelpinfo = _ganghelpinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.ganghelpinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.ganghelpinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.ganghelpinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SynGangHelpInfo)) {
/* 61 */       SynGangHelpInfo _o_ = (SynGangHelpInfo)_o1_;
/* 62 */       if (!this.ganghelpinfo.equals(_o_.ganghelpinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.ganghelpinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.ganghelpinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SynGangHelpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */