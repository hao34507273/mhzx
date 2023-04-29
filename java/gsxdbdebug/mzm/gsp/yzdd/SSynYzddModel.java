/*    */ package mzm.gsp.yzdd;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SSynYzddModel extends __SSynYzddModel__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12634400;
/*    */   public String rolename;
/*    */   public int modelid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 15 */     return 12634400;
/*    */   }
/*    */   
/*    */   public SSynYzddModel() {
/* 19 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public SSynYzddModel(String _rolename_, int _modelid_) {
/* 23 */     this.rolename = _rolename_;
/* 24 */     this.modelid = _modelid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.modelid);
/* 33 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.modelid = _os_.unmarshal_int();
/* 39 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 40 */     if (_validator_()) {
/* 41 */       return _os_;
/*    */     }
/* 43 */     throw new VerifyError("validator failed");
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) {
/* 48 */       return true;
/*    */     }
/* 50 */     if (!(_o1_ instanceof SSynYzddModel)) {
/* 51 */       return false;
/*    */     }
/* 53 */     SSynYzddModel _o_ = (SSynYzddModel)_o1_;
/* 54 */     return (this.rolename.equals(_o_.rolename)) && (this.modelid == _o_.modelid);
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0 + this.rolename.hashCode();
/* 59 */     return _h_ + this.modelid;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 66 */     _sb_.append(this.modelid).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\SSynYzddModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */