/*    */ package mzm.gsp.corps;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRenameCropsBro
/*    */   extends __SRenameCropsBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617492;
/*    */   public Octets name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617492;
/*    */   }
/*    */   
/*    */ 
/*    */   public SRenameCropsBro()
/*    */   {
/* 33 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public SRenameCropsBro(Octets _name_) {
/* 37 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.name);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.name = _os_.unmarshal_Octets();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof SRenameCropsBro)) {
/* 60 */       SRenameCropsBro _o_ = (SRenameCropsBro)_o1_;
/* 61 */       if (!this.name.equals(_o_.name)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.name.hashCode();
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append("B").append(this.name.size()).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SRenameCropsBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */