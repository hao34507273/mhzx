/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PCreateGangReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCreateGangReq
/*    */   extends __CCreateGangReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589867;
/*    */   public String name;
/*    */   public String purpose;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     new PCreateGangReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589867;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCreateGangReq()
/*    */   {
/* 35 */     this.name = "";
/* 36 */     this.purpose = "";
/*    */   }
/*    */   
/*    */   public CCreateGangReq(String _name_, String _purpose_) {
/* 40 */     this.name = _name_;
/* 41 */     this.purpose = _purpose_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.name, "UTF-16LE");
/* 50 */     _os_.marshal(this.purpose, "UTF-16LE");
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 56 */     this.purpose = _os_.unmarshal_String("UTF-16LE");
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CCreateGangReq)) {
/* 66 */       CCreateGangReq _o_ = (CCreateGangReq)_o1_;
/* 67 */       if (!this.name.equals(_o_.name)) return false;
/* 68 */       if (!this.purpose.equals(_o_.purpose)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.name.hashCode();
/* 77 */     _h_ += this.purpose.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append("T").append(this.name.length()).append(",");
/* 85 */     _sb_.append("T").append(this.purpose.length()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CCreateGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */