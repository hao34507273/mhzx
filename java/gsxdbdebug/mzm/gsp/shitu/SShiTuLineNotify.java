/*    */ package mzm.gsp.shitu;
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
/*    */ public class SShiTuLineNotify
/*    */   extends __SShiTuLineNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601607;
/*    */   public int onlinestatus;
/*    */   public int profession;
/*    */   public String professionname;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601607;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SShiTuLineNotify()
/*    */   {
/* 33 */     this.professionname = "";
/*    */   }
/*    */   
/*    */   public SShiTuLineNotify(int _onlinestatus_, int _profession_, String _professionname_) {
/* 37 */     this.onlinestatus = _onlinestatus_;
/* 38 */     this.profession = _profession_;
/* 39 */     this.professionname = _professionname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.onlinestatus);
/* 48 */     _os_.marshal(this.profession);
/* 49 */     _os_.marshal(this.professionname, "UTF-16LE");
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.onlinestatus = _os_.unmarshal_int();
/* 55 */     this.profession = _os_.unmarshal_int();
/* 56 */     this.professionname = _os_.unmarshal_String("UTF-16LE");
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SShiTuLineNotify)) {
/* 66 */       SShiTuLineNotify _o_ = (SShiTuLineNotify)_o1_;
/* 67 */       if (this.onlinestatus != _o_.onlinestatus) return false;
/* 68 */       if (this.profession != _o_.profession) return false;
/* 69 */       if (!this.professionname.equals(_o_.professionname)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.onlinestatus;
/* 78 */     _h_ += this.profession;
/* 79 */     _h_ += this.professionname.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.onlinestatus).append(",");
/* 87 */     _sb_.append(this.profession).append(",");
/* 88 */     _sb_.append("T").append(this.professionname.length()).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SShiTuLineNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */