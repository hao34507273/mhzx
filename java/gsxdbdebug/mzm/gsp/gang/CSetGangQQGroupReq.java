/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PCSetGangQQGroupReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSetGangQQGroupReq
/*    */   extends __CSetGangQQGroupReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589949;
/*    */   public String groupopenid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     new PCSetGangQQGroupReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589949;
/*    */   }
/*    */   
/*    */ 
/*    */   public CSetGangQQGroupReq()
/*    */   {
/* 34 */     this.groupopenid = "";
/*    */   }
/*    */   
/*    */   public CSetGangQQGroupReq(String _groupopenid_) {
/* 38 */     this.groupopenid = _groupopenid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.groupopenid, "UTF-16LE");
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.groupopenid = _os_.unmarshal_String("UTF-16LE");
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CSetGangQQGroupReq)) {
/* 61 */       CSetGangQQGroupReq _o_ = (CSetGangQQGroupReq)_o1_;
/* 62 */       if (!this.groupopenid.equals(_o_.groupopenid)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.groupopenid.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append("T").append(this.groupopenid.length()).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CSetGangQQGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */