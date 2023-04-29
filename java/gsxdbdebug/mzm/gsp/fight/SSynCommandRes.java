/*    */ package mzm.gsp.fight;
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
/*    */ public class SSynCommandRes
/*    */   extends __SSynCommandRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594200;
/*    */   public String commandname;
/*    */   public int commandfighterid;
/*    */   public int becommandedfighterid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594200;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynCommandRes()
/*    */   {
/* 35 */     this.commandname = "";
/*    */   }
/*    */   
/*    */   public SSynCommandRes(String _commandname_, int _commandfighterid_, int _becommandedfighterid_) {
/* 39 */     this.commandname = _commandname_;
/* 40 */     this.commandfighterid = _commandfighterid_;
/* 41 */     this.becommandedfighterid = _becommandedfighterid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.commandname, "UTF-16LE");
/* 50 */     _os_.marshal(this.commandfighterid);
/* 51 */     _os_.marshal(this.becommandedfighterid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.commandname = _os_.unmarshal_String("UTF-16LE");
/* 57 */     this.commandfighterid = _os_.unmarshal_int();
/* 58 */     this.becommandedfighterid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SSynCommandRes)) {
/* 68 */       SSynCommandRes _o_ = (SSynCommandRes)_o1_;
/* 69 */       if (!this.commandname.equals(_o_.commandname)) return false;
/* 70 */       if (this.commandfighterid != _o_.commandfighterid) return false;
/* 71 */       if (this.becommandedfighterid != _o_.becommandedfighterid) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.commandname.hashCode();
/* 80 */     _h_ += this.commandfighterid;
/* 81 */     _h_ += this.becommandedfighterid;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("T").append(this.commandname.length()).append(",");
/* 89 */     _sb_.append(this.commandfighterid).append(",");
/* 90 */     _sb_.append(this.becommandedfighterid).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSynCommandRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */